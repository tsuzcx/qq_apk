package a.j.b.a.c.m;

import a.f.b.j;
import a.j.b.a.c.a.g;
import a.j.b.a.c.b.l;
import a.j.b.a.c.b.t;
import a.j.b.a.c.i.c.a;
import a.j.b.a.c.l.w;

public abstract class k
  implements b
{
  private final a.f.a.b<g, w> CEp;
  private final String description;
  private final String name;
  
  private k(String paramString, a.f.a.b<? super g, ? extends w> paramb)
  {
    this.name = paramString;
    this.CEp = paramb;
    this.description = ("must return " + this.name);
  }
  
  public final String getDescription()
  {
    return this.description;
  }
  
  public final boolean h(t paramt)
  {
    j.q(paramt, "functionDescriptor");
    return j.e(paramt.eds(), (w)this.CEp.S(a.G((l)paramt)));
  }
  
  public final String i(t paramt)
  {
    j.q(paramt, "functionDescriptor");
    return b.a.a(this, paramt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     a.j.b.a.c.m.k
 * JD-Core Version:    0.7.0.1
 */