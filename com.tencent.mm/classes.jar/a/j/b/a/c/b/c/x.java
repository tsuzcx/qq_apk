package a.j.b.a.c.b.c;

import a.f.b.j;
import a.j.b.a.c.b.a.g.a;
import a.j.b.a.c.b.ab;
import a.j.b.a.c.b.am;
import a.j.b.a.c.b.l;
import a.j.b.a.c.b.n;
import a.j.b.a.c.b.y;
import a.j.b.a.c.f.b;
import a.j.b.a.c.f.c;
import a.v;

public abstract class x
  extends k
  implements ab
{
  public final b BXD;
  
  public x(y paramy, b paramb)
  {
    super(paramy, g.a.eeH(), paramb.CqE.emi(), am.BWF);
    this.BXD = paramb;
  }
  
  public final <R, D> R a(n<R, D> paramn, D paramD)
  {
    j.q(paramn, "visitor");
    return paramn.a((ab)this, paramD);
  }
  
  public am ecN()
  {
    am localam = am.BWF;
    j.p(localam, "SourceElement.NO_SOURCE");
    return localam;
  }
  
  public final y eed()
  {
    l locall = super.ecv();
    if (locall == null) {
      throw new v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ModuleDescriptor");
    }
    return (y)locall;
  }
  
  public final b eee()
  {
    return this.BXD;
  }
  
  public String toString()
  {
    return "package " + this.BXD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.b.c.x
 * JD-Core Version:    0.7.0.1
 */