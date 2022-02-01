package com.tencent.mm.plugin.appbrand.jsapi;

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
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.b.g;
import com.tencent.mm.ch.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.protocal.protobuf.ceb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.List;

final class JsApiLaunchApplication$1
  implements IPCRunCgi.a
{
  JsApiLaunchApplication$1(JsApiLaunchApplication paramJsApiLaunchApplication, s params, int paramInt, String paramString1, Bundle paramBundle, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {}
  
  public final void a(final int paramInt1, final int paramInt2, String paramString, final d paramd)
  {
    AppMethodBeat.i(45498);
    Log.i("MicroMsg.JsApiLaunchApplication", "on RunCgi callback errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    a.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45497);
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          JsApiLaunchApplication.1.this.cvO.i(JsApiLaunchApplication.1.this.cvP, JsApiLaunchApplication.1.this.lzP.h("fail:check fail", null));
          AppMethodBeat.o(45497);
          return;
        }
        final ceb localceb = (ceb)paramd.iLL.iLR;
        switch (localceb.dIZ)
        {
        case 1: 
        default: 
          JsApiLaunchApplication.1.this.cvO.i(JsApiLaunchApplication.1.this.cvP, JsApiLaunchApplication.1.this.lzP.h("fail:check fail 1", null));
          AppMethodBeat.o(45497);
          return;
        case 2: 
          JsApiLaunchApplication.1.this.cvO.i(JsApiLaunchApplication.1.this.cvP, JsApiLaunchApplication.1.this.lzP.h("fail:check fail forbidden scene 2", null));
          AppMethodBeat.o(45497);
          return;
        }
        final JsApiLaunchApplication.a locala = new JsApiLaunchApplication.a(new JsApiLaunchApplication.a.a()
        {
          public final void u(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
          {
            AppMethodBeat.i(45494);
            Log.i("MicroMsg.JsApiLaunchApplication", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", new Object[] { Boolean.valueOf(paramAnonymous2Boolean1), Boolean.valueOf(paramAnonymous2Boolean2) });
            if (paramAnonymous2Boolean1)
            {
              JsApiLaunchApplication.1.this.cvO.i(JsApiLaunchApplication.1.this.cvP, JsApiLaunchApplication.1.this.lzP.h("ok", null));
              AppMethodBeat.o(45494);
              return;
            }
            JsApiLaunchApplication.1.this.cvO.i(JsApiLaunchApplication.1.this.cvP, JsApiLaunchApplication.1.this.lzP.h("fail:scheme launch fail", null));
            AppMethodBeat.o(45494);
          }
        });
        Log.i("MicroMsg.JsApiLaunchApplication", "launchApplication check result(showType : %d, errCode : %d)", new Object[] { Integer.valueOf(localceb.xGz), Integer.valueOf(localceb.dIZ) });
        Object localObject2;
        Object localObject1;
        if (!Util.isNullOrNil(JsApiLaunchApplication.1.this.lzK))
        {
          localObject2 = new Intent("android.intent.action.VIEW", Uri.parse(JsApiLaunchApplication.1.this.lzK));
          ((Intent)localObject2).addFlags(268435456);
          localObject1 = Util.queryIntentActivities(JsApiLaunchApplication.1.this.cvO.getContext(), (Intent)localObject2);
          if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
          {
            if ((TextUtils.isEmpty(((Intent)localObject2).getPackage())) && (((List)localObject1).size() == 1)) {}
            for (localObject1 = h.b((ResolveInfo)((List)localObject1).get(0)); !Util.nullAsNil(MMApplicationContext.getPackageName()).equals(localObject1); localObject1 = ((Intent)localObject2).getPackage())
            {
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(45495);
                  boolean bool = h.a(JsApiLaunchApplication.1.this.cvO.getContext(), this.val$intent, null, localceb.xGz, locala, JsApiLaunchApplication.1.this.lzL);
                  locala.hj(bool);
                  AppMethodBeat.o(45495);
                }
              });
              AppMethodBeat.o(45497);
              return;
            }
          }
        }
        if ((!Util.isNullOrNil(JsApiLaunchApplication.1.this.LS)) && (!Util.isNullOrNil(JsApiLaunchApplication.1.this.lzM)))
        {
          localObject1 = q.cj(JsApiLaunchApplication.1.this.cvO.ay(Activity.class), JsApiLaunchApplication.1.this.LS);
          if ((localObject1 != null) && (localObject1[0] != null))
          {
            localObject1 = g.getMessageDigest(localObject1[0].toByteArray());
            if ((localObject1 == null) || (!((String)localObject1).equalsIgnoreCase(JsApiLaunchApplication.1.this.lzM))) {
              break label669;
            }
            try
            {
              localObject1 = MMApplicationContext.getContext().getPackageManager().getLaunchIntentForPackage(JsApiLaunchApplication.1.this.LS);
              if (localObject1 != null)
              {
                localObject2 = new Bundle();
                q.k((Bundle)localObject2, JsApiLaunchApplication.1.this.lzN);
                ((Intent)localObject1).putExtras((Bundle)localObject2);
                ((Intent)localObject1).addFlags(268435456);
                locala.hj(h.a(JsApiLaunchApplication.1.this.cvO.ay(Activity.class), (Intent)localObject1, null, locala, JsApiLaunchApplication.1.this.lzL));
                AppMethodBeat.o(45497);
                return;
              }
            }
            catch (Exception localException)
            {
              Log.e("MicroMsg.JsApiLaunchApplication", "launchApplication getLaunchIntentForPackage, %s", new Object[] { localException.getMessage() });
            }
          }
        }
        for (;;)
        {
          final JsApiLaunchApplication.LaunchApplicationTask localLaunchApplicationTask = new JsApiLaunchApplication.LaunchApplicationTask(AndroidContextUtil.castActivityOrNull(JsApiLaunchApplication.1.this.cvO.getRuntime().mContext));
          localLaunchApplicationTask.appId = JsApiLaunchApplication.1.this.kFU;
          localLaunchApplicationTask.lzV = JsApiLaunchApplication.1.this.lzN;
          localLaunchApplicationTask.extInfo = JsApiLaunchApplication.1.this.lzO;
          localLaunchApplicationTask.dFP = JsApiLaunchApplication.1.this.lzL;
          localLaunchApplicationTask.dDG = localceb.xGz;
          localLaunchApplicationTask.lyv = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(45496);
              Log.i("MicroMsg.JsApiLaunchApplication", "callback task.success:%b", new Object[] { Boolean.valueOf(localLaunchApplicationTask.success) });
              localLaunchApplicationTask.bDK();
              if (!localLaunchApplicationTask.success)
              {
                JsApiLaunchApplication.1.this.cvO.i(JsApiLaunchApplication.1.this.cvP, JsApiLaunchApplication.1.this.lzP.h("fail:sdk launch fail", null));
                AppMethodBeat.o(45496);
                return;
              }
              JsApiLaunchApplication.1.this.cvO.i(JsApiLaunchApplication.1.this.cvP, JsApiLaunchApplication.1.this.lzP.h("ok", null));
              AppMethodBeat.o(45496);
            }
          };
          localLaunchApplicationTask.bDJ();
          localLaunchApplicationTask.bDI();
          AppMethodBeat.o(45497);
          return;
          label669:
          Log.i("MicroMsg.JsApiLaunchApplication", "launchApplication signature not match");
        }
      }
    });
    AppMethodBeat.o(45498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication.1
 * JD-Core Version:    0.7.0.1
 */