package a.j.b.a.c.e;

import a.j.b.a.c.g.d;
import a.j.b.a.c.g.h;
import a.j.b.a.c.g.i.a;
import a.j.b.a.c.g.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a$ab$a
  extends i.b<a.ab, a>
  implements a.ac
{
  private int CkK;
  private int Ckr;
  private int ClT;
  private List<a.ae> Cld;
  private List<Integer> Clr;
  private a.aa Cnk;
  private int Cnl;
  private a.aa Cnm;
  private int Cnn;
  private List<a.a> Cno;
  
  private a$ab$a()
  {
    AppMethodBeat.i(120886);
    this.CkK = 6;
    this.Cld = Collections.emptyList();
    this.Cnk = a.aa.ejw();
    this.Cnm = a.aa.ejw();
    this.Cno = Collections.emptyList();
    this.Clr = Collections.emptyList();
    AppMethodBeat.o(120886);
  }
  
  private a UV(int paramInt)
  {
    this.Ckr |= 0x1;
    this.CkK = paramInt;
    return this;
  }
  
  private a UW(int paramInt)
  {
    this.Ckr |= 0x2;
    this.ClT = paramInt;
    return this;
  }
  
  private a UX(int paramInt)
  {
    this.Ckr |= 0x10;
    this.Cnl = paramInt;
    return this;
  }
  
  private a UY(int paramInt)
  {
    this.Ckr |= 0x40;
    this.Cnn = paramInt;
    return this;
  }
  
  private void ehO()
  {
    AppMethodBeat.i(120892);
    if ((this.Ckr & 0x4) != 4)
    {
      this.Cld = new ArrayList(this.Cld);
      this.Ckr |= 0x4;
    }
    AppMethodBeat.o(120892);
  }
  
  private void ehY()
  {
    AppMethodBeat.i(120896);
    if ((this.Ckr & 0x100) != 256)
    {
      this.Clr = new ArrayList(this.Clr);
      this.Ckr |= 0x100;
    }
    AppMethodBeat.o(120896);
  }
  
  private a ejZ()
  {
    AppMethodBeat.i(120887);
    a locala = new a().e(eka());
    AppMethodBeat.o(120887);
    return locala;
  }
  
  private a.ab eka()
  {
    int j = 1;
    AppMethodBeat.i(120888);
    a.ab localab = new a.ab(this, (byte)0);
    int k = this.Ckr;
    if ((k & 0x1) == 1) {}
    for (;;)
    {
      a.ab.a(localab, this.CkK);
      int i = j;
      if ((k & 0x2) == 2) {
        i = j | 0x2;
      }
      a.ab.b(localab, this.ClT);
      if ((this.Ckr & 0x4) == 4)
      {
        this.Cld = Collections.unmodifiableList(this.Cld);
        this.Ckr &= 0xFFFFFFFB;
      }
      a.ab.a(localab, this.Cld);
      j = i;
      if ((k & 0x8) == 8) {
        j = i | 0x4;
      }
      a.ab.a(localab, this.Cnk);
      i = j;
      if ((k & 0x10) == 16) {
        i = j | 0x8;
      }
      a.ab.c(localab, this.Cnl);
      j = i;
      if ((k & 0x20) == 32) {
        j = i | 0x10;
      }
      a.ab.b(localab, this.Cnm);
      i = j;
      if ((k & 0x40) == 64) {
        i = j | 0x20;
      }
      a.ab.d(localab, this.Cnn);
      if ((this.Ckr & 0x80) == 128)
      {
        this.Cno = Collections.unmodifiableList(this.Cno);
        this.Ckr &= 0xFFFFFF7F;
      }
      a.ab.b(localab, this.Cno);
      if ((this.Ckr & 0x100) == 256)
      {
        this.Clr = Collections.unmodifiableList(this.Clr);
        this.Ckr &= 0xFFFFFEFF;
      }
      a.ab.c(localab, this.Clr);
      a.ab.e(localab, i);
      AppMethodBeat.o(120888);
      return localab;
      j = 0;
    }
  }
  
  private void ekb()
  {
    AppMethodBeat.i(120895);
    if ((this.Ckr & 0x80) != 128)
    {
      this.Cno = new ArrayList(this.Cno);
      this.Ckr |= 0x80;
    }
    AppMethodBeat.o(120895);
  }
  
  private a n(a.aa paramaa)
  {
    AppMethodBeat.i(120893);
    if (((this.Ckr & 0x8) == 8) && (this.Cnk != a.aa.ejw())) {}
    for (this.Cnk = a.aa.f(this.Cnk).j(paramaa).ejS();; this.Cnk = paramaa)
    {
      this.Ckr |= 0x8;
      AppMethodBeat.o(120893);
      return this;
    }
  }
  
  private a o(a.aa paramaa)
  {
    AppMethodBeat.i(120894);
    if (((this.Ckr & 0x20) == 32) && (this.Cnm != a.aa.ejw())) {}
    for (this.Cnm = a.aa.f(this.Cnm).j(paramaa).ejS();; this.Cnm = paramaa)
    {
      this.Ckr |= 0x20;
      AppMethodBeat.o(120894);
      return this;
    }
  }
  
  /* Error */
  private a u(a.j.b.a.c.g.e parame, a.j.b.a.c.g.g paramg)
  {
    // Byte code:
    //   0: ldc 158
    //   2: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore_3
    //   7: getstatic 162	a/j/b/a/c/e/a$ab:Ckq	La/j/b/a/c/g/s;
    //   10: aload_1
    //   11: aload_2
    //   12: invokeinterface 167 3 0
    //   17: checkcast 9	a/j/b/a/c/e/a$ab
    //   20: astore_1
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 99	a/j/b/a/c/e/a$ab$a:e	(La/j/b/a/c/e/a$ab;)La/j/b/a/c/e/a$ab$a;
    //   26: pop
    //   27: ldc 158
    //   29: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: areturn
    //   34: astore_1
    //   35: aload_1
    //   36: getfield 171	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   39: checkcast 9	a/j/b/a/c/e/a$ab
    //   42: astore_2
    //   43: ldc 158
    //   45: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aload_1
    //   49: athrow
    //   50: astore_1
    //   51: aload_2
    //   52: ifnull +9 -> 61
    //   55: aload_0
    //   56: aload_2
    //   57: invokevirtual 99	a/j/b/a/c/e/a$ab$a:e	(La/j/b/a/c/e/a$ab;)La/j/b/a/c/e/a$ab$a;
    //   60: pop
    //   61: ldc 158
    //   63: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final a e(a.ab paramab)
  {
    AppMethodBeat.i(120889);
    if (paramab == a.ab.ejU())
    {
      AppMethodBeat.o(120889);
      return this;
    }
    if (paramab.ehx()) {
      UV(paramab.CkK);
    }
    if (paramab.eiv()) {
      UW(paramab.ClT);
    }
    if (!a.ab.a(paramab).isEmpty())
    {
      if (this.Cld.isEmpty())
      {
        this.Cld = a.ab.a(paramab);
        this.Ckr &= 0xFFFFFFFB;
      }
    }
    else
    {
      if (paramab.ejV()) {
        n(paramab.Cnk);
      }
      if (paramab.ejW()) {
        UX(paramab.Cnl);
      }
      if (paramab.ejX()) {
        o(paramab.Cnm);
      }
      if (paramab.ejY()) {
        UY(paramab.Cnn);
      }
      if (!a.ab.b(paramab).isEmpty())
      {
        if (!this.Cno.isEmpty()) {
          break label294;
        }
        this.Cno = a.ab.b(paramab);
        this.Ckr &= 0xFFFFFF7F;
      }
      label202:
      if (!a.ab.c(paramab).isEmpty())
      {
        if (!this.Clr.isEmpty()) {
          break label315;
        }
        this.Clr = a.ab.c(paramab);
        this.Ckr &= 0xFFFFFEFF;
      }
    }
    for (;;)
    {
      a(paramab);
      this.Ckp = this.Ckp.a(a.ab.d(paramab));
      AppMethodBeat.o(120889);
      return this;
      ehO();
      this.Cld.addAll(a.ab.a(paramab));
      break;
      label294:
      ekb();
      this.Cno.addAll(a.ab.b(paramab));
      break label202;
      label315:
      ehY();
      this.Clr.addAll(a.ab.c(paramab));
    }
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(120890);
    if ((this.Ckr & 0x2) == 2) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(120890);
      return false;
    }
    i = 0;
    while (i < this.Cld.size())
    {
      if (!((a.ae)this.Cld.get(i)).isInitialized())
      {
        AppMethodBeat.o(120890);
        return false;
      }
      i += 1;
    }
    if ((this.Ckr & 0x8) == 8) {}
    for (i = 1; (i != 0) && (!this.Cnk.isInitialized()); i = 0)
    {
      AppMethodBeat.o(120890);
      return false;
    }
    if ((this.Ckr & 0x20) == 32) {}
    for (i = 1; (i != 0) && (!this.Cnm.isInitialized()); i = 0)
    {
      AppMethodBeat.o(120890);
      return false;
    }
    i = 0;
    while (i < this.Cno.size())
    {
      if (!((a.a)this.Cno.get(i)).isInitialized())
      {
        AppMethodBeat.o(120890);
        return false;
      }
      i += 1;
    }
    if (!this.Crw.isInitialized())
    {
      AppMethodBeat.o(120890);
      return false;
    }
    AppMethodBeat.o(120890);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.e.a.ab.a
 * JD-Core Version:    0.7.0.1
 */