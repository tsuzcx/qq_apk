package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.b.a.a.b;
import com.tencent.luggage.bridge.k;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.game.f;
import com.tencent.mm.plugin.game.luggage.d;
import com.tencent.mm.plugin.game.luggage.d.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.plugin.webview.luggage.jsapi.aw.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.ax;
import com.tencent.mm.plugin.wepkg.c;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

public class m
  extends ax<d>
{
  private static Map<Integer, Object> S(JSONObject paramJSONObject)
  {
    HashMap localHashMap = new HashMap();
    if (paramJSONObject == null) {
      return localHashMap;
    }
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      int i = bk.getInt(str, -1);
      if (i == -1) {
        y.i("MicroMsg.JsApiReportGameWeb", "reportData key error");
      } else {
        localHashMap.put(Integer.valueOf(i), paramJSONObject.opt(str));
      }
    }
    return localHashMap;
  }
  
  public final void a(Context paramContext, String paramString, aw.a parama) {}
  
  public final int aGj()
  {
    return 0;
  }
  
  public final void b(com.tencent.luggage.e.a<d>.a parama)
  {
    TreeMap localTreeMap = new TreeMap(new m.1(this));
    localTreeMap.put(Integer.valueOf(com.tencent.mm.plugin.game.luggage.d.a.a.kND), (((d)parama.big).hashCode() & 0x7FFFFFFF) + "_" + (((d)parama.big).kMT.hashCode() & 0x7FFFFFFF));
    localTreeMap.put(Integer.valueOf(com.tencent.mm.plugin.game.luggage.d.a.a.kNE), aq.fH(ae.getContext()));
    localTreeMap.put(Integer.valueOf(com.tencent.mm.plugin.game.luggage.d.a.a.kNF), String.valueOf(b.X(ae.getContext())));
    try
    {
      localTreeMap.put(Integer.valueOf(com.tencent.mm.plugin.game.luggage.d.a.a.kNG), q.encode(((d)parama.big).kMT, "UTF-8"));
      label153:
      String str = ((d)parama.big).caV();
      int j = com.tencent.mm.plugin.game.luggage.d.a.a.kNH;
      int i;
      if (((d)parama.big).EB(str))
      {
        i = 1;
        localTreeMap.put(Integer.valueOf(j), Integer.valueOf(i));
        localTreeMap.put(Integer.valueOf(com.tencent.mm.plugin.game.luggage.d.a.a.kNI), Integer.valueOf(1));
        if (!(parama.big instanceof f)) {
          break label392;
        }
        localTreeMap.put(Integer.valueOf(com.tencent.mm.plugin.game.luggage.d.a.a.kNJ), Integer.valueOf(1));
        label248:
        i = com.tencent.mm.plugin.game.luggage.d.a.a.kNK;
        localObject = ((d)parama.big).aYE();
        if (((c)localObject).rNW == null) {
          break label413;
        }
      }
      JSONObject localJSONObject;
      boolean bool;
      label392:
      label413:
      for (Object localObject = ((c)localObject).rNW.version;; localObject = "")
      {
        localTreeMap.put(Integer.valueOf(i), localObject);
        i = com.tencent.mm.plugin.game.luggage.d.a.a.kNL;
        ((d)parama.big).aYE();
        localTreeMap.put(Integer.valueOf(i), c.cjJ());
        localJSONObject = parama.bih.bhk;
        localObject = localJSONObject.optString("type");
        bool = "1".equals(localJSONObject.optString("isReportNow"));
        localJSONObject = localJSONObject.optJSONObject("data");
        if (localJSONObject != null) {
          break label420;
        }
        y.i("MicroMsg.JsApiReportGameWeb", "data is null or not json");
        parama.a("data_is_null", null);
        return;
        i = 0;
        break;
        localTreeMap.put(Integer.valueOf(com.tencent.mm.plugin.game.luggage.d.a.a.kNJ), Integer.valueOf(0));
        break label248;
      }
      label420:
      if ("1".equals(localObject))
      {
        localTreeMap.put(Integer.valueOf(a.b.kNN), Boolean.valueOf(bool));
        localTreeMap.put(Integer.valueOf(a.b.kNO), Long.valueOf(com.tencent.mm.plugin.webview.luggage.c.a.RT(str).reU));
        localTreeMap.put(Integer.valueOf(a.b.kNP), Long.valueOf(com.tencent.mm.plugin.webview.luggage.c.a.RT(str).reV));
        localTreeMap.put(Integer.valueOf(a.b.kNQ), Long.valueOf(com.tencent.mm.plugin.webview.luggage.c.a.RT(str).reW));
        localTreeMap.put(Integer.valueOf(a.b.kNR), Long.valueOf(com.tencent.mm.plugin.webview.luggage.c.a.RT(str).reX));
        localTreeMap.put(Integer.valueOf(a.b.kNS), Long.valueOf(com.tencent.mm.plugin.webview.luggage.c.a.RT(str).reY));
        localTreeMap.putAll(S(localJSONObject));
        com.tencent.mm.plugin.game.luggage.d.a.l(str, localTreeMap);
        parama.a("", null);
        return;
      }
      if ("2".equals(localObject))
      {
        localTreeMap.putAll(S(localJSONObject));
        localObject = com.tencent.mm.plugin.game.luggage.d.a.y(localTreeMap);
        y.i("MicroMsg.JsApiReportGameWeb", "report web runtime. isReportNow:%b, reportData: [%s]", new Object[] { Boolean.valueOf(bool), localObject });
        h.nFQ.a(16145, (String)localObject, bool, false);
        parama.a("", null);
        return;
      }
      y.i("MicroMsg.JsApiReportGameWeb", "type is error. type:%s", new Object[] { localObject });
      parama.a("type_not_right", null);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      break label153;
    }
  }
  
  public final String name()
  {
    return "reportGameWeb";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.m
 * JD-Core Version:    0.7.0.1
 */