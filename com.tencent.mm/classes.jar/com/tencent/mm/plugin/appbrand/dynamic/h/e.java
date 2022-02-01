package com.tencent.mm.plugin.appbrand.dynamic.h;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ca;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.appcache.aw;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetContext;
import com.tencent.mm.plugin.appbrand.dynamic.d.p;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.j;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig;
import com.tencent.mm.plugin.appbrand.utils.q;
import com.tencent.mm.plugin.appbrand.utils.q.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

public class e
{
  private static volatile com.tencent.mm.ab.c.e jnJ;
  private static volatile DebuggerInfo jnK;
  
  private static void T(Runnable paramRunnable)
  {
    AppMethodBeat.i(121448);
    paramRunnable = new e.1(paramRunnable);
    if (aq.isMainThread())
    {
      paramRunnable.run();
      AppMethodBeat.o(121448);
      return;
    }
    aq.f(paramRunnable);
    AppMethodBeat.o(121448);
  }
  
  private static com.tencent.mm.ab.b.d a(com.tencent.mm.ab.c.e parame)
  {
    AppMethodBeat.i(121451);
    parame = com.tencent.mm.plugin.appbrand.dynamic.e.b.cs(parame);
    h.vKh.idkeyStat(639L, 2L, 1L, false);
    ad.i("MicroMsg.PreloadOptimizer", "Using v8 Javascript Engine");
    h.vKh.idkeyStat(639L, 0L, 1L, false);
    AppMethodBeat.o(121451);
    return parame;
  }
  
