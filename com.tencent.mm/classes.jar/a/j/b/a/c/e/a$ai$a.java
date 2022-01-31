package a.j.b.a.c.e;

import a.j.b.a.c.g.d;
import a.j.b.a.c.g.h;
import a.j.b.a.c.g.i.a;
import a.j.b.a.c.g.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$ai$a
  extends i.b<a.ai, a>
  implements a.aj
{
  private int CkK;
  private int Ckr;
  private int ClT;
  private a.aa CnD;
  private int CnE;
  private a.aa Cnc;
  private int Cnd;
  
  private a$ai$a()
  {
    AppMethodBeat.i(120978);
    this.Cnc = a.aa.ejw();
    this.CnD = a.aa.ejw();
    AppMethodBeat.o(120978);
  }
  
  private a Vd(int paramInt)
  {
    this.Ckr |= 0x1;
    this.CkK = paramInt;
    return this;
  }
  
  private a Ve(int paramInt)
  {
    this.Ckr |= 0x2;
    this.ClT = paramInt;
    return this;
  }
  
  private a Vf(int paramInt)
  {
    this.Ckr |= 0x8;
    this.Cnd = paramInt;
    return this;
  }
  
  private a Vg(int paramInt)
  {
    this.Ckr |= 0x20;
    this.CnE = paramInt;
    return this;
  }
  
  private a eku()
  {
    AppMethodBeat.i(120979);
    a locala = new a().d(ekv());
    AppMethodBeat.o(120979);
    return locala;
  }
  
  private a p(a.aa paramaa)
  {
    AppMethodBeat.i(120984);
    if (((this.Ckr & 0x4) == 4) && (this.Cnc != a.aa.ejw())) {}
    for (this.Cnc = a.aa.f(this.Cnc).j(paramaa).ejS();; this.Cnc = paramaa)
    {
      this.Ckr |= 0x4;
      AppMethodBeat.o(120984);
      return this;
    }
  }
  
  private a q(a.aa paramaa)
  {
    AppMethodBeat.i(120985);
    if (((this.Ckr & 0x10) == 16) && (this.CnD != a.aa.ejw())) {}
    for (this.CnD = a.aa.f(this.CnD).j(paramaa).ejS();; this.CnD = paramaa)
    {
      this.Ckr |= 0x10;
      AppMethodBeat.o(120985);
      return this;
    }
  }
  
  /* Error */
  private a x(a.j.b.a.c.g.e parame, a.j.b.a.c.g.g paramg)
  {
    // Byte code:
    //   0: ldc 95
    //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore_3
    //   7: getstatic 99	a/j/b/a/c/e/a$ai:Ckq	La/j/b/a/c/g/s;
    //   10: aload_1
    //   11: aload_2
    //   12: invokeinterface 104 3 0
    //   17: checkcast 9	a/j/b/a/c/e/a$ai
    //   20: astore_1
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 71	a/j/b/a/c/e/a$ai$a:d	(La/j/b/a/c/e/a$ai;)La/j/b/a/c/e/a$ai$a;
    //   26: pop
    //   27: ldc 95
    //   29: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: areturn
    //   34: astore_1
    //   35: aload_1
    //   36: getfield 108	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   39: checkcast 9	a/j/b/a/c/e/a$ai
    //   42: astore_2
    //   43: ldc 95
    //   45: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aload_1
    //   49: athrow
    //   50: astore_1
    //   51: aload_2
    //   52: ifnull +9 -> 61
    //   55: aload_0
    //   56: aload_2
    //   57: invokevirtual 71	a/j/b/a/c/e/a$ai$a:d	(La/j/b/a/c/e/a$ai;)La/j/b/a/c/e/a$ai$a;
    //   60: pop
    //   61: ldc 95
    //   63: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final a d(a.ai paramai)
  {
    AppMethodBeat.i(120981);
    if (paramai == a.ai.ekr())
    {
      AppMethodBeat.o(120981);
      return this;
    }
    if (paramai.ehx()) {
      Vd(paramai.CkK);
    }
    if (paramai.eiv()) {
      Ve(paramai.ClT);
    }
    if (paramai.eho()) {
      p(paramai.Cnc);
    }
    if (paramai.ejM()) {
      Vf(paramai.Cnd);
    }
    if (paramai.eks()) {
      q(paramai.CnD);
    }
    if (paramai.ekt()) {
      Vg(paramai.CnE);
    }
    a(paramai);
    this.Ckp = this.Ckp.a(a.ai.c(paramai));
    AppMethodBeat.o(120981);
    return this;
  }
  
  public final a.ai ekv()
  {
    int j = 1;
    AppMethodBeat.i(120980);
    a.ai localai = new a.ai(this, (byte)0);
    int k = this.Ckr;
    if ((k & 0x1) == 1) {}
    for (;;)
    {
      a.ai.a(localai, this.CkK);
      int i = j;
      if ((k & 0x2) == 2) {
        i = j | 0x2;
      }
      a.ai.b(localai, this.ClT);
      j = i;
      if ((k & 0x4) == 4) {
        j = i | 0x4;
      }
      a.ai.a(localai, this.Cnc);
      i = j;
      if ((k & 0x8) == 8) {
        i = j | 0x8;
      }
      a.ai.c(localai, this.Cnd);
      j = i;
      if ((k & 0x10) == 16) {
        j = i | 0x10;
      }
      a.ai.b(localai, this.CnD);
      i = j;
      if ((k & 0x20) == 32) {
        i = j | 0x20;
      }
      a.ai.d(localai, this.CnE);
      a.ai.e(localai, i);
      AppMethodBeat.o(120980);
      return localai;
      j = 0;
    }
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(120982);
    if ((this.Ckr & 0x2) == 2) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(120982);
      return false;
    }
    if ((this.Ckr & 0x4) == 4) {}
    for (i = 1; (i != 0) && (!this.Cnc.isInitialized()); i = 0)
    {
      AppMethodBeat.o(120982);
      return false;
    }
    if ((this.Ckr & 0x10) == 16) {}
    for (i = 1; (i != 0) && (!this.CnD.isInitialized()); i = 0)
    {
      AppMethodBeat.o(120982);
      return false;
    }
    if (!this.Crw.isInitialized())
    {
      AppMethodBeat.o(120982);
      return false;
    }
    AppMethodBeat.o(120982);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     a.j.b.a.c.e.a.ai.a
 * JD-Core Version:    0.7.0.1
 */