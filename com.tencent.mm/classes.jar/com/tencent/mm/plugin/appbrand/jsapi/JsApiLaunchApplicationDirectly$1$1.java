package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.protobuf.axg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.List;

final class JsApiLaunchApplicationDirectly$1$1
  implements Runnable
{
  JsApiLaunchApplicationDirectly$1$1(JsApiLaunchApplicationDirectly.1 param1, int paramInt1, int paramInt2, com.tencent.mm.ai.b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(130455);
    if ((this.val$errType != 0) || (this.val$errCode != 0))
    {
      this.hyw.bAW.h(this.hyw.bAX, this.hyw.hyv.j("fail:check fail", null));
      AppMethodBeat.o(130455);
      return;
    }
    Object localObject2 = (axg)this.fuz.fsW.fta;
    switch (((axg)localObject2).csV)
    {
    case 1: 
    default: 
      this.hyw.bAW.h(this.hyw.bAX, this.hyw.hyv.j("fail:check fail 1", null));
      AppMethodBeat.o(130455);
      return;
    case 2: 
      this.hyw.bAW.h(this.hyw.bAX, this.hyw.hyv.j("fail:check fail forbidden scene 2", null));
      AppMethodBeat.o(130455);
      return;
    }
    if (((axg)localObject2).xmE == 1)
    {
      this.hyw.bAW.h(this.hyw.bAX, this.hyw.hyv.j("fail:install app denied", null));
      AppMethodBeat.o(130455);
      return;
    }
    ab.i("MicroMsg.JsApiLaunchApplicationDirectly", "launchApplication check result(showType:%d, errCode:%d, jumpFlog:%d)", new Object[] { Integer.valueOf(((axg)localObject2).xmD), Integer.valueOf(((axg)localObject2).csV), Integer.valueOf(((axg)localObject2).xmE) });
    Object localObject4;
    if (com.tencent.mm.plugin.appbrand.s.b.getPackageInfo(ah.getContext(), this.hyw.val$packageName) == null)
    {
      localObject1 = this.hyw.hyv;
      localObject2 = this.hyw.hys;
      localObject3 = this.hyw.hye;
      localObject4 = this.hyw.hyt;
      String str1 = this.hyw.hyu;
      String str2 = this.hyw.val$packageName;
      r localr = this.hyw.bAW;
      int i = this.hyw.bAX;
      h.a(localr.getContext(), localr.getContext().getString(2131297150), "", localr.getContext().getString(2131296599), localr.getContext().getString(2131296590), false, new JsApiLaunchApplicationDirectly.3((JsApiLaunchApplicationDirectly)localObject1, localr, (String)localObject3, (String)localObject2, (String)localObject4, str1, str2, i), new JsApiLaunchApplicationDirectly.4((JsApiLaunchApplicationDirectly)localObject1, localr, i));
      AppMethodBeat.o(130455);
      return;
    }
    Object localObject3 = new JsApiLaunchApplicationDirectly.a(new JsApiLaunchApplicationDirectly.1.1.1(this));
    if (!bo.isNullOrNil(this.hyw.hya))
    {
      localObject4 = new Intent("android.intent.action.VIEW", Uri.parse(this.hyw.hya));
      ((Intent)localObject4).addFlags(268435456);
      localObject1 = bo.H(this.hyw.bAW.getContext(), (Intent)localObject4);
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        if ((TextUtils.isEmpty(((Intent)localObject4).getPackage())) && (((List)localObject1).size() == 1)) {}
        for (localObject1 = g.b((ResolveInfo)((List)localObject1).get(0)); !bo.nullAsNil(ah.getPackageName()).equals(localObject1); localObject1 = ((Intent)localObject4).getPackage())
        {
          al.d(new JsApiLaunchApplicationDirectly.1.1.2(this, (Intent)localObject4, (axg)localObject2, (JsApiLaunchApplicationDirectly.a)localObject3));
          AppMethodBeat.o(130455);
          return;
        }
      }
    }
    Object localObject1 = new JsApiLaunchApplicationDirectly.LaunchApplicationTask((MMActivity)this.hyw.bAW.getContext());
    ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject1).appId = this.hyw.hye;
    ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject1).hym = this.hyw.hyd;
    ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject1).extInfo = this.hyw.hyf;
    ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject1).cpJ = this.hyw.hyb;
    ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject1).showType = ((axg)localObject2).xmD;
    ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject1).hxp = new JsApiLaunchApplicationDirectly.1.1.3(this, (JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject1);
    ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject1).aBj();
    ((JsApiLaunchApplicationDirectly.LaunchApplicationTask)localObject1).aBi();
    AppMethodBeat.o(130455);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplicationDirectly.1.1
 * JD-Core Version:    0.7.0.1
 */