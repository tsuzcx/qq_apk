package a.j.b.a.c.d.b;

import a.j.b.a.c.b.au;
import a.j.b.a.c.i.b.g;
import a.j.b.a.c.i.b.i;
import a.j.b.a.c.i.b.j.a;
import a.j.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class c$a$b
  implements n.b
{
  private final ArrayList<a.j.b.a.c.i.b.f<?>> CiY;
  
  c$a$b(a.j.b.a.c.f.f paramf)
  {
    AppMethodBeat.i(120235);
    this.CiY = new ArrayList();
    AppMethodBeat.o(120235);
  }
  
  public final void a(n.d paramd)
  {
    AppMethodBeat.i(120233);
    a.f.b.j.q(paramd, "classLiteralId");
    ArrayList localArrayList = this.CiY;
    Object localObject = c.a(this.CiW.CiS, paramd);
    if (localObject != null) {}
    for (paramd = (a.j.b.a.c.i.b.f)localObject;; paramd = (a.j.b.a.c.i.b.f)j.a.aze("Error array element value of annotation argument: " + this.BVU + ": class " + paramd.BUp.emc() + " not found"))
    {
      localArrayList.add(paramd);
      AppMethodBeat.o(120233);
      return;
      localObject = a.j.b.a.c.i.b.j.CwI;
    }
  }
  
  public final void a(a.j.b.a.c.f.a parama, a.j.b.a.c.f.f paramf)
  {
    AppMethodBeat.i(120232);
    a.f.b.j.q(parama, "enumClassId");
    a.f.b.j.q(paramf, "enumEntryName");
    this.CiY.add(new i(parama, paramf));
    AppMethodBeat.o(120232);
  }
  
  public final void dB(Object paramObject)
  {
    AppMethodBeat.i(120231);
    this.CiY.add(c.a.b(this.BVU, paramObject));
    AppMethodBeat.o(120231);
  }
  
  public final void zi()
  {
    AppMethodBeat.i(120234);
    Object localObject1 = a.j.b.a.c.d.a.a.a.b(this.BVU, this.CiW.CiT);
    if (localObject1 != null)
    {
      Map localMap = (Map)this.CiW.CiR;
      a.j.b.a.c.f.f localf = this.BVU;
      Object localObject2 = g.CwD;
      localObject2 = a.j.b.a.c.n.a.av(this.CiY);
      localObject1 = ((au)localObject1).eer();
      a.f.b.j.p(localObject1, "parameter.type");
      localMap.put(localf, g.a((List)localObject2, (w)localObject1));
    }
    AppMethodBeat.o(120234);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     a.j.b.a.c.d.b.c.a.b
 * JD-Core Version:    0.7.0.1
 */