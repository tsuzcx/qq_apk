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
  private final Resources aKG;
  private long bEH;
  private AssetFileDescriptor bEJ;
  private InputStream inputStream;
  private String lqQ;
  private final s lrh;
  private long lri;
  private long lrj;
  private String mimeType;
  private boolean opened;
  private Uri uri;
  
  public o(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private o(Context paramContext, byte paramByte)
  {
    AppMethodBeat.i(211095);
    this.mimeType = null;
    this.lri = -1L;
    this.lrj = -1L;
    this.lqQ = "";
    this.aKG = paramContext.getResources();
    this.lrh = null;
    AppMethodBeat.o(211095);
  }
  
  public final void Ru(String paramString)
  {
    this.lqQ = paramString;
  }
  
  public final long a(g paramg)
  {
    long l1 = -1L;
    AppMethodBeat.i(211096);
    try
    {
      this.uri = paramg.uri;
      if (!TextUtils.equals("android.resource", this.uri.getScheme()))
      {
        paramg = new a("URI must use scheme android.resource");
        AppMethodBeat.o(211096);
        throw paramg;
      }
    }
    catch (IOException paramg)
    {
      paramg = new a(paramg);
      AppMethodBeat.o(211096);
      throw paramg;
    }
    try
    {
      int i = Integer.parseInt(this.uri.getLastPathSegment());
      this.bEJ = this.aKG.openRawResourceFd(i);
      this.lri = this.bEJ.getLength();
      this.lrj = (this.lri - paramg.position);
      this.inputStream = new FileInputStream(this.bEJ.getFileDescriptor());
      if (this.inputStream.markSupported()) {
        this.mimeType = URLConnection.guessContentTypeFromStream(this.inputStream);
      }
      this.inputStream.skip(this.bEJ.getStartOffset());
      if (this.inputStream.skip(paramg.position) < paramg.position)
      {
        paramg = new EOFException();
        AppMethodBeat.o(211096);
        throw paramg;
      }
    }
    catch (NumberFormatException paramg)
    {
      paramg = new a("Resource identifier must be an integer.");
      AppMethodBeat.o(211096);
      throw paramg;
    }
    if (paramg.length != -1L)
    {
      this.bEH = paramg.length;
      this.opened = true;
      if (this.lrh != null) {
        this.lrh.onTransferStart();
      }
      l1 = this.bEH;
      AppMethodBeat.o(211096);
      return l1;
    }
    long l2 = this.bEJ.getLength();
    if (l2 == -1L) {}
    for (;;)
    {
      this.bEH = l1;
      break;
      l1 = paramg.position;
      l1 = l2 - l1;
    }
  }
  
  public final long available()
  {
    return this.lrj;
  }
  
  public final long bbj()
  {
    return this.lri;
  }
  
  public final c bom()
  {
    AppMethodBeat.i(211100);
    if (TextUtils.isEmpty(this.mimeType))
    {
      localc = c.lrP;
      AppMethodBeat.o(211100);
      return localc;
    }
    c localc = c.Rx(this.mimeType);
    AppMethodBeat.o(211100);
    return localc;
  }
  
  public final void close()
  {
    AppMethodBeat.i(211097);
    this.uri = null;
    try
    {
      if (this.inputStream != null) {
        this.inputStream.close();
      }
      this.inputStream = null;
      try
      {
        if (this.bEJ != null) {
          this.bEJ.close();
        }
        return;
      }
      catch (IOException localIOException1)
      {
        a locala1 = new a(localIOException1);
        AppMethodBeat.o(211097);
        throw locala1;
      }
      finally
      {
        this.bEJ = null;
        if (this.opened)
        {
          this.opened = false;
          if (this.lrh != null) {
            this.lrh.onTransferEnd();
          }
        }
        AppMethodBeat.o(211097);
      }
      AppMethodBeat.o(211097);
      return;
    }
    catch (IOException localIOException2)
    {
      a locala2 = new a(localIOException2);
      AppMethodBeat.o(211097);
      throw locala2;
    }
    finally
    {
      this.inputStream = null;
      try
      {
        if (this.bEJ != null) {
          this.bEJ.close();
        }
        throw localObject2;
      }
      catch (IOException localIOException3)
      {
        a locala3 = new a(localIOException3);
        AppMethodBeat.o(211097);
        throw locala3;
      }
      finally
      {
        this.bEJ = null;
        if (this.opened)
        {
          this.opened = false;
          if (this.lrh != null) {
            this.lrh.onTransferEnd();
          }
        }
        AppMethodBeat.o(211097);
      }
    }
  }
  
  public final String getUri()
  {
    AppMethodBeat.i(211099);
    if (this.uri != null)
    {
      String str = this.uri.toString();
      AppMethodBeat.o(211099);
      return str;
    }
    AppMethodBeat.o(211099);
    return null;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(211098);
    if (paramInt2 == 0)
    {
      AppMethodBeat.o(211098);
      return 0;
    }
    if (this.bEH == 0L)
    {
      AppMethodBeat.o(211098);
      return -1;
    }
    try
    {
      if (this.bEH == -1L) {}
      for (;;)
      {
        paramInt1 = this.inputStream.read(paramArrayOfByte, paramInt1, paramInt2);
        if (paramInt1 != -1) {
          break label134;
        }
        if (this.bEH == -1L) {
          break;
        }
        paramArrayOfByte = new a(new EOFException());
        AppMethodBeat.o(211098);
        throw paramArrayOfByte;
        long l = Math.min(this.bEH, paramInt2);
        paramInt2 = (int)l;
      }
      AppMethodBeat.o(211098);
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte = new a(paramArrayOfByte);
      AppMethodBeat.o(211098);
      throw paramArrayOfByte;
    }
    return -1;
    label134:
    if (this.bEH != -1L) {
      this.bEH -= paramInt1;
    }
    if (this.lrh != null) {
      this.lrh.tz(paramInt1);
    }
    AppMethodBeat.o(211098);
    return paramInt1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.b.o
 * JD-Core Version:    0.7.0.1
 */