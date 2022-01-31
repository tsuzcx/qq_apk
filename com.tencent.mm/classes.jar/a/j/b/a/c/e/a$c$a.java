package a.j.b.a.c.e;

import a.j.b.a.c.g.d;
import a.j.b.a.c.g.h;
import a.j.b.a.c.g.i.a;
import a.j.b.a.c.g.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a$c$a
  extends i.b<a.c, a>
  implements a.d
{
  private int CkK;
  private int Ckr;
  private int Clb;
  private int Clc;
  private List<a.ae> Cld;
  private List<a.aa> Cle;
  private List<Integer> Clf;
  private List<Integer> Clh;
  private List<a.e> Clj;
  private List<a.o> Clk;
  private List<a.u> Cll;
  private List<a.ab> Clm;
  private List<a.k> Cln;
  private List<Integer> Clo;
  private a.ag Clq;
  private List<Integer> Clr;
  private a.am Cls;
  
  private a$c$a()
  {
    AppMethodBeat.i(120442);
    this.CkK = 6;
    this.Cld = Collections.emptyList();
    this.Cle = Collections.emptyList();
    this.Clf = Collections.emptyList();
    this.Clh = Collections.emptyList();
    this.Clj = Collections.emptyList();
    this.Clk = Collections.emptyList();
    this.Cll = Collections.emptyList();
    this.Clm = Collections.emptyList();
    this.Cln = Collections.emptyList();
    this.Clo = Collections.emptyList();
    this.Clq = a.ag.ekl();
    this.Clr = Collections.emptyList();
    this.Cls = a.am.ekH();
    AppMethodBeat.o(120442);
  }
  
  private a Ug(int paramInt)
  {
    this.Ckr |= 0x1;
    this.CkK = paramInt;
    return this;
  }
  
  private a Uh(int paramInt)
  {
    this.Ckr |= 0x2;
    this.Clb = paramInt;
    return this;
  }
  
  private a Ui(int paramInt)
  {
    this.Ckr |= 0x4;
    this.Clc = paramInt;
    return this;
  }
  
  private a a(a.ag paramag)
  {
    AppMethodBeat.i(120458);
    if (((this.Ckr & 0x2000) == 8192) && (this.Clq != a.ag.ekl())) {}
    for (this.Clq = a.ag.d(this.Clq).g(paramag).eko();; this.Clq = paramag)
    {
      this.Ckr |= 0x2000;
      AppMethodBeat.o(120458);
      return this;
    }
  }
  
  private a a(a.am paramam)
  {
    AppMethodBeat.i(120460);
    if (((this.Ckr & 0x8000) == 32768) && (this.Cls != a.am.ekH())) {}
    for (this.Cls = a.am.c(this.Cls).f(paramam).ekJ();; this.Cls = paramam)
    {
      this.Ckr |= 0x8000;
      AppMethodBeat.o(120460);
      return this;
    }
  }
  
  private a ehM()
  {
    AppMethodBeat.i(120443);
    a locala = new a().m(ehN());
    AppMethodBeat.o(120443);
    return locala;
  }
  
  private a.c ehN()
  {
    int j = 1;
    AppMethodBeat.i(120444);
    a.c localc = new a.c(this, (byte)0);
    int k = this.Ckr;
    if ((k & 0x1) == 1) {}
    for (;;)
    {
      a.c.a(localc, this.CkK);
      int i = j;
      if ((k & 0x2) == 2) {
        i = j | 0x2;
      }
      a.c.b(localc, this.Clb);
      j = i;
      if ((k & 0x4) == 4) {
        j = i | 0x4;
      }
      a.c.c(localc, this.Clc);
      if ((this.Ckr & 0x8) == 8)
      {
        this.Cld = Collections.unmodifiableList(this.Cld);
        this.Ckr &= 0xFFFFFFF7;
      }
      a.c.a(localc, this.Cld);
      if ((this.Ckr & 0x10) == 16)
      {
        this.Cle = Collections.unmodifiableList(this.Cle);
        this.Ckr &= 0xFFFFFFEF;
      }
      a.c.b(localc, this.Cle);
      if ((this.Ckr & 0x20) == 32)
      {
        this.Clf = Collections.unmodifiableList(this.Clf);
        this.Ckr &= 0xFFFFFFDF;
      }
      a.c.c(localc, this.Clf);
      if ((this.Ckr & 0x40) == 64)
      {
        this.Clh = Collections.unmodifiableList(this.Clh);
        this.Ckr &= 0xFFFFFFBF;
      }
      a.c.d(localc, this.Clh);
      if ((this.Ckr & 0x80) == 128)
      {
        this.Clj = Collections.unmodifiableList(this.Clj);
        this.Ckr &= 0xFFFFFF7F;
      }
      a.c.e(localc, this.Clj);
      if ((this.Ckr & 0x100) == 256)
      {
        this.Clk = Collections.unmodifiableList(this.Clk);
        this.Ckr &= 0xFFFFFEFF;
      }
      a.c.f(localc, this.Clk);
      if ((this.Ckr & 0x200) == 512)
      {
        this.Cll = Collections.unmodifiableList(this.Cll);
        this.Ckr &= 0xFFFFFDFF;
      }
      a.c.g(localc, this.Cll);
      if ((this.Ckr & 0x400) == 1024)
      {
        this.Clm = Collections.unmodifiableList(this.Clm);
        this.Ckr &= 0xFFFFFBFF;
      }
      a.c.h(localc, this.Clm);
      if ((this.Ckr & 0x800) == 2048)
      {
        this.Cln = Collections.unmodifiableList(this.Cln);
        this.Ckr &= 0xFFFFF7FF;
      }
      a.c.i(localc, this.Cln);
      if ((this.Ckr & 0x1000) == 4096)
      {
        this.Clo = Collections.unmodifiableList(this.Clo);
        this.Ckr &= 0xFFFFEFFF;
      }
      a.c.j(localc, this.Clo);
      i = j;
      if ((k & 0x2000) == 8192) {
        i = j | 0x8;
      }
      a.c.a(localc, this.Clq);
      if ((this.Ckr & 0x4000) == 16384)
      {
        this.Clr = Collections.unmodifiableList(this.Clr);
        this.Ckr &= 0xFFFFBFFF;
      }
      a.c.k(localc, this.Clr);
      j = i;
      if ((k & 0x8000) == 32768) {
        j = i | 0x10;
      }
      a.c.a(localc, this.Cls);
      a.c.d(localc, j);
      AppMethodBeat.o(120444);
      return localc;
      j = 0;
    }
  }
  
  private void ehO()
  {
    AppMethodBeat.i(120448);
    if ((this.Ckr & 0x8) != 8)
    {
      this.Cld = new ArrayList(this.Cld);
      this.Ckr |= 0x8;
    }
    AppMethodBeat.o(120448);
  }
  
  private void ehP()
  {
    AppMethodBeat.i(120449);
    if ((this.Ckr & 0x10) != 16)
    {
      this.Cle = new ArrayList(this.Cle);
      this.Ckr |= 0x10;
    }
    AppMethodBeat.o(120449);
  }
  
  private void ehQ()
  {
    AppMethodBeat.i(120450);
    if ((this.Ckr & 0x20) != 32)
    {
      this.Clf = new ArrayList(this.Clf);
      this.Ckr |= 0x20;
    }
    AppMethodBeat.o(120450);
  }
  
  private void ehR()
  {
    AppMethodBeat.i(120451);
    if ((this.Ckr & 0x40) != 64)
    {
      this.Clh = new ArrayList(this.Clh);
      this.Ckr |= 0x40;
    }
    AppMethodBeat.o(120451);
  }
  
  private void ehS()
  {
    AppMethodBeat.i(120452);
    if ((this.Ckr & 0x80) != 128)
    {
      this.Clj = new ArrayList(this.Clj);
      this.Ckr |= 0x80;
    }
    AppMethodBeat.o(120452);
  }
  
  private void ehT()
  {
    AppMethodBeat.i(120453);
    if ((this.Ckr & 0x100) != 256)
    {
      this.Clk = new ArrayList(this.Clk);
      this.Ckr |= 0x100;
    }
    AppMethodBeat.o(120453);
  }
  
  private void ehU()
  {
    AppMethodBeat.i(120454);
    if ((this.Ckr & 0x200) != 512)
    {
      this.Cll = new ArrayList(this.Cll);
      this.Ckr |= 0x200;
    }
    AppMethodBeat.o(120454);
  }
  
  private void ehV()
  {
    AppMethodBeat.i(120455);
    if ((this.Ckr & 0x400) != 1024)
    {
      this.Clm = new ArrayList(this.Clm);
      this.Ckr |= 0x400;
    }
    AppMethodBeat.o(120455);
  }
  
  private void ehW()
  {
    AppMethodBeat.i(120456);
    if ((this.Ckr & 0x800) != 2048)
    {
      this.Cln = new ArrayList(this.Cln);
      this.Ckr |= 0x800;
    }
    AppMethodBeat.o(120456);
  }
  
  private void ehX()
  {
    AppMethodBeat.i(120457);
    if ((this.Ckr & 0x1000) != 4096)
    {
      this.Clo = new ArrayList(this.Clo);
      this.Ckr |= 0x1000;
    }
    AppMethodBeat.o(120457);
  }
  
  private void ehY()
  {
    AppMethodBeat.i(120459);
    if ((this.Ckr & 0x4000) != 16384)
    {
      this.Clr = new ArrayList(this.Clr);
      this.Ckr |= 0x4000;
    }
    AppMethodBeat.o(120459);
  }
  
  /* Error */
  private a g(a.j.b.a.c.g.e parame, a.j.b.a.c.g.g paramg)
  {
    // Byte code:
    //   0: ldc 235
    //   2: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore_3
    //   7: getstatic 239	a/j/b/a/c/e/a$c:Ckq	La/j/b/a/c/g/s;
    //   10: aload_1
    //   11: aload_2
    //   12: invokeinterface 244 3 0
    //   17: checkcast 9	a/j/b/a/c/e/a$c
    //   20: astore_1
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 151	a/j/b/a/c/e/a$c$a:m	(La/j/b/a/c/e/a$c;)La/j/b/a/c/e/a$c$a;
    //   26: pop
    //   27: ldc 235
    //   29: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: areturn
    //   34: astore_1
    //   35: aload_1
    //   36: getfield 248	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   39: checkcast 9	a/j/b/a/c/e/a$c
    //   42: astore_2
    //   43: ldc 235
    //   45: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aload_1
    //   49: athrow
    //   50: astore_1
    //   51: aload_2
    //   52: ifnull +9 -> 61
    //   55: aload_0
    //   56: aload_2
    //   57: invokevirtual 151	a/j/b/a/c/e/a$c$a:m	(La/j/b/a/c/e/a$c;)La/j/b/a/c/e/a$c$a;
    //   60: pop
    //   61: ldc 235
    //   63: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(120446);
    if ((this.Ckr & 0x2) == 2) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(120446);
      return false;
    }
    i = 0;
    while (i < this.Cld.size())
    {
      if (!((a.ae)this.Cld.get(i)).isInitialized())
      {
        AppMethodBeat.o(120446);
        return false;
      }
      i += 1;
    }
    i = 0;
    while (i < this.Cle.size())
    {
      if (!((a.aa)this.Cle.get(i)).isInitialized())
      {
        AppMethodBeat.o(120446);
        return false;
      }
      i += 1;
    }
    i = 0;
    while (i < this.Clj.size())
    {
      if (!((a.e)this.Clj.get(i)).isInitialized())
      {
        AppMethodBeat.o(120446);
        return false;
      }
      i += 1;
    }
    i = 0;
    while (i < this.Clk.size())
    {
      if (!((a.o)this.Clk.get(i)).isInitialized())
      {
        AppMethodBeat.o(120446);
        return false;
      }
      i += 1;
    }
    i = 0;
    while (i < this.Cll.size())
    {
      if (!((a.u)this.Cll.get(i)).isInitialized())
      {
        AppMethodBeat.o(120446);
        return false;
      }
      i += 1;
    }
    i = 0;
    while (i < this.Clm.size())
    {
      if (!((a.ab)this.Clm.get(i)).isInitialized())
      {
        AppMethodBeat.o(120446);
        return false;
      }
      i += 1;
    }
    i = 0;
    while (i < this.Cln.size())
    {
      if (!((a.k)this.Cln.get(i)).isInitialized())
      {
        AppMethodBeat.o(120446);
        return false;
      }
      i += 1;
    }
    if ((this.Ckr & 0x2000) == 8192) {}
    for (i = 1; (i != 0) && (!this.Clq.isInitialized()); i = 0)
    {
      AppMethodBeat.o(120446);
      return false;
    }
    if (!this.Crw.isInitialized())
    {
      AppMethodBeat.o(120446);
      return false;
    }
    AppMethodBeat.o(120446);
    return true;
  }
  
  public final a m(a.c paramc)
  {
    AppMethodBeat.i(120445);
    if (paramc == a.c.ehH())
    {
      AppMethodBeat.o(120445);
      return this;
    }
    if (paramc.ehx()) {
      Ug(paramc.CkK);
    }
    if (paramc.ehI()) {
      Uh(paramc.Clb);
    }
    if (paramc.ehJ()) {
      Ui(paramc.Clc);
    }
    if (!a.c.a(paramc).isEmpty())
    {
      if (this.Cld.isEmpty())
      {
        this.Cld = a.c.a(paramc);
        this.Ckr &= 0xFFFFFFF7;
      }
    }
    else
    {
      if (!a.c.b(paramc).isEmpty())
      {
        if (!this.Cle.isEmpty()) {
          break label630;
        }
        this.Cle = a.c.b(paramc);
        this.Ckr &= 0xFFFFFFEF;
      }
      label155:
      if (!a.c.c(paramc).isEmpty())
      {
        if (!this.Clf.isEmpty()) {
          break label651;
        }
        this.Clf = a.c.c(paramc);
        this.Ckr &= 0xFFFFFFDF;
      }
      label198:
      if (!a.c.d(paramc).isEmpty())
      {
        if (!this.Clh.isEmpty()) {
          break label672;
        }
        this.Clh = a.c.d(paramc);
        this.Ckr &= 0xFFFFFFBF;
      }
      label241:
      if (!a.c.e(paramc).isEmpty())
      {
        if (!this.Clj.isEmpty()) {
          break label693;
        }
        this.Clj = a.c.e(paramc);
        this.Ckr &= 0xFFFFFF7F;
      }
      label285:
      if (!a.c.f(paramc).isEmpty())
      {
        if (!this.Clk.isEmpty()) {
          break label714;
        }
        this.Clk = a.c.f(paramc);
        this.Ckr &= 0xFFFFFEFF;
      }
      label329:
      if (!a.c.g(paramc).isEmpty())
      {
        if (!this.Cll.isEmpty()) {
          break label735;
        }
        this.Cll = a.c.g(paramc);
        this.Ckr &= 0xFFFFFDFF;
      }
      label373:
      if (!a.c.h(paramc).isEmpty())
      {
        if (!this.Clm.isEmpty()) {
          break label756;
        }
        this.Clm = a.c.h(paramc);
        this.Ckr &= 0xFFFFFBFF;
      }
      label417:
      if (!a.c.i(paramc).isEmpty())
      {
        if (!this.Cln.isEmpty()) {
          break label777;
        }
        this.Cln = a.c.i(paramc);
        this.Ckr &= 0xFFFFF7FF;
      }
      label461:
      if (!a.c.j(paramc).isEmpty())
      {
        if (!this.Clo.isEmpty()) {
          break label798;
        }
        this.Clo = a.c.j(paramc);
        this.Ckr &= 0xFFFFEFFF;
      }
      label505:
      if (paramc.ehK()) {
        a(paramc.Clq);
      }
      if (!a.c.k(paramc).isEmpty())
      {
        if (!this.Clr.isEmpty()) {
          break label819;
        }
        this.Clr = a.c.k(paramc);
        this.Ckr &= 0xFFFFBFFF;
      }
    }
    for (;;)
    {
      if (paramc.ehL()) {
        a(paramc.Cls);
      }
      a(paramc);
      this.Ckp = this.Ckp.a(a.c.l(paramc));
      AppMethodBeat.o(120445);
      return this;
      ehO();
      this.Cld.addAll(a.c.a(paramc));
      break;
      label630:
      ehP();
      this.Cle.addAll(a.c.b(paramc));
      break label155;
      label651:
      ehQ();
      this.Clf.addAll(a.c.c(paramc));
      break label198;
      label672:
      ehR();
      this.Clh.addAll(a.c.d(paramc));
      break label241;
      label693:
      ehS();
      this.Clj.addAll(a.c.e(paramc));
      break label285;
      label714:
      ehT();
      this.Clk.addAll(a.c.f(paramc));
      break label329;
      label735:
      ehU();
      this.Cll.addAll(a.c.g(paramc));
      break label373;
      label756:
      ehV();
      this.Clm.addAll(a.c.h(paramc));
      break label417;
      label777:
      ehW();
      this.Cln.addAll(a.c.i(paramc));
      break label461;
      label798:
      ehX();
      this.Clo.addAll(a.c.j(paramc));
      break label505;
      label819:
      ehY();
      this.Clr.addAll(a.c.k(paramc));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.c.e.a.c.a
 * JD-Core Version:    0.7.0.1
 */