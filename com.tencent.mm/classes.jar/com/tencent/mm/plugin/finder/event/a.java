package com.tencent.mm.plugin.finder.event;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.b;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.e;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/event/FinderFeedSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/EventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/FinderFeedSubscriber$FeedBehavior;", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "getBehavior", "ActionEvent", "FeedBehavior", "plugin-finder_release"})
public final class a
  extends e<b>
{
  public a(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(243424);
    AppMethodBeat.o(243424);
  }
  
  public final b cZR()
  {
    AppMethodBeat.i(243423);
    b localb = (b)new c(this);
    AppMethodBeat.o(243423);
    return localb;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/event/FinderFeedSubscriber$ActionEvent;", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "type", "", "feedId", "", "(IJ)V", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFeed", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFeed", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "getFeedId", "()J", "getType", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "Companion", "plugin-finder_release"})
  public static final class a
    extends b
  {
    private static final int tHA = 12;
    private static final int tHB = 13;
    private static final int tHC = 14;
    private static final int tHD = 15;
    private static final int tHE = 16;
    private static final int tHF = 17;
    private static final int tHG = 18;
    private static final int tHH = 19;
    private static final int tHI = 20;
    public static final a tHJ;
    private static final int tHp = 1;
    private static final int tHq = 2;
    private static final int tHr = 3;
    private static final int tHs = 4;
    private static final int tHt = 5;
    private static final int tHu = 6;
    private static final int tHv = 7;
    private static final int tHw = 8;
    private static final int tHx = 9;
    private static final int tHy = 10;
    private static final int tHz = 11;
    public final long feedId;
    public FinderItem tHo;
    public final int type;
    
    static
    {
      AppMethodBeat.i(243401);
      tHJ = new a((byte)0);
      tHp = 1;
      tHq = 2;
      tHr = 3;
      tHs = 4;
      tHt = 5;
      tHu = 6;
      tHv = 7;
      tHw = 8;
      tHx = 9;
      tHy = 10;
      tHz = 11;
      tHA = 12;
      tHB = 13;
      tHC = 14;
      tHD = 15;
      tHE = 16;
      tHF = 17;
      tHG = 18;
      tHH = 19;
      tHI = 20;
      AppMethodBeat.o(243401);
    }
    
    public a(int paramInt, long paramLong)
    {
      AppMethodBeat.i(243400);
      this.type = paramInt;
      this.feedId = paramLong;
      k localk = k.vfA;
      this.tHo = k.Fc(this.feedId);
      AppMethodBeat.o(243400);
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
      AppMethodBeat.i(243402);
      String str = "ActionEvent(type=" + this.type + ", feedId=" + this.feedId + ")";
      AppMethodBeat.o(243402);
      return str;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/event/FinderFeedSubscriber$ActionEvent$Companion;", "", "()V", "CANCEL_SHARE_TO_CHAT", "", "getCANCEL_SHARE_TO_CHAT", "()I", "CANCEL_SHARE_TO_SNS", "getCANCEL_SHARE_TO_SNS", "CLICK_AT", "getCLICK_AT", "CLICK_AVATAR", "getCLICK_AVATAR", "CLICK_COMMENT", "getCLICK_COMMENT", "CLICK_COMPLAINS", "getCLICK_COMPLAINS", "CLICK_LIKE_COMMENT", "getCLICK_LIKE_COMMENT", "CLICK_LINK", "getCLICK_LINK", "CLICK_MORE", "getCLICK_MORE", "CLICK_POI", "getCLICK_POI", "CLICK_TOPIC", "getCLICK_TOPIC", "COLLAPSE_ALL_TEXT", "getCOLLAPSE_ALL_TEXT", "FAV", "getFAV", "LIKE", "getLIKE", "NOT_INTEREST", "getNOT_INTEREST", "OPEN_ALL_TEXT", "getOPEN_ALL_TEXT", "SHARE_TO_CHAT", "getSHARE_TO_CHAT", "SHARE_TO_SNS", "getSHARE_TO_SNS", "UNFAV", "getUNFAV", "UNLIKE", "getUNLIKE", "plugin-finder_release"})
    public static final class a {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/event/FinderFeedSubscriber$FeedBehavior;", "", "onFeedCancelShareToChat", "", "feedId", "", "onFeedCancelShareToSns", "onFeedClickAt", "onFeedClickAvatar", "onFeedClickComment", "onFeedClickComplain", "onFeedClickLikeComment", "onFeedClickLink", "onFeedClickMore", "onFeedClickPoi", "onFeedClickTopic", "onFeedCollapseAllText", "onFeedFav", "onFeedLike", "onFeedOpenAllText", "onFeedShareToChat", "onFeedShareToSns", "onFeedUnFav", "onFeedUnLike", "onNotInteresting", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract void EA(long paramLong);
    
    public abstract void Eh(long paramLong);
    
    public abstract void Ei(long paramLong);
    
    public abstract void Ej(long paramLong);
    
    public abstract void Ek(long paramLong);
    
    public abstract void El(long paramLong);
    
    public abstract void Em(long paramLong);
    
    public abstract void En(long paramLong);
    
    public abstract void Eo(long paramLong);
    
    public abstract void Ep(long paramLong);
    
    public abstract void Eq(long paramLong);
    
    public abstract void Er(long paramLong);
    
    public abstract void Es(long paramLong);
    
    public abstract void Et(long paramLong);
    
    public abstract void Eu(long paramLong);
    
    public abstract void Ev(long paramLong);
    
    public abstract void Ew(long paramLong);
    
    public abstract void Ex(long paramLong);
    
    public abstract void Ey(long paramLong);
    
    public abstract void Ez(long paramLong);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/event/FinderFeedSubscriber$getBehavior$1", "Lcom/tencent/mm/plugin/finder/event/FinderFeedSubscriber$FeedBehavior;", "onFeedCancelShareToChat", "", "feedId", "", "onFeedCancelShareToSns", "onFeedClickAt", "onFeedClickAvatar", "onFeedClickComment", "onFeedClickComplain", "onFeedClickLikeComment", "onFeedClickLink", "onFeedClickMore", "onFeedClickPoi", "onFeedClickTopic", "onFeedCollapseAllText", "onFeedFav", "onFeedLike", "onFeedOpenAllText", "onFeedShareToChat", "onFeedShareToSns", "onFeedUnFav", "onFeedUnLike", "onNotInteresting", "plugin-finder_release"})
  public static final class c
    implements a.b
  {
    public final void EA(long paramLong)
    {
      AppMethodBeat.i(243405);
      Object localObject = a.a.tHJ;
      localObject = new a.a(a.a.dal(), paramLong);
      this.tHK.c((b)localObject);
      AppMethodBeat.o(243405);
    }
    
    public final void Eh(long paramLong)
    {
      AppMethodBeat.i(243418);
      Object localObject = a.a.tHJ;
      localObject = new a.a(a.a.cZS(), paramLong);
      this.tHK.c((b)localObject);
      AppMethodBeat.o(243418);
    }
    
    public final void Ei(long paramLong)
    {
      AppMethodBeat.i(243419);
      Object localObject = a.a.tHJ;
      localObject = new a.a(a.a.cZT(), paramLong);
      this.tHK.c((b)localObject);
      AppMethodBeat.o(243419);
    }
    
    public final void Ej(long paramLong)
    {
      AppMethodBeat.i(243420);
      Object localObject = a.a.tHJ;
      localObject = new a.a(a.a.cZU(), paramLong);
      this.tHK.c((b)localObject);
      AppMethodBeat.o(243420);
    }
    
    public final void Ek(long paramLong)
    {
      AppMethodBeat.i(243421);
      Object localObject = a.a.tHJ;
      localObject = new a.a(a.a.cZV(), paramLong);
      this.tHK.c((b)localObject);
      AppMethodBeat.o(243421);
    }
    
    public final void El(long paramLong)
    {
      AppMethodBeat.i(243422);
      Object localObject = a.a.tHJ;
      localObject = new a.a(a.a.cZW(), paramLong);
      this.tHK.c((b)localObject);
      AppMethodBeat.o(243422);
    }
    
    public final void Em(long paramLong)
    {
      AppMethodBeat.i(243410);
      Object localObject = a.a.tHJ;
      localObject = new a.a(a.a.dae(), paramLong);
      this.tHK.c((b)localObject);
      AppMethodBeat.o(243410);
    }
    
    public final void En(long paramLong)
    {
      AppMethodBeat.i(243414);
      Object localObject = a.a.tHJ;
      localObject = new a.a(a.a.cZX(), paramLong);
      this.tHK.c((b)localObject);
      AppMethodBeat.o(243414);
    }
    
    public final void Eo(long paramLong)
    {
      AppMethodBeat.i(243415);
      Object localObject = a.a.tHJ;
      localObject = new a.a(a.a.cZY(), paramLong);
      this.tHK.c((b)localObject);
      AppMethodBeat.o(243415);
    }
    
    public final void Ep(long paramLong)
    {
      AppMethodBeat.i(243416);
      Object localObject = a.a.tHJ;
      localObject = new a.a(a.a.cZZ(), paramLong);
      this.tHK.c((b)localObject);
      AppMethodBeat.o(243416);
    }
    
    public final void Eq(long paramLong)
    {
      AppMethodBeat.i(243417);
      Object localObject = a.a.tHJ;
      localObject = new a.a(a.a.daa(), paramLong);
      this.tHK.c((b)localObject);
      AppMethodBeat.o(243417);
    }
    
    public final void Er(long paramLong)
    {
      AppMethodBeat.i(243413);
      Object localObject = a.a.tHJ;
      localObject = new a.a(a.a.dab(), paramLong);
      this.tHK.c((b)localObject);
      AppMethodBeat.o(243413);
    }
    
    public final void Es(long paramLong)
    {
      AppMethodBeat.i(243412);
      Object localObject = a.a.tHJ;
      localObject = new a.a(a.a.dac(), paramLong);
      this.tHK.c((b)localObject);
      AppMethodBeat.o(243412);
    }
    
    public final void Et(long paramLong)
    {
      AppMethodBeat.i(243411);
      Object localObject = a.a.tHJ;
      localObject = new a.a(a.a.dad(), paramLong);
      this.tHK.c((b)localObject);
      AppMethodBeat.o(243411);
    }
    
    public final void Eu(long paramLong)
    {
      AppMethodBeat.i(243409);
      Object localObject = a.a.tHJ;
      localObject = new a.a(a.a.daf(), paramLong);
      this.tHK.c((b)localObject);
      AppMethodBeat.o(243409);
    }
    
    public final void Ev(long paramLong)
    {
      AppMethodBeat.i(243408);
      Object localObject = a.a.tHJ;
      localObject = new a.a(a.a.dag(), paramLong);
      this.tHK.c((b)localObject);
      AppMethodBeat.o(243408);
    }
    
    public final void Ew(long paramLong)
    {
      AppMethodBeat.i(243407);
      Object localObject = a.a.tHJ;
      localObject = new a.a(a.a.dah(), paramLong);
      this.tHK.c((b)localObject);
      AppMethodBeat.o(243407);
    }
    
    public final void Ex(long paramLong)
    {
      AppMethodBeat.i(243406);
      Object localObject = a.a.tHJ;
      localObject = new a.a(a.a.dai(), paramLong);
      this.tHK.c((b)localObject);
      AppMethodBeat.o(243406);
    }
    
    public final void Ey(long paramLong)
    {
      AppMethodBeat.i(243403);
      Object localObject = a.a.tHJ;
      localObject = new a.a(a.a.daj(), paramLong);
      this.tHK.c((b)localObject);
      AppMethodBeat.o(243403);
    }
    
    public final void Ez(long paramLong)
    {
      AppMethodBeat.i(243404);
      Object localObject = a.a.tHJ;
      localObject = new a.a(a.a.dak(), paramLong);
      this.tHK.c((b)localObject);
      AppMethodBeat.o(243404);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.a
 * JD-Core Version:    0.7.0.1
 */