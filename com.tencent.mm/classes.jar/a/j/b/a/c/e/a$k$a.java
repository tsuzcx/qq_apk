package a.j.b.a.c.e;

import a.j.b.a.c.g.d;
import a.j.b.a.c.g.h;
import a.j.b.a.c.g.i.a;
import a.j.b.a.c.g.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$k$a
  extends i.b<a.k, a>
  implements a.l
{
  private int Ckr;
  private int ClT;
  
  private a Un(int paramInt)
  {
    this.Ckr |= 0x1;
    this.ClT = paramInt;
    return this;
  }
  
  private a eiw()
  {
    AppMethodBeat.i(120578);
    a locala = new a().b(eix());
    AppMethodBeat.o(120578);
    return locala;
  }
  
  private a.k eix()
  {
    int i = 1;
    AppMethodBeat.i(120579);
    a.k localk = new a.k(this, (byte)0);
    if ((this.Ckr & 0x1) == 1) {}
    for (;;)
    {
      a.k.a(localk, this.ClT);
      a.k.b(localk, i);
      AppMethodBeat.o(120579);
      return localk;
      i = 0;
    }
  }
  
  /* Error */
  private a k(a.j.b.a.c.g.e parame, a.j.b.a.c.g.g paramg)
  {
    // Byte code:
    //   0: ldc 61
    //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore_3
    //   7: getstatic 65	a/j/b/a/c/e/a$k:Ckq	La/j/b/a/c/g/s;
    //   10: aload_1
    //   11: aload_2
    //   12: invokeinterface 70 3 0
    //   17: checkcast 9	a/j/b/a/c/e/a$k
    //   20: astore_1
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 42	a/j/b/a/c/e/a$k$a:b	(La/j/b/a/c/e/a$k;)La/j/b/a/c/e/a$k$a;
    //   26: pop
    //   27: ldc 61
    //   29: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: areturn
    //   34: astore_1
    //   35: aload_1
    //   36: getfield 74	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   39: checkcast 9	a/j/b/a/c/e/a$k
    //   42: astore_2
    //   43: ldc 61
    //   45: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aload_1
    //   49: athrow
    //   50: astore_1
    //   51: aload_2
    //   52: ifnull +9 -> 61
    //   55: aload_0
    //   56: aload_2
    //   57: invokevirtual 42	a/j/b/a/c/e/a$k$a:b	(La/j/b/a/c/e/a$k;)La/j/b/a/c/e/a$k$a;
    //   60: pop
    //   61: ldc 61
    //   63: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final a b(a.k paramk)
  {
    AppMethodBeat.i(120580);
    if (paramk == a.k.eiu())
    {
      AppMethodBeat.o(120580);
      return this;
    }
    if (paramk.eiv()) {
      Un(paramk.ClT);
    }
    a(paramk);
    this.Ckp = this.Ckp.a(a.k.a(paramk));
    AppMethodBeat.o(120580);
    return this;
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(120581);
    if (!this.Crw.isInitialized())
    {
      AppMethodBeat.o(120581);
      return false;
    }
    AppMethodBeat.o(120581);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.e.a.k.a
 * JD-Core Version:    0.7.0.1
 */