  public static com.tencent.mm.ab.c.e a(Context paramContext, WxaWidgetContext paramWxaWidgetContext, com.tencent.mm.ab.d.a parama, Bundle paramBundle)
  {
    AppMethodBeat.i(121447);
    label701:
    label704:
    for (;;)
    {
      try
      {
        com.tencent.mm.ab.c.e locale = jnJ;
        jnJ = null;
        if (locale != null)
        {
          bool = true;
          u.i("MicroMsg.PreloadOptimizer", "hit preloaded jsBridge %b", new Object[] { Boolean.valueOf(bool) });
          if (locale != null) {
            break label704;
          }
          locale = aVL();
          int i = paramBundle.getInt("widget_type");
          Object localObject = new com.tencent.mm.plugin.appbrand.dynamic.d.a.c();
          ((com.tencent.mm.plugin.appbrand.dynamic.d.a.c)localObject).fDK = paramWxaWidgetContext.getId();
          if (i == 1) {
            ((com.tencent.mm.plugin.appbrand.dynamic.d.a.c)localObject).jmn = new com.tencent.mm.plugin.appbrand.dynamic.i.c(paramWxaWidgetContext.getAppId(), paramBundle.getString("search_id"));
          }
          paramBundle = new com.tencent.mm.ab.c.c(paramContext, locale, parama, (com.tencent.mm.ab.c.b)localObject);
          paramBundle.gby = p.ra(i);
          locale.gbE = paramBundle;
          paramBundle = locale.gbG;
          locale.gbF = new com.tencent.mm.ab.c.f(paramBundle, com.tencent.mm.plugin.appbrand.dynamic.f.a.rb(i), parama);
          locale.gbI = com.tencent.mm.plugin.appbrand.dynamic.debugger.a.aVw();
          parama = paramWxaWidgetContext.aVs();
          localObject = new JSONObject();
          b((JSONObject)localObject, "widgetType", Integer.valueOf(parama.jnh));
          b((JSONObject)localObject, "platform", "android");
          b((JSONObject)localObject, "debug", Boolean.valueOf(paramWxaWidgetContext.aVq().jlF));
          if (paramWxaWidgetContext.aVr() != null) {
            b((JSONObject)localObject, "drawMinInterval", Integer.valueOf(paramWxaWidgetContext.aVr().jcz));
          }
          b((JSONObject)localObject, "clientVersion", Integer.valueOf(com.tencent.mm.protocal.d.CpK));
          JSONObject localJSONObject = new JSONObject();
          b(localJSONObject, "drawMinInterval", Integer.valueOf(parama.jnz));
          b(localJSONObject, "timerEnabled", Boolean.valueOf(parama.jnA));
          b(localJSONObject, "drawLock", Boolean.valueOf(parama.jnB));
          parama = String.format("var __widgetConfig__ = %s;var __wxConfig = %s;var __wxIndexPage = \"%s\"", new Object[] { localJSONObject.toString(), ((JSONObject)localObject).toString(), "" });
          paramBundle.evaluateJavascript(parama, null);
          ad.v("MicroMsg.PreloadOptimizer", "injectConfig(%s, %s)", new Object[] { paramWxaWidgetContext.getId(), parama });
          v.lI(10);
          parama = new ca().iI(u.vd(paramWxaWidgetContext.getId()));
          parama.dQy = u.vb(paramWxaWidgetContext.getId());
          parama.dQv = 5L;
          parama = parama.iH(paramWxaWidgetContext.getId());
          parama.dQw = System.currentTimeMillis();
          parama.iJ(ay.iw(aj.getContext())).aBj();
          parama = com.tencent.mm.plugin.appbrand.dynamic.j.c.cD(paramWxaWidgetContext.getId(), "WAWidget.js");
          if (!bt.isNullOrNil(parama)) {
            break label701;
          }
          u.i("MicroMsg.PreloadOptimizer", "read WAWidget.js", new Object[0]);
          parama = com.tencent.mm.plugin.appbrand.aa.d.convertStreamToString(aw.openRead("WAWidget.js"));
          if (bt.isNullOrNil(parama)) {
            ad.e("MicroMsg.PreloadOptimizer", "get Null Or Nil widget js");
          }
          h.vKh.idkeyStat(636L, 0L, 1L, false);
          q.a(paramBundle, parama, new q.a()
          {
            public final void cj(String paramAnonymousString)
            {
              AppMethodBeat.i(121444);
              v.lI(12);
              ca localca = new ca().iI(u.vd(this.jnM.getId()));
              localca.dQy = u.vb(this.jnM.getId());
              localca.dQv = 6L;
              localca.dQx = 2L;
              localca = localca.iH(this.jnM.getId());
              localca.dQw = System.currentTimeMillis();
              localca.iJ(ay.iw(aj.getContext())).aBj();
              j.aVk().Ha(this.jnM.getId());
              h.vKh.idkeyStat(636L, 2L, 1L, false);
              ad.e("MicroMsg.PreloadOptimizer", "Inject SDK widget Script Failed: %s", new Object[] { paramAnonymousString });
              AppMethodBeat.o(121444);
            }
            
            public final void onSuccess(String paramAnonymousString)
            {
              AppMethodBeat.i(121443);
              v.lI(11);
              paramAnonymousString = new ca().iI(u.vd(this.jnM.getId()));
              paramAnonymousString.dQy = u.vb(this.jnM.getId());
              paramAnonymousString.dQv = 6L;
              paramAnonymousString.dQx = 1L;
              paramAnonymousString = paramAnonymousString.iH(this.jnM.getId());
              paramAnonymousString.dQw = System.currentTimeMillis();
              paramAnonymousString.iJ(ay.iw(aj.getContext())).aBj();
              h.vKh.idkeyStat(636L, 1L, 1L, false);
              AppMethodBeat.o(121443);
            }
          });
          ad.v("MicroMsg.PreloadOptimizer", "injectWAWidget(%s)", new Object[] { paramWxaWidgetContext.getId() });
          v.lI(13);
          parama = com.tencent.mm.plugin.appbrand.dynamic.j.c.cD(paramWxaWidgetContext.getId(), "widget.js");
          if (bt.isNullOrNil(parama))
          {
            ad.e("MicroMsg.PreloadOptimizer", "get Null Or Nil widget js");
            com.tencent.mm.plugin.appbrand.dynamic.f.aVg().br(paramWxaWidgetContext.getId(), 2102);
          }
          h.vKh.idkeyStat(636L, 3L, 1L, false);
          q.a(paramBundle, parama, new q.a()
          {
            public final void cj(String paramAnonymousString)
            {
              AppMethodBeat.i(121446);
              v.lI(15);
              ca localca = new ca().iI(u.vd(this.jnM.getId()));
              localca.dQy = u.vb(this.jnM.getId());
              localca.dQv = 7L;
              localca.dQx = 2L;
              localca = localca.iH(this.jnM.getId());
              localca.dQw = System.currentTimeMillis();
              localca.aBj();
              h.vKh.idkeyStat(636L, 5L, 1L, false);
              ad.e("MicroMsg.PreloadOptimizer", "Inject External widget Script Failed: %s", new Object[] { paramAnonymousString });
              AppMethodBeat.o(121446);
            }
            
            public final void onSuccess(String paramAnonymousString)
            {
              AppMethodBeat.i(121445);
              v.lI(14);
              paramAnonymousString = new ca().iI(u.vd(this.jnM.getId()));
              paramAnonymousString.dQy = u.vb(this.jnM.getId());
              paramAnonymousString.dQv = 7L;
              paramAnonymousString.dQx = 1L;
              paramAnonymousString = paramAnonymousString.iH(this.jnM.getId());
              paramAnonymousString.dQw = System.currentTimeMillis();
              paramAnonymousString.iJ(ay.iw(aj.getContext())).aBj();
              h.vKh.idkeyStat(636L, 4L, 1L, false);
              j.aVk().Ha(this.jnM.getId());
              AppMethodBeat.o(121445);
            }
          });
          ad.v("MicroMsg.PreloadOptimizer", "injectWidget(%s)", new Object[] { paramWxaWidgetContext.getId() });
          de(paramContext);
          AppMethodBeat.o(121447);
          return locale;
        }
      }
      finally
      {
        AppMethodBeat.o(121447);
      }
      boolean bool = false;
      continue;
    }
  }
  
