package com.google.android.exoplayer2.c;

import com.google.android.exoplayer2.h.f;
import com.google.android.exoplayer2.i.t;
import java.io.EOFException;
import java.util.Arrays;

public final class b
  implements e
{
  private static final byte[] ayY = new byte[4096];
  private final f ayZ;
  private final long aza;
  private byte[] azb;
  private int azc;
  private int azd;
  private long position;
  
  public b(f paramf, long paramLong1, long paramLong2)
  {
    this.ayZ = paramf;
    this.position = paramLong1;
    this.aza = paramLong2;
    this.azb = new byte[65536];
  }
  
  private int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (Thread.interrupted()) {
      throw new InterruptedException();
    }
    paramInt1 = this.ayZ.read(paramArrayOfByte, paramInt1 + paramInt3, paramInt2 - paramInt3);
    if (paramInt1 == -1)
    {
      if ((paramInt3 == 0) && (paramBoolean)) {
        return -1;
      }
      throw new EOFException();
    }
    return paramInt3 + paramInt1;
  }
  
  private int c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.azd == 0) {
      return 0;
    }
    paramInt2 = Math.min(this.azd, paramInt2);
    System.arraycopy(this.azb, 0, paramArrayOfByte, paramInt1, paramInt2);
    cO(paramInt2);
    return paramInt2;
  }
  
  private int cN(int paramInt)
  {
    paramInt = Math.min(this.azd, paramInt);
    cO(paramInt);
    return paramInt;
  }
  
  private void cO(int paramInt)
  {
    this.azd -= paramInt;
    this.azc = 0;
    byte[] arrayOfByte = this.azb;
    if (this.azd < this.azb.length - 524288) {
      arrayOfByte = new byte[this.azd + 65536];
    }
    System.arraycopy(this.azb, paramInt, arrayOfByte, 0, this.azd);
    this.azb = arrayOfByte;
  }
  
  private void cP(int paramInt)
  {
    if (paramInt != -1) {
      this.position += paramInt;
    }
  }
  
  private boolean q(int paramInt, boolean paramBoolean)
  {
    int i = this.azc + paramInt;
    if (i > this.azb.length)
    {
      i = t.t(this.azb.length * 2, 65536 + i, i + 524288);
      this.azb = Arrays.copyOf(this.azb, i);
    }
    i = Math.min(this.azd - this.azc, paramInt);
    while (i < paramInt)
    {
      int j = a(this.azb, this.azc, paramInt, i, paramBoolean);
      i = j;
      if (j == -1) {
        return false;
      }
    }
    this.azc += paramInt;
    this.azd = Math.max(this.azd, this.azc);
    return true;
  }
  
  public final boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    for (int i = c(paramArrayOfByte, paramInt1, paramInt2); (i < paramInt2) && (i != -1); i = a(paramArrayOfByte, paramInt1, paramInt2, i, paramBoolean)) {}
    cP(i);
    return i != -1;
  }
  
  public final void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    b(paramArrayOfByte, paramInt1, paramInt2, false);
  }
  
  public final boolean b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (!q(paramInt2, paramBoolean)) {
      return false;
    }
    System.arraycopy(this.azb, this.azc - paramInt2, paramArrayOfByte, paramInt1, paramInt2);
    return true;
  }
  
  public final int cK(int paramInt)
  {
    int j = cN(paramInt);
    int i = j;
    if (j == 0) {
      i = a(ayY, 0, Math.min(paramInt, ayY.length), 0, true);
    }
    cP(i);
    return i;
  }
  
  public final void cL(int paramInt)
  {
    for (int i = cN(paramInt); (i < paramInt) && (i != -1); i = a(ayY, -i, Math.min(paramInt, ayY.length + i), i, false)) {}
    cP(i);
  }
  
  public final void cM(int paramInt)
  {
    q(paramInt, false);
  }
  
  public final long getLength()
  {
    return this.aza;
  }
  
  public final long getPosition()
  {
    return this.position;
  }
  
  public final void lT()
  {
    this.azc = 0;
  }
  
  public final long lU()
  {
    return this.position + this.azc;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int j = c(paramArrayOfByte, paramInt1, paramInt2);
    int i = j;
    if (j == 0) {
      i = a(paramArrayOfByte, paramInt1, paramInt2, 0, true);
    }
    cP(i);
    return i;
  }
  
  public final void readFully(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    a(paramArrayOfByte, paramInt1, paramInt2, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.c.b
 * JD-Core Version:    0.7.0.1
 */