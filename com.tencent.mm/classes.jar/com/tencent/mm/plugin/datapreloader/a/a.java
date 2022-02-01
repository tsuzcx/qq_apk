package com.tencent.mm.plugin.datapreloader.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/datapreloader/cache/DataCacheManager;", "", "()V", "storeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/datapreloader/cache/IDataCache;", "find", "_key", "_value", "key", "findOrPut", "default", "Companion", "plugin-datapreloader_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a xfR;
  private static final j<a> xfT;
  public final ConcurrentHashMap<Object, b<?, ?>> xfS;
  
  static
  {
    AppMethodBeat.i(260458);
    xfR = new a((byte)0);
    xfT = k.cm((kotlin.g.a.a)b.xfU);
    AppMethodBeat.o(260458);
  }
  
  private a()
  {
    AppMethodBeat.i(260440);
    this.xfS = new ConcurrentHashMap();
    AppMethodBeat.o(260440);
  }
  
  public final <_key, _value> b<_key, _value> eA(Object paramObject)
  {
    AppMethodBeat.i(260467);
    s.u(paramObject, "key");
    paramObject = this.xfS.get(paramObject);
    if ((paramObject instanceof b))
    {
      paramObject = (b)paramObject;
      AppMethodBeat.o(260467);
      return paramObject;
    }
    AppMethodBeat.o(260467);
    return null;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/datapreloader/cache/DataCacheManager$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/plugin/datapreloader/cache/DataCacheManager;", "getINSTANCE", "()Lcom/tencent/mm/plugin/datapreloader/cache/DataCacheManager;", "INSTANCE$delegate", "Lkotlin/Lazy;", "plugin-datapreloader_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static a dti()
    {
      AppMethodBeat.i(260426);
      a locala = (a)a.dth().getValue();
      AppMethodBeat.o(260426);
      return locala;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/datapreloader/cache/DataCacheManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<a>
  {
    public static final b xfU;
    
    static
    {
      AppMethodBeat.i(260434);
      xfU = new b();
      AppMethodBeat.o(260434);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.datapreloader.a.a
 * JD-Core Version:    0.7.0.1
 */