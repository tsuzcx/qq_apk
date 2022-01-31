package com.google.android.exoplayer2.h;

import com.google.android.exoplayer2.i.a;
import java.io.InputStream;

public final class h
  extends InputStream
{
  private final i aJa;
  private final byte[] aQS;
  long aQT;
  private final f ayZ;
  private boolean closed = false;
  private boolean opened = false;
  
  public h(f paramf, i parami)
  {
    this.ayZ = paramf;
    this.aJa = parami;
    this.aQS = new byte[1];
  }
  
  public final void close()
  {
    if (!this.closed)
    {
      this.ayZ.close();
      this.closed = true;
    }
  }
  
  final void nQ()
  {
    if (!this.opened)
    {
      this.ayZ.a(this.aJa);
      this.opened = true;
    }
  }
  
  public final int read()
  {
    if (read(this.aQS) == -1) {
      return -1;
    }
    return this.aQS[0] & 0xFF;
  }
  
  public final int read(byte[] paramArrayOfByte)
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!this.closed) {}
    for (boolean bool = true;; bool = false)
    {
      a.aC(bool);
      nQ();
      paramInt1 = this.ayZ.read(paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt1 != -1) {
        break;
      }
      return -1;
    }
    this.aQT += paramInt1;
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.h.h
 * JD-Core Version:    0.7.0.1
 */