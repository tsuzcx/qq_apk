package com.tencent.mm.plugin.appbrand.dynamic.h;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.mn;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.appcache.bc;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetContext;
import com.tencent.mm.plugin.appbrand.dynamic.d.p;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.j;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig;
import com.tencent.mm.plugin.appbrand.utils.z;
import com.tencent.mm.plugin.appbrand.utils.z.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class e
{
  private static volatile com.tencent.mm.ac.c.e rnt;
  private static volatile DebuggerInfo rnu;
  
  private static com.tencent.mm.ac.b.d a(com.tencent.mm.ac.c.e parame)
  {
    AppMethodBeat.i(121451);
    parame = com.tencent.mm.plugin.appbrand.dynamic.e.b.dW(parame);
    if (parame.aZj())
    {
      h.OAn.idkeyStat(639L, 1L, 1L, false);
      Log.i("MicroMsg.PreloadOptimizer", "Using WebView Based Javascript Engine");
    }
    for (;;)
    {
      h.OAn.idkeyStat(639L, 0L, 1L, false);
      AppMethodBeat.o(121451);
      return parame;
      h.OAn.idkeyStat(639L, 2L, 1L, false);
      Log.i("MicroMsg.PreloadOptimizer", "Using v8 Javascript Engine");
    }
  }
  
  public static com.tencent.mm.ac.c.e a(Context paramContext, WxaWidgetContext paramWxaWidgetContext, com.tencent.mm.ac.d.a parama, Bundle paramBundle)
  {
    AppMethodBeat.i(121447);
    label706:
    label709:
    for (;;)
    {
      try
      {
        com.tencent.mm.ac.c.e locale = rnt;
        rnt = null;
        if (locale != null)
        {
          bool = true;
          u.i("MicroMsg.PreloadOptimizer", "hit preloaded jsBridge %b", new Object[] { Boolean.valueOf(bool) });
          if (locale != null) {
            break label709;
          }
          paramWxaWidgetContext.cnE();
          locale = cnY();
          int i = paramBundle.getInt("widget_type");
          Object localObject = new com.tencent.mm.plugin.appbrand.dynamic.d.a.c();
          ((com.tencent.mm.plugin.appbrand.dynamic.d.a.c)localObject).lWh = paramWxaWidgetContext.getId();
          if (i == 1) {
            ((com.tencent.mm.plugin.appbrand.dynamic.d.a.c)localObject).rlX = new com.tencent.mm.plugin.appbrand.dynamic.i.c(paramWxaWidgetContext.getAppId(), paramBundle.getString("search_id"));
          }
          paramBundle = new com.tencent.mm.ac.c.c(paramContext, locale, parama, (com.tencent.mm.ac.c.b)localObject);
          paramBundle.mBf = p.zR(i);
          locale.mBl = paramBundle;
          paramBundle = locale.mBn;
          locale.mBm = new com.tencent.mm.ac.c.f(paramBundle, com.tencent.mm.plugin.appbrand.dynamic.f.a.zS(i), parama);
          locale.mBp = com.tencent.mm.plugin.appbrand.dynamic.debugger.a.cnK();
          parama = paramWxaWidgetContext.cnG();
          localObject = new JSONObject();
          c((JSONObject)localObject, "widgetType", Integer.valueOf(parama.rmS));
          c((JSONObject)localObject, "platform", "android");
          c((JSONObject)localObject, "debug", Boolean.valueOf(paramWxaWidgetContext.cnE().rlp));
          if (paramWxaWidgetContext.cnF() != null) {
            c((JSONObject)localObject, "drawMinInterval", Integer.valueOf(paramWxaWidgetContext.cnF().qWZ));
          }
          c((JSONObject)localObject, "clientVersion", Integer.valueOf(com.tencent.mm.protocal.d.Yxh));
          JSONObject localJSONObject = new JSONObject();
          c(localJSONObject, "drawMinInterval", Integer.valueOf(parama.rnj));
          c(localJSONObject, "timerEnabled", Boolean.valueOf(parama.rnk));
          c(localJSONObject, "drawLock", Boolean.valueOf(parama.rnl));
          parama = String.format("var __widgetConfig__ = %s;var __wxConfig = %s;var __wxIndexPage = \"%s\"", new Object[] { localJSONObject.toString(), ((JSONObject)localObject).toString(), "" });
          paramBundle.evaluateJavascript(parama, null);
          Log.v("MicroMsg.PreloadOptimizer", "injectConfig(%s, %s)", new Object[] { paramWxaWidgetContext.getId(), parama });
          v.rG(10);
          parama = new mn().uY(u.KQ(paramWxaWidgetContext.getId()));
          parama.iKD = u.KO(paramWxaWidgetContext.getId());
          parama.jbJ = 5L;
          parama = parama.uX(paramWxaWidgetContext.getId());
          parama.jbK = System.currentTimeMillis();
          parama.uZ(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bMH();
          parama = com.tencent.mm.plugin.appbrand.dynamic.j.c.dI(paramWxaWidgetContext.getId(), "WAWidget.js");
          if (!Util.isNullOrNil(parama)) {
            break label706;
          }
          u.i("MicroMsg.PreloadOptimizer", "read WAWidget.js", new Object[0]);
          parama = com.tencent.mm.plugin.appbrand.af.d.convertStreamToString(bc.Lh("WAWidget.js"));
          if (Util.isNullOrNil(parama)) {
            Log.e("MicroMsg.PreloadOptimizer", "get Null Or Nil widget js");
          }
          h.OAn.idkeyStat(636L, 0L, 1L, false);
          z.a(paramBundle, parama, new z.a()
          {
            public final void eW(String paramAnonymousString)
            {
              AppMethodBeat.i(121444);
              v.rG(12);
              mn localmn = new mn().uY(u.KQ(e.this.getId()));
              localmn.iKD = u.KO(e.this.getId());
              localmn.jbJ = 6L;
              localmn.jbL = 2L;
              localmn = localmn.uX(e.this.getId());
              localmn.jbK = System.currentTimeMillis();
              localmn.uZ(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bMH();
              j.cny().Zb(e.this.getId());
              h.OAn.idkeyStat(636L, 2L, 1L, false);
              Log.e("MicroMsg.PreloadOptimizer", "Inject SDK widget Script Failed: %s", new Object[] { paramAnonymousString });
              AppMethodBeat.o(121444);
            }
            
            public final void onSuccess(String paramAnonymousString)
            {
              AppMethodBeat.i(121443);
              v.rG(11);
              paramAnonymousString = new mn().uY(u.KQ(e.this.getId()));
              paramAnonymousString.iKD = u.KO(e.this.getId());
              paramAnonymousString.jbJ = 6L;
              paramAnonymousString.jbL = 1L;
              paramAnonymousString = paramAnonymousString.uX(e.this.getId());
              paramAnonymousString.jbK = System.currentTimeMillis();
              paramAnonymousString.uZ(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bMH();
              h.OAn.idkeyStat(636L, 1L, 1L, false);
              AppMethodBeat.o(121443);
            }
          });
          Log.v("MicroMsg.PreloadOptimizer", "injectWAWidget(%s)", new Object[] { paramWxaWidgetContext.getId() });
          v.rG(13);
          parama = com.tencent.mm.plugin.appbrand.dynamic.j.c.dI(paramWxaWidgetContext.getId(), "widget.js");
          if (Util.isNullOrNil(parama))
          {
            Log.e("MicroMsg.PreloadOptimizer", "get Null Or Nil widget js");
            com.tencent.mm.plugin.appbrand.dynamic.f.cnu().cx(paramWxaWidgetContext.getId(), 2102);
          }
          h.OAn.idkeyStat(636L, 3L, 1L, false);
          z.a(paramBundle, parama, new z.a()
          {
            public final void eW(String paramAnonymousString)
            {
              AppMethodBeat.i(121446);
              v.rG(15);
              mn localmn = new mn().uY(u.KQ(e.this.getId()));
              localmn.iKD = u.KO(e.this.getId());
              localmn.jbJ = 7L;
              localmn.jbL = 2L;
              localmn = localmn.uX(e.this.getId());
              localmn.jbK = System.currentTimeMillis();
              localmn.bMH();
              h.OAn.idkeyStat(636L, 5L, 1L, false);
              Log.e("MicroMsg.PreloadOptimizer", "Inject External widget Script Failed: %s", new Object[] { paramAnonymousString });
              AppMethodBeat.o(121446);
            }
            
            public final void onSuccess(String paramAnonymousString)
            {
              AppMethodBeat.i(121445);
              v.rG(14);
              paramAnonymousString = new mn().uY(u.KQ(e.this.getId()));
              paramAnonymousString.iKD = u.KO(e.this.getId());
              paramAnonymousString.jbJ = 7L;
              paramAnonymousString.jbL = 1L;
              paramAnonymousString = paramAnonymousString.uX(e.this.getId());
              paramAnonymousString.jbK = System.currentTimeMillis();
              paramAnonymousString.uZ(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bMH();
              h.OAn.idkeyStat(636L, 4L, 1L, false);
              j.cny().Zb(e.this.getId());
              AppMethodBeat.o(121445);
            }
          });
          Log.v("MicroMsg.PreloadOptimizer", "injectWidget(%s)", new Object[] { paramWxaWidgetContext.getId() });
          eA(paramContext);
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
  
  private static void ae(Runnable paramRunnable)
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
            e.this.run();
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
  
  private static void c(JSONObject paramJSONObject, String paramString, Object paramObject)
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
  
  private static com.tencent.mm.ac.c.e cnY()
  {
    AppMethodBeat.i(121450);
    com.tencent.mm.ac.c.e locale = new com.tencent.mm.ac.c.e();
    locale.a(a(locale));
    AppMethodBeat.o(121450);
    return locale;
  }
  
  public static void eA(Context paramContext)
  {
    AppMethodBeat.i(121449);
    if (!com.tencent.mm.plugin.expansions.e.aQh())
    {
      AppMethodBeat.o(121449);
      return;
    }
    ae(new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: ldc 22
        //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: ldc 8
        //   7: monitorenter
        //   8: invokestatic 32	com/tencent/mm/plugin/appbrand/dynamic/h/e:cnZ	()Lcom/tencent/mm/ac/c/e;
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
        //   37: invokestatic 48	com/tencent/mm/plugin/appbrand/dynamic/h/e:coa	()Lcom/tencent/mm/plugin/appbrand/dynamic/debugger/DebuggerInfo;
        //   40: pop
        //   41: invokestatic 51	com/tencent/mm/plugin/appbrand/dynamic/h/e:cob	()Lcom/tencent/mm/ac/c/e;
        //   44: astore_1
        //   45: ldc 8
        //   47: monitorenter
        //   48: aload_1
        //   49: invokestatic 55	com/tencent/mm/plugin/appbrand/dynamic/h/e:b	(Lcom/tencent/mm/ac/c/e;)Lcom/tencent/mm/ac/c/e;
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
        //   44	5	1	locale	com.tencent.mm.ac.c.e
        //   62	10	1	localObject1	Object
        //   73	10	1	localObject2	Object
        // Exception table:
        //   from	to	target	type
        //   8	17	62	finally
        //   48	56	73	finally
      }
    });
    AppMethodBeat.o(121449);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.h.e
 * JD-Core Version:    0.7.0.1
 */