package a.j.b.a.c.e;

import a.j.b.a.c.g.d;
import a.j.b.a.c.g.h;
import a.j.b.a.c.g.i.a;
import a.j.b.a.c.g.i.b;
import a.j.b.a.c.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a$aa$c
  extends i.b<a.aa, c>
  implements a.ad
{
  private int CkK;
  private int Ckr;
  private List<a.aa.a> Ckt;
  private boolean CmO;
  private int CmP;
  private a.aa CmQ;
  private int CmR;
  private int CmS;
  private int CmT;
  private int CmU;
  private int CmV;
  private a.aa CmW;
  private int CmX;
  private a.aa CmY;
  private int CmZ;
  
  private a$aa$c()
  {
    AppMethodBeat.i(120852);
    this.Ckt = Collections.emptyList();
    this.CmQ = a.aa.ejw();
    this.CmW = a.aa.ejw();
    this.CmY = a.aa.ejw();
    AppMethodBeat.o(120852);
  }
  
  private c UM(int paramInt)
  {
    this.Ckr |= 0x4;
    this.CmP = paramInt;
    return this;
  }
  
  private c UN(int paramInt)
  {
    this.Ckr |= 0x10;
    this.CmR = paramInt;
    return this;
  }
  
  private c UO(int paramInt)
  {
    this.Ckr |= 0x20;
    this.CmS = paramInt;
    return this;
  }
  
  private c UP(int paramInt)
  {
    this.Ckr |= 0x40;
    this.CmT = paramInt;
    return this;
  }
  
  private c UQ(int paramInt)
  {
    this.Ckr |= 0x80;
    this.CmU = paramInt;
    return this;
  }
  
  private c UR(int paramInt)
  {
    this.Ckr |= 0x100;
    this.CmV = paramInt;
    return this;
  }
  
  private c US(int paramInt)
  {
    this.Ckr |= 0x400;
    this.CmX = paramInt;
    return this;
  }
  
  private c UT(int paramInt)
  {
    this.Ckr |= 0x1000;
    this.CmZ = paramInt;
    return this;
  }
  
  private c UU(int paramInt)
  {
    this.Ckr |= 0x2000;
    this.CkK = paramInt;
    return this;
  }
  
  private void ehF()
  {
    AppMethodBeat.i(120859);
    if ((this.Ckr & 0x1) != 1)
    {
      this.Ckt = new ArrayList(this.Ckt);
      this.Ckr |= 0x1;
    }
    AppMethodBeat.o(120859);
  }
  
  private c ejQ()
  {
    AppMethodBeat.i(120853);
    c localc = new c().j(ejS());
    AppMethodBeat.o(120853);
    return localc;
  }
  
  private c k(a.aa paramaa)
  {
    AppMethodBeat.i(120860);
    if (((this.Ckr & 0x8) == 8) && (this.CmQ != a.aa.ejw())) {}
    for (this.CmQ = a.aa.f(this.CmQ).j(paramaa).ejS();; this.CmQ = paramaa)
    {
      this.Ckr |= 0x8;
      AppMethodBeat.o(120860);
      return this;
    }
  }
  
  private c l(a.aa paramaa)
  {
    AppMethodBeat.i(120861);
    if (((this.Ckr & 0x200) == 512) && (this.CmW != a.aa.ejw())) {}
    for (this.CmW = a.aa.f(this.CmW).j(paramaa).ejS();; this.CmW = paramaa)
    {
      this.Ckr |= 0x200;
      AppMethodBeat.o(120861);
      return this;
    }
  }
  
  private c m(a.aa paramaa)
  {
    AppMethodBeat.i(120862);
    if (((this.Ckr & 0x800) == 2048) && (this.CmY != a.aa.ejw())) {}
    for (this.CmY = a.aa.f(this.CmY).j(paramaa).ejS();; this.CmY = paramaa)
    {
      this.Ckr |= 0x800;
      AppMethodBeat.o(120862);
      return this;
    }
  }
  
  /* Error */
  private c t(a.j.b.a.c.g.e parame, a.j.b.a.c.g.g paramg)
  {
    // Byte code:
    //   0: ldc 127
    //   2: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore_3
    //   7: getstatic 131	a/j/b/a/c/e/a$aa:Ckq	La/j/b/a/c/g/s;
    //   10: aload_1
    //   11: aload_2
    //   12: invokeinterface 137 3 0
    //   17: checkcast 9	a/j/b/a/c/e/a$aa
    //   20: astore_1
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 111	a/j/b/a/c/e/a$aa$c:j	(La/j/b/a/c/e/a$aa;)La/j/b/a/c/e/a$aa$c;
    //   26: pop
    //   27: ldc 127
    //   29: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: areturn
    //   34: astore_1
    //   35: aload_1
    //   36: getfield 141	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   39: checkcast 9	a/j/b/a/c/e/a$aa
    //   42: astore_2
    //   43: ldc 127
    //   45: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aload_1
    //   49: athrow
    //   50: astore_1
    //   51: aload_2
    //   52: ifnull +9 -> 61
    //   55: aload_0
    //   56: aload_2
    //   57: invokevirtual 111	a/j/b/a/c/e/a$aa$c:j	(La/j/b/a/c/e/a$aa;)La/j/b/a/c/e/a$aa$c;
    //   60: pop
    //   61: ldc 127
    //   63: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aload_1
    //   67: athrow
    //   68: astore_1
    //   69: aload_3
    //   70: astore_2
    //   71: goto -20 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	c
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
  
  public final a.aa ejR()
  {
    AppMethodBeat.i(120854);
    Object localObject = ejS();
    if (!((a.aa)localObject).isInitialized())
    {
      localObject = new w();
      AppMethodBeat.o(120854);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(120854);
    return localObject;
  }
  
  public final a.aa ejS()
  {
    int j = 1;
    AppMethodBeat.i(120855);
    a.aa localaa = new a.aa(this, (byte)0);
    int k = this.Ckr;
    if ((this.Ckr & 0x1) == 1)
    {
      this.Ckt = Collections.unmodifiableList(this.Ckt);
      this.Ckr &= 0xFFFFFFFE;
    }
    a.aa.a(localaa, this.Ckt);
    if ((k & 0x2) == 2) {}
    for (;;)
    {
      a.aa.a(localaa, this.CmO);
      int i = j;
      if ((k & 0x4) == 4) {
        i = j | 0x2;
      }
      a.aa.a(localaa, this.CmP);
      j = i;
      if ((k & 0x8) == 8) {
        j = i | 0x4;
      }
      a.aa.a(localaa, this.CmQ);
      i = j;
      if ((k & 0x10) == 16) {
        i = j | 0x8;
      }
      a.aa.b(localaa, this.CmR);
      j = i;
      if ((k & 0x20) == 32) {
        j = i | 0x10;
      }
      a.aa.c(localaa, this.CmS);
      i = j;
      if ((k & 0x40) == 64) {
        i = j | 0x20;
      }
      a.aa.d(localaa, this.CmT);
      j = i;
      if ((k & 0x80) == 128) {
        j = i | 0x40;
      }
      a.aa.e(localaa, this.CmU);
      i = j;
      if ((k & 0x100) == 256) {
        i = j | 0x80;
      }
      a.aa.f(localaa, this.CmV);
      j = i;
      if ((k & 0x200) == 512) {
        j = i | 0x100;
      }
      a.aa.b(localaa, this.CmW);
      i = j;
      if ((k & 0x400) == 1024) {
        i = j | 0x200;
      }
      a.aa.g(localaa, this.CmX);
      j = i;
      if ((k & 0x800) == 2048) {
        j = i | 0x400;
      }
      a.aa.c(localaa, this.CmY);
      i = j;
      if ((k & 0x1000) == 4096) {
        i = j | 0x800;
      }
      a.aa.h(localaa, this.CmZ);
      j = i;
      if ((k & 0x2000) == 8192) {
        j = i | 0x1000;
      }
      a.aa.i(localaa, this.CkK);
      a.aa.j(localaa, j);
      AppMethodBeat.o(120855);
      return localaa;
      j = 0;
    }
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(120857);
    int i = 0;
    while (i < this.Ckt.size())
    {
      if (!((a.aa.a)this.Ckt.get(i)).isInitialized())
      {
        AppMethodBeat.o(120857);
        return false;
      }
      i += 1;
    }
    if ((this.Ckr & 0x8) == 8) {}
    for (i = 1; (i != 0) && (!this.CmQ.isInitialized()); i = 0)
    {
      AppMethodBeat.o(120857);
      return false;
    }
    if ((this.Ckr & 0x200) == 512) {}
    for (i = 1; (i != 0) && (!this.CmW.isInitialized()); i = 0)
    {
      AppMethodBeat.o(120857);
      return false;
    }
    if ((this.Ckr & 0x800) == 2048) {}
    for (i = 1; (i != 0) && (!this.CmY.isInitialized()); i = 0)
    {
      AppMethodBeat.o(120857);
      return false;
    }
    if (!this.Crw.isInitialized())
    {
      AppMethodBeat.o(120857);
      return false;
    }
    AppMethodBeat.o(120857);
    return true;
  }
  
  public final c j(a.aa paramaa)
  {
    AppMethodBeat.i(120856);
    if (paramaa == a.aa.ejw())
    {
      AppMethodBeat.o(120856);
      return this;
    }
    if (!a.aa.g(paramaa).isEmpty())
    {
      if (!this.Ckt.isEmpty()) {
        break label297;
      }
      this.Ckt = a.aa.g(paramaa);
      this.Ckr &= 0xFFFFFFFE;
    }
    for (;;)
    {
      if (paramaa.ejx()) {
        su(paramaa.CmO);
      }
      if (paramaa.ejy()) {
        UM(paramaa.CmP);
      }
      if (paramaa.ejz()) {
        k(paramaa.CmQ);
      }
      if (paramaa.ejA()) {
        UN(paramaa.CmR);
      }
      if (paramaa.ejB()) {
        UO(paramaa.CmS);
      }
      if (paramaa.ejC()) {
        UP(paramaa.CmT);
      }
      if (paramaa.ejD()) {
        UQ(paramaa.CmU);
      }
      if (paramaa.ejE()) {
        UR(paramaa.CmV);
      }
      if (paramaa.ejF()) {
        l(paramaa.CmW);
      }
      if (paramaa.ejG()) {
        US(paramaa.CmX);
      }
      if (paramaa.ejH()) {
        m(paramaa.CmY);
      }
      if (paramaa.ejI()) {
        UT(paramaa.CmZ);
      }
      if (paramaa.ehx()) {
        UU(paramaa.CkK);
      }
      a(paramaa);
      this.Ckp = this.Ckp.a(a.aa.h(paramaa));
      AppMethodBeat.o(120856);
      return this;
      label297:
      ehF();
      this.Ckt.addAll(a.aa.g(paramaa));
    }
  }
  
  public final c su(boolean paramBoolean)
  {
    this.Ckr |= 0x2;
    this.CmO = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.e.a.aa.c
 * JD-Core Version:    0.7.0.1
 */