package com.tencent.mm.plugin.appbrand.ui.autofill;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ccl;
import com.tencent.mm.protocal.protobuf.cik;
import com.tencent.mm.protocal.protobuf.cil;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.p;

final class AppBrandIDCardUI$1$4
  implements com.tencent.mm.plugin.appbrand.jsapi.m.b.b
{
  AppBrandIDCardUI$1$4(AppBrandIDCardUI.1 param1) {}
  
  public final void j(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(133218);
    if (paramBoolean)
    {
      h.qsU.e(14943, new Object[] { AppBrandIDCardUI.a(this.iQA.iQz), Integer.valueOf(4), AppBrandIDCardUI.g(this.iQA.iQz).crs });
      Object localObject = new b.a();
      ((b.a)localObject).fsX = new cik();
      ((b.a)localObject).fsY = new cil();
      ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/userdata/submitauthorizeuserid";
      ((b.a)localObject).funcId = 1721;
      ((b.a)localObject).reqCmdId = 0;
      ((b.a)localObject).respCmdId = 0;
      localObject = ((b.a)localObject).ado();
      cik localcik = (cik)((com.tencent.mm.ai.b)localObject).fsV.fta;
      localcik.cwc = AppBrandIDCardUI.a(this.iQA.iQz);
      localcik.xLl = AppBrandIDCardUI.b(this.iQA.iQz);
      localcik.xLm = paramString;
      localcik.crs = AppBrandIDCardUI.g(this.iQA.iQz).crs;
      AppBrandIDCardUI.d(this.iQA.iQz).show();
      com.tencent.mm.ipcinvoker.wx_extension.b.a((com.tencent.mm.ai.b)localObject, new AppBrandIDCardUI.1.4.1(this, paramString));
    }
    ab.i("MicroMsg.AppBrandIDCardUI", "verifyOk:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(133218);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.1.4
 * JD-Core Version:    0.7.0.1
 */