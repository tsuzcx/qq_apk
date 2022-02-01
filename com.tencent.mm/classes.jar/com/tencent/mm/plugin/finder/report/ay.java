package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.b;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.e;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.protocal.protobuf.dji;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/PageChangeSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/EventSubscriber;", "Lcom/tencent/mm/plugin/finder/report/PageChangeSubscriber$PageChangeBehavior;", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "getBehavior", "PageChangeBehavior", "PageChangeEvent", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ay
  extends e<a>
{
  public ay(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(166715);
    AppMethodBeat.o(166715);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/PageChangeSubscriber$PageChangeBehavior;", "", "onPageChange", "", "feedId", "", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "objectNonceId", "", "index", "", "mediaList", "Ljava/util/LinkedList;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "isAuto", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(long paramLong, dji paramdji, String paramString, int paramInt, LinkedList<dji> paramLinkedList, BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/PageChangeSubscriber$PageChangeEvent;", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "feedId", "", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "objectNonceId", "", "index", "", "mediaList", "Ljava/util/LinkedList;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "isAuto", "", "(JLcom/tencent/mm/protocal/protobuf/LocalFinderMedia;Ljava/lang/String;ILjava/util/LinkedList;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Z)V", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeedId", "()J", "getIndex", "()I", "()Z", "getMedia", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getMediaList", "()Ljava/util/LinkedList;", "getObjectNonceId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "toString", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends b
  {
    final boolean AAc;
    final dji ANJ;
    private final BaseFinderFeed AUZ;
    final long feedId;
    final int index;
    private final LinkedList<dji> mediaList;
    private final String objectNonceId;
    
    public b(long paramLong, dji paramdji, String paramString, int paramInt, LinkedList<dji> paramLinkedList, BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean)
    {
      AppMethodBeat.i(331058);
      this.feedId = paramLong;
      this.ANJ = paramdji;
      this.objectNonceId = paramString;
      this.index = paramInt;
      this.mediaList = paramLinkedList;
      this.AUZ = paramBaseFinderFeed;
      this.AAc = paramBoolean;
      AppMethodBeat.o(331058);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(166712);
      if (this == paramObject)
      {
        AppMethodBeat.o(166712);
        return true;
      }
      if (!(paramObject instanceof b))
      {
        AppMethodBeat.o(166712);
        return false;
      }
      paramObject = (b)paramObject;
      if (this.feedId != paramObject.feedId)
      {
        AppMethodBeat.o(166712);
        return false;
      }
      if (!s.p(this.ANJ, paramObject.ANJ))
      {
        AppMethodBeat.o(166712);
        return false;
      }
      if (!s.p(this.objectNonceId, paramObject.objectNonceId))
      {
        AppMethodBeat.o(166712);
        return false;
      }
      if (this.index != paramObject.index)
      {
        AppMethodBeat.o(166712);
        return false;
      }
      if (!s.p(this.mediaList, paramObject.mediaList))
      {
        AppMethodBeat.o(166712);
        return false;
      }
      if (!s.p(this.AUZ, paramObject.AUZ))
      {
        AppMethodBeat.o(166712);
        return false;
      }
      if (this.AAc != paramObject.AAc)
      {
        AppMethodBeat.o(166712);
        return false;
      }
      AppMethodBeat.o(166712);
      return true;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(166710);
      String str = "PageChangeEvent(feedId=" + this.feedId + ", media=" + this.ANJ + ", objectNonceId=" + this.objectNonceId + ", index=" + this.index + ", mediaList=" + this.mediaList + ", feed=" + this.AUZ + ", isAuto=" + this.AAc + ')';
      AppMethodBeat.o(166710);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/report/PageChangeSubscriber$getBehavior$1", "Lcom/tencent/mm/plugin/finder/report/PageChangeSubscriber$PageChangeBehavior;", "onPageChange", "", "feedId", "", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "objectNonceId", "", "index", "", "mediaList", "Ljava/util/LinkedList;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "isAuto", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements ay.a
  {
    public c(ay paramay) {}
    
    public final void a(long paramLong, dji paramdji, String paramString, int paramInt, LinkedList<dji> paramLinkedList, BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean)
    {
      AppMethodBeat.i(331046);
      s.u(paramdji, "media");
      s.u(paramString, "objectNonceId");
      s.u(paramLinkedList, "mediaList");
      s.u(paramBaseFinderFeed, "feed");
      paramdji = new ay.b(paramLong, paramdji, paramString, paramInt, paramLinkedList, paramBaseFinderFeed, paramBoolean);
      this.Fuz.c((b)paramdji);
      AppMethodBeat.o(331046);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.ay
 * JD-Core Version:    0.7.0.1
 */