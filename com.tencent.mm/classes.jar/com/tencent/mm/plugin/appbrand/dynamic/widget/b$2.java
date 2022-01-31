package com.tencent.mm.plugin.appbrand.dynamic.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.canvas.widget.MTextureView;

final class b$2
  implements com.tencent.mm.plugin.appbrand.canvas.c.a
{
  b$2(MTextureView paramMTextureView) {}
  
  public final void ap(float paramFloat)
  {
    AppMethodBeat.i(11092);
    b.b(paramFloat, 2, this.hrt.getTraceId());
    AppMethodBeat.o(11092);
  }
  
  public final void aq(float paramFloat)
  {
    AppMethodBeat.i(11093);
    b.b(paramFloat, 3, this.hrt.getTraceId());
    AppMethodBeat.o(11093);
  }
  
  public final void ayj()
  {
    AppMethodBeat.i(11094);
    u.ql(this.hrt.getTraceId());
    AppMethodBeat.o(11094);
  }
  
  public final void b(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(11091);
    com.tencent.mm.plugin.appbrand.widget.g.a.d(1, paramLong1, paramLong2, paramInt);
    AppMethodBeat.o(11091);
  }
  
  public final void hu(long paramLong)
  {
    AppMethodBeat.i(11089);
    com.tencent.mm.plugin.appbrand.widget.g.a.D(682, paramLong);
    AppMethodBeat.o(11089);
  }
  
  public final void hv(long paramLong)
  {
    AppMethodBeat.i(11090);
    com.tencent.mm.plugin.appbrand.widget.g.a.E(683, paramLong);
    AppMethodBeat.o(11090);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.widget.b.2
 * JD-Core Version:    0.7.0.1
 */