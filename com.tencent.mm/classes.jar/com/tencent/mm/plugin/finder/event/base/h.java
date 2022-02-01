package com.tencent.mm.plugin.finder.event.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/event/base/ScrollEvent;", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "type", "", "(I)V", "centerFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getCenterFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setCenterFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "centerFeedId", "", "getCenterFeedId", "()J", "setCenterFeedId", "(J)V", "centerFeedPos", "getCenterFeedPos", "()I", "setCenterFeedPos", "centerMediaId", "", "getCenterMediaId", "()Ljava/lang/String;", "setCenterMediaId", "(Ljava/lang/String;)V", "firstCompletelyVisibleItemPosition", "getFirstCompletelyVisibleItemPosition", "setFirstCompletelyVisibleItemPosition", "firstVisibleItemPosition", "getFirstVisibleItemPosition", "setFirstVisibleItemPosition", "itemCount", "getItemCount", "setItemCount", "lastCompletelyVisibleItemPosition", "getLastCompletelyVisibleItemPosition", "setLastCompletelyVisibleItemPosition", "lastVisibleItemPosition", "getLastVisibleItemPosition", "setLastVisibleItemPosition", "newState", "getNewState", "setNewState", "getType", "setType", "toString", "Companion", "plugin-finder_release"})
public class h
  extends b
{
  public static final a rdO;
  int ahX;
  int rdG;
  public int rdH;
  int rdI;
  public int rdJ;
  int rdK;
  public long rdL;
  int rdM;
  String rdN;
  public BaseFinderFeed rde;
  public int type;
  
  static
  {
    AppMethodBeat.i(165569);
    rdO = new a((byte)0);
    AppMethodBeat.o(165569);
  }
  
  public h(int paramInt)
  {
    this.type = paramInt;
    this.rdG = -1;
    this.rdH = -1;
    this.rdI = -1;
    this.rdJ = -1;
    this.rdL = -1L;
    this.rdN = "";
  }
  
  public String toString()
  {
    AppMethodBeat.i(165568);
    String str = "ScrollEvent(type=" + this.type + ", firstCompletelyVisibleItemPosition=" + this.rdG + ", firstVisibleItemPosition=" + this.rdH + ", lastCompletelyVisibleItemPosition=" + this.rdI + ", lastVisibleItemPosition=" + this.rdJ + ", itemCount=" + this.ahX + ", newState=" + this.rdK + ')';
    AppMethodBeat.o(165568);
    return str;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/event/base/ScrollEvent$Companion;", "", "()V", "SCROLL_STATE_ATTACHED", "", "SCROLL_STATE_DRAGGING", "SCROLL_STATE_DRAGGING_DISTANCE", "SCROLL_STATE_IDLE", "SCROLL_STATE_LOW_SPEED_FLING", "SCROLL_STATE_ON_FOCUS_VIEW", "SCROLL_STATE_ON_TAB_VISIBLE", "SCROLL_STATE_SETTLING", "SCROLL_STATE_TERM_CHANGE", "SCROLL_STATE_UNKNOWN", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.h
 * JD-Core Version:    0.7.0.1
 */