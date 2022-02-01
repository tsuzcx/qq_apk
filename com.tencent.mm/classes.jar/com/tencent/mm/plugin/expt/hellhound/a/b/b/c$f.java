package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$WaterfallsFlowSceneEnum;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "LBS", "TOPIC", "POI", "SEARCH", "OTHER_PROFILE", "FAVORITE", "plugin-expt_release"})
public enum c$f
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(220940);
    f localf1 = new f("LBS", 0, 1000);
    sFt = localf1;
    f localf2 = new f("TOPIC", 1, 1001);
    sFu = localf2;
    f localf3 = new f("POI", 2, 1002);
    sFv = localf3;
    f localf4 = new f("SEARCH", 3, 1004);
    sFw = localf4;
    f localf5 = new f("OTHER_PROFILE", 4, 1006);
    sFx = localf5;
    f localf6 = new f("FAVORITE", 5, 1008);
    sFy = localf6;
    sFz = new f[] { localf1, localf2, localf3, localf4, localf5, localf6 };
    AppMethodBeat.o(220940);
  }
  
  private c$f(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.c.f
 * JD-Core Version:    0.7.0.1
 */