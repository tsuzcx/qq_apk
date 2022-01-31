package a.j.b.a.c.d.a;

import a.a.ad;
import a.a.v;
import a.j.b.a.c.a.g;
import a.j.b.a.c.b.al;
import a.j.b.a.c.b.l;
import a.j.b.a.c.f.f;
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

public final class c
{
  private static final r Ccg;
  private static final Map<r, f> Cch;
  private static final Map<String, f> Cci;
  private static final List<f> Ccj;
  private static final Map<f, List<f>> Cck;
  public static final c Ccl;
  
  static
  {
    AppMethodBeat.i(119665);
    Ccl = new c();
    Object localObject1 = a.j.b.a.c.i.d.c.CwX.desc;
    a.f.b.j.p(localObject1, "JvmPrimitiveType.INT.desc");
    Ccg = t.u("java/util/List", "removeAt", (String)localObject1, "Ljava/lang/Object;");
    localObject1 = a.j.b.a.c.d.b.t.Cjx;
    localObject1 = a.j.b.a.c.d.b.t.ayM("Number");
    Object localObject2 = a.j.b.a.c.i.d.c.CwV.desc;
    a.f.b.j.p(localObject2, "JvmPrimitiveType.BYTE.desc");
    localObject1 = u.F(t.u((String)localObject1, "toByte", "", (String)localObject2), f.ayT("byteValue"));
    localObject2 = a.j.b.a.c.d.b.t.ayM("Number");
    Object localObject3 = a.j.b.a.c.i.d.c.CwW.desc;
    a.f.b.j.p(localObject3, "JvmPrimitiveType.SHORT.desc");
    localObject2 = u.F(t.u((String)localObject2, "toShort", "", (String)localObject3), f.ayT("shortValue"));
    localObject3 = a.j.b.a.c.d.b.t.ayM("Number");
    Object localObject4 = a.j.b.a.c.i.d.c.CwX.desc;
    a.f.b.j.p(localObject4, "JvmPrimitiveType.INT.desc");
    localObject3 = u.F(t.u((String)localObject3, "toInt", "", (String)localObject4), f.ayT("intValue"));
    localObject4 = a.j.b.a.c.d.b.t.ayM("Number");
    Object localObject5 = a.j.b.a.c.i.d.c.CwZ.desc;
    a.f.b.j.p(localObject5, "JvmPrimitiveType.LONG.desc");
    localObject4 = u.F(t.u((String)localObject4, "toLong", "", (String)localObject5), f.ayT("longValue"));
    localObject5 = a.j.b.a.c.d.b.t.ayM("Number");
    Object localObject6 = a.j.b.a.c.i.d.c.CwY.desc;
    a.f.b.j.p(localObject6, "JvmPrimitiveType.FLOAT.desc");
    localObject5 = u.F(t.u((String)localObject5, "toFloat", "", (String)localObject6), f.ayT("floatValue"));
    localObject6 = a.j.b.a.c.d.b.t.ayM("Number");
    Object localObject7 = a.j.b.a.c.i.d.c.Cxa.desc;
    a.f.b.j.p(localObject7, "JvmPrimitiveType.DOUBLE.desc");
    localObject6 = u.F(t.u((String)localObject6, "toDouble", "", (String)localObject7), f.ayT("doubleValue"));
    localObject7 = u.F(Ccg, f.ayT("remove"));
    String str1 = a.j.b.a.c.d.b.t.ayM("CharSequence");
    String str2 = a.j.b.a.c.i.d.c.CwX.desc;
    a.f.b.j.p(str2, "JvmPrimitiveType.INT.desc");
    String str3 = a.j.b.a.c.i.d.c.CwU.desc;
    a.f.b.j.p(str3, "JvmPrimitiveType.CHAR.desc");
    localObject2 = ad.a(new o[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localObject7, u.F(t.u(str1, "get", str2, str3), f.ayT("charAt")) });
    Cch = (Map)localObject2;
    localObject1 = (Map)new LinkedHashMap(ad.TQ(((Map)localObject2).size()));
    localObject2 = ((Iterable)((Map)localObject2).entrySet()).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      ((Map)localObject1).put(((r)((Map.Entry)localObject3).getKey()).signature, ((Map.Entry)localObject3).getValue());
    }
    Cci = (Map)localObject1;
    localObject2 = (Iterable)Cch.keySet();
    localObject1 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject2));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((r)((Iterator)localObject2).next()).BYN);
    }
    Ccj = (List)localObject1;
    localObject2 = (Iterable)Cch.entrySet();
    localObject1 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject2));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      ((Collection)localObject1).add(new o(((r)((Map.Entry)localObject3).getKey()).BYN, ((Map.Entry)localObject3).getValue()));
    }
    localObject1 = (Iterable)localObject1;
    localObject2 = (Map)new LinkedHashMap();
    localObject3 = ((Iterable)localObject1).iterator();
    if (((Iterator)localObject3).hasNext())
    {
      localObject4 = ((Iterator)localObject3).next();
      localObject5 = (f)((o)localObject4).second;
      localObject1 = ((Map)localObject2).get(localObject5);
      if (localObject1 == null)
      {
        localObject1 = new ArrayList();
        ((Map)localObject2).put(localObject5, localObject1);
      }
      for (;;)
      {
        ((List)localObject1).add((f)((o)localObject4).first);
        break;
      }
    }
    Cck = (Map)localObject2;
    AppMethodBeat.o(119665);
  }
  
  public static f a(al paramal)
  {
    AppMethodBeat.i(119661);
    a.f.b.j.q(paramal, "functionDescriptor");
    Map localMap = Cci;
    paramal = a.j.b.a.c.d.b.r.c((a.j.b.a.c.b.a)paramal);
    if (paramal == null)
    {
      AppMethodBeat.o(119661);
      return null;
    }
    paramal = (f)localMap.get(paramal);
    AppMethodBeat.o(119661);
    return paramal;
  }
  
  public static boolean b(al paramal)
  {
    AppMethodBeat.i(119662);
    a.f.b.j.q(paramal, "functionDescriptor");
    if ((g.b((l)paramal)) && (a.j.b.a.c.i.c.a.b((a.j.b.a.c.b.b)paramal, (a.f.a.b)new c.a(paramal)) != null))
    {
      AppMethodBeat.o(119662);
      return true;
    }
    AppMethodBeat.o(119662);
    return false;
  }
  
  public static boolean c(al paramal)
  {
    AppMethodBeat.i(119664);
    a.f.b.j.q(paramal, "receiver$0");
    if ((a.f.b.j.e(paramal.edF().name, "removeAt")) && (a.f.b.j.e(a.j.b.a.c.d.b.r.c((a.j.b.a.c.b.a)paramal), Ccg.signature)))
    {
      AppMethodBeat.o(119664);
      return true;
    }
    AppMethodBeat.o(119664);
    return false;
  }
  
  public static List<f> eft()
  {
    return Ccj;
  }
  
  public static boolean f(f paramf)
  {
    AppMethodBeat.i(119660);
    a.f.b.j.q(paramf, "receiver$0");
    boolean bool = Ccj.contains(paramf);
    AppMethodBeat.o(119660);
    return bool;
  }
  
  public static List<f> g(f paramf)
  {
    AppMethodBeat.i(119663);
    a.f.b.j.q(paramf, "name");
    List localList = (List)Cck.get(paramf);
    paramf = localList;
    if (localList == null) {
      paramf = (List)v.BMx;
    }
    AppMethodBeat.o(119663);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.d.a.c
 * JD-Core Version:    0.7.0.1
 */