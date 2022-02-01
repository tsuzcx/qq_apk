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
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.b.g;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.protocal.protobuf.brh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.List;

final class JsApiLaunchApplicationForNative$1
  implements IPCRunCgi.a
{
  JsApiLaunchApplicationForNative$1(JsApiLaunchApplicationForNative paramJsApiLaunchApplicationForNative, r paramr, int paramInt, String paramString1, Bundle paramBundle, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {}
  
  public final void a(final int paramInt1, final int paramInt2, String paramString, final b paramb)
  {
    AppMethodBeat.i(45838);
    ae.i("MicroMsg.JsApiLaunchApplicationForNative", "on RunCgi callback errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    com.tencent.mm.ch.a.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45837);
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          JsApiLaunchApplicationForNative.1.this.cjR.h(JsApiLaunchApplicationForNative.1.this.cjS, JsApiLaunchApplicationForNative.1.this.kyU.e("fail:check fail", null));
          AppMethodBeat.o(45837);
          return;
        }
        final brh localbrh = (brh)paramb.hQE.hQJ;
        switch (localbrh.drN)
        {
        case 1: 
        default: 
          JsApiLaunchApplicationForNative.1.this.cjR.h(JsApiLaunchApplicationForNative.1.this.cjS, JsApiLaunchApplicationForNative.1.this.kyU.e("fail:check fail 1", null));
          AppMethodBeat.o(45837);
          return;
        case 2: 
          JsApiLaunchApplicationForNative.1.this.cjR.h(JsApiLaunchApplicationForNative.1.this.cjS, JsApiLaunchApplicationForNative.1.this.kyU.e("fail:check fail forbidden scene 2", null));
          AppMethodBeat.o(45837);
          return;
        }
        final JsApiLaunchApplicationForNative.a locala = new JsApiLaunchApplicationForNative.a(new JsApiLaunchApplicationForNative.a.a()
        {
          public final void u(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
          {
            AppMethodBeat.i(45834);
            ae.i("MicroMsg.JsApiLaunchApplicationForNative", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", new Object[] { Boolean.valueOf(paramAnonymous2Boolean1), Boolean.valueOf(paramAnonymous2Boolean2) });
            if (paramAnonymous2Boolean1)
            {
              JsApiLaunchApplicationForNative.1.this.cjR.h(JsApiLaunchApplicationForNative.1.this.cjS, JsApiLaunchApplicationForNative.1.this.kyU.e("ok", null));
              AppMethodBeat.o(45834);
              return;
            }
            JsApiLaunchApplicationForNative.1.this.cjR.h(JsApiLaunchApplicationForNative.1.this.cjS, JsApiLaunchApplicationForNative.1.this.kyU.e("fail:scheme launch fail", null));
            AppMethodBeat.o(45834);
          }
        });
        ae.i("MicroMsg.JsApiLaunchApplicationForNative", "launchApplication check result(showType : %d, errCode : %d)", new Object[] { Integer.valueOf(localbrh.uoi), Integer.valueOf(localbrh.drN) });
        Object localObject2;
        Object localObject1;
        if (!bu.isNullOrNil(JsApiLaunchApplicationForNative.1.this.kvG))
        {
          localObject2 = new Intent("android.intent.action.VIEW", Uri.parse(JsApiLaunchApplicationForNative.1.this.kvG));
          ((Intent)localObject2).addFlags(268435456);
          localObject1 = bu.ac(JsApiLaunchApplicationForNative.1.this.cjR.getContext(), (Intent)localObject2);
          if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
          {
            if ((TextUtils.isEmpty(((Intent)localObject2).getPackage())) && (((List)localObject1).size() == 1)) {}
            for (localObject1 = h.b((ResolveInfo)((List)localObject1).get(0)); !bu.nullAsNil(ak.getPackageName()).equals(localObject1); localObject1 = ((Intent)localObject2).getPackage())
            {
              ar.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(45835);
                  boolean bool = h.a(JsApiLaunchApplicationForNative.1.this.cjR.getContext(), this.val$intent, null, localbrh.uoi, locala, JsApiLaunchApplicationForNative.1.this.kvH);
                  locala.gm(bool);
                  AppMethodBeat.o(45835);
                }
              });
              AppMethodBeat.o(45837);
              return;
            }
          }
        }
        if ((!bu.isNullOrNil(JsApiLaunchApplicationForNative.1.this.LI)) && (!bu.isNullOrNil(JsApiLaunchApplicationForNative.1.this.kvI)))
        {
          localObject1 = q.bP(JsApiLaunchApplicationForNative.1.this.cjR.au(Activity.class), JsApiLaunchApplicationForNative.1.this.LI);
          if ((localObject1 != null) && (localObject1[0] != null))
          {
            localObject1 = g.getMessageDigest(localObject1[0].toByteArray());
            if ((localObject1 == null) || (!((String)localObject1).equalsIgnoreCase(JsApiLaunchApplicationForNative.1.this.kvI))) {
              break label669;
            }
            try
            {
              localObject1 = ak.getContext().getPackageManager().getLaunchIntentForPackage(JsApiLaunchApplicationForNative.1.this.LI);
              if (localObject1 != null)
              {
                localObject2 = new Bundle();
                q.j((Bundle)localObject2, JsApiLaunchApplicationForNative.1.this.kvJ);
                ((Intent)localObject1).putExtras((Bundle)localObject2);
                ((Intent)localObject1).addFlags(268435456);
                locala.gm(h.a(JsApiLaunchApplicationForNative.1.this.cjR.au(Activity.class), (Intent)localObject1, null, locala, JsApiLaunchApplicationForNative.1.this.kvH));
                AppMethodBeat.o(45837);
                return;
              }
            }
            catch (Exception localException)
            {
              ae.e("MicroMsg.JsApiLaunchApplicationForNative", "launchApplication getLaunchIntentForPackage, %s", new Object[] { localException.getMessage() });
            }
          }
        }
        for (;;)
        {
          final JsApiLaunchApplicationForNative.LaunchApplicationTask localLaunchApplicationTask = new JsApiLaunchApplicationForNative.LaunchApplicationTask(com.tencent.mm.sdk.f.a.jw(JsApiLaunchApplicationForNative.1.this.cjR.getRuntime().mContext));
          localLaunchApplicationTask.appId = JsApiLaunchApplicationForNative.1.this.jEl;
          localLaunchApplicationTask.kvR = JsApiLaunchApplicationForNative.1.this.kvJ;
          localLaunchApplicationTask.extInfo = JsApiLaunchApplicationForNative.1.this.kvK;
          localLaunchApplicationTask.doz = JsApiLaunchApplicationForNative.1.this.kvH;
          localLaunchApplicationTask.dmr = localbrh.uoi;
          localLaunchApplicationTask.kuv = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(45836);
              ae.i("MicroMsg.JsApiLaunchApplicationForNative", "callback task.success:%b", new Object[] { Boolean.valueOf(localLaunchApplicationTask.success) });
              localLaunchApplicationTask.bix();
              if (!localLaunchApplicationTask.success)
              {
                JsApiLaunchApplicationForNative.1.this.cjR.h(JsApiLaunchApplicationForNative.1.this.cjS, JsApiLaunchApplicationForNative.1.this.kyU.e("fail:sdk launch fail", null));
                AppMethodBeat.o(45836);
                return;
              }
              JsApiLaunchApplicationForNative.1.this.cjR.h(JsApiLaunchApplicationForNative.1.this.cjS, JsApiLaunchApplicationForNative.1.this.kyU.e("ok", null));
              AppMethodBeat.o(45836);
            }
          };
          localLaunchApplicationTask.biw();
          localLaunchApplicationTask.biv();
          AppMethodBeat.o(45837);
          return;
          label669:
          ae.i("MicroMsg.JsApiLaunchApplicationForNative", "launchApplication signature not match");
        }
      }
    });
    AppMethodBeat.o(45838);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiLaunchApplicationForNative.1
 * JD-Core Version:    0.7.0.1
 */