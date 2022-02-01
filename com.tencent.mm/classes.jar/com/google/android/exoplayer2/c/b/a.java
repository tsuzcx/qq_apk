package com.google.android.exoplayer2.c.b;

import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Stack;

final class a
  implements b
{
  private final byte[] aYm;
  private final Stack<a> aYn;
  private final f aYo;
  private c aYp;
  private int aYq;
  private int aYr;
  private long aYs;
  
  a()
  {
    AppMethodBeat.i(91999);
    this.aYm = new byte[8];
    this.aYn = new Stack();
    this.aYo = new f();
    AppMethodBeat.o(91999);
  }
  
  private long a(com.google.android.exoplayer2.c.f paramf, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(92002);
    paramf.readFully(this.aYm, 0, paramInt);
    long l = 0L;
    while (i < paramInt)
    {
      l = l << 8 | this.aYm[i] & 0xFF;
      i += 1;
    }
    AppMethodBeat.o(92002);
    return l;
  }
  
  public final void a(c paramc)
  {
    this.aYp = paramc;
  }
  
  public final boolean c(com.google.android.exoplayer2.c.f paramf)
  {
    AppMethodBeat.i(92001);
    boolean bool;
    if (this.aYp != null)
    {
      bool = true;
      com.google.android.exoplayer2.i.a.checkState(bool);
    }
    for (;;)
    {
      if ((!this.aYn.isEmpty()) && (paramf.getPosition() >= ((a)this.aYn.peek()).aYt))
      {
        this.aYp.eb(((a)this.aYn.pop()).aYr);
        AppMethodBeat.o(92001);
        return true;
        bool = false;
        break;
      }
      long l2;
      long l1;
      int j;
      if (this.aYq == 0)
      {
        l2 = this.aYo.a(paramf, true, false, 4);
        l1 = l2;
        if (l2 == -2L) {
          paramf.sR();
        }
        for (;;)
        {
          paramf.b(this.aYm, 0, 4);
          i = f.ec(this.aYm[0]);
          if ((i != -1) && (i <= 4))
          {
            j = (int)f.a(this.aYm, i, false);
            if (this.aYp.dZ(j))
            {
              paramf.dQ(i);
              l1 = j;
              if (l1 != -1L) {
                break;
              }
              AppMethodBeat.o(92001);
              return false;
            }
          }
          paramf.dQ(1);
        }
        this.aYr = ((int)l1);
        this.aYq = 1;
      }
      if (this.aYq == 1)
      {
        this.aYs = this.aYo.a(paramf, false, true, 8);
        this.aYq = 2;
      }
      int i = this.aYp.dY(this.aYr);
      c localc;
      switch (i)
      {
      default: 
        paramf = new o("Invalid element type ".concat(String.valueOf(i)));
        AppMethodBeat.o(92001);
        throw paramf;
      case 1: 
        l1 = paramf.getPosition();
        l2 = this.aYs;
        this.aYn.add(new a(this.aYr, l2 + l1, (byte)0));
        this.aYp.e(this.aYr, l1, this.aYs);
        this.aYq = 0;
        AppMethodBeat.o(92001);
        return true;
      case 2: 
        if (this.aYs > 8L)
        {
          paramf = new o("Invalid integer size: " + this.aYs);
          AppMethodBeat.o(92001);
          throw paramf;
        }
        this.aYp.i(this.aYr, a(paramf, (int)this.aYs));
        this.aYq = 0;
        AppMethodBeat.o(92001);
        return true;
      case 5: 
        if ((this.aYs != 4L) && (this.aYs != 8L))
        {
          paramf = new o("Invalid float size: " + this.aYs);
          AppMethodBeat.o(92001);
          throw paramf;
        }
        localc = this.aYp;
        i = this.aYr;
        j = (int)this.aYs;
        l1 = a(paramf, j);
        if (j == 4) {}
        for (double d = Float.intBitsToFloat((int)l1);; d = Double.longBitsToDouble(l1))
        {
          localc.b(i, d);
          this.aYq = 0;
          AppMethodBeat.o(92001);
          return true;
        }
      case 3: 
        if (this.aYs > 2147483647L)
        {
          paramf = new o("String element size: " + this.aYs);
          AppMethodBeat.o(92001);
          throw paramf;
        }
        localc = this.aYp;
        i = this.aYr;
        j = (int)this.aYs;
        if (j == 0) {}
        byte[] arrayOfByte;
        for (paramf = "";; paramf = new String(arrayOfByte))
        {
          localc.b(i, paramf);
          this.aYq = 0;
          AppMethodBeat.o(92001);
          return true;
          arrayOfByte = new byte[j];
          paramf.readFully(arrayOfByte, 0, j);
        }
      case 4: 
        this.aYp.a(this.aYr, (int)this.aYs, paramf);
        this.aYq = 0;
        AppMethodBeat.o(92001);
        return true;
      }
      paramf.dQ((int)this.aYs);
      this.aYq = 0;
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(92000);
    this.aYq = 0;
    this.aYn.clear();
    this.aYo.reset();
    AppMethodBeat.o(92000);
  }
  
  static final class a
  {
    final int aYr;
    final long aYt;
    
    private a(int paramInt, long paramLong)
    {
      this.aYr = paramInt;
      this.aYt = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.b.a
 * JD-Core Version:    0.7.0.1
 */