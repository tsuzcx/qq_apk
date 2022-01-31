package com.google.android.exoplayer2.h;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public final class c
  implements g
{
  private final AssetManager aYp;
  private final w<? super c> aYq;
  private InputStream aYr;
  private long aYs;
  private boolean opened;
  private Uri uri;
  
  public c(Context paramContext, w<? super c> paramw)
  {
    AppMethodBeat.i(95787);
    this.aYp = paramContext.getAssets();
    this.aYq = paramw;
    AppMethodBeat.o(95787);
  }
  
  public final long a(j paramj)
  {
    AppMethodBeat.i(95788);
    for (;;)
    {
      String str2;
      try
      {
        this.uri = paramj.uri;
        str2 = this.uri.getPath();
        if (str2.startsWith("/android_asset/"))
        {
          str1 = str2.substring(15);
          this.aYr = this.aYp.open(str1, 1);
          if (this.aYr.skip(paramj.position) >= paramj.position) {
            break;
          }
          paramj = new EOFException();
          AppMethodBeat.o(95788);
          throw paramj;
        }
      }
      catch (IOException paramj)
      {
        paramj = new c.a(paramj);
        AppMethodBeat.o(95788);
        throw paramj;
      }
      String str1 = str2;
      if (str2.startsWith("/")) {
        str1 = str2.substring(1);
      }
    }
    if (paramj.aPF != -1L) {
      this.aYs = paramj.aPF;
    }
    for (;;)
    {
      this.opened = true;
      if (this.aYq != null) {
        this.aYq.qq();
      }
      long l = this.aYs;
      AppMethodBeat.o(95788);
      return l;
      this.aYs = this.aYr.available();
      if (this.aYs == 2147483647L) {
        this.aYs = -1L;
      }
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(95790);
    this.uri = null;
    try
    {
      if (this.aYr != null) {
        this.aYr.close();
      }
      return;
    }
    catch (IOException localIOException)
    {
      c.a locala = new c.a(localIOException);
      AppMethodBeat.o(95790);
      throw locala;
    }
    finally
    {
      this.aYr = null;
      if (this.opened)
      {
        this.opened = false;
        if (this.aYq != null) {
          this.aYq.qr();
        }
      }
      AppMethodBeat.o(95790);
    }
    AppMethodBeat.o(95790);
  }
  
  public final Uri getUri()
  {
    return this.uri;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(95789);
    if (paramInt2 == 0)
    {
      AppMethodBeat.o(95789);
      return 0;
    }
    if (this.aYs == 0L)
    {
      AppMethodBeat.o(95789);
      return -1;
    }
    try
    {
      if (this.aYs == -1L) {}
      for (;;)
      {
        paramInt1 = this.aYr.read(paramArrayOfByte, paramInt1, paramInt2);
        if (paramInt1 != -1) {
          break label134;
        }
        if (this.aYs == -1L) {
          break;
        }
        paramArrayOfByte = new c.a(new EOFException());
        AppMethodBeat.o(95789);
        throw paramArrayOfByte;
        long l = Math.min(this.aYs, paramInt2);
        paramInt2 = (int)l;
      }
      AppMethodBeat.o(95789);
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte = new c.a(paramArrayOfByte);
      AppMethodBeat.o(95789);
      throw paramArrayOfByte;
    }
    return -1;
    label134:
    if (this.aYs != -1L) {
      this.aYs -= paramInt1;
    }
    if (this.aYq != null) {
      this.aYq.el(paramInt1);
    }
    AppMethodBeat.o(95789);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.h.c
 * JD-Core Version:    0.7.0.1
 */