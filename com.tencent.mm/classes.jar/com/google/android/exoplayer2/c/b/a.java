package com.google.android.exoplayer2.c.b;

import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Stack;

final class a
  implements b
{
  private final byte[] biH;
  private final Stack<a> biI;
  private final f biJ;
  private c biK;
  private int biL;
  private int biM;
  private long biN;
  
  a()
  {
    AppMethodBeat.i(91999);
    this.biH = new byte[8];
    this.biI = new Stack();
    this.biJ = new f();
    AppMethodBeat.o(91999);
  }
  
  private long a(com.google.android.exoplayer2.c.f paramf, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(92002);
    paramf.readFully(this.biH, 0, paramInt);
    long l = 0L;
    while (i < paramInt)
    {
      l = l << 8 | this.biH[i] & 0xFF;
      i += 1;
    }
    AppMethodBeat.o(92002);
    return l;
  }
  
  public final void a(c paramc)
  {
    this.biK = paramc;
  }
  
  public final boolean c(com.google.android.exoplayer2.c.f paramf)
  {
    AppMethodBeat.i(92001);
    boolean bool;
    if (this.biK != null)
    {
      bool = true;
      com.google.android.exoplayer2.i.a.checkState(bool);
    }
    for (;;)
    {
      if ((!this.biI.isEmpty()) && (paramf.getPosition() >= ((a)this.biI.peek()).biO))
      {
        this.biK.ef(((a)this.biI.pop()).biM);
        AppMethodBeat.o(92001);
        return true;
        bool = false;
        break;
      }
      long l2;
      long l1;
      int j;
      if (this.biL == 0)
      {
        l2 = this.biJ.a(paramf, true, false, 4);
        l1 = l2;
        if (l2 == -2L) {
          paramf.uq();
        }
        for (;;)
        {
          paramf.b(this.biH, 0, 4);
          i = f.eg(this.biH[0]);
          if ((i != -1) && (i <= 4))
          {
            j = (int)f.a(this.biH, i, false);
            if (this.biK.ee(j))
            {
              paramf.dU(i);
              l1 = j;
              if (l1 != -1L) {
                break;
              }
              AppMethodBeat.o(92001);
              return false;
            }
          }
          paramf.dU(1);
        }
        this.biM = ((int)l1);
        this.biL = 1;
      }
      if (this.biL == 1)
      {
        this.biN = this.biJ.a(paramf, false, true, 8);
        this.biL = 2;
      }
      int i = this.biK.ed(this.biM);
      c localc;
      switch (i)
      {
      default: 
        paramf = new o("Invalid element type ".concat(String.valueOf(i)));
        AppMethodBeat.o(92001);
        throw paramf;
      case 1: 
        l1 = paramf.getPosition();
        l2 = this.biN;
        this.biI.add(new a(this.biM, l2 + l1, (byte)0));
        this.biK.e(this.biM, l1, this.biN);
        this.biL = 0;
        AppMethodBeat.o(92001);
        return true;
      case 2: 
        if (this.biN > 8L)
        {
          paramf = new o("Invalid integer size: " + this.biN);
          AppMethodBeat.o(92001);
          throw paramf;
        }
        this.biK.i(this.biM, a(paramf, (int)this.biN));
        this.biL = 0;
        AppMethodBeat.o(92001);
        return true;
      case 5: 
        if ((this.biN != 4L) && (this.biN != 8L))
        {
          paramf = new o("Invalid float size: " + this.biN);
          AppMethodBeat.o(92001);
          throw paramf;
        }
        localc = this.biK;
        i = this.biM;
        j = (int)this.biN;
        l1 = a(paramf, j);
        if (j == 4) {}
        for (double d = Float.intBitsToFloat((int)l1);; d = Double.longBitsToDouble(l1))
        {
          localc.b(i, d);
          this.biL = 0;
          AppMethodBeat.o(92001);
          return true;
        }
      case 3: 
        if (this.biN > 2147483647L)
        {
          paramf = new o("String element size: " + this.biN);
          AppMethodBeat.o(92001);
          throw paramf;
        }
        localc = this.biK;
        i = this.biM;
        j = (int)this.biN;
        if (j == 0) {}
        byte[] arrayOfByte;
        for (paramf = "";; paramf = new String(arrayOfByte))
        {
          localc.b(i, paramf);
          this.biL = 0;
          AppMethodBeat.o(92001);
          return true;
          arrayOfByte = new byte[j];
          paramf.readFully(arrayOfByte, 0, j);
        }
      case 4: 
        this.biK.a(this.biM, (int)this.biN, paramf);
        this.biL = 0;
        AppMethodBeat.o(92001);
        return true;
      }
      paramf.dU((int)this.biN);
      this.biL = 0;
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(92000);
    this.biL = 0;
    this.biI.clear();
    this.biJ.reset();
    AppMethodBeat.o(92000);
  }
  
  static final class a
  {
    final int biM;
    final long biO;
    
    private a(int paramInt, long paramLong)
    {
      this.biM = paramInt;
      this.biO = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.b.a
 * JD-Core Version:    0.7.0.1
 */