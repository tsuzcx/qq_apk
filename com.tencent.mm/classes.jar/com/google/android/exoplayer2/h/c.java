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
  private final AssetManager assetManager;
  private final w<? super c> did;
  private long die;
  private InputStream inputStream;
  private boolean opened;
  public Uri uri;
  
  public c(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public c(Context paramContext, w<? super c> paramw)
  {
    AppMethodBeat.i(92955);
    this.assetManager = paramContext.getAssets();
    this.did = paramw;
    AppMethodBeat.o(92955);
  }
  
  public final long a(j paramj)
  {
    AppMethodBeat.i(92956);
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
          this.inputStream = this.assetManager.open(str1, 1);
          if (this.inputStream.skip(paramj.position) >= paramj.position) {
            break;
          }
          paramj = new EOFException();
          AppMethodBeat.o(92956);
          throw paramj;
        }
      }
      catch (IOException paramj)
      {
        paramj = new a(paramj);
        AppMethodBeat.o(92956);
        throw paramj;
      }
      String str1 = str2;
      if (str2.startsWith("/")) {
        str1 = str2.substring(1);
      }
    }
    if (paramj.length != -1L) {
      this.die = paramj.length;
    }
    for (;;)
    {
      this.opened = true;
      if (this.did != null) {
        this.did.a(this, paramj);
      }
      long l = this.die;
      AppMethodBeat.o(92956);
      return l;
      this.die = this.inputStream.available();
      if (this.die == 2147483647L) {
        this.die = -1L;
      }
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(92958);
    this.uri = null;
    try
    {
      if (this.inputStream != null) {
        this.inputStream.close();
      }
      return;
    }
    catch (IOException localIOException)
    {
      a locala = new a(localIOException);
      AppMethodBeat.o(92958);
      throw locala;
    }
    finally
    {
      this.inputStream = null;
      if (this.opened)
      {
        this.opened = false;
        if (this.did != null) {
          this.did.bj(this);
        }
      }
      AppMethodBeat.o(92958);
    }
    AppMethodBeat.o(92958);
  }
  
  public final Uri getUri()
  {
    return this.uri;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(92957);
    if (paramInt2 == 0)
    {
      AppMethodBeat.o(92957);
      return 0;
    }
    if (this.die == 0L)
    {
      AppMethodBeat.o(92957);
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
        AppMethodBeat.o(92957);
        throw paramArrayOfByte;
        long l = Math.min(this.die, paramInt2);
        paramInt2 = (int)l;
      }
      AppMethodBeat.o(92957);
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte = new a(paramArrayOfByte);
      AppMethodBeat.o(92957);
      throw paramArrayOfByte;
    }
    return -1;
    label134:
    if (this.die != -1L) {
      this.die -= paramInt1;
    }
    if (this.did != null) {
      this.did.f(this, paramInt1);
    }
    AppMethodBeat.o(92957);
    return paramInt1;
  }
  
  public static final class a
    extends IOException
  {
    public a(IOException paramIOException)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.h.c
 * JD-Core Version:    0.7.0.1
 */