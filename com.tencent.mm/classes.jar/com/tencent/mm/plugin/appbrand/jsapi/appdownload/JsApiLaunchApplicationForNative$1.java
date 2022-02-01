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
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.b.g;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.protocal.protobuf.bil;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.List;

final class JsApiLaunchApplicationForNative$1
  implements IPCRunCgi.a
{
  JsApiLaunchApplicationForNative$1(JsApiLaunchApplicationForNative paramJsApiLaunchApplicationForNative, com.tencent.mm.plugin.appbrand.q paramq, int paramInt, String paramString1, Bundle paramBundle, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {}
  
  public final void a(final int paramInt1, final int paramInt2, String paramString, final b paramb)
  {
    AppMethodBeat.i(45838);
    ad.i("MicroMsg.JsApiLaunchApplicationForNative", "on RunCgi callback errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    com.tencent.mm.cj.a.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45837);
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          JsApiLaunchApplicationForNative.1.this.ccA.h(JsApiLaunchApplicationForNative.1.this.ccB, JsApiLaunchApplicationForNative.1.this.jAN.e("fail:check fail", null));
          AppMethodBeat.o(45837);
          return;
        }
        final bil localbil = (bil)paramb.gUT.gUX;
        switch (localbil.dhR)
        {
        case 1: 
        default: 
          JsApiLaunchApplicationForNative.1.this.ccA.h(JsApiLaunchApplicationForNative.1.this.ccB, JsApiLaunchApplicationForNative.1.this.jAN.e("fail:check fail 1", null));
          AppMethodBeat.o(45837);
          return;
        case 2: 
          JsApiLaunchApplicationForNative.1.this.ccA.h(JsApiLaunchApplicationForNative.1.this.ccB, JsApiLaunchApplicationForNative.1.this.jAN.e("fail:check fail forbidden scene 2", null));
          AppMethodBeat.o(45837);
          return;
        }
        final JsApiLaunchApplicationForNative.a locala = new JsApiLaunchApplicationForNative.a(new JsApiLaunchApplicationForNative.a.a()
        {
          public final void t(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
          {
            AppMethodBeat.i(45834);
            ad.i("MicroMsg.JsApiLaunchApplicationForNative", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", new Object[] { Boolean.valueOf(paramAnonymous2Boolean1), Boolean.valueOf(paramAnonymous2Boolean2) });
            if (paramAnonymous2Boolean1)
            {
              JsApiLaunchApplicationForNative.1.this.ccA.h(JsApiLaunchApplicationForNative.1.this.ccB, JsApiLaunchApplicationForNative.1.this.jAN.e("ok", null));
              AppMethodBeat.o(45834);
              return;
            }
            JsApiLaunchApplicationForNative.1.this.ccA.h(JsApiLaunchApplicationForNative.1.this.ccB, JsApiLaunchApplicationForNative.1.this.jAN.e("fail:scheme launch fail", null));
            AppMethodBeat.o(45834);
          }
        });
        ad.i("MicroMsg.JsApiLaunchApplicationForNative", "launchApplication check result(showType : %d, errCode : %d)", new Object[] { Integer.valueOf(localbil.rXs), Integer.valueOf(localbil.dhR) });
        Object localObject2;
        Object localObject1;
        if (!bt.isNullOrNil(JsApiLaunchApplicationForNative.1.this.jxy))
        {
          localObject2 = new Intent("android.intent.action.VIEW", Uri.parse(JsApiLaunchApplicationForNative.1.this.jxy));
          ((Intent)localObject2).addFlags(268435456);
          localObject1 = bt.M(JsApiLaunchApplicationForNative.1.this.ccA.getContext(), (Intent)localObject2);
          if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
          {
            if ((TextUtils.isEmpty(((Intent)localObject2).getPackage())) && (((List)localObject1).size() == 1)) {}
            for (localObject1 = h.b((ResolveInfo)((List)localObject1).get(0)); !bt.nullAsNil(aj.getPackageName()).equals(localObject1); localObject1 = ((Intent)localObject2).getPackage())
            {
              aq.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(45835);
                  boolean bool = h.a(JsApiLaunchApplicationForNative.1.this.ccA.getContext(), this.val$intent, null, localbil.rXs, locala, JsApiLaunchApplicationForNative.1.this.jxz);
                  locala.fN(bool);
                  AppMethodBeat.o(45835);
                }
              });
              AppMethodBeat.o(45837);
              return;
            }
          }
        }
        if ((!bt.isNullOrNil(JsApiLaunchApplicationForNative.1.this.IX)) && (!bt.isNullOrNil(JsApiLaunchApplicationForNative.1.this.jxA)))
        {
          localObject1 = com.tencent.mm.pluginsdk.model.app.q.bJ(JsApiLaunchApplicationForNative.1.this.ccA.au(Activity.class), JsApiLaunchApplicationForNative.1.this.IX);
          if ((localObject1 != null) && (localObject1[0] != null))
          {
            localObject1 = g.getMessageDigest(localObject1[0].toByteArray());
            if ((localObject1 == null) || (!((String)localObject1).equalsIgnoreCase(JsApiLaunchApplicationForNative.1.this.jxA))) {
              break label669;
            }
            try
            {
              localObject1 = aj.getContext().getPackageManager().getLaunchIntentForPackage(JsApiLaunchApplicationForNative.1.this.IX);
              if (localObject1 != null)
              {
                localObject2 = new Bundle();
                com.tencent.mm.pluginsdk.model.app.q.j((Bundle)localObject2, JsApiLaunchApplicationForNative.1.this.jxB);
                ((Intent)localObject1).putExtras((Bundle)localObject2);
                ((Intent)localObject1).addFlags(268435456);
                locala.fN(h.a(JsApiLaunchApplicationForNative.1.this.ccA.au(Activity.class), (Intent)localObject1, null, locala, JsApiLaunchApplicationForNative.1.this.jxz));
                AppMethodBeat.o(45837);
                return;
              }
            }
            catch (Exception localException)
            {
              ad.e("MicroMsg.JsApiLaunchApplicationForNative", "launchApplication getLaunchIntentForPackage, %s", new Object[] { localException.getMessage() });
            }
          }
        }
        for (;;)
        {
          final JsApiLaunchApplicationForNative.LaunchApplicationTask localLaunchApplicationTask = new JsApiLaunchApplicationForNative.LaunchApplicationTask(com.tencent.mm.sdk.f.a.iV(JsApiLaunchApplicationForNative.1.this.ccA.getRuntime().mContext));
          localLaunchApplicationTask.appId = JsApiLaunchApplicationForNative.1.this.iHZ;
          localLaunchApplicationTask.jxJ = JsApiLaunchApplicationForNative.1.this.jxB;
          localLaunchApplicationTask.extInfo = JsApiLaunchApplicationForNative.1.this.jxC;
          localLaunchApplicationTask.deG = JsApiLaunchApplicationForNative.1.this.jxz;
          localLaunchApplicationTask.dcz = localbil.rXs;
          localLaunchApplicationTask.jwt = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(45836);
              ad.i("MicroMsg.JsApiLaunchApplicationForNative", "callback task.success:%b", new Object[] { Boolean.valueOf(localLaunchApplicationTask.success) });
              localLaunchApplicationTask.aXn();
              if (!localLaunchApplicationTask.success)
              {
                JsApiLaunchApplicationForNative.1.this.ccA.h(JsApiLaunchApplicationForNative.1.this.ccB, JsApiLaunchApplicationForNative.1.this.jAN.e("fail:sdk launch fail", null));
                AppMethodBeat.o(45836);
                return;
              }
              JsApiLaunchApplicationForNative.1.this.ccA.h(JsApiLaunchApplicationForNative.1.this.ccB, JsApiLaunchApplicationForNative.1.this.jAN.e("ok", null));
              AppMethodBeat.o(45836);
            }
          };
          localLaunchApplicationTask.aXm();
          localLaunchApplicationTask.aXl();
          AppMethodBeat.o(45837);
          return;
          label669:
          ad.i("MicroMsg.JsApiLaunchApplicationForNative", "launchApplication signature not match");
        }
      }
    });
    AppMethodBeat.o(45838);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiLaunchApplicationForNative.1
 * JD-Core Version:    0.7.0.1
 */