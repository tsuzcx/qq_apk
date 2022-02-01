package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/HellFinderConfig$VisiableState;", "", "state", "", "(Ljava/lang/String;II)V", "getState", "()I", "VISIABLE_ON_SCROLL", "INVISIABLE_ON_SCROLL", "VISIABLE_ON_RESUME", "INVISIABLE_ON_PAUSE", "EVENT_ON_DESTROY", "plugin-expt_release"})
public enum c$e
{
  public final int state;
  
  static
  {
    AppMethodBeat.i(252760);
    e locale1 = new e("VISIABLE_ON_SCROLL", 0, 0);
    wli = locale1;
    e locale2 = new e("INVISIABLE_ON_SCROLL", 1, 1);
    wlj = locale2;
    e locale3 = new e("VISIABLE_ON_RESUME", 2, 2);
    wlk = locale3;
    e locale4 = new e("INVISIABLE_ON_PAUSE", 3, 3);
    wll = locale4;
    e locale5 = new e("EVENT_ON_DESTROY", 4, 4);
    wlm = locale5;
    wln = new e[] { locale1, locale2, locale3, locale4, locale5 };
    AppMethodBeat.o(252760);
  }
  
  private c$e(int paramInt)
  {
    this.state = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.c.e
 * JD-Core Version:    0.7.0.1
 */