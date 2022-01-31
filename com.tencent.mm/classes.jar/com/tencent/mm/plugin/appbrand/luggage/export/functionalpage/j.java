package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import a.v;
import android.app.Activity;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ad;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.plugin.appbrand.k.a.c;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.s;
import com.tencent.mm.plugin.appbrand.permission.e;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController;
import com.tencent.mm.plugin.appbrand.ui.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;

public class j
  extends o
{
  private volatile e ioH;
  volatile c ioI;
  
  public j(Activity paramActivity, ad paramad)
  {
    super(paramActivity, paramad);
  }
  
  public final r atm()
  {
    AppMethodBeat.i(132146);
    g localg = new g(atV());
    AppMethodBeat.o(132146);
    return localg;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(132147);
    atO();
    com.tencent.mm.plugin.appbrand.report.quality.a.q(this);
    a(new j.1(this));
    atP();
    this.gRl.a(this.mAppId, atS().gXd, com.tencent.mm.plugin.appbrand.task.g.c(atS()));
    atV().setRequestedOrientation(1);
    com.tencent.mm.plugin.appbrand.media.a.a.onCreate(this.mAppId);
    com.tencent.mm.plugin.appbrand.media.record.c.onCreate();
    com.tencent.mm.plugin.appbrand.jsapi.h5_interact.a.o(this);
    com.tencent.mm.plugin.appbrand.backgroundfetch.i.o(this);
    AppMethodBeat.o(132147);
  }
  
  public final void onReady()
  {
    AppMethodBeat.i(132148);
    c localc = this.ioI;
    Object localObject1 = atS().hiz.hiN;
    a.f.b.j.q(localObject1, "invokeData");
    ab.i("MicroMsg.AppBrand.FunctionalAPIInvokeManager", "performInvoke with appId(" + localc.ioz.mAppId + ") data(" + (String)localObject1 + ')');
    String str1;
    String str2;
    String str3;
    int i;
    try
    {
      localObject1 = new com.tencent.mm.aa.i((String)localObject1);
      str1 = ((com.tencent.mm.aa.i)localObject1).optString("name");
      str2 = ((com.tencent.mm.aa.i)localObject1).optString("args");
      str3 = ((com.tencent.mm.aa.i)localObject1).optString("transitiveData");
      localCharSequence = (CharSequence)str1;
      if (localCharSequence == null) {
        break label427;
      }
      if (localCharSequence.length() != 0) {
        break label441;
      }
    }
    catch (com.tencent.mm.aa.g localg)
    {
      do
      {
        CharSequence localCharSequence;
        ab.e("MicroMsg.AppBrand.FunctionalAPIInvokeManager", "performInvoke, json parse e = ".concat(String.valueOf(localg)));
        AppMethodBeat.o(132148);
        return;
        switch (localg.hashCode())
        {
        }
      } while (!localg.equals("webview"));
      localObject2 = localc.ioz.atT();
      a.f.b.j.p(localObject2, "runtime.pageContainer");
      localObject2 = ((s)localObject2).getPageView();
      if (localObject2 != null) {
        break label416;
      }
      localObject2 = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalPageView");
      AppMethodBeat.o(132148);
      throw ((Throwable)localObject2);
    }
    catch (RuntimeException localRuntimeException)
    {
      label155:
      label169:
      AppMethodBeat.o(132148);
      return;
    }
    if (i == 0)
    {
      localCharSequence = (CharSequence)str2;
      if (localCharSequence != null) {
        if (localCharSequence.length() != 0) {
          break label446;
        }
      }
    }
    else
    {
      localc.cC(str3, "fail invalid args");
      AppMethodBeat.o(132148);
      return;
      localObject1 = ((com.tencent.mm.aa.i)localObject1).optString("jsapiType");
      if (localObject1 != null) {}
    }
    for (;;)
    {
      localc.cC(str3, "fail invalid args");
      localObject1 = (Throwable)new RuntimeException();
      AppMethodBeat.o(132148);
      throw ((Throwable)localObject1);
      Object localObject2;
      if (localRuntimeException.equals("appservice"))
      {
        Object localObject3 = localc.ioz.atU();
        if (localObject3 == null)
        {
          localObject3 = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalAppService");
          AppMethodBeat.o(132148);
          throw ((Throwable)localObject3);
        }
        label416:
        for (localObject3 = (m)localObject3;; localObject3 = (m)localObject3)
        {
          localc.iox += 1;
          i = localc.iox;
          localc.ioy.put(i, new n(str3));
          ((m)localObject3).aHz().invokeHandler(str1, str2, i);
          AppMethodBeat.o(132148);
          return;
        }
        label427:
        i = 1;
        break;
        label441:
        label446:
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label449;
          }
          break label155;
          i = 0;
          break;
        }
        label449:
        break label169;
      }
    }
  }
  
  public final e wO()
  {
    return this.ioH;
  }
  
  public final com.tencent.mm.plugin.appbrand.k.a wW()
  {
    AppMethodBeat.i(132149);
    a.c localc = new a.c();
    AppMethodBeat.o(132149);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.j
 * JD-Core Version:    0.7.0.1
 */