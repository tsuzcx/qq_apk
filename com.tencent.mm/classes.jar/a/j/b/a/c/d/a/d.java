package a.j.b.a.c.d.a;

import a.a.ad;
import a.a.aj;
import a.f.b.k;
import a.j.b.a.c.f.f;
import a.j.b.a.c.i.d.c;
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

public final class d
{
  private static final List<r> Ccn;
  private static final List<String> Cco;
  private static final List<String> Ccp;
  private static final Map<r, d.b> Ccq;
  private static final Map<String, d.b> Ccr;
  private static final Set<f> Ccs;
  private static final Set<String> Cct;
  public static final d Ccu;
  
  static
  {
    AppMethodBeat.i(119679);
    Ccu = new d();
    Object localObject2 = (Iterable)aj.setOf(new String[] { "containsAll", "removeAll", "retainAll" });
    Object localObject1 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject2));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      localObject4 = c.CwT.desc;
      a.f.b.j.p(localObject4, "JvmPrimitiveType.BOOLEAN.desc");
      ((Collection)localObject1).add(t.u("java/util/Collection", (String)localObject3, "Ljava/util/Collection;", (String)localObject4));
    }
    localObject1 = (List)localObject1;
    Ccn = (List)localObject1;
    localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject2));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((r)((Iterator)localObject2).next()).signature);
    }
    Cco = (List)localObject1;
    localObject2 = (Iterable)Ccn;
    localObject1 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject2));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((r)((Iterator)localObject2).next()).BYN.name);
    }
    Ccp = (List)localObject1;
    localObject1 = a.j.b.a.c.d.b.t.Cjx;
    localObject1 = a.j.b.a.c.d.b.t.ayN("Collection");
    localObject2 = c.CwT.desc;
    a.f.b.j.p(localObject2, "JvmPrimitiveType.BOOLEAN.desc");
    localObject1 = u.F(t.u((String)localObject1, "contains", "Ljava/lang/Object;", (String)localObject2), d.b.CcD);
    localObject2 = a.j.b.a.c.d.b.t.ayN("Collection");
    Object localObject3 = c.CwT.desc;
    a.f.b.j.p(localObject3, "JvmPrimitiveType.BOOLEAN.desc");
    localObject2 = u.F(t.u((String)localObject2, "remove", "Ljava/lang/Object;", (String)localObject3), d.b.CcD);
    localObject3 = a.j.b.a.c.d.b.t.ayN("Map");
    Object localObject4 = c.CwT.desc;
    a.f.b.j.p(localObject4, "JvmPrimitiveType.BOOLEAN.desc");
    localObject3 = u.F(t.u((String)localObject3, "containsKey", "Ljava/lang/Object;", (String)localObject4), d.b.CcD);
    localObject4 = a.j.b.a.c.d.b.t.ayN("Map");
    Object localObject5 = c.CwT.desc;
    a.f.b.j.p(localObject5, "JvmPrimitiveType.BOOLEAN.desc");
    localObject4 = u.F(t.u((String)localObject4, "containsValue", "Ljava/lang/Object;", (String)localObject5), d.b.CcD);
    localObject5 = a.j.b.a.c.d.b.t.ayN("Map");
    Object localObject6 = c.CwT.desc;
    a.f.b.j.p(localObject6, "JvmPrimitiveType.BOOLEAN.desc");
    localObject5 = u.F(t.u((String)localObject5, "remove", "Ljava/lang/Object;Ljava/lang/Object;", (String)localObject6), d.b.CcD);
    localObject6 = u.F(t.u(a.j.b.a.c.d.b.t.ayN("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), d.b.CcE);
    o localo1 = u.F(t.u(a.j.b.a.c.d.b.t.ayN("Map"), "get", "Ljava/lang/Object;", "Ljava/lang/Object;"), d.b.CcB);
    o localo2 = u.F(t.u(a.j.b.a.c.d.b.t.ayN("Map"), "remove", "Ljava/lang/Object;", "Ljava/lang/Object;"), d.b.CcB);
    Object localObject7 = a.j.b.a.c.d.b.t.ayN("List");
    String str1 = c.CwX.desc;
    a.f.b.j.p(str1, "JvmPrimitiveType.INT.desc");
    localObject7 = u.F(t.u((String)localObject7, "indexOf", "Ljava/lang/Object;", str1), d.b.CcC);
    str1 = a.j.b.a.c.d.b.t.ayN("List");
    String str2 = c.CwX.desc;
    a.f.b.j.p(str2, "JvmPrimitiveType.INT.desc");
    localObject2 = ad.a(new o[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localo1, localo2, localObject7, u.F(t.u(str1, "lastIndexOf", "Ljava/lang/Object;", str2), d.b.CcC) });
    Ccq = (Map)localObject2;
    localObject1 = (Map)new LinkedHashMap(ad.TQ(((Map)localObject2).size()));
    localObject2 = ((Iterable)((Map)localObject2).entrySet()).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      ((Map)localObject1).put(((r)((Map.Entry)localObject3).getKey()).signature, ((Map.Entry)localObject3).getValue());
    }
    Ccr = (Map)localObject1;
    localObject1 = aj.a(Ccq.keySet(), (Iterable)Ccn);
    localObject3 = (Iterable)localObject1;
    localObject2 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject3));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((Collection)localObject2).add(((r)((Iterator)localObject3).next()).BYN);
    }
    Ccs = a.a.j.o((Iterable)localObject2);
    localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject2));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((r)((Iterator)localObject2).next()).signature);
    }
    Cct = a.a.j.o((Iterable)localObject1);
    AppMethodBeat.o(119679);
  }
  
  public static final a.j.b.a.c.b.t e(a.j.b.a.c.b.t paramt)
  {
    AppMethodBeat.i(119676);
    a.f.b.j.q(paramt, "functionDescriptor");
    f localf = paramt.edF();
    a.f.b.j.p(localf, "functionDescriptor.name");
    if (!h(localf))
    {
      AppMethodBeat.o(119676);
      return null;
    }
    paramt = (a.j.b.a.c.b.t)a.j.b.a.c.i.c.a.b((a.j.b.a.c.b.b)paramt, (a.f.a.b)c.CcH);
    AppMethodBeat.o(119676);
    return paramt;
  }
  
  public static boolean h(f paramf)
  {
    AppMethodBeat.i(119677);
    a.f.b.j.q(paramf, "receiver$0");
    boolean bool = Ccs.contains(paramf);
    AppMethodBeat.o(119677);
    return bool;
  }
  
  public static final d.a j(a.j.b.a.c.b.b paramb)
  {
    AppMethodBeat.i(119678);
    a.f.b.j.q(paramb, "receiver$0");
    if (!Ccs.contains(paramb.edF()))
    {
      AppMethodBeat.o(119678);
      return null;
    }
    paramb = a.j.b.a.c.i.c.a.b(paramb, (a.f.a.b)d.d.CcI);
    if (paramb != null)
    {
      paramb = a.j.b.a.c.d.b.r.c((a.j.b.a.c.b.a)paramb);
      if (paramb != null) {}
    }
    else
    {
      AppMethodBeat.o(119678);
      return null;
    }
    if (Cco.contains(paramb))
    {
      paramb = d.a.Ccv;
      AppMethodBeat.o(119678);
      return paramb;
    }
    paramb = Ccr.get(paramb);
    if (paramb == null) {
      a.f.b.j.ebi();
    }
    if ((d.b)paramb == d.b.CcB)
    {
      paramb = d.a.Ccx;
      AppMethodBeat.o(119678);
      return paramb;
    }
    paramb = d.a.Ccw;
    AppMethodBeat.o(119678);
    return paramb;
  }
  
  static final class c
    extends k
    implements a.f.a.b<a.j.b.a.c.b.b, Boolean>
  {
    public static final c CcH;
    
    static
    {
      AppMethodBeat.i(119673);
      CcH = new c();
      AppMethodBeat.o(119673);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.d.a.d
 * JD-Core Version:    0.7.0.1
 */