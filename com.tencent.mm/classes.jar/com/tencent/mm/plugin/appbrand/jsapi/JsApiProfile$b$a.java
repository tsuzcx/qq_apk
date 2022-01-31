package com.tencent.mm.plugin.appbrand.jsapi;

import android.widget.Toast;
import com.tencent.mm.ag.b;
import com.tencent.mm.ag.c;
import com.tencent.mm.ag.o;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.model.am.b.a;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;

final class JsApiProfile$b$a
  implements am.b.a
{
  JsApiProfile$b$a(JsApiProfile.b paramb, JsApiProfile.ProfileResult paramProfileResult, p paramp, int paramInt) {}
  
  public final void m(String paramString, boolean paramBoolean)
  {
    if (JsApiProfile.b.a(this.gha) == null)
    {
      y.w("MicroMsg.JsApiProfile", "getNow callback, msghandler has already been detached!");
      this.ghb.aYY = 0;
      JsApiProfile.b.a(this.gha, (AppBrandProxyUIProcessTask.ProcessResult)this.ghb);
      return;
    }
    Object localObject = this.ghc;
    if (localObject != null) {
      ((p)localObject).dismiss();
    }
    localObject = com.tencent.mm.kernel.g.r(j.class);
    a.d.b.g.j(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    localObject = ((j)localObject).Fw().abl(paramString);
    if ((localObject == null) || (((ad)localObject).Bo() <= 0))
    {
      a locala = com.tencent.mm.kernel.g.r(j.class);
      a.d.b.g.j(locala, "MMKernel.service(IMessengerStorage::class.java)");
      ((j)locala).Fw().abh(paramString);
      paramBoolean = false;
    }
    while (!paramBoolean)
    {
      Toast.makeText(ae.getContext(), (CharSequence)JsApiProfile.b.a(this.gha).getString(y.j.fmt_self_qrcode_getting_err, new Object[] { Integer.valueOf(3), Integer.valueOf(-1) }), 0).show();
      this.ghb.aYY = 0;
      JsApiProfile.b.a(this.gha, (AppBrandProxyUIProcessTask.ProcessResult)this.ghb);
      return;
      paramString = ((ad)localObject).getUsername();
    }
    b.M(paramString, 3);
    o.Kj().kb(paramString);
    if (localObject == null) {
      a.d.b.g.cUk();
    }
    if (((ad)localObject).cua())
    {
      h.nFQ.aC(10298, ((ad)localObject).getUsername() + "," + this.ghd);
      this.ghb.ggZ |= 0x1;
    }
    this.ghb.aYY = 1;
    JsApiProfile.b.a(this.gha, (AppBrandProxyUIProcessTask.ProcessResult)this.ghb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiProfile.b.a
 * JD-Core Version:    0.7.0.1
 */