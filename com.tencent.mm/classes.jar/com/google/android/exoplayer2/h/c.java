package com.google.android.exoplayer2.h;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public final class c
  implements f
{
  private final AssetManager aQM;
  private final t<? super c> aQN;
  private InputStream aQO;
  private long aQP;
  private boolean opened;
  private Uri uri;
  
  public c(Context paramContext, t<? super c> paramt)
  {
    this.aQM = paramContext.getAssets();
    this.aQN = paramt;
  }
  
  public final long a(i parami)
  {
    for (;;)
    {
      String str2;
      try
      {
        this.uri = parami.uri;
        str2 = this.uri.getPath();
        if (str2.startsWith("/android_asset/"))
        {
          str1 = str2.substring(15);
          this.aQO = this.aQM.open(str1, 1);
          if (this.aQO.skip(parami.position) >= parami.position) {
            break;
          }
          throw new EOFException();
        }
      }
      catch (IOException parami)
      {
        throw new c.a(parami);
      }
      String str1 = str2;
      if (str2.startsWith("/")) {
        str1 = str2.substring(1);
      }
    }
    if (parami.aQW != -1L) {
      this.aQP = parami.aQW;
    }
    for (;;)
    {
      this.opened = true;
      if (this.aQN != null) {
        this.aQN.nT();
      }
      return this.aQP;
      this.aQP = this.aQO.available();
      if (this.aQP == 2147483647L) {
        this.aQP = -1L;
      }
    }
  }
  
  public final void close()
  {
    this.uri = null;
    try
    {
      if (this.aQO != null) {
        this.aQO.close();
      }
      return;
    }
    catch (IOException localIOException)
    {
      throw new c.a(localIOException);
    }
    finally
    {
      this.aQO = null;
      if (this.opened)
      {
        this.opened = false;
        if (this.aQN != null) {
          this.aQN.nU();
        }
      }
    }
  }
  
  public final Uri getUri()
  {
    return this.uri;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int j = -1;
    int i;
    if (paramInt2 == 0) {
      i = 0;
    }
    for (;;)
    {
      return i;
      i = j;
      if (this.aQP != 0L) {
        try
        {
          if (this.aQP == -1L) {}
          for (;;)
          {
            paramInt1 = this.aQO.read(paramArrayOfByte, paramInt1, paramInt2);
            if (paramInt1 != -1) {
              break label111;
            }
            i = j;
            if (this.aQP == -1L) {
              break;
            }
            throw new c.a(new EOFException());
            long l = Math.min(this.aQP, paramInt2);
            paramInt2 = (int)l;
          }
          if (this.aQP == -1L) {
            break label133;
          }
        }
        catch (IOException paramArrayOfByte)
        {
          throw new c.a(paramArrayOfByte);
        }
      }
    }
    label111:
    this.aQP -= paramInt1;
    label133:
    if (this.aQN != null) {
      this.aQN.dx(paramInt1);
    }
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.h.c
 * JD-Core Version:    0.7.0.1
 */