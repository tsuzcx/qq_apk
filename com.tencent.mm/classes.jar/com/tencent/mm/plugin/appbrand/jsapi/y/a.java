package com.tencent.mm.plugin.appbrand.jsapi.y;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.an.1;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask.a;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.widget.dialog.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.i;

public final class a
  extends com.tencent.mm.plugin.appbrand.jsapi.a<c>
{
  private static final int CTRL_INDEX = 359;
  private static final String NAME = "updateApp";
  
  public final void a(final c paramc, final int paramInt)
  {
    AppMethodBeat.i(46828);
    String str = com.tencent.mm.plugin.appbrand.utils.a.vL(paramc.getRuntime().aXc().uin);
    final LaunchParcel localLaunchParcel = h.e(paramc.getRuntime().aXc());
    localLaunchParcel.lNb = bt.flT();
    new AppBrandPreInitTask(paramc.getContext(), localLaunchParcel, str, new AppBrandPreInitTask.a()
    {
      public final void a(final AppBrandInitConfigWC paramAnonymousAppBrandInitConfigWC, AppBrandStatObject paramAnonymousAppBrandStatObject)
      {
        AppMethodBeat.i(188532);
        if (paramAnonymousAppBrandInitConfigWC != null)
        {
          if ((paramc.getRuntime() == null) || (paramc.getRuntime().SB) || (paramc.getRuntime().isDestroyed()))
          {
            ad.e("MicroMsg.AppBrand.JsApiUpdateApp", "onResult with newConfig(%s %d %d) but runtime destroyed", new Object[] { paramAnonymousAppBrandInitConfigWC.appId, Integer.valueOf(paramAnonymousAppBrandInitConfigWC.dPf), Integer.valueOf(paramAnonymousAppBrandInitConfigWC.aDD) });
            AppMethodBeat.o(188532);
            return;
          }
          localLaunchParcel.d(paramAnonymousAppBrandInitConfigWC);
          if ((paramc.getRuntime().aXb().jYh.jIU == 0) && (paramAnonymousAppBrandInitConfigWC.aDD == paramc.getRuntime().aXb().jYh.pkgVersion) && (!bu.flY()))
          {
            paramc.h(paramInt, a.this.e("fail the current version is the latest version", null));
            AppMethodBeat.o(188532);
            return;
          }
          paramc.M(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(46826);
              Object localObject = new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(188530);
                  o localo = a.1.this.ksc.getRuntime();
                  AppBrandInitConfigWC localAppBrandInitConfigWC = a.1.1.this.jBp;
                  if ((localo == null) || (localAppBrandInitConfigWC == null))
                  {
                    ad.e("MicroMsg.AppBrand.RuntimeRestartHelper", "restart skip with Null runtime");
                    AppMethodBeat.o(188530);
                    return;
                  }
                  if (!localo.mInitialized)
                  {
                    ad.e("MicroMsg.AppBrand.RuntimeRestartHelper", "restart %s, not initialized", new Object[] { localo.mAppId });
                    AppMethodBeat.o(188530);
                    return;
                  }
                  localo.j(new an.1(localo, localAppBrandInitConfigWC), 0L);
                  AppMethodBeat.o(188530);
                }
              };
              if ((i.Ics >= 654315264) && (j.a.rQ(a.1.this.ksc.getRuntime().jwG.dPf)))
              {
                ((Runnable)localObject).run();
                AppMethodBeat.o(46826);
                return;
              }
              b localb = new b(a.1.this.ksc.getContext());
              localb.setCanceledOnTouchOutside(false);
              localb.setCancelable(false);
              Context localContext = a.1.this.ksc.getContext();
              int i;
              if (a.1.this.ksc.getRuntime().Eb())
              {
                i = 2131755488;
                localb.setMessage(localContext.getString(i, new Object[] { a.1.this.ksc.getRuntime().aXc().doD }));
                localObject = new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(46825);
                    this.lko.run();
                    AppMethodBeat.o(46825);
                  }
                };
                if (a.1.this.ksc.getRuntime().aXb().jYh.jIU == 0) {
                  break label229;
                }
                localb.a(2131755487, (DialogInterface.OnClickListener)localObject);
                localb.b(2131755485, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(188531);
                    a.1.this.ksc.h(a.1.this.cjQ, a.this.e("fail user canceled updateApp", null));
                    AppMethodBeat.o(188531);
                  }
                });
              }
              for (;;)
              {
                a.1.this.ksc.aVE().b(localb);
                AppMethodBeat.o(46826);
                return;
                i = 2131755489;
                break;
                label229:
                localb.a(2131755486, (DialogInterface.OnClickListener)localObject);
              }
            }
          });
          AppMethodBeat.o(188532);
          return;
        }
        paramc.h(paramInt, a.this.e("fail sync error", null));
        AppMethodBeat.o(188532);
      }
    }).bqK();
    AppMethodBeat.o(46828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.y.a
 * JD-Core Version:    0.7.0.1
 */