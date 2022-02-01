package com.tencent.mm.plugin.finder.event.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/event/base/TwoFeedFlowScrollEvent;", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "type", "", "(I)V", "acrossFeedList", "", "Lcom/tencent/mm/plugin/finder/event/base/FlowScrollEventFeedData;", "getAcrossFeedList", "()Ljava/util/List;", "setAcrossFeedList", "(Ljava/util/List;)V", "firstVisibleItemPosition", "getFirstVisibleItemPosition", "()I", "setFirstVisibleItemPosition", "lastFirstVisibleItemPosition", "getLastFirstVisibleItemPosition", "setLastFirstVisibleItemPosition", "lastLastVisibleItemPosition", "getLastLastVisibleItemPosition", "setLastLastVisibleItemPosition", "lastVisibleItemPosition", "getLastVisibleItemPosition", "setLastVisibleItemPosition", "getType", "visibleFeedList", "getVisibleFeedList", "setVisibleFeedList", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends b
{
  public static final a AOE;
  public List<g> AOA;
  public List<g> AOB;
  public int AOr;
  public int AOt;
  private final int type;
  public int vIj;
  public int vIk;
  
  static
  {
    AppMethodBeat.i(330307);
    AOE = new a((byte)0);
    AppMethodBeat.o(330307);
  }
  
  public m(int paramInt)
  {
    this.type = paramInt;
    this.vIj = -1;
    this.vIk = -1;
    this.AOr = -1;
    this.AOt = -1;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/event/base/TwoFeedFlowScrollEvent$Companion;", "", "()V", "SCROLL_DRAGGING", "", "SCROLL_STATE_ATTACHED", "SCROLL_STATE_DRAGGING", "SCROLL_STATE_FIRST_TERM_CHANGE", "SCROLL_STATE_IDLE", "SCROLL_STATE_SETTLING", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.m
 * JD-Core Version:    0.7.0.1
 */