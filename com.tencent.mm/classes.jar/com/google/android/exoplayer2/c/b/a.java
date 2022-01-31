package com.google.android.exoplayer2.c.b;

import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Stack;

final class a
  implements b
{
  private final byte[] aCi;
  private final Stack<a> aCj;
  private final f aCk;
  private c aCl;
  private int aCm;
  private int aCn;
  private long aCo;
  
  a()
  {
    AppMethodBeat.i(94884);
    this.aCi = new byte[8];
    this.aCj = new Stack();
    this.aCk = new f();
    AppMethodBeat.o(94884);
  }
  
  private long a(com.google.android.exoplayer2.c.f paramf, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(94887);
    paramf.readFully(this.aCi, 0, paramInt);
    long l = 0L;
    while (i < paramInt)
    {
      l = l << 8 | this.aCi[i] & 0xFF;
      i += 1;
    }
    AppMethodBeat.o(94887);
    return l;
  }
  
  public final void a(c paramc)
  {
    this.aCl = paramc;
  }
  
  public final boolean c(com.google.android.exoplayer2.c.f paramf)
  {
    AppMethodBeat.i(94886);
    boolean bool;
    if (this.aCl != null)
    {
      bool = true;
      com.google.android.exoplayer2.i.a.checkState(bool);
    }
    for (;;)
    {
      if ((!this.aCj.isEmpty()) && (paramf.getPosition() >= ((a)this.aCj.peek()).aCp))
      {
        this.aCl.dq(((a)this.aCj.pop()).aCn);
        AppMethodBeat.o(94886);
        return true;
        bool = false;
        break;
      }
      long l2;
      long l1;
      int j;
      if (this.aCm == 0)
      {
        l2 = this.aCk.a(paramf, true, false, 4);
        l1 = l2;
        if (l2 == -2L) {
          paramf.nW();
        }
        for (;;)
        {
          paramf.b(this.aCi, 0, 4);
          i = f.dr(this.aCi[0]);
          if ((i != -1) && (i <= 4))
          {
            j = (int)f.b(this.aCi, i, false);
            if (this.aCl.dp(j))
            {
              paramf.dg(i);
              l1 = j;
              if (l1 != -1L) {
                break;
              }
              AppMethodBeat.o(94886);
              return false;
            }
          }
          paramf.dg(1);
        }
        this.aCn = ((int)l1);
        this.aCm = 1;
      }
      if (this.aCm == 1)
      {
        this.aCo = this.aCk.a(paramf, false, true, 8);
        this.aCm = 2;
      }
      int i = this.aCl.jdMethod_do(this.aCn);
      c localc;
      switch (i)
      {
      default: 
        paramf = new o("Invalid element type ".concat(String.valueOf(i)));
        AppMethodBeat.o(94886);
        throw paramf;
      case 1: 
        l1 = paramf.getPosition();
        l2 = this.aCo;
        this.aCj.add(new a(this.aCn, l2 + l1, (byte)0));
        this.aCl.e(this.aCn, l1, this.aCo);
        this.aCm = 0;
        AppMethodBeat.o(94886);
        return true;
      case 2: 
        if (this.aCo > 8L)
        {
          paramf = new o("Invalid integer size: " + this.aCo);
          AppMethodBeat.o(94886);
          throw paramf;
        }
        this.aCl.i(this.aCn, a(paramf, (int)this.aCo));
        this.aCm = 0;
        AppMethodBeat.o(94886);
        return true;
      case 5: 
        if ((this.aCo != 4L) && (this.aCo != 8L))
        {
          paramf = new o("Invalid float size: " + this.aCo);
          AppMethodBeat.o(94886);
          throw paramf;
        }
        localc = this.aCl;
        i = this.aCn;
        j = (int)this.aCo;
        l1 = a(paramf, j);
        if (j == 4) {}
        for (double d = Float.intBitsToFloat((int)l1);; d = Double.longBitsToDouble(l1))
        {
          localc.c(i, d);
          this.aCm = 0;
          AppMethodBeat.o(94886);
          return true;
        }
      case 3: 
        if (this.aCo > 2147483647L)
        {
          paramf = new o("String element size: " + this.aCo);
          AppMethodBeat.o(94886);
          throw paramf;
        }
        localc = this.aCl;
        i = this.aCn;
        j = (int)this.aCo;
        if (j == 0) {}
        byte[] arrayOfByte;
        for (paramf = "";; paramf = new String(arrayOfByte))
        {
          localc.d(i, paramf);
          this.aCm = 0;
          AppMethodBeat.o(94886);
          return true;
          arrayOfByte = new byte[j];
          paramf.readFully(arrayOfByte, 0, j);
        }
      case 4: 
        this.aCl.a(this.aCn, (int)this.aCo, paramf);
        this.aCm = 0;
        AppMethodBeat.o(94886);
        return true;
      }
      paramf.dg((int)this.aCo);
      this.aCm = 0;
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(94885);
    this.aCm = 0;
    this.aCj.clear();
    this.aCk.reset();
    AppMethodBeat.o(94885);
  }
  
  static final class a
  {
    final int aCn;
    final long aCp;
    
    private a(int paramInt, long paramLong)
    {
      this.aCn = paramInt;
      this.aCp = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.c.b.a
 * JD-Core Version:    0.7.0.1
 */