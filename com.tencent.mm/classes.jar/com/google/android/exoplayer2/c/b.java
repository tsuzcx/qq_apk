package com.google.android.exoplayer2.c;

import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;
import java.util.Arrays;

public final class b
  implements f
{
  private static final byte[] cLj = new byte[4096];
  private final g cLk;
  private final long cLl;
  private byte[] cLm;
  private int cLn;
  private int cLo;
  private long position;
  
  public b(g paramg, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(91957);
    this.cLk = paramg;
    this.position = paramLong1;
    this.cLl = paramLong2;
    this.cLm = new byte[65536];
    AppMethodBeat.o(91957);
  }
  
  private boolean B(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(91965);
    hv(paramInt);
    int i = Math.min(this.cLo - this.cLn, paramInt);
    while (i < paramInt)
    {
      int j = a(this.cLm, this.cLn, paramInt, i, paramBoolean);
      i = j;
      if (j == -1)
      {
        AppMethodBeat.o(91965);
        return false;
      }
    }
    this.cLn += paramInt;
    this.cLo = Math.max(this.cLo, this.cLn);
    AppMethodBeat.o(91965);
    return true;
  }
  
  private int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(91971);
    if (Thread.interrupted())
    {
      paramArrayOfByte = new InterruptedException();
      AppMethodBeat.o(91971);
      throw paramArrayOfByte;
    }
    paramInt1 = this.cLk.read(paramArrayOfByte, paramInt1 + paramInt3, paramInt2 - paramInt3);
    if (paramInt1 == -1)
    {
      if ((paramInt3 == 0) && (paramBoolean))
      {
        AppMethodBeat.o(91971);
        return -1;
      }
      paramArrayOfByte = new EOFException();
      AppMethodBeat.o(91971);
      throw paramArrayOfByte;
    }
    AppMethodBeat.o(91971);
    return paramInt3 + paramInt1;
  }
  
  private int c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91969);
    if (this.cLo == 0)
    {
      AppMethodBeat.o(91969);
      return 0;
    }
    paramInt2 = Math.min(this.cLo, paramInt2);
    System.arraycopy(this.cLm, 0, paramArrayOfByte, paramInt1, paramInt2);
    hx(paramInt2);
    AppMethodBeat.o(91969);
    return paramInt2;
  }
  
  private void hv(int paramInt)
  {
    AppMethodBeat.i(91967);
    paramInt = this.cLn + paramInt;
    if (paramInt > this.cLm.length)
    {
      paramInt = x.H(this.cLm.length * 2, 65536 + paramInt, paramInt + 524288);
      this.cLm = Arrays.copyOf(this.cLm, paramInt);
    }
    AppMethodBeat.o(91967);
  }
  
  private int hw(int paramInt)
  {
    AppMethodBeat.i(91968);
    paramInt = Math.min(this.cLo, paramInt);
    hx(paramInt);
    AppMethodBeat.o(91968);
    return paramInt;
  }
  
  private void hx(int paramInt)
  {
    AppMethodBeat.i(91970);
    this.cLo -= paramInt;
    this.cLn = 0;
    byte[] arrayOfByte = this.cLm;
    if (this.cLo < this.cLm.length - 524288) {
      arrayOfByte = new byte[this.cLo + 65536];
    }
    System.arraycopy(this.cLm, paramInt, arrayOfByte, 0, this.cLo);
    this.cLm = arrayOfByte;
    AppMethodBeat.o(91970);
  }
  
  private void hy(int paramInt)
  {
    if (paramInt != -1) {
      this.position += paramInt;
    }
  }
  
  public final void RS()
  {
    this.cLn = 0;
  }
  
  public final long RT()
  {
    return this.position + this.cLn;
  }
  
  public final long RU()
  {
    return this.cLl;
  }
  
  public final boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(91959);
    for (int i = c(paramArrayOfByte, paramInt1, paramInt2); (i < paramInt2) && (i != -1); i = a(paramArrayOfByte, paramInt1, paramInt2, i, paramBoolean)) {}
    hy(i);
    if (i != -1)
    {
      AppMethodBeat.o(91959);
      return true;
    }
    AppMethodBeat.o(91959);
    return false;
  }
  
  public final void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91964);
    b(paramArrayOfByte, paramInt1, paramInt2, false);
    AppMethodBeat.o(91964);
  }
  
  public final boolean b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(91963);
    if (!B(paramInt2, paramBoolean))
    {
      AppMethodBeat.o(91963);
      return false;
    }
    System.arraycopy(this.cLm, this.cLn - paramInt2, paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(91963);
    return true;
  }
  
  public final void eP(int paramInt)
  {
    AppMethodBeat.i(91962);
    for (int i = hw(paramInt); (i < paramInt) && (i != -1); i = a(cLj, -i, Math.min(paramInt, cLj.length + i), i, false)) {}
    hy(i);
    AppMethodBeat.o(91962);
  }
  
  public final long getPosition()
  {
    return this.position;
  }
  
  public final int ht(int paramInt)
  {
    AppMethodBeat.i(91961);
    int j = hw(paramInt);
    int i = j;
    if (j == 0) {
      i = a(cLj, 0, Math.min(paramInt, cLj.length), 0, true);
    }
    hy(i);
    AppMethodBeat.o(91961);
    return i;
  }
  
  public final void hu(int paramInt)
  {
    AppMethodBeat.i(91966);
    B(paramInt, false);
    AppMethodBeat.o(91966);
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91958);
    int j = c(paramArrayOfByte, paramInt1, paramInt2);
    int i = j;
    if (j == 0) {
      i = a(paramArrayOfByte, paramInt1, paramInt2, 0, true);
    }
    hy(i);
    AppMethodBeat.o(91958);
    return i;
  }
  
  public final void readFully(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91960);
    a(paramArrayOfByte, paramInt1, paramInt2, false);
    AppMethodBeat.o(91960);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.c.b
 * JD-Core Version:    0.7.0.1
 */