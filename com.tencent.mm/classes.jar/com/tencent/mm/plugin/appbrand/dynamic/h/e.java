package com.tencent.mm.plugin.appbrand.dynamic.h;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ej;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.appcache.ax;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetContext;
import com.tencent.mm.plugin.appbrand.dynamic.d.p;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.j;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig;
import com.tencent.mm.plugin.appbrand.utils.q;
import com.tencent.mm.plugin.appbrand.utils.q.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

public class e
{
  private static volatile com.tencent.mm.ab.c.e kig;
  private static volatile DebuggerInfo kih;
  
  private static void U(Runnable paramRunnable)
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
    g.yhR.idkeyStat(639L, 2L, 1L, false);
    ad.i("MicroMsg.PreloadOptimizer", "Using v8 Javascript Engine");
    g.yhR.idkeyStat(639L, 0L, 1L, false);
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
        com.tencent.mm.ab.c.e locale = kig;
        kig = null;
        if (locale != null)
        {
          bool = true;
          u.i("MicroMsg.PreloadOptimizer", "hit preloaded jsBridge %b", new Object[] { Boolean.valueOf(bool) });
          if (locale != null) {
            break label704;
          }
          locale = bgn();
          int i = paramBundle.getInt("widget_type");
          Object localObject = new com.tencent.mm.plugin.appbrand.dynamic.d.a.c();
          ((com.tencent.mm.plugin.appbrand.dynamic.d.a.c)localObject).gaR = paramWxaWidgetContext.getId();
          if (i == 1) {
            ((com.tencent.mm.plugin.appbrand.dynamic.d.a.c)localObject).kgL = new com.tencent.mm.plugin.appbrand.dynamic.i.c(paramWxaWidgetContext.getAppId(), paramBundle.getString("search_id"));
          }
          paramBundle = new com.tencent.mm.ab.c.c(paramContext, locale, parama, (com.tencent.mm.ab.c.b)localObject);
          paramBundle.gzO = p.sp(i);
          locale.gzU = paramBundle;
          paramBundle = locale.gzW;
          locale.gzV = new com.tencent.mm.ab.c.f(paramBundle, com.tencent.mm.plugin.appbrand.dynamic.f.a.sq(i), parama);
          locale.gzY = com.tencent.mm.plugin.appbrand.dynamic.debugger.a.bfY();
          parama = paramWxaWidgetContext.bfU();
          localObject = new JSONObject();
          b((JSONObject)localObject, "widgetType", Integer.valueOf(parama.khF));
          b((JSONObject)localObject, "platform", "android");
          b((JSONObject)localObject, "debug", Boolean.valueOf(paramWxaWidgetContext.bfS().kgd));
          if (paramWxaWidgetContext.bfT() != null) {
            b((JSONObject)localObject, "drawMinInterval", Integer.valueOf(paramWxaWidgetContext.bfT().jWI));
          }
          b((JSONObject)localObject, "clientVersion", Integer.valueOf(com.tencent.mm.protocal.d.Fnj));
          JSONObject localJSONObject = new JSONObject();
          b(localJSONObject, "drawMinInterval", Integer.valueOf(parama.khW));
          b(localJSONObject, "timerEnabled", Boolean.valueOf(parama.khX));
          b(localJSONObject, "drawLock", Boolean.valueOf(parama.khY));
          parama = String.format("var __widgetConfig__ = %s;var __wxConfig = %s;var __wxIndexPage = \"%s\"", new Object[] { localJSONObject.toString(), ((JSONObject)localObject).toString(), "" });
          paramBundle.evaluateJavascript(parama, null);
          ad.v("MicroMsg.PreloadOptimizer", "injectConfig(%s, %s)", new Object[] { paramWxaWidgetContext.getId(), parama });
          v.ma(10);
          parama = new ej().nF(u.Ci(paramWxaWidgetContext.getId()));
          parama.ehS = u.Cg(paramWxaWidgetContext.getId());
          parama.ehP = 5L;
          parama = parama.nE(paramWxaWidgetContext.getId());
          parama.ehQ = System.currentTimeMillis();
          parama.nG(ay.iR(aj.getContext())).aLk();
          parama = com.tencent.mm.plugin.appbrand.dynamic.j.c.cP(paramWxaWidgetContext.getId(), "WAWidget.js");
          if (!bt.isNullOrNil(parama)) {
            break label701;
          }
          u.i("MicroMsg.PreloadOptimizer", "read WAWidget.js", new Object[0]);
          parama = com.tencent.mm.plugin.appbrand.z.d.convertStreamToString(ax.openRead("WAWidget.js"));
          if (bt.isNullOrNil(parama)) {
            ad.e("MicroMsg.PreloadOptimizer", "get Null Or Nil widget js");
          }
          g.yhR.idkeyStat(636L, 0L, 1L, false);
          q.a(paramBundle, parama, new q.a()
          {
            public final void cT(String paramAnonymousString)
            {
              AppMethodBeat.i(121444);
              v.ma(12);
              ej localej = new ej().nF(u.Ci(this.kij.getId()));
              localej.ehS = u.Cg(this.kij.getId());
              localej.ehP = 6L;
              localej.ehR = 2L;
              localej = localej.nE(this.kij.getId());
              localej.ehQ = System.currentTimeMillis();
              localej.nG(ay.iR(aj.getContext())).aLk();
              j.bfM().Oy(this.kij.getId());
              g.yhR.idkeyStat(636L, 2L, 1L, false);
              ad.e("MicroMsg.PreloadOptimizer", "Inject SDK widget Script Failed: %s", new Object[] { paramAnonymousString });
              AppMethodBeat.o(121444);
            }
            
            public final void onSuccess(String paramAnonymousString)
            {
              AppMethodBeat.i(121443);
              v.ma(11);
              paramAnonymousString = new ej().nF(u.Ci(this.kij.getId()));
              paramAnonymousString.ehS = u.Cg(this.kij.getId());
              paramAnonymousString.ehP = 6L;
              paramAnonymousString.ehR = 1L;
              paramAnonymousString = paramAnonymousString.nE(this.kij.getId());
              paramAnonymousString.ehQ = System.currentTimeMillis();
              paramAnonymousString.nG(ay.iR(aj.getContext())).aLk();
              g.yhR.idkeyStat(636L, 1L, 1L, false);
              AppMethodBeat.o(121443);
            }
          });
          ad.v("MicroMsg.PreloadOptimizer", "injectWAWidget(%s)", new Object[] { paramWxaWidgetContext.getId() });
          v.ma(13);
          parama = com.tencent.mm.plugin.appbrand.dynamic.j.c.cP(paramWxaWidgetContext.getId(), "widget.js");
          if (bt.isNullOrNil(parama))
          {
            ad.e("MicroMsg.PreloadOptimizer", "get Null Or Nil widget js");
            com.tencent.mm.plugin.appbrand.dynamic.f.bfI().bx(paramWxaWidgetContext.getId(), 2102);
          }
          g.yhR.idkeyStat(636L, 3L, 1L, false);
          q.a(paramBundle, parama, new q.a()
          {
            public final void cT(String paramAnonymousString)
            {
              AppMethodBeat.i(121446);
              v.ma(15);
              ej localej = new ej().nF(u.Ci(this.kij.getId()));
              localej.ehS = u.Cg(this.kij.getId());
              localej.ehP = 7L;
              localej.ehR = 2L;
              localej = localej.nE(this.kij.getId());
              localej.ehQ = System.currentTimeMillis();
              localej.aLk();
              g.yhR.idkeyStat(636L, 5L, 1L, false);
              ad.e("MicroMsg.PreloadOptimizer", "Inject External widget Script Failed: %s", new Object[] { paramAnonymousString });
              AppMethodBeat.o(121446);
            }
            
            public final void onSuccess(String paramAnonymousString)
            {
              AppMethodBeat.i(121445);
              v.ma(14);
              paramAnonymousString = new ej().nF(u.Ci(this.kij.getId()));
              paramAnonymousString.ehS = u.Cg(this.kij.getId());
              paramAnonymousString.ehP = 7L;
              paramAnonymousString.ehR = 1L;
              paramAnonymousString = paramAnonymousString.nE(this.kij.getId());
              paramAnonymousString.ehQ = System.currentTimeMillis();
              paramAnonymousString.nG(ay.iR(aj.getContext())).aLk();
              g.yhR.idkeyStat(636L, 4L, 1L, false);
              j.bfM().Oy(this.kij.getId());
              AppMethodBeat.o(121445);
            }
          });
          ad.v("MicroMsg.PreloadOptimizer", "injectWidget(%s)", new Object[] { paramWxaWidgetContext.getId() });
          dl(paramContext);
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
      ad.e("MicroMsg.PreloadOptimizer", "put env arguments error, %s", new Object[] { paramJSONObject });
      AppMethodBeat.o(121452);
    }
  }
  
  private static com.tencent.mm.ab.c.e bgn()
  {
    AppMethodBeat.i(121450);
    com.tencent.mm.ab.c.e locale = new com.tencent.mm.ab.c.e();
    locale.a(a(locale));
    AppMethodBeat.o(121450);
    return locale;
  }
  
  public static void dl(Context paramContext)
  {
    AppMethodBeat.i(121449);
    com.tencent.mm.plugin.expansions.a.cmP();
    U(new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: ldc 22
        //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: ldc 8
        //   7: monitorenter
        //   8: invokestatic 32	com/tencent/mm/plugin/appbrand/dynamic/h/e:bgo	()Lcom/tencent/mm/ab/c/e;
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
        //   37: invokestatic 48	com/tencent/mm/plugin/appbrand/dynamic/h/e:bgp	()Lcom/tencent/mm/plugin/appbrand/dynamic/debugger/DebuggerInfo;
        //   40: pop
        //   41: invokestatic 51	com/tencent/mm/plugin/appbrand/dynamic/h/e:bgq	()Lcom/tencent/mm/ab/c/e;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.h.e
 * JD-Core Version:    0.7.0.1
 */