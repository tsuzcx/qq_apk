package com.google.android.exoplayer2.c;

import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;
import java.util.Arrays;

public final class b
  implements f
{
  private static final byte[] aWF = new byte[4096];
  private final g aWG;
  private final long aWH;
  private byte[] aWI;
  private int aWJ;
  private int aWK;
  private long position;
  
  public b(g paramg, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(91957);
    this.aWG = paramg;
    this.position = paramLong1;
    this.aWH = paramLong2;
    this.aWI = new byte[65536];
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
    paramInt1 = this.aWG.read(paramArrayOfByte, paramInt1 + paramInt3, paramInt2 - paramInt3);
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
    if (this.aWK == 0)
    {
      AppMethodBeat.o(91969);
      return 0;
    }
    paramInt2 = Math.min(this.aWK, paramInt2);
    System.arraycopy(this.aWI, 0, paramArrayOfByte, paramInt1, paramInt2);
    dV(paramInt2);
    AppMethodBeat.o(91969);
    return paramInt2;
  }
  
  private void dT(int paramInt)
  {
    AppMethodBeat.i(91967);
    paramInt = this.aWJ + paramInt;
    if (paramInt > this.aWI.length)
    {
      paramInt = x.v(this.aWI.length * 2, 65536 + paramInt, paramInt + 524288);
      this.aWI = Arrays.copyOf(this.aWI, paramInt);
    }
    AppMethodBeat.o(91967);
  }
  
  private int dU(int paramInt)
  {
    AppMethodBeat.i(91968);
    paramInt = Math.min(this.aWK, paramInt);
    dV(paramInt);
    AppMethodBeat.o(91968);
    return paramInt;
  }
  
  private void dV(int paramInt)
  {
    AppMethodBeat.i(91970);
    this.aWK -= paramInt;
    this.aWJ = 0;
    byte[] arrayOfByte = this.aWI;
    if (this.aWK < this.aWI.length - 524288) {
      arrayOfByte = new byte[this.aWK + 65536];
    }
    System.arraycopy(this.aWI, paramInt, arrayOfByte, 0, this.aWK);
    this.aWI = arrayOfByte;
    AppMethodBeat.o(91970);
  }
  
  private void dW(int paramInt)
  {
    if (paramInt != -1) {
      this.position += paramInt;
    }
  }
  
  private boolean m(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(91965);
    dT(paramInt);
    int i = Math.min(this.aWK - this.aWJ, paramInt);
    while (i < paramInt)
    {
      int j = a(this.aWI, this.aWJ, paramInt, i, paramBoolean);
      i = j;
      if (j == -1)
      {
        AppMethodBeat.o(91965);
        return false;
      }
    }
    this.aWJ += paramInt;
    this.aWK = Math.max(this.aWK, this.aWJ);
    AppMethodBeat.o(91965);
    return true;
  }
  
  public final boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(91959);
    for (int i = c(paramArrayOfByte, paramInt1, paramInt2); (i < paramInt2) && (i != -1); i = a(paramArrayOfByte, paramInt1, paramInt2, i, paramBoolean)) {}
    dW(i);
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
    System.arraycopy(this.aWI, this.aWJ - paramInt2, paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(91963);
    return true;
  }
  
  public final int dQ(int paramInt)
  {
    AppMethodBeat.i(91961);
    int j = dU(paramInt);
    int i = j;
    if (j == 0) {
      i = a(aWF, 0, Math.min(paramInt, aWF.length), 0, true);
    }
    dW(i);
    AppMethodBeat.o(91961);
    return i;
  }
  
  public final void dR(int paramInt)
  {
    AppMethodBeat.i(91962);
    for (int i = dU(paramInt); (i < paramInt) && (i != -1); i = a(aWF, -i, Math.min(paramInt, aWF.length + i), i, false)) {}
    dW(i);
    AppMethodBeat.o(91962);
  }
  
  public final void dS(int paramInt)
  {
    AppMethodBeat.i(91966);
    m(paramInt, false);
    AppMethodBeat.o(91966);
  }
  
  public final long getLength()
  {
    return this.aWH;
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
    dW(i);
    AppMethodBeat.o(91958);
    return i;
  }
  
  public final void readFully(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91960);
    a(paramArrayOfByte, paramInt1, paramInt2, false);
    AppMethodBeat.o(91960);
  }
  
  public final void sI()
  {
    this.aWJ = 0;
  }
  
  public final long sJ()
  {
    return this.position + this.aWJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.b
 * JD-Core Version:    0.7.0.1
 */