package com.tencent.mm.plugin.appbrand.report.quality;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.performance.e;

public enum h
{
  e qyJ;
  
  static
  {
    AppMethodBeat.i(48221);
    qMX = new h("INST");
    qMY = new h[] { qMX };
    AppMethodBeat.o(48221);
  }
  
  private h()
  {
    AppMethodBeat.i(48220);
    this.qyJ = new e(Process.myPid());
    this.qyJ.cfX();
    AppMethodBeat.o(48220);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.h
 * JD-Core Version:    0.7.0.1
 */