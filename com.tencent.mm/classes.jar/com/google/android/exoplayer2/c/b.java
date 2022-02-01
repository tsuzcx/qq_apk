package com.google.android.exoplayer2.c;

import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;
import java.util.Arrays;

public final class b
  implements f
{
  private static final byte[] aXr = new byte[4096];
  private final g aXs;
  private final long aXt;
  private byte[] aXu;
  private int aXv;
  private int aXw;
  private long position;
  
  public b(g paramg, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(91957);
    this.aXs = paramg;
    this.position = paramLong1;
    this.aXt = paramLong2;
    this.aXu = new byte[65536];
    AppMethodBeat.o(91957);
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
    paramInt1 = this.aXs.read(paramArrayOfByte, paramInt1 + paramInt3, paramInt2 - paramInt3);
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
    if (this.aXw == 0)
    {
      AppMethodBeat.o(91969);
      return 0;
    }
    paramInt2 = Math.min(this.aXw, paramInt2);
    System.arraycopy(this.aXu, 0, paramArrayOfByte, paramInt1, paramInt2);
    dU(paramInt2);
    AppMethodBeat.o(91969);
    return paramInt2;
  }
  
  private void dS(int paramInt)
  {
    AppMethodBeat.i(91967);
    paramInt = this.aXv + paramInt;
    if (paramInt > this.aXu.length)
    {
      paramInt = x.v(this.aXu.length * 2, 65536 + paramInt, paramInt + 524288);
      this.aXu = Arrays.copyOf(this.aXu, paramInt);
    }
    AppMethodBeat.o(91967);
  }
  
  private int dT(int paramInt)
  {
    AppMethodBeat.i(91968);
    paramInt = Math.min(this.aXw, paramInt);
    dU(paramInt);
    AppMethodBeat.o(91968);
    return paramInt;
  }
  
  private void dU(int paramInt)
  {
    AppMethodBeat.i(91970);
    this.aXw -= paramInt;
    this.aXv = 0;
    byte[] arrayOfByte = this.aXu;
    if (this.aXw < this.aXu.length - 524288) {
      arrayOfByte = new byte[this.aXw + 65536];
    }
    System.arraycopy(this.aXu, paramInt, arrayOfByte, 0, this.aXw);
    this.aXu = arrayOfByte;
    AppMethodBeat.o(91970);
  }
  
  private void dV(int paramInt)
  {
    if (paramInt != -1) {
      this.position += paramInt;
    }
  }
  
  private boolean m(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(91965);
    dS(paramInt);
    int i = Math.min(this.aXw - this.aXv, paramInt);
    while (i < paramInt)
    {
      int j = a(this.aXu, this.aXv, paramInt, i, paramBoolean);
      i = j;
      if (j == -1)
      {
        AppMethodBeat.o(91965);
        return false;
      }
    }
    this.aXv += paramInt;
    this.aXw = Math.max(this.aXw, this.aXv);
    AppMethodBeat.o(91965);
    return true;
  }
  
  public final boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(91959);
    for (int i = c(paramArrayOfByte, paramInt1, paramInt2); (i < paramInt2) && (i != -1); i = a(paramArrayOfByte, paramInt1, paramInt2, i, paramBoolean)) {}
    dV(i);
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
    if (!m(paramInt2, paramBoolean))
    {
      AppMethodBeat.o(91963);
      return false;
    }
    System.arraycopy(this.aXu, this.aXv - paramInt2, paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(91963);
    return true;
  }
  
  public final int dP(int paramInt)
  {
    AppMethodBeat.i(91961);
    int j = dT(paramInt);
    int i = j;
    if (j == 0) {
      i = a(aXr, 0, Math.min(paramInt, aXr.length), 0, true);
    }
    dV(i);
    AppMethodBeat.o(91961);
    return i;
  }
  
  public final void dQ(int paramInt)
  {
    AppMethodBeat.i(91962);
    for (int i = dT(paramInt); (i < paramInt) && (i != -1); i = a(aXr, -i, Math.min(paramInt, aXr.length + i), i, false)) {}
    dV(i);
    AppMethodBeat.o(91962);
  }
  
  public final void dR(int paramInt)
  {
    AppMethodBeat.i(91966);
    m(paramInt, false);
    AppMethodBeat.o(91966);
  }
  
  public final long getLength()
  {
    return this.aXt;
  }
  
  public final long getPosition()
  {
    return this.position;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91958);
    int j = c(paramArrayOfByte, paramInt1, paramInt2);
    int i = j;
    if (j == 0) {
      i = a(paramArrayOfByte, paramInt1, paramInt2, 0, true);
    }
    dV(i);
    AppMethodBeat.o(91958);
    return i;
  }
  
  public final void readFully(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91960);
    a(paramArrayOfByte, paramInt1, paramInt2, false);
    AppMethodBeat.o(91960);
  }
  
  public final void sR()
  {
    this.aXv = 0;
  }
  
  public final long sS()
  {
    return this.position + this.aXv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.b
 * JD-Core Version:    0.7.0.1
 */