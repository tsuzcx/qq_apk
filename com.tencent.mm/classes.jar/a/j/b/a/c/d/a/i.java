package a.j.b.a.c.d.a;

import a.f.b.j;
import a.j.b.a.c.a.g;
import a.j.b.a.c.a.g.a;
import a.j.b.a.c.f.b;
import a.o;
import a.u;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class i
{
  private static final HashMap<b, b> CcQ;
  public static final i CcR;
  
  static
  {
    AppMethodBeat.i(119693);
    CcR = new i();
    CcQ = new HashMap();
    b localb = g.BRU.BSX;
    j.p(localb, "FQ_NAMES.mutableList");
    a(localb, ac(new String[] { "java.util.ArrayList", "java.util.LinkedList" }));
    localb = g.BRU.BSZ;
    j.p(localb, "FQ_NAMES.mutableSet");
    a(localb, ac(new String[] { "java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet" }));
    localb = g.BRU.BTa;
    j.p(localb, "FQ_NAMES.mutableMap");
    a(localb, ac(new String[] { "java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap" }));
    a(new b("java.util.function.Function"), ac(new String[] { "java.util.function.UnaryOperator" }));
    a(new b("java.util.function.BiFunction"), ac(new String[] { "java.util.function.BinaryOperator" }));
    AppMethodBeat.o(119693);
  }
  
  private static void a(b paramb, List<b> paramList)
  {
    AppMethodBeat.i(119691);
    Object localObject = (Iterable)paramList;
    paramList = (Map)CcQ;
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      o localo = u.F((b)((Iterator)localObject).next(), paramb);
      paramList.put(localo.first, localo.second);
    }
    AppMethodBeat.o(119691);
  }
  
  private static List<b> ac(String... paramVarArgs)
  {
    AppMethodBeat.i(119692);
    Collection localCollection = (Collection)new ArrayList(paramVarArgs.length);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      localCollection.add(new b(paramVarArgs[i]));
      i += 1;
    }
    paramVarArgs = (List)localCollection;
    AppMethodBeat.o(119692);
    return paramVarArgs;
  }
  
  public static b k(b paramb)
  {
    AppMethodBeat.i(119690);
    j.q(paramb, "classFqName");
    paramb = (b)CcQ.get(paramb);
    AppMethodBeat.o(119690);
    return paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.d.a.i
 * JD-Core Version:    0.7.0.1
 */