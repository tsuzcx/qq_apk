package a.j.b.a.c.e.b;

import a.j.b.a.c.e.a.w;
import a.j.b.a.c.e.a.w.a;
import a.j.b.a.c.e.a.y;
import a.j.b.a.c.e.a.y.a;
import a.j.b.a.c.g.d;
import a.j.b.a.c.g.i.a;
import a.j.b.a.c.g.n;
import a.j.b.a.c.g.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a$a$a
  extends i.a<a.a, a>
  implements a.b
{
  private int Ckr;
  private List<a.j.b.a.c.e.a.a> Cno;
  private List<a.c> CoZ;
  private List<a.c> Cpa;
  private o Cpb;
  private a.y Cpc;
  private a.w Cpd;
  
  private a$a$a()
  {
    AppMethodBeat.i(121101);
    this.CoZ = Collections.emptyList();
    this.Cpa = Collections.emptyList();
    this.Cpb = n.CrT;
    this.Cpc = a.y.ejq();
    this.Cpd = a.w.eje();
    this.Cno = Collections.emptyList();
    AppMethodBeat.o(121101);
  }
  
  /* Error */
  private a A(a.j.b.a.c.g.e parame, a.j.b.a.c.g.g paramg)
  {
    // Byte code:
    //   0: ldc 79
    //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore_3
    //   7: getstatic 83	a/j/b/a/c/e/b/a$a:Ckq	La/j/b/a/c/g/s;
    //   10: aload_1
    //   11: aload_2
    //   12: invokeinterface 88 3 0
    //   17: checkcast 9	a/j/b/a/c/e/b/a$a
    //   20: astore_1
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 92	a/j/b/a/c/e/b/a$a$a:f	(La/j/b/a/c/e/b/a$a;)La/j/b/a/c/e/b/a$a$a;
    //   26: pop
    //   27: ldc 79
    //   29: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: areturn
    //   34: astore_1
    //   35: aload_1
    //   36: getfield 96	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   39: checkcast 9	a/j/b/a/c/e/b/a$a
    //   42: astore_2
    //   43: ldc 79
    //   45: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aload_1
    //   49: athrow
    //   50: astore_1
    //   51: aload_2
    //   52: ifnull +9 -> 61
    //   55: aload_0
    //   56: aload_2
    //   57: invokevirtual 92	a/j/b/a/c/e/b/a$a$a:f	(La/j/b/a/c/e/b/a$a;)La/j/b/a/c/e/b/a$a$a;
    //   60: pop
    //   61: ldc 79
    //   63: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private a e(a.w paramw)
  {
    AppMethodBeat.i(121111);
    if (((this.Ckr & 0x10) == 16) && (this.Cpd != a.w.eje())) {}
    for (this.Cpd = a.w.a(this.Cpd).d(paramw).ejh();; this.Cpd = paramw)
    {
      this.Ckr |= 0x10;
      AppMethodBeat.o(121111);
      return this;
    }
  }
  
  private a e(a.y paramy)
  {
    AppMethodBeat.i(121110);
    if (((this.Ckr & 0x8) == 8) && (this.Cpc != a.y.ejq())) {}
    for (this.Cpc = a.y.a(this.Cpc).d(paramy).ejt();; this.Cpc = paramy)
    {
      this.Ckr |= 0x8;
      AppMethodBeat.o(121110);
      return this;
    }
  }
  
  private a ekR()
  {
    AppMethodBeat.i(121102);
    a locala = new a().f(ekS());
    AppMethodBeat.o(121102);
    return locala;
  }
  
  private a.a ekS()
  {
    int i = 1;
    AppMethodBeat.i(121103);
    a.a locala = new a.a(this, (byte)0);
    int k = this.Ckr;
    if ((this.Ckr & 0x1) == 1)
    {
      this.CoZ = Collections.unmodifiableList(this.CoZ);
      this.Ckr &= 0xFFFFFFFE;
    }
    a.a.a(locala, this.CoZ);
    if ((this.Ckr & 0x2) == 2)
    {
      this.Cpa = Collections.unmodifiableList(this.Cpa);
      this.Ckr &= 0xFFFFFFFD;
    }
    a.a.b(locala, this.Cpa);
    if ((this.Ckr & 0x4) == 4)
    {
      this.Cpb = this.Cpb.emX();
      this.Ckr &= 0xFFFFFFFB;
    }
    a.a.a(locala, this.Cpb);
    if ((k & 0x8) == 8) {}
    for (;;)
    {
      a.a.a(locala, this.Cpc);
      int j = i;
      if ((k & 0x10) == 16) {
        j = i | 0x2;
      }
      a.a.a(locala, this.Cpd);
      if ((this.Ckr & 0x20) == 32)
      {
        this.Cno = Collections.unmodifiableList(this.Cno);
        this.Ckr &= 0xFFFFFFDF;
      }
      a.a.c(locala, this.Cno);
      a.a.a(locala, j);
      AppMethodBeat.o(121103);
      return locala;
      i = 0;
    }
  }
  
  private void ekT()
  {
    AppMethodBeat.i(121107);
    if ((this.Ckr & 0x1) != 1)
    {
      this.CoZ = new ArrayList(this.CoZ);
      this.Ckr |= 0x1;
    }
    AppMethodBeat.o(121107);
  }
  
  private void ekU()
  {
    AppMethodBeat.i(121108);
    if ((this.Ckr & 0x2) != 2)
    {
      this.Cpa = new ArrayList(this.Cpa);
      this.Ckr |= 0x2;
    }
    AppMethodBeat.o(121108);
  }
  
  private void ekV()
  {
    AppMethodBeat.i(121109);
    if ((this.Ckr & 0x4) != 4)
    {
      this.Cpb = new n(this.Cpb);
      this.Ckr |= 0x4;
    }
    AppMethodBeat.o(121109);
  }
  
  private void ekb()
  {
    AppMethodBeat.i(121112);
    if ((this.Ckr & 0x20) != 32)
    {
      this.Cno = new ArrayList(this.Cno);
      this.Ckr |= 0x20;
    }
    AppMethodBeat.o(121112);
  }
  
  public final a f(a.a parama)
  {
    AppMethodBeat.i(121104);
    if (parama == a.a.ekO())
    {
      AppMethodBeat.o(121104);
      return this;
    }
    if (!a.a.a(parama).isEmpty())
    {
      if (this.CoZ.isEmpty())
      {
        this.CoZ = a.a.a(parama);
        this.Ckr &= 0xFFFFFFFE;
      }
    }
    else
    {
      if (!a.a.b(parama).isEmpty())
      {
        if (!this.Cpa.isEmpty()) {
          break label266;
        }
        this.Cpa = a.a.b(parama);
        this.Ckr &= 0xFFFFFFFD;
      }
      label105:
      if (!a.a.c(parama).isEmpty())
      {
        if (!this.Cpb.isEmpty()) {
          break label287;
        }
        this.Cpb = a.a.c(parama);
        this.Ckr &= 0xFFFFFFFB;
      }
      label148:
      if (parama.ekP()) {
        e(parama.Cpc);
      }
      if (parama.ekQ()) {
        e(parama.Cpd);
      }
      if (!a.a.d(parama).isEmpty())
      {
        if (!this.Cno.isEmpty()) {
          break label308;
        }
        this.Cno = a.a.d(parama);
        this.Ckr &= 0xFFFFFFDF;
      }
    }
    for (;;)
    {
      this.Ckp = this.Ckp.a(a.a.e(parama));
      AppMethodBeat.o(121104);
      return this;
      ekT();
      this.CoZ.addAll(a.a.a(parama));
      break;
      label266:
      ekU();
      this.Cpa.addAll(a.a.b(parama));
      break label105;
      label287:
      ekV();
      this.Cpb.addAll(a.a.c(parama));
      break label148;
      label308:
      ekb();
      this.Cno.addAll(a.a.d(parama));
    }
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(121105);
    int i = 0;
    while (i < this.CoZ.size())
    {
      if (!((a.c)this.CoZ.get(i)).isInitialized())
      {
        AppMethodBeat.o(121105);
        return false;
      }
      i += 1;
    }
    i = 0;
    while (i < this.Cpa.size())
    {
      if (!((a.c)this.Cpa.get(i)).isInitialized())
      {
        AppMethodBeat.o(121105);
        return false;
      }
      i += 1;
    }
    if ((this.Ckr & 0x10) == 16) {}
    for (i = 1; (i != 0) && (!this.Cpd.isInitialized()); i = 0)
    {
      AppMethodBeat.o(121105);
      return false;
    }
    i = 0;
    while (i < this.Cno.size())
    {
      if (!((a.j.b.a.c.e.a.a)this.Cno.get(i)).isInitialized())
      {
        AppMethodBeat.o(121105);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(121105);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.e.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */