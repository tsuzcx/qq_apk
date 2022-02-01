package com.tencent.mm.gpu.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  public String activityName = "";
  public int gwD;
  public int gwE;
  public int gwF;
  public long gwG;
  public int gwH;
  public int pid;
  public String processName;
  
  public final String toString()
  {
    AppMethodBeat.i(209672);
    String str = " \n" + String.format(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> %s(pid=%s) <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<", new Object[] { this.processName, Integer.valueOf(this.pid) }) + "\n| gfx-dev:\t " + this.gwD + "kb\n| gl-mtrack:\t " + this.gwE + "kb\n| egl-mtrack:\t " + this.gwF + "kb\n| spend:\t " + this.gwH + "min\n| activity:\t " + this.activityName + "\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> END(cost:" + this.gwG + "ms) <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n";
    AppMethodBeat.o(209672);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.gpu.e.e
 * JD-Core Version:    0.7.0.1
 */