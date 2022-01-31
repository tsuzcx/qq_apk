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
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.protocal.protobuf.axg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.List;

final class JsApiLaunchApplication$1$1
  implements Runnable
{
  JsApiLaunchApplication$1$1(JsApiLaunchApplication.1 param1, int paramInt1, int paramInt2, b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(130438);
    if ((this.val$errType != 0) || (this.val$errCode != 0))
    {
      this.hyh.bAW.h(this.hyh.bAX, this.hyh.hyg.j("fail:check fail", null));
      AppMethodBeat.o(130438);
      return;
    }
    axg localaxg = (axg)this.fuz.fsW.fta;
    switch (localaxg.csV)
    {
    case 1: 
    default: 
      this.hyh.bAW.h(this.hyh.bAX, this.hyh.hyg.j("fail:check fail 1", null));
      AppMethodBeat.o(130438);
      return;
    case 2: 
      this.hyh.bAW.h(this.hyh.bAX, this.hyh.hyg.j("fail:check fail forbidden scene 2", null));
      AppMethodBeat.o(130438);
      return;
    }
    JsApiLaunchApplication.a locala = new JsApiLaunchApplication.a(new JsApiLaunchApplication.1.1.1(this));
    ab.i("MicroMsg.JsApiLaunchApplication", "launchApplication check result(showType : %d, errCode : %d)", new Object[] { Integer.valueOf(localaxg.xmD), Integer.valueOf(localaxg.csV) });
    Object localObject2;
    Object localObject1;
    if (!bo.isNullOrNil(this.hyh.hya))
    {
      localObject2 = new Intent("android.intent.action.VIEW", Uri.parse(this.hyh.hya));
      ((Intent)localObject2).addFlags(268435456);
      localObject1 = bo.H(this.hyh.bAW.getContext(), (Intent)localObject2);
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        if ((TextUtils.isEmpty(((Intent)localObject2).getPackage())) && (((List)localObject1).size() == 1)) {}
        for (localObject1 = com.tencent.mm.pluginsdk.model.app.g.b((ResolveInfo)((List)localObject1).get(0)); !bo.nullAsNil(ah.getPackageName()).equals(localObject1); localObject1 = ((Intent)localObject2).getPackage())
        {
          al.d(new JsApiLaunchApplication.1.1.2(this, (Intent)localObject2, localaxg, locala));
          AppMethodBeat.o(130438);
          return;
        }
      }
    }
    if ((!bo.isNullOrNil(this.hyh.Cl)) && (!bo.isNullOrNil(this.hyh.hyc)))
    {
      localObject1 = p.bv(this.hyh.bAW.X(Activity.class), this.hyh.Cl);
      if ((localObject1 != null) && (localObject1[0] != null))
      {
        localObject1 = com.tencent.mm.a.g.w(localObject1[0].toByteArray());
        if ((localObject1 == null) || (!((String)localObject1).equalsIgnoreCase(this.hyh.hyc))) {
          break label669;
        }
        try
        {
          localObject1 = ah.getContext().getPackageManager().getLaunchIntentForPackage(this.hyh.Cl);
          if (localObject1 != null)
          {
            localObject2 = new Bundle();
            p.j((Bundle)localObject2, this.hyh.hyd);
            ((Intent)localObject1).putExtras((Bundle)localObject2);
            ((Intent)localObject1).addFlags(268435456);
            locala.ea(com.tencent.mm.pluginsdk.model.app.g.a(this.hyh.bAW.X(Activity.class), (Intent)localObject1, null, locala, this.hyh.hyb));
            AppMethodBeat.o(130438);
            return;
          }
        }
        catch (Exception localException)
        {
          ab.e("MicroMsg.JsApiLaunchApplication", "launchApplication getLaunchIntentForPackage, %s", new Object[] { localException.getMessage() });
        }
      }
    }
    for (;;)
    {
      JsApiLaunchApplication.LaunchApplicationTask localLaunchApplicationTask = new JsApiLaunchApplication.LaunchApplicationTask((MMActivity)this.hyh.bAW.getContext());
      localLaunchApplicationTask.appId = this.hyh.hye;
      localLaunchApplicationTask.hym = this.hyh.hyd;
      localLaunchApplicationTask.extInfo = this.hyh.hyf;
      localLaunchApplicationTask.cpJ = this.hyh.hyb;
      localLaunchApplicationTask.showType = localaxg.xmD;
      localLaunchApplicationTask.hxp = new JsApiLaunchApplication.1.1.3(this, localLaunchApplicationTask);
      localLaunchApplicationTask.aBj();
      localLaunchApplicationTask.aBi();
      AppMethodBeat.o(130438);
      return;
      label669:
      ab.i("MicroMsg.JsApiLaunchApplication", "launchApplication signature not match");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication.1.1
 * JD-Core Version:    0.7.0.1
 */