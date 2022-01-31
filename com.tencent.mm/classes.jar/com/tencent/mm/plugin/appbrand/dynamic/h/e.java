package com.tencent.mm.plugin.appbrand.dynamic.h;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.aa.c.b;
import com.tencent.mm.h.b.a.r;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.appcache.ah;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetContext;
import com.tencent.mm.plugin.appbrand.dynamic.d.p;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public class e
{
  private static volatile com.tencent.mm.aa.c.e fXa;
  private static volatile DebuggerInfo fXb;
  
  public static com.tencent.mm.aa.c.e a(Context paramContext, WxaWidgetContext paramWxaWidgetContext, com.tencent.mm.aa.d.a parama, Bundle paramBundle)
  {
    label674:
    label677:
    for (;;)
    {
      try
      {
        com.tencent.mm.aa.c.e locale = fXa;
        fXa = null;
        if (locale != null)
        {
          bool = true;
          u.i("MicroMsg.PreloadOptimizer", "hit preloaded jsBridge %b", new Object[] { Boolean.valueOf(bool) });
          if (locale != null) {
            break label677;
          }
          locale = afA();
          int i = paramBundle.getInt("widget_type");
          Object localObject = new com.tencent.mm.plugin.appbrand.dynamic.d.a.c();
          ((com.tencent.mm.plugin.appbrand.dynamic.d.a.c)localObject).dIX = paramWxaWidgetContext.getId();
          if (i == 1) {
            ((com.tencent.mm.plugin.appbrand.dynamic.d.a.c)localObject).fVD = new com.tencent.mm.plugin.appbrand.dynamic.i.c(paramWxaWidgetContext.getAppId(), paramBundle.getString("search_id"));
          }
          paramBundle = new com.tencent.mm.aa.c.c(paramContext, locale, parama, (b)localObject);
          paramBundle.dIQ = p.kI(i);
          locale.dIY = paramBundle;
          paramBundle = locale.dJa;
          locale.dIZ = new com.tencent.mm.aa.c.f(paramBundle, com.tencent.mm.plugin.appbrand.dynamic.f.a.kJ(i), parama);
          locale.dJc = com.tencent.mm.plugin.appbrand.dynamic.debugger.a.afl();
          parama = paramWxaWidgetContext.afh();
          localObject = new JSONObject();
          b((JSONObject)localObject, "widgetType", Integer.valueOf(parama.fWz));
          b((JSONObject)localObject, "platform", "android");
          b((JSONObject)localObject, "debug", Boolean.valueOf(paramWxaWidgetContext.aff().fUV));
          b((JSONObject)localObject, "drawMinInterval", Integer.valueOf(paramWxaWidgetContext.afg().fOP));
          b((JSONObject)localObject, "clientVersion", Integer.valueOf(com.tencent.mm.protocal.d.spa));
          JSONObject localJSONObject = new JSONObject();
          b(localJSONObject, "drawMinInterval", Integer.valueOf(parama.fWQ));
          b(localJSONObject, "timerEnabled", Boolean.valueOf(parama.fWR));
          b(localJSONObject, "drawLock", Boolean.valueOf(parama.fWS));
          parama = String.format("var __widgetConfig__ = %s;var __wxConfig = %s;var __wxIndexPage = \"%s\"", new Object[] { localJSONObject.toString(), ((JSONObject)localObject).toString(), "" });
          paramBundle.evaluateJavascript(parama, null);
          y.v("MicroMsg.PreloadOptimizer", "injectConfig(%s, %s)", new Object[] { paramWxaWidgetContext.getId(), parama });
          v.jdMethod_if(10);
          parama = new r();
          parama.cjv = u.jy(paramWxaWidgetContext.getId());
          parama.cjw = u.jx(paramWxaWidgetContext.getId());
          parama.cjs = 5L;
          parama.cjr = paramWxaWidgetContext.getId();
          parama.cjt = System.currentTimeMillis();
          parama.cjy = aq.fH(ae.getContext());
          parama.QX();
          parama = com.tencent.mm.plugin.appbrand.dynamic.j.c.bq(paramWxaWidgetContext.getId(), "WAWidget.js");
          if (!bk.bl(parama)) {
            break label674;
          }
          u.i("MicroMsg.PreloadOptimizer", "read WAWidget.js", new Object[0]);
          parama = com.tencent.mm.plugin.appbrand.u.d.convertStreamToString(ah.openRead("WAWidget.js"));
          if (bk.bl(parama)) {
            y.e("MicroMsg.PreloadOptimizer", "get Null Or Nil widget js");
          }
          h.nFQ.a(636L, 0L, 1L, false);
          com.tencent.mm.aa.a.a(paramBundle, parama, new e.2(paramWxaWidgetContext));
          y.v("MicroMsg.PreloadOptimizer", "injectWAWidget(%s)", new Object[] { paramWxaWidgetContext.getId() });
          v.jdMethod_if(13);
          parama = com.tencent.mm.plugin.appbrand.dynamic.j.c.bq(paramWxaWidgetContext.getId(), "widget.js");
          if (bk.bl(parama))
          {
            y.e("MicroMsg.PreloadOptimizer", "get Null Or Nil widget js");
            com.tencent.mm.plugin.appbrand.dynamic.f.aeW().aH(paramWxaWidgetContext.getId(), 2102);
          }
          h.nFQ.a(636L, 3L, 1L, false);
          com.tencent.mm.aa.a.a(paramBundle, parama, new e.3(paramWxaWidgetContext));
          y.v("MicroMsg.PreloadOptimizer", "injectWidget(%s)", new Object[] { paramWxaWidgetContext.getId() });
          ce(paramContext);
          return locale;
        }
      }
      finally {}
      boolean bool = false;
      continue;
    }
  }
  
  private static com.tencent.mm.aa.c.e afA()
  {
    com.tencent.mm.aa.c.e locale = new com.tencent.mm.aa.c.e();
    com.tencent.mm.plugin.appbrand.dynamic.e.a locala = new com.tencent.mm.plugin.appbrand.dynamic.e.a(locale);
    h.nFQ.a(639L, 2L, 1L, false);
    y.i("MicroMsg.PreloadOptimizer", "Using v8 Javascript Engine");
    h.nFQ.a(639L, 0L, 1L, false);
    if (locale.dJa != null)
    {
      y.e("MicroMsg.MiniJsBridge", "can not initialize again.");
      return locale;
    }
    locale.dJa = locala;
    return locale;
  }
  
  private static void b(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    try
    {
      paramJSONObject.put(paramString, paramObject);
      return;
    }
    catch (Exception paramJSONObject)
    {
      y.e("MicroMsg.PreloadOptimizer", "put env arguments error, %s", new Object[] { paramJSONObject });
    }
  }
  
  public static void ce(Context paramContext)
  {
    com.tencent.mm.cg.a.e(new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: ldc 8
        //   2: monitorenter
        //   3: invokestatic 25	com/tencent/mm/plugin/appbrand/dynamic/h/e:afB	()Lcom/tencent/mm/aa/c/e;
        //   6: ifnull +7 -> 13
        //   9: ldc 8
        //   11: monitorexit
        //   12: return
        //   13: ldc 8
        //   15: monitorexit
        //   16: ldc 27
        //   18: ldc 29
        //   20: iconst_0
        //   21: anewarray 4	java/lang/Object
        //   24: invokestatic 35	com/tencent/mm/modelappbrand/u:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   27: invokestatic 39	com/tencent/mm/plugin/appbrand/dynamic/h/e:afC	()Lcom/tencent/mm/plugin/appbrand/dynamic/debugger/DebuggerInfo;
        //   30: pop
        //   31: invokestatic 42	com/tencent/mm/plugin/appbrand/dynamic/h/e:afD	()Lcom/tencent/mm/aa/c/e;
        //   34: astore_1
        //   35: ldc 8
        //   37: monitorenter
        //   38: aload_1
        //   39: invokestatic 46	com/tencent/mm/plugin/appbrand/dynamic/h/e:a	(Lcom/tencent/mm/aa/c/e;)Lcom/tencent/mm/aa/c/e;
        //   42: pop
        //   43: ldc 8
        //   45: monitorexit
        //   46: return
        //   47: astore_1
        //   48: ldc 8
        //   50: monitorexit
        //   51: aload_1
        //   52: athrow
        //   53: astore_1
        //   54: ldc 8
        //   56: monitorexit
        //   57: aload_1
        //   58: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	59	0	this	1
        //   34	5	1	locale	com.tencent.mm.aa.c.e
        //   47	5	1	localObject1	Object
        //   53	5	1	localObject2	Object
        // Exception table:
        //   from	to	target	type
        //   38	46	47	finally
        //   48	51	47	finally
        //   3	12	53	finally
        //   13	16	53	finally
        //   54	57	53	finally
      }
    }, 5000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.h.e
 * JD-Core Version:    0.7.0.1
 */