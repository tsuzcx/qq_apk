package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.co.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.b;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.protocal.protobuf.cmv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.List;

final class JsApiLaunchApplicationDirectly$1
  implements IPCRunCgi.a
{
  JsApiLaunchApplicationDirectly$1(JsApiLaunchApplicationDirectly paramJsApiLaunchApplicationDirectly, v paramv, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Bundle paramBundle, String paramString7, String paramString8) {}
  
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
          JsApiLaunchApplicationDirectly.1.this.cue.j(JsApiLaunchApplicationDirectly.1.this.cuf, JsApiLaunchApplicationDirectly.1.this.ovu.h("fail:check fail", null));
          AppMethodBeat.o(45514);
          return;
        }
        final cmv localcmv = (cmv)d.c.b(paramd.lBS);
        Log.i("MicroMsg.JsApiLaunchApplicationDirectly", "launchApplication check result(showType:%d, errCode:%d, jumpFlog:%d)", new Object[] { Integer.valueOf(localcmv.CKC), Integer.valueOf(localcmv.fBP), Integer.valueOf(localcmv.Tux) });
        switch (localcmv.fBP)
        {
        case 1: 
        default: 
          JsApiLaunchApplicationDirectly.1.this.cue.j(JsApiLaunchApplicationDirectly.1.this.cuf, JsApiLaunchApplicationDirectly.1.this.ovu.h("fail:check fail 1", null));
          AppMethodBeat.o(45514);
          return;
        case 2: 
          JsApiLaunchApplicationDirectly.1.this.cue.j(JsApiLaunchApplicationDirectly.1.this.cuf, JsApiLaunchApplicationDirectly.1.this.ovu.h("fail:check fail forbidden scene 2", null));
          AppMethodBeat.o(45514);
          return;
        }
        if (localcmv.Tux == 1)
        {
          JsApiLaunchApplicationDirectly.1.this.cue.j(JsApiLaunchApplicationDirectly.1.this.cuf, JsApiLaunchApplicationDirectly.1.this.ovu.h("fail:install app denied", null));
          AppMethodBeat.o(45514);
          return;
        }
        if (b.getPackageInfo(MMApplicationContext.getContext(), JsApiLaunchApplicationDirectly.1.this.ovr) == null)
        {
          Log.i("MicroMsg.JsApiLaunchApplicationDirectly", "launchApplication, no weishi app, go download it");
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(283576);
              JsApiLaunchApplicationDirectly localJsApiLaunchApplicationDirectly = JsApiLaunchApplicationDirectly.1.this.ovu;
              String str1 = JsApiLaunchApplicationDirectly.1.this.ovs;
              String str2 = JsApiLaunchApplicationDirectly.1.this.nzB;
              String str3 = JsApiLaunchApplicationDirectly.1.this.ovt;
              String str4 = JsApiLaunchApplicationDirectly.1.this.nHk;
              String str5 = JsApiLaunchApplicationDirectly.1.this.ovr;
              v localv = JsApiLaunchApplicationDirectly.1.this.cue;
              int i = JsApiLaunchApplicationDirectly.1.this.cuf;
              com.tencent.mm.ui.base.h.a(localv.getContext(), localv.getContext().getString(au.i.appbrand_install_application), "", localv.getContext().getString(au.i.app_brand_confirm), localv.getContext().getString(au.i.app_brand_cancel), false, new JsApiLaunchApplicationDirectly.3(localJsApiLaunchApplicationDirectly, localv, str2, str1, str3, str4, str5, i), new JsApiLaunchApplicationDirectly.4(localJsApiLaunchApplicationDirectly, localv, i));
              AppMethodBeat.o(283576);
            }
          });
          AppMethodBeat.o(45514);
          return;
        }
        final JsApiLaunchApplicationDirectly.a locala = new JsApiLaunchApplicationDirectly.a(new JsApiLaunchApplicationDirectly.a.a()
        {
          public final void x(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
          {
            AppMethodBeat.i(272194);
            Log.i("MicroMsg.JsApiLaunchApplicationDirectly", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", new Object[] { Boolean.valueOf(paramAnonymous2Boolean1), Boolean.valueOf(paramAnonymous2Boolean2) });
            JsApiLaunchApplicationDirectly.a(JsApiLaunchApplicationDirectly.1.this.ovu, JsApiLaunchApplicationDirectly.1.this.cue);
            if (paramAnonymous2Boolean1)
            {
              JsApiLaunchApplicationDirectly.1.this.cue.j(JsApiLaunchApplicationDirectly.1.this.cuf, JsApiLaunchApplicationDirectly.1.this.ovu.h("ok", null));
              AppMethodBeat.o(272194);
              return;
            }
            JsApiLaunchApplicationDirectly.1.this.cue.j(JsApiLaunchApplicationDirectly.1.this.cuf, JsApiLaunchApplicationDirectly.1.this.ovu.h("fail:scheme launch fail", null));
            AppMethodBeat.o(272194);
          }
        });
        if (!Util.isNullOrNil(JsApiLaunchApplicationDirectly.1.this.ova))
        {
          final Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(JsApiLaunchApplicationDirectly.1.this.ova));
          localIntent.addFlags(268435456);
          localObject = Util.queryIntentActivities(JsApiLaunchApplicationDirectly.1.this.cue.getContext(), localIntent);
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
                  boolean bool = com.tencent.mm.pluginsdk.model.app.h.a(JsApiLaunchApplicationDirectly.1.this.cue.getContext(), localIntent, null, localcmv.CKC, locala, JsApiLaunchApplicationDirectly.1.this.ovb);
                  locala.hZ(bool);
                  AppMethodBeat.o(45513);
                }
              });
              AppMethodBeat.o(45514);
              return;
            }
          }
        }
        Object localObject = new JsApiLaunchApplicationDirectly.LaunchApplicationTask(AndroidContextUtil.castActivityOrNull(JsApiLaunchApplicationDirectly.1.this.cue.getRuntime().mContext));
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).appId = JsApiLaunchApplicationDirectly.1.this.nzB;
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).ovl = JsApiLaunchApplicationDirectly.1.this.ovd;
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).extInfo = JsApiLaunchApplicationDirectly.1.this.ove;
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).fyw = JsApiLaunchApplicationDirectly.1.this.ovb;
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).fwp = localcmv.CKC;
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).otv = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(276170);
            Log.i("MicroMsg.JsApiLaunchApplicationDirectly", "callback task.success:%b", new Object[] { Boolean.valueOf(this.ovy.success) });
            this.ovy.bPk();
            if (!this.ovy.success)
            {
              JsApiLaunchApplicationDirectly.1.this.cue.j(JsApiLaunchApplicationDirectly.1.this.cuf, JsApiLaunchApplicationDirectly.1.this.ovu.h("fail:sdk launch fail", null));
              AppMethodBeat.o(276170);
              return;
            }
            JsApiLaunchApplicationDirectly.1.this.cue.j(JsApiLaunchApplicationDirectly.1.this.cuf, JsApiLaunchApplicationDirectly.1.this.ovu.h("ok", null));
            AppMethodBeat.o(276170);
          }
        };
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).bPj();
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).bPi();
        AppMethodBeat.o(45514);
      }
    });
    AppMethodBeat.o(45515);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplicationDirectly.1
 * JD-Core Version:    0.7.0.1
 */