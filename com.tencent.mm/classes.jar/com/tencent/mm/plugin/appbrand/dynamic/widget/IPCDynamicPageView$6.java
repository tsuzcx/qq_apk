package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.plugin.appbrand.dynamic.a.e;
import com.tencent.mm.plugin.appbrand.dynamic.i;

final class IPCDynamicPageView$6
  implements Runnable
{
  IPCDynamicPageView$6(IPCDynamicPageView paramIPCDynamicPageView) {}
  
  public final void run()
  {
    AppMethodBeat.i(11042);
    IPCDynamicPageView.f(this.hro);
    String str = IPCDynamicPageView.e(this.hro);
    Bundle localBundle = new Bundle();
    localBundle.putString("id", str);
    f.a(i.azB().AY(str), localBundle, a.e.class, null);
    AppMethodBeat.o(11042);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView.6
 * JD-Core Version:    0.7.0.1
 */