package com.tencent.mm.plugin.appbrand.dynamic.h;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.el;
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
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONObject;

public class e
{
  private static volatile com.tencent.mm.aa.c.e klw;
  private static volatile DebuggerInfo klx;
  
  private static void S(Runnable paramRunnable)
  {
    AppMethodBeat.i(121448);
    paramRunnable = new e.1(paramRunnable);
    if (ar.isMainThread())
    {
      paramRunnable.run();
      AppMethodBeat.o(121448);
      return;
    }
    ar.f(paramRunnable);
    AppMethodBeat.o(121448);
  }
  
  private static com.tencent.mm.aa.b.d a(com.tencent.mm.aa.c.e parame)
  {
    AppMethodBeat.i(121451);
    parame = com.tencent.mm.plugin.appbrand.dynamic.e.b.ct(parame);
    g.yxI.idkeyStat(639L, 2L, 1L, false);
    ae.i("MicroMsg.PreloadOptimizer", "Using v8 Javascript Engine");
    g.yxI.idkeyStat(639L, 0L, 1L, false);
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
        com.tencent.mm.aa.c.e locale = klw;
        klw = null;
        if (locale != null)
        {
          bool = true;
          u.i("MicroMsg.PreloadOptimizer", "hit preloaded jsBridge %b", new Object[] { Boolean.valueOf(bool) });
          if (locale != null) {
            break label704;
          }
          locale = bgV();
          int i = paramBundle.getInt("widget_type");
          Object localObject = new com.tencent.mm.plugin.appbrand.dynamic.d.a.c();
          ((com.tencent.mm.plugin.appbrand.dynamic.d.a.c)localObject).gcZ = paramWxaWidgetContext.getId();
          if (i == 1) {
            ((com.tencent.mm.plugin.appbrand.dynamic.d.a.c)localObject).kkb = new com.tencent.mm.plugin.appbrand.dynamic.i.c(paramWxaWidgetContext.getAppId(), paramBundle.getString("search_id"));
          }
          paramBundle = new com.tencent.mm.aa.c.c(paramContext, locale, parama, (com.tencent.mm.aa.c.b)localObject);
          paramBundle.gCv = p.ss(i);
          locale.gCB = paramBundle;
          paramBundle = locale.gCD;
          locale.gCC = new com.tencent.mm.aa.c.f(paramBundle, com.tencent.mm.plugin.appbrand.dynamic.f.a.st(i), parama);
          locale.gCF = com.tencent.mm.plugin.appbrand.dynamic.debugger.a.bgG();
          parama = paramWxaWidgetContext.bgC();
          localObject = new JSONObject();
          b((JSONObject)localObject, "widgetType", Integer.valueOf(parama.kkV));
          b((JSONObject)localObject, "platform", "android");
          b((JSONObject)localObject, "debug", Boolean.valueOf(paramWxaWidgetContext.bgA().kjt));
          if (paramWxaWidgetContext.bgB() != null) {
            b((JSONObject)localObject, "drawMinInterval", Integer.valueOf(paramWxaWidgetContext.bgB().jZX));
          }
          b((JSONObject)localObject, "clientVersion", Integer.valueOf(com.tencent.mm.protocal.d.FFH));
          JSONObject localJSONObject = new JSONObject();
          b(localJSONObject, "drawMinInterval", Integer.valueOf(parama.klm));
          b(localJSONObject, "timerEnabled", Boolean.valueOf(parama.kln));
          b(localJSONObject, "drawLock", Boolean.valueOf(parama.klo));
          parama = String.format("var __widgetConfig__ = %s;var __wxConfig = %s;var __wxIndexPage = \"%s\"", new Object[] { localJSONObject.toString(), ((JSONObject)localObject).toString(), "" });
          paramBundle.evaluateJavascript(parama, null);
          ae.v("MicroMsg.PreloadOptimizer", "injectConfig(%s, %s)", new Object[] { paramWxaWidgetContext.getId(), parama });
          v.md(10);
          parama = new el().oa(u.CK(paramWxaWidgetContext.getId()));
          parama.ejC = u.CI(paramWxaWidgetContext.getId());
          parama.ejz = 5L;
          parama = parama.nZ(paramWxaWidgetContext.getId());
          parama.ejA = System.currentTimeMillis();
          parama.ob(az.iW(ak.getContext())).aLH();
          parama = com.tencent.mm.plugin.appbrand.dynamic.j.c.cR(paramWxaWidgetContext.getId(), "WAWidget.js");
          if (!bu.isNullOrNil(parama)) {
            break label701;
          }
          u.i("MicroMsg.PreloadOptimizer", "read WAWidget.js", new Object[0]);
          parama = com.tencent.mm.plugin.appbrand.y.d.convertStreamToString(ay.openRead("WAWidget.js"));
          if (bu.isNullOrNil(parama)) {
            ae.e("MicroMsg.PreloadOptimizer", "get Null Or Nil widget js");
          }
          g.yxI.idkeyStat(636L, 0L, 1L, false);
          s.a(paramBundle, parama, new s.a()
          {
            public final void cV(String paramAnonymousString)
            {
              AppMethodBeat.i(121444);
              v.md(12);
              el localel = new el().oa(u.CK(this.klz.getId()));
              localel.ejC = u.CI(this.klz.getId());
              localel.ejz = 6L;
              localel.ejB = 2L;
              localel = localel.nZ(this.klz.getId());
              localel.ejA = System.currentTimeMillis();
              localel.ob(az.iW(ak.getContext())).aLH();
              j.bgu().Pg(this.klz.getId());
              g.yxI.idkeyStat(636L, 2L, 1L, false);
              ae.e("MicroMsg.PreloadOptimizer", "Inject SDK widget Script Failed: %s", new Object[] { paramAnonymousString });
              AppMethodBeat.o(121444);
            }
            
            public final void onSuccess(String paramAnonymousString)
            {
              AppMethodBeat.i(121443);
              v.md(11);
              paramAnonymousString = new el().oa(u.CK(this.klz.getId()));
              paramAnonymousString.ejC = u.CI(this.klz.getId());
              paramAnonymousString.ejz = 6L;
              paramAnonymousString.ejB = 1L;
              paramAnonymousString = paramAnonymousString.nZ(this.klz.getId());
              paramAnonymousString.ejA = System.currentTimeMillis();
              paramAnonymousString.ob(az.iW(ak.getContext())).aLH();
              g.yxI.idkeyStat(636L, 1L, 1L, false);
              AppMethodBeat.o(121443);
            }
          });
          ae.v("MicroMsg.PreloadOptimizer", "injectWAWidget(%s)", new Object[] { paramWxaWidgetContext.getId() });
          v.md(13);
          parama = com.tencent.mm.plugin.appbrand.dynamic.j.c.cR(paramWxaWidgetContext.getId(), "widget.js");
          if (bu.isNullOrNil(parama))
          {
            ae.e("MicroMsg.PreloadOptimizer", "get Null Or Nil widget js");
            com.tencent.mm.plugin.appbrand.dynamic.f.bgq().bA(paramWxaWidgetContext.getId(), 2102);
          }
          g.yxI.idkeyStat(636L, 3L, 1L, false);
          s.a(paramBundle, parama, new s.a()
          {
            public final void cV(String paramAnonymousString)
            {
              AppMethodBeat.i(121446);
              v.md(15);
              el localel = new el().oa(u.CK(this.klz.getId()));
              localel.ejC = u.CI(this.klz.getId());
              localel.ejz = 7L;
              localel.ejB = 2L;
              localel = localel.nZ(this.klz.getId());
              localel.ejA = System.currentTimeMillis();
              localel.aLH();
              g.yxI.idkeyStat(636L, 5L, 1L, false);
              ae.e("MicroMsg.PreloadOptimizer", "Inject External widget Script Failed: %s", new Object[] { paramAnonymousString });
              AppMethodBeat.o(121446);
            }
            
            public final void onSuccess(String paramAnonymousString)
            {
              AppMethodBeat.i(121445);
              v.md(14);
              paramAnonymousString = new el().oa(u.CK(this.klz.getId()));
              paramAnonymousString.ejC = u.CI(this.klz.getId());
              paramAnonymousString.ejz = 7L;
              paramAnonymousString.ejB = 1L;
              paramAnonymousString = paramAnonymousString.nZ(this.klz.getId());
              paramAnonymousString.ejA = System.currentTimeMillis();
              paramAnonymousString.ob(az.iW(ak.getContext())).aLH();
              g.yxI.idkeyStat(636L, 4L, 1L, false);
              j.bgu().Pg(this.klz.getId());
              AppMethodBeat.o(121445);
            }
          });
          ae.v("MicroMsg.PreloadOptimizer", "injectWidget(%s)", new Object[] { paramWxaWidgetContext.getId() });
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
      ae.e("MicroMsg.PreloadOptimizer", "put env arguments error, %s", new Object[] { paramJSONObject });
      AppMethodBeat.o(121452);
    }
  }
  
  private static com.tencent.mm.aa.c.e bgV()
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
    com.tencent.mm.plugin.expansions.a.cof();
    S(new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: ldc 22
        //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: ldc 8
        //   7: monitorenter
        //   8: invokestatic 32	com/tencent/mm/plugin/appbrand/dynamic/h/e:bgW	()Lcom/tencent/mm/aa/c/e;
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
        //   37: invokestatic 48	com/tencent/mm/plugin/appbrand/dynamic/h/e:bgX	()Lcom/tencent/mm/plugin/appbrand/dynamic/debugger/DebuggerInfo;
        //   40: pop
        //   41: invokestatic 51	com/tencent/mm/plugin/appbrand/dynamic/h/e:bgY	()Lcom/tencent/mm/aa/c/e;
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