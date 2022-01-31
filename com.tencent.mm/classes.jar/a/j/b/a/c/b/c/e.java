package a.j.b.a.c.b.c;

import a.j.b.a.c.b.a.g;
import a.j.b.a.c.b.am;
import a.j.b.a.c.b.ap;
import a.j.b.a.c.b.ar;
import a.j.b.a.c.b.l;
import a.j.b.a.c.b.n;
import a.j.b.a.c.k.i;
import a.j.b.a.c.l.ad;
import a.j.b.a.c.l.an;
import a.j.b.a.c.l.ba;
import a.j.b.a.c.l.w;
import java.util.List;

public abstract class e
  extends k
  implements ar
{
  private final a.j.b.a.c.k.f<ad> BYO;
  final ba BYX;
  final boolean BYY;
  private final a.j.b.a.c.k.f<an> BYZ;
  private final int index;
  
  protected e(i parami, l paraml, g paramg, a.j.b.a.c.f.f paramf, ba paramba, boolean paramBoolean, int paramInt, am paramam, ap paramap)
  {
    super(paraml, paramg, paramf, paramam);
    this.BYX = paramba;
    this.BYY = paramBoolean;
    this.index = paramInt;
    this.BYZ = parami.l(new e.1(this, parami, paramap));
    this.BYO = parami.l(new e.2(this, parami, paramf));
  }
  
  protected abstract void J(w paramw);
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    return paramn.a(this, paramD);
  }
  
  public final List<w> ebo()
  {
    return ((e.a)ecx()).eoF();
  }
  
  public final an ecx()
  {
    return (an)this.BYZ.invoke();
  }
  
  public final boolean edA()
  {
    return false;
  }
  
  public final ar edB()
  {
    return (ar)super.eeM();
  }
  
  public final ad edE()
  {
    return (ad)this.BYO.invoke();
  }
  
  public final ba edG()
  {
    return this.BYX;
  }
  
  public final boolean edH()
  {
    return this.BYY;
  }
  
  protected abstract List<w> eeP();
  
  public final int getIndex()
  {
    return this.index;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.b.c.e
 * JD-Core Version:    0.7.0.1
 */