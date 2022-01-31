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
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.protocal.protobuf.axg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.List;

final class JsApiLaunchApplicationForNative$1$1
  implements Runnable
{
  JsApiLaunchApplicationForNative$1$1(JsApiLaunchApplicationForNative.1 param1, int paramInt1, int paramInt2, b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(143335);
    if ((this.val$errType != 0) || (this.val$errCode != 0))
    {
      this.hBk.bAW.h(this.hBk.bAX, this.hBk.hBj.j("fail:check fail", null));
      AppMethodBeat.o(143335);
      return;
    }
    axg localaxg = (axg)this.fuz.fsW.fta;
    switch (localaxg.csV)
    {
    case 1: 
    default: 
      this.hBk.bAW.h(this.hBk.bAX, this.hBk.hBj.j("fail:check fail 1", null));
      AppMethodBeat.o(143335);
      return;
    case 2: 
      this.hBk.bAW.h(this.hBk.bAX, this.hBk.hBj.j("fail:check fail forbidden scene 2", null));
      AppMethodBeat.o(143335);
      return;
    }
    JsApiLaunchApplicationForNative.a locala = new JsApiLaunchApplicationForNative.a(new JsApiLaunchApplicationForNative.a.a()
    {
      public final void r(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(143332);
        ab.i("MicroMsg.JsApiLaunchApplicationForNative", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", new Object[] { Boolean.valueOf(paramAnonymousBoolean1), Boolean.valueOf(paramAnonymousBoolean2) });
        if (paramAnonymousBoolean1)
        {
          JsApiLaunchApplicationForNative.1.1.this.hBk.bAW.h(JsApiLaunchApplicationForNative.1.1.this.hBk.bAX, JsApiLaunchApplicationForNative.1.1.this.hBk.hBj.j("ok", null));
          AppMethodBeat.o(143332);
          return;
        }
        JsApiLaunchApplicationForNative.1.1.this.hBk.bAW.h(JsApiLaunchApplicationForNative.1.1.this.hBk.bAX, JsApiLaunchApplicationForNative.1.1.this.hBk.hBj.j("fail:scheme launch fail", null));
        AppMethodBeat.o(143332);
      }
    });
    ab.i("MicroMsg.JsApiLaunchApplicationForNative", "launchApplication check result(showType : %d, errCode : %d)", new Object[] { Integer.valueOf(localaxg.xmD), Integer.valueOf(localaxg.csV) });
    Object localObject2;
    Object localObject1;
    if (!bo.isNullOrNil(this.hBk.hya))
    {
      localObject2 = new Intent("android.intent.action.VIEW", Uri.parse(this.hBk.hya));
      ((Intent)localObject2).addFlags(268435456);
      localObject1 = bo.H(this.hBk.bAW.getContext(), (Intent)localObject2);
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        if ((TextUtils.isEmpty(((Intent)localObject2).getPackage())) && (((List)localObject1).size() == 1)) {}
        for (localObject1 = com.tencent.mm.pluginsdk.model.app.g.b((ResolveInfo)((List)localObject1).get(0)); !bo.nullAsNil(ah.getPackageName()).equals(localObject1); localObject1 = ((Intent)localObject2).getPackage())
        {
          al.d(new JsApiLaunchApplicationForNative.1.1.2(this, (Intent)localObject2, localaxg, locala));
          AppMethodBeat.o(143335);
          return;
        }
      }
    }
    if ((!bo.isNullOrNil(this.hBk.Cl)) && (!bo.isNullOrNil(this.hBk.hyc)))
    {
      localObject1 = p.bv(this.hBk.bAW.X(Activity.class), this.hBk.Cl);
      if ((localObject1 != null) && (localObject1[0] != null))
      {
        localObject1 = com.tencent.mm.a.g.w(localObject1[0].toByteArray());
        if ((localObject1 == null) || (!((String)localObject1).equalsIgnoreCase(this.hBk.hyc))) {
          break label669;
        }
        try
        {
          localObject1 = ah.getContext().getPackageManager().getLaunchIntentForPackage(this.hBk.Cl);
          if (localObject1 != null)
          {
            localObject2 = new Bundle();
            p.j((Bundle)localObject2, this.hBk.hyd);
            ((Intent)localObject1).putExtras((Bundle)localObject2);
            ((Intent)localObject1).addFlags(268435456);
            locala.ea(com.tencent.mm.pluginsdk.model.app.g.a(this.hBk.bAW.X(Activity.class), (Intent)localObject1, null, locala, this.hBk.hyb));
            AppMethodBeat.o(143335);
            return;
          }
        }
        catch (Exception localException)
        {
          ab.e("MicroMsg.JsApiLaunchApplicationForNative", "launchApplication getLaunchIntentForPackage, %s", new Object[] { localException.getMessage() });
        }
      }
    }
    for (;;)
    {
      JsApiLaunchApplicationForNative.LaunchApplicationTask localLaunchApplicationTask = new JsApiLaunchApplicationForNative.LaunchApplicationTask((MMActivity)this.hBk.bAW.getContext());
      localLaunchApplicationTask.appId = this.hBk.hye;
      localLaunchApplicationTask.hym = this.hBk.hyd;
      localLaunchApplicationTask.extInfo = this.hBk.hyf;
      localLaunchApplicationTask.cpJ = this.hBk.hyb;
      localLaunchApplicationTask.showType = localaxg.xmD;
      localLaunchApplicationTask.hxp = new JsApiLaunchApplicationForNative.1.1.3(this, localLaunchApplicationTask);
      localLaunchApplicationTask.aBj();
      localLaunchApplicationTask.aBi();
      AppMethodBeat.o(143335);
      return;
      label669:
      ab.i("MicroMsg.JsApiLaunchApplicationForNative", "launchApplication signature not match");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiLaunchApplicationForNative.1.1
 * JD-Core Version:    0.7.0.1
 */