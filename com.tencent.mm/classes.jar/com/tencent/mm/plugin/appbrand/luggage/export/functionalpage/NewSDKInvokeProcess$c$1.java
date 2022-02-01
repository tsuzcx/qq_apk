package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.Resp;
import com.tencent.mm.plugin.appbrand.ae.a.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.fakenative.f;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.a.b;
import d.g.b.p;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"returnToApp", "", "retMsg", "", "invoke"})
final class NewSDKInvokeProcess$c$1
  extends d.g.b.q
  implements b<String, z>
{
  NewSDKInvokeProcess$c$1(NewSDKInvokeProcess.NewSdkInvokeBackData paramNewSdkInvokeBackData, d paramd)
  {
    super(1);
  }
  
  private void invoke(String paramString)
  {
    AppMethodBeat.i(189378);
    Object localObject1 = a.a.nqe;
    localObject1 = this.lOO.lOK.invokeTicket;
    if (localObject1 == null) {
      p.gfZ();
    }
    a.a.VH((String)localObject1);
    localObject1 = new Bundle();
    Object localObject2 = new WXLaunchWxaRedirectingPage.Resp(Bundle.EMPTY);
    String str = this.lOO.lOK.invokeTicket;
    if (str == null) {
      p.gfZ();
    }
    ((WXLaunchWxaRedirectingPage.Resp)localObject2).invokeTicket = str;
    ((WXLaunchWxaRedirectingPage.Resp)localObject2).callbackActivity = this.lOO.lOK.callbackActivity;
    ((WXLaunchWxaRedirectingPage.Resp)localObject2).errStr = paramString;
    ((WXLaunchWxaRedirectingPage.Resp)localObject2).toBundle((Bundle)localObject1);
    com.tencent.mm.pluginsdk.model.app.q.bb((Bundle)localObject1);
    com.tencent.mm.pluginsdk.model.app.q.bc((Bundle)localObject1);
    paramString = aj.getContext();
    localObject2 = new MMessageActV2.Args();
    ((MMessageActV2.Args)localObject2).targetPkgName = this.lOO.lOK.packageName;
    ((MMessageActV2.Args)localObject2).bundle = ((Bundle)localObject1);
    MMessageActV2.send(paramString, (MMessageActV2.Args)localObject2);
    paramString = this.jDK;
    if (paramString != null)
    {
      f.a(paramString);
      AppMethodBeat.o(189378);
      return;
    }
    AppMethodBeat.o(189378);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.NewSDKInvokeProcess.c.1
 * JD-Core Version:    0.7.0.1
 */