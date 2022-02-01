package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"removeInvalidHeaders", "", "headers", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "invoke"})
final class v$d$d
  extends q
  implements b<HashMap<String, List<? extends String>>, kotlin.x>
{
  public static final d pDZ;
  
  static
  {
    AppMethodBeat.i(195662);
    pDZ = new d();
    AppMethodBeat.o(195662);
  }
  
  v$d$d()
  {
    super(1);
  }
  
  public static void i(HashMap<String, List<String>> paramHashMap)
  {
    AppMethodBeat.i(195661);
    p.h(paramHashMap, "headers");
    Object localObject1 = paramHashMap.keySet();
    p.g(localObject1, "headers.keys");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      String str = (String)localObject3;
      Set localSet = x.coN();
      p.g(str, "it");
      if (str == null)
      {
        paramHashMap = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(195661);
        throw paramHashMap;
      }
      str = str.toLowerCase();
      p.g(str, "(this as java.lang.String).toLowerCase()");
      if (localSet.contains(str)) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    localObject1 = (List)localObject1;
    Log.i("MicroMsg.WebPrefetcher", "removeInvalidHeaders size: " + ((List)localObject1).size());
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramHashMap.remove((String)((Iterator)localObject1).next());
    }
    AppMethodBeat.o(195661);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.v.d.d
 * JD-Core Version:    0.7.0.1
 */