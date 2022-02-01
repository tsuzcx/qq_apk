package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.b;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.e;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.protocal.protobuf.bvf;
import d.g.b.p;
import d.l;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/PageChangeSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/EventSubscriber;", "Lcom/tencent/mm/plugin/finder/report/PageChangeSubscriber$PageChangeBehavior;", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "getBehavior", "PageChangeBehavior", "PageChangeEvent", "plugin-finder_release"})
public final class v
  extends e<a>
{
  public v(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(166715);
    AppMethodBeat.o(166715);
  }
  
  public final a cEA()
  {
    AppMethodBeat.i(166714);
    a locala = (a)new c(this);
    AppMethodBeat.o(166714);
    return locala;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/PageChangeSubscriber$PageChangeBehavior;", "", "onPageChange", "", "feedId", "", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "objectNonceId", "", "index", "", "mediaList", "Ljava/util/LinkedList;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(long paramLong, bvf parambvf, String paramString, int paramInt, LinkedList<bvf> paramLinkedList, BaseFinderFeed paramBaseFinderFeed);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/report/PageChangeSubscriber$PageChangeEvent;", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "feedId", "", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "objectNonceId", "", "index", "", "mediaList", "Ljava/util/LinkedList;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "(JLcom/tencent/mm/protocal/protobuf/LocalFinderMedia;Ljava/lang/String;ILjava/util/LinkedList;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeedId", "()J", "getIndex", "()I", "getMedia", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getMediaList", "()Ljava/util/LinkedList;", "getObjectNonceId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "plugin-finder_release"})
  public static final class b
    extends b
  {
    final long dtq;
    final int index;
    private final LinkedList<bvf> mediaList;
    private final String objectNonceId;
    private final BaseFinderFeed rQZ;
    final bvf rQt;
    
    public b(long paramLong, bvf parambvf, String paramString, int paramInt, LinkedList<bvf> paramLinkedList, BaseFinderFeed paramBaseFinderFeed)
    {
      AppMethodBeat.i(166709);
      this.dtq = paramLong;
      this.rQt = parambvf;
      this.objectNonceId = paramString;
      this.index = paramInt;
      this.mediaList = paramLinkedList;
      this.rQZ = paramBaseFinderFeed;
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
          if ((this.dtq != paramObject.dtq) || (!p.i(this.rQt, paramObject.rQt)) || (!p.i(this.objectNonceId, paramObject.objectNonceId)) || (this.index != paramObject.index) || (!p.i(this.mediaList, paramObject.mediaList)) || (!p.i(this.rQZ, paramObject.rQZ))) {}
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
      long l = this.dtq;
      int n = (int)(l ^ l >>> 32);
      Object localObject = this.rQt;
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
        localObject = this.rQZ;
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
      String str = "PageChangeEvent(feedId=" + this.dtq + ", media=" + this.rQt + ", objectNonceId=" + this.objectNonceId + ", index=" + this.index + ", mediaList=" + this.mediaList + ", feed=" + this.rQZ + ")";
      AppMethodBeat.o(166710);
      return str;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/report/PageChangeSubscriber$getBehavior$1", "Lcom/tencent/mm/plugin/finder/report/PageChangeSubscriber$PageChangeBehavior;", "onPageChange", "", "feedId", "", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "objectNonceId", "", "index", "", "mediaList", "Ljava/util/LinkedList;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "plugin-finder_release"})
  public static final class c
    implements v.a
  {
    public final void a(long paramLong, bvf parambvf, String paramString, int paramInt, LinkedList<bvf> paramLinkedList, BaseFinderFeed paramBaseFinderFeed)
    {
      AppMethodBeat.i(166713);
      p.h(parambvf, "media");
      p.h(paramString, "objectNonceId");
      p.h(paramLinkedList, "mediaList");
      p.h(paramBaseFinderFeed, "feed");
      parambvf = new v.b(paramLong, parambvf, paramString, paramInt, paramLinkedList, paramBaseFinderFeed);
      this.ssu.c((b)parambvf);
      AppMethodBeat.o(166713);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.v
 * JD-Core Version:    0.7.0.1
 */