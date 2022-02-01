package com.tencent.mm.plugin.appbrand.dynamic.h;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.do;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONObject;

public class e
{
  private static volatile com.tencent.mm.aa.c.e jNV;
  private static volatile DebuggerInfo jNW;
  
  private static void V(Runnable paramRunnable)
  {
    AppMethodBeat.i(121448);
    paramRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(121441);
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
        {
          public final boolean queueIdle()
          {
            AppMethodBeat.i(121440);
            Looper.myQueue().removeIdleHandler(this);
            e.1.this.val$runnable.run();
            AppMethodBeat.o(121440);
            return false;
          }
        });
        AppMethodBeat.o(121441);
      }
    };
    if (ap.isMainThread())
    {
      paramRunnable.run();
      AppMethodBeat.o(121448);
      return;
    }
    ap.f(paramRunnable);
    AppMethodBeat.o(121448);
  }
  
  private static com.tencent.mm.aa.b.d a(com.tencent.mm.aa.c.e parame)
  {
    AppMethodBeat.i(121451);
    parame = com.tencent.mm.plugin.appbrand.dynamic.e.b.cq(parame);
    h.wUl.idkeyStat(639L, 2L, 1L, false);
    ac.i("MicroMsg.PreloadOptimizer", "Using v8 Javascript Engine");
    h.wUl.idkeyStat(639L, 0L, 1L, false);
    AppMethodBeat.o(121451);
    return parame;
  }
  
  public static com.tencent.mm.aa.c.e a(Context paramContext, WxaWidgetContext paramWxaWidgetContext, com.tencent.mm.aa.d.a parama, Bundle paramBundle)
  {
    AppMethodBeat.i(121447);
    label701:
    label704:
    for (;;)
    {
      try
      {
        com.tencent.mm.aa.c.e locale = jNV;
        jNV = null;
        if (locale != null)
        {
          bool = true;
          u.i("MicroMsg.PreloadOptimizer", "hit preloaded jsBridge %b", new Object[] { Boolean.valueOf(bool) });
          if (locale != null) {
            break label704;
          }
          locale = bcJ();
          int i = paramBundle.getInt("widget_type");
          Object localObject = new com.tencent.mm.plugin.appbrand.dynamic.d.a.c();
          ((com.tencent.mm.plugin.appbrand.dynamic.d.a.c)localObject).fHr = paramWxaWidgetContext.getId();
          if (i == 1) {
            ((com.tencent.mm.plugin.appbrand.dynamic.d.a.c)localObject).jMA = new com.tencent.mm.plugin.appbrand.dynamic.i.c(paramWxaWidgetContext.getAppId(), paramBundle.getString("search_id"));
          }
          paramBundle = new com.tencent.mm.aa.c.c(paramContext, locale, parama, (com.tencent.mm.aa.c.b)localObject);
          paramBundle.gge = p.rN(i);
          locale.ggk = paramBundle;
          paramBundle = locale.ggm;
          locale.ggl = new com.tencent.mm.aa.c.f(paramBundle, com.tencent.mm.plugin.appbrand.dynamic.f.a.rO(i), parama);
          locale.ggo = com.tencent.mm.plugin.appbrand.dynamic.debugger.a.bcu();
          parama = paramWxaWidgetContext.bcq();
          localObject = new JSONObject();
          b((JSONObject)localObject, "widgetType", Integer.valueOf(parama.jNu));
          b((JSONObject)localObject, "platform", "android");
          b((JSONObject)localObject, "debug", Boolean.valueOf(paramWxaWidgetContext.bco().jLS));
          if (paramWxaWidgetContext.bcp() != null) {
            b((JSONObject)localObject, "drawMinInterval", Integer.valueOf(paramWxaWidgetContext.bcp().jCM));
          }
          b((JSONObject)localObject, "clientVersion", Integer.valueOf(com.tencent.mm.protocal.d.DIc));
          JSONObject localJSONObject = new JSONObject();
          b(localJSONObject, "drawMinInterval", Integer.valueOf(parama.jNL));
          b(localJSONObject, "timerEnabled", Boolean.valueOf(parama.jNM));
          b(localJSONObject, "drawLock", Boolean.valueOf(parama.jNN));
          parama = String.format("var __widgetConfig__ = %s;var __wxConfig = %s;var __wxIndexPage = \"%s\"", new Object[] { localJSONObject.toString(), ((JSONObject)localObject).toString(), "" });
          paramBundle.evaluateJavascript(parama, null);
          ac.v("MicroMsg.PreloadOptimizer", "injectConfig(%s, %s)", new Object[] { paramWxaWidgetContext.getId(), parama });
          v.lA(10);
          parama = new do().ly(u.zj(paramWxaWidgetContext.getId()));
          parama.dSn = u.zh(paramWxaWidgetContext.getId());
          parama.dSk = 5L;
          parama = parama.lx(paramWxaWidgetContext.getId());
          parama.dSl = System.currentTimeMillis();
          parama.lz(ax.iH(ai.getContext())).aHZ();
          parama = com.tencent.mm.plugin.appbrand.dynamic.j.c.cN(paramWxaWidgetContext.getId(), "WAWidget.js");
          if (!bs.isNullOrNil(parama)) {
            break label701;
          }
          u.i("MicroMsg.PreloadOptimizer", "read WAWidget.js", new Object[0]);
          parama = com.tencent.mm.plugin.appbrand.z.d.convertStreamToString(aw.openRead("WAWidget.js"));
          if (bs.isNullOrNil(parama)) {
            ac.e("MicroMsg.PreloadOptimizer", "get Null Or Nil widget js");
          }
          h.wUl.idkeyStat(636L, 0L, 1L, false);
          q.a(paramBundle, parama, new q.a()
          {
            public final void bZ(String paramAnonymousString)
            {
              AppMethodBeat.i(121444);
              v.lA(12);
              do localdo = new do().ly(u.zj(this.jNY.getId()));
              localdo.dSn = u.zh(this.jNY.getId());
              localdo.dSk = 6L;
              localdo.dSm = 2L;
              localdo = localdo.lx(this.jNY.getId());
              localdo.dSl = System.currentTimeMillis();
              localdo.lz(ax.iH(ai.getContext())).aHZ();
              j.bci().Le(this.jNY.getId());
              h.wUl.idkeyStat(636L, 2L, 1L, false);
              ac.e("MicroMsg.PreloadOptimizer", "Inject SDK widget Script Failed: %s", new Object[] { paramAnonymousString });
              AppMethodBeat.o(121444);
            }
            
            public final void onSuccess(String paramAnonymousString)
            {
              AppMethodBeat.i(121443);
              v.lA(11);
              paramAnonymousString = new do().ly(u.zj(this.jNY.getId()));
              paramAnonymousString.dSn = u.zh(this.jNY.getId());
              paramAnonymousString.dSk = 6L;
              paramAnonymousString.dSm = 1L;
              paramAnonymousString = paramAnonymousString.lx(this.jNY.getId());
              paramAnonymousString.dSl = System.currentTimeMillis();
              paramAnonymousString.lz(ax.iH(ai.getContext())).aHZ();
              h.wUl.idkeyStat(636L, 1L, 1L, false);
              AppMethodBeat.o(121443);
            }
          });
          ac.v("MicroMsg.PreloadOptimizer", "injectWAWidget(%s)", new Object[] { paramWxaWidgetContext.getId() });
          v.lA(13);
          parama = com.tencent.mm.plugin.appbrand.dynamic.j.c.cN(paramWxaWidgetContext.getId(), "widget.js");
          if (bs.isNullOrNil(parama))
          {
            ac.e("MicroMsg.PreloadOptimizer", "get Null Or Nil widget js");
            com.tencent.mm.plugin.appbrand.dynamic.f.bce().bv(paramWxaWidgetContext.getId(), 2102);
          }
          h.wUl.idkeyStat(636L, 3L, 1L, false);
          q.a(paramBundle, parama, new q.a()
          {
            public final void bZ(String paramAnonymousString)
            {
              AppMethodBeat.i(121446);
              v.lA(15);
              do localdo = new do().ly(u.zj(this.jNY.getId()));
              localdo.dSn = u.zh(this.jNY.getId());
              localdo.dSk = 7L;
              localdo.dSm = 2L;
              localdo = localdo.lx(this.jNY.getId());
              localdo.dSl = System.currentTimeMillis();
              localdo.aHZ();
              h.wUl.idkeyStat(636L, 5L, 1L, false);
              ac.e("MicroMsg.PreloadOptimizer", "Inject External widget Script Failed: %s", new Object[] { paramAnonymousString });
              AppMethodBeat.o(121446);
            }
            
            public final void onSuccess(String paramAnonymousString)
            {
              AppMethodBeat.i(121445);
              v.lA(14);
              paramAnonymousString = new do().ly(u.zj(this.jNY.getId()));
              paramAnonymousString.dSn = u.zh(this.jNY.getId());
              paramAnonymousString.dSk = 7L;
              paramAnonymousString.dSm = 1L;
              paramAnonymousString = paramAnonymousString.lx(this.jNY.getId());
              paramAnonymousString.dSl = System.currentTimeMillis();
              paramAnonymousString.lz(ax.iH(ai.getContext())).aHZ();
              h.wUl.idkeyStat(636L, 4L, 1L, false);
              j.bci().Le(this.jNY.getId());
              AppMethodBeat.o(121445);
            }
          });
          ac.v("MicroMsg.PreloadOptimizer", "injectWidget(%s)", new Object[] { paramWxaWidgetContext.getId() });
          dn(paramContext);
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
      ac.e("MicroMsg.PreloadOptimizer", "put env arguments error, %s", new Object[] { paramJSONObject });
      AppMethodBeat.o(121452);
    }
  }
  
  private static com.tencent.mm.aa.c.e bcJ()
  {
    AppMethodBeat.i(121450);
    com.tencent.mm.aa.c.e locale = new com.tencent.mm.aa.c.e();
    locale.a(a(locale));
    AppMethodBeat.o(121450);
    return locale;
  }
  
  public static void dn(Context paramContext)
  {
    AppMethodBeat.i(121449);
    com.tencent.mm.plugin.expansions.a.cil();
    V(new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: ldc 22
        //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: ldc 8
        //   7: monitorenter
        //   8: invokestatic 32	com/tencent/mm/plugin/appbrand/dynamic/h/e:bcK	()Lcom/tencent/mm/aa/c/e;
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
        //   37: invokestatic 48	com/tencent/mm/plugin/appbrand/dynamic/h/e:bcL	()Lcom/tencent/mm/plugin/appbrand/dynamic/debugger/DebuggerInfo;
        //   40: pop
        //   41: invokestatic 51	com/tencent/mm/plugin/appbrand/dynamic/h/e:bcM	()Lcom/tencent/mm/aa/c/e;
        //   44: astore_1
        //   45: ldc 8
        //   47: monitorenter
        //   48: aload_1
        //   49: invokestatic 55	com/tencent/mm/plugin/appbrand/dynamic/h/e:b	(Lcom/tencent/mm/aa/c/e;)Lcom/tencent/mm/aa/c/e;
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
        //   44	5	1	locale	com.tencent.mm.aa.c.e
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.h.e
 * JD-Core Version:    0.7.0.1
 */