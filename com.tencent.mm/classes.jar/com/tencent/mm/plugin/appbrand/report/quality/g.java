package com.tencent.mm.plugin.appbrand.report.quality;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.performance.e;

public enum g
{
  e mhj;
  
  static
  {
    AppMethodBeat.i(48221);
    muJ = new g("INST");
    muK = new g[] { muJ };
    AppMethodBeat.o(48221);
  }
  
  private g()
  {
    AppMethodBeat.i(48220);
    this.mhj = new e(Process.myPid());
    this.mhj.bvU();
    AppMethodBeat.o(48220);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.g
 * JD-Core Version:    0.7.0.1
 */