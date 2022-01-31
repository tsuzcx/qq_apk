package a.j.b.a.c.d.a.f;

import a.a.ad;
import a.a.y;
import a.j.b.a.c.d.b.t;
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

public final class m$a$a
{
  private o<String, r> Cir;
  private final String iHa;
  private final List<o<String, r>> parameters;
  
  public m$a$a(String paramString)
  {
    AppMethodBeat.i(120183);
    this.iHa = localObject;
    this.parameters = ((List)new ArrayList());
    this.Cir = u.F("V", null);
    AppMethodBeat.o(120183);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(120181);
    a.f.b.j.q(paramc, "type");
    this.Cir = u.F(paramc.desc, null);
    AppMethodBeat.o(120181);
  }
  
  public final void a(String paramString, d... paramVarArgs)
  {
    AppMethodBeat.i(120179);
    a.f.b.j.q(paramString, "type");
    a.f.b.j.q(paramVarArgs, "qualifiers");
    Collection localCollection = (Collection)this.parameters;
    int i;
    if (paramVarArgs.length == 0)
    {
      i = 1;
      if (i == 0) {
        break label63;
      }
    }
    for (paramVarArgs = null;; paramVarArgs = new r(paramVarArgs))
    {
      localCollection.add(u.F(paramString, paramVarArgs));
      AppMethodBeat.o(120179);
      return;
      i = 0;
      break;
      label63:
      Object localObject1 = a.a.e.T(paramVarArgs);
      paramVarArgs = (Map)new LinkedHashMap(a.i.e.iE(ad.TQ(a.a.j.d((Iterable)localObject1)), 16));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        paramVarArgs.put(Integer.valueOf(((y)localObject2).index), (d)((y)localObject2).value);
      }
    }
  }
  
  public final void b(String paramString, d... paramVarArgs)
  {
    AppMethodBeat.i(120180);
    a.f.b.j.q(paramString, "type");
    a.f.b.j.q(paramVarArgs, "qualifiers");
    Object localObject1 = a.a.e.T(paramVarArgs);
    paramVarArgs = (Map)new LinkedHashMap(a.i.e.iE(ad.TQ(a.a.j.d((Iterable)localObject1)), 16));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      paramVarArgs.put(Integer.valueOf(((y)localObject2).index), (d)((y)localObject2).value);
    }
    this.Cir = u.F(paramString, new r(paramVarArgs));
    AppMethodBeat.o(120180);
  }
  
  public final o<String, j> egN()
  {
    AppMethodBeat.i(120182);
    Object localObject1 = t.Cjx;
    localObject1 = this.Cis.className;
    Object localObject2 = this.iHa;
    Object localObject3 = (Iterable)this.parameters;
    Collection localCollection = (Collection)new ArrayList(a.a.j.d((Iterable)localObject3));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      localCollection.add((String)((o)((Iterator)localObject3).next()).first);
    }
    localObject1 = t.jq((String)localObject1, t.e((String)localObject2, (List)localCollection, (String)this.Cir.first));
    localObject2 = (r)this.Cir.second;
    localObject3 = (Iterable)this.parameters;
    localCollection = (Collection)new ArrayList(a.a.j.d((Iterable)localObject3));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      localCollection.add((r)((o)((Iterator)localObject3).next()).second);
    }
    localObject1 = u.F(localObject1, new j((r)localObject2, (List)localCollection));
    AppMethodBeat.o(120182);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.d.a.f.m.a.a
 * JD-Core Version:    0.7.0.1
 */