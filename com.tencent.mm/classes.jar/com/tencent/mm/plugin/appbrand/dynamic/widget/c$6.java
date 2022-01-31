package com.tencent.mm.plugin.appbrand.dynamic.widget;

import com.tencent.mm.h.b.a.r;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.appbrand.canvas.widget.MHardwareAccelerateDrawableView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;

final class c$6
  implements com.tencent.mm.plugin.appbrand.canvas.c.a
{
  c$6(MHardwareAccelerateDrawableView paramMHardwareAccelerateDrawableView) {}
  
  public final void adR()
  {
    v.jdMethod_if(20);
    r localr = new r();
    localr.cjv = u.jy(this.fYl.getTraceId());
    localr.cjw = u.jx(this.fYl.getTraceId());
    localr.cjs = 12L;
    localr.cju = 1L;
    localr.cjr = this.fYl.getTraceId();
    localr.cjt = System.currentTimeMillis();
    localr.cjy = aq.fH(ae.getContext());
    localr.QX();
  }
  
  public final void ae(float paramFloat)
  {
    c.b(paramFloat, 2, this.fYl.getTraceId());
  }
  
  public final void af(float paramFloat)
  {
    c.b(paramFloat, 3, this.fYl.getTraceId());
  }
  
  public final void b(long paramLong1, long paramLong2, int paramInt)
  {
    com.tencent.mm.plugin.appbrand.widget.f.a.c(0, paramLong1, paramLong2, paramInt);
  }
  
  public final void cv(long paramLong)
  {
    com.tencent.mm.plugin.appbrand.widget.f.a.p(667, paramLong);
  }
  
  public final void cw(long paramLong)
  {
    com.tencent.mm.plugin.appbrand.widget.f.a.q(668, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.widget.c.6
 * JD-Core Version:    0.7.0.1
 */