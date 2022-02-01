package androidx.camera.core.impl;

import android.util.ArrayMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class av
  implements ac
{
  protected static final Comparator<ac.a<?>> MU;
  private static final av MV;
  protected final TreeMap<ac.a<?>, Map<ac.c, Object>> MW;
  
  static
  {
    AppMethodBeat.i(198890);
    MU = av..ExternalSyntheticLambda0.INSTANCE;
    MV = new av(new TreeMap(MU));
    AppMethodBeat.o(198890);
  }
  
  av(TreeMap<ac.a<?>, Map<ac.c, Object>> paramTreeMap)
  {
    this.MW = paramTreeMap;
  }
  
  public static av kw()
  {
    return MV;
  }
  
  public static av l(ac paramac)
  {
    AppMethodBeat.i(198873);
    if (av.class.equals(paramac.getClass()))
    {
      paramac = (av)paramac;
      AppMethodBeat.o(198873);
      return paramac;
    }
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
    paramac = new av(localTreeMap);
    AppMethodBeat.o(198873);
    return paramac;
  }
  
  public final <ValueT> ValueT a(ac.a<ValueT> parama, ac.c paramc)
  {
    AppMethodBeat.i(198931);
    Map localMap = (Map)this.MW.get(parama);
    if (localMap == null)
    {
      parama = new IllegalArgumentException("Option does not exist: ".concat(String.valueOf(parama)));
      AppMethodBeat.o(198931);
      throw parama;
    }
    if (!localMap.containsKey(paramc))
    {
      parama = new IllegalArgumentException("Option does not exist: " + parama + " with priority=" + paramc);
      AppMethodBeat.o(198931);
      throw parama;
    }
    parama = localMap.get(paramc);
    AppMethodBeat.o(198931);
    return parama;
  }
  
  public final void a(String paramString, ac.b paramb)
  {
    AppMethodBeat.i(198939);
    Object localObject = ac.a.a(paramString, Void.class, null);
    localObject = this.MW.tailMap(localObject).entrySet().iterator();
    Map.Entry localEntry;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localEntry = (Map.Entry)((Iterator)localObject).next();
    } while ((((ac.a)localEntry.getKey()).getId().startsWith(paramString)) && (paramb.onOptionMatched((ac.a)localEntry.getKey())));
    AppMethodBeat.o(198939);
  }
  
  public final boolean a(ac.a<?> parama)
  {
    AppMethodBeat.i(198910);
    boolean bool = this.MW.containsKey(parama);
    AppMethodBeat.o(198910);
    return bool;
  }
  
  public final <ValueT> ValueT b(ac.a<ValueT> parama)
  {
    AppMethodBeat.i(198916);
    Map localMap = (Map)this.MW.get(parama);
    if (localMap == null)
    {
      parama = new IllegalArgumentException("Option does not exist: ".concat(String.valueOf(parama)));
      AppMethodBeat.o(198916);
      throw parama;
    }
    parama = localMap.get((ac.c)Collections.min(localMap.keySet()));
    AppMethodBeat.o(198916);
    return parama;
  }
  
  public final <ValueT> ValueT b(ac.a<ValueT> parama, ValueT paramValueT)
  {
    AppMethodBeat.i(198926);
    try
    {
      parama = b(parama);
      AppMethodBeat.o(198926);
      return parama;
    }
    catch (IllegalArgumentException parama)
    {
      AppMethodBeat.o(198926);
    }
    return paramValueT;
  }
  
  public final ac.c c(ac.a<?> parama)
  {
    AppMethodBeat.i(198934);
    Map localMap = (Map)this.MW.get(parama);
    if (localMap == null)
    {
      parama = new IllegalArgumentException("Option does not exist: ".concat(String.valueOf(parama)));
      AppMethodBeat.o(198934);
      throw parama;
    }
    parama = (ac.c)Collections.min(localMap.keySet());
    AppMethodBeat.o(198934);
    return parama;
  }
  
  public final Set<ac.c> d(ac.a<?> parama)
  {
    AppMethodBeat.i(198944);
    parama = (Map)this.MW.get(parama);
    if (parama == null)
    {
      parama = Collections.emptySet();
      AppMethodBeat.o(198944);
      return parama;
    }
    parama = Collections.unmodifiableSet(parama.keySet());
    AppMethodBeat.o(198944);
    return parama;
  }
  
  public final Set<ac.a<?>> ke()
  {
    AppMethodBeat.i(198904);
    Set localSet = Collections.unmodifiableSet(this.MW.keySet());
    AppMethodBeat.o(198904);
    return localSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.impl.av
 * JD-Core Version:    0.7.0.1
 */