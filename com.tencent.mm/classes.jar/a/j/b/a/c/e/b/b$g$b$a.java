package a.j.b.a.c.e.b;

import a.j.b.a.c.g.d;
import a.j.b.a.c.g.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class b$g$b$a
  extends i.a<b.g.b, a>
  implements b.g.c
{
  private int Ckr;
  private int CpN;
  private int CpO;
  private Object CpP;
  private b.g.b.b CpQ;
  private List<Integer> CpR;
  private List<Integer> CpT;
  
  private b$g$b$a()
  {
    AppMethodBeat.i(121255);
    this.CpN = 1;
    this.CpP = "";
    this.CpQ = b.g.b.b.CpV;
    this.CpR = Collections.emptyList();
    this.CpT = Collections.emptyList();
    AppMethodBeat.o(121255);
  }
  
  /* Error */
  private a G(a.j.b.a.c.g.e parame, a.j.b.a.c.g.g paramg)
  {
    // Byte code:
    //   0: ldc 65
    //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore_3
    //   7: getstatic 69	a/j/b/a/c/e/b/b$g$b:Ckq	La/j/b/a/c/g/s;
    //   10: aload_1
    //   11: aload_2
    //   12: invokeinterface 74 3 0
    //   17: checkcast 9	a/j/b/a/c/e/b/b$g$b
    //   20: astore_1
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 78	a/j/b/a/c/e/b/b$g$b$a:e	(La/j/b/a/c/e/b/b$g$b;)La/j/b/a/c/e/b/b$g$b$a;
    //   26: pop
    //   27: ldc 65
    //   29: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: areturn
    //   34: astore_1
    //   35: aload_1
    //   36: getfield 82	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   39: checkcast 9	a/j/b/a/c/e/b/b$g$b
    //   42: astore_2
    //   43: ldc 65
    //   45: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aload_1
    //   49: athrow
    //   50: astore_1
    //   51: aload_2
    //   52: ifnull +9 -> 61
    //   55: aload_0
    //   56: aload_2
    //   57: invokevirtual 78	a/j/b/a/c/e/b/b$g$b$a:e	(La/j/b/a/c/e/b/b$g$b;)La/j/b/a/c/e/b/b$g$b$a;
    //   60: pop
    //   61: ldc 65
    //   63: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   6	64	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	21	34	a/j/b/a/c/g/k
    //   43	50	50	finally
    //   7	21	68	finally
    //   35	43	68	finally
  }
  
  private a Vx(int paramInt)
  {
    this.Ckr |= 0x1;
    this.CpN = paramInt;
    return this;
  }
  
  private a Vy(int paramInt)
  {
    this.Ckr |= 0x2;
    this.CpO = paramInt;
    return this;
  }
  
  private a a(b.g.b.b paramb)
  {
    AppMethodBeat.i(121260);
    if (paramb == null)
    {
      paramb = new NullPointerException();
      AppMethodBeat.o(121260);
      throw paramb;
    }
    this.Ckr |= 0x8;
    this.CpQ = paramb;
    AppMethodBeat.o(121260);
    return this;
  }
  
  private a elQ()
  {
    AppMethodBeat.i(121256);
    a locala = new a().e(elR());
    AppMethodBeat.o(121256);
    return locala;
  }
  
  private b.g.b elR()
  {
    int j = 1;
    AppMethodBeat.i(121257);
    b.g.b localb = new b.g.b(this, (byte)0);
    int k = this.Ckr;
    if ((k & 0x1) == 1) {}
    for (;;)
    {
      b.g.b.a(localb, this.CpN);
      int i = j;
      if ((k & 0x2) == 2) {
        i = j | 0x2;
      }
      b.g.b.b(localb, this.CpO);
      j = i;
      if ((k & 0x4) == 4) {
        j = i | 0x4;
      }
      b.g.b.a(localb, this.CpP);
      i = j;
      if ((k & 0x8) == 8) {
        i = j | 0x8;
      }
      b.g.b.a(localb, this.CpQ);
      if ((this.Ckr & 0x10) == 16)
      {
        this.CpR = Collections.unmodifiableList(this.CpR);
        this.Ckr &= 0xFFFFFFEF;
      }
      b.g.b.a(localb, this.CpR);
      if ((this.Ckr & 0x20) == 32)
      {
        this.CpT = Collections.unmodifiableList(this.CpT);
        this.Ckr &= 0xFFFFFFDF;
      }
      b.g.b.b(localb, this.CpT);
      b.g.b.c(localb, i);
      AppMethodBeat.o(121257);
      return localb;
      j = 0;
    }
  }
  
  private void elS()
  {
    AppMethodBeat.i(121261);
    if ((this.Ckr & 0x10) != 16)
    {
      this.CpR = new ArrayList(this.CpR);
      this.Ckr |= 0x10;
    }
    AppMethodBeat.o(121261);
  }
  
  private void elT()
  {
    AppMethodBeat.i(121262);
    if ((this.Ckr & 0x20) != 32)
    {
      this.CpT = new ArrayList(this.CpT);
      this.Ckr |= 0x20;
    }
    AppMethodBeat.o(121262);
  }
  
  public final a e(b.g.b paramb)
  {
    AppMethodBeat.i(121258);
    if (paramb == b.g.b.elI())
    {
      AppMethodBeat.o(121258);
      return this;
    }
    if (paramb.elJ()) {
      Vx(paramb.CpN);
    }
    if (paramb.elK()) {
      Vy(paramb.CpO);
    }
    if (paramb.elL())
    {
      this.Ckr |= 0x4;
      this.CpP = b.g.b.a(paramb);
    }
    if (paramb.elN()) {
      a(paramb.CpQ);
    }
    if (!b.g.b.b(paramb).isEmpty())
    {
      if (this.CpR.isEmpty())
      {
        this.CpR = b.g.b.b(paramb);
        this.Ckr &= 0xFFFFFFEF;
      }
    }
    else if (!b.g.b.c(paramb).isEmpty())
    {
      if (!this.CpT.isEmpty()) {
        break label221;
      }
      this.CpT = b.g.b.c(paramb);
      this.Ckr &= 0xFFFFFFDF;
    }
    for (;;)
    {
      this.Ckp = this.Ckp.a(b.g.b.d(paramb));
      AppMethodBeat.o(121258);
      return this;
      elS();
      this.CpR.addAll(b.g.b.b(paramb));
      break;
      label221:
      elT();
      this.CpT.addAll(b.g.b.c(paramb));
    }
  }
  
  public final boolean isInitialized()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.c.e.b.b.g.b.a
 * JD-Core Version:    0.7.0.1
 */