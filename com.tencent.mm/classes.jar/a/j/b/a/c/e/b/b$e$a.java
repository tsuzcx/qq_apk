package a.j.b.a.c.e.b;

import a.j.b.a.c.g.d;
import a.j.b.a.c.g.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b$e$a
  extends i.a<b.e, a>
  implements b.f
{
  private int Ckr;
  private b.a CpE;
  private b.c CpF;
  private b.c CpG;
  private b.c CpH;
  
  private b$e$a()
  {
    AppMethodBeat.i(121210);
    this.CpE = b.a.elj();
    this.CpF = b.c.elp();
    this.CpG = b.c.elp();
    this.CpH = b.c.elp();
    AppMethodBeat.o(121210);
  }
  
  /* Error */
  private a E(a.j.b.a.c.g.e parame, a.j.b.a.c.g.g paramg)
  {
    // Byte code:
    //   0: ldc 58
    //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore_3
    //   7: getstatic 62	a/j/b/a/c/e/b/b$e:Ckq	La/j/b/a/c/g/s;
    //   10: aload_1
    //   11: aload_2
    //   12: invokeinterface 67 3 0
    //   17: checkcast 9	a/j/b/a/c/e/b/b$e
    //   20: astore_1
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 71	a/j/b/a/c/e/b/b$e$a:b	(La/j/b/a/c/e/b/b$e;)La/j/b/a/c/e/b/b$e$a;
    //   26: pop
    //   27: ldc 58
    //   29: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: areturn
    //   34: astore_1
    //   35: aload_1
    //   36: getfield 75	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   39: checkcast 9	a/j/b/a/c/e/b/b$e
    //   42: astore_2
    //   43: ldc 58
    //   45: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aload_1
    //   49: athrow
    //   50: astore_1
    //   51: aload_2
    //   52: ifnull +9 -> 61
    //   55: aload_0
    //   56: aload_2
    //   57: invokevirtual 71	a/j/b/a/c/e/b/b$e$a:b	(La/j/b/a/c/e/b/b$e;)La/j/b/a/c/e/b/b$e$a;
    //   60: pop
    //   61: ldc 58
    //   63: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private a d(b.a parama)
  {
    AppMethodBeat.i(121215);
    if (((this.Ckr & 0x1) == 1) && (this.CpE != b.a.elj())) {}
    for (this.CpE = b.a.a(this.CpE).c(parama).eln();; this.CpE = parama)
    {
      this.Ckr |= 0x1;
      AppMethodBeat.o(121215);
      return this;
    }
  }
  
  private a d(b.c paramc)
  {
    AppMethodBeat.i(121216);
    if (((this.Ckr & 0x2) == 2) && (this.CpF != b.c.elp())) {}
    for (this.CpF = b.c.a(this.CpF).c(paramc).els();; this.CpF = paramc)
    {
      this.Ckr |= 0x2;
      AppMethodBeat.o(121216);
      return this;
    }
  }
  
  private a e(b.c paramc)
  {
    AppMethodBeat.i(121217);
    if (((this.Ckr & 0x4) == 4) && (this.CpG != b.c.elp())) {}
    for (this.CpG = b.c.a(this.CpG).c(paramc).els();; this.CpG = paramc)
    {
      this.Ckr |= 0x4;
      AppMethodBeat.o(121217);
      return this;
    }
  }
  
  private b.e elA()
  {
    int j = 1;
    AppMethodBeat.i(121212);
    b.e locale = new b.e(this, (byte)0);
    int k = this.Ckr;
    if ((k & 0x1) == 1) {}
    for (;;)
    {
      b.e.a(locale, this.CpE);
      int i = j;
      if ((k & 0x2) == 2) {
        i = j | 0x2;
      }
      b.e.a(locale, this.CpF);
      j = i;
      if ((k & 0x4) == 4) {
        j = i | 0x4;
      }
      b.e.b(locale, this.CpG);
      i = j;
      if ((k & 0x8) == 8) {
        i = j | 0x8;
      }
      b.e.c(locale, this.CpH);
      b.e.a(locale, i);
      AppMethodBeat.o(121212);
      return locale;
      j = 0;
    }
  }
  
  private a elz()
  {
    AppMethodBeat.i(121211);
    a locala = new a().b(elA());
    AppMethodBeat.o(121211);
    return locala;
  }
  
  private a f(b.c paramc)
  {
    AppMethodBeat.i(121218);
    if (((this.Ckr & 0x8) == 8) && (this.CpH != b.c.elp())) {}
    for (this.CpH = b.c.a(this.CpH).c(paramc).els();; this.CpH = paramc)
    {
      this.Ckr |= 0x8;
      AppMethodBeat.o(121218);
      return this;
    }
  }
  
  public final a b(b.e parame)
  {
    AppMethodBeat.i(121213);
    if (parame == b.e.elu())
    {
      AppMethodBeat.o(121213);
      return this;
    }
    if (parame.elv()) {
      d(parame.CpE);
    }
    if (parame.elw()) {
      d(parame.CpF);
    }
    if (parame.elx()) {
      e(parame.CpG);
    }
    if (parame.ely()) {
      f(parame.CpH);
    }
    this.Ckp = this.Ckp.a(b.e.a(parame));
    AppMethodBeat.o(121213);
    return this;
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     a.j.b.a.c.e.b.b.e.a
 * JD-Core Version:    0.7.0.1
 */