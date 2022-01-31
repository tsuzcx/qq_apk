package a.j.b.a.c.e;

import a.j.b.a.c.g.d;
import a.j.b.a.c.g.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a$g$a
  extends i.a<a.g, a>
  implements a.h
{
  private int Ckr;
  private List<a.i> ClE;
  
  private a$g$a()
  {
    AppMethodBeat.i(120514);
    this.ClE = Collections.emptyList();
    AppMethodBeat.o(120514);
  }
  
  private a eii()
  {
    AppMethodBeat.i(120515);
    a locala = new a().d(eij());
    AppMethodBeat.o(120515);
    return locala;
  }
  
  private void eik()
  {
    AppMethodBeat.i(120520);
    if ((this.Ckr & 0x1) != 1)
    {
      this.ClE = new ArrayList(this.ClE);
      this.Ckr |= 0x1;
    }
    AppMethodBeat.o(120520);
  }
  
  /* Error */
  private a i(a.j.b.a.c.g.e parame, a.j.b.a.c.g.g paramg)
  {
    // Byte code:
    //   0: ldc 65
    //   2: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore_3
    //   7: getstatic 69	a/j/b/a/c/e/a$g:Ckq	La/j/b/a/c/g/s;
    //   10: aload_1
    //   11: aload_2
    //   12: invokeinterface 74 3 0
    //   17: checkcast 9	a/j/b/a/c/e/a$g
    //   20: astore_1
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 50	a/j/b/a/c/e/a$g$a:d	(La/j/b/a/c/e/a$g;)La/j/b/a/c/e/a$g$a;
    //   26: pop
    //   27: ldc 65
    //   29: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: areturn
    //   34: astore_1
    //   35: aload_1
    //   36: getfield 78	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   39: checkcast 9	a/j/b/a/c/e/a$g
    //   42: astore_2
    //   43: ldc 65
    //   45: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aload_1
    //   49: athrow
    //   50: astore_1
    //   51: aload_2
    //   52: ifnull +9 -> 61
    //   55: aload_0
    //   56: aload_2
    //   57: invokevirtual 50	a/j/b/a/c/e/a$g$a:d	(La/j/b/a/c/e/a$g;)La/j/b/a/c/e/a$g$a;
    //   60: pop
    //   61: ldc 65
    //   63: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final a d(a.g paramg)
  {
    AppMethodBeat.i(120517);
    if (paramg == a.g.eig())
    {
      AppMethodBeat.o(120517);
      return this;
    }
    if (!a.g.b(paramg).isEmpty())
    {
      if (!this.ClE.isEmpty()) {
        break label84;
      }
      this.ClE = a.g.b(paramg);
      this.Ckr &= 0xFFFFFFFE;
    }
    for (;;)
    {
      this.Ckp = this.Ckp.a(a.g.c(paramg));
      AppMethodBeat.o(120517);
      return this;
      label84:
      eik();
      this.ClE.addAll(a.g.b(paramg));
    }
  }
  
  public final a.g eij()
  {
    AppMethodBeat.i(120516);
    a.g localg = new a.g(this, (byte)0);
    if ((this.Ckr & 0x1) == 1)
    {
      this.ClE = Collections.unmodifiableList(this.ClE);
      this.Ckr &= 0xFFFFFFFE;
    }
    a.g.a(localg, this.ClE);
    AppMethodBeat.o(120516);
    return localg;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(120518);
    int i = 0;
    while (i < this.ClE.size())
    {
      if (!((a.i)this.ClE.get(i)).isInitialized())
      {
        AppMethodBeat.o(120518);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(120518);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.e.a.g.a
 * JD-Core Version:    0.7.0.1
 */