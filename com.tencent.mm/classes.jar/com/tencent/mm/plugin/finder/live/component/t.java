package com.tencent.mm.plugin.finder.live.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleContract;", "", "LuckyMoneyState", "Presenter", "ViewCallback", "plugin-finder_release"})
public abstract interface t
{
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleContract$LuckyMoneyState;", "", "(Ljava/lang/String;I)V", "NEW", "OPENED", "ALL_SNATCHED", "plugin-finder_release"})
  public static enum a
  {
    static
    {
      AppMethodBeat.i(286390);
      a locala1 = new a("NEW", 0);
      ybF = locala1;
      a locala2 = new a("OPENED", 1);
      ybG = locala2;
      a locala3 = new a("ALL_SNATCHED", 2);
      ybH = locala3;
      ybI = new a[] { locala1, locala2, locala3 };
      AppMethodBeat.o(286390);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.t
 * JD-Core Version:    0.7.0.1
 */