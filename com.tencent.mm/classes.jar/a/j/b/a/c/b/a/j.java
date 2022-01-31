package a.j.b.a.c.b.a;

import a.f.a.a;
import a.f.b.t;
import a.f.b.v;
import a.j.b.a.c.b.am;
import a.j.b.a.c.f.b;
import a.j.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class j
  implements c
{
  private final a.f BXB;
  private final a.j.b.a.c.a.g BXC;
  final b BXD;
  private final Map<a.j.b.a.c.f.f, a.j.b.a.c.i.b.f<?>> BXE;
  
  static
  {
    AppMethodBeat.i(119344);
    eOJ = new a.j.k[] { (a.j.k)v.a(new t(v.aG(j.class), "type", "getType()Lorg/jetbrains/kotlin/types/KotlinType;")) };
    AppMethodBeat.o(119344);
  }
  
  public j(a.j.b.a.c.a.g paramg, b paramb, Map<a.j.b.a.c.f.f, ? extends a.j.b.a.c.i.b.f<?>> paramMap)
  {
    AppMethodBeat.i(119347);
    this.BXC = paramg;
    this.BXD = paramb;
    this.BXE = paramMap;
    this.BXB = a.g.a(a.k.BLU, (a)new j.a(this));
    AppMethodBeat.o(119347);
  }
  
  public final am ecN()
  {
    AppMethodBeat.i(119346);
    am localam = am.BWF;
    a.f.b.j.p(localam, "SourceElement.NO_SOURCE");
    AppMethodBeat.o(119346);
    return localam;
  }
  
  public final Map<a.j.b.a.c.f.f, a.j.b.a.c.i.b.f<?>> eeG()
  {
    return this.BXE;
  }
  
  public final b eee()
  {
    return this.BXD;
  }
  
  public final w eer()
  {
    AppMethodBeat.i(119345);
    w localw = (w)this.BXB.getValue();
    AppMethodBeat.o(119345);
    return localw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.b.a.j
 * JD-Core Version:    0.7.0.1
 */