package com.tencent.mm.plugin.expt.hellhound.ext.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$VisiableState;", "", "state", "", "(Ljava/lang/String;II)V", "getState", "()I", "VISIABLE_ON_SCROLL", "INVISIABLE_ON_SCROLL", "VISIABLE_ON_RESUME", "INVISIABLE_ON_PAUSE", "EVENT_ON_DESTROY", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum c$e
{
  public final int state;
  
  static
  {
    AppMethodBeat.i(300597);
    zHn = new e("VISIABLE_ON_SCROLL", 0, 0);
    zHo = new e("INVISIABLE_ON_SCROLL", 1, 1);
    zHp = new e("VISIABLE_ON_RESUME", 2, 2);
    zHq = new e("INVISIABLE_ON_PAUSE", 3, 3);
    zHr = new e("EVENT_ON_DESTROY", 4, 4);
    zHs = new e[] { zHn, zHo, zHp, zHq, zHr };
    AppMethodBeat.o(300597);
  }
  
  private c$e(int paramInt)
  {
    this.state = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.e
 * JD-Core Version:    0.7.0.1
 */