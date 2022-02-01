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
import com.tencent.mm.protocal.protobuf.bil;
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
    com.tencent.mm.cj.a.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45514);
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          JsApiLaunchApplicationDirectly.1.this.ccA.h(JsApiLaunchApplicationDirectly.1.this.ccB, JsApiLaunchApplicationDirectly.1.this.jxS.e("fail:check fail", null));
          AppMethodBeat.o(45514);
          return;
        }
        final bil localbil = (bil)paramb.gUT.gUX;
        ad.i("MicroMsg.JsApiLaunchApplicationDirectly", "launchApplication check result(showType:%d, errCode:%d, jumpFlog:%d)", new Object[] { Integer.valueOf(localbil.rXs), Integer.valueOf(localbil.dhR), Integer.valueOf(localbil.DGg) });
        switch (localbil.dhR)
        {
        case 1: 
        default: 
          JsApiLaunchApplicationDirectly.1.this.ccA.h(JsApiLaunchApplicationDirectly.1.this.ccB, JsApiLaunchApplicationDirectly.1.this.jxS.e("fail:check fail 1", null));
          AppMethodBeat.o(45514);
          return;
        case 2: 
          JsApiLaunchApplicationDirectly.1.this.ccA.h(JsApiLaunchApplicationDirectly.1.this.ccB, JsApiLaunchApplicationDirectly.1.this.jxS.e("fail:check fail forbidden scene 2", null));
          AppMethodBeat.o(45514);
          return;
        }
        if (localbil.DGg == 1)
        {
          JsApiLaunchApplicationDirectly.1.this.ccA.h(JsApiLaunchApplicationDirectly.1.this.ccB, JsApiLaunchApplicationDirectly.1.this.jxS.e("fail:install app denied", null));
          AppMethodBeat.o(45514);
          return;
        }
        if (com.tencent.mm.plugin.appbrand.aa.b.getPackageInfo(aj.getContext(), JsApiLaunchApplicationDirectly.1.this.cug) == null)
        {
          ad.i("MicroMsg.JsApiLaunchApplicationDirectly", "launchApplication, no weishi app, go download it");
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(195801);
              JsApiLaunchApplicationDirectly localJsApiLaunchApplicationDirectly = JsApiLaunchApplicationDirectly.1.this.jxS;
              String str1 = JsApiLaunchApplicationDirectly.1.this.jxP;
              String str2 = JsApiLaunchApplicationDirectly.1.this.iHZ;
              String str3 = JsApiLaunchApplicationDirectly.1.this.jxQ;
              String str4 = JsApiLaunchApplicationDirectly.1.this.jxR;
              String str5 = JsApiLaunchApplicationDirectly.1.this.cug;
              q localq = JsApiLaunchApplicationDirectly.1.this.ccA;
              int i = JsApiLaunchApplicationDirectly.1.this.ccB;
              com.tencent.mm.ui.base.h.a(localq.getContext(), localq.getContext().getString(2131755982), "", localq.getContext().getString(2131755364), localq.getContext().getString(2131755355), false, new JsApiLaunchApplicationDirectly.3(localJsApiLaunchApplicationDirectly, localq, str2, str1, str3, str4, str5, i), new JsApiLaunchApplicationDirectly.4(localJsApiLaunchApplicationDirectly, localq, i));
              AppMethodBeat.o(195801);
            }
          });
          AppMethodBeat.o(45514);
          return;
        }
        final JsApiLaunchApplicationDirectly.a locala = new JsApiLaunchApplicationDirectly.a(new JsApiLaunchApplicationDirectly.a.a()
        {
          public final void t(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
          {
            AppMethodBeat.i(195802);
            ad.i("MicroMsg.JsApiLaunchApplicationDirectly", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", new Object[] { Boolean.valueOf(paramAnonymous2Boolean1), Boolean.valueOf(paramAnonymous2Boolean2) });
            JsApiLaunchApplicationDirectly.a(JsApiLaunchApplicationDirectly.1.this.jxS, JsApiLaunchApplicationDirectly.1.this.ccA);
            if (paramAnonymous2Boolean1)
            {
              JsApiLaunchApplicationDirectly.1.this.ccA.h(JsApiLaunchApplicationDirectly.1.this.ccB, JsApiLaunchApplicationDirectly.1.this.jxS.e("ok", null));
              AppMethodBeat.o(195802);
              return;
            }
            JsApiLaunchApplicationDirectly.1.this.ccA.h(JsApiLaunchApplicationDirectly.1.this.ccB, JsApiLaunchApplicationDirectly.1.this.jxS.e("fail:scheme launch fail", null));
            AppMethodBeat.o(195802);
          }
        });
        if (!bt.isNullOrNil(JsApiLaunchApplicationDirectly.1.this.jxy))
        {
          final Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(JsApiLaunchApplicationDirectly.1.this.jxy));
          localIntent.addFlags(268435456);
          localObject = bt.M(JsApiLaunchApplicationDirectly.1.this.ccA.getContext(), localIntent);
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
                  boolean bool = com.tencent.mm.pluginsdk.model.app.h.a(JsApiLaunchApplicationDirectly.1.this.ccA.getContext(), localIntent, null, localbil.rXs, locala, JsApiLaunchApplicationDirectly.1.this.jxz);
                  locala.fN(bool);
                  AppMethodBeat.o(45513);
                }
              });
              AppMethodBeat.o(45514);
              return;
            }
          }
        }
        Object localObject = new JsApiLaunchApplicationDirectly.LaunchApplicationTask(com.tencent.mm.sdk.f.a.iV(JsApiLaunchApplicationDirectly.1.this.ccA.getRuntime().mContext));
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).appId = JsApiLaunchApplicationDirectly.1.this.iHZ;
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).jxJ = JsApiLaunchApplicationDirectly.1.this.jxB;
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).extInfo = JsApiLaunchApplicationDirectly.1.this.jxC;
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).deG = JsApiLaunchApplicationDirectly.1.this.jxz;
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).dcz = localbil.rXs;
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).jwt = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(195803);
            ad.i("MicroMsg.JsApiLaunchApplicationDirectly", "callback task.success:%b", new Object[] { Boolean.valueOf(this.jxW.success) });
            this.jxW.aXn();
            if (!this.jxW.success)
            {
              JsApiLaunchApplicationDirectly.1.this.ccA.h(JsApiLaunchApplicationDirectly.1.this.ccB, JsApiLaunchApplicationDirectly.1.this.jxS.e("fail:sdk launch fail", null));
              AppMethodBeat.o(195803);
              return;
            }
            JsApiLaunchApplicationDirectly.1.this.ccA.h(JsApiLaunchApplicationDirectly.1.this.ccB, JsApiLaunchApplicationDirectly.1.this.jxS.e("ok", null));
            AppMethodBeat.o(195803);
          }
        };
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).aXm();
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).aXl();
        AppMethodBeat.o(45514);
      }
    });
    AppMethodBeat.o(45515);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplicationDirectly.1
 * JD-Core Version:    0.7.0.1
 */