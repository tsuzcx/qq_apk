package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v.b;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.dynamic.a.a;
import com.tencent.mm.plugin.appbrand.dynamic.e;
import com.tencent.mm.plugin.appbrand.dynamic.i;
import com.tencent.mm.plugin.appbrand.dynamic.j.b;

final class IPCDynamicPageView$4
  implements Runnable
{
  IPCDynamicPageView$4(IPCDynamicPageView paramIPCDynamicPageView, Bundle paramBundle, String paramString1, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(11040);
    String str1 = "";
    if (this.hmS != null) {
      str1 = this.hmS.getString("cache_key", "");
    }
    u.i("MicroMsg.IPCDynamicPageView", "prepare(%s, %s)", new Object[] { this.val$id, this.val$appId });
    IPCDynamicPageView.a(this.hro, b.Bp(this.val$id));
    if (IPCDynamicPageView.g(this.hro) == null) {
      IPCDynamicPageView.a(this.hro, new com.tencent.mm.plugin.appbrand.widget.f());
    }
    IPCDynamicPageView.g(this.hro).field_id = this.val$id;
    IPCDynamicPageView.g(this.hro).field_cacheKey = str1;
    IPCDynamicPageView.g(this.hro).field_appId = u.qn(IPCDynamicPageView.e(this.hro));
    this.hro.getDrawContext().eGu.i("id", this.val$id);
    e.azy().b(this.val$id, this.hro);
    if (this.hmS != null) {
      this.hmS.putBundle("__env_args", IPCDynamicPageView.b(this.hro, this.hmS));
    }
    IPCDynamicPageView.f(this.hro);
    str1 = this.val$id;
    String str2 = this.val$appId;
    Bundle localBundle1 = this.hmS;
    Bundle localBundle2 = new Bundle();
    localBundle2.putString("id", str1);
    localBundle2.putString("appId", str2);
    localBundle2.putBundle("extData", localBundle1);
    u.i("MicroMsg.DynamicIPCJsBridge", "before IPCInvoke_AttachTo invoke", new Object[0]);
    com.tencent.mm.ipcinvoker.f.a(i.azB().AY(str1), localBundle2, a.a.class, null);
    AppMethodBeat.o(11040);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView.4
 * JD-Core Version:    0.7.0.1
 */