  private static com.tencent.mm.ab.c.e aVL()
  {
    AppMethodBeat.i(121450);
    com.tencent.mm.ab.c.e locale = new com.tencent.mm.ab.c.e();
    locale.a(a(locale));
    AppMethodBeat.o(121450);
    return locale;
  }
  
  private static void b(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    AppMethodBeat.i(121452);
    try
    {
      paramJSONObject.put(paramString, paramObject);
      AppMethodBeat.o(121452);
      return;
    }
    catch (Exception paramJSONObject)
    {
      ad.e("MicroMsg.PreloadOptimizer", "put env arguments error, %s", new Object[] { paramJSONObject });
      AppMethodBeat.o(121452);
    }
  }
  
  public static void de(Context paramContext)
  {
    AppMethodBeat.i(121449);
    com.tencent.mm.plugin.expansions.a.cbc();
    T(new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: ldc 22
        //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: ldc 8
        //   7: monitorenter
        //   8: invokestatic 32	com/tencent/mm/plugin/appbrand/dynamic/h/e:aVM	()Lcom/tencent/mm/ab/c/e;
        //   11: ifnull +12 -> 23
        //   14: ldc 8
        //   16: monitorexit
        //   17: ldc 22
        //   19: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   22: return
        //   23: ldc 8
        //   25: monitorexit
        //   26: ldc 37
        //   28: ldc 39
        //   30: iconst_0
        //   31: anewarray 4	java/lang/Object
        //   34: invokestatic 44	com/tencent/mm/modelappbrand/u:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   37: invokestatic 48	com/tencent/mm/plugin/appbrand/dynamic/h/e:aVN	()Lcom/tencent/mm/plugin/appbrand/dynamic/debugger/DebuggerInfo;
        //   40: pop
        //   41: invokestatic 51	com/tencent/mm/plugin/appbrand/dynamic/h/e:aVO	()Lcom/tencent/mm/ab/c/e;
        //   44: astore_1
        //   45: ldc 8
        //   47: monitorenter
        //   48: aload_1
        //   49: invokestatic 55	com/tencent/mm/plugin/appbrand/dynamic/h/e:b	(Lcom/tencent/mm/ab/c/e;)Lcom/tencent/mm/ab/c/e;
        //   52: pop
        //   53: ldc 8
        //   55: monitorexit
        //   56: ldc 22
        //   58: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   61: return
        //   62: astore_1
        //   63: ldc 8
        //   65: monitorexit
        //   66: ldc 22
        //   68: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   71: aload_1
        //   72: athrow
        //   73: astore_1
        //   74: ldc 8
        //   76: monitorexit
        //   77: ldc 22
        //   79: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   82: aload_1
        //   83: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	84	0	this	2
        //   44	5	1	locale	com.tencent.mm.ab.c.e
        //   62	10	1	localObject1	Object
        //   73	10	1	localObject2	Object
        // Exception table:
        //   from	to	target	type
        //   8	17	62	finally
        //   23	26	62	finally
        //   63	66	62	finally
        //   48	56	73	finally
        //   74	77	73	finally
      }
    });
    AppMethodBeat.o(121449);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.h.e
 * JD-Core Version:    0.7.0.1
 */