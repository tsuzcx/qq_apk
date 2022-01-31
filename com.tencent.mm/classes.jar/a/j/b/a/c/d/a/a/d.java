package a.j.b.a.c.d.a.a;

import a.a.ad;
import a.a.x;
import a.j.b.a.c.a.g;
import a.j.b.a.c.a.g.a;
import a.j.b.a.c.b.a.n;
import a.j.b.a.c.f.a;
import a.j.b.a.c.i.b.i;
import a.o;
import a.u;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class d
{
  private static final Map<String, EnumSet<n>> CdU;
  private static final Map<String, a.j.b.a.c.b.a.m> CdV;
  public static final d CdW;
  
  static
  {
    AppMethodBeat.i(119763);
    CdW = new d();
    CdU = ad.a(new o[] { u.F("PACKAGE", EnumSet.noneOf(n.class)), u.F("TYPE", EnumSet.of((Enum)n.BXP, (Enum)n.BYc)), u.F("ANNOTATION_TYPE", EnumSet.of((Enum)n.BXQ)), u.F("TYPE_PARAMETER", EnumSet.of((Enum)n.BXR)), u.F("FIELD", EnumSet.of((Enum)n.BXT)), u.F("LOCAL_VARIABLE", EnumSet.of((Enum)n.BXU)), u.F("PARAMETER", EnumSet.of((Enum)n.BXV)), u.F("CONSTRUCTOR", EnumSet.of((Enum)n.BXW)), u.F("METHOD", EnumSet.of((Enum)n.BXX, (Enum)n.BXY, (Enum)n.BXZ)), u.F("TYPE_USE", EnumSet.of((Enum)n.BYa)) });
    CdV = ad.a(new o[] { u.F("RUNTIME", a.j.b.a.c.b.a.m.BXL), u.F("CLASS", a.j.b.a.c.b.a.m.BXM), u.F("SOURCE", a.j.b.a.c.b.a.m.BXN) });
    AppMethodBeat.o(119763);
  }
  
  public static a.j.b.a.c.i.b.f<?> a(a.j.b.a.c.d.a.e.b paramb)
  {
    AppMethodBeat.i(119762);
    if (!(paramb instanceof a.j.b.a.c.d.a.e.m)) {
      paramb = null;
    }
    for (;;)
    {
      paramb = (a.j.b.a.c.d.a.e.m)paramb;
      if (paramb != null)
      {
        Object localObject = CdV;
        paramb = paramb.egq();
        if (paramb != null)
        {
          paramb = paramb.name;
          localObject = (a.j.b.a.c.b.a.m)((Map)localObject).get(paramb);
          if (localObject == null) {
            break label115;
          }
          paramb = a.n(g.BRU.BSG);
          a.f.b.j.p(paramb, "ClassId.topLevel(KotlinB…AMES.annotationRetention)");
          localObject = a.j.b.a.c.f.f.ayT(((a.j.b.a.c.b.a.m)localObject).name());
          a.f.b.j.p(localObject, "Name.identifier(retention.name)");
          paramb = new i(paramb, (a.j.b.a.c.f.f)localObject);
        }
      }
      for (;;)
      {
        paramb = (a.j.b.a.c.i.b.f)paramb;
        AppMethodBeat.o(119762);
        return paramb;
        paramb = null;
        break;
        label115:
        paramb = null;
        continue;
        paramb = null;
      }
    }
  }
  
  public static a.j.b.a.c.i.b.f<?> gd(List<? extends a.j.b.a.c.d.a.e.b> paramList)
  {
    AppMethodBeat.i(119761);
    a.f.b.j.q(paramList, "arguments");
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if ((localObject2 instanceof a.j.b.a.c.d.a.e.m)) {
        paramList.add(localObject2);
      }
    }
    paramList = (Iterable)paramList;
    localObject1 = (Collection)new ArrayList();
    Object localObject2 = paramList.iterator();
    if (((Iterator)localObject2).hasNext())
    {
      paramList = ((a.j.b.a.c.d.a.e.m)((Iterator)localObject2).next()).egq();
      if (paramList != null)
      {
        paramList = paramList.name;
        label127:
        paramList = (EnumSet)CdU.get(paramList);
        if (paramList == null) {
          break label166;
        }
      }
      label166:
      for (paramList = (Set)paramList;; paramList = (Set)x.BMz)
      {
        a.a.j.a((Collection)localObject1, (Iterable)paramList);
        break;
        paramList = null;
        break label127;
      }
    }
    localObject1 = (Iterable)localObject1;
    paramList = (Collection)new ArrayList(a.a.j.d((Iterable)localObject1));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (n)((Iterator)localObject1).next();
      localObject2 = a.n(g.BRU.BSF);
      a.f.b.j.p(localObject2, "ClassId.topLevel(KotlinB…Q_NAMES.annotationTarget)");
      localObject3 = a.j.b.a.c.f.f.ayT(((n)localObject3).name());
      a.f.b.j.p(localObject3, "Name.identifier(kotlinTarget.name)");
      paramList.add(new i((a)localObject2, (a.j.b.a.c.f.f)localObject3));
    }
    paramList = (a.j.b.a.c.i.b.f)new a.j.b.a.c.i.b.b((List)paramList, (a.f.a.b)d.a.CdX);
    AppMethodBeat.o(119761);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.c.d.a.a.d
 * JD-Core Version:    0.7.0.1
 */