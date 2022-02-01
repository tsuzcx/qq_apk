package com.tencent.mm.gpu.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  public String activityName = "";
  public int gtW;
  public int gtX;
  public int gtY;
  public long gtZ;
  public int gua;
  public int pid;
  public String processName;
  
  public final String toString()
  {
    AppMethodBeat.i(219550);
    String str = " \n" + String.format(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> %s(pid=%s) <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<", new Object[] { this.processName, Integer.valueOf(this.pid) }) + "\n| gfx-dev:\t " + this.gtW + "kb\n| gl-mtrack:\t " + this.gtX + "kb\n| egl-mtrack:\t " + this.gtY + "kb\n| spend:\t " + this.gua + "min\n| activity:\t " + this.activityName + "\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> END(cost:" + this.gtZ + "ms) <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n";
    AppMethodBeat.o(219550);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.gpu.e.e
 * JD-Core Version:    0.7.0.1
 */