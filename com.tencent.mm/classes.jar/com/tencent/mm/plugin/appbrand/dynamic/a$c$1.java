package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.modelappbrand.u;

final class a$c$1
  implements WxaWidgetInitializer.a
{
  a$c$1(a.c paramc, c paramc1) {}
  
  public final void a(String paramString1, String paramString2, boolean paramBoolean, WxaWidgetContext paramWxaWidgetContext)
  {
    AppMethodBeat.i(10647);
    Bundle localBundle = new Bundle();
    localBundle.putInt("op", 1);
    localBundle.putString("id", paramString1);
    localBundle.putString("appId", paramString2);
    localBundle.putBoolean("success", paramBoolean);
    if (paramWxaWidgetContext != null)
    {
      u.i("MicroMsg.DynamicIPCJsBridge", " OnInitializeCallback.onInitialized putContext %s", new Object[] { paramString1 });
      localBundle.putParcelable("fwContext", paramWxaWidgetContext);
      k.a(paramString1, paramWxaWidgetContext);
    }
    this.eEg.ad(localBundle);
    AppMethodBeat.o(10647);
  }
  
  public final void bL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(10646);
    Bundle localBundle = new Bundle();
    localBundle.putInt("op", 0);
    localBundle.putString("id", paramString1);
    localBundle.putString("appId", paramString2);
    this.eEg.ad(localBundle);
    AppMethodBeat.o(10646);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.a.c.1
 * JD-Core Version:    0.7.0.1
 */