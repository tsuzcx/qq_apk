package coil.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.g.b.a.a;
import kotlin.g.b.s;
import kotlin.r;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcoil/request/Parameters;", "", "Lkotlin/Pair;", "", "Lcoil/request/Parameters$Entry;", "()V", "map", "", "(Ljava/util/Map;)V", "size", "", "()I", "cacheKey", "key", "cacheKeys", "entry", "equals", "", "other", "", "hashCode", "isEmpty", "iterator", "", "newBuilder", "Lcoil/request/Parameters$Builder;", "toString", "value", "values", "Builder", "Companion", "Entry", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  implements Iterable<r<? extends String, ? extends c>>, a
{
  public static final b cpO;
  public static final l cpP;
  private final Map<String, c> map;
  
  static
  {
    AppMethodBeat.i(187905);
    cpO = new b((byte)0);
    cpP = new l();
    AppMethodBeat.o(187905);
  }
  
  public l()
  {
    this(ak.kkZ());
    AppMethodBeat.i(187889);
    AppMethodBeat.o(187889);
  }
  
  private l(Map<String, c> paramMap)
  {
    this.map = paramMap;
  }
  
  public final Map<String, String> Nf()
  {
    AppMethodBeat.i(187915);
    if (this.map.isEmpty())
    {
      localMap = ak.kkZ();
      AppMethodBeat.o(187915);
      return localMap;
    }
    Object localObject = this.map;
    Map localMap = (Map)new LinkedHashMap();
    localObject = ((Map)localObject).entrySet().iterator();
    if (((Iterator)localObject).hasNext())
    {
      ((Map.Entry)((Iterator)localObject).next()).getValue();
      AppMethodBeat.o(187915);
      throw null;
    }
    AppMethodBeat.o(187915);
    return localMap;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(187935);
    if ((this == paramObject) || (((paramObject instanceof l)) && (s.p(this.map, ((l)paramObject).map))))
    {
      AppMethodBeat.o(187935);
      return true;
    }
    AppMethodBeat.o(187935);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(187945);
    int i = this.map.hashCode();
    AppMethodBeat.o(187945);
    return i;
  }
  
  public final Iterator<r<String, c>> iterator()
  {
    AppMethodBeat.i(187925);
    Object localObject2 = this.map;
    Object localObject1 = (Collection)new ArrayList(((Map)localObject2).size());
    localObject2 = ((Map)localObject2).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
      ((Collection)localObject1).add(v.Y((String)localEntry.getKey(), (c)localEntry.getValue()));
    }
    localObject1 = ((List)localObject1).iterator();
    AppMethodBeat.o(187925);
    return localObject1;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(187950);
    String str = "Parameters(map=" + this.map + ')';
    AppMethodBeat.o(187950);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lcoil/request/Parameters$Builder;", "", "()V", "parameters", "Lcoil/request/Parameters;", "(Lcoil/request/Parameters;)V", "map", "", "", "Lcoil/request/Parameters$Entry;", "build", "remove", "key", "set", "value", "cacheKey", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private final Map<String, l.c> map;
    
    public a()
    {
      AppMethodBeat.i(187922);
      this.map = ((Map)new LinkedHashMap());
      AppMethodBeat.o(187922);
    }
    
    public a(l paraml)
    {
      AppMethodBeat.i(187932);
      this.map = ak.dw(l.a(paraml));
      AppMethodBeat.o(187932);
    }
    
    public final l Ng()
    {
      AppMethodBeat.i(187940);
      l locall = new l(ak.dv(this.map), (byte)0);
      AppMethodBeat.o(187940);
      return locall;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcoil/request/Parameters$Companion;", "", "()V", "EMPTY", "Lcoil/request/Parameters;", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b {}
  
  @Metadata(d1={""}, d2={"Lcoil/request/Parameters$Entry;", "", "value", "cacheKey", "", "(Ljava/lang/Object;Ljava/lang/String;)V", "getCacheKey", "()Ljava/lang/String;", "getValue", "()Ljava/lang/Object;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (!(paramObject instanceof c)) {
        return false;
      }
      throw null;
    }
    
    public final int hashCode()
    {
      throw null;
    }
    
    public final String toString()
    {
      throw null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     coil.j.l
 * JD-Core Version:    0.7.0.1
 */