package a.j.b.a.c.e.b;

import a.j.b.a.c.g.d;
import a.j.b.a.c.g.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b$c$a
  extends i.a<b.c, a>
  implements b.d
{
  private int Ckr;
  private int ClT;
  private int CpB;
  
  /* Error */
  private a D(a.j.b.a.c.g.e parame, a.j.b.a.c.g.g paramg)
  {
    // Byte code:
    //   0: ldc 24
    //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore_3
    //   7: getstatic 34	a/j/b/a/c/e/b/b$c:Ckq	La/j/b/a/c/g/s;
    //   10: aload_1
    //   11: aload_2
    //   12: invokeinterface 39 3 0
    //   17: checkcast 9	a/j/b/a/c/e/b/b$c
    //   20: astore_1
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 43	a/j/b/a/c/e/b/b$c$a:c	(La/j/b/a/c/e/b/b$c;)La/j/b/a/c/e/b/b$c$a;
    //   26: pop
    //   27: ldc 24
    //   29: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: areturn
    //   34: astore_1
    //   35: aload_1
    //   36: getfield 50	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   39: checkcast 9	a/j/b/a/c/e/b/b$c
    //   42: astore_2
    //   43: ldc 24
    //   45: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aload_1
    //   49: athrow
    //   50: astore_1
    //   51: aload_2
    //   52: ifnull +9 -> 61
    //   55: aload_0
    //   56: aload_2
    //   57: invokevirtual 43	a/j/b/a/c/e/b/b$c$a:c	(La/j/b/a/c/e/b/b$c;)La/j/b/a/c/e/b/b$c$a;
    //   60: pop
    //   61: ldc 24
    //   63: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private a Vv(int paramInt)
  {
    this.Ckr |= 0x1;
    this.ClT = paramInt;
    return this;
  }
  
  private a Vw(int paramInt)
  {
    this.Ckr |= 0x2;
    this.CpB = paramInt;
    return this;
  }
  
  private a elr()
  {
    AppMethodBeat.i(121187);
    a locala = new a().c(els());
    AppMethodBeat.o(121187);
    return locala;
  }
  
  public final a c(b.c paramc)
  {
    AppMethodBeat.i(121189);
    if (paramc == b.c.elp())
    {
      AppMethodBeat.o(121189);
      return this;
    }
    if (paramc.eiv()) {
      Vv(paramc.ClT);
    }
    if (paramc.elk()) {
      Vw(paramc.CpB);
    }
    this.Ckp = this.Ckp.a(b.c.b(paramc));
    AppMethodBeat.o(121189);
    return this;
  }
  
  public final b.c els()
  {
    int i = 1;
    AppMethodBeat.i(121188);
    b.c localc = new b.c(this, (byte)0);
    int k = this.Ckr;
    if ((k & 0x1) == 1) {}
    for (;;)
    {
      b.c.a(localc, this.ClT);
      int j = i;
      if ((k & 0x2) == 2) {
        j = i | 0x2;
      }
      b.c.b(localc, this.CpB);
      b.c.c(localc, j);
      AppMethodBeat.o(121188);
      return localc;
      i = 0;
    }
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.c.e.b.b.c.a
 * JD-Core Version:    0.7.0.1
 */