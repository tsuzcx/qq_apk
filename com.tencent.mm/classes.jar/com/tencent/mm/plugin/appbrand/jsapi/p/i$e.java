package com.tencent.mm.plugin.appbrand.jsapi.p;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "callback"})
final class i$e
  implements b.a
{
  i$e(List paramList) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    AppMethodBeat.i(143867);
    ab.i("MicroMsg.AppBrand.JsApiOperateRealtimeReport.RealtimeReportQueue", "onCgiBack, errType=" + paramInt1 + ", errCode=" + paramInt2 + ", errMsg=" + paramString);
    paramb = new HashMap();
    Object localObject1 = new i.e.1(paramb);
    Object localObject2;
    Object localObject3;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      localObject2 = ((Iterable)this.hYq).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (i.d)((Iterator)localObject2).next();
        ((i.e.1)localObject1).a(((i.d)localObject3).hrA, (i.d)localObject3);
      }
      h.qsU.j(1074L, 2L, this.hYq.size());
      h.qsU.B(1074L, 5L);
      paramb = paramb.entrySet();
      a.f.b.j.p(paramb, "component2EntryMap.entries");
      paramb = ((Iterable)paramb).iterator();
    }
    for (;;)
    {
      if (!paramb.hasNext()) {
        break label616;
      }
      localObject3 = (Map.Entry)paramb.next();
      localObject1 = new d.b().i((c)((Map.Entry)localObject3).getKey());
      localObject2 = new HashMap();
      if (paramInt1 == 0) {}
      for (int i = paramInt2;; i = -9999)
      {
        ((HashMap)localObject2).put("errcode", Integer.valueOf(i));
        ((HashMap)localObject2).put("errmsg", paramString);
        localObject4 = ((Map.Entry)localObject3).getValue();
        a.f.b.j.p(localObject4, "entry.value");
        Object localObject5 = (Iterable)localObject4;
        localObject4 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject5));
        localObject5 = ((Iterable)localObject5).iterator();
        while (((Iterator)localObject5).hasNext()) {
          ((Collection)localObject4).add(Long.valueOf(((i.d)((Iterator)localObject5).next()).content.length()));
        }
        localObject2 = ((Iterable)this.hYq).iterator();
        i = 0;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (i.d)((Iterator)localObject2).next();
          localObject4 = i.hYe;
          if (!i.aEy().a((i.d)localObject3)) {
            ((i.e.1)localObject1).a(((i.d)localObject3).hrA, (i.d)localObject3);
          } else {
            i += 1;
          }
        }
        if (i <= 0) {
          break;
        }
        h.qsU.j(1074L, 0L, i);
        break;
      }
      ((HashMap)localObject2).put("dataSize", Long.valueOf(a.a.j.v((Iterable)localObject4)));
      localObject3 = ((Map.Entry)localObject3).getValue();
      a.f.b.j.p(localObject3, "entry.value");
      Object localObject4 = (Iterable)localObject3;
      localObject3 = (Collection)new ArrayList(a.a.j.d((Iterable)localObject4));
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext()) {
        ((Collection)localObject3).add(Integer.valueOf(((i.d)((Iterator)localObject4).next()).id));
      }
      ((HashMap)localObject2).put("idList", new JSONArray((Collection)a.a.j.m((Iterable)localObject3)));
      ((p)localObject1).w((Map)localObject2).aBz();
    }
    label616:
    AppMethodBeat.o(143867);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.i.e
 * JD-Core Version:    0.7.0.1
 */