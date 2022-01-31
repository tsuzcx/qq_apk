package com.tencent.mm.plugin.appbrand.dynamic.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.canvas.widget.MHardwareAccelerateDrawableView;

final class b$6
  implements com.tencent.mm.plugin.appbrand.canvas.c.a
{
  b$6(MHardwareAccelerateDrawableView paramMHardwareAccelerateDrawableView) {}
  
  public final void ap(float paramFloat)
  {
    AppMethodBeat.i(11116);
    b.b(paramFloat, 2, this.hrx.getTraceId());
    AppMethodBeat.o(11116);
  }
  
  public final void aq(float paramFloat)
  {
    AppMethodBeat.i(11117);
    b.b(paramFloat, 3, this.hrx.getTraceId());
    AppMethodBeat.o(11117);
  }
  
  public final void ayj()
  {
    AppMethodBeat.i(11118);
    u.ql(this.hrx.getTraceId());
    AppMethodBeat.o(11118);
  }
  
  public final void b(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(11115);
    com.tencent.mm.plugin.appbrand.widget.g.a.d(0, paramLong1, paramLong2, paramInt);
    AppMethodBeat.o(11115);
  }
  
  public final void hu(long paramLong)
  {
    AppMethodBeat.i(11113);
    com.tencent.mm.plugin.appbrand.widget.g.a.D(667, paramLong);
    AppMethodBeat.o(11113);
  }
  
  public final void hv(long paramLong)
  {
    AppMethodBeat.i(11114);
    com.tencent.mm.plugin.appbrand.widget.g.a.E(668, paramLong);
    AppMethodBeat.o(11114);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.widget.b.6
 * JD-Core Version:    0.7.0.1
 */