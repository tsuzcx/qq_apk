package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.b;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.e;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.protocal.protobuf.cjl;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/PageChangeSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/EventSubscriber;", "Lcom/tencent/mm/plugin/finder/report/PageChangeSubscriber$PageChangeBehavior;", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "getBehavior", "PageChangeBehavior", "PageChangeEvent", "plugin-finder_release"})
public final class ag
  extends e<a>
{
  public ag(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(166715);
    AppMethodBeat.o(166715);
  }
  
  public final a doV()
  {
    AppMethodBeat.i(166714);
    a locala = (a)new c(this);
    AppMethodBeat.o(166714);
    return locala;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/PageChangeSubscriber$PageChangeBehavior;", "", "onPageChange", "", "feedId", "", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "objectNonceId", "", "index", "", "mediaList", "Ljava/util/LinkedList;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "isAuto", "", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(long paramLong, cjl paramcjl, String paramString, int paramInt, LinkedList<cjl> paramLinkedList, BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/PageChangeSubscriber$PageChangeEvent;", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "feedId", "", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "objectNonceId", "", "index", "", "mediaList", "Ljava/util/LinkedList;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "isAuto", "", "(JLcom/tencent/mm/protocal/protobuf/LocalFinderMedia;Ljava/lang/String;ILjava/util/LinkedList;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Z)V", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeedId", "()J", "getIndex", "()I", "()Z", "getMedia", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getMediaList", "()Ljava/util/LinkedList;", "getObjectNonceId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "toString", "plugin-finder_release"})
  public static final class b
    extends b
  {
    final long feedId;
    final int index;
    private final LinkedList<cjl> mediaList;
    private final String objectNonceId;
    final cjl tHM;
    private final BaseFinderFeed tNO;
    final boolean viJ;
    
    public b(long paramLong, cjl paramcjl, String paramString, int paramInt, LinkedList<cjl> paramLinkedList, BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean)
    {
      AppMethodBeat.i(250866);
      this.feedId = paramLong;
      this.tHM = paramcjl;
      this.objectNonceId = paramString;
      this.index = paramInt;
      this.mediaList = paramLinkedList;
      this.tNO = paramBaseFinderFeed;
      this.viJ = paramBoolean;
      AppMethodBeat.o(250866);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(166712);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((this.feedId != paramObject.feedId) || (!p.j(this.tHM, paramObject.tHM)) || (!p.j(this.objectNonceId, paramObject.objectNonceId)) || (this.index != paramObject.index) || (!p.j(this.mediaList, paramObject.mediaList)) || (!p.j(this.tNO, paramObject.tNO)) || (this.viJ != paramObject.viJ)) {}
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
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(166710);
      String str = "PageChangeEvent(feedId=" + this.feedId + ", media=" + this.tHM + ", objectNonceId=" + this.objectNonceId + ", index=" + this.index + ", mediaList=" + this.mediaList + ", feed=" + this.tNO + ", isAuto=" + this.viJ + ")";
      AppMethodBeat.o(166710);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/report/PageChangeSubscriber$getBehavior$1", "Lcom/tencent/mm/plugin/finder/report/PageChangeSubscriber$PageChangeBehavior;", "onPageChange", "", "feedId", "", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "objectNonceId", "", "index", "", "mediaList", "Ljava/util/LinkedList;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "isAuto", "", "plugin-finder_release"})
  public static final class c
    implements ag.a
  {
    public final void a(long paramLong, cjl paramcjl, String paramString, int paramInt, LinkedList<cjl> paramLinkedList, BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean)
    {
      AppMethodBeat.i(250867);
      p.h(paramcjl, "media");
      p.h(paramString, "objectNonceId");
      p.h(paramLinkedList, "mediaList");
      p.h(paramBaseFinderFeed, "feed");
      paramcjl = new ag.b(paramLong, paramcjl, paramString, paramInt, paramLinkedList, paramBaseFinderFeed, paramBoolean);
      this.viK.c((b)paramcjl);
      AppMethodBeat.o(250867);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.ag
 * JD-Core Version:    0.7.0.1
 */