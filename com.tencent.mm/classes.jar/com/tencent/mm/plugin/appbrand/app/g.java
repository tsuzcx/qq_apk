package com.tencent.mm.plugin.appbrand.app;

import com.tencent.luggage.sdk.g.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/app/AppBrandUserInfoProvider;", "Lcom/tencent/luggage/sdk/userinfo/IWechatUserInfoProvider;", "()V", "getUserAvatarHDHeadImage", "", "callback", "Lcom/tencent/luggage/sdk/userinfo/IWechatUserInfoProvider$OnGetImagePathCallback;", "getUserDisplayNickName", "", "IPCGetHeadIconPath", "IPCGetUserDisplayNickName", "plugin-appbrand-integration_release"})
public final class g
  implements com.tencent.luggage.sdk.g.a
{
  public static final g nCu;
  
  static
  {
    AppMethodBeat.i(175112);
    nCu = new g();
    AppMethodBeat.o(175112);
  }
  
  public final String Sy()
  {
    AppMethodBeat.i(175111);
    Object localObject = (IPCString)XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, IPCVoid.jZu, g.b.class);
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
    p.k(paramb, "callback");
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, IPCVoid.jZu, g.a.class, (f)new c(paramb));
    AppMethodBeat.o(175110);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "path", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class c<T>
    implements f<ResultType>
  {
    c(a.b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.g
 * JD-Core Version:    0.7.0.1
 */