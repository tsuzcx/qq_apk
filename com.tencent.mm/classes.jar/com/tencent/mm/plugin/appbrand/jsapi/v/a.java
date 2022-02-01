package com.tencent.mm.plugin.appbrand.jsapi.v;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.am.1;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask.a;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.widget.dialog.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
  extends com.tencent.mm.plugin.appbrand.jsapi.a<c>
{
  private static final int CTRL_INDEX = 359;
  private static final String NAME = "updateApp";
  
  public final void a(final c paramc, final int paramInt)
  {
    AppMethodBeat.i(46828);
    String str = com.tencent.mm.plugin.appbrand.utils.a.vf(paramc.getRuntime().aTS().uin);
    final LaunchParcel localLaunchParcel = com.tencent.mm.plugin.appbrand.config.h.e(paramc.getRuntime().aTS());
    localLaunchParcel.lpI = bs.eWj();
    new AppBrandPreInitTask(paramc.getContext(), localLaunchParcel, str, new AppBrandPreInitTask.a()
    {
      public final void f(final AppBrandInitConfigWC paramAnonymousAppBrandInitConfigWC)
      {
        AppMethodBeat.i(46827);
        if (paramAnonymousAppBrandInitConfigWC != null)
        {
          if ((paramc.getRuntime() == null) || (paramc.getRuntime().QM) || (paramc.getRuntime().isDestroyed()))
          {
            ac.e("MicroMsg.AppBrand.JsApiUpdateApp", "onResult with newConfig(%s %d %d) but runtime destroyed", new Object[] { paramAnonymousAppBrandInitConfigWC.appId, Integer.valueOf(paramAnonymousAppBrandInitConfigWC.joY), Integer.valueOf(paramAnonymousAppBrandInitConfigWC.aBM) });
            AppMethodBeat.o(46827);
            return;
          }
          localLaunchParcel.d(paramAnonymousAppBrandInitConfigWC);
          if ((paramc.getRuntime().aTR().jEg.jpa == 0) && (paramAnonymousAppBrandInitConfigWC.aBM == paramc.getRuntime().aTR().jEg.pkgVersion) && (!bt.eWo()))
          {
            paramc.h(paramInt, a.this.e("fail the current version is the latest version", null));
            AppMethodBeat.o(46827);
            return;
          }
          paramc.N(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(46826);
              Object localObject = new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(186768);
                  o localo = a.1.this.jXH.getRuntime();
                  AppBrandInitConfigWC localAppBrandInitConfigWC = a.1.1.this.jhZ;
                  if ((localo == null) || (localAppBrandInitConfigWC == null))
                  {
                    ac.e("MicroMsg.AppBrand.RuntimeRestartHelper", "restart skip with Null runtime");
                    AppMethodBeat.o(186768);
                    return;
                  }
                  if (!localo.mInitialized)
                  {
                    ac.e("MicroMsg.AppBrand.RuntimeRestartHelper", "restart %s, not initialized", new Object[] { localo.mAppId });
                    AppMethodBeat.o(186768);
                    return;
                  }
                  localo.i(new am.1(localo, localAppBrandInitConfigWC), 0L);
                  AppMethodBeat.o(186768);
                }
              };
              if ((com.tencent.mm.sdk.platformtools.h.GqE >= 654315264) && (j.a.rq(a.1.this.jXH.getRuntime().jdx.joY)))
              {
                ((Runnable)localObject).run();
                AppMethodBeat.o(46826);
                return;
              }
              b localb = new b(a.1.this.jXH.getContext());
              localb.setCanceledOnTouchOutside(false);
              localb.setCancelable(false);
              Context localContext = a.1.this.jXH.getContext();
              int i;
              if (a.1.this.jXH.getRuntime().CC())
              {
                i = 2131755488;
                localb.setMessage(localContext.getString(i, new Object[] { a.1.this.jXH.getRuntime().aTS().ddh }));
                localObject = new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(46825);
                    this.kNL.run();
                    AppMethodBeat.o(46825);
                  }
                };
                if (a.1.this.jXH.getRuntime().aTR().jEg.jpa == 0) {
                  break label229;
                }
                localb.a(2131755487, (DialogInterface.OnClickListener)localObject);
                localb.b(2131755485, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(186769);
                    a.1.this.jXH.h(a.1.this.bZy, a.this.e("fail user canceled updateApp", null));
                    AppMethodBeat.o(186769);
                  }
                });
              }
              for (;;)
              {
                a.1.this.jXH.aSs().b(localb);
                AppMethodBeat.o(46826);
                return;
                i = 2131755489;
                break;
                label229:
                localb.a(2131755486, (DialogInterface.OnClickListener)localObject);
              }
            }
          });
          AppMethodBeat.o(46827);
          return;
        }
        paramc.h(paramInt, a.this.e("fail sync error", null));
        AppMethodBeat.o(46827);
      }
    }).bmZ();
    AppMethodBeat.o(46828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.a
 * JD-Core Version:    0.7.0.1
 */