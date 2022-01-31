package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.performance.c;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.report.quality.a;
import com.tencent.mm.plugin.appbrand.report.quality.b;

final class o$3$1
  implements Runnable
{
  o$3$1(o.3 param3) {}
  
  public final void run()
  {
    AppMethodBeat.i(128977);
    if ((!this.gRy.gRw) && (!this.gRy.gRv.mFinished))
    {
      a.aLt();
      b.a(false, this.gRy.gRv.mAppId, this.gRy.fET, j.aLa());
    }
    o.h(this.gRy.gRv).C(2, System.currentTimeMillis() - this.gRy.fET);
    c.a(this.gRy.gRv.mAppId, "X5Prepare", this.gRy.fET, System.currentTimeMillis());
    this.gRy.gRx.tT();
    AppMethodBeat.o(128977);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.3.1
 * JD-Core Version:    0.7.0.1
 */