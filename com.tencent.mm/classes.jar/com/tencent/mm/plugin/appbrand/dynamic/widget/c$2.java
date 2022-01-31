package com.tencent.mm.plugin.appbrand.dynamic.widget;

import com.tencent.mm.h.b.a.r;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.canvas.widget.MTextureView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;

final class c$2
  implements com.tencent.mm.plugin.appbrand.canvas.c.a
{
  c$2(MTextureView paramMTextureView) {}
  
  public final void adR()
  {
    v.jdMethod_if(20);
    r localr = new r();
    localr.cjv = u.jy(this.fYh.getTraceId());
    localr.cjw = u.jx(this.fYh.getTraceId());
    localr.cjs = 12L;
    localr.cju = 1L;
    localr.cjr = this.fYh.getTraceId();
    localr.cjt = System.currentTimeMillis();
    localr.cjy = aq.fH(ae.getContext());
    localr.QX();
  }
  
  public final void ae(float paramFloat)
  {
    c.b(paramFloat, 2, this.fYh.getTraceId());
  }
  
  public final void af(float paramFloat)
  {
    c.b(paramFloat, 3, this.fYh.getTraceId());
  }
  
  public final void b(long paramLong1, long paramLong2, int paramInt)
  {
    com.tencent.mm.plugin.appbrand.widget.f.a.c(1, paramLong1, paramLong2, paramInt);
  }
  
  public final void cv(long paramLong)
  {
    com.tencent.mm.plugin.appbrand.widget.f.a.p(682, paramLong);
  }
  
  public final void cw(long paramLong)
  {
    com.tencent.mm.plugin.appbrand.widget.f.a.q(683, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.widget.c.2
 * JD-Core Version:    0.7.0.1
 */