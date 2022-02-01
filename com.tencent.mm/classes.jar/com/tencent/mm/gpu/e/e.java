package com.tencent.mm.gpu.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  public String activityName = "";
  public int hjr;
  public int hjs;
  public int hjt;
  public long hju;
  public int hjv;
  public int pid;
  public String processName;
  
  public final String toString()
  {
    AppMethodBeat.i(186204);
    String str = " \n" + String.format(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> %s(pid=%s) <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<", new Object[] { this.processName, Integer.valueOf(this.pid) }) + "\n| gfx-dev:\t " + this.hjr + "kb\n| gl-mtrack:\t " + this.hjs + "kb\n| egl-mtrack:\t " + this.hjt + "kb\n| spend:\t " + this.hjv + "min\n| activity:\t " + this.activityName + "\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> END(cost:" + this.hju + "ms) <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n";
    AppMethodBeat.o(186204);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.gpu.e.e
 * JD-Core Version:    0.7.0.1
 */