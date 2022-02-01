package com.tencent.mm.plugin.finder.event;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.b;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.e;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/event/FinderFeedSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/EventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/FinderFeedSubscriber$FeedBehavior;", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "getBehavior", "ActionEvent", "FeedBehavior", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends e<b>
{
  public a(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(330283);
    AppMethodBeat.o(330283);
  }
  
  public final b dYj()
  {
    AppMethodBeat.i(330286);
    b localb = (b)new c(this);
    AppMethodBeat.o(330286);
    return localb;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/event/FinderFeedSubscriber$ActionEvent;", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "type", "", "feedId", "", "(IJ)V", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFeed", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFeed", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "getFeedId", "()J", "getType", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends b
  {
    private static final int ANA;
    private static final int ANB;
    private static final int ANC;
    private static final int ANE;
    private static final int ANF;
    public static final a ANi;
    private static final int ANk;
    private static final int ANl;
    private static final int ANm;
    private static final int ANn;
    private static final int ANo;
    private static final int ANp;
    private static final int ANq;
    private static final int ANr;
    private static final int ANs;
    private static final int ANt;
    private static final int ANu;
    private static final int ANv;
    private static final int ANw;
    private static final int ANx;
    private static final int ANy;
    private static final int ANz;
    public FinderItem ANj;
    public final long feedId;
    public final int type;
    
    static
    {
      AppMethodBeat.i(330384);
      ANi = new a((byte)0);
      ANk = 1;
      ANl = 2;
      ANm = 3;
      ANn = 4;
      ANo = 5;
      ANp = 6;
      ANq = 7;
      ANr = 8;
      ANs = 9;
      ANt = 10;
      ANu = 11;
      ANv = 12;
      ANw = 13;
      ANx = 14;
      ANy = 15;
      ANz = 16;
      ANA = 17;
      ANB = 18;
      ANC = 19;
      ANE = 20;
      ANF = 21;
      AppMethodBeat.o(330384);
    }
    
    public a(int paramInt, long paramLong)
    {
      AppMethodBeat.i(330289);
      this.type = paramInt;
      this.feedId = paramLong;
      this.ANj = ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).jm(this.feedId);
      AppMethodBeat.o(330289);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof a)) {
          return false;
        }
        paramObject = (a)paramObject;
        if (this.type != paramObject.type) {
          return false;
        }
      } while (this.feedId == paramObject.feedId);
      return false;
    }
    
    public final long getFeedId()
    {
      return this.feedId;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(330401);
      int i = this.type;
      int j = q.a..ExternalSyntheticBackport0.m(this.feedId);
      AppMethodBeat.o(330401);
      return i * 31 + j;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(330395);
      String str = "ActionEvent(type=" + this.type + ", feedId=" + this.feedId + ')';
      AppMethodBeat.o(330395);
      return str;
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/event/FinderFeedSubscriber$ActionEvent$Companion;", "", "()V", "CANCEL_SHARE_TO_CHAT", "", "getCANCEL_SHARE_TO_CHAT", "()I", "CANCEL_SHARE_TO_SNS", "getCANCEL_SHARE_TO_SNS", "CLICK_AT", "getCLICK_AT", "CLICK_AVATAR", "getCLICK_AVATAR", "CLICK_COMMENT", "getCLICK_COMMENT", "CLICK_COMPLAINS", "getCLICK_COMPLAINS", "CLICK_LIKE_COMMENT", "getCLICK_LIKE_COMMENT", "CLICK_LINK", "getCLICK_LINK", "CLICK_MORE", "getCLICK_MORE", "CLICK_POI", "getCLICK_POI", "CLICK_TOPIC", "getCLICK_TOPIC", "COLLAPSE_ALL_TEXT", "getCOLLAPSE_ALL_TEXT", "FAV", "getFAV", "LIKE", "getLIKE", "LONG_CLICK_AVATAR", "getLONG_CLICK_AVATAR", "NOT_INTEREST", "getNOT_INTEREST", "OPEN_ALL_TEXT", "getOPEN_ALL_TEXT", "SHARE_TO_CHAT", "getSHARE_TO_CHAT", "SHARE_TO_SNS", "getSHARE_TO_SNS", "UNFAV", "getUNFAV", "UNLIKE", "getUNLIKE", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/event/FinderFeedSubscriber$FeedBehavior;", "", "onFeedCancelShareToChat", "", "feedId", "", "onFeedCancelShareToSns", "onFeedClickAt", "onFeedClickAvatar", "onFeedClickComment", "onFeedClickComplain", "onFeedClickLikeComment", "onFeedClickLink", "onFeedClickMore", "onFeedClickPoi", "onFeedClickTopic", "onFeedCollapseAllText", "onFeedFav", "onFeedLike", "onFeedLongClickAvatar", "onFeedOpenAllText", "onFeedShareToChat", "onFeedShareToSns", "onFeedUnFav", "onFeedUnLike", "onNotInteresting", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void mU(long paramLong);
    
    public abstract void mV(long paramLong);
    
    public abstract void mW(long paramLong);
    
    public abstract void mX(long paramLong);
    
    public abstract void mY(long paramLong);
    
    public abstract void mZ(long paramLong);
    
    public abstract void na(long paramLong);
    
    public abstract void nb(long paramLong);
    
    public abstract void nc(long paramLong);
    
    public abstract void nd(long paramLong);
    
    public abstract void ne(long paramLong);
    
    public abstract void nf(long paramLong);
    
    public abstract void ng(long paramLong);
    
    public abstract void nh(long paramLong);
    
    public abstract void ni(long paramLong);
    
    public abstract void nj(long paramLong);
    
    public abstract void nk(long paramLong);
    
    public abstract void nl(long paramLong);
    
    public abstract void nm(long paramLong);
    
    public abstract void nn(long paramLong);
    
    public abstract void no(long paramLong);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/event/FinderFeedSubscriber$getBehavior$1", "Lcom/tencent/mm/plugin/finder/event/FinderFeedSubscriber$FeedBehavior;", "onFeedCancelShareToChat", "", "feedId", "", "onFeedCancelShareToSns", "onFeedClickAt", "onFeedClickAvatar", "onFeedClickComment", "onFeedClickComplain", "onFeedClickLikeComment", "onFeedClickLink", "onFeedClickMore", "onFeedClickPoi", "onFeedClickTopic", "onFeedCollapseAllText", "onFeedFav", "onFeedLike", "onFeedLongClickAvatar", "onFeedOpenAllText", "onFeedShareToChat", "onFeedShareToSns", "onFeedUnFav", "onFeedUnLike", "onNotInteresting", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements a.b
  {
    c(a parama) {}
    
    public final void mU(long paramLong)
    {
      AppMethodBeat.i(330364);
      Object localObject = a.a.ANi;
      localObject = new a.a(a.a.dYk(), paramLong);
      this.ANG.c((b)localObject);
      AppMethodBeat.o(330364);
    }
    
    public final void mV(long paramLong)
    {
      AppMethodBeat.i(330373);
      Object localObject = a.a.ANi;
      localObject = new a.a(a.a.dYl(), paramLong);
      this.ANG.c((b)localObject);
      AppMethodBeat.o(330373);
    }
    
    public final void mW(long paramLong)
    {
      AppMethodBeat.i(330378);
      Object localObject = a.a.ANi;
      localObject = new a.a(a.a.dYm(), paramLong);
      this.ANG.c((b)localObject);
      AppMethodBeat.o(330378);
    }
    
    public final void mX(long paramLong)
    {
      AppMethodBeat.i(330383);
      Object localObject = a.a.ANi;
      localObject = new a.a(a.a.dYn(), paramLong);
      this.ANG.c((b)localObject);
      AppMethodBeat.o(330383);
    }
    
    public final void mY(long paramLong)
    {
      AppMethodBeat.i(330390);
      Object localObject = a.a.ANi;
      localObject = new a.a(a.a.dYo(), paramLong);
      this.ANG.c((b)localObject);
      AppMethodBeat.o(330390);
    }
    
    public final void mZ(long paramLong)
    {
      AppMethodBeat.i(330326);
      Object localObject = a.a.ANi;
      localObject = new a.a(a.a.dYw(), paramLong);
      this.ANG.c((b)localObject);
      AppMethodBeat.o(330326);
    }
    
    public final void na(long paramLong)
    {
      AppMethodBeat.i(330345);
      Object localObject = a.a.ANi;
      localObject = new a.a(a.a.dYp(), paramLong);
      this.ANG.c((b)localObject);
      AppMethodBeat.o(330345);
    }
    
    public final void nb(long paramLong)
    {
      AppMethodBeat.i(330348);
      Object localObject = a.a.ANi;
      localObject = new a.a(a.a.dYq(), paramLong);
      this.ANG.c((b)localObject);
      AppMethodBeat.o(330348);
    }
    
    public final void nc(long paramLong)
    {
      AppMethodBeat.i(330355);
      Object localObject = a.a.ANi;
      localObject = new a.a(a.a.dYr(), paramLong);
      this.ANG.c((b)localObject);
      AppMethodBeat.o(330355);
    }
    
    public final void nd(long paramLong)
    {
      AppMethodBeat.i(330359);
      Object localObject = a.a.ANi;
      localObject = new a.a(a.a.dYs(), paramLong);
      this.ANG.c((b)localObject);
      AppMethodBeat.o(330359);
    }
    
    public final void ne(long paramLong)
    {
      AppMethodBeat.i(330339);
      Object localObject = a.a.ANi;
      localObject = new a.a(a.a.dYt(), paramLong);
      this.ANG.c((b)localObject);
      AppMethodBeat.o(330339);
    }
    
    public final void nf(long paramLong)
    {
      AppMethodBeat.i(330335);
      Object localObject = a.a.ANi;
      localObject = new a.a(a.a.dYu(), paramLong);
      this.ANG.c((b)localObject);
      AppMethodBeat.o(330335);
    }
    
    public final void ng(long paramLong)
    {
      AppMethodBeat.i(330332);
      Object localObject = a.a.ANi;
      localObject = new a.a(a.a.dYv(), paramLong);
      this.ANG.c((b)localObject);
      AppMethodBeat.o(330332);
    }
    
    public final void nh(long paramLong)
    {
      AppMethodBeat.i(330321);
      Object localObject = a.a.ANi;
      localObject = new a.a(a.a.dYx(), paramLong);
      this.ANG.c((b)localObject);
      AppMethodBeat.o(330321);
    }
    
    public final void ni(long paramLong)
    {
      AppMethodBeat.i(330317);
      Object localObject = a.a.ANi;
      localObject = new a.a(a.a.dYy(), paramLong);
      this.ANG.c((b)localObject);
      AppMethodBeat.o(330317);
    }
    
    public final void nj(long paramLong)
    {
      AppMethodBeat.i(330313);
      Object localObject = a.a.ANi;
      localObject = new a.a(a.a.dYz(), paramLong);
      this.ANG.c((b)localObject);
      AppMethodBeat.o(330313);
    }
    
    public final void nk(long paramLong)
    {
      AppMethodBeat.i(330308);
      Object localObject = a.a.ANi;
      localObject = new a.a(a.a.dYA(), paramLong);
      this.ANG.c((b)localObject);
      AppMethodBeat.o(330308);
    }
    
    public final void nl(long paramLong)
    {
      AppMethodBeat.i(330298);
      Object localObject = a.a.ANi;
      localObject = new a.a(a.a.dYB(), paramLong);
      this.ANG.c((b)localObject);
      AppMethodBeat.o(330298);
    }
    
    public final void nm(long paramLong)
    {
      AppMethodBeat.i(330302);
      Object localObject = a.a.ANi;
      localObject = new a.a(a.a.dYC(), paramLong);
      this.ANG.c((b)localObject);
      AppMethodBeat.o(330302);
    }
    
    public final void nn(long paramLong)
    {
      AppMethodBeat.i(330305);
      Object localObject = a.a.ANi;
      localObject = new a.a(a.a.dYD(), paramLong);
      this.ANG.c((b)localObject);
      AppMethodBeat.o(330305);
    }
    
    public final void no(long paramLong)
    {
      AppMethodBeat.i(330293);
      Object localObject = a.a.ANi;
      localObject = new a.a(a.a.dYE(), paramLong);
      this.ANG.c((b)localObject);
      AppMethodBeat.o(330293);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.a
 * JD-Core Version:    0.7.0.1
 */