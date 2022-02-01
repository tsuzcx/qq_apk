package com.tencent.mm.plugin.finder.event;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.b;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.e;
import com.tencent.mm.plugin.finder.report.d;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/event/FinderFeedSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/EventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/FinderFeedSubscriber$FeedBehavior;", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "getBehavior", "ActionEvent", "FeedBehavior", "plugin-finder_release"})
public final class a
  extends e<b>
{
  public a(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(201389);
    AppMethodBeat.o(201389);
  }
  
  public final b ctb()
  {
    AppMethodBeat.i(201388);
    b localb = (b)new c(this);
    AppMethodBeat.o(201388);
    return localb;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/event/FinderFeedSubscriber$ActionEvent;", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "type", "", "feedId", "", "(IJ)V", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFeed", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFeed", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "getFeedId", "()J", "getType", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "Companion", "plugin-finder_release"})
  public static final class a
    extends b
  {
    private static final int rcF = 1;
    private static final int rcG = 2;
    private static final int rcH = 3;
    private static final int rcI = 4;
    private static final int rcJ = 5;
    private static final int rcK = 6;
    private static final int rcL = 7;
    private static final int rcM = 8;
    private static final int rcN = 9;
    private static final int rcO = 10;
    private static final int rcP = 11;
    private static final int rcQ = 12;
    private static final int rcR = 13;
    private static final int rcS = 14;
    private static final int rcT = 15;
    private static final int rcU = 16;
    private static final int rcV = 17;
    public static final a.a.a rcW;
    public final long dig;
    private FinderItem feed;
    public final int type;
    
    static
    {
      AppMethodBeat.i(201369);
      rcW = new a.a.a((byte)0);
      rcF = 1;
      rcG = 2;
      rcH = 3;
      rcI = 4;
      rcJ = 5;
      rcK = 6;
      rcL = 7;
      rcM = 8;
      rcN = 9;
      rcO = 10;
      rcP = 11;
      rcQ = 12;
      rcR = 13;
      rcS = 14;
      rcT = 15;
      rcU = 16;
      rcV = 17;
      AppMethodBeat.o(201369);
    }
    
    public a(int paramInt, long paramLong)
    {
      AppMethodBeat.i(201368);
      this.type = paramInt;
      this.dig = paramLong;
      d locald = d.rxr;
      this.feed = d.ur(this.dig);
      AppMethodBeat.o(201368);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.type != paramObject.type) || (this.dig != paramObject.dig)) {}
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
      long l = this.dig;
      return i * 31 + (int)(l ^ l >>> 32);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(201370);
      String str = "ActionEvent(type=" + this.type + ", feedId=" + this.dig + ")";
      AppMethodBeat.o(201370);
      return str;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/event/FinderFeedSubscriber$FeedBehavior;", "", "onFeedCancelShareToChat", "", "feedId", "", "onFeedCancelShareToSns", "onFeedClickAvatar", "onFeedClickComment", "onFeedClickComplain", "onFeedClickLikeComment", "onFeedClickMore", "onFeedClickPoi", "onFeedCollapseAllText", "onFeedFav", "onFeedLike", "onFeedOpenAllText", "onFeedShareToChat", "onFeedShareToSns", "onFeedUnFav", "onFeedUnLike", "onNotInteresting", "plugin-finder_release"})
  public static abstract interface b
  {
    public abstract void tO(long paramLong);
    
    public abstract void tP(long paramLong);
    
    public abstract void tQ(long paramLong);
    
    public abstract void tR(long paramLong);
    
    public abstract void tS(long paramLong);
    
    public abstract void tT(long paramLong);
    
    public abstract void tU(long paramLong);
    
    public abstract void tV(long paramLong);
    
    public abstract void tW(long paramLong);
    
    public abstract void tX(long paramLong);
    
    public abstract void tY(long paramLong);
    
    public abstract void tZ(long paramLong);
    
    public abstract void ua(long paramLong);
    
    public abstract void ub(long paramLong);
    
    public abstract void uc(long paramLong);
    
    public abstract void ud(long paramLong);
    
    public abstract void ue(long paramLong);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/event/FinderFeedSubscriber$getBehavior$1", "Lcom/tencent/mm/plugin/finder/event/FinderFeedSubscriber$FeedBehavior;", "onFeedCancelShareToChat", "", "feedId", "", "onFeedCancelShareToSns", "onFeedClickAvatar", "onFeedClickComment", "onFeedClickComplain", "onFeedClickLikeComment", "onFeedClickMore", "onFeedClickPoi", "onFeedCollapseAllText", "onFeedFav", "onFeedLike", "onFeedOpenAllText", "onFeedShareToChat", "onFeedShareToSns", "onFeedUnFav", "onFeedUnLike", "onNotInteresting", "plugin-finder_release"})
  public static final class c
    implements a.b
  {
    public final void tO(long paramLong)
    {
      AppMethodBeat.i(201383);
      Object localObject = a.a.rcW;
      localObject = new a.a(a.a.ctc(), paramLong);
      this.rcX.c((b)localObject);
      AppMethodBeat.o(201383);
    }
    
    public final void tP(long paramLong)
    {
      AppMethodBeat.i(201384);
      Object localObject = a.a.rcW;
      localObject = new a.a(a.a.ctd(), paramLong);
      this.rcX.c((b)localObject);
      AppMethodBeat.o(201384);
    }
    
    public final void tQ(long paramLong)
    {
      AppMethodBeat.i(201385);
      Object localObject = a.a.rcW;
      localObject = new a.a(a.a.cte(), paramLong);
      this.rcX.c((b)localObject);
      AppMethodBeat.o(201385);
    }
    
    public final void tR(long paramLong)
    {
      AppMethodBeat.i(201386);
      Object localObject = a.a.rcW;
      localObject = new a.a(a.a.ctf(), paramLong);
      this.rcX.c((b)localObject);
      AppMethodBeat.o(201386);
    }
    
    public final void tS(long paramLong)
    {
      AppMethodBeat.i(201387);
      Object localObject = a.a.rcW;
      localObject = new a.a(a.a.ctg(), paramLong);
      this.rcX.c((b)localObject);
      AppMethodBeat.o(201387);
    }
    
    public final void tT(long paramLong)
    {
      AppMethodBeat.i(201375);
      Object localObject = a.a.rcW;
      localObject = new a.a(a.a.cto(), paramLong);
      this.rcX.c((b)localObject);
      AppMethodBeat.o(201375);
    }
    
    public final void tU(long paramLong)
    {
      AppMethodBeat.i(201379);
      Object localObject = a.a.rcW;
      localObject = new a.a(a.a.cth(), paramLong);
      this.rcX.c((b)localObject);
      AppMethodBeat.o(201379);
    }
    
    public final void tV(long paramLong)
    {
      AppMethodBeat.i(201380);
      Object localObject = a.a.rcW;
      localObject = new a.a(a.a.cti(), paramLong);
      this.rcX.c((b)localObject);
      AppMethodBeat.o(201380);
    }
    
    public final void tW(long paramLong)
    {
      AppMethodBeat.i(201381);
      Object localObject = a.a.rcW;
      localObject = new a.a(a.a.ctj(), paramLong);
      this.rcX.c((b)localObject);
      AppMethodBeat.o(201381);
    }
    
    public final void tX(long paramLong)
    {
      AppMethodBeat.i(201382);
      Object localObject = a.a.rcW;
      localObject = new a.a(a.a.ctk(), paramLong);
      this.rcX.c((b)localObject);
      AppMethodBeat.o(201382);
    }
    
    public final void tY(long paramLong)
    {
      AppMethodBeat.i(201378);
      Object localObject = a.a.rcW;
      localObject = new a.a(a.a.ctl(), paramLong);
      this.rcX.c((b)localObject);
      AppMethodBeat.o(201378);
    }
    
    public final void tZ(long paramLong)
    {
      AppMethodBeat.i(201377);
      Object localObject = a.a.rcW;
      localObject = new a.a(a.a.ctm(), paramLong);
      this.rcX.c((b)localObject);
      AppMethodBeat.o(201377);
    }
    
    public final void ua(long paramLong)
    {
      AppMethodBeat.i(201376);
      Object localObject = a.a.rcW;
      localObject = new a.a(a.a.ctn(), paramLong);
      this.rcX.c((b)localObject);
      AppMethodBeat.o(201376);
    }
    
    public final void ub(long paramLong)
    {
      AppMethodBeat.i(201374);
      Object localObject = a.a.rcW;
      localObject = new a.a(a.a.ctp(), paramLong);
      this.rcX.c((b)localObject);
      AppMethodBeat.o(201374);
    }
    
    public final void uc(long paramLong)
    {
      AppMethodBeat.i(201373);
      Object localObject = a.a.rcW;
      localObject = new a.a(a.a.ctq(), paramLong);
      this.rcX.c((b)localObject);
      AppMethodBeat.o(201373);
    }
    
    public final void ud(long paramLong)
    {
      AppMethodBeat.i(201372);
      Object localObject = a.a.rcW;
      localObject = new a.a(a.a.ctr(), paramLong);
      this.rcX.c((b)localObject);
      AppMethodBeat.o(201372);
    }
    
    public final void ue(long paramLong)
    {
      AppMethodBeat.i(201371);
      Object localObject = a.a.rcW;
      localObject = new a.a(a.a.cts(), paramLong);
      this.rcX.c((b)localObject);
      AppMethodBeat.o(201371);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.a
 * JD-Core Version:    0.7.0.1
 */