package com.tencent.mm.plugin.appbrand.app;

import com.tencent.luggage.sdk.f.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/app/AppBrandUserInfoProvider;", "Lcom/tencent/luggage/sdk/userinfo/IWechatUserInfoProvider;", "()V", "getUserAvatarHDHeadImage", "", "callback", "Lcom/tencent/luggage/sdk/userinfo/IWechatUserInfoProvider$OnGetImagePathCallback;", "getUserDisplayNickName", "", "IPCGetHeadIconPath", "IPCGetUserDisplayNickName", "plugin-appbrand-integration_release"})
public final class g
  implements com.tencent.luggage.sdk.f.a
{
  public static final g kIF;
  
  static
  {
    AppMethodBeat.i(175112);
    kIF = new g();
    AppMethodBeat.o(175112);
  }
  
  public final String Pa()
  {
    AppMethodBeat.i(175111);
    Object localObject = (IPCString)XIPCInvoker.a(MainProcessIPCService.dkO, IPCVoid.hnE, g.b.class);
    if (localObject != null)
    {
      localObject = ((IPCString)localObject).value;
      AppMethodBeat.o(175111);
      return localObject;
    }
    AppMethodBeat.o(175111);
    return null;
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(175110);
    p.h(paramb, "callback");
    XIPCInvoker.a(MainProcessIPCService.dkO, IPCVoid.hnE, g.a.class, (d)new c(paramb));
    AppMethodBeat.o(175110);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "path", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class c<T>
    implements d<ResultType>
  {
    c(a.b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.g
 * JD-Core Version:    0.7.0.1
 */