package a.j.b.a.c.e;

import a.j.b.a.c.g.d;
import a.j.b.a.c.g.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a$i$a
  extends i.a<a.i, a>
  implements a.j
{
  private int Ckr;
  private a.i.b ClG;
  private List<a.m> ClH;
  private a.m ClI;
  private a.i.c ClJ;
  
  private a$i$a()
  {
    AppMethodBeat.i(120541);
    this.ClG = a.i.b.ClK;
    this.ClH = Collections.emptyList();
    this.ClI = a.m.eiz();
    this.ClJ = a.i.c.ClO;
    AppMethodBeat.o(120541);
  }
  
  private a a(a.i.b paramb)
  {
    AppMethodBeat.i(120547);
    if (paramb == null)
    {
      paramb = new NullPointerException();
      AppMethodBeat.o(120547);
      throw paramb;
    }
    this.Ckr |= 0x1;
    this.ClG = paramb;
    AppMethodBeat.o(120547);
    return this;
  }
  
  private a a(a.i.c paramc)
  {
    AppMethodBeat.i(120550);
    if (paramc == null)
    {
      paramc = new NullPointerException();
      AppMethodBeat.o(120550);
      throw paramc;
    }
    this.Ckr |= 0x8;
    this.ClJ = paramc;
    AppMethodBeat.o(120550);
    return this;
  }
  
  private a a(a.m paramm)
  {
    AppMethodBeat.i(120549);
    if (((this.Ckr & 0x4) == 4) && (this.ClI != a.m.eiz())) {}
    for (this.ClI = a.m.b(this.ClI).f(paramm).eiF();; this.ClI = paramm)
    {
      this.Ckr |= 0x4;
      AppMethodBeat.o(120549);
      return this;
    }
  }
  
  private a eiq()
  {
    AppMethodBeat.i(120542);
    a locala = new a().c(eir());
    AppMethodBeat.o(120542);
    return locala;
  }
  
  private a.i eir()
  {
    int j = 1;
    AppMethodBeat.i(120543);
    a.i locali = new a.i(this, (byte)0);
    int k = this.Ckr;
    if ((k & 0x1) == 1) {}
    for (;;)
    {
      a.i.a(locali, this.ClG);
      if ((this.Ckr & 0x2) == 2)
      {
        this.ClH = Collections.unmodifiableList(this.ClH);
        this.Ckr &= 0xFFFFFFFD;
      }
      a.i.a(locali, this.ClH);
      int i = j;
      if ((k & 0x4) == 4) {
        i = j | 0x2;
      }
      a.i.a(locali, this.ClI);
      j = i;
      if ((k & 0x8) == 8) {
        j = i | 0x4;
      }
      a.i.a(locali, this.ClJ);
      a.i.a(locali, j);
      AppMethodBeat.o(120543);
      return locali;
      j = 0;
    }
  }
  
  private void eis()
  {
    AppMethodBeat.i(120548);
    if ((this.Ckr & 0x2) != 2)
    {
      this.ClH = new ArrayList(this.ClH);
      this.Ckr |= 0x2;
    }
    AppMethodBeat.o(120548);
  }
  
  /* Error */
  private a j(a.j.b.a.c.g.e parame, a.j.b.a.c.g.g paramg)
  {
    // Byte code:
    //   0: ldc 138
    //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore_3
    //   7: getstatic 142	a/j/b/a/c/e/a$i:Ckq	La/j/b/a/c/g/s;
    //   10: aload_1
    //   11: aload_2
    //   12: invokeinterface 147 3 0
    //   17: checkcast 9	a/j/b/a/c/e/a$i
    //   20: astore_1
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 101	a/j/b/a/c/e/a$i$a:c	(La/j/b/a/c/e/a$i;)La/j/b/a/c/e/a$i$a;
    //   26: pop
    //   27: ldc 138
    //   29: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: areturn
    //   34: astore_1
    //   35: aload_1
    //   36: getfield 151	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   39: checkcast 9	a/j/b/a/c/e/a$i
    //   42: astore_2
    //   43: ldc 138
    //   45: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aload_1
    //   49: athrow
    //   50: astore_1
    //   51: aload_2
    //   52: ifnull +9 -> 61
    //   55: aload_0
    //   56: aload_2
    //   57: invokevirtual 101	a/j/b/a/c/e/a$i$a:c	(La/j/b/a/c/e/a$i;)La/j/b/a/c/e/a$i$a;
    //   60: pop
    //   61: ldc 138
    //   63: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final a c(a.i parami)
  {
    AppMethodBeat.i(120544);
    if (parami == a.i.eim())
    {
      AppMethodBeat.o(120544);
      return this;
    }
    if (parami.ein()) {
      a(parami.ClG);
    }
    if (!a.i.a(parami).isEmpty())
    {
      if (!this.ClH.isEmpty()) {
        break label132;
      }
      this.ClH = a.i.a(parami);
      this.Ckr &= 0xFFFFFFFD;
    }
    for (;;)
    {
      if (parami.eio()) {
        a(parami.ClI);
      }
      if (parami.eip()) {
        a(parami.ClJ);
      }
      this.Ckp = this.Ckp.a(a.i.b(parami));
      AppMethodBeat.o(120544);
      return this;
      label132:
      eis();
      this.ClH.addAll(a.i.a(parami));
    }
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(120545);
    int i = 0;
    while (i < this.ClH.size())
    {
      if (!((a.m)this.ClH.get(i)).isInitialized())
      {
        AppMethodBeat.o(120545);
        return false;
      }
      i += 1;
    }
    if ((this.Ckr & 0x4) == 4) {}
    for (i = 1; (i != 0) && (!this.ClI.isInitialized()); i = 0)
    {
      AppMethodBeat.o(120545);
      return false;
    }
    AppMethodBeat.o(120545);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     a.j.b.a.c.e.a.i.a
 * JD-Core Version:    0.7.0.1
 */