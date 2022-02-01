package com.tencent.mm.plugin.finder.live.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleContract;", "", "LuckyMoneyState", "Presenter", "ViewCallback", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface ai
{
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveLuckyMoneyBubbleContract$LuckyMoneyState;", "", "(Ljava/lang/String;I)V", "NEW", "OPENED", "ALL_SNATCHED", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum a
  {
    static
    {
      AppMethodBeat.i(352713);
      CzU = new a("NEW", 0);
      CzV = new a("OPENED", 1);
      CzW = new a("ALL_SNATCHED", 2);
      CzX = new a[] { CzU, CzV, CzW };
      AppMethodBeat.o(352713);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.ai
 * JD-Core Version:    0.7.0.1
 */