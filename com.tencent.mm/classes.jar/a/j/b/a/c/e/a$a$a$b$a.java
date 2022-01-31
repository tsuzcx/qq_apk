package a.j.b.a.c.e;

import a.j.b.a.c.g.d;
import a.j.b.a.c.g.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a$a$a$b$a
  extends i.a<a.a.a.b, a>
  implements a.a.a.c
{
  private a.a.a.b.b CkA;
  private long CkB;
  private float CkC;
  private double CkD;
  private int CkE;
  private int CkF;
  private int CkG;
  private a.a CkH;
  private List<a.a.a.b> CkI;
  private int CkJ;
  private int CkK;
  private int Ckr;
  
  private a$a$a$b$a()
  {
    AppMethodBeat.i(120373);
    this.CkA = a.a.a.b.b.CkL;
    this.CkH = a.a.egW();
    this.CkI = Collections.emptyList();
    AppMethodBeat.o(120373);
  }
  
  private a I(double paramDouble)
  {
    this.Ckr |= 0x8;
    this.CkD = paramDouble;
    return this;
  }
  
  private a TY(int paramInt)
  {
    this.Ckr |= 0x10;
    this.CkE = paramInt;
    return this;
  }
  
  private a TZ(int paramInt)
  {
    this.Ckr |= 0x20;
    this.CkF = paramInt;
    return this;
  }
  
  private a Ua(int paramInt)
  {
    this.Ckr |= 0x40;
    this.CkG = paramInt;
    return this;
  }
  
  private a Ub(int paramInt)
  {
    this.Ckr |= 0x200;
    this.CkJ = paramInt;
    return this;
  }
  
  private a Uc(int paramInt)
  {
    this.Ckr |= 0x400;
    this.CkK = paramInt;
    return this;
  }
  
  private a a(a.a.a.b.b paramb)
  {
    AppMethodBeat.i(120379);
    if (paramb == null)
    {
      paramb = new NullPointerException();
      AppMethodBeat.o(120379);
      throw paramb;
    }
    this.Ckr |= 0x1;
    this.CkA = paramb;
    AppMethodBeat.o(120379);
    return this;
  }
  
  private a bG(float paramFloat)
  {
    this.Ckr |= 0x4;
    this.CkC = paramFloat;
    return this;
  }
  
  private a d(a.a parama)
  {
    AppMethodBeat.i(120380);
    if (((this.Ckr & 0x80) == 128) && (this.CkH != a.a.egW())) {}
    for (this.CkH = a.a.a(this.CkH).e(parama).ehE();; this.CkH = parama)
    {
      this.Ckr |= 0x80;
      AppMethodBeat.o(120380);
      return this;
    }
  }
  
  /* Error */
  private a e(a.j.b.a.c.g.e parame, a.j.b.a.c.g.g paramg)
  {
    // Byte code:
    //   0: ldc 116
    //   2: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore_3
    //   7: getstatic 120	a/j/b/a/c/e/a$a$a$b:Ckq	La/j/b/a/c/g/s;
    //   10: aload_1
    //   11: aload_2
    //   12: invokeinterface 125 3 0
    //   17: checkcast 9	a/j/b/a/c/e/a$a$a$b
    //   20: astore_1
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 128	a/j/b/a/c/e/a$a$a$b$a:e	(La/j/b/a/c/e/a$a$a$b;)La/j/b/a/c/e/a$a$a$b$a;
    //   26: pop
    //   27: ldc 116
    //   29: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: areturn
    //   34: astore_1
    //   35: aload_1
    //   36: getfield 132	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   39: checkcast 9	a/j/b/a/c/e/a$a$a$b
    //   42: astore_2
    //   43: ldc 116
    //   45: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aload_1
    //   49: athrow
    //   50: astore_1
    //   51: aload_2
    //   52: ifnull +9 -> 61
    //   55: aload_0
    //   56: aload_2
    //   57: invokevirtual 128	a/j/b/a/c/e/a$a$a$b$a:e	(La/j/b/a/c/e/a$a$a$b;)La/j/b/a/c/e/a$a$a$b$a;
    //   60: pop
    //   61: ldc 116
    //   63: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aload_1
    //   67: athrow
    //   68: astore_1
    //   69: aload_3
    //   70: astore_2
    //   71: goto -20 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	a
    //   0	74	1	parame	a.j.b.a.c.g.e
    //   0	74	2	paramg	a.j.b.a.c.g.g
    //   6	64	3	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   7	21	34	a/j/b/a/c/g/k
    //   43	50	50	finally
    //   7	21	68	finally
    //   35	43	68	finally
  }
  
  private void ehA()
  {
    AppMethodBeat.i(120381);
    if ((this.Ckr & 0x100) != 256)
    {
      this.CkI = new ArrayList(this.CkI);
      this.Ckr |= 0x100;
    }
    AppMethodBeat.o(120381);
  }
  
  private a ehy()
  {
    AppMethodBeat.i(120374);
    a locala = new a().e(ehz());
    AppMethodBeat.o(120374);
    return locala;
  }
  
  private a po(long paramLong)
  {
    this.Ckr |= 0x2;
    this.CkB = paramLong;
    return this;
  }
  
  public final a e(a.a.a.b paramb)
  {
    AppMethodBeat.i(120376);
    if (paramb == a.a.a.b.ehn())
    {
      AppMethodBeat.o(120376);
      return this;
    }
    if (paramb.eho()) {
      a(paramb.CkA);
    }
    if (paramb.ehp()) {
      po(paramb.CkB);
    }
    if (paramb.ehq()) {
      bG(paramb.CkC);
    }
    if (paramb.ehr()) {
      I(paramb.CkD);
    }
    if (paramb.ehs()) {
      TY(paramb.CkE);
    }
    if (paramb.eht()) {
      TZ(paramb.CkF);
    }
    if (paramb.ehu()) {
      Ua(paramb.CkG);
    }
    if (paramb.ehv()) {
      d(paramb.CkH);
    }
    if (!a.a.a.b.c(paramb).isEmpty())
    {
      if (!this.CkI.isEmpty()) {
        break label245;
      }
      this.CkI = a.a.a.b.c(paramb);
      this.Ckr &= 0xFFFFFEFF;
    }
    for (;;)
    {
      if (paramb.ehw()) {
        Ub(paramb.CkJ);
      }
      if (paramb.ehx()) {
        Uc(paramb.CkK);
      }
      this.Ckp = this.Ckp.a(a.a.a.b.d(paramb));
      AppMethodBeat.o(120376);
      return this;
      label245:
      ehA();
      this.CkI.addAll(a.a.a.b.c(paramb));
    }
  }
  
  public final a.a.a.b ehz()
  {
    int j = 1;
    AppMethodBeat.i(120375);
    a.a.a.b localb = new a.a.a.b(this, (byte)0);
    int k = this.Ckr;
    if ((k & 0x1) == 1) {}
    for (;;)
    {
      a.a.a.b.a(localb, this.CkA);
      int i = j;
      if ((k & 0x2) == 2) {
        i = j | 0x2;
      }
      a.a.a.b.a(localb, this.CkB);
      j = i;
      if ((k & 0x4) == 4) {
        j = i | 0x4;
      }
      a.a.a.b.a(localb, this.CkC);
      i = j;
      if ((k & 0x8) == 8) {
        i = j | 0x8;
      }
      a.a.a.b.a(localb, this.CkD);
      j = i;
      if ((k & 0x10) == 16) {
        j = i | 0x10;
      }
      a.a.a.b.a(localb, this.CkE);
      i = j;
      if ((k & 0x20) == 32) {
        i = j | 0x20;
      }
      a.a.a.b.b(localb, this.CkF);
      j = i;
      if ((k & 0x40) == 64) {
        j = i | 0x40;
      }
      a.a.a.b.c(localb, this.CkG);
      i = j;
      if ((k & 0x80) == 128) {
        i = j | 0x80;
      }
      a.a.a.b.a(localb, this.CkH);
      if ((this.Ckr & 0x100) == 256)
      {
        this.CkI = Collections.unmodifiableList(this.CkI);
        this.Ckr &= 0xFFFFFEFF;
      }
      a.a.a.b.a(localb, this.CkI);
      j = i;
      if ((k & 0x200) == 512) {
        j = i | 0x100;
      }
      a.a.a.b.d(localb, this.CkJ);
      i = j;
      if ((k & 0x400) == 1024) {
        i = j | 0x200;
      }
      a.a.a.b.e(localb, this.CkK);
      a.a.a.b.f(localb, i);
      AppMethodBeat.o(120375);
      return localb;
      j = 0;
    }
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(120377);
    if ((this.Ckr & 0x80) == 128) {}
    for (int i = 1; (i != 0) && (!this.CkH.isInitialized()); i = 0)
    {
      AppMethodBeat.o(120377);
      return false;
    }
    i = 0;
    while (i < this.CkI.size())
    {
      if (!((a.a.a.b)this.CkI.get(i)).isInitialized())
      {
        AppMethodBeat.o(120377);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(120377);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.c.e.a.a.a.b.a
 * JD-Core Version:    0.7.0.1
 */