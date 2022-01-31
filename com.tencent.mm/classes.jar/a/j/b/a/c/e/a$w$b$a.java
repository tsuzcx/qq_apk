package a.j.b.a.c.e;

import a.j.b.a.c.g.d;
import a.j.b.a.c.g.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$w$b$a
  extends i.a<a.w.b, a>
  implements a.w.c
{
  private int Ckr;
  private int CmE = -1;
  private int CmF;
  private a.w.b.b CmG = a.w.b.b.CmI;
  
  private a UH(int paramInt)
  {
    this.Ckr |= 0x1;
    this.CmE = paramInt;
    return this;
  }
  
  private a UI(int paramInt)
  {
    this.Ckr |= 0x2;
    this.CmF = paramInt;
    return this;
  }
  
  private a a(a.w.b.b paramb)
  {
    AppMethodBeat.i(120763);
    if (paramb == null)
    {
      paramb = new NullPointerException();
      AppMethodBeat.o(120763);
      throw paramb;
    }
    this.Ckr |= 0x4;
    this.CmG = paramb;
    AppMethodBeat.o(120763);
    return this;
  }
  
  private a ejn()
  {
    AppMethodBeat.i(120759);
    a locala = new a().b(ejo());
    AppMethodBeat.o(120759);
    return locala;
  }
  
  private a.w.b ejo()
  {
    int j = 1;
    AppMethodBeat.i(120760);
    a.w.b localb = new a.w.b(this, (byte)0);
    int k = this.Ckr;
    if ((k & 0x1) == 1) {}
    for (;;)
    {
      a.w.b.a(localb, this.CmE);
      int i = j;
      if ((k & 0x2) == 2) {
        i = j | 0x2;
      }
      a.w.b.b(localb, this.CmF);
      j = i;
      if ((k & 0x4) == 4) {
        j = i | 0x4;
      }
      a.w.b.a(localb, this.CmG);
      a.w.b.c(localb, j);
      AppMethodBeat.o(120760);
      return localb;
      j = 0;
    }
  }
  
  /* Error */
  private a q(a.j.b.a.c.g.e parame, a.j.b.a.c.g.g paramg)
  {
    // Byte code:
    //   0: ldc 85
    //   2: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore_3
    //   7: getstatic 89	a/j/b/a/c/e/a$w$b:Ckq	La/j/b/a/c/g/s;
    //   10: aload_1
    //   11: aload_2
    //   12: invokeinterface 94 3 0
    //   17: checkcast 9	a/j/b/a/c/e/a$w$b
    //   20: astore_1
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 63	a/j/b/a/c/e/a$w$b$a:b	(La/j/b/a/c/e/a$w$b;)La/j/b/a/c/e/a$w$b$a;
    //   26: pop
    //   27: ldc 85
    //   29: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: areturn
    //   34: astore_1
    //   35: aload_1
    //   36: getfield 98	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   39: checkcast 9	a/j/b/a/c/e/a$w$b
    //   42: astore_2
    //   43: ldc 85
    //   45: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aload_1
    //   49: athrow
    //   50: astore_1
    //   51: aload_2
    //   52: ifnull +9 -> 61
    //   55: aload_0
    //   56: aload_2
    //   57: invokevirtual 63	a/j/b/a/c/e/a$w$b$a:b	(La/j/b/a/c/e/a$w$b;)La/j/b/a/c/e/a$w$b$a;
    //   60: pop
    //   61: ldc 85
    //   63: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final a b(a.w.b paramb)
  {
    AppMethodBeat.i(120761);
    if (paramb == a.w.b.ejk())
    {
      AppMethodBeat.o(120761);
      return this;
    }
    if (paramb.ejl()) {
      UH(paramb.CmE);
    }
    if (paramb.ejm()) {
      UI(paramb.CmF);
    }
    if (paramb.eip()) {
      a(paramb.CmG);
    }
    this.Ckp = this.Ckp.a(a.w.b.a(paramb));
    AppMethodBeat.o(120761);
    return this;
  }
  
  public final boolean isInitialized()
  {
    if ((this.Ckr & 0x2) == 2) {}
    for (int i = 1; i == 0; i = 0) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.c.e.a.w.b.a
 * JD-Core Version:    0.7.0.1
 */