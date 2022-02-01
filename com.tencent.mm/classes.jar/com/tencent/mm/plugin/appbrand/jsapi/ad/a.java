package com.tencent.mm.plugin.appbrand.jsapi.ad;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.ba.1;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.i;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask.a;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.appbrand.widget.dialog.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a
  extends com.tencent.mm.plugin.appbrand.jsapi.c<com.tencent.mm.plugin.appbrand.service.c>
{
  private static final int CTRL_INDEX = 359;
  private static final String NAME = "updateApp";
  
  public final void a(final com.tencent.mm.plugin.appbrand.service.c paramc, final int paramInt)
  {
    AppMethodBeat.i(46828);
    LaunchParcel localLaunchParcel = i.e(paramc.getRuntime().bDy());
    localLaunchParcel.pZk = Util.nowMilliSecond();
    new AppBrandPreInitTask(paramc.getContext(), localLaunchParcel, new AppBrandPreInitTask.a()
    {
      public final void a(final AppBrandInitConfigWC paramAnonymousAppBrandInitConfigWC, AppBrandStatObject paramAnonymousAppBrandStatObject)
      {
        AppMethodBeat.i(272187);
        if (paramAnonymousAppBrandInitConfigWC != null)
        {
          if ((paramc.getRuntime() == null) || (paramc.getRuntime().aol) || (paramc.getRuntime().ntU.get()))
          {
            Log.e("MicroMsg.AppBrand.JsApiUpdateApp", "onResult with newConfig(%s %d %d) but runtime destroyed", new Object[] { paramAnonymousAppBrandInitConfigWC.appId, Integer.valueOf(paramAnonymousAppBrandInitConfigWC.cBI), Integer.valueOf(paramAnonymousAppBrandInitConfigWC.appVersion) });
            AppMethodBeat.o(272187);
            return;
          }
          if ((paramc.getRuntime().bDx().nYR.nHY == 0) && (paramAnonymousAppBrandInitConfigWC.appVersion == paramc.getRuntime().bDx().nYR.pkgVersion) && (!WeChatEnvironment.hasDebugger()))
          {
            paramc.j(paramInt, a.this.h("fail the current version is the latest version", null));
            AppMethodBeat.o(272187);
            return;
          }
          paramc.P(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(46826);
              Object localObject = new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(278615);
                  t localt = a.1.this.nAX.getRuntime();
                  AppBrandInitConfigWC localAppBrandInitConfigWC = a.1.1.this.nzp;
                  if ((localt == null) || (localAppBrandInitConfigWC == null))
                  {
                    Log.e("MicroMsg.AppBrand.RuntimeRestartHelper", "restart skip with Null runtime");
                    AppMethodBeat.o(278615);
                    return;
                  }
                  if (!localt.mInitialized)
                  {
                    Log.e("MicroMsg.AppBrand.RuntimeRestartHelper", "restart %s, not initialized", new Object[] { localt.mAppId });
                    AppMethodBeat.o(278615);
                    return;
                  }
                  localt.h(new ba.1(localt, localAppBrandInitConfigWC), 0L);
                  AppMethodBeat.o(278615);
                }
              };
              if ((BuildInfo.CLIENT_VERSION_INT >= 654315264) && (j.a.za(a.1.this.nAX.getRuntime().ntz.cBI)))
              {
                ((Runnable)localObject).run();
                AppMethodBeat.o(46826);
                return;
              }
              b localb = new b(a.1.this.nAX.getContext());
              localb.setCanceledOnTouchOutside(false);
              localb.setCancelable(false);
              Context localContext = a.1.this.nAX.getContext();
              int i;
              if (a.1.this.nAX.getRuntime().Qv())
              {
                i = au.i.app_brand_jsapi_update_app_need_reboot_wording_for_game;
                localb.setMessage(localContext.getString(i, new Object[] { a.1.this.nAX.getRuntime().bDy().fzM }));
                localObject = new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(46825);
                    this.ptR.run();
                    AppMethodBeat.o(46825);
                  }
                };
                if (a.1.this.nAX.getRuntime().bDx().nYR.nHY == 0) {
                  break label233;
                }
                localb.a(au.i.app_brand_jsapi_update_app_dialog_confirm_for_debug, (DialogInterface.OnClickListener)localObject);
                localb.b(au.i.app_brand_jsapi_update_app_dialog_cancel_for_debug, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(280636);
                    a.1.this.nAX.j(a.1.this.cuf, a.this.h("fail user canceled updateApp", null));
                    AppMethodBeat.o(280636);
                  }
                });
              }
              for (;;)
              {
                a.1.this.nAX.getDialogContainer().a(localb);
                AppMethodBeat.o(46826);
                return;
                i = au.i.app_brand_jsapi_update_app_need_reboot_wording_for_normal;
                break;
                label233:
                localb.a(au.i.app_brand_jsapi_update_app_dialog_confirm, (DialogInterface.OnClickListener)localObject);
              }
            }
          });
          AppMethodBeat.o(272187);
          return;
        }
        paramc.j(paramInt, a.this.h("fail sync error", null));
        AppMethodBeat.o(272187);
      }
    }).bZw();
    AppMethodBeat.o(46828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.a
 * JD-Core Version:    0.7.0.1
 */