package a.j.b.a.c.e;

import a.j.b.a.c.g.d;
import a.j.b.a.c.g.h;
import a.j.b.a.c.g.i.a;
import a.j.b.a.c.g.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a$ae$a
  extends i.b<a.ae, a>
  implements a.af
{
  private int Ckr;
  private int Cks;
  private int ClT;
  private boolean Cnq;
  private a.ae.b Cnr;
  private List<a.aa> Cns;
  private List<Integer> Cnt;
  
  private a$ae$a()
  {
    AppMethodBeat.i(120918);
    this.Cnr = a.ae.b.Cnx;
    this.Cns = Collections.emptyList();
    this.Cnt = Collections.emptyList();
    AppMethodBeat.o(120918);
  }
  
  private a UZ(int paramInt)
  {
    this.Ckr |= 0x1;
    this.Cks = paramInt;
    return this;
  }
  
  private a Va(int paramInt)
  {
    this.Ckr |= 0x2;
    this.ClT = paramInt;
    return this;
  }
  
  private a a(a.ae.b paramb)
  {
    AppMethodBeat.i(120924);
    if (paramb == null)
    {
      paramb = new NullPointerException();
      AppMethodBeat.o(120924);
      throw paramb;
    }
    this.Ckr |= 0x8;
    this.Cnr = paramb;
    AppMethodBeat.o(120924);
    return this;
  }
  
  private a ekg()
  {
    AppMethodBeat.i(120919);
    a locala = new a().d(ekh());
    AppMethodBeat.o(120919);
    return locala;
  }
  
  private a.ae ekh()
  {
    int j = 1;
    AppMethodBeat.i(120920);
    a.ae localae = new a.ae(this, (byte)0);
    int k = this.Ckr;
    if ((k & 0x1) == 1) {}
    for (;;)
    {
      a.ae.a(localae, this.Cks);
      int i = j;
      if ((k & 0x2) == 2) {
        i = j | 0x2;
      }
      a.ae.b(localae, this.ClT);
      j = i;
      if ((k & 0x4) == 4) {
        j = i | 0x4;
      }
      a.ae.a(localae, this.Cnq);
      i = j;
      if ((k & 0x8) == 8) {
        i = j | 0x8;
      }
      a.ae.a(localae, this.Cnr);
      if ((this.Ckr & 0x10) == 16)
      {
        this.Cns = Collections.unmodifiableList(this.Cns);
        this.Ckr &= 0xFFFFFFEF;
      }
      a.ae.a(localae, this.Cns);
      if ((this.Ckr & 0x20) == 32)
      {
        this.Cnt = Collections.unmodifiableList(this.Cnt);
        this.Ckr &= 0xFFFFFFDF;
      }
      a.ae.b(localae, this.Cnt);
      a.ae.c(localae, i);
      AppMethodBeat.o(120920);
      return localae;
      j = 0;
    }
  }
  
  private void eki()
  {
    AppMethodBeat.i(120925);
    if ((this.Ckr & 0x10) != 16)
    {
      this.Cns = new ArrayList(this.Cns);
      this.Ckr |= 0x10;
    }
    AppMethodBeat.o(120925);
  }
  
  private void ekj()
  {
    AppMethodBeat.i(120926);
    if ((this.Ckr & 0x20) != 32)
    {
      this.Cnt = new ArrayList(this.Cnt);
      this.Ckr |= 0x20;
    }
    AppMethodBeat.o(120926);
  }
  
  private a sv(boolean paramBoolean)
  {
    this.Ckr |= 0x4;
    this.Cnq = paramBoolean;
    return this;
  }
  
  /* Error */
  private a v(a.j.b.a.c.g.e parame, a.j.b.a.c.g.g paramg)
  {
    // Byte code:
    //   0: ldc 129
    //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore_3
    //   7: getstatic 133	a/j/b/a/c/e/a$ae:Ckq	La/j/b/a/c/g/s;
    //   10: aload_1
    //   11: aload_2
    //   12: invokeinterface 138 3 0
    //   17: checkcast 9	a/j/b/a/c/e/a$ae
    //   20: astore_1
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 81	a/j/b/a/c/e/a$ae$a:d	(La/j/b/a/c/e/a$ae;)La/j/b/a/c/e/a$ae$a;
    //   26: pop
    //   27: ldc 129
    //   29: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: areturn
    //   34: astore_1
    //   35: aload_1
    //   36: getfield 142	a/j/b/a/c/g/k:CrM	La/j/b/a/c/g/q;
    //   39: checkcast 9	a/j/b/a/c/e/a$ae
    //   42: astore_2
    //   43: ldc 129
    //   45: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aload_1
    //   49: athrow
    //   50: astore_1
    //   51: aload_2
    //   52: ifnull +9 -> 61
    //   55: aload_0
    //   56: aload_2
    //   57: invokevirtual 81	a/j/b/a/c/e/a$ae$a:d	(La/j/b/a/c/e/a$ae;)La/j/b/a/c/e/a$ae$a;
    //   60: pop
    //   61: ldc 129
    //   63: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final a d(a.ae paramae)
  {
    AppMethodBeat.i(120921);
    if (paramae == a.ae.ekd())
    {
      AppMethodBeat.o(120921);
      return this;
    }
    if (paramae.egY()) {
      UZ(paramae.Cks);
    }
    if (paramae.eiv()) {
      Va(paramae.ClT);
    }
    if (paramae.eke()) {
      sv(paramae.Cnq);
    }
    if (paramae.ekf()) {
      a(paramae.Cnr);
    }
    if (!a.ae.a(paramae).isEmpty())
    {
      if (this.Cns.isEmpty())
      {
        this.Cns = a.ae.a(paramae);
        this.Ckr &= 0xFFFFFFEF;
      }
    }
    else if (!a.ae.b(paramae).isEmpty())
    {
      if (!this.Cnt.isEmpty()) {
        break label217;
      }
      this.Cnt = a.ae.b(paramae);
      this.Ckr &= 0xFFFFFFDF;
    }
    for (;;)
    {
      a(paramae);
      this.Ckp = this.Ckp.a(a.ae.c(paramae));
      AppMethodBeat.o(120921);
      return this;
      eki();
      this.Cns.addAll(a.ae.a(paramae));
      break;
      label217:
      ekj();
      this.Cnt.addAll(a.ae.b(paramae));
    }
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(120922);
    if ((this.Ckr & 0x1) == 1) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(120922);
      return false;
    }
    if ((this.Ckr & 0x2) == 2) {}
    for (i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(120922);
      return false;
    }
    i = 0;
    while (i < this.Cns.size())
    {
      if (!((a.aa)this.Cns.get(i)).isInitialized())
      {
        AppMethodBeat.o(120922);
        return false;
      }
      i += 1;
    }
    if (!this.Crw.isInitialized())
    {
      AppMethodBeat.o(120922);
      return false;
    }
    AppMethodBeat.o(120922);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.e.a.ae.a
 * JD-Core Version:    0.7.0.1
 */