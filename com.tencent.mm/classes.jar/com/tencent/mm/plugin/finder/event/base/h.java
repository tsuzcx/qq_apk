package com.tencent.mm.plugin.finder.event.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.FeedData;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/event/base/ScrollEvent;", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "type", "", "(I)V", "centerFeed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "getCenterFeed", "()Lcom/tencent/mm/plugin/finder/storage/FeedData;", "setCenterFeed", "(Lcom/tencent/mm/plugin/finder/storage/FeedData;)V", "centerFeedId", "", "getCenterFeedId", "()J", "setCenterFeedId", "(J)V", "centerFeedPosition", "getCenterFeedPosition", "()I", "setCenterFeedPosition", "centerMediaId", "", "getCenterMediaId", "()Ljava/lang/String;", "setCenterMediaId", "(Ljava/lang/String;)V", "firstCompletelyVisibleItemPosition", "getFirstCompletelyVisibleItemPosition", "setFirstCompletelyVisibleItemPosition", "firstVisibleItemPosition", "getFirstVisibleItemPosition", "setFirstVisibleItemPosition", "itemCount", "getItemCount", "setItemCount", "lastCompletelyVisibleItemPosition", "getLastCompletelyVisibleItemPosition", "setLastCompletelyVisibleItemPosition", "lastVisibleItemPosition", "getLastVisibleItemPosition", "setLastVisibleItemPosition", "newState", "getNewState", "setNewState", "getType", "setType", "toString", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public class h
  extends b
{
  public static final a AOp;
  public int AOq;
  public int AOr;
  int AOs;
  public int AOt;
  public int AOu;
  public long AOv;
  public int AOw;
  String AOx;
  public FeedData AOy;
  int bUo;
  public int type;
  
  static
  {
    AppMethodBeat.i(165569);
    AOp = new a((byte)0);
    AppMethodBeat.o(165569);
  }
  
  public h(int paramInt)
  {
    this.type = paramInt;
    this.AOq = -1;
    this.AOr = -1;
    this.AOs = -1;
    this.AOt = -1;
    this.AOv = -1L;
    this.AOw = -1;
    this.AOx = "";
  }
  
  public final int dYN()
  {
    return this.AOr;
  }
  
  public final int dYO()
  {
    return this.AOt;
  }
  
  public final long dYP()
  {
    return this.AOv;
  }
  
  public final int getType()
  {
    return this.type;
  }
  
  public String toString()
  {
    AppMethodBeat.i(165568);
    String str = "ScrollEvent(type=" + this.type + ", firstCompletelyVisibleItemPosition=" + this.AOq + ", firstVisibleItemPosition=" + this.AOr + ", lastCompletelyVisibleItemPosition=" + this.AOs + ", lastVisibleItemPosition=" + this.AOt + ", itemCount=" + this.bUo + ", newState=" + this.AOu + ')';
    AppMethodBeat.o(165568);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/event/base/ScrollEvent$Companion;", "", "()V", "SCROLL_STATE_ATTACHED", "", "SCROLL_STATE_DATA_CHANGE", "SCROLL_STATE_DRAGGING", "SCROLL_STATE_DRAGGING_DISTANCE", "SCROLL_STATE_IDLE", "SCROLL_STATE_ITEM_UPDATE", "SCROLL_STATE_LOW_SPEED_FLING", "SCROLL_STATE_ON_FOCUS_VIEW", "SCROLL_STATE_ON_PAGE_SELECT", "SCROLL_STATE_ON_TAB_INVISIBLE", "SCROLL_STATE_ON_TAB_VISIBLE", "SCROLL_STATE_SETTLING", "SCROLL_STATE_UNKNOWN", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.h
 * JD-Core Version:    0.7.0.1
 */