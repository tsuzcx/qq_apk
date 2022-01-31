package a.j.b.a.c.j.a;

import a.j.b.a.c.b.l;
import a.j.b.a.c.e.a.ae;
import a.j.b.a.c.e.a.a;
import a.j.b.a.c.e.a.c;
import a.j.b.a.c.e.a.h;
import a.j.b.a.c.j.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class k
{
  public final c BOc;
  public final h BOd;
  public final l BZh;
  public final i CiZ;
  public final w CyQ;
  public final q CyR;
  final a.j.b.a.c.e.a.i CyS;
  final e CyT;
  private final a Cyt;
  
  public k(i parami, c paramc, l paraml, h paramh, a.j.b.a.c.e.a.i parami1, a parama, e parame, w paramw, List<a.ae> paramList)
  {
    AppMethodBeat.i(122269);
    this.CiZ = parami;
    this.BOc = paramc;
    this.BZh = paraml;
    this.BOd = paramh;
    this.CyS = parami1;
    this.Cyt = parama;
    this.CyT = parame;
    this.CyQ = new w(this, paramw, paramList, "Deserializer for " + this.BZh.edF(), (byte)0);
    this.CyR = new q(this);
    AppMethodBeat.o(122269);
  }
  
  public final k a(l paraml, List<a.ae> paramList, c paramc, h paramh, a.j.b.a.c.e.a.i parami, a parama)
  {
    AppMethodBeat.i(122267);
    a.f.b.j.q(paraml, "descriptor");
    a.f.b.j.q(paramList, "typeParameterProtos");
    a.f.b.j.q(paramc, "nameResolver");
    a.f.b.j.q(paramh, "typeTable");
    a.f.b.j.q(parami, "versionRequirementTable");
    a.f.b.j.q(parama, "metadataVersion");
    i locali = this.CiZ;
    a.f.b.j.q(parama, "version");
    if (a.j.b.a.c.e.a.j.a(parama)) {}
    for (;;)
    {
      paraml = new k(locali, paramc, paraml, paramh, parami, parama, this.CyT, this.CyQ, paramList);
      AppMethodBeat.o(122267);
      return paraml;
      parami = this.CyS;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.j.a.k
 * JD-Core Version:    0.7.0.1
 */