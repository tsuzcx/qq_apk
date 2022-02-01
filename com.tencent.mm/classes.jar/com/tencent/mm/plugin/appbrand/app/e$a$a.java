package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.appbrand.jsapi.auth.g.b;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/app/AppBrandUserInfoProvider$IPCGetHeadIconPath$invoke$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeHelper$GetHeadIconPathCallback;", "onCallback", "", "path", "", "plugin-appbrand-integration_release"})
public final class e$a$a
  implements g.b
{
  e$a$a(d paramd) {}
  
  public final void KZ(String paramString)
  {
    AppMethodBeat.i(175105);
    d locald = this.jDK;
    if (locald != null)
    {
      locald.be(new IPCString(paramString));
      AppMethodBeat.o(175105);
      return;
    }
    AppMethodBeat.o(175105);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.e.a.a
 * JD-Core Version:    0.7.0.1
 */