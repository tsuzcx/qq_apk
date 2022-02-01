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
  private final Resources aHZ;
  private long bwt;
  private AssetFileDescriptor bwv;
  private InputStream inputStream;
  private final s koO;
  private long koP;
  private long koQ;
  private String kox;
  private String mimeType;
  private boolean opened;
  private Uri uri;
  
  public o(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private o(Context paramContext, byte paramByte)
  {
    AppMethodBeat.i(193909);
    this.mimeType = null;
    this.koP = -1L;
    this.koQ = -1L;
    this.kox = "";
    this.aHZ = paramContext.getResources();
    this.koO = null;
    AppMethodBeat.o(193909);
  }
  
  public final void Jk(String paramString)
  {
    this.kox = paramString;
  }
  
  public final long a(g paramg)
  {
    long l1 = -1L;
    AppMethodBeat.i(193910);
    try
    {
      this.uri = paramg.uri;
      if (!TextUtils.equals("android.resource", this.uri.getScheme()))
      {
        paramg = new a("URI must use scheme android.resource");
        AppMethodBeat.o(193910);
        throw paramg;
      }
    }
    catch (IOException paramg)
    {
      paramg = new a(paramg);
      AppMethodBeat.o(193910);
      throw paramg;
    }
    try
    {
      int i = Integer.parseInt(this.uri.getLastPathSegment());
      this.bwv = this.aHZ.openRawResourceFd(i);
      this.koP = this.bwv.getLength();
      this.koQ = (this.koP - paramg.position);
      this.inputStream = new FileInputStream(this.bwv.getFileDescriptor());
      if (this.inputStream.markSupported()) {
        this.mimeType = URLConnection.guessContentTypeFromStream(this.inputStream);
      }
      this.inputStream.skip(this.bwv.getStartOffset());
      if (this.inputStream.skip(paramg.position) < paramg.position)
      {
        paramg = new EOFException();
        AppMethodBeat.o(193910);
        throw paramg;
      }
    }
    catch (NumberFormatException paramg)
    {
      paramg = new a("Resource identifier must be an integer.");
      AppMethodBeat.o(193910);
      throw paramg;
    }
    if (paramg.length != -1L)
    {
      this.bwt = paramg.length;
      this.opened = true;
      if (this.koO != null) {
        this.koO.onTransferStart();
      }
      l1 = this.bwt;
      AppMethodBeat.o(193910);
      return l1;
    }
    long l2 = this.bwv.getLength();
    if (l2 == -1L) {}
    for (;;)
    {
      this.bwt = l1;
      break;
      l1 = paramg.position;
      l1 = l2 - l1;
    }
  }
  
  public final long aQu()
  {
    return this.koP;
  }
  
  public final long available()
  {
    return this.koQ;
  }
  
  public final c bcW()
  {
    AppMethodBeat.i(193914);
    if (TextUtils.isEmpty(this.mimeType))
    {
      localc = c.kpw;
      AppMethodBeat.o(193914);
      return localc;
    }
    c localc = c.Jn(this.mimeType);
    AppMethodBeat.o(193914);
    return localc;
  }
  
  public final void close()
  {
    AppMethodBeat.i(193911);
    this.uri = null;
    try
    {
      if (this.inputStream != null) {
        this.inputStream.close();
      }
      this.inputStream = null;
      try
      {
        if (this.bwv != null) {
          this.bwv.close();
        }
        return;
      }
      catch (IOException localIOException1)
      {
        a locala1 = new a(localIOException1);
        AppMethodBeat.o(193911);
        throw locala1;
      }
      finally
      {
        this.bwv = null;
        if (this.opened)
        {
          this.opened = false;
          if (this.koO != null) {
            this.koO.onTransferEnd();
          }
        }
        AppMethodBeat.o(193911);
      }
      AppMethodBeat.o(193911);
      return;
    }
    catch (IOException localIOException2)
    {
      a locala2 = new a(localIOException2);
      AppMethodBeat.o(193911);
      throw locala2;
    }
    finally
    {
      this.inputStream = null;
      try
      {
        if (this.bwv != null) {
          this.bwv.close();
        }
        throw localObject2;
      }
      catch (IOException localIOException3)
      {
        a locala3 = new a(localIOException3);
        AppMethodBeat.o(193911);
        throw locala3;
      }
      finally
      {
        this.bwv = null;
        if (this.opened)
        {
          this.opened = false;
          if (this.koO != null) {
            this.koO.onTransferEnd();
          }
        }
        AppMethodBeat.o(193911);
      }
    }
  }
  
  public final String getUri()
  {
    AppMethodBeat.i(193913);
    if (this.uri != null)
    {
      String str = this.uri.toString();
      AppMethodBeat.o(193913);
      return str;
    }
    AppMethodBeat.o(193913);
    return null;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(193912);
    if (paramInt2 == 0)
    {
      AppMethodBeat.o(193912);
      return 0;
    }
    if (this.bwt == 0L)
    {
      AppMethodBeat.o(193912);
      return -1;
    }
    try
    {
      if (this.bwt == -1L) {}
      for (;;)
      {
        paramInt1 = this.inputStream.read(paramArrayOfByte, paramInt1, paramInt2);
        if (paramInt1 != -1) {
          break label134;
        }
        if (this.bwt == -1L) {
          break;
        }
        paramArrayOfByte = new a(new EOFException());
        AppMethodBeat.o(193912);
        throw paramArrayOfByte;
        long l = Math.min(this.bwt, paramInt2);
        paramInt2 = (int)l;
      }
      AppMethodBeat.o(193912);
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte = new a(paramArrayOfByte);
      AppMethodBeat.o(193912);
      throw paramArrayOfByte;
    }
    return -1;
    label134:
    if (this.bwt != -1L) {
      this.bwt -= paramInt1;
    }
    if (this.koO != null) {
      this.koO.sc(paramInt1);
    }
    AppMethodBeat.o(193912);
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