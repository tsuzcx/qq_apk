package a.j.b.a.c.a;

import a.aa;
import a.j.b.a.c.a.a.a.a;
import a.j.b.a.c.a.a.b.b;
import a.j.b.a.c.b.e;
import a.j.b.a.c.b.l;
import a.j.b.a.c.f.b;
import a.j.b.a.c.i.b.s;
import a.j.b.a.c.l.an;
import a.j.b.a.c.l.ap;
import a.j.b.a.c.l.w;
import a.j.b.a.c.l.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class f
{
  private static b.b a(l paraml)
  {
    AppMethodBeat.i(119084);
    a.f.b.j.q(paraml, "receiver$0");
    if (!(paraml instanceof e))
    {
      AppMethodBeat.o(119084);
      return null;
    }
    if (!g.c(paraml))
    {
      AppMethodBeat.o(119084);
      return null;
    }
    paraml = a(a.j.b.a.c.i.c.a.q(paraml));
    AppMethodBeat.o(119084);
    return paraml;
  }
  
  private static final b.b a(a.j.b.a.c.f.c paramc)
  {
    AppMethodBeat.i(119085);
    if ((!paramc.eme()) || (paramc.CqJ.isEmpty()))
    {
      AppMethodBeat.o(119085);
      return null;
    }
    Object localObject = a.j.b.a.c.a.a.a.BUw;
    localObject = paramc.emh().name;
    a.f.b.j.p(localObject, "shortName().asString()");
    paramc = paramc.emf().emd();
    a.f.b.j.p(paramc, "toSafe().parent()");
    paramc = a.a.b((String)localObject, paramc);
    AppMethodBeat.o(119085);
    return paramc;
  }
  
  public static final a.j.b.a.c.l.ad a(g paramg, a.j.b.a.c.b.a.g paramg1, w paramw1, List<? extends w> paramList, w paramw2, boolean paramBoolean)
  {
    AppMethodBeat.i(119090);
    a.f.b.j.q(paramg, "builtIns");
    a.f.b.j.q(paramg1, "annotations");
    a.f.b.j.q(paramList, "parameterTypes");
    a.f.b.j.q(paramw2, "returnType");
    a.f.b.j.q(paramList, "parameterTypes");
    a.f.b.j.q(paramw2, "returnType");
    a.f.b.j.q(paramg, "builtIns");
    int j = paramList.size();
    ArrayList localArrayList;
    Object localObject2;
    if (paramw1 != null)
    {
      i = 1;
      localArrayList = new ArrayList(i + j + 1);
      localObject2 = (Collection)localArrayList;
      if (paramw1 == null) {
        break label183;
      }
    }
    label183:
    for (Object localObject1 = a.j.b.a.c.l.c.a.aM(paramw1);; localObject1 = null)
    {
      a.j.b.a.c.n.a.b((Collection)localObject2, localObject1);
      localObject1 = ((Iterable)paramList).iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        Collection localCollection = (Collection)localArrayList;
        if (i < 0) {
          a.a.j.eaS();
        }
        localCollection.add(a.j.b.a.c.l.c.a.aM((w)localObject2));
        i += 1;
      }
      i = 0;
      break;
    }
    localArrayList.add(a.j.b.a.c.l.c.a.aM(paramw2));
    localObject1 = (List)localArrayList;
    int i = paramList.size();
    if (paramw1 == null)
    {
      if (!paramBoolean) {
        break label295;
      }
      paramList = paramg.TU(i);
      label231:
      a.f.b.j.p(paramList, "if (suspendFunction) bui…tFunction(parameterCount)");
      paramw2 = paramg1;
      if (paramw1 != null)
      {
        paramw1 = g.BRU.BSB;
        a.f.b.j.p(paramw1, "KotlinBuiltIns.FQ_NAMES.extensionFunctionType");
        if (paramg1.i(paramw1) == null) {
          break label308;
        }
      }
    }
    for (paramw2 = paramg1;; paramw2 = a.j.b.a.c.b.a.g.a.fZ(a.a.j.d(paramg1, new a.j.b.a.c.b.a.j(paramg, paramw1, a.a.ad.emptyMap()))))
    {
      paramg = x.a(paramw2, paramList, (List)localObject1);
      AppMethodBeat.o(119090);
      return paramg;
      i += 1;
      break;
      label295:
      paramList = paramg.ayx(g.TS(i));
      break label231;
      label308:
      paramw1 = a.j.b.a.c.b.a.g.BXx;
      paramg1 = (Iterable)paramg1;
      paramw1 = g.BRU.BSB;
      a.f.b.j.p(paramw1, "KotlinBuiltIns.FQ_NAMES.extensionFunctionType");
    }
  }
  
  public static final boolean d(w paramw)
  {
    AppMethodBeat.i(119080);
    a.f.b.j.q(paramw, "receiver$0");
    paramw = paramw.enU().ecR();
    if (paramw != null) {}
    for (paramw = a((l)paramw); paramw == b.b.BUF; paramw = null)
    {
      AppMethodBeat.o(119080);
      return true;
    }
    AppMethodBeat.o(119080);
    return false;
  }
  
  public static final boolean e(w paramw)
  {
    AppMethodBeat.i(119081);
    a.f.b.j.q(paramw, "receiver$0");
    paramw = paramw.enU().ecR();
    if (paramw != null) {}
    for (paramw = a((l)paramw); paramw == b.b.BUG; paramw = null)
    {
      AppMethodBeat.o(119081);
      return true;
    }
    AppMethodBeat.o(119081);
    return false;
  }
  
  public static final boolean f(w paramw)
  {
    AppMethodBeat.i(119082);
    a.f.b.j.q(paramw, "receiver$0");
    paramw = paramw.enU().ecR();
    if (paramw != null) {}
    for (paramw = a((l)paramw); (paramw == b.b.BUF) || (paramw == b.b.BUG); paramw = null)
    {
      AppMethodBeat.o(119082);
      return true;
    }
    AppMethodBeat.o(119082);
    return false;
  }
  
  private static final boolean g(w paramw)
  {
    AppMethodBeat.i(119083);
    paramw = paramw.ecM();
    b localb = g.BRU.BSB;
    a.f.b.j.p(localb, "KotlinBuiltIns.FQ_NAMES.extensionFunctionType");
    if (paramw.i(localb) != null)
    {
      AppMethodBeat.o(119083);
      return true;
    }
    AppMethodBeat.o(119083);
    return false;
  }
  
  public static final w h(w paramw)
  {
    AppMethodBeat.i(119086);
    a.f.b.j.q(paramw, "receiver$0");
    boolean bool = f(paramw);
    if ((aa.BMh) && (!bool))
    {
      paramw = (Throwable)new AssertionError("Not a function type: ".concat(String.valueOf(paramw)));
      AppMethodBeat.o(119086);
      throw paramw;
    }
    if (g(paramw))
    {
      paramw = ((ap)a.a.j.fQ(paramw.enR())).eer();
      AppMethodBeat.o(119086);
      return paramw;
    }
    AppMethodBeat.o(119086);
    return null;
  }
  
  public static final w i(w paramw)
  {
    AppMethodBeat.i(119087);
    a.f.b.j.q(paramw, "receiver$0");
    boolean bool = f(paramw);
    if ((aa.BMh) && (!bool))
    {
      paramw = (Throwable)new AssertionError("Not a function type: ".concat(String.valueOf(paramw)));
      AppMethodBeat.o(119087);
      throw paramw;
    }
    paramw = ((ap)a.a.j.fS(paramw.enR())).eer();
    a.f.b.j.p(paramw, "arguments.last().type");
    AppMethodBeat.o(119087);
    return paramw;
  }
  
  public static final List<ap> j(w paramw)
  {
    int j = 1;
    AppMethodBeat.i(119088);
    a.f.b.j.q(paramw, "receiver$0");
    boolean bool = f(paramw);
    if ((aa.BMh) && (!bool))
    {
      paramw = (Throwable)new AssertionError("Not a function type: ".concat(String.valueOf(paramw)));
      AppMethodBeat.o(119088);
      throw paramw;
    }
    List localList = paramw.enR();
    a.f.b.j.q(paramw, "receiver$0");
    int i;
    label94:
    int k;
    if ((f(paramw)) && (g(paramw)))
    {
      i = 1;
      if (i == 0) {
        break label153;
      }
      i = 1;
      k = localList.size() - 1;
      if (i > k) {
        break label158;
      }
    }
    for (;;)
    {
      if ((!aa.BMh) || (j != 0)) {
        break label163;
      }
      paramw = (Throwable)new AssertionError("Not an exact function type: ".concat(String.valueOf(paramw)));
      AppMethodBeat.o(119088);
      throw paramw;
      i = 0;
      break;
      label153:
      i = 0;
      break label94;
      label158:
      j = 0;
    }
    label163:
    paramw = localList.subList(i, k);
    AppMethodBeat.o(119088);
    return paramw;
  }
  
  public static final a.j.b.a.c.f.f k(w paramw)
  {
    AppMethodBeat.i(119089);
    a.f.b.j.q(paramw, "receiver$0");
    paramw = paramw.ecM();
    Object localObject = g.BRU.BSC;
    a.f.b.j.p(localObject, "KotlinBuiltIns.FQ_NAMES.parameterName");
    paramw = paramw.i((b)localObject);
    if (paramw == null)
    {
      AppMethodBeat.o(119089);
      return null;
    }
    localObject = a.a.j.i((Iterable)paramw.eeG().values());
    paramw = (w)localObject;
    if (!(localObject instanceof s)) {
      paramw = null;
    }
    paramw = (s)paramw;
    if (paramw != null)
    {
      paramw = (String)paramw.getValue();
      if (paramw != null) {
        if (!a.j.b.a.c.f.f.ayU(paramw)) {
          break label120;
        }
      }
    }
    while (paramw == null)
    {
      AppMethodBeat.o(119089);
      return null;
      label120:
      paramw = null;
    }
    paramw = a.j.b.a.c.f.f.ayT(paramw);
    AppMethodBeat.o(119089);
    return paramw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.a.f
 * JD-Core Version:    0.7.0.1
 */