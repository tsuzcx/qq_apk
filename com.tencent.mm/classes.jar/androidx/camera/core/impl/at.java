package androidx.camera.core.impl;

import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public final class at
  extends av
  implements as
{
  private static final ac.c MT = ac.c.Md;
  
  private at(TreeMap<ac.a<?>, Map<ac.c, Object>> paramTreeMap)
  {
    super(paramTreeMap);
  }
  
  public static at k(ac paramac)
  {
    AppMethodBeat.i(198864);
    TreeMap localTreeMap = new TreeMap(MU);
    Iterator localIterator = paramac.ke().iterator();
    while (localIterator.hasNext())
    {
      ac.a locala = (ac.a)localIterator.next();
      Object localObject = paramac.d(locala);
      ArrayMap localArrayMap = new ArrayMap();
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ac.c localc = (ac.c)((Iterator)localObject).next();
        localArrayMap.put(localc, paramac.a(locala, localc));
      }
      localTreeMap.put(locala, localArrayMap);
    }
    paramac = new at(localTreeMap);
    AppMethodBeat.o(198864);
    return paramac;
  }
  
  public static at ku()
  {
    AppMethodBeat.i(198857);
    at localat = new at(new TreeMap(MU));
    AppMethodBeat.o(198857);
    return localat;
  }
  
  public final <ValueT> void a(ac.a<ValueT> parama, ac.c paramc, ValueT paramValueT)
  {
    AppMethodBeat.i(198895);
    Object localObject = (Map)this.MW.get(parama);
    if (localObject == null)
    {
      localObject = new ArrayMap();
      this.MW.put(parama, localObject);
      ((Map)localObject).put(paramc, paramValueT);
      AppMethodBeat.o(198895);
      return;
    }
    ac.c localc = (ac.c)Collections.min(((Map)localObject).keySet());
    if ((((Map)localObject).get(localc).equals(paramValueT)) || (!ac.-CC.a(localc, paramc)))
    {
      ((Map)localObject).put(paramc, paramValueT);
      AppMethodBeat.o(198895);
      return;
    }
    parama = new IllegalArgumentException("Option values conflicts: " + parama.getId() + ", existing value (" + localc + ")=" + ((Map)localObject).get(localc) + ", conflicting (" + paramc + ")=" + paramValueT);
    AppMethodBeat.o(198895);
    throw parama;
  }
  
  public final <ValueT> void c(ac.a<ValueT> parama, ValueT paramValueT)
  {
    AppMethodBeat.i(198882);
    a(parama, MT, paramValueT);
    AppMethodBeat.o(198882);
  }
  
  public final <ValueT> ValueT e(ac.a<ValueT> parama)
  {
    AppMethodBeat.i(198875);
    parama = this.MW.remove(parama);
    AppMethodBeat.o(198875);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.impl.at
 * JD-Core Version:    0.7.0.1
 */