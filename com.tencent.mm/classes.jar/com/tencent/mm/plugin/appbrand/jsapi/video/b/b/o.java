package com.tencent.mm.plugin.appbrand.jsapi.video.b.b;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;

public final class o
  implements t
{
  private final Resources aKy;
  private long bEJ;
  private AssetFileDescriptor bEL;
  private InputStream inputStream;
  private String mimeType;
  private final s mxN;
  private long mxO;
  private long mxP;
  private String mxw;
  private boolean opened;
  private Uri uri;
  
  public o(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private o(Context paramContext, byte paramByte)
  {
    AppMethodBeat.i(234764);
    this.mimeType = null;
    this.mxO = -1L;
    this.mxP = -1L;
    this.mxw = "";
    this.aKy = paramContext.getResources();
    this.mxN = null;
    AppMethodBeat.o(234764);
  }
  
  public final long a(g paramg)
  {
    long l1 = -1L;
    AppMethodBeat.i(234765);
    try
    {
      this.uri = paramg.uri;
      if (!TextUtils.equals("android.resource", this.uri.getScheme()))
      {
        paramg = new a("URI must use scheme android.resource");
        AppMethodBeat.o(234765);
        throw paramg;
      }
    }
    catch (IOException paramg)
    {
      paramg = new a(paramg);
      AppMethodBeat.o(234765);
      throw paramg;
    }
    try
    {
      int i = Integer.parseInt(this.uri.getLastPathSegment());
      this.bEL = this.aKy.openRawResourceFd(i);
      this.mxO = this.bEL.getLength();
      this.mxP = (this.mxO - paramg.position);
      this.inputStream = new FileInputStream(this.bEL.getFileDescriptor());
      if (this.inputStream.markSupported()) {
        this.mimeType = URLConnection.guessContentTypeFromStream(this.inputStream);
      }
      this.inputStream.skip(this.bEL.getStartOffset());
      if (this.inputStream.skip(paramg.position) < paramg.position)
      {
        paramg = new EOFException();
        AppMethodBeat.o(234765);
        throw paramg;
      }
    }
    catch (NumberFormatException paramg)
    {
      paramg = new a("Resource identifier must be an integer.");
      AppMethodBeat.o(234765);
      throw paramg;
    }
    if (paramg.length != -1L)
    {
      this.bEJ = paramg.length;
      this.opened = true;
      if (this.mxN != null) {
        this.mxN.onTransferStart();
      }
      l1 = this.bEJ;
      AppMethodBeat.o(234765);
      return l1;
    }
    long l2 = this.bEL.getLength();
    if (l2 == -1L) {}
    for (;;)
    {
      this.bEJ = l1;
      break;
      l1 = paramg.position;
      l1 = l2 - l1;
    }
  }
  
  public final long available()
  {
    return this.mxP;
  }
  
  public final c bJP()
  {
    AppMethodBeat.i(234769);
    if (TextUtils.isEmpty(this.mimeType))
    {
      localc = c.myv;
      AppMethodBeat.o(234769);
      return localc;
    }
    c localc = c.abd(this.mimeType);
    AppMethodBeat.o(234769);
    return localc;
  }
  
  public final void close()
  {
    AppMethodBeat.i(234766);
    this.uri = null;
    try
    {
      if (this.inputStream != null) {
        this.inputStream.close();
      }
      this.inputStream = null;
      try
      {
        if (this.bEL != null) {
          this.bEL.close();
        }
        return;
      }
      catch (IOException localIOException1)
      {
        a locala1 = new a(localIOException1);
        AppMethodBeat.o(234766);
        throw locala1;
      }
      finally
      {
        this.bEL = null;
        if (this.opened)
        {
          this.opened = false;
          if (this.mxN != null) {
            this.mxN.onTransferEnd();
          }
        }
        AppMethodBeat.o(234766);
      }
      AppMethodBeat.o(234766);
      return;
    }
    catch (IOException localIOException2)
    {
      a locala2 = new a(localIOException2);
      AppMethodBeat.o(234766);
      throw locala2;
    }
    finally
    {
      this.inputStream = null;
      try
      {
        if (this.bEL != null) {
          this.bEL.close();
        }
        throw localObject2;
      }
      catch (IOException localIOException3)
      {
        a locala3 = new a(localIOException3);
        AppMethodBeat.o(234766);
        throw locala3;
      }
      finally
      {
        this.bEL = null;
        if (this.opened)
        {
          this.opened = false;
          if (this.mxN != null) {
            this.mxN.onTransferEnd();
          }
        }
        AppMethodBeat.o(234766);
      }
    }
  }
  
  public final long getTotalLength()
  {
    return this.mxO;
  }
  
  public final String getUri()
  {
    AppMethodBeat.i(234768);
    if (this.uri != null)
    {
      String str = this.uri.toString();
      AppMethodBeat.o(234768);
      return str;
    }
    AppMethodBeat.o(234768);
    return null;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(234767);
    if (paramInt2 == 0)
    {
      AppMethodBeat.o(234767);
      return 0;
    }
    if (this.bEJ == 0L)
    {
      AppMethodBeat.o(234767);
      return -1;
    }
    try
    {
      if (this.bEJ == -1L) {}
      for (;;)
      {
        paramInt1 = this.inputStream.read(paramArrayOfByte, paramInt1, paramInt2);
        if (paramInt1 != -1) {
          break label134;
        }
        if (this.bEJ == -1L) {
          break;
        }
        paramArrayOfByte = new a(new EOFException());
        AppMethodBeat.o(234767);
        throw paramArrayOfByte;
        long l = Math.min(this.bEJ, paramInt2);
        paramInt2 = (int)l;
      }
      AppMethodBeat.o(234767);
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte = new a(paramArrayOfByte);
      AppMethodBeat.o(234767);
      throw paramArrayOfByte;
    }
    return -1;
    label134:
    if (this.bEJ != -1L) {
      this.bEJ -= paramInt1;
    }
    if (this.mxN != null) {
      this.mxN.xx(paramInt1);
    }
    AppMethodBeat.o(234767);
    return paramInt1;
  }
  
  public final void setLogTag(String paramString)
  {
    this.mxw = paramString;
  }
  
  public static final class a
    extends IOException
  {
    public a(IOException paramIOException)
    {
      super();
    }
    
    public a(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.b.o
 * JD-Core Version:    0.7.0.1
 */