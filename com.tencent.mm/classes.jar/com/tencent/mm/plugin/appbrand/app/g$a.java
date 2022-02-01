package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.jsapi.auth.h.b;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/app/AppBrandUserInfoProvider$IPCGetHeadIconPath;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g$a
  implements d<IPCVoid, IPCString>
{
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/app/AppBrandUserInfoProvider$IPCGetHeadIconPath$invoke$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeHelper$GetHeadIconPathCallback;", "onCallback", "", "path", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements h.b
  {
    a(f<IPCString> paramf) {}
    
    public final void onCallback(String paramString)
    {
      AppMethodBeat.i(175105);
      f localf = this.mht;
      if (localf != null) {
        localf.onCallback(new IPCString(paramString));
      }
      AppMethodBeat.o(175105);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.g.a
 * JD-Core Version:    0.7.0.1
 */