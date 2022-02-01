package com.tencent.mm.plugin.appbrand.report.quality;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.performance.e;

public enum g
{
  e mmi;
  
  static
  {
    AppMethodBeat.i(48221);
    mzG = new g("INST");
    mzH = new g[] { mzG };
    AppMethodBeat.o(48221);
  }
  
  private g()
  {
    AppMethodBeat.i(48220);
    this.mmi = new e(Process.myPid());
    this.mmi.bwL();
    AppMethodBeat.o(48220);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.g
 * JD-Core Version:    0.7.0.1
 */