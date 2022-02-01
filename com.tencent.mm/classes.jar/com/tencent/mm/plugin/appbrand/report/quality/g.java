package com.tencent.mm.plugin.appbrand.report.quality;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.performance.e;

public enum g
{
  e tDE;
  
  static
  {
    AppMethodBeat.i(48221);
    tRH = new g("INST");
    tRI = new g[] { tRH };
    AppMethodBeat.o(48221);
  }
  
  private g()
  {
    AppMethodBeat.i(48220);
    this.tDE = new e(Process.myPid());
    this.tDE.cGJ();
    AppMethodBeat.o(48220);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.g
 * JD-Core Version:    0.7.0.1
 */