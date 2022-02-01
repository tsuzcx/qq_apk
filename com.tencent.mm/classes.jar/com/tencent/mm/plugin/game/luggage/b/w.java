package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.d.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.luggage.jsapi.bn.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bo;
import com.tencent.mm.plugin.webview.ui.tools.game.e;
import com.tencent.mm.plugin.webview.ui.tools.game.e.b;
import com.tencent.mm.plugin.webview.ui.tools.game.g;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.json.JSONObject;

public class w
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(a<f>.a parama)
  {
    AppMethodBeat.i(83089);
    Object localObject1 = new TreeMap(new Comparator() {});
    Object localObject3 = parama.bZV.bZb;
    Object localObject2 = ((JSONObject)localObject3).optString("type");
    boolean bool = "1".equals(((JSONObject)localObject3).optString("isReportNow"));
    localObject3 = ((JSONObject)localObject3).optJSONObject("data");
    if (localObject3 == null)
    {
      ad.i("MicroMsg.JsApiReportGameWeb", "data is null or not json");
      parama.a("data_is_null", null);
      AppMethodBeat.o(83089);
      return;
    }
    Integer localInteger;
    if ("1".equals(localObject2))
    {
      ad.i("MicroMsg.JsApiReportGameWeb", "report web performance, url:%s", new Object[] { ((f)parama.bZU).bEx() });
      ((Map)localObject1).put(Integer.valueOf(e.b.Bnf), Boolean.valueOf(bool));
      localObject2 = g.bu((JSONObject)localObject3);
      localObject3 = ((Map)localObject2).keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localInteger = (Integer)((Iterator)localObject3).next();
        if (!((Map)localObject1).containsKey(localInteger)) {
          ((Map)localObject1).put(localInteger, ((Map)localObject2).get(localInteger));
        }
      }
      g.H(((f)parama.bZU).cBJ(), (Map)localObject1);
      parama.a("", null);
      AppMethodBeat.o(83089);
      return;
    }
    if ("2".equals(localObject2))
    {
      ((Map)localObject1).putAll(((f)parama.bZU).cBK());
      localObject2 = g.bu((JSONObject)localObject3);
      localObject3 = ((Map)localObject2).keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localInteger = (Integer)((Iterator)localObject3).next();
        if (!((Map)localObject1).containsKey(localInteger)) {
          ((Map)localObject1).put(localInteger, ((Map)localObject2).get(localInteger));
        }
      }
      localObject1 = e.bw((Map)localObject1);
      ad.i("MicroMsg.JsApiReportGameWeb", "report web runtime. isReportNow:%b, reportData: [%s]", new Object[] { Boolean.valueOf(bool), localObject1 });
      h.vKh.a(16145, (String)localObject1, bool, false);
      parama.a("", null);
      AppMethodBeat.o(83089);
      return;
    }
    ad.i("MicroMsg.JsApiReportGameWeb", "type is error. type:%s", new Object[] { localObject2 });
    parama.a("type_not_right", null);
    AppMethodBeat.o(83089);
  }
  
  public final int bQV()
  {
    return 0;
  }
  
  public final String name()
  {
    return "reportGameWeb";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.w
 * JD-Core Version:    0.7.0.1
 */