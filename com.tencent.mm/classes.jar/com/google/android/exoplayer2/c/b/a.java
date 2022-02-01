package com.google.android.exoplayer2.c.b;

import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Stack;

final class a
  implements b
{
  private final byte[] aSi;
  private final Stack<a> aSj;
  private final f aSk;
  private c aSl;
  private int aSm;
  private int aSn;
  private long aSo;
  
  a()
  {
    AppMethodBeat.i(91999);
    this.aSi = new byte[8];
    this.aSj = new Stack();
    this.aSk = new f();
    AppMethodBeat.o(91999);
  }
  
  private long a(com.google.android.exoplayer2.c.f paramf, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(92002);
    paramf.readFully(this.aSi, 0, paramInt);
    long l = 0L;
    while (i < paramInt)
    {
      l = l << 8 | this.aSi[i] & 0xFF;
      i += 1;
    }
    AppMethodBeat.o(92002);
    return l;
  }
  
  public final void a(c paramc)
  {
    this.aSl = paramc;
  }
  
  public final boolean c(com.google.android.exoplayer2.c.f paramf)
  {
    AppMethodBeat.i(92001);
    boolean bool;
    if (this.aSl != null)
    {
      bool = true;
      com.google.android.exoplayer2.i.a.checkState(bool);
    }
    for (;;)
    {
      if ((!this.aSj.isEmpty()) && (paramf.getPosition() >= ((a)this.aSj.peek()).aSp))
      {
        this.aSl.en(((a)this.aSj.pop()).aSn);
        AppMethodBeat.o(92001);
        return true;
        bool = false;
        break;
      }
      long l2;
      long l1;
      int j;
      if (this.aSm == 0)
      {
        l2 = this.aSk.a(paramf, true, false, 4);
        l1 = l2;
        if (l2 == -2L) {
          paramf.sp();
        }
        for (;;)
        {
          paramf.b(this.aSi, 0, 4);
          i = f.eo(this.aSi[0]);
          if ((i != -1) && (i <= 4))
          {
            j = (int)f.a(this.aSi, i, false);
            if (this.aSl.em(j))
            {
              paramf.ed(i);
              l1 = j;
              if (l1 != -1L) {
                break;
              }
              AppMethodBeat.o(92001);
              return false;
            }
          }
          paramf.ed(1);
        }
        this.aSn = ((int)l1);
        this.aSm = 1;
      }
      if (this.aSm == 1)
      {
        this.aSo = this.aSk.a(paramf, false, true, 8);
        this.aSm = 2;
      }
      int i = this.aSl.el(this.aSn);
      c localc;
      switch (i)
      {
      default: 
        paramf = new o("Invalid element type ".concat(String.valueOf(i)));
        AppMethodBeat.o(92001);
        throw paramf;
      case 1: 
        l1 = paramf.getPosition();
        l2 = this.aSo;
        this.aSj.add(new a(this.aSn, l2 + l1, (byte)0));
        this.aSl.f(this.aSn, l1, this.aSo);
        this.aSm = 0;
        AppMethodBeat.o(92001);
        return true;
      case 2: 
        if (this.aSo > 8L)
        {
          paramf = new o("Invalid integer size: " + this.aSo);
          AppMethodBeat.o(92001);
          throw paramf;
        }
        this.aSl.i(this.aSn, a(paramf, (int)this.aSo));
        this.aSm = 0;
        AppMethodBeat.o(92001);
        return true;
      case 5: 
        if ((this.aSo != 4L) && (this.aSo != 8L))
        {
          paramf = new o("Invalid float size: " + this.aSo);
          AppMethodBeat.o(92001);
          throw paramf;
        }
        localc = this.aSl;
        i = this.aSn;
        j = (int)this.aSo;
        l1 = a(paramf, j);
        if (j == 4) {}
        for (double d = Float.intBitsToFloat((int)l1);; d = Double.longBitsToDouble(l1))
        {
          localc.b(i, d);
          this.aSm = 0;
          AppMethodBeat.o(92001);
          return true;
        }
      case 3: 
        if (this.aSo > 2147483647L)
        {
          paramf = new o("String element size: " + this.aSo);
          AppMethodBeat.o(92001);
          throw paramf;
        }
        localc = this.aSl;
        i = this.aSn;
        j = (int)this.aSo;
        if (j == 0) {}
        byte[] arrayOfByte;
        for (paramf = "";; paramf = new String(arrayOfByte))
        {
          localc.d(i, paramf);
          this.aSm = 0;
          AppMethodBeat.o(92001);
          return true;
          arrayOfByte = new byte[j];
          paramf.readFully(arrayOfByte, 0, j);
        }
      case 4: 
        this.aSl.a(this.aSn, (int)this.aSo, paramf);
        this.aSm = 0;
        AppMethodBeat.o(92001);
        return true;
      }
      paramf.ed((int)this.aSo);
      this.aSm = 0;
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(92000);
    this.aSm = 0;
    this.aSj.clear();
    this.aSk.reset();
    AppMethodBeat.o(92000);
  }
  
  static final class a
  {
    final int aSn;
    final long aSp;
    
    private a(int paramInt, long paramLong)
    {
      this.aSn = paramInt;
      this.aSp = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c.b.a
 * JD-Core Version:    0.7.0.1
 */