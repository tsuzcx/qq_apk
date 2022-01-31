package com.tencent.mm.plugin.appbrand.dynamic.h;

import com.tencent.mm.aa.a.a;
import com.tencent.mm.h.b.a.r;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetContext;
import com.tencent.mm.plugin.appbrand.dynamic.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;

final class e$3
  implements a.a
{
  e$3(WxaWidgetContext paramWxaWidgetContext) {}
  
  public final void Cu()
  {
    v.jdMethod_if(14);
    r localr = new r();
    localr.cjv = u.jy(this.fXc.getId());
    localr.cjw = u.jx(this.fXc.getId());
    localr.cjs = 7L;
    localr.cju = 1L;
    localr.cjr = this.fXc.getId();
    localr.cjt = System.currentTimeMillis();
    localr.cjy = aq.fH(ae.getContext());
    localr.QX();
    h.nFQ.a(636L, 4L, 1L, false);
    j.aeZ().ta(this.fXc.getId());
  }
  
  public final void fM(String paramString)
  {
    v.jdMethod_if(15);
    r localr = new r();
    localr.cjv = u.jy(this.fXc.getId());
    localr.cjw = u.jx(this.fXc.getId());
    localr.cjs = 7L;
    localr.cju = 2L;
    localr.cjr = this.fXc.getId();
    localr.cjt = System.currentTimeMillis();
    localr.QX();
    h.nFQ.a(636L, 5L, 1L, false);
    y.e("MicroMsg.PreloadOptimizer", "Inject External widget Script Failed: %s", new Object[] { paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.h.e.3
 * JD-Core Version:    0.7.0.1
 */