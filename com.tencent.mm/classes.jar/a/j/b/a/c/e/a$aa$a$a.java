package a.j.b.a.c.e;

import a.j.b.a.c.g.d;
import a.j.b.a.c.g.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$aa$a$a
  extends i.a<a.aa.a, a>
  implements a.aa.b
{
  private int Ckr;
  private a.aa.a.b Cnb;
  private a.aa Cnc;
  private int Cnd;
  
  private a$aa$a$a()
  {
    AppMethodBeat.i(120822);
    this.Cnb = a.aa.a.b.Cng;
    this.Cnc = a.aa.ejw();
    AppMethodBeat.o(120822);
  }
  
  private a UK(int paramInt)
  {
    this.Ckr |= 0x4;
    this.Cnd = paramInt;
    return this;
  }
  
  private a a(a.aa.a.b paramb)
  {
    AppMethodBeat.i(120828);
    if (paramb == null)
    {
      paramb = new NullPointerException();
      AppMethodBeat.o(120828);
      throw paramb;
    }
    this.Ckr |= 0x1;
    this.Cnb = paramb;
    AppMethodBeat.o(120828);
    return this;
  }
  
  private a ejN()
  {
    AppMethodBeat.i(120823);
    a locala = new a().b(ejO());
    AppMethodBeat.o(120823);
    return locala;
  }
  
  private a.aa.a ejO()
  {
    int j = 1;
    AppMethodBeat.i(120824);
    a.aa.a locala = new a.aa.a(this, (byte)0);
    int k = this.Ckr;
    if ((k & 0x1) == 1) {}
    for (;;)
    {
      a.aa.a.a(locala, this.Cnb);
      int i = j;
      if ((k & 0x2) == 2) {
        i = j | 0x2;
      }
      a.aa.a.a(locala, this.Cnc);
      j = i;
      if ((k & 0x4) == 4) {
        j = i | 0x4;
      }
      a.aa.a.a(locala, this.Cnd);
      a.aa.a.b(locala, j);
      AppMethodBeat.o(120824);
      return locala;
      j = 0;
    }
  }
  
  private a i(a.aa paramaa)
  {
    AppMethodBeat.i(120829);
    if (((this.Ckr & 0x2) == 2) && (this.Cnc != a.aa.ejw())) {}
    for (this.Cnc = a.aa.f(this.Cnc).j(paramaa).ejS();; this.Cnc = paramaa)
    {
      this.Ckr |= 0x2;
      AppMethodBeat.o(120829);
      return this;
    }
  }
  
  /* Error */
  private a s(a.j.b.a.c.g.e parame, a.j.b.a.c.g.g paramg)
  {
    // Byte code:
    //   0: ldc 106
    //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore_3
    //   7: getstatic 110	a/j/b/a/c/e/a$aa$a:Ckq	La/j/b/a/c/g/s;
    //   10: aload_1
    //   11: aload_2
    //   12: invokeinterface 115 3 0
    //   17: checkcast 9	a/j/b/a/c/e/a$aa$a
    //   20: astore_1
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 70	a/j/b/a/c/e/a$aa$a$a:b	(La/j/b/a/c/e/a$aa$a;)La/j/b/a/c/e/a$aa$a$a;
    //   26: pop
    //   27: ldc 106
    //   29: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: areturn
    //   34: astore_1
    //   35: aload_1
    //   36: getfield 119	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   39: checkcast 9	a/j/b/a/c/e/a$aa$a
    //   42: astore_2
    //   43: ldc 106
    //   45: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aload_1
    //   49: athrow
    //   50: astore_1
    //   51: aload_2
    //   52: ifnull +9 -> 61
    //   55: aload_0
    //   56: aload_2
    //   57: invokevirtual 70	a/j/b/a/c/e/a$aa$a$a:b	(La/j/b/a/c/e/a$aa$a;)La/j/b/a/c/e/a$aa$a$a;
    //   60: pop
    //   61: ldc 106
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
  
  public final a b(a.aa.a parama)
  {
    AppMethodBeat.i(120825);
    if (parama == a.aa.a.ejK())
    {
      AppMethodBeat.o(120825);
      return this;
    }
    if (parama.ejL()) {
      a(parama.Cnb);
    }
    if (parama.eho()) {
      i(parama.Cnc);
    }
    if (parama.ejM()) {
      UK(parama.Cnd);
    }
    this.Ckp = this.Ckp.a(a.aa.a.a(parama));
    AppMethodBeat.o(120825);
    return this;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(120826);
    if ((this.Ckr & 0x2) == 2) {}
    for (int i = 1; (i != 0) && (!this.Cnc.isInitialized()); i = 0)
    {
      AppMethodBeat.o(120826);
      return false;
    }
    AppMethodBeat.o(120826);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.e.a.aa.a.a
 * JD-Core Version:    0.7.0.1
 */