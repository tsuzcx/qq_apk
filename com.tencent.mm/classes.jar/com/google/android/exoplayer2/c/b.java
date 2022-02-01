package com.google.android.exoplayer2.c;

import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.EOFException;
import java.util.Arrays;

public final class b
  implements f
{
  private static final byte[] aRn = new byte[4096];
  private final g aRo;
  private final long aRp;
  private byte[] aRq;
  private int aRr;
  private int aRs;
  private long position;
  
  public b(g paramg, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(91957);
    this.aRo = paramg;
    this.position = paramLong1;
    this.aRp = paramLong2;
    this.aRq = new byte[65536];
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
    paramInt1 = this.aRo.read(paramArrayOfByte, paramInt1 + paramInt3, paramInt2 - paramInt3);
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
    if (this.aRs == 0)
    {
      AppMethodBeat.o(91969);
      return 0;
    }
    paramInt2 = Math.min(this.aRs, paramInt2);
    System.arraycopy(this.aRq, 0, paramArrayOfByte, paramInt1, paramInt2);
    eh(paramInt2);
    AppMethodBeat.o(91969);
    return paramInt2;
  }
  
  private void ef(int paramInt)
  {
    AppMethodBeat.i(91967);
    paramInt = this.aRr + paramInt;
    if (paramInt > this.aRq.length)
    {
      paramInt = x.r(this.aRq.length * 2, 65536 + paramInt, paramInt + 524288);
      this.aRq = Arrays.copyOf(this.aRq, paramInt);
    }
    AppMethodBeat.o(91967);
  }
  
  private int eg(int paramInt)
  {
    AppMethodBeat.i(91968);
    paramInt = Math.min(this.aRs, paramInt);
    eh(paramInt);
    AppMethodBeat.o(91968);
    return paramInt;
  }
  
  private void eh(int paramInt)
  {
    AppMethodBeat.i(91970);
    this.aRs -= paramInt;
    this.aRr = 0;
    byte[] arrayOfByte = this.aRq;
    if (this.aRs < this.aRq.length - 524288) {
      arrayOfByte = new byte[this.aRs + 65536];
    }
    System.arraycopy(this.aRq, paramInt, arrayOfByte, 0, this.aRs);
    this.aRq = arrayOfByte;
    AppMethodBeat.o(91970);
  }
  
  private void ei(int paramInt)
  {
    if (paramInt != -1) {
      this.position += paramInt;
    }
  }
  
  private boolean n(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(91965);
    ef(paramInt);
    int i = Math.min(this.aRs - this.aRr, paramInt);
    while (i < paramInt)
    {
      int j = a(this.aRq, this.aRr, paramInt, i, paramBoolean);
      i = j;
      if (j == -1)
      {
        AppMethodBeat.o(91965);
        return false;
      }
    }
    this.aRr += paramInt;
    this.aRs = Math.max(this.aRs, this.aRr);
    AppMethodBeat.o(91965);
    return true;
  }
  
  public final boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(91959);
    for (int i = c(paramArrayOfByte, paramInt1, paramInt2); (i < paramInt2) && (i != -1); i = a(paramArrayOfByte, paramInt1, paramInt2, i, paramBoolean)) {}
    ei(i);
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
    if (!n(paramInt2, paramBoolean))
    {
      AppMethodBeat.o(91963);
      return false;
    }
    System.arraycopy(this.aRq, this.aRr - paramInt2, paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(91963);
    return true;
  }
  
  public final int ec(int paramInt)
  {
    AppMethodBeat.i(91961);
    int j = eg(paramInt);
    int i = j;
    if (j == 0) {
      i = a(aRn, 0, Math.min(paramInt, aRn.length), 0, true);
    }
    ei(i);
    AppMethodBeat.o(91961);
    return i;
  }
  
  public final void ed(int paramInt)
  {
    AppMethodBeat.i(91962);
    for (int i = eg(paramInt); (i < paramInt) && (i != -1); i = a(aRn, -i, Math.min(paramInt, aRn.length + i), i, false)) {}
    ei(i);
    AppMethodBeat.o(91962);
  }
  
  public final void ee(int paramInt)
  {
    AppMethodBeat.i(91966);
    n(paramInt, false);
    AppMethodBeat.o(91966);
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
    ei(i);
    AppMethodBeat.o(91958);
    return i;
  }
  
  public final void readFully(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(91960);
    a(paramArrayOfByte, paramInt1, paramInt2, false);
    AppMethodBeat.o(91960);
  }
  
  public final void sp()
  {
    this.aRr = 0;
  }
  
  public final long sq()
  {
    return this.position + this.aRr;
  }
  
  public final long sr()
  {
    return this.aRp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c.b
 * JD-Core Version:    0.7.0.1
 */