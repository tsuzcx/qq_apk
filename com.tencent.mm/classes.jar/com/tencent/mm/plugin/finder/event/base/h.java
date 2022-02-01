package com.tencent.mm.plugin.finder.event.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/event/base/ScrollEvent;", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "type", "", "(I)V", "centerFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getCenterFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setCenterFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "centerFeedId", "", "getCenterFeedId", "()J", "setCenterFeedId", "(J)V", "centerFeedItemPosition", "getCenterFeedItemPosition", "()I", "setCenterFeedItemPosition", "centerFeedPos", "getCenterFeedPos", "setCenterFeedPos", "centerMediaId", "", "getCenterMediaId", "()Ljava/lang/String;", "setCenterMediaId", "(Ljava/lang/String;)V", "firstBindItemPosition", "getFirstBindItemPosition", "setFirstBindItemPosition", "firstCompletelyVisibleItemPosition", "getFirstCompletelyVisibleItemPosition", "setFirstCompletelyVisibleItemPosition", "firstVisibleItemPosition", "getFirstVisibleItemPosition", "setFirstVisibleItemPosition", "itemCount", "getItemCount", "setItemCount", "lastBindItemPosition", "getLastBindItemPosition", "setLastBindItemPosition", "lastCompletelyVisibleItemPosition", "getLastCompletelyVisibleItemPosition", "setLastCompletelyVisibleItemPosition", "lastVisibleItemPosition", "getLastVisibleItemPosition", "setLastVisibleItemPosition", "newState", "getNewState", "setNewState", "getType", "setType", "toString", "Companion", "plugin-finder_release"})
public class h
  extends b
{
  public static final a rZQ;
  int ajO;
  int rZE;
  public int rZF;
  int rZG;
  public int rZH;
  int rZI;
  int rZJ;
  int rZK;
  public long rZL;
  public int rZM;
  int rZN;
  String rZO;
  public BaseFinderFeed rZP;
  public int type;
  
  static
  {
    AppMethodBeat.i(165569);
    rZQ = new a((byte)0);
    AppMethodBeat.o(165569);
  }
  
  public h(int paramInt)
  {
    this.type = paramInt;
    this.rZE = -1;
    this.rZF = -1;
    this.rZG = -1;
    this.rZH = -1;
    this.rZI = -1;
    this.rZJ = -1;
    this.rZL = -1L;
    this.rZM = -1;
    this.rZO = "";
  }
  
  public String toString()
  {
    AppMethodBeat.i(165568);
    String str = "ScrollEvent(type=" + this.type + ", firstCompletelyVisibleItemPosition=" + this.rZE + ", firstVisibleItemPosition=" + this.rZF + ", lastCompletelyVisibleItemPosition=" + this.rZG + ", lastVisibleItemPosition=" + this.rZH + ", itemCount=" + this.ajO + ", newState=" + this.rZK + ')';
    AppMethodBeat.o(165568);
    return str;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/event/base/ScrollEvent$Companion;", "", "()V", "SCROLL_STATE_ATTACHED", "", "SCROLL_STATE_DATA_CHANGE", "SCROLL_STATE_DRAGGING", "SCROLL_STATE_DRAGGING_DISTANCE", "SCROLL_STATE_IDLE", "SCROLL_STATE_ITEM_UPDATE", "SCROLL_STATE_LOW_SPEED_FLING", "SCROLL_STATE_ON_FOCUS_VIEW", "SCROLL_STATE_ON_TAB_VISIBLE", "SCROLL_STATE_SETTLING", "SCROLL_STATE_UNKNOWN", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.h
 * JD-Core Version:    0.7.0.1
 */