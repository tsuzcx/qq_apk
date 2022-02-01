package com.tencent.mm.plugin.finder.event;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.b;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.e;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/event/FinderFeedSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/EventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/FinderFeedSubscriber$FeedBehavior;", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "getBehavior", "ActionEvent", "FeedBehavior", "plugin-finder_release"})
public final class a
  extends e<b>
{
  public a(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(201974);
    AppMethodBeat.o(201974);
  }
  
  public final b cAI()
  {
    AppMethodBeat.i(201973);
    b localb = (b)new c(this);
    AppMethodBeat.o(201973);
    return localb;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/event/FinderFeedSubscriber$ActionEvent;", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "type", "", "feedId", "", "(IJ)V", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFeed", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFeed", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "getFeedId", "()J", "getType", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "Companion", "plugin-finder_release"})
  public static final class a
    extends b
  {
    private static final int rYA = 2;
    private static final int rYB = 3;
    private static final int rYC = 4;
    private static final int rYD = 5;
    private static final int rYE = 6;
    private static final int rYF = 7;
    private static final int rYG = 8;
    private static final int rYH = 9;
    private static final int rYI = 10;
    private static final int rYJ = 11;
    private static final int rYK = 12;
    private static final int rYL = 13;
    private static final int rYM = 14;
    private static final int rYN = 15;
    private static final int rYO = 16;
    private static final int rYP = 17;
    private static final int rYQ = 18;
    private static final int rYR = 19;
    private static final int rYS = 20;
    public static final a rYT;
    private static final int rYz = 1;
    public final long duw;
    private FinderItem feed;
    public final int type;
    
    static
    {
      AppMethodBeat.i(201951);
      rYT = new a((byte)0);
      rYz = 1;
      rYA = 2;
      rYB = 3;
      rYC = 4;
      rYD = 5;
      rYE = 6;
      rYF = 7;
      rYG = 8;
      rYH = 9;
      rYI = 10;
      rYJ = 11;
      rYK = 12;
      rYL = 13;
      rYM = 14;
      rYN = 15;
      rYO = 16;
      rYP = 17;
      rYQ = 18;
      rYR = 19;
      rYS = 20;
      AppMethodBeat.o(201951);
    }
    
    public a(int paramInt, long paramLong)
    {
      AppMethodBeat.i(201950);
      this.type = paramInt;
      this.duw = paramLong;
      i locali = i.syT;
      this.feed = i.wJ(this.duw);
      AppMethodBeat.o(201950);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.type != paramObject.type) || (this.duw != paramObject.duw)) {}
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
      long l = this.duw;
      return i * 31 + (int)(l ^ l >>> 32);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(201952);
      String str = "ActionEvent(type=" + this.type + ", feedId=" + this.duw + ")";
      AppMethodBeat.o(201952);
      return str;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/event/FinderFeedSubscriber$ActionEvent$Companion;", "", "()V", "CANCEL_SHARE_TO_CHAT", "", "getCANCEL_SHARE_TO_CHAT", "()I", "CANCEL_SHARE_TO_SNS", "getCANCEL_SHARE_TO_SNS", "CLICK_AT", "getCLICK_AT", "CLICK_AVATAR", "getCLICK_AVATAR", "CLICK_COMMENT", "getCLICK_COMMENT", "CLICK_COMPLAINS", "getCLICK_COMPLAINS", "CLICK_LIKE_COMMENT", "getCLICK_LIKE_COMMENT", "CLICK_LINK", "getCLICK_LINK", "CLICK_MORE", "getCLICK_MORE", "CLICK_POI", "getCLICK_POI", "CLICK_TOPIC", "getCLICK_TOPIC", "COLLAPSE_ALL_TEXT", "getCOLLAPSE_ALL_TEXT", "FAV", "getFAV", "LIKE", "getLIKE", "NOT_INTEREST", "getNOT_INTEREST", "OPEN_ALL_TEXT", "getOPEN_ALL_TEXT", "SHARE_TO_CHAT", "getSHARE_TO_CHAT", "SHARE_TO_SNS", "getSHARE_TO_SNS", "UNFAV", "getUNFAV", "UNLIKE", "getUNLIKE", "plugin-finder_release"})
    public static final class a {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/event/FinderFeedSubscriber$FeedBehavior;", "", "onFeedCancelShareToChat", "", "feedId", "", "onFeedCancelShareToSns", "onFeedClickAt", "onFeedClickAvatar", "onFeedClickComment", "onFeedClickComplain", "onFeedClickLikeComment", "onFeedClickLink", "onFeedClickMore", "onFeedClickPoi", "onFeedClickTopic", "onFeedCollapseAllText", "onFeedFav", "onFeedLike", "onFeedOpenAllText", "onFeedShareToChat", "onFeedShareToSns", "onFeedUnFav", "onFeedUnLike", "onNotInteresting", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract void wb(long paramLong);
    
    public abstract void wc(long paramLong);
    
    public abstract void wd(long paramLong);
    
    public abstract void we(long paramLong);
    
    public abstract void wf(long paramLong);
    
    public abstract void wg(long paramLong);
    
    public abstract void wh(long paramLong);
    
    public abstract void wi(long paramLong);
    
    public abstract void wj(long paramLong);
    
    public abstract void wk(long paramLong);
    
    public abstract void wl(long paramLong);
    
    public abstract void wm(long paramLong);
    
    public abstract void wn(long paramLong);
    
    public abstract void wo(long paramLong);
    
    public abstract void wp(long paramLong);
    
    public abstract void wq(long paramLong);
    
    public abstract void wr(long paramLong);
    
    public abstract void ws(long paramLong);
    
    public abstract void wt(long paramLong);
    
    public abstract void wu(long paramLong);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/event/FinderFeedSubscriber$getBehavior$1", "Lcom/tencent/mm/plugin/finder/event/FinderFeedSubscriber$FeedBehavior;", "onFeedCancelShareToChat", "", "feedId", "", "onFeedCancelShareToSns", "onFeedClickAt", "onFeedClickAvatar", "onFeedClickComment", "onFeedClickComplain", "onFeedClickLikeComment", "onFeedClickLink", "onFeedClickMore", "onFeedClickPoi", "onFeedClickTopic", "onFeedCollapseAllText", "onFeedFav", "onFeedLike", "onFeedOpenAllText", "onFeedShareToChat", "onFeedShareToSns", "onFeedUnFav", "onFeedUnLike", "onNotInteresting", "plugin-finder_release"})
  public static final class c
    implements a.b
  {
    public final void wb(long paramLong)
    {
      AppMethodBeat.i(201968);
      Object localObject = a.a.rYT;
      localObject = new a.a(a.a.cAJ(), paramLong);
      this.rYU.c((b)localObject);
      AppMethodBeat.o(201968);
    }
    
    public final void wc(long paramLong)
    {
      AppMethodBeat.i(201969);
      Object localObject = a.a.rYT;
      localObject = new a.a(a.a.cAK(), paramLong);
      this.rYU.c((b)localObject);
      AppMethodBeat.o(201969);
    }
    
    public final void wd(long paramLong)
    {
      AppMethodBeat.i(201970);
      Object localObject = a.a.rYT;
      localObject = new a.a(a.a.cAL(), paramLong);
      this.rYU.c((b)localObject);
      AppMethodBeat.o(201970);
    }
    
    public final void we(long paramLong)
    {
      AppMethodBeat.i(201971);
      Object localObject = a.a.rYT;
      localObject = new a.a(a.a.cAM(), paramLong);
      this.rYU.c((b)localObject);
      AppMethodBeat.o(201971);
    }
    
    public final void wf(long paramLong)
    {
      AppMethodBeat.i(201972);
      Object localObject = a.a.rYT;
      localObject = new a.a(a.a.cAN(), paramLong);
      this.rYU.c((b)localObject);
      AppMethodBeat.o(201972);
    }
    
    public final void wg(long paramLong)
    {
      AppMethodBeat.i(201960);
      Object localObject = a.a.rYT;
      localObject = new a.a(a.a.cAV(), paramLong);
      this.rYU.c((b)localObject);
      AppMethodBeat.o(201960);
    }
    
    public final void wh(long paramLong)
    {
      AppMethodBeat.i(201964);
      Object localObject = a.a.rYT;
      localObject = new a.a(a.a.cAO(), paramLong);
      this.rYU.c((b)localObject);
      AppMethodBeat.o(201964);
    }
    
    public final void wi(long paramLong)
    {
      AppMethodBeat.i(201965);
      Object localObject = a.a.rYT;
      localObject = new a.a(a.a.cAP(), paramLong);
      this.rYU.c((b)localObject);
      AppMethodBeat.o(201965);
    }
    
    public final void wj(long paramLong)
    {
      AppMethodBeat.i(201966);
      Object localObject = a.a.rYT;
      localObject = new a.a(a.a.cAQ(), paramLong);
      this.rYU.c((b)localObject);
      AppMethodBeat.o(201966);
    }
    
    public final void wk(long paramLong)
    {
      AppMethodBeat.i(201967);
      Object localObject = a.a.rYT;
      localObject = new a.a(a.a.cAR(), paramLong);
      this.rYU.c((b)localObject);
      AppMethodBeat.o(201967);
    }
    
    public final void wl(long paramLong)
    {
      AppMethodBeat.i(201963);
      Object localObject = a.a.rYT;
      localObject = new a.a(a.a.cAS(), paramLong);
      this.rYU.c((b)localObject);
      AppMethodBeat.o(201963);
    }
    
    public final void wm(long paramLong)
    {
      AppMethodBeat.i(201962);
      Object localObject = a.a.rYT;
      localObject = new a.a(a.a.cAT(), paramLong);
      this.rYU.c((b)localObject);
      AppMethodBeat.o(201962);
    }
    
    public final void wn(long paramLong)
    {
      AppMethodBeat.i(201961);
      Object localObject = a.a.rYT;
      localObject = new a.a(a.a.cAU(), paramLong);
      this.rYU.c((b)localObject);
      AppMethodBeat.o(201961);
    }
    
    public final void wo(long paramLong)
    {
      AppMethodBeat.i(201959);
      Object localObject = a.a.rYT;
      localObject = new a.a(a.a.cAW(), paramLong);
      this.rYU.c((b)localObject);
      AppMethodBeat.o(201959);
    }
    
    public final void wp(long paramLong)
    {
      AppMethodBeat.i(201958);
      Object localObject = a.a.rYT;
      localObject = new a.a(a.a.cAX(), paramLong);
      this.rYU.c((b)localObject);
      AppMethodBeat.o(201958);
    }
    
    public final void wq(long paramLong)
    {
      AppMethodBeat.i(201957);
      Object localObject = a.a.rYT;
      localObject = new a.a(a.a.cAY(), paramLong);
      this.rYU.c((b)localObject);
      AppMethodBeat.o(201957);
    }
    
    public final void wr(long paramLong)
    {
      AppMethodBeat.i(201956);
      Object localObject = a.a.rYT;
      localObject = new a.a(a.a.cAZ(), paramLong);
      this.rYU.c((b)localObject);
      AppMethodBeat.o(201956);
    }
    
    public final void ws(long paramLong)
    {
      AppMethodBeat.i(201953);
      Object localObject = a.a.rYT;
      localObject = new a.a(a.a.cBa(), paramLong);
      this.rYU.c((b)localObject);
      AppMethodBeat.o(201953);
    }
    
    public final void wt(long paramLong)
    {
      AppMethodBeat.i(201954);
      Object localObject = a.a.rYT;
      localObject = new a.a(a.a.cBb(), paramLong);
      this.rYU.c((b)localObject);
      AppMethodBeat.o(201954);
    }
    
    public final void wu(long paramLong)
    {
      AppMethodBeat.i(201955);
      Object localObject = a.a.rYT;
      localObject = new a.a(a.a.cBc(), paramLong);
      this.rYU.c((b)localObject);
      AppMethodBeat.o(201955);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.a
 * JD-Core Version:    0.7.0.1
 */