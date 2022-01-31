package a.j.b.a.c.e;

import a.j.b.a.c.g.d;
import a.j.b.a.c.g.h;
import a.j.b.a.c.g.i.a;
import a.j.b.a.c.g.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a$e$a
  extends i.b<a.e, a>
  implements a.f
{
  private int CkK;
  private int Ckr;
  private List<a.ai> ClC;
  private List<Integer> Clr;
  
  private a$e$a()
  {
    AppMethodBeat.i(120486);
    this.CkK = 6;
    this.ClC = Collections.emptyList();
    this.Clr = Collections.emptyList();
    AppMethodBeat.o(120486);
  }
  
  private a Uk(int paramInt)
  {
    this.Ckr |= 0x1;
    this.CkK = paramInt;
    return this;
  }
  
  private void ehY()
  {
    AppMethodBeat.i(120493);
    if ((this.Ckr & 0x4) != 4)
    {
      this.Clr = new ArrayList(this.Clr);
      this.Ckr |= 0x4;
    }
    AppMethodBeat.o(120493);
  }
  
  private a eic()
  {
    AppMethodBeat.i(120487);
    a locala = new a().d(eid());
    AppMethodBeat.o(120487);
    return locala;
  }
  
  private a.e eid()
  {
    int i = 1;
    AppMethodBeat.i(120488);
    a.e locale = new a.e(this, (byte)0);
    if ((this.Ckr & 0x1) == 1) {}
    for (;;)
    {
      a.e.a(locale, this.CkK);
      if ((this.Ckr & 0x2) == 2)
      {
        this.ClC = Collections.unmodifiableList(this.ClC);
        this.Ckr &= 0xFFFFFFFD;
      }
      a.e.a(locale, this.ClC);
      if ((this.Ckr & 0x4) == 4)
      {
        this.Clr = Collections.unmodifiableList(this.Clr);
        this.Ckr &= 0xFFFFFFFB;
      }
      a.e.b(locale, this.Clr);
      a.e.b(locale, i);
      AppMethodBeat.o(120488);
      return locale;
      i = 0;
    }
  }
  
  private void eie()
  {
    AppMethodBeat.i(120492);
    if ((this.Ckr & 0x2) != 2)
    {
      this.ClC = new ArrayList(this.ClC);
      this.Ckr |= 0x2;
    }
    AppMethodBeat.o(120492);
  }
  
  /* Error */
  private a h(a.j.b.a.c.g.e parame, a.j.b.a.c.g.g paramg)
  {
    // Byte code:
    //   0: ldc 96
    //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore_3
    //   7: getstatic 100	a/j/b/a/c/e/a$e:Ckq	La/j/b/a/c/g/s;
    //   10: aload_1
    //   11: aload_2
    //   12: invokeinterface 105 3 0
    //   17: checkcast 9	a/j/b/a/c/e/a$e
    //   20: astore_1
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 68	a/j/b/a/c/e/a$e$a:d	(La/j/b/a/c/e/a$e;)La/j/b/a/c/e/a$e$a;
    //   26: pop
    //   27: ldc 96
    //   29: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: areturn
    //   34: astore_1
    //   35: aload_1
    //   36: getfield 109	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   39: checkcast 9	a/j/b/a/c/e/a$e
    //   42: astore_2
    //   43: ldc 96
    //   45: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aload_1
    //   49: athrow
    //   50: astore_1
    //   51: aload_2
    //   52: ifnull +9 -> 61
    //   55: aload_0
    //   56: aload_2
    //   57: invokevirtual 68	a/j/b/a/c/e/a$e$a:d	(La/j/b/a/c/e/a$e;)La/j/b/a/c/e/a$e$a;
    //   60: pop
    //   61: ldc 96
    //   63: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final a d(a.e parame)
  {
    AppMethodBeat.i(120489);
    if (parame == a.e.eib())
    {
      AppMethodBeat.o(120489);
      return this;
    }
    if (parame.ehx()) {
      Uk(parame.CkK);
    }
    if (!a.e.a(parame).isEmpty())
    {
      if (this.ClC.isEmpty())
      {
        this.ClC = a.e.a(parame);
        this.Ckr &= 0xFFFFFFFD;
      }
    }
    else if (!a.e.b(parame).isEmpty())
    {
      if (!this.Clr.isEmpty()) {
        break label169;
      }
      this.Clr = a.e.b(parame);
      this.Ckr &= 0xFFFFFFFB;
    }
    for (;;)
    {
      a(parame);
      this.Ckp = this.Ckp.a(a.e.c(parame));
      AppMethodBeat.o(120489);
      return this;
      eie();
      this.ClC.addAll(a.e.a(parame));
      break;
      label169:
      ehY();
      this.Clr.addAll(a.e.b(parame));
    }
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(120490);
    int i = 0;
    while (i < this.ClC.size())
    {
      if (!((a.ai)this.ClC.get(i)).isInitialized())
      {
        AppMethodBeat.o(120490);
        return false;
      }
      i += 1;
    }
    if (!this.Crw.isInitialized())
    {
      AppMethodBeat.o(120490);
      return false;
    }
    AppMethodBeat.o(120490);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.e.a.e.a
 * JD-Core Version:    0.7.0.1
 */