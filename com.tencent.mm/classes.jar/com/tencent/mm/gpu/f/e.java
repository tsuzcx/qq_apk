package com.tencent.mm.gpu.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  public String activityName = "";
  public int jVl;
  public int jVm;
  public int jVn;
  public long jVo;
  public int jVp;
  public int pid;
  public String processName;
  
  public final String toString()
  {
    AppMethodBeat.i(210897);
    String str = " \n" + String.format(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> %s(pid=%s) <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<", new Object[] { this.processName, Integer.valueOf(this.pid) }) + "\n| gfx-dev:\t " + this.jVl + "kb\n| gl-mtrack:\t " + this.jVm + "kb\n| egl-mtrack:\t " + this.jVn + "kb\n| spend:\t " + this.jVp + "min\n| activity:\t " + this.activityName + "\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> END(cost:" + this.jVo + "ms) <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n";
    AppMethodBeat.o(210897);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.gpu.f.e
 * JD-Core Version:    0.7.0.1
 */