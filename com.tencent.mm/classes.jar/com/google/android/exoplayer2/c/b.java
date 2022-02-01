package com.google.android.exoplayer2.c;

import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;
import java.util.Arrays;

public final class b
  implements f
{
  private static final byte[] bhJ = new byte[4096];
  private final g bhK;
  private final long bhL;
  private byte[] bhM;
  private int bhN;
  private int bhO;
  private long position;
  
  public b(g paramg, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(91957);
    this.bhK = paramg;
    this.position = paramLong1;
    this.bhL = paramLong2;
    this.bhM = new byte[65536];
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
    paramInt1 = this.bhK.read(paramArrayOfByte, paramInt1 + paramInt3, paramInt2 - paramInt3);
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
    if (this.bhO == 0)
    {
      AppMethodBeat.o(91969);
      return 0;
    }
    paramInt2 = Math.min(this.bhO, paramInt2);
    System.arraycopy(this.bhM, 0, paramArrayOfByte, paramInt1, paramInt2);
    dT(paramInt2);
    AppMethodBeat.o(91969);
    return paramInt2;
  }
  
  private void dR(int paramInt)
  {
    AppMethodBeat.i(91967);
    paramInt = this.bhN + paramInt;
    if (paramInt > this.bhM.length)
    {
      paramInt = x.s(this.bhM.length * 2, 65536 + paramInt, paramInt + 524288);
      this.bhM = Arrays.copyOf(this.bhM, paramInt);
    }
    AppMethodBeat.o(91967);
  }
  
  private int dS(int paramInt)
  {
    AppMethodBeat.i(91968);
    paramInt = Math.min(this.bhO, paramInt);
    dT(paramInt);
    AppMethodBeat.o(91968);
    return paramInt;
  }
  
  private void dT(int paramInt)
  {
    AppMethodBeat.i(91970);
    this.bhO -= paramInt;
    this.bhN = 0;
    byte[] arrayOfByte = this.bhM;
    if (this.bhO < this.bhM.length - 524288) {
      arrayOfByte = new byte[this.bhO + 65536];
    }
    System.arraycopy(this.bhM, paramInt, arrayOfByte, 0, this.bhO);
    this.bhM = arrayOfByte;
    AppMethodBeat.o(91970);
  }
  
  private void dU(int paramInt)
  {
    if (paramInt != -1) {
      this.position += paramInt;
    }
  }
  
  private boolean o(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(91965);
    dR(paramInt);
    int i = Math.min(this.bhO - this.bhN, paramInt);
    while (i < paramInt)
    {
      int j = a(this.bhM, this.bhN, paramInt, i, paramBoolean);
      i = j;
      if (j == -1)
      {
        AppMethodBeat.o(91965);
        return false;
      }
    }
    this.bhN += paramInt;
    this.bhO = Math.max(this.bhO, this.bhN);
    AppMethodBeat.o(91965);
    return true;
  }
  
  public final boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(91959);
    for (int i = c(paramArrayOfByte, paramInt1, paramInt2); (i < paramInt2) && (i != -1); i = a(paramArrayOfByte, paramInt1, paramInt2, i, paramBoolean)) {}
    dU(i);
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
    if (!o(paramInt2, paramBoolean))
    {
      AppMethodBeat.o(91963);
      return false;
    }
    System.arraycopy(this.bhM, this.bhN - paramInt2, paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(91963);
    return true;
  }
  
  public final int dO(int paramInt)
  {
    AppMethodBeat.i(91961);
    int j = dS(paramInt);
    int i = j;
    if (j == 0) {
      i = a(bhJ, 0, Math.min(paramInt, bhJ.length), 0, true);
    }
    dU(i);
    AppMethodBeat.o(91961);
    return i;
  }
  
  public final void dP(int paramInt)
  {
    AppMethodBeat.i(91962);
    for (int i = dS(paramInt); (i < paramInt) && (i != -1); i = a(bhJ, -i, Math.min(paramInt, bhJ.length + i), i, false)) {}
    dU(i);
    AppMethodBeat.o(91962);
  }
  
  public final void dQ(int paramInt)
  {
    AppMethodBeat.i(91966);
    o(paramInt, false);
    AppMethodBeat.o(91966);
  }
  
  public final long getLength()
  {
    return this.bhL;
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
    dU(i);
    AppMethodBeat.o(91958);
    return i;
  }
  
  public final void readFully(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91960);
    a(paramArrayOfByte, paramInt1, paramInt2, false);
    AppMethodBeat.o(91960);
  }
  
  public final void uv()
  {
    this.bhN = 0;
  }
  
  public final long uw()
  {
    return this.position + this.bhN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.c.b
 * JD-Core Version:    0.7.0.1
 */