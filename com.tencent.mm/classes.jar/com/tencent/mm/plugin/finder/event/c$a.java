package com.tencent.mm.plugin.finder.event;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.report.b;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/event/FinderFeedSubscriber$ActionEvent;", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "type", "", "feedId", "", "(IJ)V", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFeed", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFeed", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "getFeedId", "()J", "getType", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "Companion", "plugin-finder_release"})
public final class c$a
  extends c
{
  private static final int KLG = 1;
  private static final int KLH = 2;
  private static final int KLI = 3;
  private static final int KLJ = 4;
  private static final int KLK = 5;
  private static final int KLL = 6;
  private static final int KLM = 7;
  private static final int KLN = 8;
  private static final int KLO = 9;
  private static final int KLP = 10;
  private static final int KLQ = 11;
  private static final int KLR = 12;
  private static final int KLS = 13;
  private static final int KLT = 14;
  private static final int KLU = 15;
  private static final int KLV = 16;
  private static final int KLW = 17;
  public static final a KLX;
  private FinderItem feed;
  public final long feedId;
  public final int type;
  
  static
  {
    AppMethodBeat.i(197494);
    KLX = new a((byte)0);
    KLG = 1;
    KLH = 2;
    KLI = 3;
    KLJ = 4;
    KLK = 5;
    KLL = 6;
    KLM = 7;
    KLN = 8;
    KLO = 9;
    KLP = 10;
    KLQ = 11;
    KLR = 12;
    KLS = 13;
    KLT = 14;
    KLU = 15;
    KLV = 16;
    KLW = 17;
    AppMethodBeat.o(197494);
  }
  
  public c$a(int paramInt, long paramLong)
  {
    AppMethodBeat.i(197493);
    this.type = paramInt;
    this.feedId = paramLong;
    b localb = b.qFq;
    this.feed = b.qh(this.feedId);
    AppMethodBeat.o(197493);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((this.type != paramObject.type) || (this.feedId != paramObject.feedId)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final int hashCode()
  {
    int i = this.type;
    long l = this.feedId;
    return i * 31 + (int)(l ^ l >>> 32);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(197495);
    String str = "ActionEvent(type=" + this.type + ", feedId=" + this.feedId + ")";
    AppMethodBeat.o(197495);
    return str;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/event/FinderFeedSubscriber$ActionEvent$Companion;", "", "()V", "CANCEL_SHARE_TO_CHAT", "", "getCANCEL_SHARE_TO_CHAT", "()I", "CANCEL_SHARE_TO_SNS", "getCANCEL_SHARE_TO_SNS", "CLICK_AVATAR", "getCLICK_AVATAR", "CLICK_COMMENT", "getCLICK_COMMENT", "CLICK_COMPLAINS", "getCLICK_COMPLAINS", "CLICK_LIKE_COMMENT", "getCLICK_LIKE_COMMENT", "CLICK_MORE", "getCLICK_MORE", "CLICK_POI", "getCLICK_POI", "COLLAPSE_ALL_TEXT", "getCOLLAPSE_ALL_TEXT", "FAV", "getFAV", "LIKE", "getLIKE", "NOT_INTEREST", "getNOT_INTEREST", "OPEN_ALL_TEXT", "getOPEN_ALL_TEXT", "SHARE_TO_CHAT", "getSHARE_TO_CHAT", "SHARE_TO_SNS", "getSHARE_TO_SNS", "UNFAV", "getUNFAV", "UNLIKE", "getUNLIKE", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.c.a
 * JD-Core Version:    0.7.0.1
 */