package com.tencent.mm.plugin.finder.storage.logic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.i;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.protocal.protobuf.aqo;
import com.tencent.mm.protocal.protobuf.aqp;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.g.b.p;
import d.v;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderObjectWordingConfig;", "", "()V", "SRV_Placeholder", "", "configMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/protocal/protobuf/FinderObjectExtInfo;", "Lkotlin/collections/HashMap;", "getExtInfo", "type", "preLoadIcon", "", "info", "resetConfig", "infoList", "Lcom/tencent/mm/protocal/protobuf/FinderObjectExtInfoList;", "plugin-finder_release"})
public final class f
{
  private static final HashMap<Integer, aqo> sLx;
  public static final f sLy;
  
  static
  {
    AppMethodBeat.i(204475);
    sLy = new f();
    sLx = new HashMap();
    Object localObject = g.ajR();
    p.g(localObject, "MMKernel.storage()");
    localObject = ((e)localObject).ajA().get(am.a.Jdy, "");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(204475);
      throw ((Throwable)localObject);
    }
    localObject = bu.aSx((String)localObject);
    aqp localaqp = new aqp();
    localaqp.parseFrom((byte[])localObject);
    a(localaqp);
    AppMethodBeat.o(204475);
  }
  
  public static aqo FV(int paramInt)
  {
    AppMethodBeat.i(204473);
    if (j.IS_FLAVOR_PURPLE)
    {
      Object localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.cKL().value()).intValue() == 1) {
        paramInt = 1;
      }
      localObject = (aqo)sLx.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(204473);
      return localObject;
    }
    AppMethodBeat.o(204473);
    return null;
  }
  
  public static void a(aqp paramaqp)
  {
    AppMethodBeat.i(204474);
    p.h(paramaqp, "infoList");
    sLx.clear();
    Object localObject1 = paramaqp.GHA;
    if (localObject1 != null)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (aqo)((Iterator)localObject1).next();
        Object localObject3 = (Map)sLx;
        int i = ((aqo)localObject2).objectType;
        p.g(localObject2, "it");
        ((Map)localObject3).put(Integer.valueOf(i), localObject2);
        localObject3 = i.srW;
        localObject3 = i.cEn();
        Object localObject4 = new com.tencent.mm.plugin.finder.loader.l(((aqo)localObject2).GHw, r.sJu);
        i locali = i.srW;
        ((d)localObject3).a(localObject4, i.a(i.a.srX));
        localObject3 = i.srW;
        localObject3 = i.cEn();
        localObject4 = new com.tencent.mm.plugin.finder.loader.l(((aqo)localObject2).GHx, r.sJu);
        locali = i.srW;
        ((d)localObject3).a(localObject4, i.a(i.a.srX));
        localObject3 = i.srW;
        localObject3 = i.cEn();
        localObject4 = new com.tencent.mm.plugin.finder.loader.l(((aqo)localObject2).GHy, r.sJu);
        locali = i.srW;
        ((d)localObject3).a(localObject4, i.a(i.a.srX));
        localObject3 = i.srW;
        localObject3 = i.cEn();
        localObject2 = new com.tencent.mm.plugin.finder.loader.l(((aqo)localObject2).GHz, r.sJu);
        localObject4 = i.srW;
        ((d)localObject3).a(localObject2, i.a(i.a.srX));
      }
    }
    localObject1 = g.ajR();
    p.g(localObject1, "MMKernel.storage()");
    ((e)localObject1).ajA().set(am.a.Jdy, bu.cH(paramaqp.toByteArray()));
    AppMethodBeat.o(204474);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.logic.f
 * JD-Core Version:    0.7.0.1
 */