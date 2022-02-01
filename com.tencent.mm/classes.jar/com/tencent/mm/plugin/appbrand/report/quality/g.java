package com.tencent.mm.plugin.appbrand.report.quality;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.performance.e;

public enum g
{
  e lhE;
  
  static
  {
    AppMethodBeat.i(48221);
    lsZ = new g("INST");
    lta = new g[] { lsZ };
    AppMethodBeat.o(48221);
  }
  
  private g()
  {
    AppMethodBeat.i(48220);
    this.lhE = new e(Process.myPid());
    this.lhE.blb();
    AppMethodBeat.o(48220);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.g
 * JD-Core Version:    0.7.0.1
 */