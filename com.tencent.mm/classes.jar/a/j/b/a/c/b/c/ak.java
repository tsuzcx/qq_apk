package a.j.b.a.c.b.c;

import a.j.b.a.c.b.am;
import a.j.b.a.c.b.l;

public abstract class ak
  extends aj
{
  protected final boolean Cbq;
  protected a.j.b.a.c.k.g<a.j.b.a.c.i.b.f<?>> Cbr;
  
  static
  {
    if (!ak.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public ak(l paraml, a.j.b.a.c.b.a.g paramg, a.j.b.a.c.f.f paramf, boolean paramBoolean, am paramam)
  {
    super(paraml, paramg, paramf, null, paramam);
    this.Cbq = paramBoolean;
  }
  
  public final void a(a.j.b.a.c.k.g<a.j.b.a.c.i.b.f<?>> paramg)
  {
    assert (!this.Cbq) : ("Constant value for variable initializer should be recorded only for final variables: " + this.BYN);
    this.Cbr = paramg;
  }
  
  public final boolean eey()
  {
    return this.Cbq;
  }
  
  public final a.j.b.a.c.i.b.f<?> eez()
  {
    if (this.Cbr != null) {
      return (a.j.b.a.c.i.b.f)this.Cbr.invoke();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.b.c.ak
 * JD-Core Version:    0.7.0.1
 */