package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.pluginsdk.ui.applet.n;
import com.tencent.mm.pluginsdk.ui.applet.o;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;

final class JsApiPrivateAddContact$a
  extends AppBrandProxyUIProcessTask
{
  protected final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    boolean bool = true;
    Object localObject = new JsApiPrivateAddContact.AddContactResult();
    if (!(paramProcessRequest instanceof JsApiPrivateAddContact.AddContactRequest))
    {
      y.w("MicroMsg.JsApiPrivateAddContact", "handleRequest !(request instanceof AddContactRequest)");
      JsApiPrivateAddContact.AddContactResult.a((JsApiPrivateAddContact.AddContactResult)localObject, -1);
      a((AppBrandProxyUIProcessTask.ProcessResult)localObject);
      return;
    }
    paramProcessRequest = (JsApiPrivateAddContact.AddContactRequest)paramProcessRequest;
    f localf = (f)g.r(f.class);
    MMActivity localMMActivity = ahy();
    String str = paramProcessRequest.userName;
    int i = paramProcessRequest.scene;
    localObject = new JsApiPrivateAddContact.a.1(this, (JsApiPrivateAddContact.AddContactResult)localObject);
    if (paramProcessRequest.ggV == 1) {}
    for (;;)
    {
      localf.a(localMMActivity, str, i, (n)localObject, bool, "").show();
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiPrivateAddContact.a
 * JD-Core Version:    0.7.0.1
 */