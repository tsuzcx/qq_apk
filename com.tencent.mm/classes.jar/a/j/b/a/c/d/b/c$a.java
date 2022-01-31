package a.j.b.a.c.d.b;

import a.j.b.a.c.b.a.d;
import a.j.b.a.c.b.am;
import a.j.b.a.c.b.e;
import a.j.b.a.c.f.a;
import a.j.b.a.c.i.b.g;
import a.j.b.a.c.i.b.i;
import a.j.b.a.c.i.b.j.a;
import a.j.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c$a
  implements n.a
{
  final HashMap<a.j.b.a.c.f.f, a.j.b.a.c.i.b.f<?>> CiR;
  
  c$a(e parame, List paramList, am paramam)
  {
    AppMethodBeat.i(120243);
    this.CiR = new HashMap();
    AppMethodBeat.o(120243);
  }
  
  static a.j.b.a.c.i.b.f<?> b(a.j.b.a.c.f.f paramf, Object paramObject)
  {
    AppMethodBeat.i(120242);
    a.j.b.a.c.i.b.f localf = g.CwD.dL(paramObject);
    paramObject = localf;
    if (localf == null)
    {
      paramObject = a.j.b.a.c.i.b.j.CwI;
      paramObject = (a.j.b.a.c.i.b.f)j.a.aze("Unsupported annotation argument: ".concat(String.valueOf(paramf)));
    }
    AppMethodBeat.o(120242);
    return paramObject;
  }
  
  public final n.a a(a.j.b.a.c.f.f paramf, a parama)
  {
    AppMethodBeat.i(120240);
    a.f.b.j.q(paramf, "name");
    a.f.b.j.q(parama, "classId");
    ArrayList localArrayList = new ArrayList();
    c localc = this.CiS;
    am localam = am.BWF;
    a.f.b.j.p(localam, "SourceElement.NO_SOURCE");
    paramf = (n.a)new c.a.a(this, localc.a(parama, localam, (List)localArrayList), paramf, localArrayList);
    AppMethodBeat.o(120240);
    return paramf;
  }
  
  public final void a(a.j.b.a.c.f.f paramf, n.d paramd)
  {
    AppMethodBeat.i(120237);
    a.f.b.j.q(paramf, "name");
    a.f.b.j.q(paramd, "classLiteralId");
    Map localMap = (Map)this.CiR;
    Object localObject = c.a(this.CiS, paramd);
    if (localObject != null) {}
    for (paramd = (a.j.b.a.c.i.b.f)localObject;; paramd = (a.j.b.a.c.i.b.f)j.a.aze("Error value of annotation argument: " + paramf + ": class " + paramd.BUp.emc() + " not found"))
    {
      localMap.put(paramf, paramd);
      AppMethodBeat.o(120237);
      return;
      localObject = a.j.b.a.c.i.b.j.CwI;
    }
  }
  
  public final void a(a.j.b.a.c.f.f paramf1, a parama, a.j.b.a.c.f.f paramf2)
  {
    AppMethodBeat.i(120238);
    a.f.b.j.q(paramf1, "name");
    a.f.b.j.q(parama, "enumClassId");
    a.f.b.j.q(paramf2, "enumEntryName");
    ((Map)this.CiR).put(paramf1, new i(parama, paramf2));
    AppMethodBeat.o(120238);
  }
  
  public final void a(a.j.b.a.c.f.f paramf, Object paramObject)
  {
    AppMethodBeat.i(120236);
    if (paramf != null) {
      ((Map)this.CiR).put(paramf, b(paramf, paramObject));
    }
    AppMethodBeat.o(120236);
  }
  
  public final n.b o(a.j.b.a.c.f.f paramf)
  {
    AppMethodBeat.i(120239);
    a.f.b.j.q(paramf, "name");
    paramf = (n.b)new c.a.b(this, paramf);
    AppMethodBeat.o(120239);
    return paramf;
  }
  
  public final void zi()
  {
    AppMethodBeat.i(120241);
    this.sAz.add(new d((w)this.CiT.edE(), (Map)this.CiR, this.CiU));
    AppMethodBeat.o(120241);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.d.b.c.a
 * JD-Core Version:    0.7.0.1
 */