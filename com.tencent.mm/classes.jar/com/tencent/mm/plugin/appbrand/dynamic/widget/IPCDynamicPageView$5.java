package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.plugin.appbrand.dynamic.a.d;
import com.tencent.mm.plugin.appbrand.dynamic.i;

final class IPCDynamicPageView$5
  implements Runnable
{
  IPCDynamicPageView$5(IPCDynamicPageView paramIPCDynamicPageView) {}
  
  public final void run()
  {
    IPCDynamicPageView.f(this.fXO);
    String str = IPCDynamicPageView.e(this.fXO);
    Bundle localBundle = new Bundle();
    localBundle.putString("id", str);
    f.a(i.aeX().sX(str), localBundle, a.d.class, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView.5
 * JD-Core Version:    0.7.0.1
 */