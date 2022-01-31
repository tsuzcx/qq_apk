package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.facebook.device.yearclass.YearClass;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.game.luggage.d.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.luggage.jsapi.bh.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bi;
import com.tencent.mm.plugin.webview.ui.tools.game.e;
import com.tencent.mm.plugin.webview.ui.tools.game.e.a;
import com.tencent.mm.plugin.webview.ui.tools.game.e.b;
import com.tencent.mm.plugin.wepkg.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.json.JSONObject;

public class v
  extends bi<com.tencent.mm.plugin.game.luggage.d.f>
{
  public final void a(Context paramContext, String paramString, bh.a parama) {}
  
  public final void b(a<com.tencent.mm.plugin.game.luggage.d.f>.a parama)
  {
    AppMethodBeat.i(135887);
    Object localObject1 = new TreeMap(new v.1(this));
    ((Map)localObject1).put(Integer.valueOf(e.a.vmG), ((com.tencent.mm.plugin.game.luggage.d.f)parama.byE).bFD());
    ((Map)localObject1).put(Integer.valueOf(e.a.vmH), at.gU(ah.getContext()));
    ((Map)localObject1).put(Integer.valueOf(e.a.vmI), String.valueOf(YearClass.get(ah.getContext())));
    try
    {
      ((Map)localObject1).put(Integer.valueOf(e.a.vmJ), q.encode(bo.nullAsNil(((com.tencent.mm.plugin.game.luggage.d.f)parama.byE).daZ()), "UTF-8"));
      label121:
      Object localObject2 = ((com.tencent.mm.plugin.game.luggage.d.f)parama.byE).daZ();
      int j = e.a.vmK;
      int i;
      if (((com.tencent.mm.plugin.game.luggage.d.f)parama.byE).PT((String)localObject2))
      {
        i = 1;
        ((Map)localObject1).put(Integer.valueOf(j), Integer.valueOf(i));
        ((Map)localObject1).put(Integer.valueOf(e.a.vmL), Integer.valueOf(1));
        if (!(parama.byE instanceof g)) {
          break label344;
        }
        ((Map)localObject1).put(Integer.valueOf(e.a.vmM), Integer.valueOf(1));
      }
      Object localObject3;
      boolean bool;
      for (;;)
      {
        ((Map)localObject1).put(Integer.valueOf(e.a.vmN), ((com.tencent.mm.plugin.game.luggage.d.f)parama.byE).bFC().dkk());
        i = e.a.vmO;
        ((com.tencent.mm.plugin.game.luggage.d.f)parama.byE).bFC();
        ((Map)localObject1).put(Integer.valueOf(i), c.dkl());
        localObject3 = parama.byF.bxK;
        localObject2 = ((JSONObject)localObject3).optString("type");
        bool = "1".equals(((JSONObject)localObject3).optString("isReportNow"));
        localObject3 = ((JSONObject)localObject3).optJSONObject("data");
        if (localObject3 != null) {
          break label365;
        }
        ab.i("MicroMsg.JsApiReportGameWeb", "data is null or not json");
        parama.a("data_is_null", null);
        AppMethodBeat.o(135887);
        return;
        i = 0;
        break;
        label344:
        ((Map)localObject1).put(Integer.valueOf(e.a.vmM), Integer.valueOf(0));
      }
      label365:
      Integer localInteger;
      if ("1".equals(localObject2))
      {
        ((Map)localObject1).put(Integer.valueOf(e.b.vmQ), Boolean.valueOf(bool));
        localObject2 = com.tencent.mm.plugin.webview.ui.tools.game.f.aT((JSONObject)localObject3);
        localObject3 = ((Map)localObject2).keySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localInteger = (Integer)((Iterator)localObject3).next();
          if (!((Map)localObject1).containsKey(localInteger)) {
            ((Map)localObject1).put(localInteger, ((Map)localObject2).get(localInteger));
          }
        }
        com.tencent.mm.plugin.webview.ui.tools.game.f.A(((com.tencent.mm.plugin.game.luggage.d.f)parama.byE).daZ(), (Map)localObject1);
        parama.a("", null);
        AppMethodBeat.o(135887);
        return;
      }
      if ("2".equals(localObject2))
      {
        localObject2 = com.tencent.mm.plugin.webview.ui.tools.game.f.aT((JSONObject)localObject3);
        localObject3 = ((Map)localObject2).keySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localInteger = (Integer)((Iterator)localObject3).next();
          if (!((Map)localObject1).containsKey(localInteger)) {
            ((Map)localObject1).put(localInteger, ((Map)localObject2).get(localInteger));
          }
        }
        localObject1 = e.aJ((Map)localObject1);
        ab.i("MicroMsg.JsApiReportGameWeb", "report web runtime. isReportNow:%b, reportData: [%s]", new Object[] { Boolean.valueOf(bool), localObject1 });
        h.qsU.a(16145, (String)localObject1, bool, false);
        parama.a("", null);
        AppMethodBeat.o(135887);
        return;
      }
      ab.i("MicroMsg.JsApiReportGameWeb", "type is error. type:%s", new Object[] { localObject2 });
      parama.a("type_not_right", null);
      AppMethodBeat.o(135887);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      break label121;
    }
  }
  
  public final int bjL()
  {
    return 0;
  }
  
  public final String name()
  {
    return "reportGameWeb";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.v
 * JD-Core Version:    0.7.0.1
 */