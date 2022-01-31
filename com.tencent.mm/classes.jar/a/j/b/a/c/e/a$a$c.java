package a.j.b.a.c.e;

import a.j.b.a.c.g.d;
import a.j.b.a.c.g.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a$a$c
  extends i.a<a.a, c>
  implements a.b
{
  private int Ckr;
  private int Cks;
  private List<a.a.a> Ckt;
  
  private a$a$c()
  {
    AppMethodBeat.i(120413);
    this.Ckt = Collections.emptyList();
    AppMethodBeat.o(120413);
  }
  
  private c Uf(int paramInt)
  {
    this.Ckr |= 0x1;
    this.Cks = paramInt;
    return this;
  }
  
  private c ehD()
  {
    AppMethodBeat.i(120414);
    c localc = new c().e(ehE());
    AppMethodBeat.o(120414);
    return localc;
  }
  
  private void ehF()
  {
    AppMethodBeat.i(120419);
    if ((this.Ckr & 0x2) != 2)
    {
      this.Ckt = new ArrayList(this.Ckt);
      this.Ckr |= 0x2;
    }
    AppMethodBeat.o(120419);
  }
  
  /* Error */
  private c f(a.j.b.a.c.g.e parame, a.j.b.a.c.g.g paramg)
  {
    // Byte code:
    //   0: ldc 71
    //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore_3
    //   7: getstatic 75	a/j/b/a/c/e/a$a:Ckq	La/j/b/a/c/g/s;
    //   10: aload_1
    //   11: aload_2
    //   12: invokeinterface 81 3 0
    //   17: checkcast 9	a/j/b/a/c/e/a$a
    //   20: astore_1
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 57	a/j/b/a/c/e/a$a$c:e	(La/j/b/a/c/e/a$a;)La/j/b/a/c/e/a$a$c;
    //   26: pop
    //   27: ldc 71
    //   29: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: areturn
    //   34: astore_1
    //   35: aload_1
    //   36: getfield 85	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   39: checkcast 9	a/j/b/a/c/e/a$a
    //   42: astore_2
    //   43: ldc 71
    //   45: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aload_1
    //   49: athrow
    //   50: astore_1
    //   51: aload_2
    //   52: ifnull +9 -> 61
    //   55: aload_0
    //   56: aload_2
    //   57: invokevirtual 57	a/j/b/a/c/e/a$a$c:e	(La/j/b/a/c/e/a$a;)La/j/b/a/c/e/a$a$c;
    //   60: pop
    //   61: ldc 71
    //   63: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aload_1
    //   67: athrow
    //   68: astore_1
    //   69: aload_3
    //   70: astore_2
    //   71: goto -20 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	c
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
  
  public final c e(a.a parama)
  {
    AppMethodBeat.i(120416);
    if (parama == a.a.egW())
    {
      AppMethodBeat.o(120416);
      return this;
    }
    if (parama.egY()) {
      Uf(parama.Cks);
    }
    if (!a.a.b(parama).isEmpty())
    {
      if (!this.Ckt.isEmpty()) {
        break label100;
      }
      this.Ckt = a.a.b(parama);
      this.Ckr &= 0xFFFFFFFD;
    }
    for (;;)
    {
      this.Ckp = this.Ckp.a(a.a.c(parama));
      AppMethodBeat.o(120416);
      return this;
      label100:
      ehF();
      this.Ckt.addAll(a.a.b(parama));
    }
  }
  
  public final a.a ehE()
  {
    int i = 1;
    AppMethodBeat.i(120415);
    a.a locala = new a.a(this, (byte)0);
    if ((this.Ckr & 0x1) == 1) {}
    for (;;)
    {
      a.a.a(locala, this.Cks);
      if ((this.Ckr & 0x2) == 2)
      {
        this.Ckt = Collections.unmodifiableList(this.Ckt);
        this.Ckr &= 0xFFFFFFFD;
      }
      a.a.a(locala, this.Ckt);
      a.a.b(locala, i);
      AppMethodBeat.o(120415);
      return locala;
      i = 0;
    }
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(120417);
    if ((this.Ckr & 0x1) == 1) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(120417);
      return false;
    }
    i = 0;
    while (i < this.Ckt.size())
    {
      if (!((a.a.a)this.Ckt.get(i)).isInitialized())
      {
        AppMethodBeat.o(120417);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(120417);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.e.a.a.c
 * JD-Core Version:    0.7.0.1
 */