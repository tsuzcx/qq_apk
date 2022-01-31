package a.j.b.a.c.d.a;

import a.a.ad;
import a.a.v;
import a.aa;
import a.j.b.a.c.a.g;
import a.j.b.a.c.a.g.a;
import a.j.b.a.c.b.l;
import a.j.b.a.c.f.c;
import a.j.b.a.c.f.f;
import a.j.b.a.c.i.c.a;
import a.o;
import a.u;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class e
{
  private static final Map<a.j.b.a.c.f.b, f> CcJ;
  private static final Map<f, List<f>> CcK;
  private static final Set<a.j.b.a.c.f.b> CcL;
  private static final Set<f> CcM;
  public static final e CcN;
  
  static
  {
    AppMethodBeat.i(119686);
    CcN = new e();
    Object localObject1 = g.BRU.BSr;
    a.f.b.j.p(localObject1, "BUILTIN_NAMES._enum");
    localObject1 = u.F(t.b((c)localObject1, "name"), f.ayT("name"));
    Object localObject2 = g.BRU.BSr;
    a.f.b.j.p(localObject2, "BUILTIN_NAMES._enum");
    localObject2 = u.F(t.b((c)localObject2, "ordinal"), f.ayT("ordinal"));
    Object localObject3 = g.BRU.BSO;
    a.f.b.j.p(localObject3, "BUILTIN_NAMES.collection");
    localObject3 = u.F(t.a((a.j.b.a.c.f.b)localObject3, "size"), f.ayT("size"));
    Object localObject4 = g.BRU.BSS;
    a.f.b.j.p(localObject4, "BUILTIN_NAMES.map");
    localObject4 = u.F(t.a((a.j.b.a.c.f.b)localObject4, "size"), f.ayT("size"));
    Object localObject5 = g.BRU.BSf;
    a.f.b.j.p(localObject5, "BUILTIN_NAMES.charSequence");
    localObject5 = u.F(t.b((c)localObject5, "length"), f.ayT("length"));
    Object localObject6 = g.BRU.BSS;
    a.f.b.j.p(localObject6, "BUILTIN_NAMES.map");
    localObject6 = u.F(t.a((a.j.b.a.c.f.b)localObject6, "keys"), f.ayT("keySet"));
    Object localObject7 = g.BRU.BSS;
    a.f.b.j.p(localObject7, "BUILTIN_NAMES.map");
    localObject7 = u.F(t.a((a.j.b.a.c.f.b)localObject7, "values"), f.ayT("values"));
    a.j.b.a.c.f.b localb = g.BRU.BSS;
    a.f.b.j.p(localb, "BUILTIN_NAMES.map");
    localObject1 = ad.a(new o[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localObject7, u.F(t.a(localb, "entries"), f.ayT("entrySet")) });
    CcJ = (Map)localObject1;
    localObject2 = (Iterable)((Map)localObject1).entrySet();
    localObject1 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject2));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      ((Collection)localObject1).add(new o(((a.j.b.a.c.f.b)((Map.Entry)localObject3).getKey()).CqE.emh(), ((Map.Entry)localObject3).getValue()));
    }
    localObject1 = (Iterable)localObject1;
    localObject2 = (Map)new LinkedHashMap();
    localObject3 = ((Iterable)localObject1).iterator();
    if (((Iterator)localObject3).hasNext())
    {
      localObject4 = ((Iterator)localObject3).next();
      localObject5 = (f)((o)localObject4).second;
      localObject1 = ((Map)localObject2).get(localObject5);
      if (localObject1 != null) {
        break label596;
      }
      localObject1 = new ArrayList();
      ((Map)localObject2).put(localObject5, localObject1);
    }
    label596:
    for (;;)
    {
      ((List)localObject1).add((f)((o)localObject4).first);
      break;
      CcK = (Map)localObject2;
      localObject1 = CcJ.keySet();
      CcL = (Set)localObject1;
      localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject2));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add(((a.j.b.a.c.f.b)((Iterator)localObject2).next()).CqE.emh());
      }
      CcM = a.a.j.o((Iterable)localObject1);
      AppMethodBeat.o(119686);
      return;
    }
  }
  
  public static Set<f> efv()
  {
    return CcM;
  }
  
  public static List<f> i(f paramf)
  {
    AppMethodBeat.i(119684);
    a.f.b.j.q(paramf, "name1");
    List localList = (List)CcK.get(paramf);
    paramf = localList;
    if (localList == null) {
      paramf = (List)v.BMx;
    }
    AppMethodBeat.o(119684);
    return paramf;
  }
  
  public static boolean l(a.j.b.a.c.b.b paramb)
  {
    AppMethodBeat.i(119683);
    a.f.b.j.q(paramb, "callableMemberDescriptor");
    if (!CcM.contains(paramb.edF()))
    {
      AppMethodBeat.o(119683);
      return false;
    }
    if ((a.a.j.a((Iterable)CcL, a.I((l)paramb))) && (paramb.edu().isEmpty()))
    {
      AppMethodBeat.o(119683);
      return true;
    }
    if (g.b((l)paramb))
    {
      paramb = paramb.edw();
      a.f.b.j.p(paramb, "overriddenDescriptors");
      paramb = (Iterable)paramb;
      if ((!(paramb instanceof Collection)) || (!((Collection)paramb).isEmpty()))
      {
        paramb = paramb.iterator();
        while (paramb.hasNext())
        {
          a.j.b.a.c.b.b localb = (a.j.b.a.c.b.b)paramb.next();
          a.f.b.j.p(localb, "it");
          if (l(localb))
          {
            AppMethodBeat.o(119683);
            return true;
          }
        }
      }
    }
    AppMethodBeat.o(119683);
    return false;
  }
  
  public static String m(a.j.b.a.c.b.b paramb)
  {
    AppMethodBeat.i(119685);
    a.f.b.j.q(paramb, "receiver$0");
    boolean bool = g.b((l)paramb);
    if ((aa.BMh) && (!bool))
    {
      paramb = (Throwable)new AssertionError("This method is defined only for builtin members, but " + paramb + " found");
      AppMethodBeat.o(119685);
      throw paramb;
    }
    paramb = a.b(a.x(paramb), (a.f.a.b)e.a.CcO);
    if (paramb == null)
    {
      AppMethodBeat.o(119685);
      return null;
    }
    paramb = (f)CcJ.get(a.o((l)paramb));
    if (paramb != null)
    {
      paramb = paramb.name;
      AppMethodBeat.o(119685);
      return paramb;
    }
    AppMethodBeat.o(119685);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.c.d.a.e
 * JD-Core Version:    0.7.0.1
 */