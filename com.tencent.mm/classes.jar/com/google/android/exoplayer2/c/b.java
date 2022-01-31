package com.google.android.exoplayer2.c;

import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;
import java.util.Arrays;

public final class b
  implements f
{
  private static final byte[] aBn = new byte[4096];
  private final g aBo;
  private final long aBp;
  private byte[] aBq;
  private int aBr;
  private int aBs;
  private long position;
  
  public b(g paramg, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(94842);
    this.aBo = paramg;
    this.position = paramLong1;
    this.aBp = paramLong2;
    this.aBq = new byte[65536];
    AppMethodBeat.o(94842);
  }
  
  private int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(94856);
    if (Thread.interrupted())
    {
      paramArrayOfByte = new InterruptedException();
      AppMethodBeat.o(94856);
      throw paramArrayOfByte;
    }
    paramInt1 = this.aBo.read(paramArrayOfByte, paramInt1 + paramInt3, paramInt2 - paramInt3);
    if (paramInt1 == -1)
    {
      if ((paramInt3 == 0) && (paramBoolean))
      {
        AppMethodBeat.o(94856);
        return -1;
      }
      paramArrayOfByte = new EOFException();
      AppMethodBeat.o(94856);
      throw paramArrayOfByte;
    }
    AppMethodBeat.o(94856);
    return paramInt3 + paramInt1;
  }
  
  private int c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94854);
    if (this.aBs == 0)
    {
      AppMethodBeat.o(94854);
      return 0;
    }
    paramInt2 = Math.min(this.aBs, paramInt2);
    System.arraycopy(this.aBq, 0, paramArrayOfByte, paramInt1, paramInt2);
    dk(paramInt2);
    AppMethodBeat.o(94854);
    return paramInt2;
  }
  
  private void di(int paramInt)
  {
    AppMethodBeat.i(94852);
    paramInt = this.aBr + paramInt;
    if (paramInt > this.aBq.length)
    {
      paramInt = x.t(this.aBq.length * 2, 65536 + paramInt, paramInt + 524288);
      this.aBq = Arrays.copyOf(this.aBq, paramInt);
    }
    AppMethodBeat.o(94852);
  }
  
  private int dj(int paramInt)
  {
    AppMethodBeat.i(94853);
    paramInt = Math.min(this.aBs, paramInt);
    dk(paramInt);
    AppMethodBeat.o(94853);
    return paramInt;
  }
  
  private void dk(int paramInt)
  {
    AppMethodBeat.i(94855);
    this.aBs -= paramInt;
    this.aBr = 0;
    byte[] arrayOfByte = this.aBq;
    if (this.aBs < this.aBq.length - 524288) {
      arrayOfByte = new byte[this.aBs + 65536];
    }
    System.arraycopy(this.aBq, paramInt, arrayOfByte, 0, this.aBs);
    this.aBq = arrayOfByte;
    AppMethodBeat.o(94855);
  }
  
  private void dl(int paramInt)
  {
    if (paramInt != -1) {
      this.position += paramInt;
    }
  }
  
  private boolean n(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(94850);
    di(paramInt);
    int i = Math.min(this.aBs - this.aBr, paramInt);
    while (i < paramInt)
    {
      int j = a(this.aBq, this.aBr, paramInt, i, paramBoolean);
      i = j;
      if (j == -1)
      {
        AppMethodBeat.o(94850);
        return false;
      }
    }
    this.aBr += paramInt;
    this.aBs = Math.max(this.aBs, this.aBr);
    AppMethodBeat.o(94850);
    return true;
  }
  
  public final boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(94844);
    for (int i = c(paramArrayOfByte, paramInt1, paramInt2); (i < paramInt2) && (i != -1); i = a(paramArrayOfByte, paramInt1, paramInt2, i, paramBoolean)) {}
    dl(i);
    if (i != -1)
    {
      AppMethodBeat.o(94844);
      return true;
    }
    AppMethodBeat.o(94844);
    return false;
  }
  
  public final void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94849);
    b(paramArrayOfByte, paramInt1, paramInt2, false);
    AppMethodBeat.o(94849);
  }
  
  public final boolean b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(94848);
    if (!n(paramInt2, paramBoolean))
    {
      AppMethodBeat.o(94848);
      return false;
    }
    System.arraycopy(this.aBq, this.aBr - paramInt2, paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(94848);
    return true;
  }
  
  public final int df(int paramInt)
  {
    AppMethodBeat.i(94846);
    int j = dj(paramInt);
    int i = j;
    if (j == 0) {
      i = a(aBn, 0, Math.min(paramInt, aBn.length), 0, true);
    }
    dl(i);
    AppMethodBeat.o(94846);
    return i;
  }
  
  public final void dg(int paramInt)
  {
    AppMethodBeat.i(94847);
    for (int i = dj(paramInt); (i < paramInt) && (i != -1); i = a(aBn, -i, Math.min(paramInt, aBn.length + i), i, false)) {}
    dl(i);
    AppMethodBeat.o(94847);
  }
  
  public final void dh(int paramInt)
  {
    AppMethodBeat.i(94851);
    n(paramInt, false);
    AppMethodBeat.o(94851);
  }
  
  public final long getLength()
  {
    return this.aBp;
  }
  
  public final long getPosition()
  {
    return this.position;
  }
  
  public final void nW()
  {
    this.aBr = 0;
  }
  
  public final long nX()
  {
    return this.position + this.aBr;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94843);
    int j = c(paramArrayOfByte, paramInt1, paramInt2);
    int i = j;
    if (j == 0) {
      i = a(paramArrayOfByte, paramInt1, paramInt2, 0, true);
    }
    dl(i);
    AppMethodBeat.o(94843);
    return i;
  }
  
  public final void readFully(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94845);
    a(paramArrayOfByte, paramInt1, paramInt2, false);
    AppMethodBeat.o(94845);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.c.b
 * JD-Core Version:    0.7.0.1
 */