package com.tencent.mm.plugin.finder.event;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.e;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/event/FinderFeedSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/EventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/FinderFeedSubscriber$FeedBehavior;", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "getBehavior", "ActionEvent", "FeedBehavior", "plugin-finder-base_release"})
public final class a
  extends e<b>
{
  public a(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(263516);
    AppMethodBeat.o(263516);
  }
  
  public final b dpO()
  {
    AppMethodBeat.i(263514);
    b localb = (b)new c(this);
    AppMethodBeat.o(263514);
    return localb;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/event/FinderFeedSubscriber$ActionEvent;", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "type", "", "feedId", "", "(IJ)V", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFeed", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFeed", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "getFeedId", "()J", "getType", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "Companion", "plugin-finder-base_release"})
  public static final class a
    extends com.tencent.mm.plugin.finder.event.base.b
  {
    private static final int xpZ = 1;
    private static final int xqa = 2;
    private static final int xqb = 3;
    private static final int xqc = 4;
    private static final int xqd = 5;
    private static final int xqe = 6;
    private static final int xqf = 7;
    private static final int xqg = 8;
    private static final int xqh = 9;
    private static final int xqi = 10;
    private static final int xqj = 11;
    private static final int xqk = 12;
    private static final int xql = 13;
    private static final int xqm = 14;
    private static final int xqn = 15;
    private static final int xqo = 16;
    private static final int xqp = 17;
    private static final int xqq = 18;
    private static final int xqr = 19;
    private static final int xqs = 20;
    public static final a xqt;
    public final long feedId;
    public final int type;
    public FinderItem xpY;
    
    static
    {
      AppMethodBeat.i(262906);
      xqt = new a((byte)0);
      xpZ = 1;
      xqa = 2;
      xqb = 3;
      xqc = 4;
      xqd = 5;
      xqe = 6;
      xqf = 7;
      xqg = 8;
      xqh = 9;
      xqi = 10;
      xqj = 11;
      xqk = 12;
      xql = 13;
      xqm = 14;
      xqn = 15;
      xqo = 16;
      xqp = 17;
      xqq = 18;
      xqr = 19;
      xqs = 20;
      AppMethodBeat.o(262906);
    }
    
    public a(int paramInt, long paramLong)
    {
      AppMethodBeat.i(262904);
      this.type = paramInt;
      this.feedId = paramLong;
      this.xpY = ((com.tencent.mm.plugin.b)h.ae(com.tencent.mm.plugin.b.class)).Hc(this.feedId);
      AppMethodBeat.o(262904);
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
    
    public final long getFeedId()
    {
      return this.feedId;
    }
    
    public final int hashCode()
    {
      int i = this.type;
      long l = this.feedId;
      return i * 31 + (int)(l ^ l >>> 32);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(262926);
      String str = "ActionEvent(type=" + this.type + ", feedId=" + this.feedId + ")";
      AppMethodBeat.o(262926);
      return str;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/event/FinderFeedSubscriber$ActionEvent$Companion;", "", "()V", "CANCEL_SHARE_TO_CHAT", "", "getCANCEL_SHARE_TO_CHAT", "()I", "CANCEL_SHARE_TO_SNS", "getCANCEL_SHARE_TO_SNS", "CLICK_AT", "getCLICK_AT", "CLICK_AVATAR", "getCLICK_AVATAR", "CLICK_COMMENT", "getCLICK_COMMENT", "CLICK_COMPLAINS", "getCLICK_COMPLAINS", "CLICK_LIKE_COMMENT", "getCLICK_LIKE_COMMENT", "CLICK_LINK", "getCLICK_LINK", "CLICK_MORE", "getCLICK_MORE", "CLICK_POI", "getCLICK_POI", "CLICK_TOPIC", "getCLICK_TOPIC", "COLLAPSE_ALL_TEXT", "getCOLLAPSE_ALL_TEXT", "FAV", "getFAV", "LIKE", "getLIKE", "NOT_INTEREST", "getNOT_INTEREST", "OPEN_ALL_TEXT", "getOPEN_ALL_TEXT", "SHARE_TO_CHAT", "getSHARE_TO_CHAT", "SHARE_TO_SNS", "getSHARE_TO_SNS", "UNFAV", "getUNFAV", "UNLIKE", "getUNLIKE", "plugin-finder-base_release"})
    public static final class a {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/event/FinderFeedSubscriber$FeedBehavior;", "", "onFeedCancelShareToChat", "", "feedId", "", "onFeedCancelShareToSns", "onFeedClickAt", "onFeedClickAvatar", "onFeedClickComment", "onFeedClickComplain", "onFeedClickLikeComment", "onFeedClickLink", "onFeedClickMore", "onFeedClickPoi", "onFeedClickTopic", "onFeedCollapseAllText", "onFeedFav", "onFeedLike", "onFeedOpenAllText", "onFeedShareToChat", "onFeedShareToSns", "onFeedUnFav", "onFeedUnLike", "onNotInteresting", "plugin-finder-base_release"})
  public static abstract interface b
  {
    public abstract void KA(long paramLong);
    
    public abstract void KB(long paramLong);
    
    public abstract void KC(long paramLong);
    
    public abstract void KD(long paramLong);
    
    public abstract void KE(long paramLong);
    
    public abstract void KF(long paramLong);
    
    public abstract void KG(long paramLong);
    
    public abstract void KH(long paramLong);
    
    public abstract void KI(long paramLong);
    
    public abstract void KJ(long paramLong);
    
    public abstract void KK(long paramLong);
    
    public abstract void KL(long paramLong);
    
    public abstract void KM(long paramLong);
    
    public abstract void KN(long paramLong);
    
    public abstract void KO(long paramLong);
    
    public abstract void KP(long paramLong);
    
    public abstract void Kw(long paramLong);
    
    public abstract void Kx(long paramLong);
    
    public abstract void Ky(long paramLong);
    
    public abstract void Kz(long paramLong);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/event/FinderFeedSubscriber$getBehavior$1", "Lcom/tencent/mm/plugin/finder/event/FinderFeedSubscriber$FeedBehavior;", "onFeedCancelShareToChat", "", "feedId", "", "onFeedCancelShareToSns", "onFeedClickAt", "onFeedClickAvatar", "onFeedClickComment", "onFeedClickComplain", "onFeedClickLikeComment", "onFeedClickLink", "onFeedClickMore", "onFeedClickPoi", "onFeedClickTopic", "onFeedCollapseAllText", "onFeedFav", "onFeedLike", "onFeedOpenAllText", "onFeedShareToChat", "onFeedShareToSns", "onFeedUnFav", "onFeedUnLike", "onNotInteresting", "plugin-finder-base_release"})
  public static final class c
    implements a.b
  {
    public final void KA(long paramLong)
    {
      AppMethodBeat.i(259237);
      Object localObject = a.a.xqt;
      localObject = new a.a(a.a.dpT(), paramLong);
      this.xqu.c((com.tencent.mm.plugin.finder.event.base.b)localObject);
      AppMethodBeat.o(259237);
    }
    
    public final void KB(long paramLong)
    {
      AppMethodBeat.i(259224);
      Object localObject = a.a.xqt;
      localObject = new a.a(a.a.dqb(), paramLong);
      this.xqu.c((com.tencent.mm.plugin.finder.event.base.b)localObject);
      AppMethodBeat.o(259224);
    }
    
    public final void KC(long paramLong)
    {
      AppMethodBeat.i(259229);
      Object localObject = a.a.xqt;
      localObject = new a.a(a.a.dpU(), paramLong);
      this.xqu.c((com.tencent.mm.plugin.finder.event.base.b)localObject);
      AppMethodBeat.o(259229);
    }
    
    public final void KD(long paramLong)
    {
      AppMethodBeat.i(259230);
      Object localObject = a.a.xqt;
      localObject = new a.a(a.a.dpV(), paramLong);
      this.xqu.c((com.tencent.mm.plugin.finder.event.base.b)localObject);
      AppMethodBeat.o(259230);
    }
    
    public final void KE(long paramLong)
    {
      AppMethodBeat.i(259231);
      Object localObject = a.a.xqt;
      localObject = new a.a(a.a.dpW(), paramLong);
      this.xqu.c((com.tencent.mm.plugin.finder.event.base.b)localObject);
      AppMethodBeat.o(259231);
    }
    
    public final void KF(long paramLong)
    {
      AppMethodBeat.i(259232);
      Object localObject = a.a.xqt;
      localObject = new a.a(a.a.dpX(), paramLong);
      this.xqu.c((com.tencent.mm.plugin.finder.event.base.b)localObject);
      AppMethodBeat.o(259232);
    }
    
    public final void KG(long paramLong)
    {
      AppMethodBeat.i(259228);
      Object localObject = a.a.xqt;
      localObject = new a.a(a.a.dpY(), paramLong);
      this.xqu.c((com.tencent.mm.plugin.finder.event.base.b)localObject);
      AppMethodBeat.o(259228);
    }
    
    public final void KH(long paramLong)
    {
      AppMethodBeat.i(259226);
      Object localObject = a.a.xqt;
      localObject = new a.a(a.a.dpZ(), paramLong);
      this.xqu.c((com.tencent.mm.plugin.finder.event.base.b)localObject);
      AppMethodBeat.o(259226);
    }
    
    public final void KI(long paramLong)
    {
      AppMethodBeat.i(259225);
      Object localObject = a.a.xqt;
      localObject = new a.a(a.a.dqa(), paramLong);
      this.xqu.c((com.tencent.mm.plugin.finder.event.base.b)localObject);
      AppMethodBeat.o(259225);
    }
    
    public final void KJ(long paramLong)
    {
      AppMethodBeat.i(259223);
      Object localObject = a.a.xqt;
      localObject = new a.a(a.a.dqc(), paramLong);
      this.xqu.c((com.tencent.mm.plugin.finder.event.base.b)localObject);
      AppMethodBeat.o(259223);
    }
    
    public final void KK(long paramLong)
    {
      AppMethodBeat.i(259222);
      Object localObject = a.a.xqt;
      localObject = new a.a(a.a.dqd(), paramLong);
      this.xqu.c((com.tencent.mm.plugin.finder.event.base.b)localObject);
      AppMethodBeat.o(259222);
    }
    
    public final void KL(long paramLong)
    {
      AppMethodBeat.i(259221);
      Object localObject = a.a.xqt;
      localObject = new a.a(a.a.dqe(), paramLong);
      this.xqu.c((com.tencent.mm.plugin.finder.event.base.b)localObject);
      AppMethodBeat.o(259221);
    }
    
    public final void KM(long paramLong)
    {
      AppMethodBeat.i(259220);
      Object localObject = a.a.xqt;
      localObject = new a.a(a.a.dqf(), paramLong);
      this.xqu.c((com.tencent.mm.plugin.finder.event.base.b)localObject);
      AppMethodBeat.o(259220);
    }
    
    public final void KN(long paramLong)
    {
      AppMethodBeat.i(259217);
      Object localObject = a.a.xqt;
      localObject = new a.a(a.a.dqg(), paramLong);
      this.xqu.c((com.tencent.mm.plugin.finder.event.base.b)localObject);
      AppMethodBeat.o(259217);
    }
    
    public final void KO(long paramLong)
    {
      AppMethodBeat.i(259218);
      Object localObject = a.a.xqt;
      localObject = new a.a(a.a.dqh(), paramLong);
      this.xqu.c((com.tencent.mm.plugin.finder.event.base.b)localObject);
      AppMethodBeat.o(259218);
    }
    
    public final void KP(long paramLong)
    {
      AppMethodBeat.i(259219);
      Object localObject = a.a.xqt;
      localObject = new a.a(a.a.dqi(), paramLong);
      this.xqu.c((com.tencent.mm.plugin.finder.event.base.b)localObject);
      AppMethodBeat.o(259219);
    }
    
    public final void Kw(long paramLong)
    {
      AppMethodBeat.i(259233);
      Object localObject = a.a.xqt;
      localObject = new a.a(a.a.dpP(), paramLong);
      this.xqu.c((com.tencent.mm.plugin.finder.event.base.b)localObject);
      AppMethodBeat.o(259233);
    }
    
    public final void Kx(long paramLong)
    {
      AppMethodBeat.i(259234);
      Object localObject = a.a.xqt;
      localObject = new a.a(a.a.dpQ(), paramLong);
      this.xqu.c((com.tencent.mm.plugin.finder.event.base.b)localObject);
      AppMethodBeat.o(259234);
    }
    
    public final void Ky(long paramLong)
    {
      AppMethodBeat.i(259235);
      Object localObject = a.a.xqt;
      localObject = new a.a(a.a.dpR(), paramLong);
      this.xqu.c((com.tencent.mm.plugin.finder.event.base.b)localObject);
      AppMethodBeat.o(259235);
    }
    
    public final void Kz(long paramLong)
    {
      AppMethodBeat.i(259236);
      Object localObject = a.a.xqt;
      localObject = new a.a(a.a.dpS(), paramLong);
      this.xqu.c((com.tencent.mm.plugin.finder.event.base.b)localObject);
      AppMethodBeat.o(259236);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.a
 * JD-Core Version:    0.7.0.1
 */