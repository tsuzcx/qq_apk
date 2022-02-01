package com.google.android.exoplayer2.c.b;

import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Stack;

final class a
  implements b
{
  private final byte[] aXA;
  private final Stack<a> aXB;
  private final f aXC;
  private c aXD;
  private int aXE;
  private int aXF;
  private long aXG;
  
  a()
  {
    AppMethodBeat.i(91999);
    this.aXA = new byte[8];
    this.aXB = new Stack();
    this.aXC = new f();
    AppMethodBeat.o(91999);
  }
  
  private long a(com.google.android.exoplayer2.c.f paramf, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(92002);
    paramf.readFully(this.aXA, 0, paramInt);
    long l = 0L;
    while (i < paramInt)
    {
      l = l << 8 | this.aXA[i] & 0xFF;
      i += 1;
    }
    AppMethodBeat.o(92002);
    return l;
  }
  
  public final void a(c paramc)
  {
    this.aXD = paramc;
  }
  
  public final boolean c(com.google.android.exoplayer2.c.f paramf)
  {
    AppMethodBeat.i(92001);
    boolean bool;
    if (this.aXD != null)
    {
      bool = true;
      com.google.android.exoplayer2.i.a.checkState(bool);
    }
    for (;;)
    {
      if ((!this.aXB.isEmpty()) && (paramf.getPosition() >= ((a)this.aXB.peek()).aXH))
      {
        this.aXD.eb(((a)this.aXB.pop()).aXF);
        AppMethodBeat.o(92001);
        return true;
        bool = false;
        break;
      }
      long l2;
      long l1;
      int j;
      if (this.aXE == 0)
      {
        l2 = this.aXC.a(paramf, true, false, 4);
        l1 = l2;
        if (l2 == -2L) {
          paramf.sI();
        }
        for (;;)
        {
          paramf.b(this.aXA, 0, 4);
          i = f.ec(this.aXA[0]);
          if ((i != -1) && (i <= 4))
          {
            j = (int)f.a(this.aXA, i, false);
            if (this.aXD.dZ(j))
            {
              paramf.dR(i);
              l1 = j;
              if (l1 != -1L) {
                break;
              }
              AppMethodBeat.o(92001);
              return false;
            }
          }
          paramf.dR(1);
        }
        this.aXF = ((int)l1);
        this.aXE = 1;
      }
      if (this.aXE == 1)
      {
        this.aXG = this.aXC.a(paramf, false, true, 8);
        this.aXE = 2;
      }
      int i = this.aXD.dY(this.aXF);
      c localc;
      switch (i)
      {
      default: 
        paramf = new o("Invalid element type ".concat(String.valueOf(i)));
        AppMethodBeat.o(92001);
        throw paramf;
      case 1: 
        l1 = paramf.getPosition();
        l2 = this.aXG;
        this.aXB.add(new a(this.aXF, l2 + l1, (byte)0));
        this.aXD.e(this.aXF, l1, this.aXG);
        this.aXE = 0;
        AppMethodBeat.o(92001);
        return true;
      case 2: 
        if (this.aXG > 8L)
        {
          paramf = new o("Invalid integer size: " + this.aXG);
          AppMethodBeat.o(92001);
          throw paramf;
        }
        this.aXD.i(this.aXF, a(paramf, (int)this.aXG));
        this.aXE = 0;
        AppMethodBeat.o(92001);
        return true;
      case 5: 
        if ((this.aXG != 4L) && (this.aXG != 8L))
        {
          paramf = new o("Invalid float size: " + this.aXG);
          AppMethodBeat.o(92001);
          throw paramf;
        }
        localc = this.aXD;
        i = this.aXF;
        j = (int)this.aXG;
        l1 = a(paramf, j);
        if (j == 4) {}
        for (double d = Float.intBitsToFloat((int)l1);; d = Double.longBitsToDouble(l1))
        {
          localc.b(i, d);
          this.aXE = 0;
          AppMethodBeat.o(92001);
          return true;
        }
      case 3: 
        if (this.aXG > 2147483647L)
        {
          paramf = new o("String element size: " + this.aXG);
          AppMethodBeat.o(92001);
          throw paramf;
        }
        localc = this.aXD;
        i = this.aXF;
        j = (int)this.aXG;
        if (j == 0) {}
        byte[] arrayOfByte;
        for (paramf = "";; paramf = new String(arrayOfByte))
        {
          localc.b(i, paramf);
          this.aXE = 0;
          AppMethodBeat.o(92001);
          return true;
          arrayOfByte = new byte[j];
          paramf.readFully(arrayOfByte, 0, j);
        }
      case 4: 
        this.aXD.a(this.aXF, (int)this.aXG, paramf);
        this.aXE = 0;
        AppMethodBeat.o(92001);
        return true;
      }
      paramf.dR((int)this.aXG);
      this.aXE = 0;
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(92000);
    this.aXE = 0;
    this.aXB.clear();
    this.aXC.reset();
    AppMethodBeat.o(92000);
  }
  
  static final class a
  {
    final int aXF;
    final long aXH;
    
    private a(int paramInt, long paramLong)
    {
      this.aXF = paramInt;
      this.aXH = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.b.a
 * JD-Core Version:    0.7.0.1
 */