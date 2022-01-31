package com.tencent.mm.plugin.appbrand.dynamic.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.canvas.widget.MCanvasView;

final class b$4
  implements com.tencent.mm.plugin.appbrand.canvas.c.a
{
  b$4(MCanvasView paramMCanvasView) {}
  
  public final void ap(float paramFloat)
  {
    AppMethodBeat.i(11104);
    b.b(paramFloat, 2, this.hrv.getTraceId());
    AppMethodBeat.o(11104);
  }
  
  public final void aq(float paramFloat)
  {
    AppMethodBeat.i(11105);
    b.b(paramFloat, 3, this.hrv.getTraceId());
    AppMethodBeat.o(11105);
  }
  
  public final void ayj()
  {
    AppMethodBeat.i(11106);
    u.ql(this.hrv.getTraceId());
    AppMethodBeat.o(11106);
  }
  
  public final void b(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(11103);
    com.tencent.mm.plugin.appbrand.widget.g.a.d(3, paramLong1, paramLong2, paramInt);
    AppMethodBeat.o(11103);
  }
  
  public final void hu(long paramLong)
  {
    AppMethodBeat.i(11101);
    com.tencent.mm.plugin.appbrand.widget.g.a.D(685, paramLong);
    AppMethodBeat.o(11101);
  }
  
  public final void hv(long paramLong)
  {
    AppMethodBeat.i(11102);
    com.tencent.mm.plugin.appbrand.widget.g.a.E(684, paramLong);
    AppMethodBeat.o(11102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.widget.b.4
 * JD-Core Version:    0.7.0.1
 */