package a.j.b.a.c.j.a.a;

import a.j.b.a.c.b.a.a;
import a.j.b.a.c.b.a.g;
import a.j.b.a.c.b.ak;
import a.j.b.a.c.b.al;
import a.j.b.a.c.b.am;
import a.j.b.a.c.b.ar;
import a.j.b.a.c.b.au;
import a.j.b.a.c.b.az;
import a.j.b.a.c.b.b.a;
import a.j.b.a.c.b.c.ad;
import a.j.b.a.c.b.c.p;
import a.j.b.a.c.b.l;
import a.j.b.a.c.b.t;
import a.j.b.a.c.e.a.o;
import a.j.b.a.c.e.a.c;
import a.j.b.a.c.e.a.h;
import a.j.b.a.c.e.a.i;
import a.j.b.a.c.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Map;

public final class j
  extends ad
  implements b
{
  private final c BOc;
  private final h BOd;
  private final a.o CAm;
  private final i CyS;
  private final e CyT;
  private f.a CzD;
  
  private j(l paraml, al paramal, g paramg, f paramf, b.a parama, a.o paramo, c paramc, h paramh, i parami, e parame, am paramam) {}
  
  public final ad a(ak paramak1, ak paramak2, List<? extends ar> paramList, List<? extends au> paramList1, a.j.b.a.c.l.w paramw, a.j.b.a.c.b.w paramw1, az paramaz, Map<? extends a.a<?>, ?> paramMap, f.a parama)
  {
    AppMethodBeat.i(122416);
    a.f.b.j.q(paramList, "typeParameters");
    a.f.b.j.q(paramList1, "unsubstitutedValueParameters");
    a.f.b.j.q(paramaz, "visibility");
    a.f.b.j.q(paramMap, "userDataMap");
    a.f.b.j.q(parama, "isExperimentalCoroutineInReleaseEnvironment");
    paramak1 = super.a(paramak1, paramak2, paramList, paramList1, paramw, paramw1, paramaz, paramMap);
    this.CzD = parama;
    a.f.b.j.p(paramak1, "super.initialize(\n      …easeEnvironment\n        }");
    AppMethodBeat.o(122416);
    return paramak1;
  }
  
  public final p a(l paraml, t paramt, b.a parama, f paramf, g paramg, am paramam)
  {
    AppMethodBeat.i(122417);
    a.f.b.j.q(paraml, "newOwner");
    a.f.b.j.q(parama, "kind");
    a.f.b.j.q(paramg, "annotations");
    a.f.b.j.q(paramam, "source");
    al localal = (al)paramt;
    if (paramf == null)
    {
      paramt = this.BYN;
      a.f.b.j.p(paramt, "name");
    }
    for (;;)
    {
      paraml = new j(paraml, localal, paramg, paramt, parama, this.CAm, this.BOc, this.BOd, this.CyS, this.CyT, paramam);
      paraml.CzD = this.CzD;
      paraml = (p)paraml;
      AppMethodBeat.o(122417);
      return paraml;
      paramt = paramf;
    }
  }
  
  public final c eot()
  {
    return this.BOc;
  }
  
  public final h eou()
  {
    return this.BOd;
  }
  
  public final e eov()
  {
    return this.CyT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.j.a.a.j
 * JD-Core Version:    0.7.0.1
 */