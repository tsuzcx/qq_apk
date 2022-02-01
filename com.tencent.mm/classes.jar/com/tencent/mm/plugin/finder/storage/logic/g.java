package com.tencent.mm.plugin.finder.storage.logic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.storage.config.b;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.protocal.protobuf.azu;
import com.tencent.mm.protocal.protobuf.azv;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderObjectWordingConfig;", "", "()V", "SRV_Placeholder", "", "configMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/protocal/protobuf/FinderObjectExtInfo;", "Lkotlin/collections/HashMap;", "getExtInfo", "type", "preLoadIcon", "", "info", "resetConfig", "infoList", "Lcom/tencent/mm/protocal/protobuf/FinderObjectExtInfoList;", "plugin-finder_release"})
public final class g
{
  private static final HashMap<Integer, azu> hDh;
  public static final g vGW;
  
  static
  {
    AppMethodBeat.i(252099);
    vGW = new g();
    hDh = new HashMap();
    Object localObject = com.tencent.mm.kernel.g.aAh();
    kotlin.g.b.p.g(localObject, "MMKernel.storage()");
    localObject = ((e)localObject).azQ().get(ar.a.OmO, "");
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(252099);
      throw ((Throwable)localObject);
    }
    localObject = Util.decodeHexString((String)localObject);
    azv localazv = new azv();
    localazv.parseFrom((byte[])localObject);
    a(localazv);
    AppMethodBeat.o(252099);
  }
  
  public static azu Lj(int paramInt)
  {
    AppMethodBeat.i(252097);
    Object localObject = c.vCb;
    if (((Number)c.duG().value()).intValue() == 1) {
      paramInt = 1;
    }
    localObject = (azu)hDh.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(252097);
    return localObject;
  }
  
  public static void a(azv paramazv)
  {
    AppMethodBeat.i(252098);
    kotlin.g.b.p.h(paramazv, "infoList");
    hDh.clear();
    Object localObject1 = paramazv.LJM;
    if (localObject1 != null)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (azu)((Iterator)localObject1).next();
        Object localObject3 = (Map)hDh;
        int i = ((azu)localObject2).objectType;
        kotlin.g.b.p.g(localObject2, "it");
        ((Map)localObject3).put(Integer.valueOf(i), localObject2);
        localObject3 = m.uJa;
        localObject3 = m.djY();
        Object localObject4 = new com.tencent.mm.plugin.finder.loader.p(((azu)localObject2).LJE, x.vEn);
        m localm = m.uJa;
        ((d)localObject3).a(localObject4, m.a(m.a.uJb));
        localObject3 = m.uJa;
        localObject3 = m.djY();
        localObject4 = new com.tencent.mm.plugin.finder.loader.p(((azu)localObject2).LJF, x.vEn);
        localm = m.uJa;
        ((d)localObject3).a(localObject4, m.a(m.a.uJb));
        localObject3 = m.uJa;
        localObject3 = m.djY();
        localObject4 = new com.tencent.mm.plugin.finder.loader.p(((azu)localObject2).LJG, x.vEn);
        localm = m.uJa;
        ((d)localObject3).a(localObject4, m.a(m.a.uJb));
        localObject3 = m.uJa;
        localObject3 = m.djY();
        localObject2 = new com.tencent.mm.plugin.finder.loader.p(((azu)localObject2).LJH, x.vEn);
        localObject4 = m.uJa;
        ((d)localObject3).a(localObject2, m.a(m.a.uJb));
      }
    }
    localObject1 = com.tencent.mm.kernel.g.aAh();
    kotlin.g.b.p.g(localObject1, "MMKernel.storage()");
    ((e)localObject1).azQ().set(ar.a.OmO, Util.encodeHexString(paramazv.toByteArray()));
    AppMethodBeat.o(252098);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.logic.g
 * JD-Core Version:    0.7.0.1
 */