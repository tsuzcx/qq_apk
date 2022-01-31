package a.j.b.a.c.e;

import a.j.b.a.c.g.d;
import a.j.b.a.c.g.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a$w$a
  extends i.a<a.w, a>
  implements a.x
{
  private int Ckr;
  private List<a.w.b> CmC;
  
  private a$w$a()
  {
    AppMethodBeat.i(120741);
    this.CmC = Collections.emptyList();
    AppMethodBeat.o(120741);
  }
  
  private a ejg()
  {
    AppMethodBeat.i(120742);
    a locala = new a().d(ejh());
    AppMethodBeat.o(120742);
    return locala;
  }
  
  private void eji()
  {
    AppMethodBeat.i(120747);
    if ((this.Ckr & 0x1) != 1)
    {
      this.CmC = new ArrayList(this.CmC);
      this.Ckr |= 0x1;
    }
    AppMethodBeat.o(120747);
  }
  
  /* Error */
  private a p(a.j.b.a.c.g.e parame, a.j.b.a.c.g.g paramg)
  {
    // Byte code:
    //   0: ldc 66
    //   2: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore_3
    //   7: getstatic 70	a/j/b/a/c/e/a$w:Ckq	La/j/b/a/c/g/s;
    //   10: aload_1
    //   11: aload_2
    //   12: invokeinterface 75 3 0
    //   17: checkcast 9	a/j/b/a/c/e/a$w
    //   20: astore_1
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 50	a/j/b/a/c/e/a$w$a:d	(La/j/b/a/c/e/a$w;)La/j/b/a/c/e/a$w$a;
    //   26: pop
    //   27: ldc 66
    //   29: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: areturn
    //   34: astore_1
    //   35: aload_1
    //   36: getfield 79	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   39: checkcast 9	a/j/b/a/c/e/a$w
    //   42: astore_2
    //   43: ldc 66
    //   45: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aload_1
    //   49: athrow
    //   50: astore_1
    //   51: aload_2
    //   52: ifnull +9 -> 61
    //   55: aload_0
    //   56: aload_2
    //   57: invokevirtual 50	a/j/b/a/c/e/a$w$a:d	(La/j/b/a/c/e/a$w;)La/j/b/a/c/e/a$w$a;
    //   60: pop
    //   61: ldc 66
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
  
  public final a d(a.w paramw)
  {
    AppMethodBeat.i(120744);
    if (paramw == a.w.eje())
    {
      AppMethodBeat.o(120744);
      return this;
    }
    if (!a.w.b(paramw).isEmpty())
    {
      if (!this.CmC.isEmpty()) {
        break label84;
      }
      this.CmC = a.w.b(paramw);
      this.Ckr &= 0xFFFFFFFE;
    }
    for (;;)
    {
      this.Ckp = this.Ckp.a(a.w.c(paramw));
      AppMethodBeat.o(120744);
      return this;
      label84:
      eji();
      this.CmC.addAll(a.w.b(paramw));
    }
  }
  
  public final a.w ejh()
  {
    AppMethodBeat.i(120743);
    a.w localw = new a.w(this, (byte)0);
    if ((this.Ckr & 0x1) == 1)
    {
      this.CmC = Collections.unmodifiableList(this.CmC);
      this.Ckr &= 0xFFFFFFFE;
    }
    a.w.a(localw, this.CmC);
    AppMethodBeat.o(120743);
    return localw;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(120745);
    int i = 0;
    while (i < this.CmC.size())
    {
      if (!((a.w.b)this.CmC.get(i)).isInitialized())
      {
        AppMethodBeat.o(120745);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(120745);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     a.j.b.a.c.e.a.w.a
 * JD-Core Version:    0.7.0.1
 */