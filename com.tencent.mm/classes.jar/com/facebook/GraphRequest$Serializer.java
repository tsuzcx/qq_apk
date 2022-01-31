package com.facebook;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

class GraphRequest$Serializer
  implements GraphRequest.KeyValueSerializer
{
  private boolean firstWrite = true;
  private final Logger logger;
  private final OutputStream outputStream;
  private boolean useUrlEncode = false;
  
  public GraphRequest$Serializer(OutputStream paramOutputStream, Logger paramLogger, boolean paramBoolean)
  {
    this.outputStream = paramOutputStream;
    this.logger = paramLogger;
    this.useUrlEncode = paramBoolean;
  }
  
  private RuntimeException getInvalidTypeError()
  {
    AppMethodBeat.i(71653);
    IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("value is not a supported type.");
    AppMethodBeat.o(71653);
    return localIllegalArgumentException;
  }
  
  public void write(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(71662);
    if (!this.useUrlEncode)
    {
      if (this.firstWrite)
      {
        this.outputStream.write("--".getBytes());
        this.outputStream.write(GraphRequest.access$200().getBytes());
        this.outputStream.write("\r\n".getBytes());
        this.firstWrite = false;
      }
      this.outputStream.write(String.format(paramString, paramVarArgs).getBytes());
      AppMethodBeat.o(71662);
      return;
    }
    this.outputStream.write(URLEncoder.encode(String.format(Locale.US, paramString, paramVarArgs), "UTF-8").getBytes());
    AppMethodBeat.o(71662);
  }
  
  public void writeBitmap(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(71656);
    writeContentDisposition(paramString, paramString, "image/png");
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, this.outputStream);
    writeLine("", new Object[0]);
    writeRecordBoundary();
    if (this.logger != null) {
      this.logger.appendKeyValue("    ".concat(String.valueOf(paramString)), "<Image>");
    }
    AppMethodBeat.o(71656);
  }
  
  public void writeBytes(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(71657);
    writeContentDisposition(paramString, paramString, "content/unknown");
    this.outputStream.write(paramArrayOfByte);
    writeLine("", new Object[0]);
    writeRecordBoundary();
    if (this.logger != null) {
      this.logger.appendKeyValue("    ".concat(String.valueOf(paramString)), String.format(Locale.ROOT, "<Data: %d>", new Object[] { Integer.valueOf(paramArrayOfByte.length) }));
    }
    AppMethodBeat.o(71657);
  }
  
  public void writeContentDisposition(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(71661);
    if (!this.useUrlEncode)
    {
      write("Content-Disposition: form-data; name=\"%s\"", new Object[] { paramString1 });
      if (paramString2 != null) {
        write("; filename=\"%s\"", new Object[] { paramString2 });
      }
      writeLine("", new Object[0]);
      if (paramString3 != null) {
        writeLine("%s: %s", new Object[] { "Content-Type", paramString3 });
      }
      writeLine("", new Object[0]);
      AppMethodBeat.o(71661);
      return;
    }
    this.outputStream.write(String.format("%s=", new Object[] { paramString1 }).getBytes());
    AppMethodBeat.o(71661);
  }
  
  public void writeContentUri(String paramString1, Uri paramUri, String paramString2)
  {
    AppMethodBeat.i(71658);
    String str = paramString2;
    if (paramString2 == null) {
      str = "content/unknown";
    }
    writeContentDisposition(paramString1, paramString1, str);
    if ((this.outputStream instanceof ProgressNoopOutputStream))
    {
      long l = Utility.getContentSize(paramUri);
      ((ProgressNoopOutputStream)this.outputStream).addProgress(l);
    }
    for (int i = 0;; i = Utility.copyAndCloseInputStream(FacebookSdk.getApplicationContext().getContentResolver().openInputStream(paramUri), this.outputStream) + 0)
    {
      writeLine("", new Object[0]);
      writeRecordBoundary();
      if (this.logger != null) {
        this.logger.appendKeyValue("    ".concat(String.valueOf(paramString1)), String.format(Locale.ROOT, "<Data: %d>", new Object[] { Integer.valueOf(i) }));
      }
      AppMethodBeat.o(71658);
      return;
    }
  }
  
  public void writeFile(String paramString1, ParcelFileDescriptor paramParcelFileDescriptor, String paramString2)
  {
    AppMethodBeat.i(71659);
    String str = paramString2;
    if (paramString2 == null) {
      str = "content/unknown";
    }
    writeContentDisposition(paramString1, paramString1, str);
    if ((this.outputStream instanceof ProgressNoopOutputStream)) {
      ((ProgressNoopOutputStream)this.outputStream).addProgress(paramParcelFileDescriptor.getStatSize());
    }
    for (int i = 0;; i = Utility.copyAndCloseInputStream(new ParcelFileDescriptor.AutoCloseInputStream(paramParcelFileDescriptor), this.outputStream) + 0)
    {
      writeLine("", new Object[0]);
      writeRecordBoundary();
      if (this.logger != null) {
        this.logger.appendKeyValue("    ".concat(String.valueOf(paramString1)), String.format(Locale.ROOT, "<Data: %d>", new Object[] { Integer.valueOf(i) }));
      }
      AppMethodBeat.o(71659);
      return;
    }
  }
  
  public void writeLine(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(71663);
    write(paramString, paramVarArgs);
    if (!this.useUrlEncode) {
      write("\r\n", new Object[0]);
    }
    AppMethodBeat.o(71663);
  }
  
  public void writeObject(String paramString, Object paramObject, GraphRequest paramGraphRequest)
  {
    AppMethodBeat.i(71652);
    if ((this.outputStream instanceof RequestOutputStream)) {
      ((RequestOutputStream)this.outputStream).setCurrentRequest(paramGraphRequest);
    }
    if (GraphRequest.access$000(paramObject))
    {
      writeString(paramString, GraphRequest.access$100(paramObject));
      AppMethodBeat.o(71652);
      return;
    }
    if ((paramObject instanceof Bitmap))
    {
      writeBitmap(paramString, (Bitmap)paramObject);
      AppMethodBeat.o(71652);
      return;
    }
    if ((paramObject instanceof byte[]))
    {
      writeBytes(paramString, (byte[])paramObject);
      AppMethodBeat.o(71652);
      return;
    }
    if ((paramObject instanceof Uri))
    {
      writeContentUri(paramString, (Uri)paramObject, null);
      AppMethodBeat.o(71652);
      return;
    }
    if ((paramObject instanceof ParcelFileDescriptor))
    {
      writeFile(paramString, (ParcelFileDescriptor)paramObject, null);
      AppMethodBeat.o(71652);
      return;
    }
    if ((paramObject instanceof GraphRequest.ParcelableResourceWithMimeType))
    {
      paramGraphRequest = (GraphRequest.ParcelableResourceWithMimeType)paramObject;
      paramObject = paramGraphRequest.getResource();
      paramGraphRequest = paramGraphRequest.getMimeType();
      if ((paramObject instanceof ParcelFileDescriptor))
      {
        writeFile(paramString, (ParcelFileDescriptor)paramObject, paramGraphRequest);
        AppMethodBeat.o(71652);
        return;
      }
      if ((paramObject instanceof Uri))
      {
        writeContentUri(paramString, (Uri)paramObject, paramGraphRequest);
        AppMethodBeat.o(71652);
        return;
      }
      paramString = getInvalidTypeError();
      AppMethodBeat.o(71652);
      throw paramString;
    }
    paramString = getInvalidTypeError();
    AppMethodBeat.o(71652);
    throw paramString;
  }
  
  public void writeRecordBoundary()
  {
    AppMethodBeat.i(71660);
    if (!this.useUrlEncode)
    {
      writeLine("--%s", new Object[] { GraphRequest.access$200() });
      AppMethodBeat.o(71660);
      return;
    }
    this.outputStream.write("&".getBytes());
    AppMethodBeat.o(71660);
  }
  
  public void writeRequestsAsJson(String paramString, JSONArray paramJSONArray, Collection<GraphRequest> paramCollection)
  {
    AppMethodBeat.i(71654);
    if (!(this.outputStream instanceof RequestOutputStream))
    {
      writeString(paramString, paramJSONArray.toString());
      AppMethodBeat.o(71654);
      return;
    }
    RequestOutputStream localRequestOutputStream = (RequestOutputStream)this.outputStream;
    writeContentDisposition(paramString, null, null);
    write("[", new Object[0]);
    paramCollection = paramCollection.iterator();
    int i = 0;
    if (paramCollection.hasNext())
    {
      GraphRequest localGraphRequest = (GraphRequest)paramCollection.next();
      JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
      localRequestOutputStream.setCurrentRequest(localGraphRequest);
      if (i > 0) {
        write(",%s", new Object[] { localJSONObject.toString() });
      }
      for (;;)
      {
        i += 1;
        break;
        write("%s", new Object[] { localJSONObject.toString() });
      }
    }
    write("]", new Object[0]);
    if (this.logger != null) {
      this.logger.appendKeyValue("    ".concat(String.valueOf(paramString)), paramJSONArray.toString());
    }
    AppMethodBeat.o(71654);
  }
  
  public void writeString(String paramString1, String paramString2)
  {
    AppMethodBeat.i(71655);
    writeContentDisposition(paramString1, null, null);
    writeLine("%s", new Object[] { paramString2 });
    writeRecordBoundary();
    if (this.logger != null) {
      this.logger.appendKeyValue("    ".concat(String.valueOf(paramString1)), paramString2);
    }
    AppMethodBeat.o(71655);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.facebook.GraphRequest.Serializer
 * JD-Core Version:    0.7.0.1
 */