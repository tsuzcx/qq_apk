package a.j.b.a.c.e;

import a.j.b.a.c.g.d;
import a.j.b.a.c.g.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a$m$a
  extends i.a<a.m, a>
  implements a.n
{
  private int CkK;
  private int Ckr;
  private int ClV;
  private a.m.b ClW;
  private a.aa ClX;
  private int ClY;
  private List<a.m> ClZ;
  private List<a.m> Cma;
  
  private a$m$a()
  {
    AppMethodBeat.i(120602);
    this.ClW = a.m.b.Cmb;
    this.ClX = a.aa.ejw();
    this.ClZ = Collections.emptyList();
    this.Cma = Collections.emptyList();
    AppMethodBeat.o(120602);
  }
  
  private a Uo(int paramInt)
  {
    this.Ckr |= 0x1;
    this.CkK = paramInt;
    return this;
  }
  
  private a Up(int paramInt)
  {
    this.Ckr |= 0x2;
    this.ClV = paramInt;
    return this;
  }
  
  private a Uq(int paramInt)
  {
    this.Ckr |= 0x10;
    this.ClY = paramInt;
    return this;
  }
  
  private a a(a.aa paramaa)
  {
    AppMethodBeat.i(120609);
    if (((this.Ckr & 0x8) == 8) && (this.ClX != a.aa.ejw())) {}
    for (this.ClX = a.aa.f(this.ClX).j(paramaa).ejS();; this.ClX = paramaa)
    {
      this.Ckr |= 0x8;
      AppMethodBeat.o(120609);
      return this;
    }
  }
  
  private a a(a.m.b paramb)
  {
    AppMethodBeat.i(120608);
    if (paramb == null)
    {
      paramb = new NullPointerException();
      AppMethodBeat.o(120608);
      throw paramb;
    }
    this.Ckr |= 0x4;
    this.ClW = paramb;
    AppMethodBeat.o(120608);
    return this;
  }
  
  private a eiE()
  {
    AppMethodBeat.i(120603);
    a locala = new a().f(eiF());
    AppMethodBeat.o(120603);
    return locala;
  }
  
  private void eiG()
  {
    AppMethodBeat.i(120610);
    if ((this.Ckr & 0x20) != 32)
    {
      this.ClZ = new ArrayList(this.ClZ);
      this.Ckr |= 0x20;
    }
    AppMethodBeat.o(120610);
  }
  
  private void eiH()
  {
    AppMethodBeat.i(120611);
    if ((this.Ckr & 0x40) != 64)
    {
      this.Cma = new ArrayList(this.Cma);
      this.Ckr |= 0x40;
    }
    AppMethodBeat.o(120611);
  }
  
  /* Error */
  private a l(a.j.b.a.c.g.e parame, a.j.b.a.c.g.g paramg)
  {
    // Byte code:
    //   0: ldc 121
    //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore_3
    //   7: getstatic 125	a/j/b/a/c/e/a$m:Ckq	La/j/b/a/c/g/s;
    //   10: aload_1
    //   11: aload_2
    //   12: invokeinterface 130 3 0
    //   17: checkcast 9	a/j/b/a/c/e/a$m
    //   20: astore_1
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 105	a/j/b/a/c/e/a$m$a:f	(La/j/b/a/c/e/a$m;)La/j/b/a/c/e/a$m$a;
    //   26: pop
    //   27: ldc 121
    //   29: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: areturn
    //   34: astore_1
    //   35: aload_1
    //   36: getfield 134	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   39: checkcast 9	a/j/b/a/c/e/a$m
    //   42: astore_2
    //   43: ldc 121
    //   45: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aload_1
    //   49: athrow
    //   50: astore_1
    //   51: aload_2
    //   52: ifnull +9 -> 61
    //   55: aload_0
    //   56: aload_2
    //   57: invokevirtual 105	a/j/b/a/c/e/a$m$a:f	(La/j/b/a/c/e/a$m;)La/j/b/a/c/e/a$m$a;
    //   60: pop
    //   61: ldc 121
    //   63: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final a.m eiF()
  {
    int j = 1;
    AppMethodBeat.i(120604);
    a.m localm = new a.m(this, (byte)0);
    int k = this.Ckr;
    if ((k & 0x1) == 1) {}
    for (;;)
    {
      a.m.a(localm, this.CkK);
      int i = j;
      if ((k & 0x2) == 2) {
        i = j | 0x2;
      }
      a.m.b(localm, this.ClV);
      j = i;
      if ((k & 0x4) == 4) {
        j = i | 0x4;
      }
      a.m.a(localm, this.ClW);
      i = j;
      if ((k & 0x8) == 8) {
        i = j | 0x8;
      }
      a.m.a(localm, this.ClX);
      j = i;
      if ((k & 0x10) == 16) {
        j = i | 0x10;
      }
      a.m.c(localm, this.ClY);
      if ((this.Ckr & 0x20) == 32)
      {
        this.ClZ = Collections.unmodifiableList(this.ClZ);
        this.Ckr &= 0xFFFFFFDF;
      }
      a.m.a(localm, this.ClZ);
      if ((this.Ckr & 0x40) == 64)
      {
        this.Cma = Collections.unmodifiableList(this.Cma);
        this.Ckr &= 0xFFFFFFBF;
      }
      a.m.b(localm, this.Cma);
      a.m.d(localm, j);
      AppMethodBeat.o(120604);
      return localm;
      j = 0;
    }
  }
  
  public final a f(a.m paramm)
  {
    AppMethodBeat.i(120605);
    if (paramm == a.m.eiz())
    {
      AppMethodBeat.o(120605);
      return this;
    }
    if (paramm.ehx()) {
      Uo(paramm.CkK);
    }
    if (paramm.eiA()) {
      Up(paramm.ClV);
    }
    if (paramm.eiB()) {
      a(paramm.ClW);
    }
    if (paramm.eiC()) {
      a(paramm.ClX);
    }
    if (paramm.eiD()) {
      Uq(paramm.ClY);
    }
    if (!a.m.c(paramm).isEmpty())
    {
      if (this.ClZ.isEmpty())
      {
        this.ClZ = a.m.c(paramm);
        this.Ckr &= 0xFFFFFFDF;
      }
    }
    else if (!a.m.d(paramm).isEmpty())
    {
      if (!this.Cma.isEmpty()) {
        break label228;
      }
      this.Cma = a.m.d(paramm);
      this.Ckr &= 0xFFFFFFBF;
    }
    for (;;)
    {
      this.Ckp = this.Ckp.a(a.m.e(paramm));
      AppMethodBeat.o(120605);
      return this;
      eiG();
      this.ClZ.addAll(a.m.c(paramm));
      break;
      label228:
      eiH();
      this.Cma.addAll(a.m.d(paramm));
    }
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(120606);
    if ((this.Ckr & 0x8) == 8) {}
    for (int i = 1; (i != 0) && (!this.ClX.isInitialized()); i = 0)
    {
      AppMethodBeat.o(120606);
      return false;
    }
    i = 0;
    while (i < this.ClZ.size())
    {
      if (!((a.m)this.ClZ.get(i)).isInitialized())
      {
        AppMethodBeat.o(120606);
        return false;
      }
      i += 1;
    }
    i = 0;
    while (i < this.Cma.size())
    {
      if (!((a.m)this.Cma.get(i)).isInitialized())
      {
        AppMethodBeat.o(120606);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(120606);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.e.a.m.a
 * JD-Core Version:    0.7.0.1
 */