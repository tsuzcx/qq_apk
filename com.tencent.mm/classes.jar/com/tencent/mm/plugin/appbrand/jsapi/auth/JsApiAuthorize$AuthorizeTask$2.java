package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.d;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.permission.m;
import com.tencent.mm.plugin.appbrand.widget.b.l;
import com.tencent.mm.protocal.protobuf.bwv;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

final class JsApiAuthorize$AuthorizeTask$2
  implements Runnable
{
  JsApiAuthorize$AuthorizeTask$2(JsApiAuthorize.AuthorizeTask paramAuthorizeTask, LinkedList paramLinkedList) {}
  
  public final void run()
  {
    AppMethodBeat.i(130834);
    bwv localbwv = (bwv)this.hDM.get(0);
    com.tencent.mm.plugin.appbrand.i locali = this.hDK.hDv.getRuntime();
    boolean bool = m.a(localbwv.wAh, locali.wY());
    com.tencent.mm.plugin.appbrand.widget.b.i locali1 = new com.tencent.mm.plugin.appbrand.widget.b.i(locali.atj().getContext(), new JsApiAuthorize.AuthorizeTask.2.1(this));
    locali1.FG(locali.wY().cqQ);
    locali1.FJ(this.hDK.hDC);
    locali1.FH(localbwv.Desc);
    locali1.FK(this.hDK.hDD);
    locali1.FL(this.hDK.hDE);
    locali1.ka(this.hDK.hDB);
    if ("scope.userInfo".equals(localbwv.wAh))
    {
      e.a locala = e.hDq;
      e.a.a(this.hDK.hDv.getContext(), d.rd(this.hDK.hDF), this.hDK.hDG, localbwv.wAh, locali1);
    }
    while (bool) {
      if (TextUtils.isEmpty(m.a(localbwv.wAh, locali)))
      {
        JsApiAuthorize.AuthorizeTask.a(this.hDK, "fail:require permission desc");
        ab.i("MicroMsg.JsApiAuthorize", "error = fail:require permission desc");
        AppMethodBeat.o(130834);
        return;
        locali1.FM(localbwv.wAh);
      }
      else
      {
        locali1.FI(m.a(localbwv.wAh, locali));
      }
    }
    ab.i("MicroMsg.JsApiAuthorize", "Confirm dialog scope=%s desc =%s auth_desc=%s ext_desc=%s", new Object[] { localbwv.wAh, localbwv.Desc, localbwv.xmp, localbwv.iEA });
    locali.gPE.b(locali1);
    AppMethodBeat.o(130834);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize.AuthorizeTask.2
 * JD-Core Version:    0.7.0.1
 */