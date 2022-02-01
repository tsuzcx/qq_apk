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
  private InputStream aFw;
  private long bom;
  private AssetFileDescriptor boo;
  private final Resources lRm;
  private String mimeType;
  private boolean opened;
  private String pvQ;
  private final s pwh;
  private long pwi;
  private long pwj;
  private Uri uri;
  
  public o(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private o(Context paramContext, byte paramByte)
  {
    AppMethodBeat.i(227217);
    this.mimeType = null;
    this.pwi = -1L;
    this.pwj = -1L;
    this.pvQ = "";
    this.lRm = paramContext.getResources();
    this.pwh = null;
    AppMethodBeat.o(227217);
  }
  
  public final long a(g paramg)
  {
    long l1 = -1L;
    AppMethodBeat.i(227228);
    try
    {
      this.uri = paramg.uri;
      if (!TextUtils.equals("android.resource", this.uri.getScheme()))
      {
        paramg = new a("URI must use scheme android.resource");
        AppMethodBeat.o(227228);
        throw paramg;
      }
    }
    catch (IOException paramg)
    {
      paramg = new a(paramg);
      AppMethodBeat.o(227228);
      throw paramg;
    }
    try
    {
      int i = Integer.parseInt(this.uri.getLastPathSegment());
      this.boo = this.lRm.openRawResourceFd(i);
      this.pwi = this.boo.getLength();
      this.pwj = (this.pwi - paramg.position);
      this.aFw = new FileInputStream(this.boo.getFileDescriptor());
      if (this.aFw.markSupported()) {
        this.mimeType = URLConnection.guessContentTypeFromStream(this.aFw);
      }
      this.aFw.skip(this.boo.getStartOffset());
      if (this.aFw.skip(paramg.position) < paramg.position)
      {
        paramg = new EOFException();
        AppMethodBeat.o(227228);
        throw paramg;
      }
    }
    catch (NumberFormatException paramg)
    {
      paramg = new a("Resource identifier must be an integer.");
      AppMethodBeat.o(227228);
      throw paramg;
    }
    if (paramg.aFL != -1L)
    {
      this.bom = paramg.aFL;
      this.opened = true;
      if (this.pwh != null) {
        this.pwh.onTransferStart();
      }
      l1 = this.bom;
      AppMethodBeat.o(227228);
      return l1;
    }
    long l2 = this.boo.getLength();
    if (l2 == -1L) {}
    for (;;)
    {
      this.bom = l1;
      break;
      l1 = paramg.position;
      l1 = l2 - l1;
    }
  }
  
  public final long available()
  {
    return this.pwj;
  }
  
  public final c bVy()
  {
    AppMethodBeat.i(227254);
    if (TextUtils.isEmpty(this.mimeType))
    {
      localc = c.pwP;
      AppMethodBeat.o(227254);
      return localc;
    }
    c localc = c.aiX(this.mimeType);
    AppMethodBeat.o(227254);
    return localc;
  }
  
  public final void close()
  {
    AppMethodBeat.i(227241);
    this.uri = null;
    try
    {
      if (this.aFw != null) {
        this.aFw.close();
      }
      this.aFw = null;
      try
      {
        if (this.boo != null) {
          this.boo.close();
        }
        return;
      }
      catch (IOException localIOException1)
      {
        a locala1 = new a(localIOException1);
        AppMethodBeat.o(227241);
        throw locala1;
      }
      finally
      {
        this.boo = null;
        if (this.opened)
        {
          this.opened = false;
          if (this.pwh != null) {
            this.pwh.onTransferEnd();
          }
        }
        AppMethodBeat.o(227241);
      }
      AppMethodBeat.o(227241);
      return;
    }
    catch (IOException localIOException2)
    {
      a locala2 = new a(localIOException2);
      AppMethodBeat.o(227241);
      throw locala2;
    }
    finally
    {
      this.aFw = null;
      try
      {
        if (this.boo != null) {
          this.boo.close();
        }
        throw localObject2;
      }
      catch (IOException localIOException3)
      {
        a locala3 = new a(localIOException3);
        AppMethodBeat.o(227241);
        throw locala3;
      }
      finally
      {
        this.boo = null;
        if (this.opened)
        {
          this.opened = false;
          if (this.pwh != null) {
            this.pwh.onTransferEnd();
          }
        }
        AppMethodBeat.o(227241);
      }
    }
  }
  
  public final long getTotalLength()
  {
    return this.pwi;
  }
  
  public final String getUri()
  {
    AppMethodBeat.i(227253);
    if (this.uri != null)
    {
      String str = this.uri.toString();
      AppMethodBeat.o(227253);
      return str;
    }
    AppMethodBeat.o(227253);
    return null;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(227251);
    if (paramInt2 == 0)
    {
      AppMethodBeat.o(227251);
      return 0;
    }
    if (this.bom == 0L)
    {
      AppMethodBeat.o(227251);
      return -1;
    }
    try
    {
      if (this.bom == -1L) {}
      for (;;)
      {
        paramInt1 = this.aFw.read(paramArrayOfByte, paramInt1, paramInt2);
        if (paramInt1 != -1) {
          break label134;
        }
        if (this.bom == -1L) {
          break;
        }
        paramArrayOfByte = new a(new EOFException());
        AppMethodBeat.o(227251);
        throw paramArrayOfByte;
        long l = Math.min(this.bom, paramInt2);
        paramInt2 = (int)l;
      }
      AppMethodBeat.o(227251);
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte = new a(paramArrayOfByte);
      AppMethodBeat.o(227251);
      throw paramArrayOfByte;
    }
    return -1;
    label134:
    if (this.bom != -1L) {
      this.bom -= paramInt1;
    }
    if (this.pwh != null) {
      this.pwh.AU(paramInt1);
    }
    AppMethodBeat.o(227251);
    return paramInt1;
  }
  
  public final void setLogTag(String paramString)
  {
    this.pvQ = paramString;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.b.o
 * JD-Core Version:    0.7.0.1
 */