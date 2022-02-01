package com.tencent.mm.plugin.finder.event.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/event/base/TwoFeedFlowScrollEvent;", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "type", "", "(I)V", "acrossFeedList", "", "Lcom/tencent/mm/plugin/finder/event/base/FlowScrollEventFeedData;", "getAcrossFeedList", "()Ljava/util/List;", "setAcrossFeedList", "(Ljava/util/List;)V", "firstVisibleItemPosition", "getFirstVisibleItemPosition", "()I", "setFirstVisibleItemPosition", "lastFirstVisibleItemPosition", "getLastFirstVisibleItemPosition", "setLastFirstVisibleItemPosition", "lastLastVisibleItemPosition", "getLastLastVisibleItemPosition", "setLastLastVisibleItemPosition", "lastVisibleItemPosition", "getLastVisibleItemPosition", "setLastVisibleItemPosition", "getType", "visibleFeedList", "getVisibleFeedList", "setVisibleFeedList", "Companion", "plugin-finder_release"})
public final class l
  extends b
{
  public static final a tIL;
  public int ptb;
  public int ptc;
  public int tIA;
  public List<g> tIH;
  public List<g> tII;
  public int tIy;
  private final int type;
  
  static
  {
    AppMethodBeat.i(243472);
    tIL = new a((byte)0);
    AppMethodBeat.o(243472);
  }
  
  public l(int paramInt)
  {
    this.type = paramInt;
    this.ptb = -1;
    this.ptc = -1;
    this.tIy = -1;
    this.tIA = -1;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/event/base/TwoFeedFlowScrollEvent$Companion;", "", "()V", "SCROLL_DRAGGING", "", "SCROLL_STATE_ATTACHED", "SCROLL_STATE_DRAGGING", "SCROLL_STATE_FIRST_TERM_CHANGE", "SCROLL_STATE_IDLE", "SCROLL_STATE_SETTLING", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.l
 * JD-Core Version:    0.7.0.1
 */