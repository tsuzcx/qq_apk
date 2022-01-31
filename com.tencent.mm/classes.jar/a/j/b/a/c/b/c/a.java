package a.j.b.a.c.b.c;

import a.j.b.a.c.b.ak;
import a.j.b.a.c.b.e;
import a.j.b.a.c.b.n;
import a.j.b.a.c.i.e.h;
import a.j.b.a.c.i.e.l;
import a.j.b.a.c.k.i;
import a.j.b.a.c.l.ad;
import a.j.b.a.c.l.as;
import a.j.b.a.c.l.au;

public abstract class a
  implements e
{
  public final a.j.b.a.c.f.f BYN;
  protected final a.j.b.a.c.k.f<ad> BYO;
  private final a.j.b.a.c.k.f<h> BYP;
  private final a.j.b.a.c.k.f<ak> BYQ;
  
  static
  {
    if (!a.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public a(i parami, a.j.b.a.c.f.f paramf)
  {
    this.BYN = paramf;
    this.BYO = parami.l(new a.1(this));
    this.BYP = parami.l(new a.2(this));
    this.BYQ = parami.l(new a.3(this));
  }
  
  public h a(as paramas)
  {
    if (paramas.isEmpty()) {
      return ecy();
    }
    paramas = au.d(paramas);
    return new l(ecy(), paramas);
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    return paramn.a(this, paramD);
  }
  
  public final ad edE()
  {
    return (ad)this.BYO.invoke();
  }
  
  public final a.j.b.a.c.f.f edF()
  {
    return this.BYN;
  }
  
  public h edJ()
  {
    return (h)this.BYP.invoke();
  }
  
  public final ak edK()
  {
    return (ak)this.BYQ.invoke();
  }
  
  public final e edL()
  {
    return this;
  }
  
  public e g(au paramau)
  {
    if (paramau.BZY.isEmpty()) {
      return this;
    }
    return new s(this, paramau);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     a.j.b.a.c.b.c.a
 * JD-Core Version:    0.7.0.1
 */