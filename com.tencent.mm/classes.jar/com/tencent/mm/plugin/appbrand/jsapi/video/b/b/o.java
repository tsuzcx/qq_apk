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
  private final Resources aIP;
  private long bus;
  private AssetFileDescriptor buu;
  private InputStream inputStream;
  private String kPQ;
  private final s kQh;
  private long kQi;
  private long kQj;
  private String mimeType;
  private boolean opened;
  private Uri uri;
  
  public o(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private o(Context paramContext, byte paramByte)
  {
    AppMethodBeat.i(194256);
    this.mimeType = null;
    this.kQi = -1L;
    this.kQj = -1L;
    this.kPQ = "";
    this.aIP = paramContext.getResources();
    this.kQh = null;
    AppMethodBeat.o(194256);
  }
  
  public final void No(String paramString)
  {
    this.kPQ = paramString;
  }
  
  public final long a(g paramg)
  {
    long l1 = -1L;
    AppMethodBeat.i(194257);
    try
    {
      this.uri = paramg.uri;
      if (!TextUtils.equals("android.resource", this.uri.getScheme()))
      {
        paramg = new a("URI must use scheme android.resource");
        AppMethodBeat.o(194257);
        throw paramg;
      }
    }
    catch (IOException paramg)
    {
      paramg = new a(paramg);
      AppMethodBeat.o(194257);
      throw paramg;
    }
    try
    {
      int i = Integer.parseInt(this.uri.getLastPathSegment());
      this.buu = this.aIP.openRawResourceFd(i);
      this.kQi = this.buu.getLength();
      this.kQj = (this.kQi - paramg.position);
      this.inputStream = new FileInputStream(this.buu.getFileDescriptor());
      if (this.inputStream.markSupported()) {
        this.mimeType = URLConnection.guessContentTypeFromStream(this.inputStream);
      }
      this.inputStream.skip(this.buu.getStartOffset());
      if (this.inputStream.skip(paramg.position) < paramg.position)
      {
        paramg = new EOFException();
        AppMethodBeat.o(194257);
        throw paramg;
      }
    }
    catch (NumberFormatException paramg)
    {
      paramg = new a("Resource identifier must be an integer.");
      AppMethodBeat.o(194257);
      throw paramg;
    }
    if (paramg.length != -1L)
    {
      this.bus = paramg.length;
      this.opened = true;
      if (this.kQh != null) {
        this.kQh.onTransferStart();
      }
      l1 = this.bus;
      AppMethodBeat.o(194257);
      return l1;
    }
    long l2 = this.buu.getLength();
    if (l2 == -1L) {}
    for (;;)
    {
      this.bus = l1;
      break;
      l1 = paramg.position;
      l1 = l2 - l1;
    }
  }
  
  public final long aXm()
  {
    return this.kQi;
  }
  
  public final long available()
  {
    return this.kQj;
  }
  
  public final c bjR()
  {
    AppMethodBeat.i(194261);
    if (TextUtils.isEmpty(this.mimeType))
    {
      localc = c.kQP;
      AppMethodBeat.o(194261);
      return localc;
    }
    c localc = c.Nr(this.mimeType);
    AppMethodBeat.o(194261);
    return localc;
  }
  
  public final void close()
  {
    AppMethodBeat.i(194258);
    this.uri = null;
    try
    {
      if (this.inputStream != null) {
        this.inputStream.close();
      }
      this.inputStream = null;
      try
      {
        if (this.buu != null) {
          this.buu.close();
        }
        return;
      }
      catch (IOException localIOException1)
      {
        a locala1 = new a(localIOException1);
        AppMethodBeat.o(194258);
        throw locala1;
      }
      finally
      {
        this.buu = null;
        if (this.opened)
        {
          this.opened = false;
          if (this.kQh != null) {
            this.kQh.onTransferEnd();
          }
        }
        AppMethodBeat.o(194258);
      }
      AppMethodBeat.o(194258);
      return;
    }
    catch (IOException localIOException2)
    {
      a locala2 = new a(localIOException2);
      AppMethodBeat.o(194258);
      throw locala2;
    }
    finally
    {
      this.inputStream = null;
      try
      {
        if (this.buu != null) {
          this.buu.close();
        }
        throw localObject2;
      }
      catch (IOException localIOException3)
      {
        a locala3 = new a(localIOException3);
        AppMethodBeat.o(194258);
        throw locala3;
      }
      finally
      {
        this.buu = null;
        if (this.opened)
        {
          this.opened = false;
          if (this.kQh != null) {
            this.kQh.onTransferEnd();
          }
        }
        AppMethodBeat.o(194258);
      }
    }
  }
  
  public final String getUri()
  {
    AppMethodBeat.i(194260);
    if (this.uri != null)
    {
      String str = this.uri.toString();
      AppMethodBeat.o(194260);
      return str;
    }
    AppMethodBeat.o(194260);
    return null;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194259);
    if (paramInt2 == 0)
    {
      AppMethodBeat.o(194259);
      return 0;
    }
    if (this.bus == 0L)
    {
      AppMethodBeat.o(194259);
      return -1;
    }
    try
    {
      if (this.bus == -1L) {}
      for (;;)
      {
        paramInt1 = this.inputStream.read(paramArrayOfByte, paramInt1, paramInt2);
        if (paramInt1 != -1) {
          break label134;
        }
        if (this.bus == -1L) {
          break;
        }
        paramArrayOfByte = new a(new EOFException());
        AppMethodBeat.o(194259);
        throw paramArrayOfByte;
        long l = Math.min(this.bus, paramInt2);
        paramInt2 = (int)l;
      }
      AppMethodBeat.o(194259);
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte = new a(paramArrayOfByte);
      AppMethodBeat.o(194259);
      throw paramArrayOfByte;
    }
    return -1;
    label134:
    if (this.bus != -1L) {
      this.bus -= paramInt1;
    }
    if (this.kQh != null) {
      this.kQh.sS(paramInt1);
    }
    AppMethodBeat.o(194259);
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