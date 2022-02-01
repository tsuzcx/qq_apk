package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.b;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.e;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.protocal.protobuf.bvz;
import d.g.b.p;
import d.l;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/report/PageChangeSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/EventSubscriber;", "Lcom/tencent/mm/plugin/finder/report/PageChangeSubscriber$PageChangeBehavior;", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "getBehavior", "PageChangeBehavior", "PageChangeEvent", "plugin-finder_release"})
public final class w
  extends e<a>
{
  public w(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(166715);
    AppMethodBeat.o(166715);
  }
  
  public final a cGw()
  {
    AppMethodBeat.i(166714);
    a locala = (a)new c(this);
    AppMethodBeat.o(166714);
    return locala;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/report/PageChangeSubscriber$PageChangeBehavior;", "", "onPageChange", "", "feedId", "", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "objectNonceId", "", "index", "", "mediaList", "Ljava/util/LinkedList;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(long paramLong, bvz parambvz, String paramString, int paramInt, LinkedList<bvz> paramLinkedList, BaseFinderFeed paramBaseFinderFeed);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/report/PageChangeSubscriber$PageChangeEvent;", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "feedId", "", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "objectNonceId", "", "index", "", "mediaList", "Ljava/util/LinkedList;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "(JLcom/tencent/mm/protocal/protobuf/LocalFinderMedia;Ljava/lang/String;ILjava/util/LinkedList;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeedId", "()J", "getIndex", "()I", "getMedia", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getMediaList", "()Ljava/util/LinkedList;", "getObjectNonceId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "plugin-finder_release"})
  public static final class b
    extends b
  {
    final long duw;
    final int index;
    private final LinkedList<bvz> mediaList;
    private final String objectNonceId;
    final bvz rYV;
    private final BaseFinderFeed rZB;
    
    public b(long paramLong, bvz parambvz, String paramString, int paramInt, LinkedList<bvz> paramLinkedList, BaseFinderFeed paramBaseFinderFeed)
    {
      AppMethodBeat.i(166709);
      this.duw = paramLong;
      this.rYV = parambvz;
      this.objectNonceId = paramString;
      this.index = paramInt;
      this.mediaList = paramLinkedList;
      this.rZB = paramBaseFinderFeed;
      AppMethodBeat.o(166709);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(166712);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((this.duw != paramObject.duw) || (!p.i(this.rYV, paramObject.rYV)) || (!p.i(this.objectNonceId, paramObject.objectNonceId)) || (this.index != paramObject.index) || (!p.i(this.mediaList, paramObject.mediaList)) || (!p.i(this.rZB, paramObject.rZB))) {}
        }
      }
      else
      {
        AppMethodBeat.o(166712);
        return true;
      }
      AppMethodBeat.o(166712);
      return false;
    }
    
    public final int hashCode()
    {
      int m = 0;
      AppMethodBeat.i(166711);
      long l = this.duw;
      int n = (int)(l ^ l >>> 32);
      Object localObject = this.rYV;
      int i;
      int j;
      label59:
      int i1;
      if (localObject != null)
      {
        i = localObject.hashCode();
        localObject = this.objectNonceId;
        if (localObject == null) {
          break label140;
        }
        j = localObject.hashCode();
        i1 = this.index;
        localObject = this.mediaList;
        if (localObject == null) {
          break label145;
        }
      }
      label140:
      label145:
      for (int k = localObject.hashCode();; k = 0)
      {
        localObject = this.rZB;
        if (localObject != null) {
          m = localObject.hashCode();
        }
        AppMethodBeat.o(166711);
        return (k + ((j + (i + n * 31) * 31) * 31 + i1) * 31) * 31 + m;
        i = 0;
        break;
        j = 0;
        break label59;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(166710);
      String str = "PageChangeEvent(feedId=" + this.duw + ", media=" + this.rYV + ", objectNonceId=" + this.objectNonceId + ", index=" + this.index + ", mediaList=" + this.mediaList + ", feed=" + this.rZB + ")";
      AppMethodBeat.o(166710);
      return str;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/report/PageChangeSubscriber$getBehavior$1", "Lcom/tencent/mm/plugin/finder/report/PageChangeSubscriber$PageChangeBehavior;", "onPageChange", "", "feedId", "", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "objectNonceId", "", "index", "", "mediaList", "Ljava/util/LinkedList;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "plugin-finder_release"})
  public static final class c
    implements w.a
  {
    public final void a(long paramLong, bvz parambvz, String paramString, int paramInt, LinkedList<bvz> paramLinkedList, BaseFinderFeed paramBaseFinderFeed)
    {
      AppMethodBeat.i(166713);
      p.h(parambvz, "media");
      p.h(paramString, "objectNonceId");
      p.h(paramLinkedList, "mediaList");
      p.h(paramBaseFinderFeed, "feed");
      parambvz = new w.b(paramLong, parambvz, paramString, paramInt, paramLinkedList, paramBaseFinderFeed);
      this.sCE.c((b)parambvz);
      AppMethodBeat.o(166713);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.w
 * JD-Core Version:    0.7.0.1
 */