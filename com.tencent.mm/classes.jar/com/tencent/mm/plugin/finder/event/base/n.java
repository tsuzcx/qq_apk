package com.tencent.mm.plugin.finder.event.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/event/base/TwoFeedFlowScrollEvent;", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "type", "", "(I)V", "acrossFeedList", "", "Lcom/tencent/mm/plugin/finder/event/base/FlowScrollEventFeedData;", "getAcrossFeedList", "()Ljava/util/List;", "setAcrossFeedList", "(Ljava/util/List;)V", "firstVisibleItemPosition", "getFirstVisibleItemPosition", "()I", "setFirstVisibleItemPosition", "lastFirstVisibleItemPosition", "getLastFirstVisibleItemPosition", "setLastFirstVisibleItemPosition", "lastLastVisibleItemPosition", "getLastLastVisibleItemPosition", "setLastLastVisibleItemPosition", "lastVisibleItemPosition", "getLastVisibleItemPosition", "setLastVisibleItemPosition", "getType", "visibleFeedList", "getVisibleFeedList", "setVisibleFeedList", "Companion", "plugin-finder_release"})
public final class n
  extends c
{
  public static final a KMo;
  public List<k> KMl;
  public List<k> KMm;
  public int mYh;
  public int mYi;
  public int qsi;
  public int qsj;
  private final int type;
  
  static
  {
    AppMethodBeat.i(197550);
    KMo = new a((byte)0);
    AppMethodBeat.o(197550);
  }
  
  public n(int paramInt)
  {
    this.type = paramInt;
    this.mYh = -1;
    this.mYi = -1;
    this.qsi = -1;
    this.qsj = -1;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/event/base/TwoFeedFlowScrollEvent$Companion;", "", "()V", "SCROLL_DRAGGING", "", "SCROLL_STATE_ATTACHED", "SCROLL_STATE_DRAGGING", "SCROLL_STATE_FIRST_TERM_CHANGE", "SCROLL_STATE_IDLE", "SCROLL_STATE_SETTLING", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.n
 * JD-Core Version:    0.7.0.1
 */