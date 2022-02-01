package com.tencent.mm.plugin.finder.event;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.b;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.e;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/event/FinderFeedSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/EventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/FinderFeedSubscriber$FeedBehavior;", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "getBehavior", "ActionEvent", "FeedBehavior", "plugin-finder_release"})
public final class a
  extends e<b>
{
  public a(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(201529);
    AppMethodBeat.o(201529);
  }
  
  public final b cze()
  {
    AppMethodBeat.i(201528);
    b localb = (b)new c(this);
    AppMethodBeat.o(201528);
    return localb;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/event/FinderFeedSubscriber$ActionEvent;", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "type", "", "feedId", "", "(IJ)V", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFeed", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFeed", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "getFeedId", "()J", "getType", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "Companion", "plugin-finder_release"})
  public static final class a
    extends b
  {
    private static final int rPX = 1;
    private static final int rPY = 2;
    private static final int rPZ = 3;
    private static final int rQa = 4;
    private static final int rQb = 5;
    private static final int rQc = 6;
    private static final int rQd = 7;
    private static final int rQe = 8;
    private static final int rQf = 9;
    private static final int rQg = 10;
    private static final int rQh = 11;
    private static final int rQi = 12;
    private static final int rQj = 13;
    private static final int rQk = 14;
    private static final int rQl = 15;
    private static final int rQm = 16;
    private static final int rQn = 17;
    private static final int rQo = 18;
    private static final int rQp = 19;
    private static final int rQq = 20;
    public static final a rQr;
    public final long dtq;
    private FinderItem feed;
    public final int type;
    
    static
    {
      AppMethodBeat.i(201506);
      rQr = new a((byte)0);
      rPX = 1;
      rPY = 2;
      rPZ = 3;
      rQa = 4;
      rQb = 5;
      rQc = 6;
      rQd = 7;
      rQe = 8;
      rQf = 9;
      rQg = 10;
      rQh = 11;
      rQi = 12;
      rQj = 13;
      rQk = 14;
      rQl = 15;
      rQm = 16;
      rQn = 17;
      rQo = 18;
      rQp = 19;
      rQq = 20;
      AppMethodBeat.o(201506);
    }
    
    public a(int paramInt, long paramLong)
    {
      AppMethodBeat.i(201505);
      this.type = paramInt;
      this.dtq = paramLong;
      h localh = h.soM;
      this.feed = h.ws(this.dtq);
      AppMethodBeat.o(201505);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.type != paramObject.type) || (this.dtq != paramObject.dtq)) {}
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
      long l = this.dtq;
      return i * 31 + (int)(l ^ l >>> 32);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(201507);
      String str = "ActionEvent(type=" + this.type + ", feedId=" + this.dtq + ")";
      AppMethodBeat.o(201507);
      return str;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/event/FinderFeedSubscriber$ActionEvent$Companion;", "", "()V", "CANCEL_SHARE_TO_CHAT", "", "getCANCEL_SHARE_TO_CHAT", "()I", "CANCEL_SHARE_TO_SNS", "getCANCEL_SHARE_TO_SNS", "CLICK_AT", "getCLICK_AT", "CLICK_AVATAR", "getCLICK_AVATAR", "CLICK_COMMENT", "getCLICK_COMMENT", "CLICK_COMPLAINS", "getCLICK_COMPLAINS", "CLICK_LIKE_COMMENT", "getCLICK_LIKE_COMMENT", "CLICK_LINK", "getCLICK_LINK", "CLICK_MORE", "getCLICK_MORE", "CLICK_POI", "getCLICK_POI", "CLICK_TOPIC", "getCLICK_TOPIC", "COLLAPSE_ALL_TEXT", "getCOLLAPSE_ALL_TEXT", "FAV", "getFAV", "LIKE", "getLIKE", "NOT_INTEREST", "getNOT_INTEREST", "OPEN_ALL_TEXT", "getOPEN_ALL_TEXT", "SHARE_TO_CHAT", "getSHARE_TO_CHAT", "SHARE_TO_SNS", "getSHARE_TO_SNS", "UNFAV", "getUNFAV", "UNLIKE", "getUNLIKE", "plugin-finder_release"})
    public static final class a {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/event/FinderFeedSubscriber$FeedBehavior;", "", "onFeedCancelShareToChat", "", "feedId", "", "onFeedCancelShareToSns", "onFeedClickAt", "onFeedClickAvatar", "onFeedClickComment", "onFeedClickComplain", "onFeedClickLikeComment", "onFeedClickLink", "onFeedClickMore", "onFeedClickPoi", "onFeedClickTopic", "onFeedCollapseAllText", "onFeedFav", "onFeedLike", "onFeedOpenAllText", "onFeedShareToChat", "onFeedShareToSns", "onFeedUnFav", "onFeedUnLike", "onNotInteresting", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract void vL(long paramLong);
    
    public abstract void vM(long paramLong);
    
    public abstract void vN(long paramLong);
    
    public abstract void vO(long paramLong);
    
    public abstract void vP(long paramLong);
    
    public abstract void vQ(long paramLong);
    
    public abstract void vR(long paramLong);
    
    public abstract void vS(long paramLong);
    
    public abstract void vT(long paramLong);
    
    public abstract void vU(long paramLong);
    
    public abstract void vV(long paramLong);
    
    public abstract void vW(long paramLong);
    
    public abstract void vX(long paramLong);
    
    public abstract void vY(long paramLong);
    
    public abstract void vZ(long paramLong);
    
    public abstract void wa(long paramLong);
    
    public abstract void wb(long paramLong);
    
    public abstract void wc(long paramLong);
    
    public abstract void wd(long paramLong);
    
    public abstract void we(long paramLong);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/event/FinderFeedSubscriber$getBehavior$1", "Lcom/tencent/mm/plugin/finder/event/FinderFeedSubscriber$FeedBehavior;", "onFeedCancelShareToChat", "", "feedId", "", "onFeedCancelShareToSns", "onFeedClickAt", "onFeedClickAvatar", "onFeedClickComment", "onFeedClickComplain", "onFeedClickLikeComment", "onFeedClickLink", "onFeedClickMore", "onFeedClickPoi", "onFeedClickTopic", "onFeedCollapseAllText", "onFeedFav", "onFeedLike", "onFeedOpenAllText", "onFeedShareToChat", "onFeedShareToSns", "onFeedUnFav", "onFeedUnLike", "onNotInteresting", "plugin-finder_release"})
  public static final class c
    implements a.b
  {
    public final void vL(long paramLong)
    {
      AppMethodBeat.i(201523);
      Object localObject = a.a.rQr;
      localObject = new a.a(a.a.czf(), paramLong);
      this.rQs.c((b)localObject);
      AppMethodBeat.o(201523);
    }
    
    public final void vM(long paramLong)
    {
      AppMethodBeat.i(201524);
      Object localObject = a.a.rQr;
      localObject = new a.a(a.a.czg(), paramLong);
      this.rQs.c((b)localObject);
      AppMethodBeat.o(201524);
    }
    
    public final void vN(long paramLong)
    {
      AppMethodBeat.i(201525);
      Object localObject = a.a.rQr;
      localObject = new a.a(a.a.czh(), paramLong);
      this.rQs.c((b)localObject);
      AppMethodBeat.o(201525);
    }
    
    public final void vO(long paramLong)
    {
      AppMethodBeat.i(201526);
      Object localObject = a.a.rQr;
      localObject = new a.a(a.a.czi(), paramLong);
      this.rQs.c((b)localObject);
      AppMethodBeat.o(201526);
    }
    
    public final void vP(long paramLong)
    {
      AppMethodBeat.i(201527);
      Object localObject = a.a.rQr;
      localObject = new a.a(a.a.czj(), paramLong);
      this.rQs.c((b)localObject);
      AppMethodBeat.o(201527);
    }
    
    public final void vQ(long paramLong)
    {
      AppMethodBeat.i(201515);
      Object localObject = a.a.rQr;
      localObject = new a.a(a.a.czr(), paramLong);
      this.rQs.c((b)localObject);
      AppMethodBeat.o(201515);
    }
    
    public final void vR(long paramLong)
    {
      AppMethodBeat.i(201519);
      Object localObject = a.a.rQr;
      localObject = new a.a(a.a.czk(), paramLong);
      this.rQs.c((b)localObject);
      AppMethodBeat.o(201519);
    }
    
    public final void vS(long paramLong)
    {
      AppMethodBeat.i(201520);
      Object localObject = a.a.rQr;
      localObject = new a.a(a.a.czl(), paramLong);
      this.rQs.c((b)localObject);
      AppMethodBeat.o(201520);
    }
    
    public final void vT(long paramLong)
    {
      AppMethodBeat.i(201521);
      Object localObject = a.a.rQr;
      localObject = new a.a(a.a.czm(), paramLong);
      this.rQs.c((b)localObject);
      AppMethodBeat.o(201521);
    }
    
    public final void vU(long paramLong)
    {
      AppMethodBeat.i(201522);
      Object localObject = a.a.rQr;
      localObject = new a.a(a.a.czn(), paramLong);
      this.rQs.c((b)localObject);
      AppMethodBeat.o(201522);
    }
    
    public final void vV(long paramLong)
    {
      AppMethodBeat.i(201518);
      Object localObject = a.a.rQr;
      localObject = new a.a(a.a.czo(), paramLong);
      this.rQs.c((b)localObject);
      AppMethodBeat.o(201518);
    }
    
    public final void vW(long paramLong)
    {
      AppMethodBeat.i(201517);
      Object localObject = a.a.rQr;
      localObject = new a.a(a.a.czp(), paramLong);
      this.rQs.c((b)localObject);
      AppMethodBeat.o(201517);
    }
    
    public final void vX(long paramLong)
    {
      AppMethodBeat.i(201516);
      Object localObject = a.a.rQr;
      localObject = new a.a(a.a.czq(), paramLong);
      this.rQs.c((b)localObject);
      AppMethodBeat.o(201516);
    }
    
    public final void vY(long paramLong)
    {
      AppMethodBeat.i(201514);
      Object localObject = a.a.rQr;
      localObject = new a.a(a.a.czs(), paramLong);
      this.rQs.c((b)localObject);
      AppMethodBeat.o(201514);
    }
    
    public final void vZ(long paramLong)
    {
      AppMethodBeat.i(201513);
      Object localObject = a.a.rQr;
      localObject = new a.a(a.a.czt(), paramLong);
      this.rQs.c((b)localObject);
      AppMethodBeat.o(201513);
    }
    
    public final void wa(long paramLong)
    {
      AppMethodBeat.i(201512);
      Object localObject = a.a.rQr;
      localObject = new a.a(a.a.czu(), paramLong);
      this.rQs.c((b)localObject);
      AppMethodBeat.o(201512);
    }
    
    public final void wb(long paramLong)
    {
      AppMethodBeat.i(201511);
      Object localObject = a.a.rQr;
      localObject = new a.a(a.a.czv(), paramLong);
      this.rQs.c((b)localObject);
      AppMethodBeat.o(201511);
    }
    
    public final void wc(long paramLong)
    {
      AppMethodBeat.i(201508);
      Object localObject = a.a.rQr;
      localObject = new a.a(a.a.czw(), paramLong);
      this.rQs.c((b)localObject);
      AppMethodBeat.o(201508);
    }
    
    public final void wd(long paramLong)
    {
      AppMethodBeat.i(201509);
      Object localObject = a.a.rQr;
      localObject = new a.a(a.a.czx(), paramLong);
      this.rQs.c((b)localObject);
      AppMethodBeat.o(201509);
    }
    
    public final void we(long paramLong)
    {
      AppMethodBeat.i(201510);
      Object localObject = a.a.rQr;
      localObject = new a.a(a.a.czy(), paramLong);
      this.rQs.c((b)localObject);
      AppMethodBeat.o(201510);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.a
 * JD-Core Version:    0.7.0.1
 */