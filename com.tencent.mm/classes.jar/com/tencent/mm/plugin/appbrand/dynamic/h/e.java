package com.tencent.mm.plugin.appbrand.dynamic.h;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.hr;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.appcache.ay;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetContext;
import com.tencent.mm.plugin.appbrand.dynamic.d.p;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.j;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig;
import com.tencent.mm.plugin.appbrand.utils.s;
import com.tencent.mm.plugin.appbrand.utils.s.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class e
{
  private static volatile com.tencent.mm.aa.c.e lph;
  private static volatile DebuggerInfo lpi;
  
  private static void X(Runnable paramRunnable)
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
    if (MMHandlerThread.isMainThread())
    {
      paramRunnable.run();
      AppMethodBeat.o(121448);
      return;
    }
    MMHandlerThread.postToMainThread(paramRunnable);
    AppMethodBeat.o(121448);
  }
  
  private static com.tencent.mm.aa.b.d a(com.tencent.mm.aa.c.e parame)
  {
    AppMethodBeat.i(121451);
    parame = com.tencent.mm.plugin.appbrand.dynamic.e.b.cC(parame);
    h.CyF.idkeyStat(639L, 2L, 1L, false);
    Log.i("MicroMsg.PreloadOptimizer", "Using v8 Javascript Engine");
    h.CyF.idkeyStat(639L, 0L, 1L, false);
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
        com.tencent.mm.aa.c.e locale = lph;
        lph = null;
        if (locale != null)
        {
          bool = true;
          u.i("MicroMsg.PreloadOptimizer", "hit preloaded jsBridge %b", new Object[] { Boolean.valueOf(bool) });
          if (locale != null) {
            break label704;
          }
          locale = bCo();
          int i = paramBundle.getInt("widget_type");
          Object localObject = new com.tencent.mm.plugin.appbrand.dynamic.d.a.c();
          ((com.tencent.mm.plugin.appbrand.dynamic.d.a.c)localObject).gIx = paramWxaWidgetContext.getId();
          if (i == 1) {
            ((com.tencent.mm.plugin.appbrand.dynamic.d.a.c)localObject).lnK = new com.tencent.mm.plugin.appbrand.dynamic.i.c(paramWxaWidgetContext.getAppId(), paramBundle.getString("search_id"));
          }
          paramBundle = new com.tencent.mm.aa.c.c(paramContext, locale, parama, (com.tencent.mm.aa.c.b)localObject);
          paramBundle.hpj = p.wo(i);
          locale.hpp = paramBundle;
          paramBundle = locale.hpr;
          locale.hpq = new com.tencent.mm.aa.c.f(paramBundle, com.tencent.mm.plugin.appbrand.dynamic.f.a.wp(i), parama);
          locale.hpt = com.tencent.mm.plugin.appbrand.dynamic.debugger.a.bBZ();
          parama = paramWxaWidgetContext.bBV();
          localObject = new JSONObject();
          b((JSONObject)localObject, "widgetType", Integer.valueOf(parama.loG));
          b((JSONObject)localObject, "platform", "android");
          b((JSONObject)localObject, "debug", Boolean.valueOf(paramWxaWidgetContext.bBT().lnb));
          if (paramWxaWidgetContext.bBU() != null) {
            b((JSONObject)localObject, "drawMinInterval", Integer.valueOf(paramWxaWidgetContext.bBU().lda));
          }
          b((JSONObject)localObject, "clientVersion", Integer.valueOf(com.tencent.mm.protocal.d.KyO));
          JSONObject localJSONObject = new JSONObject();
          b(localJSONObject, "drawMinInterval", Integer.valueOf(parama.loX));
          b(localJSONObject, "timerEnabled", Boolean.valueOf(parama.loY));
          b(localJSONObject, "drawLock", Boolean.valueOf(parama.loZ));
          parama = String.format("var __widgetConfig__ = %s;var __wxConfig = %s;var __wxIndexPage = \"%s\"", new Object[] { localJSONObject.toString(), ((JSONObject)localObject).toString(), "" });
          paramBundle.evaluateJavascript(parama, null);
          Log.v("MicroMsg.PreloadOptimizer", "injectConfig(%s, %s)", new Object[] { paramWxaWidgetContext.getId(), parama });
          v.pl(10);
          parama = new hr().vt(u.Lv(paramWxaWidgetContext.getId()));
          parama.eBS = u.Lt(paramWxaWidgetContext.getId());
          parama.eMi = 5L;
          parama = parama.vs(paramWxaWidgetContext.getId());
          parama.eMj = System.currentTimeMillis();
          parama.vu(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bfK();
          parama = com.tencent.mm.plugin.appbrand.dynamic.j.c.dg(paramWxaWidgetContext.getId(), "WAWidget.js");
          if (!Util.isNullOrNil(parama)) {
            break label701;
          }
          u.i("MicroMsg.PreloadOptimizer", "read WAWidget.js", new Object[0]);
          parama = com.tencent.mm.plugin.appbrand.ac.d.convertStreamToString(ay.openRead("WAWidget.js"));
          if (Util.isNullOrNil(parama)) {
            Log.e("MicroMsg.PreloadOptimizer", "get Null Or Nil widget js");
          }
          h.CyF.idkeyStat(636L, 0L, 1L, false);
          s.a(paramBundle, parama, new s.a()
          {
            public final void du(String paramAnonymousString)
            {
              AppMethodBeat.i(121444);
              v.pl(12);
              hr localhr = new hr().vt(u.Lv(this.lpk.getId()));
              localhr.eBS = u.Lt(this.lpk.getId());
              localhr.eMi = 6L;
              localhr.eMk = 2L;
              localhr = localhr.vs(this.lpk.getId());
              localhr.eMj = System.currentTimeMillis();
              localhr.vu(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bfK();
              j.bBN().Yr(this.lpk.getId());
              h.CyF.idkeyStat(636L, 2L, 1L, false);
              Log.e("MicroMsg.PreloadOptimizer", "Inject SDK widget Script Failed: %s", new Object[] { paramAnonymousString });
              AppMethodBeat.o(121444);
            }
            
            public final void onSuccess(String paramAnonymousString)
            {
              AppMethodBeat.i(121443);
              v.pl(11);
              paramAnonymousString = new hr().vt(u.Lv(this.lpk.getId()));
              paramAnonymousString.eBS = u.Lt(this.lpk.getId());
              paramAnonymousString.eMi = 6L;
              paramAnonymousString.eMk = 1L;
              paramAnonymousString = paramAnonymousString.vs(this.lpk.getId());
              paramAnonymousString.eMj = System.currentTimeMillis();
              paramAnonymousString.vu(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bfK();
              h.CyF.idkeyStat(636L, 1L, 1L, false);
              AppMethodBeat.o(121443);
            }
          });
          Log.v("MicroMsg.PreloadOptimizer", "injectWAWidget(%s)", new Object[] { paramWxaWidgetContext.getId() });
          v.pl(13);
          parama = com.tencent.mm.plugin.appbrand.dynamic.j.c.dg(paramWxaWidgetContext.getId(), "widget.js");
          if (Util.isNullOrNil(parama))
          {
            Log.e("MicroMsg.PreloadOptimizer", "get Null Or Nil widget js");
            com.tencent.mm.plugin.appbrand.dynamic.f.bBJ().bF(paramWxaWidgetContext.getId(), 2102);
          }
          h.CyF.idkeyStat(636L, 3L, 1L, false);
          s.a(paramBundle, parama, new s.a()
          {
            public final void du(String paramAnonymousString)
            {
              AppMethodBeat.i(121446);
              v.pl(15);
              hr localhr = new hr().vt(u.Lv(this.lpk.getId()));
              localhr.eBS = u.Lt(this.lpk.getId());
              localhr.eMi = 7L;
              localhr.eMk = 2L;
              localhr = localhr.vs(this.lpk.getId());
              localhr.eMj = System.currentTimeMillis();
              localhr.bfK();
              h.CyF.idkeyStat(636L, 5L, 1L, false);
              Log.e("MicroMsg.PreloadOptimizer", "Inject External widget Script Failed: %s", new Object[] { paramAnonymousString });
              AppMethodBeat.o(121446);
            }
            
            public final void onSuccess(String paramAnonymousString)
            {
              AppMethodBeat.i(121445);
              v.pl(14);
              paramAnonymousString = new hr().vt(u.Lv(this.lpk.getId()));
              paramAnonymousString.eBS = u.Lt(this.lpk.getId());
              paramAnonymousString.eMi = 7L;
              paramAnonymousString.eMk = 1L;
              paramAnonymousString = paramAnonymousString.vs(this.lpk.getId());
              paramAnonymousString.eMj = System.currentTimeMillis();
              paramAnonymousString.vu(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bfK();
              h.CyF.idkeyStat(636L, 4L, 1L, false);
              j.bBN().Yr(this.lpk.getId());
              AppMethodBeat.o(121445);
            }
          });
          Log.v("MicroMsg.PreloadOptimizer", "injectWidget(%s)", new Object[] { paramWxaWidgetContext.getId() });
          dI(paramContext);
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
      Log.e("MicroMsg.PreloadOptimizer", "put env arguments error, %s", new Object[] { paramJSONObject });
      AppMethodBeat.o(121452);
    }
  }
  
  private static com.tencent.mm.aa.c.e bCo()
  {
    AppMethodBeat.i(121450);
    com.tencent.mm.aa.c.e locale = new com.tencent.mm.aa.c.e();
    locale.a(a(locale));
    AppMethodBeat.o(121450);
    return locale;
  }
  
  public static void dI(Context paramContext)
  {
    AppMethodBeat.i(121449);
    com.tencent.mm.plugin.expansions.a.cMr();
    X(new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: ldc 22
        //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: ldc 8
        //   7: monitorenter
        //   8: invokestatic 32	com/tencent/mm/plugin/appbrand/dynamic/h/e:bCp	()Lcom/tencent/mm/aa/c/e;
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
        //   37: invokestatic 48	com/tencent/mm/plugin/appbrand/dynamic/h/e:bCq	()Lcom/tencent/mm/plugin/appbrand/dynamic/debugger/DebuggerInfo;
        //   40: pop
        //   41: invokestatic 51	com/tencent/mm/plugin/appbrand/dynamic/h/e:bCr	()Lcom/tencent/mm/aa/c/e;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.h.e
 * JD-Core Version:    0.7.0.1
 */