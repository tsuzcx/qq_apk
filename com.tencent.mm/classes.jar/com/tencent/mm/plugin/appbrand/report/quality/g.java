package com.tencent.mm.plugin.appbrand.report.quality;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.performance.e;

public enum g
{
  e iAM;
  
  static
  {
    AppMethodBeat.i(132698);
    iID = new g("INST");
    iIE = new g[] { iID };
    AppMethodBeat.o(132698);
  }
  
  private g()
  {
    AppMethodBeat.i(132697);
    this.iAM = new e(Process.myPid());
    this.iAM.aKr();
    AppMethodBeat.o(132697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.g
 * JD-Core Version:    0.7.0.1
 */