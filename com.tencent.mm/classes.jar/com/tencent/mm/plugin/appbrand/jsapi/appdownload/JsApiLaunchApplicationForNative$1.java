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
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.b.g;
import com.tencent.mm.co.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.protocal.protobuf.cmv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.List;

final class JsApiLaunchApplicationForNative$1
  implements IPCRunCgi.a
{
  JsApiLaunchApplicationForNative$1(JsApiLaunchApplicationForNative paramJsApiLaunchApplicationForNative, v paramv, int paramInt, String paramString1, Bundle paramBundle, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {}
  
  public final void a(final int paramInt1, final int paramInt2, String paramString, final d paramd)
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
          JsApiLaunchApplicationForNative.1.this.cue.j(JsApiLaunchApplicationForNative.1.this.cuf, JsApiLaunchApplicationForNative.1.this.oyP.h("fail:check fail", null));
          AppMethodBeat.o(45837);
          return;
        }
        final cmv localcmv = (cmv)d.c.b(paramd.lBS);
        switch (localcmv.fBP)
        {
        case 1: 
        default: 
          JsApiLaunchApplicationForNative.1.this.cue.j(JsApiLaunchApplicationForNative.1.this.cuf, JsApiLaunchApplicationForNative.1.this.oyP.h("fail:check fail 1", null));
          AppMethodBeat.o(45837);
          return;
        case 2: 
          JsApiLaunchApplicationForNative.1.this.cue.j(JsApiLaunchApplicationForNative.1.this.cuf, JsApiLaunchApplicationForNative.1.this.oyP.h("fail:check fail forbidden scene 2", null));
          AppMethodBeat.o(45837);
          return;
        }
        final JsApiLaunchApplicationForNative.a locala = new JsApiLaunchApplicationForNative.a(new JsApiLaunchApplicationForNative.a.a()
        {
          public final void x(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
          {
            AppMethodBeat.i(45834);
            Log.i("MicroMsg.JsApiLaunchApplicationForNative", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", new Object[] { Boolean.valueOf(paramAnonymous2Boolean1), Boolean.valueOf(paramAnonymous2Boolean2) });
            if (paramAnonymous2Boolean1)
            {
              JsApiLaunchApplicationForNative.1.this.cue.j(JsApiLaunchApplicationForNative.1.this.cuf, JsApiLaunchApplicationForNative.1.this.oyP.h("ok", null));
              AppMethodBeat.o(45834);
              return;
            }
            JsApiLaunchApplicationForNative.1.this.cue.j(JsApiLaunchApplicationForNative.1.this.cuf, JsApiLaunchApplicationForNative.1.this.oyP.h("fail:scheme launch fail", null));
            AppMethodBeat.o(45834);
          }
        });
        Log.i("MicroMsg.JsApiLaunchApplicationForNative", "launchApplication check result(showType : %d, errCode : %d)", new Object[] { Integer.valueOf(localcmv.CKC), Integer.valueOf(localcmv.fBP) });
        Object localObject2;
        Object localObject1;
        if (!Util.isNullOrNil(JsApiLaunchApplicationForNative.1.this.ova))
        {
          localObject2 = new Intent("android.intent.action.VIEW", Uri.parse(JsApiLaunchApplicationForNative.1.this.ova));
          ((Intent)localObject2).addFlags(268435456);
          localObject1 = Util.queryIntentActivities(JsApiLaunchApplicationForNative.1.this.cue.getContext(), (Intent)localObject2);
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
                  boolean bool = h.a(JsApiLaunchApplicationForNative.1.this.cue.getContext(), this.val$intent, null, localcmv.CKC, locala, JsApiLaunchApplicationForNative.1.this.ovb);
                  locala.hZ(bool);
                  AppMethodBeat.o(45835);
                }
              });
              AppMethodBeat.o(45837);
              return;
            }
          }
        }
        if ((!Util.isNullOrNil(JsApiLaunchApplicationForNative.1.this.ack)) && (!Util.isNullOrNil(JsApiLaunchApplicationForNative.1.this.ovc)))
        {
          localObject1 = q.cv(JsApiLaunchApplicationForNative.1.this.cue.ax(Activity.class), JsApiLaunchApplicationForNative.1.this.ack);
          if ((localObject1 != null) && (localObject1[0] != null))
          {
            localObject1 = g.getMessageDigest(localObject1[0].toByteArray());
            if ((localObject1 == null) || (!((String)localObject1).equalsIgnoreCase(JsApiLaunchApplicationForNative.1.this.ovc))) {
              break label669;
            }
            try
            {
              localObject1 = MMApplicationContext.getContext().getPackageManager().getLaunchIntentForPackage(JsApiLaunchApplicationForNative.1.this.ack);
              if (localObject1 != null)
              {
                localObject2 = new Bundle();
                q.l((Bundle)localObject2, JsApiLaunchApplicationForNative.1.this.ovd);
                ((Intent)localObject1).putExtras((Bundle)localObject2);
                ((Intent)localObject1).addFlags(268435456);
                locala.hZ(h.a(JsApiLaunchApplicationForNative.1.this.cue.ax(Activity.class), (Intent)localObject1, null, locala, JsApiLaunchApplicationForNative.1.this.ovb));
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
          final JsApiLaunchApplicationForNative.LaunchApplicationTask localLaunchApplicationTask = new JsApiLaunchApplicationForNative.LaunchApplicationTask(AndroidContextUtil.castActivityOrNull(JsApiLaunchApplicationForNative.1.this.cue.getRuntime().mContext));
          localLaunchApplicationTask.appId = JsApiLaunchApplicationForNative.1.this.nzB;
          localLaunchApplicationTask.ovl = JsApiLaunchApplicationForNative.1.this.ovd;
          localLaunchApplicationTask.extInfo = JsApiLaunchApplicationForNative.1.this.ove;
          localLaunchApplicationTask.fyw = JsApiLaunchApplicationForNative.1.this.ovb;
          localLaunchApplicationTask.fwp = localcmv.CKC;
          localLaunchApplicationTask.otv = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(45836);
              Log.i("MicroMsg.JsApiLaunchApplicationForNative", "callback task.success:%b", new Object[] { Boolean.valueOf(localLaunchApplicationTask.success) });
              localLaunchApplicationTask.bPk();
              if (!localLaunchApplicationTask.success)
              {
                JsApiLaunchApplicationForNative.1.this.cue.j(JsApiLaunchApplicationForNative.1.this.cuf, JsApiLaunchApplicationForNative.1.this.oyP.h("fail:sdk launch fail", null));
                AppMethodBeat.o(45836);
                return;
              }
              JsApiLaunchApplicationForNative.1.this.cue.j(JsApiLaunchApplicationForNative.1.this.cuf, JsApiLaunchApplicationForNative.1.this.oyP.h("ok", null));
              AppMethodBeat.o(45836);
            }
          };
          localLaunchApplicationTask.bPj();
          localLaunchApplicationTask.bPi();
          AppMethodBeat.o(45837);
          return;
          label669:
          Log.i("MicroMsg.JsApiLaunchApplicationForNative", "launchApplication signature not match");
        }
      }
    });
    AppMethodBeat.o(45838);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiLaunchApplicationForNative.1
 * JD-Core Version:    0.7.0.1
 */