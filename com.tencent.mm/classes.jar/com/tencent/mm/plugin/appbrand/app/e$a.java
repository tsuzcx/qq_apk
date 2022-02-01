package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.jsapi.auth.g.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/app/AppBrandUserInfoProvider$IPCGetHeadIconPath;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
public final class e$a
  implements b<IPCVoid, IPCString>
{
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/app/AppBrandUserInfoProvider$IPCGetHeadIconPath$invoke$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeHelper$GetHeadIconPathCallback;", "onCallback", "", "path", "", "plugin-appbrand-integration_release"})
  public static final class a
    implements g.b
  {
    a(d paramd) {}
    
    public final void Lz(String paramString)
    {
      AppMethodBeat.i(175105);
      d locald = this.jGI;
      if (locald != null)
      {
        locald.be(new IPCString(paramString));
        AppMethodBeat.o(175105);
        return;
      }
      AppMethodBeat.o(175105);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.e.a
 * JD-Core Version:    0.7.0.1
 */