package com.tencent.mm.plugin.appbrand.dynamic.h;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.af;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.appcache.an;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetContext;
import com.tencent.mm.plugin.appbrand.dynamic.d.p;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig;
import com.tencent.mm.plugin.appbrand.t.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public class e
{
  private static volatile com.tencent.mm.z.c.e hqA;
  private static volatile DebuggerInfo hqB;
  
  private static void F(Runnable paramRunnable)
  {
    AppMethodBeat.i(10967);
    paramRunnable = new e.1(paramRunnable);
    if (al.isMainThread())
    {
      paramRunnable.run();
      AppMethodBeat.o(10967);
      return;
    }
    al.d(paramRunnable);
    AppMethodBeat.o(10967);
  }
  
  private static com.tencent.mm.z.b.d a(com.tencent.mm.z.c.e parame)
  {
    AppMethodBeat.i(10970);
    parame = com.tencent.mm.plugin.appbrand.dynamic.e.b.bi(parame);
    h.qsU.idkeyStat(639L, 2L, 1L, false);
    ab.i("MicroMsg.PreloadOptimizer", "Using v8 Javascript Engine");
    h.qsU.idkeyStat(639L, 0L, 1L, false);
    AppMethodBeat.o(10970);
    return parame;
  }
  
  public static com.tencent.mm.z.c.e a(Context paramContext, WxaWidgetContext paramWxaWidgetContext, com.tencent.mm.z.d.a parama, Bundle paramBundle)
  {
    AppMethodBeat.i(10966);
    label702:
    label705:
    for (;;)
    {
      try
      {
        com.tencent.mm.z.c.e locale = hqA;
        hqA = null;
        if (locale != null)
        {
          bool = true;
          u.i("MicroMsg.PreloadOptimizer", "hit preloaded jsBridge %b", new Object[] { Boolean.valueOf(bool) });
          if (locale != null) {
            break label705;
          }
          locale = aAe();
          int i = paramBundle.getInt("widget_type");
          Object localObject = new com.tencent.mm.plugin.appbrand.dynamic.d.a.c();
          ((com.tencent.mm.plugin.appbrand.dynamic.d.a.c)localObject).equ = paramWxaWidgetContext.getId();
          if (i == 1) {
            ((com.tencent.mm.plugin.appbrand.dynamic.d.a.c)localObject).hpf = new com.tencent.mm.plugin.appbrand.dynamic.i.c(paramWxaWidgetContext.getAppId(), paramBundle.getString("search_id"));
          }
          paramBundle = new com.tencent.mm.z.c.c(paramContext, locale, parama, (com.tencent.mm.z.c.b)localObject);
          paramBundle.eGq = p.nG(i);
          locale.eGw = paramBundle;
          paramBundle = locale.eGy;
          locale.eGx = new com.tencent.mm.z.c.f(paramBundle, com.tencent.mm.plugin.appbrand.dynamic.f.a.nH(i), parama);
          locale.eGA = com.tencent.mm.plugin.appbrand.dynamic.debugger.a.azP();
          parama = paramWxaWidgetContext.azL();
          localObject = new JSONObject();
          a((JSONObject)localObject, "widgetType", Integer.valueOf(parama.hpZ));
          a((JSONObject)localObject, "platform", "android");
          a((JSONObject)localObject, "debug", Boolean.valueOf(paramWxaWidgetContext.azJ().hox));
          if (paramWxaWidgetContext.azK() != null) {
            a((JSONObject)localObject, "drawMinInterval", Integer.valueOf(paramWxaWidgetContext.azK().hhP));
          }
          a((JSONObject)localObject, "clientVersion", Integer.valueOf(com.tencent.mm.protocal.d.whH));
          JSONObject localJSONObject = new JSONObject();
          a(localJSONObject, "drawMinInterval", Integer.valueOf(parama.hqq));
          a(localJSONObject, "timerEnabled", Boolean.valueOf(parama.hqr));
          a(localJSONObject, "drawLock", Boolean.valueOf(parama.hqs));
          parama = String.format("var __widgetConfig__ = %s;var __wxConfig = %s;var __wxIndexPage = \"%s\"", new Object[] { localJSONObject.toString(), ((JSONObject)localObject).toString(), "" });
          paramBundle.evaluateJavascript(parama, null);
          ab.v("MicroMsg.PreloadOptimizer", "injectConfig(%s, %s)", new Object[] { paramWxaWidgetContext.getId(), parama });
          v.kS(10);
          parama = new af().fB(u.qn(paramWxaWidgetContext.getId()));
          parama.cUl = u.qm(paramWxaWidgetContext.getId());
          parama.cUh = 5L;
          parama = parama.fA(paramWxaWidgetContext.getId());
          parama.cUi = System.currentTimeMillis();
          parama.fC(at.gU(ah.getContext())).ake();
          parama = com.tencent.mm.plugin.appbrand.dynamic.j.c.bU(paramWxaWidgetContext.getId(), "WAWidget.js");
          if (!bo.isNullOrNil(parama)) {
            break label702;
          }
          u.i("MicroMsg.PreloadOptimizer", "read WAWidget.js", new Object[0]);
          parama = com.tencent.mm.plugin.appbrand.s.d.convertStreamToString(an.openRead("WAWidget.js"));
          if (bo.isNullOrNil(parama)) {
            ab.e("MicroMsg.PreloadOptimizer", "get Null Or Nil widget js");
          }
          h.qsU.idkeyStat(636L, 0L, 1L, false);
          n.a(paramBundle, parama, new e.3(paramWxaWidgetContext));
          ab.v("MicroMsg.PreloadOptimizer", "injectWAWidget(%s)", new Object[] { paramWxaWidgetContext.getId() });
          v.kS(13);
          parama = com.tencent.mm.plugin.appbrand.dynamic.j.c.bU(paramWxaWidgetContext.getId(), "widget.js");
          if (bo.isNullOrNil(parama))
          {
            ab.e("MicroMsg.PreloadOptimizer", "get Null Or Nil widget js");
            com.tencent.mm.plugin.appbrand.dynamic.f.azz().aZ(paramWxaWidgetContext.getId(), 2102);
          }
          h.qsU.idkeyStat(636L, 3L, 1L, false);
          n.a(paramBundle, parama, new e.4(paramWxaWidgetContext));
          ab.v("MicroMsg.PreloadOptimizer", "injectWidget(%s)", new Object[] { paramWxaWidgetContext.getId() });
          cH(paramContext);
          AppMethodBeat.o(10966);
          return locale;
        }
      }
      finally
      {
        AppMethodBeat.o(10966);
      }
      boolean bool = false;
      continue;
    }
  }
  
  private static void a(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    AppMethodBeat.i(10971);
    try
    {
      paramJSONObject.put(paramString, paramObject);
      AppMethodBeat.o(10971);
      return;
    }
    catch (Exception paramJSONObject)
    {
      ab.e("MicroMsg.PreloadOptimizer", "put env arguments error, %s", new Object[] { paramJSONObject });
      AppMethodBeat.o(10971);
    }
  }
  
  private static com.tencent.mm.z.c.e aAe()
  {
    AppMethodBeat.i(10969);
    com.tencent.mm.z.c.e locale = new com.tencent.mm.z.c.e();
    locale.a(a(locale));
    AppMethodBeat.o(10969);
    return locale;
  }
  
  public static void cH(Context paramContext)
  {
    AppMethodBeat.i(10968);
    F(new e.2(paramContext));
    AppMethodBeat.o(10968);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.h.e
 * JD-Core Version:    0.7.0.1
 */