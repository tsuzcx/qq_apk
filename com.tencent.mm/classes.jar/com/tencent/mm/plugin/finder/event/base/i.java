package com.tencent.mm.plugin.finder.event.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/event/base/ScrollEvent;", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "type", "", "(I)V", "centerFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getCenterFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setCenterFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "centerFeedId", "", "getCenterFeedId", "()J", "setCenterFeedId", "(J)V", "centerFeedPos", "getCenterFeedPos", "()I", "setCenterFeedPos", "centerMediaId", "", "getCenterMediaId", "()Ljava/lang/String;", "setCenterMediaId", "(Ljava/lang/String;)V", "firstCompletelyVisibleItemPosition", "getFirstCompletelyVisibleItemPosition", "setFirstCompletelyVisibleItemPosition", "firstVisibleItemPosition", "getFirstVisibleItemPosition", "setFirstVisibleItemPosition", "itemCount", "getItemCount", "setItemCount", "lastCompletelyVisibleItemPosition", "getLastCompletelyVisibleItemPosition", "setLastCompletelyVisibleItemPosition", "lastVisibleItemPosition", "getLastVisibleItemPosition", "setLastVisibleItemPosition", "newState", "getNewState", "setNewState", "getType", "setType", "toString", "Companion", "plugin-finder_release"})
public class i
  extends c
{
  public static final a qsF;
  int KMk;
  int ahd;
  int qsB;
  int qsC;
  int qsD;
  public int qsi;
  public int qsj;
  public long qsk;
  public BaseFinderFeed qsl;
  String qsm;
  public int type;
  
  static
  {
    AppMethodBeat.i(165569);
    qsF = new a((byte)0);
    AppMethodBeat.o(165569);
  }
  
  public i(int paramInt)
  {
    this.type = paramInt;
    this.qsB = -1;
    this.qsi = -1;
    this.qsC = -1;
    this.qsj = -1;
    this.qsk = -1L;
    this.qsm = "";
  }
  
  public String toString()
  {
    AppMethodBeat.i(165568);
    String str = "ScrollEvent(type=" + this.type + ", firstCompletelyVisibleItemPosition=" + this.qsB + ", firstVisibleItemPosition=" + this.qsi + ", lastCompletelyVisibleItemPosition=" + this.qsC + ", lastVisibleItemPosition=" + this.qsj + ", itemCount=" + this.ahd + ", newState=" + this.qsD + ')';
    AppMethodBeat.o(165568);
    return str;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/event/base/ScrollEvent$Companion;", "", "()V", "SCROLL_DRAGGING", "", "SCROLL_STATE_ATTACHED", "SCROLL_STATE_DRAGGING", "SCROLL_STATE_FIRST_TERM_CHANGE", "SCROLL_STATE_IDLE", "SCROLL_STATE_ON_FOCUS_VIEW", "SCROLL_STATE_ON_TAB_VISIBLE", "SCROLL_STATE_SETTLING", "SCROLL_STATE_UNKNOWN", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.i
 * JD-Core Version:    0.7.0.1
 */