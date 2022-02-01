package com.tencent.mm.plugin.appbrand.app;

import com.tencent.luggage.sdk.g.a;
import com.tencent.luggage.sdk.g.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.modelavatar.AvatarStorage;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/app/AppBrandUserInfoProvider;", "Lcom/tencent/luggage/sdk/userinfo/IWechatUserInfoProvider;", "()V", "getUserAvatarHDHeadImage", "", "callback", "Lcom/tencent/luggage/sdk/userinfo/IWechatUserInfoProvider$OnGetImagePathCallback;", "getUserDisplayNickName", "", "IPCGetHeadIconPath", "IPCGetUserDisplayNickName", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  implements a
{
  public static final g qBP;
  
  static
  {
    AppMethodBeat.i(175112);
    qBP = new g();
    AppMethodBeat.o(175112);
  }
  
  private static final void a(a.a parama, IPCString paramIPCString)
  {
    AppMethodBeat.i(317796);
    s.u(parama, "$callback");
    if (paramIPCString == null) {
      paramIPCString = null;
    }
    for (;;)
    {
      if (paramIPCString == null)
      {
        s.u(parama, "$callback");
        parama.onGetImagePath(null);
      }
      AppMethodBeat.o(317796);
      return;
      paramIPCString = paramIPCString.value;
      if (paramIPCString == null)
      {
        paramIPCString = null;
      }
      else
      {
        parama.onGetImagePath(AvatarStorage.LL(paramIPCString));
        paramIPCString = ah.aiuX;
      }
    }
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(175110);
    s.u(parama, "callback");
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, IPCVoid.mzv, g.a.class, new g..ExternalSyntheticLambda0(parama));
    AppMethodBeat.o(175110);
  }
  
  public final String asO()
  {
    AppMethodBeat.i(175111);
    Object localObject = (IPCString)XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, IPCVoid.mzv, g.b.class);
    if (localObject == null)
    {
      AppMethodBeat.o(175111);
      return null;
    }
    localObject = ((IPCString)localObject).value;
    AppMethodBeat.o(175111);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.g
 * JD-Core Version:    0.7.0.1
 */