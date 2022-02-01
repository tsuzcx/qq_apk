package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.b;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.e;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.protocal.protobuf.bqs;
import d.g.b.k;
import d.l;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/report/PageChangeSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/EventSubscriber;", "Lcom/tencent/mm/plugin/finder/report/PageChangeSubscriber$PageChangeBehavior;", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;)V", "getBehavior", "PageChangeBehavior", "PageChangeEvent", "plugin-finder_release"})
public final class p
  extends e<p.a>
{
  public p(c paramc)
  {
    super(paramc);
    AppMethodBeat.i(166715);
    AppMethodBeat.o(166715);
  }
  
  public final p.a cxE()
  {
    AppMethodBeat.i(166714);
    p.a locala = (p.a)new c(this);
    AppMethodBeat.o(166714);
    return locala;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/report/PageChangeSubscriber$getBehavior$1", "Lcom/tencent/mm/plugin/finder/report/PageChangeSubscriber$PageChangeBehavior;", "onPageChange", "", "feedId", "", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "objectNonceId", "", "index", "", "mediaList", "Ljava/util/LinkedList;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "plugin-finder_release"})
  public static final class c
    implements p.a
  {
    public final void a(long paramLong, bqs parambqs, String paramString, int paramInt, LinkedList<bqs> paramLinkedList, BaseFinderFeed paramBaseFinderFeed)
    {
      AppMethodBeat.i(166713);
      k.h(parambqs, "media");
      k.h(paramString, "objectNonceId");
      k.h(paramLinkedList, "mediaList");
      k.h(paramBaseFinderFeed, "feed");
      parambqs = new p.b(paramLong, parambqs, paramString, paramInt, paramLinkedList, paramBaseFinderFeed);
      this.rAs.c((b)parambqs);
      AppMethodBeat.o(166713);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.p
 * JD-Core Version:    0.7.0.1
 */