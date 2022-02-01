package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.modelappbrand.u;

final class a$c$1
  implements WxaWidgetInitializer.a
{
  a$c$1(a.c paramc, f paramf) {}
  
  public final void a(String paramString1, String paramString2, boolean paramBoolean, WxaWidgetContext paramWxaWidgetContext)
  {
    AppMethodBeat.i(121128);
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
    this.val$callback.aH(localBundle);
    AppMethodBeat.o(121128);
  }
  
  public final void dg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121127);
    Bundle localBundle = new Bundle();
    localBundle.putInt("op", 0);
    localBundle.putString("id", paramString1);
    localBundle.putString("appId", paramString2);
    this.val$callback.aH(localBundle);
    AppMethodBeat.o(121127);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.a.c.1
 * JD-Core Version:    0.7.0.1
 */