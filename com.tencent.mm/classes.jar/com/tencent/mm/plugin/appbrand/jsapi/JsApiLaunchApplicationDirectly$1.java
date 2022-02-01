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
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.protocal.protobuf.brh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.List;

final class JsApiLaunchApplicationDirectly$1
  implements IPCRunCgi.a
{
  JsApiLaunchApplicationDirectly$1(JsApiLaunchApplicationDirectly paramJsApiLaunchApplicationDirectly, r paramr, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Bundle paramBundle, String paramString7, String paramString8) {}
  
  public final void a(final int paramInt1, final int paramInt2, String paramString, final com.tencent.mm.ak.b paramb)
  {
    AppMethodBeat.i(45515);
    ae.i("MicroMsg.JsApiLaunchApplicationDirectly", "on RunCgi callback errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    com.tencent.mm.ch.a.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45514);
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          JsApiLaunchApplicationDirectly.1.this.cjR.h(JsApiLaunchApplicationDirectly.1.this.cjS, JsApiLaunchApplicationDirectly.1.this.kvZ.e("fail:check fail", null));
          AppMethodBeat.o(45514);
          return;
        }
        final brh localbrh = (brh)paramb.hQE.hQJ;
        ae.i("MicroMsg.JsApiLaunchApplicationDirectly", "launchApplication check result(showType:%d, errCode:%d, jumpFlog:%d)", new Object[] { Integer.valueOf(localbrh.uoi), Integer.valueOf(localbrh.drN), Integer.valueOf(localbrh.HeA) });
        switch (localbrh.drN)
        {
        case 1: 
        default: 
          JsApiLaunchApplicationDirectly.1.this.cjR.h(JsApiLaunchApplicationDirectly.1.this.cjS, JsApiLaunchApplicationDirectly.1.this.kvZ.e("fail:check fail 1", null));
          AppMethodBeat.o(45514);
          return;
        case 2: 
          JsApiLaunchApplicationDirectly.1.this.cjR.h(JsApiLaunchApplicationDirectly.1.this.cjS, JsApiLaunchApplicationDirectly.1.this.kvZ.e("fail:check fail forbidden scene 2", null));
          AppMethodBeat.o(45514);
          return;
        }
        if (localbrh.HeA == 1)
        {
          JsApiLaunchApplicationDirectly.1.this.cjR.h(JsApiLaunchApplicationDirectly.1.this.cjS, JsApiLaunchApplicationDirectly.1.this.kvZ.e("fail:install app denied", null));
          AppMethodBeat.o(45514);
          return;
        }
        if (com.tencent.mm.plugin.appbrand.y.b.getPackageInfo(ak.getContext(), JsApiLaunchApplicationDirectly.1.this.cCR) == null)
        {
          ae.i("MicroMsg.JsApiLaunchApplicationDirectly", "launchApplication, no weishi app, go download it");
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(222393);
              JsApiLaunchApplicationDirectly localJsApiLaunchApplicationDirectly = JsApiLaunchApplicationDirectly.1.this.kvZ;
              String str1 = JsApiLaunchApplicationDirectly.1.this.kvX;
              String str2 = JsApiLaunchApplicationDirectly.1.this.jEl;
              String str3 = JsApiLaunchApplicationDirectly.1.this.kvY;
              String str4 = JsApiLaunchApplicationDirectly.1.this.jLl;
              String str5 = JsApiLaunchApplicationDirectly.1.this.cCR;
              r localr = JsApiLaunchApplicationDirectly.1.this.cjR;
              int i = JsApiLaunchApplicationDirectly.1.this.cjS;
              com.tencent.mm.ui.base.h.a(localr.getContext(), localr.getContext().getString(2131755982), "", localr.getContext().getString(2131755364), localr.getContext().getString(2131755355), false, new JsApiLaunchApplicationDirectly.3(localJsApiLaunchApplicationDirectly, localr, str2, str1, str3, str4, str5, i), new JsApiLaunchApplicationDirectly.4(localJsApiLaunchApplicationDirectly, localr, i));
              AppMethodBeat.o(222393);
            }
          });
          AppMethodBeat.o(45514);
          return;
        }
        final JsApiLaunchApplicationDirectly.a locala = new JsApiLaunchApplicationDirectly.a(new JsApiLaunchApplicationDirectly.a.a()
        {
          public final void u(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
          {
            AppMethodBeat.i(222394);
            ae.i("MicroMsg.JsApiLaunchApplicationDirectly", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", new Object[] { Boolean.valueOf(paramAnonymous2Boolean1), Boolean.valueOf(paramAnonymous2Boolean2) });
            JsApiLaunchApplicationDirectly.a(JsApiLaunchApplicationDirectly.1.this.kvZ, JsApiLaunchApplicationDirectly.1.this.cjR);
            if (paramAnonymous2Boolean1)
            {
              JsApiLaunchApplicationDirectly.1.this.cjR.h(JsApiLaunchApplicationDirectly.1.this.cjS, JsApiLaunchApplicationDirectly.1.this.kvZ.e("ok", null));
              AppMethodBeat.o(222394);
              return;
            }
            JsApiLaunchApplicationDirectly.1.this.cjR.h(JsApiLaunchApplicationDirectly.1.this.cjS, JsApiLaunchApplicationDirectly.1.this.kvZ.e("fail:scheme launch fail", null));
            AppMethodBeat.o(222394);
          }
        });
        if (!bu.isNullOrNil(JsApiLaunchApplicationDirectly.1.this.kvG))
        {
          final Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(JsApiLaunchApplicationDirectly.1.this.kvG));
          localIntent.addFlags(268435456);
          localObject = bu.ac(JsApiLaunchApplicationDirectly.1.this.cjR.getContext(), localIntent);
          if ((localObject != null) && (!((List)localObject).isEmpty()))
          {
            if ((TextUtils.isEmpty(localIntent.getPackage())) && (((List)localObject).size() == 1)) {}
            for (localObject = com.tencent.mm.pluginsdk.model.app.h.b((ResolveInfo)((List)localObject).get(0)); !bu.nullAsNil(ak.getPackageName()).equals(localObject); localObject = localIntent.getPackage())
            {
              ar.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(45513);
                  boolean bool = com.tencent.mm.pluginsdk.model.app.h.a(JsApiLaunchApplicationDirectly.1.this.cjR.getContext(), localIntent, null, localbrh.uoi, locala, JsApiLaunchApplicationDirectly.1.this.kvH);
                  locala.gm(bool);
                  AppMethodBeat.o(45513);
                }
              });
              AppMethodBeat.o(45514);
              return;
            }
          }
        }
        Object localObject = new JsApiLaunchApplicationDirectly.LaunchApplicationTask(com.tencent.mm.sdk.f.a.jw(JsApiLaunchApplicationDirectly.1.this.cjR.getRuntime().mContext));
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).appId = JsApiLaunchApplicationDirectly.1.this.jEl;
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).kvR = JsApiLaunchApplicationDirectly.1.this.kvJ;
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).extInfo = JsApiLaunchApplicationDirectly.1.this.kvK;
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).doz = JsApiLaunchApplicationDirectly.1.this.kvH;
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).dmr = localbrh.uoi;
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).kuv = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(222395);
            ae.i("MicroMsg.JsApiLaunchApplicationDirectly", "callback task.success:%b", new Object[] { Boolean.valueOf(this.kwd.success) });
            this.kwd.bix();
            if (!this.kwd.success)
            {
              JsApiLaunchApplicationDirectly.1.this.cjR.h(JsApiLaunchApplicationDirectly.1.this.cjS, JsApiLaunchApplicationDirectly.1.this.kvZ.e("fail:sdk launch fail", null));
              AppMethodBeat.o(222395);
              return;
            }
            JsApiLaunchApplicationDirectly.1.this.cjR.h(JsApiLaunchApplicationDirectly.1.this.cjS, JsApiLaunchApplicationDirectly.1.this.kvZ.e("ok", null));
            AppMethodBeat.o(222395);
          }
        };
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).biw();
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).biv();
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