package a.j.b.a.c.e.b;

import a.j.b.a.c.g.d;
import a.j.b.a.c.g.i.a;
import a.j.b.a.c.g.n;
import a.j.b.a.c.g.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a$c$a
  extends i.a<a.c, a>
  implements a.d
{
  private int Ckr;
  private Object Cpf;
  private o Cpg;
  private List<Integer> Cph;
  private o Cpj;
  private o Cpk;
  private List<Integer> Cpl;
  
  private a$c$a()
  {
    AppMethodBeat.i(121133);
    this.Cpf = "";
    this.Cpg = n.CrT;
    this.Cph = Collections.emptyList();
    this.Cpj = n.CrT;
    this.Cpk = n.CrT;
    this.Cpl = Collections.emptyList();
    AppMethodBeat.o(121133);
  }
  
  /* Error */
  private a B(a.j.b.a.c.g.e parame, a.j.b.a.c.g.g paramg)
  {
    // Byte code:
    //   0: ldc 67
    //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore_3
    //   7: getstatic 71	a/j/b/a/c/e/b/a$c:Ckq	La/j/b/a/c/g/s;
    //   10: aload_1
    //   11: aload_2
    //   12: invokeinterface 76 3 0
    //   17: checkcast 9	a/j/b/a/c/e/b/a$c
    //   20: astore_1
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 80	a/j/b/a/c/e/b/a$c$a:h	(La/j/b/a/c/e/b/a$c;)La/j/b/a/c/e/b/a$c$a;
    //   26: pop
    //   27: ldc 67
    //   29: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: areturn
    //   34: astore_1
    //   35: aload_1
    //   36: getfield 84	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   39: checkcast 9	a/j/b/a/c/e/b/a$c
    //   42: astore_2
    //   43: ldc 67
    //   45: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aload_1
    //   49: athrow
    //   50: astore_1
    //   51: aload_2
    //   52: ifnull +9 -> 61
    //   55: aload_0
    //   56: aload_2
    //   57: invokevirtual 80	a/j/b/a/c/e/b/a$c$a:h	(La/j/b/a/c/e/b/a$c;)La/j/b/a/c/e/b/a$c$a;
    //   60: pop
    //   61: ldc 67
    //   63: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private a elb()
  {
    AppMethodBeat.i(121134);
    a locala = new a().h(elc());
    AppMethodBeat.o(121134);
    return locala;
  }
  
  private a.c elc()
  {
    int i = 1;
    AppMethodBeat.i(121135);
    a.c localc = new a.c(this, (byte)0);
    if ((this.Ckr & 0x1) == 1) {}
    for (;;)
    {
      a.c.a(localc, this.Cpf);
      if ((this.Ckr & 0x2) == 2)
      {
        this.Cpg = this.Cpg.emX();
        this.Ckr &= 0xFFFFFFFD;
      }
      a.c.a(localc, this.Cpg);
      if ((this.Ckr & 0x4) == 4)
      {
        this.Cph = Collections.unmodifiableList(this.Cph);
        this.Ckr &= 0xFFFFFFFB;
      }
      a.c.a(localc, this.Cph);
      if ((this.Ckr & 0x8) == 8)
      {
        this.Cpj = this.Cpj.emX();
        this.Ckr &= 0xFFFFFFF7;
      }
      a.c.b(localc, this.Cpj);
      if ((this.Ckr & 0x10) == 16)
      {
        this.Cpk = this.Cpk.emX();
        this.Ckr &= 0xFFFFFFEF;
      }
      a.c.c(localc, this.Cpk);
      if ((this.Ckr & 0x20) == 32)
      {
        this.Cpl = Collections.unmodifiableList(this.Cpl);
        this.Ckr &= 0xFFFFFFDF;
      }
      a.c.b(localc, this.Cpl);
      a.c.a(localc, i);
      AppMethodBeat.o(121135);
      return localc;
      i = 0;
    }
  }
  
  private void eld()
  {
    AppMethodBeat.i(121138);
    if ((this.Ckr & 0x2) != 2)
    {
      this.Cpg = new n(this.Cpg);
      this.Ckr |= 0x2;
    }
    AppMethodBeat.o(121138);
  }
  
  private void ele()
  {
    AppMethodBeat.i(121139);
    if ((this.Ckr & 0x4) != 4)
    {
      this.Cph = new ArrayList(this.Cph);
      this.Ckr |= 0x4;
    }
    AppMethodBeat.o(121139);
  }
  
  private void elf()
  {
    AppMethodBeat.i(121140);
    if ((this.Ckr & 0x8) != 8)
    {
      this.Cpj = new n(this.Cpj);
      this.Ckr |= 0x8;
    }
    AppMethodBeat.o(121140);
  }
  
  private void elg()
  {
    AppMethodBeat.i(121141);
    if ((this.Ckr & 0x10) != 16)
    {
      this.Cpk = new n(this.Cpk);
      this.Ckr |= 0x10;
    }
    AppMethodBeat.o(121141);
  }
  
  private void elh()
  {
    AppMethodBeat.i(121142);
    if ((this.Ckr & 0x20) != 32)
    {
      this.Cpl = new ArrayList(this.Cpl);
      this.Ckr |= 0x20;
    }
    AppMethodBeat.o(121142);
  }
  
  public final a h(a.c paramc)
  {
    AppMethodBeat.i(121136);
    if (paramc == a.c.ekX())
    {
      AppMethodBeat.o(121136);
      return this;
    }
    if (paramc.ekY())
    {
      this.Ckr |= 0x1;
      this.Cpf = a.c.a(paramc);
    }
    if (!a.c.b(paramc).isEmpty())
    {
      if (this.Cpg.isEmpty())
      {
        this.Cpg = a.c.b(paramc);
        this.Ckr &= 0xFFFFFFFD;
      }
    }
    else
    {
      if (!a.c.c(paramc).isEmpty())
      {
        if (!this.Cph.isEmpty()) {
          break label302;
        }
        this.Cph = a.c.c(paramc);
        this.Ckr &= 0xFFFFFFFB;
      }
      label130:
      if (!a.c.d(paramc).isEmpty())
      {
        if (!this.Cpj.isEmpty()) {
          break label323;
        }
        this.Cpj = a.c.d(paramc);
        this.Ckr &= 0xFFFFFFF7;
      }
      label173:
      if (!a.c.e(paramc).isEmpty())
      {
        if (!this.Cpk.isEmpty()) {
          break label344;
        }
        this.Cpk = a.c.e(paramc);
        this.Ckr &= 0xFFFFFFEF;
      }
      label216:
      if (!a.c.f(paramc).isEmpty())
      {
        if (!this.Cpl.isEmpty()) {
          break label365;
        }
        this.Cpl = a.c.f(paramc);
        this.Ckr &= 0xFFFFFFDF;
      }
    }
    for (;;)
    {
      this.Ckp = this.Ckp.a(a.c.g(paramc));
      AppMethodBeat.o(121136);
      return this;
      eld();
      this.Cpg.addAll(a.c.b(paramc));
      break;
      label302:
      ele();
      this.Cph.addAll(a.c.c(paramc));
      break label130;
      label323:
      elf();
      this.Cpj.addAll(a.c.d(paramc));
      break label173;
      label344:
      elg();
      this.Cpk.addAll(a.c.e(paramc));
      break label216;
      label365:
      elh();
      this.Cpl.addAll(a.c.f(paramc));
    }
  }
  
  public final boolean isInitialized()
  {
    if ((this.Ckr & 0x1) == 1) {}
    for (int i = 1; i == 0; i = 0) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.c.e.b.a.c.a
 * JD-Core Version:    0.7.0.1
 */