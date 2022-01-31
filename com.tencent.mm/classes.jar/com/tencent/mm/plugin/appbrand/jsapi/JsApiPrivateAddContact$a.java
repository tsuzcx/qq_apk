package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.pluginsdk.ui.applet.n;
import com.tencent.mm.pluginsdk.ui.applet.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;

final class JsApiPrivateAddContact$a
  extends AppBrandProxyUIProcessTask
{
  public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    boolean bool = true;
    AppMethodBeat.i(73167);
    Object localObject = new JsApiPrivateAddContact.AddContactResult();
    if (!(paramProcessRequest instanceof JsApiPrivateAddContact.AddContactRequest))
    {
      ab.w("MicroMsg.JsApiPrivateAddContact", "handleRequest !(request instanceof AddContactRequest)");
      JsApiPrivateAddContact.AddContactResult.a((JsApiPrivateAddContact.AddContactResult)localObject, -1);
      a((AppBrandProxyUIProcessTask.ProcessResult)localObject);
      AppMethodBeat.o(73167);
      return;
    }
    paramProcessRequest = (JsApiPrivateAddContact.AddContactRequest)paramProcessRequest;
    com.tencent.mm.pluginsdk.g localg = (com.tencent.mm.pluginsdk.g)com.tencent.mm.kernel.g.E(com.tencent.mm.pluginsdk.g.class);
    MMActivity localMMActivity = aBf();
    String str = paramProcessRequest.userName;
    int i = paramProcessRequest.scene;
    localObject = new JsApiPrivateAddContact.a.1(this, (JsApiPrivateAddContact.AddContactResult)localObject);
    if (paramProcessRequest.hzv == 1) {}
    for (;;)
    {
      localg.a(localMMActivity, str, i, (n)localObject, bool, "").show();
      AppMethodBeat.o(73167);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiPrivateAddContact.a
 * JD-Core Version:    0.7.0.1
 */