package com.tencent.mm.plugin.appbrand.app;

import com.tencent.luggage.sdk.f.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.jsapi.auth.g.b;
import d.g.b.k;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/app/AppBrandUserInfoProvider;", "Lcom/tencent/luggage/sdk/userinfo/IWechatUserInfoProvider;", "()V", "getUserAvatarHDHeadImage", "", "callback", "Lcom/tencent/luggage/sdk/userinfo/IWechatUserInfoProvider$OnGetImagePathCallback;", "getUserDisplayNickName", "", "IPCGetHeadIconPath", "IPCGetUserDisplayNickName", "plugin-appbrand-integration_release"})
public final class e
  implements com.tencent.luggage.sdk.f.a
{
  public static final e jjT;
  
  static
  {
    AppMethodBeat.i(175112);
    jjT = new e();
    AppMethodBeat.o(175112);
  }
  
  public final String DN()
  {
    AppMethodBeat.i(175111);
    Object localObject = (IPCString)XIPCInvoker.a("com.tencent.mm", IPCVoid.gey, e.b.class);
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
    k.h(paramb, "callback");
    XIPCInvoker.a("com.tencent.mm", IPCVoid.gey, a.class, (d)new c(paramb));
    AppMethodBeat.o(175110);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/app/AppBrandUserInfoProvider$IPCGetHeadIconPath;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
  public static final class a
    implements b<IPCVoid, IPCString>
  {
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/app/AppBrandUserInfoProvider$IPCGetHeadIconPath$invoke$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeHelper$GetHeadIconPathCallback;", "onCallback", "", "path", "", "plugin-appbrand-integration_release"})
    public static final class a
      implements g.b
    {
      a(d paramd) {}
      
      public final void HH(String paramString)
      {
        AppMethodBeat.i(175105);
        d locald = this.jjU;
        if (locald != null)
        {
          locald.bc(new IPCString(paramString));
          AppMethodBeat.o(175105);
          return;
        }
        AppMethodBeat.o(175105);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "path", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class c<T>
    implements d<ResultType>
  {
    c(a.b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.e
 * JD-Core Version:    0.7.0.1
 */