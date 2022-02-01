package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.protocal.protobuf.bqn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.List;

final class JsApiLaunchApplicationDirectly$1
  implements IPCRunCgi.a
{
  JsApiLaunchApplicationDirectly$1(JsApiLaunchApplicationDirectly paramJsApiLaunchApplicationDirectly, q paramq, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Bundle paramBundle, String paramString7, String paramString8) {}
  
  public final void a(final int paramInt1, final int paramInt2, String paramString, final com.tencent.mm.al.b paramb)
  {
    AppMethodBeat.i(45515);
    ad.i("MicroMsg.JsApiLaunchApplicationDirectly", "on RunCgi callback errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    com.tencent.mm.ci.a.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45514);
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          JsApiLaunchApplicationDirectly.1.this.cjP.h(JsApiLaunchApplicationDirectly.1.this.cjQ, JsApiLaunchApplicationDirectly.1.this.ksJ.e("fail:check fail", null));
          AppMethodBeat.o(45514);
          return;
        }
        final bqn localbqn = (bqn)paramb.hNL.hNQ;
        ad.i("MicroMsg.JsApiLaunchApplicationDirectly", "launchApplication check result(showType:%d, errCode:%d, jumpFlog:%d)", new Object[] { Integer.valueOf(localbqn.uda), Integer.valueOf(localbqn.dqI), Integer.valueOf(localbqn.GKZ) });
        switch (localbqn.dqI)
        {
        case 1: 
        default: 
          JsApiLaunchApplicationDirectly.1.this.cjP.h(JsApiLaunchApplicationDirectly.1.this.cjQ, JsApiLaunchApplicationDirectly.1.this.ksJ.e("fail:check fail 1", null));
          AppMethodBeat.o(45514);
          return;
        case 2: 
          JsApiLaunchApplicationDirectly.1.this.cjP.h(JsApiLaunchApplicationDirectly.1.this.cjQ, JsApiLaunchApplicationDirectly.1.this.ksJ.e("fail:check fail forbidden scene 2", null));
          AppMethodBeat.o(45514);
          return;
        }
        if (localbqn.GKZ == 1)
        {
          JsApiLaunchApplicationDirectly.1.this.cjP.h(JsApiLaunchApplicationDirectly.1.this.cjQ, JsApiLaunchApplicationDirectly.1.this.ksJ.e("fail:install app denied", null));
          AppMethodBeat.o(45514);
          return;
        }
        if (com.tencent.mm.plugin.appbrand.z.b.getPackageInfo(aj.getContext(), JsApiLaunchApplicationDirectly.1.this.cCk) == null)
        {
          ad.i("MicroMsg.JsApiLaunchApplicationDirectly", "launchApplication, no weishi app, go download it");
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(188267);
              JsApiLaunchApplicationDirectly localJsApiLaunchApplicationDirectly = JsApiLaunchApplicationDirectly.1.this.ksJ;
              String str1 = JsApiLaunchApplicationDirectly.1.this.ksH;
              String str2 = JsApiLaunchApplicationDirectly.1.this.jBr;
              String str3 = JsApiLaunchApplicationDirectly.1.this.ksI;
              String str4 = JsApiLaunchApplicationDirectly.1.this.jIk;
              String str5 = JsApiLaunchApplicationDirectly.1.this.cCk;
              q localq = JsApiLaunchApplicationDirectly.1.this.cjP;
              int i = JsApiLaunchApplicationDirectly.1.this.cjQ;
              com.tencent.mm.ui.base.h.a(localq.getContext(), localq.getContext().getString(2131755982), "", localq.getContext().getString(2131755364), localq.getContext().getString(2131755355), false, new JsApiLaunchApplicationDirectly.3(localJsApiLaunchApplicationDirectly, localq, str2, str1, str3, str4, str5, i), new JsApiLaunchApplicationDirectly.4(localJsApiLaunchApplicationDirectly, localq, i));
              AppMethodBeat.o(188267);
            }
          });
          AppMethodBeat.o(45514);
          return;
        }
        final JsApiLaunchApplicationDirectly.a locala = new JsApiLaunchApplicationDirectly.a(new JsApiLaunchApplicationDirectly.a.a()
        {
          public final void u(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
          {
            AppMethodBeat.i(188268);
            ad.i("MicroMsg.JsApiLaunchApplicationDirectly", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", new Object[] { Boolean.valueOf(paramAnonymous2Boolean1), Boolean.valueOf(paramAnonymous2Boolean2) });
            JsApiLaunchApplicationDirectly.a(JsApiLaunchApplicationDirectly.1.this.ksJ, JsApiLaunchApplicationDirectly.1.this.cjP);
            if (paramAnonymous2Boolean1)
            {
              JsApiLaunchApplicationDirectly.1.this.cjP.h(JsApiLaunchApplicationDirectly.1.this.cjQ, JsApiLaunchApplicationDirectly.1.this.ksJ.e("ok", null));
              AppMethodBeat.o(188268);
              return;
            }
            JsApiLaunchApplicationDirectly.1.this.cjP.h(JsApiLaunchApplicationDirectly.1.this.cjQ, JsApiLaunchApplicationDirectly.1.this.ksJ.e("fail:scheme launch fail", null));
            AppMethodBeat.o(188268);
          }
        });
        if (!bt.isNullOrNil(JsApiLaunchApplicationDirectly.1.this.ksq))
        {
          final Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(JsApiLaunchApplicationDirectly.1.this.ksq));
          localIntent.addFlags(268435456);
          localObject = bt.ac(JsApiLaunchApplicationDirectly.1.this.cjP.getContext(), localIntent);
          if ((localObject != null) && (!((List)localObject).isEmpty()))
          {
            if ((TextUtils.isEmpty(localIntent.getPackage())) && (((List)localObject).size() == 1)) {}
            for (localObject = com.tencent.mm.pluginsdk.model.app.h.b((ResolveInfo)((List)localObject).get(0)); !bt.nullAsNil(aj.getPackageName()).equals(localObject); localObject = localIntent.getPackage())
            {
              aq.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(45513);
                  boolean bool = com.tencent.mm.pluginsdk.model.app.h.a(JsApiLaunchApplicationDirectly.1.this.cjP.getContext(), localIntent, null, localbqn.uda, locala, JsApiLaunchApplicationDirectly.1.this.ksr);
                  locala.go(bool);
                  AppMethodBeat.o(45513);
                }
              });
              AppMethodBeat.o(45514);
              return;
            }
          }
        }
        Object localObject = new JsApiLaunchApplicationDirectly.LaunchApplicationTask(com.tencent.mm.sdk.f.a.jq(JsApiLaunchApplicationDirectly.1.this.cjP.getRuntime().mContext));
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).appId = JsApiLaunchApplicationDirectly.1.this.jBr;
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).ksB = JsApiLaunchApplicationDirectly.1.this.kst;
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).extInfo = JsApiLaunchApplicationDirectly.1.this.ksu;
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).dnx = JsApiLaunchApplicationDirectly.1.this.ksr;
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).dlp = localbqn.uda;
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).krg = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(188269);
            ad.i("MicroMsg.JsApiLaunchApplicationDirectly", "callback task.success:%b", new Object[] { Boolean.valueOf(this.ksN.success) });
            this.ksN.bhO();
            if (!this.ksN.success)
            {
              JsApiLaunchApplicationDirectly.1.this.cjP.h(JsApiLaunchApplicationDirectly.1.this.cjQ, JsApiLaunchApplicationDirectly.1.this.ksJ.e("fail:sdk launch fail", null));
              AppMethodBeat.o(188269);
              return;
            }
            JsApiLaunchApplicationDirectly.1.this.cjP.h(JsApiLaunchApplicationDirectly.1.this.cjQ, JsApiLaunchApplicationDirectly.1.this.ksJ.e("ok", null));
            AppMethodBeat.o(188269);
          }
        };
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).bhN();
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).bhM();
        AppMethodBeat.o(45514);
      }
    });
    AppMethodBeat.o(45515);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplicationDirectly.1
 * JD-Core Version:    0.7.0.1
 */