package com.tencent.mm.plugin.appbrand.jsapi.z;

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
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.sdk.platformtools.j;

public final class a
  extends com.tencent.mm.plugin.appbrand.jsapi.a<c>
{
  private static final int CTRL_INDEX = 359;
  private static final String NAME = "updateApp";
  
  public final void a(final c paramc, final int paramInt)
  {
    AppMethodBeat.i(46828);
    String str = com.tencent.mm.plugin.appbrand.utils.b.vQ(paramc.getRuntime().aXx().uin);
    final LaunchParcel localLaunchParcel = h.e(paramc.getRuntime().aXx());
    localLaunchParcel.lRC = bu.fpO();
    new AppBrandPreInitTask(paramc.getContext(), localLaunchParcel, str, new AppBrandPreInitTask.a()
    {
      public final void a(final AppBrandInitConfigWC paramAnonymousAppBrandInitConfigWC, AppBrandStatObject paramAnonymousAppBrandStatObject)
      {
        AppMethodBeat.i(222691);
        if (paramAnonymousAppBrandInitConfigWC != null)
        {
          if ((paramc.getRuntime() == null) || (paramc.getRuntime().SB) || (paramc.getRuntime().isDestroyed()))
          {
            ae.e("MicroMsg.AppBrand.JsApiUpdateApp", "onResult with newConfig(%s %d %d) but runtime destroyed", new Object[] { paramAnonymousAppBrandInitConfigWC.appId, Integer.valueOf(paramAnonymousAppBrandInitConfigWC.dQv), Integer.valueOf(paramAnonymousAppBrandInitConfigWC.aDD) });
            AppMethodBeat.o(222691);
            return;
          }
          localLaunchParcel.f(paramAnonymousAppBrandInitConfigWC);
          if ((paramc.getRuntime().aXw().kbw.jLV == 0) && (paramAnonymousAppBrandInitConfigWC.aDD == paramc.getRuntime().aXw().kbw.pkgVersion) && (!bv.fpT()))
          {
            paramc.h(paramInt, a.this.e("fail the current version is the latest version", null));
            AppMethodBeat.o(222691);
            return;
          }
          paramc.K(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(46826);
              Object localObject = new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(222689);
                  p localp = a.1.this.kvs.getRuntime();
                  AppBrandInitConfigWC localAppBrandInitConfigWC = a.1.1.this.jEa;
                  if ((localp == null) || (localAppBrandInitConfigWC == null))
                  {
                    ae.e("MicroMsg.AppBrand.RuntimeRestartHelper", "restart skip with Null runtime");
                    AppMethodBeat.o(222689);
                    return;
                  }
                  if (!localp.mInitialized)
                  {
                    ae.e("MicroMsg.AppBrand.RuntimeRestartHelper", "restart %s, not initialized", new Object[] { localp.mAppId });
                    AppMethodBeat.o(222689);
                    return;
                  }
                  localp.j(new an.1(localp, localAppBrandInitConfigWC), 0L);
                  AppMethodBeat.o(222689);
                }
              };
              if ((j.IwD >= 654315264) && (j.a.rT(a.1.this.kvs.getRuntime().jzC.dQv)))
              {
                ((Runnable)localObject).run();
                AppMethodBeat.o(46826);
                return;
              }
              com.tencent.mm.plugin.appbrand.widget.dialog.b localb = new com.tencent.mm.plugin.appbrand.widget.dialog.b(a.1.this.kvs.getContext());
              localb.setCanceledOnTouchOutside(false);
              localb.setCancelable(false);
              Context localContext = a.1.this.kvs.getContext();
              int i;
              if (a.1.this.kvs.getRuntime().Ee())
              {
                i = 2131755488;
                localb.setMessage(localContext.getString(i, new Object[] { a.1.this.kvs.getRuntime().aXx().dpI }));
                localObject = new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(46825);
                    this.loM.run();
                    AppMethodBeat.o(46825);
                  }
                };
                if (a.1.this.kvs.getRuntime().aXw().kbw.jLV == 0) {
                  break label229;
                }
                localb.a(2131755487, (DialogInterface.OnClickListener)localObject);
                localb.b(2131755485, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(222690);
                    a.1.this.kvs.h(a.1.this.cjS, a.this.e("fail user canceled updateApp", null));
                    AppMethodBeat.o(222690);
                  }
                });
              }
              for (;;)
              {
                a.1.this.kvs.aWd().b(localb);
                AppMethodBeat.o(46826);
                return;
                i = 2131755489;
                break;
                label229:
                localb.a(2131755486, (DialogInterface.OnClickListener)localObject);
              }
            }
          });
          AppMethodBeat.o(222691);
          return;
        }
        paramc.h(paramInt, a.this.e("fail sync error", null));
        AppMethodBeat.o(222691);
      }
    }).bru();
    AppMethodBeat.o(46828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.a
 * JD-Core Version:    0.7.0.1
 */