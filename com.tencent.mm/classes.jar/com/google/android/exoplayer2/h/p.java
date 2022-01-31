package com.google.android.exoplayer2.h;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class p
  implements f
{
  private final t<? super p> aQN;
  private long aQP;
  private RandomAccessFile aRL;
  private boolean opened;
  private Uri uri;
  
  public p()
  {
    this(null);
  }
  
  public p(t<? super p> paramt)
  {
    this.aQN = paramt;
  }
  
  public final long a(i parami)
  {
    for (;;)
    {
      try
      {
        this.uri = parami.uri;
        this.aRL = new RandomAccessFile(parami.uri.getPath(), "r");
        this.aRL.seek(parami.position);
        if (parami.aQW == -1L)
        {
          l = this.aRL.length() - parami.position;
          this.aQP = l;
          if (this.aQP >= 0L) {
            break;
          }
          throw new EOFException();
        }
      }
      catch (IOException parami)
      {
        throw new p.a(parami);
      }
      long l = parami.aQW;
    }
    this.opened = true;
    if (this.aQN != null) {
      this.aQN.nT();
    }
    return this.aQP;
  }
  
  public final void close()
  {
    this.uri = null;
    try
    {
      if (this.aRL != null) {
        this.aRL.close();
      }
      return;
    }
    catch (IOException localIOException)
    {
      throw new p.a(localIOException);
    }
    finally
    {
      this.aRL = null;
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
    if (paramInt2 == 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      return paramInt1;
      if (this.aQP == 0L) {
        return -1;
      }
      try
      {
        paramInt2 = this.aRL.read(paramArrayOfByte, paramInt1, (int)Math.min(this.aQP, paramInt2));
        paramInt1 = paramInt2;
        if (paramInt2 <= 0) {
          continue;
        }
        this.aQP -= paramInt2;
        paramInt1 = paramInt2;
        if (this.aQN == null) {
          continue;
        }
        this.aQN.dx(paramInt2);
        return paramInt2;
      }
      catch (IOException paramArrayOfByte)
      {
        throw new p.a(paramArrayOfByte);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.h.p
 * JD-Core Version:    0.7.0.1
 */