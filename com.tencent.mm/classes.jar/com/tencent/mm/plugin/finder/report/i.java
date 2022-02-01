package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.event.base.g;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.protocal.protobuf.bmd;
import d.g.b.k;
import d.l;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/report/PageChangeSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/EventSubscriber;", "Lcom/tencent/mm/plugin/finder/report/PageChangeSubscriber$PageChangeBehavior;", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "getBehavior", "PageChangeBehavior", "PageChangeEvent", "plugin-finder_release"})
public final class i
  extends g<a>
{
  public i(d paramd)
  {
    super(paramd);
    AppMethodBeat.i(166715);
    AppMethodBeat.o(166715);
  }
  
  public final a coi()
  {
    AppMethodBeat.i(166714);
    a locala = (a)new c(this);
    AppMethodBeat.o(166714);
    return locala;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/report/PageChangeSubscriber$PageChangeBehavior;", "", "onPageChange", "", "feedId", "", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "objectNonceId", "", "index", "", "mediaList", "Ljava/util/LinkedList;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(long paramLong, bmd parambmd, String paramString, int paramInt, LinkedList<bmd> paramLinkedList, BaseFinderFeed paramBaseFinderFeed);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/report/PageChangeSubscriber$PageChangeEvent;", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "feedId", "", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "objectNonceId", "", "index", "", "mediaList", "Ljava/util/LinkedList;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "(JLcom/tencent/mm/protocal/protobuf/LocalFinderMedia;Ljava/lang/String;ILjava/util/LinkedList;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeedId", "()J", "getIndex", "()I", "getMedia", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getMediaList", "()Ljava/util/LinkedList;", "getObjectNonceId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "plugin-finder_release"})
  public static final class b
    extends c
  {
    final long feedId;
    public final int index;
    private final LinkedList<bmd> mediaList;
    private final String objectNonceId;
    private final BaseFinderFeed qHv;
    final bmd qsb;
    
    public b(long paramLong, bmd parambmd, String paramString, int paramInt, LinkedList<bmd> paramLinkedList, BaseFinderFeed paramBaseFinderFeed)
    {
      AppMethodBeat.i(166709);
      this.feedId = paramLong;
      this.qsb = parambmd;
      this.objectNonceId = paramString;
      this.index = paramInt;
      this.mediaList = paramLinkedList;
      this.qHv = paramBaseFinderFeed;
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
          if ((this.feedId != paramObject.feedId) || (!k.g(this.qsb, paramObject.qsb)) || (!k.g(this.objectNonceId, paramObject.objectNonceId)) || (this.index != paramObject.index) || (!k.g(this.mediaList, paramObject.mediaList)) || (!k.g(this.qHv, paramObject.qHv))) {}
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
      long l = this.feedId;
      int n = (int)(l ^ l >>> 32);
      Object localObject = this.qsb;
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
        localObject = this.qHv;
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
      String str = "PageChangeEvent(feedId=" + this.feedId + ", media=" + this.qsb + ", objectNonceId=" + this.objectNonceId + ", index=" + this.index + ", mediaList=" + this.mediaList + ", feed=" + this.qHv + ")";
      AppMethodBeat.o(166710);
      return str;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/report/PageChangeSubscriber$getBehavior$1", "Lcom/tencent/mm/plugin/finder/report/PageChangeSubscriber$PageChangeBehavior;", "onPageChange", "", "feedId", "", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "objectNonceId", "", "index", "", "mediaList", "Ljava/util/LinkedList;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "plugin-finder_release"})
  public static final class c
    implements i.a
  {
    public final void a(long paramLong, bmd parambmd, String paramString, int paramInt, LinkedList<bmd> paramLinkedList, BaseFinderFeed paramBaseFinderFeed)
    {
      AppMethodBeat.i(166713);
      k.h(parambmd, "media");
      k.h(paramString, "objectNonceId");
      k.h(paramLinkedList, "mediaList");
      k.h(paramBaseFinderFeed, "feed");
      parambmd = new i.b(paramLong, parambmd, paramString, paramInt, paramLinkedList, paramBaseFinderFeed);
      this.qHw.b((c)parambmd);
      AppMethodBeat.o(166713);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.i
 * JD-Core Version:    0.7.0.1
 */