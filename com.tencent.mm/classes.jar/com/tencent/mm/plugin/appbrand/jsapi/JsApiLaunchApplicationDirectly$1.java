package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.List;

final class JsApiLaunchApplicationDirectly$1
  implements IPCRunCgi.a
{
  JsApiLaunchApplicationDirectly$1(JsApiLaunchApplicationDirectly paramJsApiLaunchApplicationDirectly, q paramq, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Bundle paramBundle, String paramString7, String paramString8) {}
  
  public final void a(final int paramInt1, final int paramInt2, String paramString, final com.tencent.mm.ak.b paramb)
  {
    AppMethodBeat.i(45515);
    ac.i("MicroMsg.JsApiLaunchApplicationDirectly", "on RunCgi callback errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    com.tencent.mm.ci.a.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45514);
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          JsApiLaunchApplicationDirectly.1.this.bZx.h(JsApiLaunchApplicationDirectly.1.this.bZy, JsApiLaunchApplicationDirectly.1.this.jYn.e("fail:check fail", null));
          AppMethodBeat.o(45514);
          return;
        }
        final bmd localbmd = (bmd)paramb.hvs.hvw;
        ac.i("MicroMsg.JsApiLaunchApplicationDirectly", "launchApplication check result(showType:%d, errCode:%d, jumpFlog:%d)", new Object[] { Integer.valueOf(localbmd.tfk), Integer.valueOf(localbmd.dfm), Integer.valueOf(localbmd.FbA) });
        switch (localbmd.dfm)
        {
        case 1: 
        default: 
          JsApiLaunchApplicationDirectly.1.this.bZx.h(JsApiLaunchApplicationDirectly.1.this.bZy, JsApiLaunchApplicationDirectly.1.this.jYn.e("fail:check fail 1", null));
          AppMethodBeat.o(45514);
          return;
        case 2: 
          JsApiLaunchApplicationDirectly.1.this.bZx.h(JsApiLaunchApplicationDirectly.1.this.bZy, JsApiLaunchApplicationDirectly.1.this.jYn.e("fail:check fail forbidden scene 2", null));
          AppMethodBeat.o(45514);
          return;
        }
        if (localbmd.FbA == 1)
        {
          JsApiLaunchApplicationDirectly.1.this.bZx.h(JsApiLaunchApplicationDirectly.1.this.bZy, JsApiLaunchApplicationDirectly.1.this.jYn.e("fail:install app denied", null));
          AppMethodBeat.o(45514);
          return;
        }
        if (com.tencent.mm.plugin.appbrand.z.b.getPackageInfo(ai.getContext(), JsApiLaunchApplicationDirectly.1.this.cro) == null)
        {
          ac.i("MicroMsg.JsApiLaunchApplicationDirectly", "launchApplication, no weishi app, go download it");
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(186564);
              JsApiLaunchApplicationDirectly localJsApiLaunchApplicationDirectly = JsApiLaunchApplicationDirectly.1.this.jYn;
              String str1 = JsApiLaunchApplicationDirectly.1.this.jYl;
              String str2 = JsApiLaunchApplicationDirectly.1.this.jib;
              String str3 = JsApiLaunchApplicationDirectly.1.this.jYm;
              String str4 = JsApiLaunchApplicationDirectly.1.this.joo;
              String str5 = JsApiLaunchApplicationDirectly.1.this.cro;
              q localq = JsApiLaunchApplicationDirectly.1.this.bZx;
              int i = JsApiLaunchApplicationDirectly.1.this.bZy;
              com.tencent.mm.ui.base.h.a(localq.getContext(), localq.getContext().getString(2131755982), "", localq.getContext().getString(2131755364), localq.getContext().getString(2131755355), false, new JsApiLaunchApplicationDirectly.3(localJsApiLaunchApplicationDirectly, localq, str2, str1, str3, str4, str5, i), new JsApiLaunchApplicationDirectly.4(localJsApiLaunchApplicationDirectly, localq, i));
              AppMethodBeat.o(186564);
            }
          });
          AppMethodBeat.o(45514);
          return;
        }
        final JsApiLaunchApplicationDirectly.a locala = new JsApiLaunchApplicationDirectly.a(new JsApiLaunchApplicationDirectly.a.a()
        {
          public final void u(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
          {
            AppMethodBeat.i(186565);
            ac.i("MicroMsg.JsApiLaunchApplicationDirectly", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", new Object[] { Boolean.valueOf(paramAnonymous2Boolean1), Boolean.valueOf(paramAnonymous2Boolean2) });
            JsApiLaunchApplicationDirectly.a(JsApiLaunchApplicationDirectly.1.this.jYn, JsApiLaunchApplicationDirectly.1.this.bZx);
            if (paramAnonymous2Boolean1)
            {
              JsApiLaunchApplicationDirectly.1.this.bZx.h(JsApiLaunchApplicationDirectly.1.this.bZy, JsApiLaunchApplicationDirectly.1.this.jYn.e("ok", null));
              AppMethodBeat.o(186565);
              return;
            }
            JsApiLaunchApplicationDirectly.1.this.bZx.h(JsApiLaunchApplicationDirectly.1.this.bZy, JsApiLaunchApplicationDirectly.1.this.jYn.e("fail:scheme launch fail", null));
            AppMethodBeat.o(186565);
          }
        });
        if (!bs.isNullOrNil(JsApiLaunchApplicationDirectly.1.this.jXU))
        {
          final Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(JsApiLaunchApplicationDirectly.1.this.jXU));
          localIntent.addFlags(268435456);
          localObject = bs.aa(JsApiLaunchApplicationDirectly.1.this.bZx.getContext(), localIntent);
          if ((localObject != null) && (!((List)localObject).isEmpty()))
          {
            if ((TextUtils.isEmpty(localIntent.getPackage())) && (((List)localObject).size() == 1)) {}
            for (localObject = com.tencent.mm.pluginsdk.model.app.h.b((ResolveInfo)((List)localObject).get(0)); !bs.nullAsNil(ai.getPackageName()).equals(localObject); localObject = localIntent.getPackage())
            {
              ap.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(45513);
                  boolean bool = com.tencent.mm.pluginsdk.model.app.h.a(JsApiLaunchApplicationDirectly.1.this.bZx.getContext(), localIntent, null, localbmd.tfk, locala, JsApiLaunchApplicationDirectly.1.this.jXV);
                  locala.gj(bool);
                  AppMethodBeat.o(45513);
                }
              });
              AppMethodBeat.o(45514);
              return;
            }
          }
        }
        Object localObject = new JsApiLaunchApplicationDirectly.LaunchApplicationTask(com.tencent.mm.sdk.f.a.jg(JsApiLaunchApplicationDirectly.1.this.bZx.getRuntime().mContext));
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).appId = JsApiLaunchApplicationDirectly.1.this.jib;
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).jYf = JsApiLaunchApplicationDirectly.1.this.jXX;
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).extInfo = JsApiLaunchApplicationDirectly.1.this.jXY;
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).dcb = JsApiLaunchApplicationDirectly.1.this.jXV;
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).cZX = localbmd.tfk;
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).jWP = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(186566);
            ac.i("MicroMsg.JsApiLaunchApplicationDirectly", "callback task.success:%b", new Object[] { Boolean.valueOf(this.jYr.success) });
            this.jYr.bek();
            if (!this.jYr.success)
            {
              JsApiLaunchApplicationDirectly.1.this.bZx.h(JsApiLaunchApplicationDirectly.1.this.bZy, JsApiLaunchApplicationDirectly.1.this.jYn.e("fail:sdk launch fail", null));
              AppMethodBeat.o(186566);
              return;
            }
            JsApiLaunchApplicationDirectly.1.this.bZx.h(JsApiLaunchApplicationDirectly.1.this.bZy, JsApiLaunchApplicationDirectly.1.this.jYn.e("ok", null));
            AppMethodBeat.o(186566);
          }
        };
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).bej();
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).bei();
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