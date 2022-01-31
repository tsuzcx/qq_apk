package a.j.b.a.c.b;

import a.a.ab;
import a.a.aj;
import a.a.v;
import a.a.x;
import a.j.b.a.c.b.a.g.a;
import a.j.b.a.c.b.c.ah;
import a.j.b.a.c.k.i;
import a.j.b.a.c.l.ba;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class aa$b
  extends a.j.b.a.c.b.c.g
{
  private final boolean BWA;
  private final List<ar> BWy;
  private final a.j.b.a.c.l.e BWz;
  
  public aa$b(i parami, l paraml, a.j.b.a.c.f.f paramf, boolean paramBoolean, int paramInt)
  {
    super(parami, paraml, paramf, am.BWF);
    AppMethodBeat.i(119287);
    this.BWA = paramBoolean;
    paramf = (Iterable)a.i.e.iD(0, paramInt);
    paraml = (Collection)new ArrayList(a.a.j.d(paramf));
    paramf = paramf.iterator();
    while (paramf.hasNext())
    {
      paramInt = ((ab)paramf).nextInt();
      l locall = (l)this;
      g.a locala = a.j.b.a.c.b.a.g.BXx;
      paraml.add(ah.a(locall, g.a.eeH(), ba.CBX, a.j.b.a.c.f.f.ayT("T".concat(String.valueOf(paramInt))), paramInt));
    }
    this.BWy = ((List)paraml);
    this.BWz = new a.j.b.a.c.l.e((e)this, this.BWy, (Collection)aj.setOf(a.j.b.a.c.i.c.a.F(this).eec().ecl()), parami);
    AppMethodBeat.o(119287);
  }
  
  public final Collection<d> ecA()
  {
    return (Collection)x.BMz;
  }
  
  public final f ecB()
  {
    return f.BWf;
  }
  
  public final w ecC()
  {
    return w.BWp;
  }
  
  public final d ecD()
  {
    return null;
  }
  
  public final az ecE()
  {
    AppMethodBeat.i(119284);
    az localaz = ay.BWO;
    a.f.b.j.p(localaz, "Visibilities.PUBLIC");
    AppMethodBeat.o(119284);
    return localaz;
  }
  
  public final boolean ecF()
  {
    return false;
  }
  
  public final boolean ecG()
  {
    return this.BWA;
  }
  
  public final boolean ecH()
  {
    return false;
  }
  
  public final boolean ecI()
  {
    return false;
  }
  
  public final boolean ecJ()
  {
    return false;
  }
  
  public final boolean ecK()
  {
    return false;
  }
  
  public final boolean ecL()
  {
    return false;
  }
  
  public final a.j.b.a.c.b.a.g ecM()
  {
    AppMethodBeat.i(119285);
    Object localObject = a.j.b.a.c.b.a.g.BXx;
    localObject = g.a.eeH();
    AppMethodBeat.o(119285);
    return localObject;
  }
  
  public final Collection<e> ecO()
  {
    return (Collection)v.BMx;
  }
  
  public final List<ar> ecP()
  {
    return this.BWy;
  }
  
  public final e ecz()
  {
    return null;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(119286);
    String str = "class " + this.BYN + " (not found)";
    AppMethodBeat.o(119286);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.c.b.aa.b
 * JD-Core Version:    0.7.0.1
 */