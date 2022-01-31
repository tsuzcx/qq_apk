package a.j.b.a.c.e;

import a.j.b.a.c.g.d;
import a.j.b.a.c.g.h;
import a.j.b.a.c.g.i.a;
import a.j.b.a.c.g.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a$o$a
  extends i.b<a.o, a>
  implements a.p
{
  private int CkK;
  private int Ckr;
  private List<a.ai> ClC;
  private int ClT;
  private List<a.ae> Cld;
  private a.ag Clq;
  private List<Integer> Clr;
  private int Cmg;
  private a.aa Cmh;
  private int Cmi;
  private a.aa Cmj;
  private int Cmk;
  private a.g Cml;
  
  private a$o$a()
  {
    AppMethodBeat.i(120636);
    this.CkK = 6;
    this.Cmg = 6;
    this.Cmh = a.aa.ejw();
    this.Cld = Collections.emptyList();
    this.Cmj = a.aa.ejw();
    this.ClC = Collections.emptyList();
    this.Clq = a.ag.ekl();
    this.Clr = Collections.emptyList();
    this.Cml = a.g.eig();
    AppMethodBeat.o(120636);
  }
  
  private a Us(int paramInt)
  {
    this.Ckr |= 0x1;
    this.CkK = paramInt;
    return this;
  }
  
  private a Ut(int paramInt)
  {
    this.Ckr |= 0x2;
    this.Cmg = paramInt;
    return this;
  }
  
  private a Uu(int paramInt)
  {
    this.Ckr |= 0x4;
    this.ClT = paramInt;
    return this;
  }
  
  private a Uv(int paramInt)
  {
    this.Ckr |= 0x10;
    this.Cmi = paramInt;
    return this;
  }
  
  private a Uw(int paramInt)
  {
    this.Ckr |= 0x80;
    this.Cmk = paramInt;
    return this;
  }
  
  private a b(a.aa paramaa)
  {
    AppMethodBeat.i(120642);
    if (((this.Ckr & 0x8) == 8) && (this.Cmh != a.aa.ejw())) {}
    for (this.Cmh = a.aa.f(this.Cmh).j(paramaa).ejS();; this.Cmh = paramaa)
    {
      this.Ckr |= 0x8;
      AppMethodBeat.o(120642);
      return this;
    }
  }
  
  private a b(a.ag paramag)
  {
    AppMethodBeat.i(120646);
    if (((this.Ckr & 0x200) == 512) && (this.Clq != a.ag.ekl())) {}
    for (this.Clq = a.ag.d(this.Clq).g(paramag).eko();; this.Clq = paramag)
    {
      this.Ckr |= 0x200;
      AppMethodBeat.o(120646);
      return this;
    }
  }
  
  private a c(a.aa paramaa)
  {
    AppMethodBeat.i(120644);
    if (((this.Ckr & 0x40) == 64) && (this.Cmj != a.aa.ejw())) {}
    for (this.Cmj = a.aa.f(this.Cmj).j(paramaa).ejS();; this.Cmj = paramaa)
    {
      this.Ckr |= 0x40;
      AppMethodBeat.o(120644);
      return this;
    }
  }
  
  private a e(a.g paramg)
  {
    AppMethodBeat.i(120648);
    if (((this.Ckr & 0x800) == 2048) && (this.Cml != a.g.eig())) {}
    for (this.Cml = a.g.a(this.Cml).d(paramg).eij();; this.Cml = paramg)
    {
      this.Ckr |= 0x800;
      AppMethodBeat.o(120648);
      return this;
    }
  }
  
  private void ehO()
  {
    AppMethodBeat.i(120643);
    if ((this.Ckr & 0x20) != 32)
    {
      this.Cld = new ArrayList(this.Cld);
      this.Ckr |= 0x20;
    }
    AppMethodBeat.o(120643);
  }
  
  private void ehY()
  {
    AppMethodBeat.i(120647);
    if ((this.Ckr & 0x400) != 1024)
    {
      this.Clr = new ArrayList(this.Clr);
      this.Ckr |= 0x400;
    }
    AppMethodBeat.o(120647);
  }
  
  private a eiQ()
  {
    AppMethodBeat.i(120637);
    a locala = new a().e(eiR());
    AppMethodBeat.o(120637);
    return locala;
  }
  
  private a.o eiR()
  {
    int j = 1;
    AppMethodBeat.i(120638);
    a.o localo = new a.o(this, (byte)0);
    int k = this.Ckr;
    if ((k & 0x1) == 1) {}
    for (;;)
    {
      a.o.a(localo, this.CkK);
      int i = j;
      if ((k & 0x2) == 2) {
        i = j | 0x2;
      }
      a.o.b(localo, this.Cmg);
      j = i;
      if ((k & 0x4) == 4) {
        j = i | 0x4;
      }
      a.o.c(localo, this.ClT);
      i = j;
      if ((k & 0x8) == 8) {
        i = j | 0x8;
      }
      a.o.a(localo, this.Cmh);
      j = i;
      if ((k & 0x10) == 16) {
        j = i | 0x10;
      }
      a.o.d(localo, this.Cmi);
      if ((this.Ckr & 0x20) == 32)
      {
        this.Cld = Collections.unmodifiableList(this.Cld);
        this.Ckr &= 0xFFFFFFDF;
      }
      a.o.a(localo, this.Cld);
      i = j;
      if ((k & 0x40) == 64) {
        i = j | 0x20;
      }
      a.o.b(localo, this.Cmj);
      j = i;
      if ((k & 0x80) == 128) {
        j = i | 0x40;
      }
      a.o.e(localo, this.Cmk);
      if ((this.Ckr & 0x100) == 256)
      {
        this.ClC = Collections.unmodifiableList(this.ClC);
        this.Ckr &= 0xFFFFFEFF;
      }
      a.o.b(localo, this.ClC);
      i = j;
      if ((k & 0x200) == 512) {
        i = j | 0x80;
      }
      a.o.a(localo, this.Clq);
      if ((this.Ckr & 0x400) == 1024)
      {
        this.Clr = Collections.unmodifiableList(this.Clr);
        this.Ckr &= 0xFFFFFBFF;
      }
      a.o.c(localo, this.Clr);
      j = i;
      if ((k & 0x800) == 2048) {
        j = i | 0x100;
      }
      a.o.a(localo, this.Cml);
      a.o.f(localo, j);
      AppMethodBeat.o(120638);
      return localo;
      j = 0;
    }
  }
  
  private void eie()
  {
    AppMethodBeat.i(120645);
    if ((this.Ckr & 0x100) != 256)
    {
      this.ClC = new ArrayList(this.ClC);
      this.Ckr |= 0x100;
    }
    AppMethodBeat.o(120645);
  }
  
  /* Error */
  private a m(a.j.b.a.c.g.e parame, a.j.b.a.c.g.g paramg)
  {
    // Byte code:
    //   0: ldc 214
    //   2: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore_3
    //   7: getstatic 218	a/j/b/a/c/e/a$o:Ckq	La/j/b/a/c/g/s;
    //   10: aload_1
    //   11: aload_2
    //   12: invokeinterface 223 3 0
    //   17: checkcast 9	a/j/b/a/c/e/a$o
    //   20: astore_1
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 166	a/j/b/a/c/e/a$o$a:e	(La/j/b/a/c/e/a$o;)La/j/b/a/c/e/a$o$a;
    //   26: pop
    //   27: ldc 214
    //   29: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: areturn
    //   34: astore_1
    //   35: aload_1
    //   36: getfield 227	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   39: checkcast 9	a/j/b/a/c/e/a$o
    //   42: astore_2
    //   43: ldc 214
    //   45: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aload_1
    //   49: athrow
    //   50: astore_1
    //   51: aload_2
    //   52: ifnull +9 -> 61
    //   55: aload_0
    //   56: aload_2
    //   57: invokevirtual 166	a/j/b/a/c/e/a$o$a:e	(La/j/b/a/c/e/a$o;)La/j/b/a/c/e/a$o$a;
    //   60: pop
    //   61: ldc 214
    //   63: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final a e(a.o paramo)
  {
    AppMethodBeat.i(120639);
    if (paramo == a.o.eiJ())
    {
      AppMethodBeat.o(120639);
      return this;
    }
    if (paramo.ehx()) {
      Us(paramo.CkK);
    }
    if (paramo.eiK()) {
      Ut(paramo.Cmg);
    }
    if (paramo.eiv()) {
      Uu(paramo.ClT);
    }
    if (paramo.eiL()) {
      b(paramo.Cmh);
    }
    if (paramo.eiM()) {
      Uv(paramo.Cmi);
    }
    if (!a.o.a(paramo).isEmpty())
    {
      if (this.Cld.isEmpty())
      {
        this.Cld = a.o.a(paramo);
        this.Ckr &= 0xFFFFFFDF;
      }
    }
    else
    {
      if (paramo.eiN()) {
        c(paramo.Cmj);
      }
      if (paramo.eiO()) {
        Uw(paramo.Cmk);
      }
      if (!a.o.b(paramo).isEmpty())
      {
        if (!this.ClC.isEmpty()) {
          break label342;
        }
        this.ClC = a.o.b(paramo);
        this.Ckr &= 0xFFFFFEFF;
      }
      label218:
      if (paramo.ehK()) {
        b(paramo.Clq);
      }
      if (!a.o.c(paramo).isEmpty())
      {
        if (!this.Clr.isEmpty()) {
          break label363;
        }
        this.Clr = a.o.c(paramo);
        this.Ckr &= 0xFFFFFBFF;
      }
    }
    for (;;)
    {
      if (paramo.eiP()) {
        e(paramo.Cml);
      }
      a(paramo);
      this.Ckp = this.Ckp.a(a.o.d(paramo));
      AppMethodBeat.o(120639);
      return this;
      ehO();
      this.Cld.addAll(a.o.a(paramo));
      break;
      label342:
      eie();
      this.ClC.addAll(a.o.b(paramo));
      break label218;
      label363:
      ehY();
      this.Clr.addAll(a.o.c(paramo));
    }
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(120640);
    if ((this.Ckr & 0x4) == 4) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(120640);
      return false;
    }
    if ((this.Ckr & 0x8) == 8) {}
    for (i = 1; (i != 0) && (!this.Cmh.isInitialized()); i = 0)
    {
      AppMethodBeat.o(120640);
      return false;
    }
    i = 0;
    while (i < this.Cld.size())
    {
      if (!((a.ae)this.Cld.get(i)).isInitialized())
      {
        AppMethodBeat.o(120640);
        return false;
      }
      i += 1;
    }
    if ((this.Ckr & 0x40) == 64) {}
    for (i = 1; (i != 0) && (!this.Cmj.isInitialized()); i = 0)
    {
      AppMethodBeat.o(120640);
      return false;
    }
    i = 0;
    while (i < this.ClC.size())
    {
      if (!((a.ai)this.ClC.get(i)).isInitialized())
      {
        AppMethodBeat.o(120640);
        return false;
      }
      i += 1;
    }
    if ((this.Ckr & 0x200) == 512) {}
    for (i = 1; (i != 0) && (!this.Clq.isInitialized()); i = 0)
    {
      AppMethodBeat.o(120640);
      return false;
    }
    if ((this.Ckr & 0x800) == 2048) {}
    for (i = 1; (i != 0) && (!this.Cml.isInitialized()); i = 0)
    {
      AppMethodBeat.o(120640);
      return false;
    }
    if (!this.Crw.isInitialized())
    {
      AppMethodBeat.o(120640);
      return false;
    }
    AppMethodBeat.o(120640);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.e.a.o.a
 * JD-Core Version:    0.7.0.1
 */