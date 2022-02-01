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
  private long die;
  private AssetFileDescriptor dig;
  private InputStream inputStream;
  private String mimeType;
  private final Resources oJY;
  private boolean opened;
  private String sAW;
  private final s sBn;
  private long sBo;
  private long sBp;
  private Uri uri;
  
  public o(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private o(Context paramContext, byte paramByte)
  {
    AppMethodBeat.i(328556);
    this.mimeType = null;
    this.sBo = -1L;
    this.sBp = -1L;
    this.sAW = "";
    this.oJY = paramContext.getResources();
    this.sBn = null;
    AppMethodBeat.o(328556);
  }
  
  public final long a(g paramg)
  {
    long l1 = -1L;
    AppMethodBeat.i(328569);
    try
    {
      this.uri = paramg.uri;
      if (!TextUtils.equals("android.resource", this.uri.getScheme()))
      {
        paramg = new a("URI must use scheme android.resource");
        AppMethodBeat.o(328569);
        throw paramg;
      }
    }
    catch (IOException paramg)
    {
      paramg = new a(paramg);
      AppMethodBeat.o(328569);
      throw paramg;
    }
    try
    {
      int i = Integer.parseInt(this.uri.getLastPathSegment());
      this.dig = this.oJY.openRawResourceFd(i);
      this.sBo = this.dig.getLength();
      this.sBp = (this.sBo - paramg.position);
      this.inputStream = new FileInputStream(this.dig.getFileDescriptor());
      if (this.inputStream.markSupported()) {
        this.mimeType = URLConnection.guessContentTypeFromStream(this.inputStream);
      }
      this.inputStream.skip(this.dig.getStartOffset());
      if (this.inputStream.skip(paramg.position) < paramg.position)
      {
        paramg = new EOFException();
        AppMethodBeat.o(328569);
        throw paramg;
      }
    }
    catch (NumberFormatException paramg)
    {
      paramg = new a("Resource identifier must be an integer.");
      AppMethodBeat.o(328569);
      throw paramg;
    }
    if (paramg.length != -1L)
    {
      this.die = paramg.length;
      this.opened = true;
      if (this.sBn != null) {
        this.sBn.onTransferStart();
      }
      l1 = this.die;
      AppMethodBeat.o(328569);
      return l1;
    }
    long l2 = this.dig.getLength();
    if (l2 == -1L) {}
    for (;;)
    {
      this.die = l1;
      break;
      l1 = paramg.position;
      l1 = l2 - l1;
    }
  }
  
  public final long available()
  {
    return this.sBp;
  }
  
  public final void close()
  {
    AppMethodBeat.i(328579);
    this.uri = null;
    try
    {
      if (this.inputStream != null) {
        this.inputStream.close();
      }
      this.inputStream = null;
      try
      {
        if (this.dig != null) {
          this.dig.close();
        }
        return;
      }
      catch (IOException localIOException1)
      {
        a locala1 = new a(localIOException1);
        AppMethodBeat.o(328579);
        throw locala1;
      }
      finally
      {
        this.dig = null;
        if (this.opened)
        {
          this.opened = false;
          if (this.sBn != null) {
            this.sBn.onTransferEnd();
          }
        }
        AppMethodBeat.o(328579);
      }
      AppMethodBeat.o(328579);
      return;
    }
    catch (IOException localIOException2)
    {
      a locala2 = new a(localIOException2);
      AppMethodBeat.o(328579);
      throw locala2;
    }
    finally
    {
      this.inputStream = null;
      try
      {
        if (this.dig != null) {
          this.dig.close();
        }
        throw localObject2;
      }
      catch (IOException localIOException3)
      {
        a locala3 = new a(localIOException3);
        AppMethodBeat.o(328579);
        throw locala3;
      }
      finally
      {
        this.dig = null;
        if (this.opened)
        {
          this.opened = false;
          if (this.sBn != null) {
            this.sBn.onTransferEnd();
          }
        }
        AppMethodBeat.o(328579);
      }
    }
  }
  
  public final c cvM()
  {
    AppMethodBeat.i(328604);
    if (TextUtils.isEmpty(this.mimeType))
    {
      localc = c.sBV;
      AppMethodBeat.o(328604);
      return localc;
    }
    c localc = c.abW(this.mimeType);
    AppMethodBeat.o(328604);
    return localc;
  }
  
  public final long getTotalLength()
  {
    return this.sBo;
  }
  
  public final String getUri()
  {
    AppMethodBeat.i(328592);
    if (this.uri != null)
    {
      String str = this.uri.toString();
      AppMethodBeat.o(328592);
      return str;
    }
    AppMethodBeat.o(328592);
    return null;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(328587);
    if (paramInt2 == 0)
    {
      AppMethodBeat.o(328587);
      return 0;
    }
    if (this.die == 0L)
    {
      AppMethodBeat.o(328587);
      return -1;
    }
    try
    {
      if (this.die == -1L) {}
      for (;;)
      {
        paramInt1 = this.inputStream.read(paramArrayOfByte, paramInt1, paramInt2);
        if (paramInt1 != -1) {
          break label134;
        }
        if (this.die == -1L) {
          break;
        }
        paramArrayOfByte = new a(new EOFException());
        AppMethodBeat.o(328587);
        throw paramArrayOfByte;
        long l = Math.min(this.die, paramInt2);
        paramInt2 = (int)l;
      }
      AppMethodBeat.o(328587);
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte = new a(paramArrayOfByte);
      AppMethodBeat.o(328587);
      throw paramArrayOfByte;
    }
    return -1;
    label134:
    if (this.die != -1L) {
      this.die -= paramInt1;
    }
    if (this.sBn != null) {
      this.sBn.Bj(paramInt1);
    }
    AppMethodBeat.o(328587);
    return paramInt1;
  }
  
  public final void setLogTag(String paramString)
  {
    this.sAW = paramString;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.b.o
 * JD-Core Version:    0.7.0.1
 */