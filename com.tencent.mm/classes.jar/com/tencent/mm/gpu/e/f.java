package com.tencent.mm.gpu.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  String activityName = "";
  long gaA;
  int gaB;
  int gax;
  int gay;
  int gaz;
  int pid;
  String processName;
  
  public final String toString()
  {
    AppMethodBeat.i(209437);
    String str = " \n" + String.format(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> %s(pid=%s) <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<", new Object[] { this.processName, Integer.valueOf(this.pid) }) + "\n| gfx-dev:\t " + this.gax + "kb\n| gl-mtrack:\t " + this.gay + "kb\n| egl-mtrack:\t " + this.gaz + "kb\n| spend:\t " + this.gaB + "min\n| activity:\t " + this.activityName + "\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> END(cost:" + this.gaA + "ms) <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n";
    AppMethodBeat.o(209437);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.gpu.e.f
 * JD-Core Version:    0.7.0.1
 */