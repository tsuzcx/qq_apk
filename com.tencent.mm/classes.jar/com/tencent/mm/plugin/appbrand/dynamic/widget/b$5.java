package com.tencent.mm.plugin.appbrand.dynamic.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.canvas.widget.MDrawableView;

final class b$5
  implements com.tencent.mm.plugin.appbrand.canvas.c.a
{
  b$5(MDrawableView paramMDrawableView) {}
  
  public final void ap(float paramFloat)
  {
    AppMethodBeat.i(11110);
    b.b(paramFloat, 2, this.hrw.getTraceId());
    AppMethodBeat.o(11110);
  }
  
  public final void aq(float paramFloat)
  {
    AppMethodBeat.i(11111);
    b.b(paramFloat, 3, this.hrw.getTraceId());
    AppMethodBeat.o(11111);
  }
  
  public final void ayj()
  {
    AppMethodBeat.i(11112);
    u.ql(this.hrw.getTraceId());
    AppMethodBeat.o(11112);
  }
  
  public final void b(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(11109);
    com.tencent.mm.plugin.appbrand.widget.g.a.d(4, paramLong1, paramLong2, paramInt);
    AppMethodBeat.o(11109);
  }
  
  public final void hu(long paramLong)
  {
    AppMethodBeat.i(11107);
    com.tencent.mm.plugin.appbrand.widget.g.a.D(667, paramLong);
    AppMethodBeat.o(11107);
  }
  
  public final void hv(long paramLong)
  {
    AppMethodBeat.i(11108);
    com.tencent.mm.plugin.appbrand.widget.g.a.E(668, paramLong);
    AppMethodBeat.o(11108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.widget.b.5
 * JD-Core Version:    0.7.0.1
 */