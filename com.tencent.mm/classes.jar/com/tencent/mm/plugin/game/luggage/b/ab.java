package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.ui.tools.game.d;
import com.tencent.mm.plugin.webview.ui.tools.game.d.b;
import com.tencent.mm.plugin.webview.ui.tools.game.f;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.json.JSONObject;

public class ab
  extends br<com.tencent.mm.plugin.game.luggage.f.g>
{
  public final void a(Context paramContext, String paramString, bq.a parama) {}
  
  public final void b(b<com.tencent.mm.plugin.game.luggage.f.g>.a paramb)
  {
    AppMethodBeat.i(83089);
    Object localObject1 = new TreeMap(new Comparator() {});
    Object localObject3 = paramb.chh.cgn;
    Object localObject2 = ((JSONObject)localObject3).optString("type");
    boolean bool = "1".equals(((JSONObject)localObject3).optString("isReportNow"));
    localObject3 = ((JSONObject)localObject3).optJSONObject("data");
    if (localObject3 == null)
    {
      ad.i("MicroMsg.JsApiReportGameWeb", "data is null or not json");
      paramb.a("data_is_null", null);
      AppMethodBeat.o(83089);
      return;
    }
    Integer localInteger;
    if ("1".equals(localObject2))
    {
      ad.i("MicroMsg.JsApiReportGameWeb", "report web performance, url:%s", new Object[] { ((com.tencent.mm.plugin.game.luggage.f.g)paramb.chg).bQm() });
      ((Map)localObject1).put(Integer.valueOf(d.b.EiW), Boolean.valueOf(bool));
      localObject2 = f.bD((JSONObject)localObject3);
      localObject3 = ((Map)localObject2).keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localInteger = (Integer)((Iterator)localObject3).next();
        if (!((Map)localObject1).containsKey(localInteger)) {
          ((Map)localObject1).put(localInteger, ((Map)localObject2).get(localInteger));
        }
      }
      f.J(((com.tencent.mm.plugin.game.luggage.f.g)paramb.chg).cXx(), (Map)localObject1);
      paramb.a("", null);
      AppMethodBeat.o(83089);
      return;
    }
    if ("2".equals(localObject2))
    {
      ((Map)localObject1).putAll(((com.tencent.mm.plugin.game.luggage.f.g)paramb.chg).cXy());
      localObject2 = f.bD((JSONObject)localObject3);
      localObject3 = ((Map)localObject2).keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localInteger = (Integer)((Iterator)localObject3).next();
        if (!((Map)localObject1).containsKey(localInteger)) {
          ((Map)localObject1).put(localInteger, ((Map)localObject2).get(localInteger));
        }
      }
      localObject1 = d.bE((Map)localObject1);
      ad.i("MicroMsg.JsApiReportGameWeb", "report web runtime. isReportNow:%b, reportData: [%s]", new Object[] { Boolean.valueOf(bool), localObject1 });
      com.tencent.mm.plugin.report.service.g.yhR.a(16145, (String)localObject1, bool, false);
      paramb.a("", null);
      AppMethodBeat.o(83089);
      return;
    }
    ad.i("MicroMsg.JsApiReportGameWeb", "type is error. type:%s", new Object[] { localObject2 });
    paramb.a("type_not_right", null);
    AppMethodBeat.o(83089);
  }
  
  public final int ccO()
  {
    return 0;
  }
  
  public final String name()
  {
    return "reportGameWeb";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.ab
 * JD-Core Version:    0.7.0.1
 */