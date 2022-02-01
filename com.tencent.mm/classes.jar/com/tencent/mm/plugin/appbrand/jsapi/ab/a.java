package com.tencent.mm.plugin.appbrand.jsapi.ab;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.ay.1;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.i;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask.a;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.widget.dialog.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;

public final class a
  extends d<c>
{
  private static final int CTRL_INDEX = 359;
  private static final String NAME = "updateApp";
  
  public final void a(final c paramc, final int paramInt)
  {
    AppMethodBeat.i(46828);
    LaunchParcel localLaunchParcel = i.e(paramc.getRuntime().bsC());
    localLaunchParcel.mYM = Util.nowMilliSecond();
    new AppBrandPreInitTask(paramc.getContext(), localLaunchParcel, new AppBrandPreInitTask.a()
    {
      public final void a(final AppBrandInitConfigWC paramAnonymousAppBrandInitConfigWC, AppBrandStatObject paramAnonymousAppBrandStatObject)
      {
        AppMethodBeat.i(227002);
        if (paramAnonymousAppBrandInitConfigWC != null)
        {
          if ((paramc.getRuntime() == null) || (paramc.getRuntime().SO) || (paramc.getRuntime().isDestroyed()))
          {
            Log.e("MicroMsg.AppBrand.JsApiUpdateApp", "onResult with newConfig(%s %d %d) but runtime destroyed", new Object[] { paramAnonymousAppBrandInitConfigWC.appId, Integer.valueOf(paramAnonymousAppBrandInitConfigWC.eix), Integer.valueOf(paramAnonymousAppBrandInitConfigWC.appVersion) });
            AppMethodBeat.o(227002);
            return;
          }
          if ((paramc.getRuntime().bsB().leE.kNW == 0) && (paramAnonymousAppBrandInitConfigWC.appVersion == paramc.getRuntime().bsB().leE.pkgVersion) && (!WeChatEnvironment.hasDebugger()))
          {
            paramc.i(paramInt, a.this.h("fail the current version is the latest version", null));
            AppMethodBeat.o(227002);
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
                  AppMethodBeat.i(227000);
                  q localq = a.1.this.lzl.getRuntime();
                  AppBrandInitConfigWC localAppBrandInitConfigWC = a.1.1.this.kFJ;
                  if ((localq == null) || (localAppBrandInitConfigWC == null))
                  {
                    Log.e("MicroMsg.AppBrand.RuntimeRestartHelper", "restart skip with Null runtime");
                    AppMethodBeat.o(227000);
                    return;
                  }
                  if (!localq.mInitialized)
                  {
                    Log.e("MicroMsg.AppBrand.RuntimeRestartHelper", "restart %s, not initialized", new Object[] { localq.mAppId });
                    AppMethodBeat.o(227000);
                    return;
                  }
                  localq.i(new ay.1(localq, localAppBrandInitConfigWC), 0L);
                  AppMethodBeat.o(227000);
                }
              };
              if ((BuildInfo.CLIENT_VERSION_INT >= 654315264) && (j.a.vP(a.1.this.lzl.getRuntime().kAq.eix)))
              {
                ((Runnable)localObject).run();
                AppMethodBeat.o(46826);
                return;
              }
              b localb = new b(a.1.this.lzl.getContext());
              localb.setCanceledOnTouchOutside(false);
              localb.setCancelable(false);
              Context localContext = a.1.this.lzl.getContext();
              int i;
              if (a.1.this.lzl.getRuntime().NA())
              {
                i = 2131755526;
                localb.setMessage(localContext.getString(i, new Object[] { a.1.this.lzl.getRuntime().bsC().brandName }));
                localObject = new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(46825);
                    this.mvs.run();
                    AppMethodBeat.o(46825);
                  }
                };
                if (a.1.this.lzl.getRuntime().bsB().leE.kNW == 0) {
                  break label229;
                }
                localb.a(2131755525, (DialogInterface.OnClickListener)localObject);
                localb.b(2131755523, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(227001);
                    a.1.this.lzl.i(a.1.this.cvP, a.this.h("fail user canceled updateApp", null));
                    AppMethodBeat.o(227001);
                  }
                });
              }
              for (;;)
              {
                a.1.this.lzl.getDialogContainer().b(localb);
                AppMethodBeat.o(46826);
                return;
                i = 2131755527;
                break;
                label229:
                localb.a(2131755524, (DialogInterface.OnClickListener)localObject);
              }
            }
          });
          AppMethodBeat.o(227002);
          return;
        }
        paramc.i(paramInt, a.this.h("fail sync error", null));
        AppMethodBeat.o(227002);
      }
    }).bNf();
    AppMethodBeat.o(46828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ab.a
 * JD-Core Version:    0.7.0.1
 */