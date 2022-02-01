package com.tencent.mm.plugin.finder.event.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/event/base/TwoFeedFlowScrollEvent;", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "type", "", "(I)V", "acrossFeedList", "", "Lcom/tencent/mm/plugin/finder/event/base/FlowScrollEventFeedData;", "getAcrossFeedList", "()Ljava/util/List;", "setAcrossFeedList", "(Ljava/util/List;)V", "firstVisibleItemPosition", "getFirstVisibleItemPosition", "()I", "setFirstVisibleItemPosition", "lastFirstVisibleItemPosition", "getLastFirstVisibleItemPosition", "setLastFirstVisibleItemPosition", "lastLastVisibleItemPosition", "getLastLastVisibleItemPosition", "setLastLastVisibleItemPosition", "lastVisibleItemPosition", "getLastVisibleItemPosition", "setLastVisibleItemPosition", "getType", "visibleFeedList", "getVisibleFeedList", "setVisibleFeedList", "Companion", "plugin-finder_release"})
public final class l
  extends b
{
  public static final a rRs;
  public int obN;
  public int obO;
  public int rRd;
  public int rRf;
  public List<g> rRp;
  public List<g> rRq;
  private final int type;
  
  static
  {
    AppMethodBeat.i(201572);
    rRs = new a((byte)0);
    AppMethodBeat.o(201572);
  }
  
  public l(int paramInt)
  {
    this.type = paramInt;
    this.obN = -1;
    this.obO = -1;
    this.rRd = -1;
    this.rRf = -1;
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/event/base/TwoFeedFlowScrollEvent$Companion;", "", "()V", "SCROLL_DRAGGING", "", "SCROLL_STATE_ATTACHED", "SCROLL_STATE_DRAGGING", "SCROLL_STATE_FIRST_TERM_CHANGE", "SCROLL_STATE_IDLE", "SCROLL_STATE_SETTLING", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.l
 * JD-Core Version:    0.7.0.1
 */