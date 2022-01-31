package a.j.b.a.c.e.b;

import a.j.b.a.c.g.d;
import a.j.b.a.c.g.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class b$g$a
  extends i.a<b.g, a>
  implements b.h
{
  private int Ckr;
  private List<b.g.b> CpJ;
  private List<Integer> CpK;
  
  private b$g$a()
  {
    AppMethodBeat.i(121237);
    this.CpJ = Collections.emptyList();
    this.CpK = Collections.emptyList();
    AppMethodBeat.o(121237);
  }
  
  /* Error */
  private a F(a.j.b.a.c.g.e parame, a.j.b.a.c.g.g paramg)
  {
    // Byte code:
    //   0: ldc 47
    //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore_3
    //   7: getstatic 51	a/j/b/a/c/e/b/b$g:Ckq	La/j/b/a/c/g/s;
    //   10: aload_1
    //   11: aload_2
    //   12: invokeinterface 56 3 0
    //   17: checkcast 9	a/j/b/a/c/e/b/b$g
    //   20: astore_1
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 60	a/j/b/a/c/e/b/b$g$a:d	(La/j/b/a/c/e/b/b$g;)La/j/b/a/c/e/b/b$g$a;
    //   26: pop
    //   27: ldc 47
    //   29: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: areturn
    //   34: astore_1
    //   35: aload_1
    //   36: getfield 64	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   39: checkcast 9	a/j/b/a/c/e/b/b$g
    //   42: astore_2
    //   43: ldc 47
    //   45: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aload_1
    //   49: athrow
    //   50: astore_1
    //   51: aload_2
    //   52: ifnull +9 -> 61
    //   55: aload_0
    //   56: aload_2
    //   57: invokevirtual 60	a/j/b/a/c/e/b/b$g$a:d	(La/j/b/a/c/e/b/b$g;)La/j/b/a/c/e/b/b$g$a;
    //   60: pop
    //   61: ldc 47
    //   63: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private a elD()
  {
    AppMethodBeat.i(121238);
    a locala = new a().d(elE());
    AppMethodBeat.o(121238);
    return locala;
  }
  
  private b.g elE()
  {
    AppMethodBeat.i(121239);
    b.g localg = new b.g(this, (byte)0);
    if ((this.Ckr & 0x1) == 1)
    {
      this.CpJ = Collections.unmodifiableList(this.CpJ);
      this.Ckr &= 0xFFFFFFFE;
    }
    b.g.a(localg, this.CpJ);
    if ((this.Ckr & 0x2) == 2)
    {
      this.CpK = Collections.unmodifiableList(this.CpK);
      this.Ckr &= 0xFFFFFFFD;
    }
    b.g.b(localg, this.CpK);
    AppMethodBeat.o(121239);
    return localg;
  }
  
  private void elF()
  {
    AppMethodBeat.i(121242);
    if ((this.Ckr & 0x1) != 1)
    {
      this.CpJ = new ArrayList(this.CpJ);
      this.Ckr |= 0x1;
    }
    AppMethodBeat.o(121242);
  }
  
  private void elG()
  {
    AppMethodBeat.i(121243);
    if ((this.Ckr & 0x2) != 2)
    {
      this.CpK = new ArrayList(this.CpK);
      this.Ckr |= 0x2;
    }
    AppMethodBeat.o(121243);
  }
  
  public final a d(b.g paramg)
  {
    AppMethodBeat.i(121240);
    if (paramg == b.g.elC())
    {
      AppMethodBeat.o(121240);
      return this;
    }
    if (!b.g.a(paramg).isEmpty())
    {
      if (this.CpJ.isEmpty())
      {
        this.CpJ = b.g.a(paramg);
        this.Ckr &= 0xFFFFFFFE;
      }
    }
    else if (!b.g.b(paramg).isEmpty())
    {
      if (!this.CpK.isEmpty()) {
        break label148;
      }
      this.CpK = b.g.b(paramg);
      this.Ckr &= 0xFFFFFFFD;
    }
    for (;;)
    {
      this.Ckp = this.Ckp.a(b.g.c(paramg));
      AppMethodBeat.o(121240);
      return this;
      elF();
      this.CpJ.addAll(b.g.a(paramg));
      break;
      label148:
      elG();
      this.CpK.addAll(b.g.b(paramg));
    }
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.c.e.b.b.g.a
 * JD-Core Version:    0.7.0.1
 */