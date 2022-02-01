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
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.b.g;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.protocal.protobuf.bqn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.List;

final class JsApiLaunchApplication$1
  implements IPCRunCgi.a
{
  JsApiLaunchApplication$1(JsApiLaunchApplication paramJsApiLaunchApplication, com.tencent.mm.plugin.appbrand.q paramq, int paramInt, String paramString1, Bundle paramBundle, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {}
  
  public final void a(final int paramInt1, final int paramInt2, String paramString, final b paramb)
  {
    AppMethodBeat.i(45498);
    ad.i("MicroMsg.JsApiLaunchApplication", "on RunCgi callback errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    com.tencent.mm.ci.a.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45497);
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          JsApiLaunchApplication.1.this.cjP.h(JsApiLaunchApplication.1.this.cjQ, JsApiLaunchApplication.1.this.ksv.e("fail:check fail", null));
          AppMethodBeat.o(45497);
          return;
        }
        final bqn localbqn = (bqn)paramb.hNL.hNQ;
        switch (localbqn.dqI)
        {
        case 1: 
        default: 
          JsApiLaunchApplication.1.this.cjP.h(JsApiLaunchApplication.1.this.cjQ, JsApiLaunchApplication.1.this.ksv.e("fail:check fail 1", null));
          AppMethodBeat.o(45497);
          return;
        case 2: 
          JsApiLaunchApplication.1.this.cjP.h(JsApiLaunchApplication.1.this.cjQ, JsApiLaunchApplication.1.this.ksv.e("fail:check fail forbidden scene 2", null));
          AppMethodBeat.o(45497);
          return;
        }
        final JsApiLaunchApplication.a locala = new JsApiLaunchApplication.a(new JsApiLaunchApplication.a.a()
        {
          public final void u(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
          {
            AppMethodBeat.i(45494);
            ad.i("MicroMsg.JsApiLaunchApplication", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", new Object[] { Boolean.valueOf(paramAnonymous2Boolean1), Boolean.valueOf(paramAnonymous2Boolean2) });
            if (paramAnonymous2Boolean1)
            {
              JsApiLaunchApplication.1.this.cjP.h(JsApiLaunchApplication.1.this.cjQ, JsApiLaunchApplication.1.this.ksv.e("ok", null));
              AppMethodBeat.o(45494);
              return;
            }
            JsApiLaunchApplication.1.this.cjP.h(JsApiLaunchApplication.1.this.cjQ, JsApiLaunchApplication.1.this.ksv.e("fail:scheme launch fail", null));
            AppMethodBeat.o(45494);
          }
        });
        ad.i("MicroMsg.JsApiLaunchApplication", "launchApplication check result(showType : %d, errCode : %d)", new Object[] { Integer.valueOf(localbqn.uda), Integer.valueOf(localbqn.dqI) });
        Object localObject2;
        Object localObject1;
        if (!bt.isNullOrNil(JsApiLaunchApplication.1.this.ksq))
        {
          localObject2 = new Intent("android.intent.action.VIEW", Uri.parse(JsApiLaunchApplication.1.this.ksq));
          ((Intent)localObject2).addFlags(268435456);
          localObject1 = bt.ac(JsApiLaunchApplication.1.this.cjP.getContext(), (Intent)localObject2);
          if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
          {
            if ((TextUtils.isEmpty(((Intent)localObject2).getPackage())) && (((List)localObject1).size() == 1)) {}
            for (localObject1 = h.b((ResolveInfo)((List)localObject1).get(0)); !bt.nullAsNil(aj.getPackageName()).equals(localObject1); localObject1 = ((Intent)localObject2).getPackage())
            {
              aq.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(45495);
                  boolean bool = h.a(JsApiLaunchApplication.1.this.cjP.getContext(), this.val$intent, null, localbqn.uda, locala, JsApiLaunchApplication.1.this.ksr);
                  locala.go(bool);
                  AppMethodBeat.o(45495);
                }
              });
              AppMethodBeat.o(45497);
              return;
            }
          }
        }
        if ((!bt.isNullOrNil(JsApiLaunchApplication.1.this.LI)) && (!bt.isNullOrNil(JsApiLaunchApplication.1.this.kss)))
        {
          localObject1 = com.tencent.mm.pluginsdk.model.app.q.bO(JsApiLaunchApplication.1.this.cjP.au(Activity.class), JsApiLaunchApplication.1.this.LI);
          if ((localObject1 != null) && (localObject1[0] != null))
          {
            localObject1 = g.getMessageDigest(localObject1[0].toByteArray());
            if ((localObject1 == null) || (!((String)localObject1).equalsIgnoreCase(JsApiLaunchApplication.1.this.kss))) {
              break label669;
            }
            try
            {
              localObject1 = aj.getContext().getPackageManager().getLaunchIntentForPackage(JsApiLaunchApplication.1.this.LI);
              if (localObject1 != null)
              {
                localObject2 = new Bundle();
                com.tencent.mm.pluginsdk.model.app.q.j((Bundle)localObject2, JsApiLaunchApplication.1.this.kst);
                ((Intent)localObject1).putExtras((Bundle)localObject2);
                ((Intent)localObject1).addFlags(268435456);
                locala.go(h.a(JsApiLaunchApplication.1.this.cjP.au(Activity.class), (Intent)localObject1, null, locala, JsApiLaunchApplication.1.this.ksr));
                AppMethodBeat.o(45497);
                return;
              }
            }
            catch (Exception localException)
            {
              ad.e("MicroMsg.JsApiLaunchApplication", "launchApplication getLaunchIntentForPackage, %s", new Object[] { localException.getMessage() });
            }
          }
        }
        for (;;)
        {
          final JsApiLaunchApplication.LaunchApplicationTask localLaunchApplicationTask = new JsApiLaunchApplication.LaunchApplicationTask(com.tencent.mm.sdk.f.a.jq(JsApiLaunchApplication.1.this.cjP.getRuntime().mContext));
          localLaunchApplicationTask.appId = JsApiLaunchApplication.1.this.jBr;
          localLaunchApplicationTask.ksB = JsApiLaunchApplication.1.this.kst;
          localLaunchApplicationTask.extInfo = JsApiLaunchApplication.1.this.ksu;
          localLaunchApplicationTask.dnx = JsApiLaunchApplication.1.this.ksr;
          localLaunchApplicationTask.dlp = localbqn.uda;
          localLaunchApplicationTask.krg = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(45496);
              ad.i("MicroMsg.JsApiLaunchApplication", "callback task.success:%b", new Object[] { Boolean.valueOf(localLaunchApplicationTask.success) });
              localLaunchApplicationTask.bhO();
              if (!localLaunchApplicationTask.success)
              {
                JsApiLaunchApplication.1.this.cjP.h(JsApiLaunchApplication.1.this.cjQ, JsApiLaunchApplication.1.this.ksv.e("fail:sdk launch fail", null));
                AppMethodBeat.o(45496);
                return;
              }
              JsApiLaunchApplication.1.this.cjP.h(JsApiLaunchApplication.1.this.cjQ, JsApiLaunchApplication.1.this.ksv.e("ok", null));
              AppMethodBeat.o(45496);
            }
          };
          localLaunchApplicationTask.bhN();
          localLaunchApplicationTask.bhM();
          AppMethodBeat.o(45497);
          return;
          label669:
          ad.i("MicroMsg.JsApiLaunchApplication", "launchApplication signature not match");
        }
      }
    });
    AppMethodBeat.o(45498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication.1
 * JD-Core Version:    0.7.0.1
 */