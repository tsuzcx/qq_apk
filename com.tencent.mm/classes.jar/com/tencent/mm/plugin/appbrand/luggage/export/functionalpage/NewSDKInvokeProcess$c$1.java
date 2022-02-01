package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.Resp;
import com.tencent.mm.plugin.appbrand.ac.a.a.a;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.a.b;
import d.g.b.p;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"returnToApp", "", "retMsg", "", "invoke"})
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
    AppMethodBeat.i(223638);
    Object localObject1 = a.a.nvx;
    localObject1 = this.lTp.lTl.invokeTicket;
    if (localObject1 == null) {
      p.gkB();
    }
    a.a.Wt((String)localObject1);
    localObject1 = new Bundle();
    Object localObject2 = new WXLaunchWxaRedirectingPage.Resp(Bundle.EMPTY);
    String str = this.lTp.lTl.invokeTicket;
    if (str == null) {
      p.gkB();
    }
    ((WXLaunchWxaRedirectingPage.Resp)localObject2).invokeTicket = str;
    ((WXLaunchWxaRedirectingPage.Resp)localObject2).callbackActivity = this.lTp.lTl.callbackActivity;
    ((WXLaunchWxaRedirectingPage.Resp)localObject2).errStr = paramString;
    ((WXLaunchWxaRedirectingPage.Resp)localObject2).toBundle((Bundle)localObject1);
    com.tencent.mm.pluginsdk.model.app.q.bc((Bundle)localObject1);
    com.tencent.mm.pluginsdk.model.app.q.bd((Bundle)localObject1);
    paramString = ak.getContext();
    localObject2 = new MMessageActV2.Args();
    ((MMessageActV2.Args)localObject2).targetPkgName = this.lTp.lTl.packageName;
    ((MMessageActV2.Args)localObject2).bundle = ((Bundle)localObject1);
    MMessageActV2.send(paramString, (MMessageActV2.Args)localObject2);
    paramString = this.jGI;
    if (paramString != null)
    {
      a.a(paramString);
      AppMethodBeat.o(223638);
      return;
    }
    AppMethodBeat.o(223638);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.NewSDKInvokeProcess.c.1
 * JD-Core Version:    0.7.0.1
 */