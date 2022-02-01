package com.tencent.mm.plugin.finder.event.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.FeedData;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/event/base/ScrollEvent;", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "type", "", "(I)V", "centerFeed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "getCenterFeed", "()Lcom/tencent/mm/plugin/finder/storage/FeedData;", "setCenterFeed", "(Lcom/tencent/mm/plugin/finder/storage/FeedData;)V", "centerFeedId", "", "getCenterFeedId", "()J", "setCenterFeedId", "(J)V", "centerFeedPosition", "getCenterFeedPosition", "()I", "setCenterFeedPosition", "centerMediaId", "", "getCenterMediaId", "()Ljava/lang/String;", "setCenterMediaId", "(Ljava/lang/String;)V", "firstCompletelyVisibleItemPosition", "getFirstCompletelyVisibleItemPosition", "setFirstCompletelyVisibleItemPosition", "firstVisibleItemPosition", "getFirstVisibleItemPosition", "setFirstVisibleItemPosition", "itemCount", "getItemCount", "setItemCount", "lastCompletelyVisibleItemPosition", "getLastCompletelyVisibleItemPosition", "setLastCompletelyVisibleItemPosition", "lastVisibleItemPosition", "getLastVisibleItemPosition", "setLastVisibleItemPosition", "newState", "getNewState", "setNewState", "getType", "setType", "toString", "Companion", "plugin-finder_release"})
public class h
  extends b
{
  public static final a tIG;
  int akb;
  public int tIA;
  int tIB;
  public long tIC;
  public int tID;
  String tIE;
  public FeedData tIF;
  int tIx;
  public int tIy;
  int tIz;
  public int type;
  
  static
  {
    AppMethodBeat.i(165569);
    tIG = new a((byte)0);
    AppMethodBeat.o(165569);
  }
  
  public h(int paramInt)
  {
    this.type = paramInt;
    this.tIx = -1;
    this.tIy = -1;
    this.tIz = -1;
    this.tIA = -1;
    this.tIC = -1L;
    this.tID = -1;
    this.tIE = "";
  }
  
  public String toString()
  {
    AppMethodBeat.i(165568);
    String str = "ScrollEvent(type=" + this.type + ", firstCompletelyVisibleItemPosition=" + this.tIx + ", firstVisibleItemPosition=" + this.tIy + ", lastCompletelyVisibleItemPosition=" + this.tIz + ", lastVisibleItemPosition=" + this.tIA + ", itemCount=" + this.akb + ", newState=" + this.tIB + ')';
    AppMethodBeat.o(165568);
    return str;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/event/base/ScrollEvent$Companion;", "", "()V", "SCROLL_STATE_ATTACHED", "", "SCROLL_STATE_DATA_CHANGE", "SCROLL_STATE_DRAGGING", "SCROLL_STATE_DRAGGING_DISTANCE", "SCROLL_STATE_IDLE", "SCROLL_STATE_ITEM_UPDATE", "SCROLL_STATE_LOW_SPEED_FLING", "SCROLL_STATE_ON_FOCUS_VIEW", "SCROLL_STATE_ON_TAB_INVISIBLE", "SCROLL_STATE_ON_TAB_VISIBLE", "SCROLL_STATE_SETTLING", "SCROLL_STATE_UNKNOWN", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.h
 * JD-Core Version:    0.7.0.1
 */