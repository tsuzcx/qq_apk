package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.page.GameWebPage;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bw;
import com.tencent.mm.plugin.webview.ui.tools.game.e;
import com.tencent.mm.plugin.webview.ui.tools.game.e.b;
import com.tencent.mm.plugin.webview.ui.tools.game.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.json.JSONObject;

public class am
  extends bw<GameWebPage>
{
  public final void a(Context paramContext, String paramString, bv.a parama) {}
  
  public final void b(b<GameWebPage>.a paramb)
  {
    AppMethodBeat.i(83089);
    Object localObject1 = new TreeMap(new Comparator() {});
    Object localObject3 = paramb.eiZ.eif;
    Object localObject2 = ((JSONObject)localObject3).optString("type");
    boolean bool = "1".equals(((JSONObject)localObject3).optString("isReportNow"));
    localObject3 = ((JSONObject)localObject3).optJSONObject("data");
    if (localObject3 == null)
    {
      Log.i("MicroMsg.JsApiReportGameWeb", "data is null or not json");
      paramb.a("data_is_null", null);
      AppMethodBeat.o(83089);
      return;
    }
    Integer localInteger;
    if ("1".equals(localObject2))
    {
      Log.i("MicroMsg.JsApiReportGameWeb", "report web performance, url:%s", new Object[] { ((GameWebPage)paramb.eiY).dgY() });
      ((Map)localObject1).put(Integer.valueOf(e.b.Xgi), Boolean.valueOf(bool));
      localObject2 = g.cI((JSONObject)localObject3);
      localObject3 = ((Map)localObject2).keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localInteger = (Integer)((Iterator)localObject3).next();
        if (!((Map)localObject1).containsKey(localInteger)) {
          ((Map)localObject1).put(localInteger, ((Map)localObject2).get(localInteger));
        }
      }
      g.w(((GameWebPage)paramb.eiY).fET(), (Map)localObject1);
      paramb.a("", null);
      AppMethodBeat.o(83089);
      return;
    }
    if ("2".equals(localObject2))
    {
      ((Map)localObject1).putAll(((GameWebPage)paramb.eiY).fEU());
      localObject2 = g.cI((JSONObject)localObject3);
      localObject3 = ((Map)localObject2).keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localInteger = (Integer)((Iterator)localObject3).next();
        if (!((Map)localObject1).containsKey(localInteger)) {
          ((Map)localObject1).put(localInteger, ((Map)localObject2).get(localInteger));
        }
      }
      localObject1 = e.cq((Map)localObject1);
      Log.i("MicroMsg.JsApiReportGameWeb", "report web runtime. isReportNow:%b, reportData: [%s]", new Object[] { Boolean.valueOf(bool), localObject1 });
      h.OAn.b(16145, (String)localObject1, bool, false);
      paramb.a("", null);
      AppMethodBeat.o(83089);
      return;
    }
    Log.i("MicroMsg.JsApiReportGameWeb", "type is error. type:%s", new Object[] { localObject2 });
    paramb.a("type_not_right", null);
    AppMethodBeat.o(83089);
  }
  
  public final int dgI()
  {
    return 0;
  }
  
  public final String name()
  {
    return "reportGameWeb";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.am
 * JD-Core Version:    0.7.0.1
 */