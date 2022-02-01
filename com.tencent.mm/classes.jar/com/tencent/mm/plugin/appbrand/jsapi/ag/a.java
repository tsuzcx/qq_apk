package com.tencent.mm.plugin.appbrand.jsapi.ag;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.k.a;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.bg;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.i;
import com.tencent.mm.plugin.appbrand.config.n;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask.a;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.appbrand.widget.dialog.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.r;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a
  extends com.tencent.mm.plugin.appbrand.jsapi.c<com.tencent.mm.plugin.appbrand.service.c>
{
  private static final int CTRL_INDEX = 359;
  public static final String NAME = "updateApp";
  
  public final void a(final com.tencent.mm.plugin.appbrand.service.c paramc, final int paramInt)
  {
    AppMethodBeat.i(46828);
    LaunchParcel localLaunchParcel = i.g(paramc.getRuntime().getInitConfig());
    localLaunchParcel.tdX = Util.nowMilliSecond();
    paramc = new AppBrandPreInitTask(paramc.getContext(), localLaunchParcel, new AppBrandPreInitTask.a()
    {
      public final void onResult(final AppBrandInitConfigWC paramAnonymousAppBrandInitConfigWC, AppBrandStatObject paramAnonymousAppBrandStatObject)
      {
        AppMethodBeat.i(326286);
        if (paramAnonymousAppBrandInitConfigWC != null)
        {
          if ((paramc.getRuntime() == null) || (paramc.getRuntime().ccV) || (paramc.getRuntime().qsE.get()))
          {
            Log.e("MicroMsg.AppBrand.JsApiUpdateApp", "onResult with newConfig(%s %d %d) but runtime destroyed", new Object[] { paramAnonymousAppBrandInitConfigWC.appId, Integer.valueOf(paramAnonymousAppBrandInitConfigWC.eul), Integer.valueOf(paramAnonymousAppBrandInitConfigWC.appVersion) });
            AppMethodBeat.o(326286);
            return;
          }
          paramc.V(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(46826);
              Object localObject = new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(326293);
                  bg.a(a.1.this.qAj.getRuntime(), a.1.1.this.qyp, com.tencent.mm.plugin.appbrand.launching.report.a.teW);
                  AppMethodBeat.o(326293);
                }
              };
              if ((BuildInfo.CLIENT_VERSION_INT >= 654315264) && (k.a.zn(a.1.this.qAj.getRuntime().qsh.eul)))
              {
                a.1.this.qAj.getRuntime().U((Runnable)localObject);
                AppMethodBeat.o(46826);
                return;
              }
              b localb = new b(a.1.this.qAj.getContext());
              localb.setCanceledOnTouchOutside(false);
              localb.setCancelable(false);
              Context localContext = a.1.this.qAj.getContext();
              int i;
              if (a.1.this.qAj.getRuntime().aqJ())
              {
                i = ba.i.app_brand_jsapi_update_app_need_reboot_wording_for_game;
                localb.setMessage(localContext.getString(i, new Object[] { a.1.this.qAj.getRuntime().getInitConfig().hEy }));
                localObject = new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(46825);
                    this.syV.run();
                    AppMethodBeat.o(46825);
                  }
                };
                if (a.1.this.qAj.getRuntime().ccM().qYY.qHO == 0) {
                  break label241;
                }
                localb.a(ba.i.app_brand_jsapi_update_app_dialog_confirm_for_debug, (DialogInterface.OnClickListener)localObject);
                localb.b(ba.i.app_brand_jsapi_update_app_dialog_cancel_for_debug, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(326291);
                    a.1.this.qAj.callback(a.1.this.elZ, a.this.ZP("fail user canceled updateApp"));
                    AppMethodBeat.o(326291);
                  }
                });
              }
              for (;;)
              {
                a.1.this.qAj.getDialogContainer().b(localb);
                AppMethodBeat.o(46826);
                return;
                i = ba.i.app_brand_jsapi_update_app_need_reboot_wording_for_normal;
                break;
                label241:
                localb.a(ba.i.app_brand_jsapi_update_app_dialog_confirm, (DialogInterface.OnClickListener)localObject);
              }
            }
          });
          AppMethodBeat.o(326286);
          return;
        }
        paramc.callback(paramInt, a.this.ZP("fail sync error"));
        AppMethodBeat.o(326286);
      }
    });
    paramc.sWe = true;
    paramc.czH();
    AppMethodBeat.o(46828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.a
 * JD-Core Version:    0.7.0.1
 */