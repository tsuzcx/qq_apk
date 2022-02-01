package com.google.android.exoplayer2.c.b;

import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Stack;

final class a
  implements b
{
  private final byte[] biE;
  private final Stack<a> biF;
  private final f biG;
  private c biH;
  private int biI;
  private int biJ;
  private long biK;
  
  a()
  {
    AppMethodBeat.i(91999);
    this.biE = new byte[8];
    this.biF = new Stack();
    this.biG = new f();
    AppMethodBeat.o(91999);
  }
  
  private long a(com.google.android.exoplayer2.c.f paramf, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(92002);
    paramf.readFully(this.biE, 0, paramInt);
    long l = 0L;
    while (i < paramInt)
    {
      l = l << 8 | this.biE[i] & 0xFF;
      i += 1;
    }
    AppMethodBeat.o(92002);
    return l;
  }
  
  public final void a(c paramc)
  {
    this.biH = paramc;
  }
  
  public final boolean c(com.google.android.exoplayer2.c.f paramf)
  {
    AppMethodBeat.i(92001);
    boolean bool;
    if (this.biH != null)
    {
      bool = true;
      com.google.android.exoplayer2.i.a.checkState(bool);
    }
    for (;;)
    {
      if ((!this.biF.isEmpty()) && (paramf.getPosition() >= ((a)this.biF.peek()).biL))
      {
        this.biH.dZ(((a)this.biF.pop()).biJ);
        AppMethodBeat.o(92001);
        return true;
        bool = false;
        break;
      }
      long l2;
      long l1;
      int j;
      if (this.biI == 0)
      {
        l2 = this.biG.a(paramf, true, false, 4);
        l1 = l2;
        if (l2 == -2L) {
          paramf.uv();
        }
        for (;;)
        {
          paramf.b(this.biE, 0, 4);
          i = f.ea(this.biE[0]);
          if ((i != -1) && (i <= 4))
          {
            j = (int)f.a(this.biE, i, false);
            if (this.biH.dY(j))
            {
              paramf.dP(i);
              l1 = j;
              if (l1 != -1L) {
                break;
              }
              AppMethodBeat.o(92001);
              return false;
            }
          }
          paramf.dP(1);
        }
        this.biJ = ((int)l1);
        this.biI = 1;
      }
      if (this.biI == 1)
      {
        this.biK = this.biG.a(paramf, false, true, 8);
        this.biI = 2;
      }
      int i = this.biH.dX(this.biJ);
      c localc;
      switch (i)
      {
      default: 
        paramf = new o("Invalid element type ".concat(String.valueOf(i)));
        AppMethodBeat.o(92001);
        throw paramf;
      case 1: 
        l1 = paramf.getPosition();
        l2 = this.biK;
        this.biF.add(new a(this.biJ, l2 + l1, (byte)0));
        this.biH.f(this.biJ, l1, this.biK);
        this.biI = 0;
        AppMethodBeat.o(92001);
        return true;
      case 2: 
        if (this.biK > 8L)
        {
          paramf = new o("Invalid integer size: " + this.biK);
          AppMethodBeat.o(92001);
          throw paramf;
        }
        this.biH.i(this.biJ, a(paramf, (int)this.biK));
        this.biI = 0;
        AppMethodBeat.o(92001);
        return true;
      case 5: 
        if ((this.biK != 4L) && (this.biK != 8L))
        {
          paramf = new o("Invalid float size: " + this.biK);
          AppMethodBeat.o(92001);
          throw paramf;
        }
        localc = this.biH;
        i = this.biJ;
        j = (int)this.biK;
        l1 = a(paramf, j);
        if (j == 4) {}
        for (double d = Float.intBitsToFloat((int)l1);; d = Double.longBitsToDouble(l1))
        {
          localc.b(i, d);
          this.biI = 0;
          AppMethodBeat.o(92001);
          return true;
        }
      case 3: 
        if (this.biK > 2147483647L)
        {
          paramf = new o("String element size: " + this.biK);
          AppMethodBeat.o(92001);
          throw paramf;
        }
        localc = this.biH;
        i = this.biJ;
        j = (int)this.biK;
        if (j == 0) {}
        byte[] arrayOfByte;
        for (paramf = "";; paramf = new String(arrayOfByte))
        {
          localc.d(i, paramf);
          this.biI = 0;
          AppMethodBeat.o(92001);
          return true;
          arrayOfByte = new byte[j];
          paramf.readFully(arrayOfByte, 0, j);
        }
      case 4: 
        this.biH.a(this.biJ, (int)this.biK, paramf);
        this.biI = 0;
        AppMethodBeat.o(92001);
        return true;
      }
      paramf.dP((int)this.biK);
      this.biI = 0;
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(92000);
    this.biI = 0;
    this.biF.clear();
    this.biG.reset();
    AppMethodBeat.o(92000);
  }
  
  static final class a
  {
    final int biJ;
    final long biL;
    
    private a(int paramInt, long paramLong)
    {
      this.biJ = paramInt;
      this.biL = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.c.b.a
 * JD-Core Version:    0.7.0.1
 */