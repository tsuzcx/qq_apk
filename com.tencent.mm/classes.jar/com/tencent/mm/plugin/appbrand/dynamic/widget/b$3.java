package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.canvas.widget.MSurfaceView;

final class b$3
  implements com.tencent.mm.plugin.appbrand.canvas.c.a
{
  b$3(MSurfaceView paramMSurfaceView) {}
  
  public final void ap(float paramFloat)
  {
    AppMethodBeat.i(11098);
    b.b(paramFloat, 2, this.hru.getTraceId());
    AppMethodBeat.o(11098);
  }
  
  public final void aq(float paramFloat)
  {
    AppMethodBeat.i(11099);
    b.b(paramFloat, 3, this.hru.getTraceId());
    AppMethodBeat.o(11099);
  }
  
  public final void ayj()
  {
    AppMethodBeat.i(11100);
    if (TextUtils.isEmpty(this.hru.getTraceId()))
    {
      u.i("MicroMsg.WidgetDrawableViewFactory", "traceId is null return", new Object[0]);
      AppMethodBeat.o(11100);
      return;
    }
    u.ql(this.hru.getTraceId());
    AppMethodBeat.o(11100);
  }
  
  public final void b(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(11097);
    com.tencent.mm.plugin.appbrand.widget.g.a.d(2, paramLong1, paramLong2, paramInt);
    AppMethodBeat.o(11097);
  }
  
  public final void hu(long paramLong)
  {
    AppMethodBeat.i(11095);
    com.tencent.mm.plugin.appbrand.widget.g.a.D(667, paramLong);
    AppMethodBeat.o(11095);
  }
  
  public final void hv(long paramLong)
  {
    AppMethodBeat.i(11096);
    com.tencent.mm.plugin.appbrand.widget.g.a.E(668, paramLong);
    AppMethodBeat.o(11096);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.widget.b.3
 * JD-Core Version:    0.7.0.1
 */