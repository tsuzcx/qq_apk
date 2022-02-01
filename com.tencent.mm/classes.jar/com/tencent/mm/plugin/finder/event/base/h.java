package com.tencent.mm.plugin.finder.event.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/event/base/ScrollEvent;", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "type", "", "(I)V", "centerFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getCenterFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setCenterFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "centerFeedId", "", "getCenterFeedId", "()J", "setCenterFeedId", "(J)V", "centerFeedItemPosition", "getCenterFeedItemPosition", "()I", "setCenterFeedItemPosition", "centerFeedPos", "getCenterFeedPos", "setCenterFeedPos", "centerMediaId", "", "getCenterMediaId", "()Ljava/lang/String;", "setCenterMediaId", "(Ljava/lang/String;)V", "firstBindItemPosition", "getFirstBindItemPosition", "setFirstBindItemPosition", "firstCompletelyVisibleItemPosition", "getFirstCompletelyVisibleItemPosition", "setFirstCompletelyVisibleItemPosition", "firstVisibleItemPosition", "getFirstVisibleItemPosition", "setFirstVisibleItemPosition", "itemCount", "getItemCount", "setItemCount", "lastBindItemPosition", "getLastBindItemPosition", "setLastBindItemPosition", "lastCompletelyVisibleItemPosition", "getLastCompletelyVisibleItemPosition", "setLastCompletelyVisibleItemPosition", "lastVisibleItemPosition", "getLastVisibleItemPosition", "setLastVisibleItemPosition", "newState", "getNewState", "setNewState", "getType", "setType", "toString", "Companion", "plugin-finder_release"})
public class h
  extends b
{
  public static final a rRo;
  int ajO;
  int rRc;
  public int rRd;
  int rRe;
  public int rRf;
  int rRg;
  int rRh;
  int rRi;
  public long rRj;
  public int rRk;
  int rRl;
  String rRm;
  public BaseFinderFeed rRn;
  public int type;
  
  static
  {
    AppMethodBeat.i(165569);
    rRo = new a((byte)0);
    AppMethodBeat.o(165569);
  }
  
  public h(int paramInt)
  {
    this.type = paramInt;
    this.rRc = -1;
    this.rRd = -1;
    this.rRe = -1;
    this.rRf = -1;
    this.rRg = -1;
    this.rRh = -1;
    this.rRj = -1L;
    this.rRk = -1;
    this.rRm = "";
  }
  
  public String toString()
  {
    AppMethodBeat.i(165568);
    String str = "ScrollEvent(type=" + this.type + ", firstCompletelyVisibleItemPosition=" + this.rRc + ", firstVisibleItemPosition=" + this.rRd + ", lastCompletelyVisibleItemPosition=" + this.rRe + ", lastVisibleItemPosition=" + this.rRf + ", itemCount=" + this.ajO + ", newState=" + this.rRi + ')';
    AppMethodBeat.o(165568);
    return str;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/event/base/ScrollEvent$Companion;", "", "()V", "SCROLL_STATE_ATTACHED", "", "SCROLL_STATE_DATA_CHANGE", "SCROLL_STATE_DRAGGING", "SCROLL_STATE_DRAGGING_DISTANCE", "SCROLL_STATE_IDLE", "SCROLL_STATE_ITEM_UPDATE", "SCROLL_STATE_LOW_SPEED_FLING", "SCROLL_STATE_ON_FOCUS_VIEW", "SCROLL_STATE_ON_TAB_VISIBLE", "SCROLL_STATE_SETTLING", "SCROLL_STATE_UNKNOWN", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.h
 * JD-Core Version:    0.7.0.1
 */