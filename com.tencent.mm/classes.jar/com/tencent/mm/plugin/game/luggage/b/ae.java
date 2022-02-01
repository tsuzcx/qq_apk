package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.luggage.jsapi.br.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bs;
import com.tencent.mm.plugin.webview.ui.tools.game.d;
import com.tencent.mm.plugin.webview.ui.tools.game.d.b;
import com.tencent.mm.plugin.webview.ui.tools.game.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.json.JSONObject;

public class ae
  extends bs<i>
{
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(b<i>.a paramb)
  {
    AppMethodBeat.i(83089);
    Object localObject1 = new TreeMap(new Comparator() {});
    Object localObject3 = paramb.ctb.csi;
    Object localObject2 = ((JSONObject)localObject3).optString("type");
    boolean bool = "1".equals(((JSONObject)localObject3).optString("isReportNow"));
    localObject3 = ((JSONObject)localObject3).optJSONObject("data");
    if (localObject3 == null)
    {
      Log.i("MicroMsg.JsApiReportGameWeb", "data is null or not json");
      paramb.c("data_is_null", null);
      AppMethodBeat.o(83089);
      return;
    }
    Integer localInteger;
    if ("1".equals(localObject2))
    {
      Log.i("MicroMsg.JsApiReportGameWeb", "report web performance, url:%s", new Object[] { ((i)paramb.cta).coX() });
      ((Map)localObject1).put(Integer.valueOf(d.b.Jqx), Boolean.valueOf(bool));
      localObject2 = f.cc((JSONObject)localObject3);
      localObject3 = ((Map)localObject2).keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localInteger = (Integer)((Iterator)localObject3).next();
        if (!((Map)localObject1).containsKey(localInteger)) {
          ((Map)localObject1).put(localInteger, ((Map)localObject2).get(localInteger));
        }
      }
      f.P(((i)paramb.cta).dTQ(), (Map)localObject1);
      paramb.c("", null);
      AppMethodBeat.o(83089);
      return;
    }
    if ("2".equals(localObject2))
    {
      ((Map)localObject1).putAll(((i)paramb.cta).dTR());
      localObject2 = f.cc((JSONObject)localObject3);
      localObject3 = ((Map)localObject2).keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localInteger = (Integer)((Iterator)localObject3).next();
        if (!((Map)localObject1).containsKey(localInteger)) {
          ((Map)localObject1).put(localInteger, ((Map)localObject2).get(localInteger));
        }
      }
      localObject1 = d.bP((Map)localObject1);
      Log.i("MicroMsg.JsApiReportGameWeb", "report web runtime. isReportNow:%b, reportData: [%s]", new Object[] { Boolean.valueOf(bool), localObject1 });
      h.CyF.a(16145, (String)localObject1, bool, false);
      paramb.c("", null);
      AppMethodBeat.o(83089);
      return;
    }
    Log.i("MicroMsg.JsApiReportGameWeb", "type is error. type:%s", new Object[] { localObject2 });
    paramb.c("type_not_right", null);
    AppMethodBeat.o(83089);
  }
  
  public final int dTs()
  {
    return 0;
  }
  
  public final String name()
  {
    return "reportGameWeb";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.ae
 * JD-Core Version:    0.7.0.1
 */