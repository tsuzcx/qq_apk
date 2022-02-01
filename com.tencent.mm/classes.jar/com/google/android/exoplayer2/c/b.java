package com.google.android.exoplayer2.c;

import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;
import java.util.Arrays;

public final class b
  implements f
{
  private static final byte[] bhM = new byte[4096];
  private final g bhN;
  private final long bhO;
  private byte[] bhP;
  private int bhQ;
  private int bhR;
  private long position;
  
  public b(g paramg, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(91957);
    this.bhN = paramg;
    this.position = paramLong1;
    this.bhO = paramLong2;
    this.bhP = new byte[65536];
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
    paramInt1 = this.bhN.read(paramArrayOfByte, paramInt1 + paramInt3, paramInt2 - paramInt3);
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
    if (this.bhR == 0)
    {
      AppMethodBeat.o(91969);
      return 0;
    }
    paramInt2 = Math.min(this.bhR, paramInt2);
    System.arraycopy(this.bhP, 0, paramArrayOfByte, paramInt1, paramInt2);
    dY(paramInt2);
    AppMethodBeat.o(91969);
    return paramInt2;
  }
  
  private void dW(int paramInt)
  {
    AppMethodBeat.i(91967);
    paramInt = this.bhQ + paramInt;
    if (paramInt > this.bhP.length)
    {
      paramInt = x.v(this.bhP.length * 2, 65536 + paramInt, paramInt + 524288);
      this.bhP = Arrays.copyOf(this.bhP, paramInt);
    }
    AppMethodBeat.o(91967);
  }
  
  private int dX(int paramInt)
  {
    AppMethodBeat.i(91968);
    paramInt = Math.min(this.bhR, paramInt);
    dY(paramInt);
    AppMethodBeat.o(91968);
    return paramInt;
  }
  
  private void dY(int paramInt)
  {
    AppMethodBeat.i(91970);
    this.bhR -= paramInt;
    this.bhQ = 0;
    byte[] arrayOfByte = this.bhP;
    if (this.bhR < this.bhP.length - 524288) {
      arrayOfByte = new byte[this.bhR + 65536];
    }
    System.arraycopy(this.bhP, paramInt, arrayOfByte, 0, this.bhR);
    this.bhP = arrayOfByte;
    AppMethodBeat.o(91970);
  }
  
  private void dZ(int paramInt)
  {
    if (paramInt != -1) {
      this.position += paramInt;
    }
  }
  
  private boolean m(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(91965);
    dW(paramInt);
    int i = Math.min(this.bhR - this.bhQ, paramInt);
    while (i < paramInt)
    {
      int j = a(this.bhP, this.bhQ, paramInt, i, paramBoolean);
      i = j;
      if (j == -1)
      {
        AppMethodBeat.o(91965);
        return false;
      }
    }
    this.bhQ += paramInt;
    this.bhR = Math.max(this.bhR, this.bhQ);
    AppMethodBeat.o(91965);
    return true;
  }
  
  public final boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(91959);
    for (int i = c(paramArrayOfByte, paramInt1, paramInt2); (i < paramInt2) && (i != -1); i = a(paramArrayOfByte, paramInt1, paramInt2, i, paramBoolean)) {}
    dZ(i);
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
    System.arraycopy(this.bhP, this.bhQ - paramInt2, paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(91963);
    return true;
  }
  
  public final int dT(int paramInt)
  {
    AppMethodBeat.i(91961);
    int j = dX(paramInt);
    int i = j;
    if (j == 0) {
      i = a(bhM, 0, Math.min(paramInt, bhM.length), 0, true);
    }
    dZ(i);
    AppMethodBeat.o(91961);
    return i;
  }
  
  public final void dU(int paramInt)
  {
    AppMethodBeat.i(91962);
    for (int i = dX(paramInt); (i < paramInt) && (i != -1); i = a(bhM, -i, Math.min(paramInt, bhM.length + i), i, false)) {}
    dZ(i);
    AppMethodBeat.o(91962);
  }
  
  public final void dV(int paramInt)
  {
    AppMethodBeat.i(91966);
    m(paramInt, false);
    AppMethodBeat.o(91966);
  }
  
  public final long getLength()
  {
    return this.bhO;
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
    dZ(i);
    AppMethodBeat.o(91958);
    return i;
  }
  
  public final void readFully(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91960);
    a(paramArrayOfByte, paramInt1, paramInt2, false);
    AppMethodBeat.o(91960);
  }
  
  public final void uq()
  {
    this.bhQ = 0;
  }
  
  public final long ur()
  {
    return this.position + this.bhQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.b
 * JD-Core Version:    0.7.0.1
 */