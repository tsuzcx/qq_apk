package com.google.android.exoplayer2.c.b;

import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Stack;

final class a
  implements b
{
  private final byte[] cMe;
  private final Stack<a> cMf;
  private final f cMg;
  private c cMh;
  private int cMi;
  private int cMj;
  private long cMk;
  
  a()
  {
    AppMethodBeat.i(91999);
    this.cMe = new byte[8];
    this.cMf = new Stack();
    this.cMg = new f();
    AppMethodBeat.o(91999);
  }
  
  private long a(com.google.android.exoplayer2.c.f paramf, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(92002);
    paramf.readFully(this.cMe, 0, paramInt);
    long l = 0L;
    while (i < paramInt)
    {
      l = l << 8 | this.cMe[i] & 0xFF;
      i += 1;
    }
    AppMethodBeat.o(92002);
    return l;
  }
  
  public final void a(c paramc)
  {
    this.cMh = paramc;
  }
  
  public final boolean c(com.google.android.exoplayer2.c.f paramf)
  {
    AppMethodBeat.i(92001);
    boolean bool;
    if (this.cMh != null)
    {
      bool = true;
      com.google.android.exoplayer2.i.a.checkState(bool);
    }
    for (;;)
    {
      if ((!this.cMf.isEmpty()) && (paramf.getPosition() >= ((a)this.cMf.peek()).cMl))
      {
        this.cMh.hD(((a)this.cMf.pop()).cMj);
        AppMethodBeat.o(92001);
        return true;
        bool = false;
        break;
      }
      long l2;
      long l1;
      int j;
      if (this.cMi == 0)
      {
        l2 = this.cMg.a(paramf, true, false, 4);
        l1 = l2;
        if (l2 == -2L) {
          paramf.RS();
        }
        for (;;)
        {
          paramf.b(this.cMe, 0, 4);
          i = f.hE(this.cMe[0]);
          if ((i != -1) && (i <= 4))
          {
            j = (int)f.a(this.cMe, i, false);
            if (this.cMh.hC(j))
            {
              paramf.eP(i);
              l1 = j;
              if (l1 != -1L) {
                break;
              }
              AppMethodBeat.o(92001);
              return false;
            }
          }
          paramf.eP(1);
        }
        this.cMj = ((int)l1);
        this.cMi = 1;
      }
      if (this.cMi == 1)
      {
        this.cMk = this.cMg.a(paramf, false, true, 8);
        this.cMi = 2;
      }
      int i = this.cMh.hB(this.cMj);
      c localc;
      switch (i)
      {
      default: 
        paramf = new o("Invalid element type ".concat(String.valueOf(i)));
        AppMethodBeat.o(92001);
        throw paramf;
      case 1: 
        l1 = paramf.getPosition();
        l2 = this.cMk;
        this.cMf.add(new a(this.cMj, l2 + l1, (byte)0));
        this.cMh.f(this.cMj, l1, this.cMk);
        this.cMi = 0;
        AppMethodBeat.o(92001);
        return true;
      case 2: 
        if (this.cMk > 8L)
        {
          paramf = new o("Invalid integer size: " + this.cMk);
          AppMethodBeat.o(92001);
          throw paramf;
        }
        this.cMh.i(this.cMj, a(paramf, (int)this.cMk));
        this.cMi = 0;
        AppMethodBeat.o(92001);
        return true;
      case 5: 
        if ((this.cMk != 4L) && (this.cMk != 8L))
        {
          paramf = new o("Invalid float size: " + this.cMk);
          AppMethodBeat.o(92001);
          throw paramf;
        }
        localc = this.cMh;
        i = this.cMj;
        j = (int)this.cMk;
        l1 = a(paramf, j);
        if (j == 4) {}
        for (double d = Float.intBitsToFloat((int)l1);; d = Double.longBitsToDouble(l1))
        {
          localc.c(i, d);
          this.cMi = 0;
          AppMethodBeat.o(92001);
          return true;
        }
      case 3: 
        if (this.cMk > 2147483647L)
        {
          paramf = new o("String element size: " + this.cMk);
          AppMethodBeat.o(92001);
          throw paramf;
        }
        localc = this.cMh;
        i = this.cMj;
        j = (int)this.cMk;
        if (j == 0) {}
        byte[] arrayOfByte;
        for (paramf = "";; paramf = new String(arrayOfByte))
        {
          localc.e(i, paramf);
          this.cMi = 0;
          AppMethodBeat.o(92001);
          return true;
          arrayOfByte = new byte[j];
          paramf.readFully(arrayOfByte, 0, j);
        }
      case 4: 
        this.cMh.a(this.cMj, (int)this.cMk, paramf);
        this.cMi = 0;
        AppMethodBeat.o(92001);
        return true;
      }
      paramf.eP((int)this.cMk);
      this.cMi = 0;
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(92000);
    this.cMi = 0;
    this.cMf.clear();
    this.cMg.reset();
    AppMethodBeat.o(92000);
  }
  
  static final class a
  {
    final int cMj;
    final long cMl;
    
    private a(int paramInt, long paramLong)
    {
      this.cMj = paramInt;
      this.cMl = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.c.b.a
 * JD-Core Version:    0.7.0.1
 */