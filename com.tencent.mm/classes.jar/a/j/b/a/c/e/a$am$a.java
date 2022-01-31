package a.j.b.a.c.e;

import a.j.b.a.c.g.d;
import a.j.b.a.c.g.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a$am$a
  extends i.a<a.am, a>
  implements a.an
{
  private int Ckr;
  private List<a.ak> CnV;
  
  private a$am$a()
  {
    AppMethodBeat.i(121038);
    this.CnV = Collections.emptyList();
    AppMethodBeat.o(121038);
  }
  
  private a ekI()
  {
    AppMethodBeat.i(121039);
    a locala = new a().f(ekJ());
    AppMethodBeat.o(121039);
    return locala;
  }
  
  private void ekK()
  {
    AppMethodBeat.i(121043);
    if ((this.Ckr & 0x1) != 1)
    {
      this.CnV = new ArrayList(this.CnV);
      this.Ckr |= 0x1;
    }
    AppMethodBeat.o(121043);
  }
  
  /* Error */
  private a z(a.j.b.a.c.g.e parame, a.j.b.a.c.g.g paramg)
  {
    // Byte code:
    //   0: ldc 66
    //   2: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore_3
    //   7: getstatic 70	a/j/b/a/c/e/a$am:Ckq	La/j/b/a/c/g/s;
    //   10: aload_1
    //   11: aload_2
    //   12: invokeinterface 75 3 0
    //   17: checkcast 9	a/j/b/a/c/e/a$am
    //   20: astore_1
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 50	a/j/b/a/c/e/a$am$a:f	(La/j/b/a/c/e/a$am;)La/j/b/a/c/e/a$am$a;
    //   26: pop
    //   27: ldc 66
    //   29: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: areturn
    //   34: astore_1
    //   35: aload_1
    //   36: getfield 79	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   39: checkcast 9	a/j/b/a/c/e/a$am
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
    //   57: invokevirtual 50	a/j/b/a/c/e/a$am$a:f	(La/j/b/a/c/e/a$am;)La/j/b/a/c/e/a$am$a;
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
  
  public final a.am ekJ()
  {
    AppMethodBeat.i(121040);
    a.am localam = new a.am(this, (byte)0);
    if ((this.Ckr & 0x1) == 1)
    {
      this.CnV = Collections.unmodifiableList(this.CnV);
      this.Ckr &= 0xFFFFFFFE;
    }
    a.am.a(localam, this.CnV);
    AppMethodBeat.o(121040);
    return localam;
  }
  
  public final a f(a.am paramam)
  {
    AppMethodBeat.i(121041);
    if (paramam == a.am.ekH())
    {
      AppMethodBeat.o(121041);
      return this;
    }
    if (!a.am.d(paramam).isEmpty())
    {
      if (!this.CnV.isEmpty()) {
        break label84;
      }
      this.CnV = a.am.d(paramam);
      this.Ckr &= 0xFFFFFFFE;
    }
    for (;;)
    {
      this.Ckp = this.Ckp.a(a.am.e(paramam));
      AppMethodBeat.o(121041);
      return this;
      label84:
      ekK();
      this.CnV.addAll(a.am.d(paramam));
    }
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.c.e.a.am.a
 * JD-Core Version:    0.7.0.1
 */