package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.b.g;
import com.tencent.mm.ci.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.protocal.protobuf.ddj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.List;

final class JsApiLaunchApplicationForNative$1
  implements IPCRunCgi.a
{
  JsApiLaunchApplicationForNative$1(JsApiLaunchApplicationForNative paramJsApiLaunchApplicationForNative, y paramy, int paramInt, String paramString1, Bundle paramBundle, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {}
  
  public final void callback(final int paramInt1, final int paramInt2, String paramString, final c paramc)
  {
    AppMethodBeat.i(45838);
    Log.i("MicroMsg.JsApiLaunchApplicationForNative", "on RunCgi callback errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    a.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45837);
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          JsApiLaunchApplicationForNative.1.this.elY.callback(JsApiLaunchApplicationForNative.1.this.elZ, JsApiLaunchApplicationForNative.1.this.rCH.ZP("fail:check fail"));
          AppMethodBeat.o(45837);
          return;
        }
        final ddj localddj = (ddj)c.c.b(paramc.otC);
        switch (localddj.hGE)
        {
        case 1: 
        default: 
          JsApiLaunchApplicationForNative.1.this.elY.callback(JsApiLaunchApplicationForNative.1.this.elZ, JsApiLaunchApplicationForNative.1.this.rCH.ZP("fail:check fail 1"));
          AppMethodBeat.o(45837);
          return;
        case 2: 
          JsApiLaunchApplicationForNative.1.this.elY.callback(JsApiLaunchApplicationForNative.1.this.elZ, JsApiLaunchApplicationForNative.1.this.rCH.ZP("fail:check fail forbidden scene 2"));
          AppMethodBeat.o(45837);
          return;
        }
        final JsApiLaunchApplicationForNative.a locala = new JsApiLaunchApplicationForNative.a(new JsApiLaunchApplicationForNative.a.a()
        {
          public final void C(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
          {
            AppMethodBeat.i(45834);
            Log.i("MicroMsg.JsApiLaunchApplicationForNative", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", new Object[] { Boolean.valueOf(paramAnonymous2Boolean1), Boolean.valueOf(paramAnonymous2Boolean2) });
            if (paramAnonymous2Boolean1)
            {
              JsApiLaunchApplicationForNative.1.this.elY.callback(JsApiLaunchApplicationForNative.1.this.elZ, JsApiLaunchApplicationForNative.1.this.rCH.ZP("ok"));
              AppMethodBeat.o(45834);
              return;
            }
            JsApiLaunchApplicationForNative.1.this.elY.callback(JsApiLaunchApplicationForNative.1.this.elZ, JsApiLaunchApplicationForNative.1.this.rCH.ZP("fail:scheme launch fail"));
            AppMethodBeat.o(45834);
          }
        });
        Log.i("MicroMsg.JsApiLaunchApplicationForNative", "launchApplication check result(showType : %d, errCode : %d)", new Object[] { Integer.valueOf(localddj.show_type), Integer.valueOf(localddj.hGE) });
        Object localObject2;
        Object localObject1;
        if (!Util.isNullOrNil(JsApiLaunchApplicationForNative.1.this.ryu))
        {
          localObject2 = new Intent("android.intent.action.VIEW", Uri.parse(JsApiLaunchApplicationForNative.1.this.ryu));
          ((Intent)localObject2).addFlags(268435456);
          localObject1 = Util.queryIntentActivities(JsApiLaunchApplicationForNative.1.this.elY.getContext(), (Intent)localObject2);
          if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
          {
            if ((TextUtils.isEmpty(((Intent)localObject2).getPackage())) && (((List)localObject1).size() == 1)) {}
            for (localObject1 = h.b((ResolveInfo)((List)localObject1).get(0)); !Util.nullAsNil(MMApplicationContext.getPackageName()).equals(localObject1); localObject1 = ((Intent)localObject2).getPackage())
            {
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(45835);
                  boolean bool = h.a(JsApiLaunchApplicationForNative.1.this.elY.getContext(), this.val$intent, null, localddj.show_type, locala, JsApiLaunchApplicationForNative.1.this.ryv);
                  locala.iY(bool);
                  AppMethodBeat.o(45835);
                }
              });
              AppMethodBeat.o(45837);
              return;
            }
          }
        }
        if ((!Util.isNullOrNil(JsApiLaunchApplicationForNative.1.this.bJT)) && (!Util.isNullOrNil(JsApiLaunchApplicationForNative.1.this.ryw)))
        {
          localObject1 = u.cG(JsApiLaunchApplicationForNative.1.this.elY.aQ(Activity.class), JsApiLaunchApplicationForNative.1.this.bJT);
          if ((localObject1 != null) && (localObject1[0] != null))
          {
            localObject1 = g.getMessageDigest(localObject1[0].toByteArray());
            if ((localObject1 == null) || (!((String)localObject1).equalsIgnoreCase(JsApiLaunchApplicationForNative.1.this.ryw))) {
              break label667;
            }
            try
            {
              localObject1 = MMApplicationContext.getContext().getPackageManager().getLaunchIntentForPackage(JsApiLaunchApplicationForNative.1.this.bJT);
              if (localObject1 != null)
              {
                localObject2 = new Bundle();
                u.l((Bundle)localObject2, JsApiLaunchApplicationForNative.1.this.ryx);
                ((Intent)localObject1).putExtras((Bundle)localObject2);
                ((Intent)localObject1).addFlags(268435456);
                locala.iY(h.a(JsApiLaunchApplicationForNative.1.this.elY.aQ(Activity.class), (Intent)localObject1, null, locala, JsApiLaunchApplicationForNative.1.this.ryv));
                AppMethodBeat.o(45837);
                return;
              }
            }
            catch (Exception localException)
            {
              Log.e("MicroMsg.JsApiLaunchApplicationForNative", "launchApplication getLaunchIntentForPackage, %s", new Object[] { localException.getMessage() });
            }
          }
        }
        for (;;)
        {
          final JsApiLaunchApplicationForNative.LaunchApplicationTask localLaunchApplicationTask = new JsApiLaunchApplicationForNative.LaunchApplicationTask(AndroidContextUtil.castActivityOrNull(JsApiLaunchApplicationForNative.1.this.elY.getRuntime().mContext));
          localLaunchApplicationTask.appId = JsApiLaunchApplicationForNative.1.this.qyB;
          localLaunchApplicationTask.ryF = JsApiLaunchApplicationForNative.1.this.ryx;
          localLaunchApplicationTask.extInfo = JsApiLaunchApplicationForNative.1.this.ryy;
          localLaunchApplicationTask.hDf = JsApiLaunchApplicationForNative.1.this.ryv;
          localLaunchApplicationTask.hAN = localddj.show_type;
          localLaunchApplicationTask.rxj = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(45836);
              Log.i("MicroMsg.JsApiLaunchApplicationForNative", "callback task.success:%b", new Object[] { Boolean.valueOf(localLaunchApplicationTask.success) });
              localLaunchApplicationTask.cpx();
              if (!localLaunchApplicationTask.success)
              {
                JsApiLaunchApplicationForNative.1.this.elY.callback(JsApiLaunchApplicationForNative.1.this.elZ, JsApiLaunchApplicationForNative.1.this.rCH.ZP("fail:sdk launch fail"));
                AppMethodBeat.o(45836);
                return;
              }
              JsApiLaunchApplicationForNative.1.this.elY.callback(JsApiLaunchApplicationForNative.1.this.elZ, JsApiLaunchApplicationForNative.1.this.rCH.ZP("ok"));
              AppMethodBeat.o(45836);
            }
          };
          localLaunchApplicationTask.cpw();
          localLaunchApplicationTask.cpv();
          AppMethodBeat.o(45837);
          return;
          label667:
          Log.i("MicroMsg.JsApiLaunchApplicationForNative", "launchApplication signature not match");
        }
      }
    });
    AppMethodBeat.o(45838);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiLaunchApplicationForNative.1
 * JD-Core Version:    0.7.0.1
 */