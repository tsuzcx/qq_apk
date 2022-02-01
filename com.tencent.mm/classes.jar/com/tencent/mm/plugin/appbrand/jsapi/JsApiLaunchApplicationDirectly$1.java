package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.ci.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.af.b;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.protocal.protobuf.ddj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.base.k;
import java.util.List;

final class JsApiLaunchApplicationDirectly$1
  implements IPCRunCgi.a
{
  JsApiLaunchApplicationDirectly$1(JsApiLaunchApplicationDirectly paramJsApiLaunchApplicationDirectly, y paramy, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Bundle paramBundle, String paramString7, String paramString8) {}
  
  public final void callback(final int paramInt1, final int paramInt2, String paramString, final c paramc)
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
          JsApiLaunchApplicationDirectly.1.this.elY.callback(JsApiLaunchApplicationDirectly.1.this.elZ, JsApiLaunchApplicationDirectly.1.this.ryO.ZP("fail:check fail"));
          AppMethodBeat.o(45514);
          return;
        }
        final ddj localddj = (ddj)c.c.b(paramc.otC);
        Log.i("MicroMsg.JsApiLaunchApplicationDirectly", "launchApplication check result(showType:%d, errCode:%d, jumpFlog:%d)", new Object[] { Integer.valueOf(localddj.show_type), Integer.valueOf(localddj.hGE), Integer.valueOf(localddj.aaJb) });
        switch (localddj.hGE)
        {
        case 1: 
        default: 
          JsApiLaunchApplicationDirectly.1.this.elY.callback(JsApiLaunchApplicationDirectly.1.this.elZ, JsApiLaunchApplicationDirectly.1.this.ryO.ZP("fail:check fail 1"));
          AppMethodBeat.o(45514);
          return;
        case 2: 
          JsApiLaunchApplicationDirectly.1.this.elY.callback(JsApiLaunchApplicationDirectly.1.this.elZ, JsApiLaunchApplicationDirectly.1.this.ryO.ZP("fail:check fail forbidden scene 2"));
          AppMethodBeat.o(45514);
          return;
        }
        if (localddj.aaJb == 1)
        {
          JsApiLaunchApplicationDirectly.1.this.elY.callback(JsApiLaunchApplicationDirectly.1.this.elZ, JsApiLaunchApplicationDirectly.1.this.ryO.ZP("fail:install app denied"));
          AppMethodBeat.o(45514);
          return;
        }
        if (b.getPackageInfo(MMApplicationContext.getContext(), JsApiLaunchApplicationDirectly.1.this.ryL) == null)
        {
          Log.i("MicroMsg.JsApiLaunchApplicationDirectly", "launchApplication, no weishi app, go download it");
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(325499);
              JsApiLaunchApplicationDirectly localJsApiLaunchApplicationDirectly = JsApiLaunchApplicationDirectly.1.this.ryO;
              String str1 = JsApiLaunchApplicationDirectly.1.this.ryM;
              String str2 = JsApiLaunchApplicationDirectly.1.this.qyB;
              String str3 = JsApiLaunchApplicationDirectly.1.this.ryN;
              String str4 = JsApiLaunchApplicationDirectly.1.this.qGX;
              String str5 = JsApiLaunchApplicationDirectly.1.this.ryL;
              y localy = JsApiLaunchApplicationDirectly.1.this.elY;
              int i = JsApiLaunchApplicationDirectly.1.this.elZ;
              k.a(localy.getContext(), localy.getContext().getString(ba.i.appbrand_install_application), "", localy.getContext().getString(ba.i.app_brand_confirm), localy.getContext().getString(ba.i.app_brand_cancel), false, new JsApiLaunchApplicationDirectly.3(localJsApiLaunchApplicationDirectly, localy, str2, str1, str3, str4, str5, i), new JsApiLaunchApplicationDirectly.4(localJsApiLaunchApplicationDirectly, localy, i));
              AppMethodBeat.o(325499);
            }
          });
          AppMethodBeat.o(45514);
          return;
        }
        final JsApiLaunchApplicationDirectly.a locala = new JsApiLaunchApplicationDirectly.a(new JsApiLaunchApplicationDirectly.a.a()
        {
          public final void C(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
          {
            AppMethodBeat.i(325506);
            Log.i("MicroMsg.JsApiLaunchApplicationDirectly", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", new Object[] { Boolean.valueOf(paramAnonymous2Boolean1), Boolean.valueOf(paramAnonymous2Boolean2) });
            JsApiLaunchApplicationDirectly.a(JsApiLaunchApplicationDirectly.1.this.ryO, JsApiLaunchApplicationDirectly.1.this.elY);
            if (paramAnonymous2Boolean1)
            {
              JsApiLaunchApplicationDirectly.1.this.elY.callback(JsApiLaunchApplicationDirectly.1.this.elZ, JsApiLaunchApplicationDirectly.1.this.ryO.ZP("ok"));
              AppMethodBeat.o(325506);
              return;
            }
            JsApiLaunchApplicationDirectly.1.this.elY.callback(JsApiLaunchApplicationDirectly.1.this.elZ, JsApiLaunchApplicationDirectly.1.this.ryO.ZP("fail:scheme launch fail"));
            AppMethodBeat.o(325506);
          }
        });
        if (!Util.isNullOrNil(JsApiLaunchApplicationDirectly.1.this.ryu))
        {
          final Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(JsApiLaunchApplicationDirectly.1.this.ryu));
          localIntent.addFlags(268435456);
          localObject = Util.queryIntentActivities(JsApiLaunchApplicationDirectly.1.this.elY.getContext(), localIntent);
          if ((localObject != null) && (!((List)localObject).isEmpty()))
          {
            if ((TextUtils.isEmpty(localIntent.getPackage())) && (((List)localObject).size() == 1)) {}
            for (localObject = h.b((ResolveInfo)((List)localObject).get(0)); !Util.nullAsNil(MMApplicationContext.getPackageName()).equals(localObject); localObject = localIntent.getPackage())
            {
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(45513);
                  boolean bool = h.a(JsApiLaunchApplicationDirectly.1.this.elY.getContext(), localIntent, null, localddj.show_type, locala, JsApiLaunchApplicationDirectly.1.this.ryv);
                  locala.iY(bool);
                  AppMethodBeat.o(45513);
                }
              });
              AppMethodBeat.o(45514);
              return;
            }
          }
        }
        Object localObject = new JsApiLaunchApplicationDirectly.LaunchApplicationTask(AndroidContextUtil.castActivityOrNull(JsApiLaunchApplicationDirectly.1.this.elY.getRuntime().mContext));
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).appId = JsApiLaunchApplicationDirectly.1.this.qyB;
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).ryF = JsApiLaunchApplicationDirectly.1.this.ryx;
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).extInfo = JsApiLaunchApplicationDirectly.1.this.ryy;
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).hDf = JsApiLaunchApplicationDirectly.1.this.ryv;
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).hAN = localddj.show_type;
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).rxj = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(325540);
            Log.i("MicroMsg.JsApiLaunchApplicationDirectly", "callback task.success:%b", new Object[] { Boolean.valueOf(this.ryS.success) });
            this.ryS.cpx();
            if (!this.ryS.success)
            {
              JsApiLaunchApplicationDirectly.1.this.elY.callback(JsApiLaunchApplicationDirectly.1.this.elZ, JsApiLaunchApplicationDirectly.1.this.ryO.ZP("fail:sdk launch fail"));
              AppMethodBeat.o(325540);
              return;
            }
            JsApiLaunchApplicationDirectly.1.this.elY.callback(JsApiLaunchApplicationDirectly.1.this.elZ, JsApiLaunchApplicationDirectly.1.this.ryO.ZP("ok"));
            AppMethodBeat.o(325540);
          }
        };
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).cpw();
        ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject).cpv();
        AppMethodBeat.o(45514);
      }
    });
    AppMethodBeat.o(45515);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplicationDirectly.1
 * JD-Core Version:    0.7.0.1
 */