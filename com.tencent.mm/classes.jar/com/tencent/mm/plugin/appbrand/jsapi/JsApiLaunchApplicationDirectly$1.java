package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ch.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.b;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.protocal.protobuf.ceb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.List;

final class JsApiLaunchApplicationDirectly$1
  implements IPCRunCgi.a
{
  JsApiLaunchApplicationDirectly$1(JsApiLaunchApplicationDirectly paramJsApiLaunchApplicationDirectly, s params, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Bundle paramBundle, String paramString7, String paramString8) {}
  
  public final void a(final int paramInt1, final int paramInt2, String paramString, final d paramd)
  {
    AppMethodBeat.i(45515);
    Log.i("MicroMsg.JsApiLaunchApplicationDirectly", "on RunCgi callback errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    a.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45514);
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          JsApiLaunchApplicationDirectly.1.this.cvO.i(JsApiLaunchApplicationDirectly.1.this.cvP, JsApiLaunchApplicationDirectly.1.this.lAd.h("fail:check fail", null));
          AppMethodBeat.o(45514);
          return;
        }
        final ceb localceb = (ceb)paramd.iLL.iLR;
        Log.i("MicroMsg.JsApiLaunchApplicationDirectly", "launchApplication check result(showType:%d, errCode:%d, jumpFlog:%d)", new Object[] { Integer.valueOf(localceb.xGz), Integer.valueOf(localceb.dIZ), Integer.valueOf(localceb.MjI) });
        switch (localceb.dIZ)
        {
        case 1: 
        default: 
          JsApiLaunchApplicationDirectly.1.this.cvO.i(JsApiLaunchApplicationDirectly.1.this.cvP, JsApiLaunchApplicationDirectly.1.this.lAd.h("fail:check fail 1", null));
          AppMethodBeat.o(45514);
          return;
        case 2: 
          JsApiLaunchApplicationDirectly.1.this.cvO.i(JsApiLaunchApplicationDirectly.1.this.cvP, JsApiLaunchApplicationDirectly.1.this.lAd.h("fail:check fail forbidden scene 2", null));
          AppMethodBeat.o(45514);
          return;
        }
        if (localceb.MjI == 1)
        {
          JsApiLaunchApplicationDirectly.1.this.cvO.i(JsApiLaunchApplicationDirectly.1.this.cvP, JsApiLaunchApplicationDirectly.1.this.lAd.h("fail:install app denied", null));
          AppMethodBeat.o(45514);
          return;
        }
        if (b.getPackageInfo(MMApplicationContext.getContext(), JsApiLaunchApplicationDirectly.1.this.cQM) == null)
        {
          Log.i("MicroMsg.JsApiLaunchApplicationDirectly", "launchApplication, no weishi app, go download it");
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(226671);
              JsApiLaunchApplicationDirectly localJsApiLaunchApplicationDirectly = JsApiLaunchApplicationDirectly.1.this.lAd;
              String str1 = JsApiLaunchApplicationDirectly.1.this.lAb;
              String str2 = JsApiLaunchApplicationDirectly.1.this.kFU;
              String str3 = JsApiLaunchApplicationDirectly.1.this.lAc;
              String str4 = JsApiLaunchApplicationDirectly.1.this.kNk;
              String str5 = JsApiLaunchApplicationDirectly.1.this.cQM;
              s locals = JsApiLaunchApplicationDirectly.1.this.cvO;
              int i = JsApiLaunchApplicationDirectly.1.this.cvP;
              com.tencent.mm.ui.base.h.a(locals.getContext(), locals.getContext().getString(2131756092), "", locals.getContext().getString(2131755401), locals.getContext().getString(2131755392), false, new JsApiLaunchApplicationDirectly.3(localJsApiLaunchApplicationDirectly, locals, str2, str1, str3, str4, str5, i), new JsApiLaunchApplicationDirectly.4(localJsApiLaunchApplicationDirectly, locals, i));
              AppMethodBeat.o(226671);
            }
          });
          AppMethodBeat.o(45514);
          return;
        }
        final JsApiLaunchApplicationDirectly.a locala = new JsApiLaunchApplicationDirectly.a(new JsApiLaunchApplicationDirectly.a.a()
        {
          public final void u(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
          {
            AppMethodBeat.i(226672);
            Log.i("MicroMsg.JsApiLaunchApplicationDirectly", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", new Object[] { Boolean.valueOf(paramAnonymous2Boolean1), Boolean.valueOf(paramAnonymous2Boolean2) });
            JsApiLaunchApplicationDirectly.a(JsApiLaunchApplicationDirectly.1.this.lAd, JsApiLaunchApplicationDirectly.1.this.cvO);
            if (paramAnonymous2Boolean1)
            {
              JsApiLaunchApplicationDirectly.1.this.cvO.i(JsApiLaunchApplicationDirectly.1.this.cvP, JsApiLaunchApplicationDirectly.1.this.lAd.h("ok", null));
              AppMethodBeat.o(226672);
              return;
            }
            JsApiLaunchApplicationDirectly.1.this.cvO.i(JsApiLaunchApplicationDirectly.1.this.cvP, JsApiLaunchApplicationDirectly.1.this.lAd.h("fail:scheme launch fail", null));
            AppMethodBeat.o(226672);
          }
        });
        if (!Util.isNullOrNil(JsApiLaunchApplicationDirectly.1.this.lzK))
        {
          final Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(JsApiLaunchApplicationDirectly.1.this.lzK));
          localIntent.addFlags(268435456);
          localObject = Util.queryIntentActivities(JsApiLaunchApplicationDirectly.1.this.cvO.getContext(), localIntent);
          if ((localObject != null) && (!((List)localObject).isEmpty()))
          {
            if ((TextUtils.isEmpty(localIntent.getPackage())) && (((List)localObject).size() == 1)) {}
            for (localObject = com.tencent.mm.pluginsdk.model.app.h.b((ResolveInfo)((List)localObject).get(0)); !Util.nullAsNil(MMApplicationContext.getPackageName()).equals(localObject); localObject = localIntent.getPackage())
            {
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(45513);
                  boolean bool = com.tencent.mm.pluginsdk.model.app.h.a(JsApiLaunchApplicationDirectly.1.this.cvO.getContext(), localIntent, null, localceb.xGz, locala, JsApiLaunchApplicationDirectly.1.this.lzL);
                  locala.hj(bool);
                  AppMethodBeat.o(45513);
                }
              });
              AppMethodBeat.o(45514);
              return;
            }
          }
        }
        Object localObject = new JsApiLaunchApplicationDirectly.LaunchApplicationTask(AndroidContextUtil.castActivityOrNull(JsApiLaunchApplicationDirectly.1.this.cvO.getRuntime().mContext));
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).appId = JsApiLaunchApplicationDirectly.1.this.kFU;
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).lzV = JsApiLaunchApplicationDirectly.1.this.lzN;
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).extInfo = JsApiLaunchApplicationDirectly.1.this.lzO;
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).dFP = JsApiLaunchApplicationDirectly.1.this.lzL;
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).dDG = localceb.xGz;
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).lyv = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(226673);
            Log.i("MicroMsg.JsApiLaunchApplicationDirectly", "callback task.success:%b", new Object[] { Boolean.valueOf(this.lAh.success) });
            this.lAh.bDK();
            if (!this.lAh.success)
            {
              JsApiLaunchApplicationDirectly.1.this.cvO.i(JsApiLaunchApplicationDirectly.1.this.cvP, JsApiLaunchApplicationDirectly.1.this.lAd.h("fail:sdk launch fail", null));
              AppMethodBeat.o(226673);
              return;
            }
            JsApiLaunchApplicationDirectly.1.this.cvO.i(JsApiLaunchApplicationDirectly.1.this.cvP, JsApiLaunchApplicationDirectly.1.this.lAd.h("ok", null));
            AppMethodBeat.o(226673);
          }
        };
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).bDJ();
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).bDI();
        AppMethodBeat.o(45514);
      }
    });
    AppMethodBeat.o(45515);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplicationDirectly.1
 * JD-Core Version:    0.7.0.1
 */