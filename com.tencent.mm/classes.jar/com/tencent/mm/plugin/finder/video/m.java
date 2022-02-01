package com.tencent.mm.plugin.finder.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.e;
import com.tencent.mm.plugin.finder.utils.n;
import com.tencent.mm.plugin.vlog.model.r;
import com.tencent.mm.plugin.vlog.model.t;
import com.tencent.mm.plugin.vlog.model.t.a;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.protocal.protobuf.yo;
import d.g.a.a;
import d.g.a.b;
import d.g.b.k;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/video/FinderVideoThumbFetcherFactory;", "", "()V", "getThumbFetcher", "Lcom/tencent/mm/plugin/vlog/ui/thumb/ITrackThumbFetcher;", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "width", "", "height", "plugin-finder_release"})
public final class m
{
  public static final m rTs;
  
  static
  {
    AppMethodBeat.i(203909);
    rTs = new m();
    AppMethodBeat.o(203909);
  }
  
  public static com.tencent.mm.plugin.vlog.ui.thumb.c a(bqs parambqs, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(203908);
    k.h(parambqs, "media");
    Object localObject1 = parambqs.FfQ;
    Object localObject2 = n.rPN;
    if ((!n.c(parambqs)) && (localObject1 != null))
    {
      parambqs = com.tencent.mm.plugin.vlog.model.c.a((yo)localObject1);
      parambqs.hY(paramInt1, paramInt2);
      localObject1 = com.tencent.mm.plugin.vlog.model.c.b((yo)localObject1);
      ((e)localObject1).start();
      parambqs.D((b)localObject1);
      long l = parambqs.efB();
      localObject2 = t.Aop;
      parambqs = (com.tencent.mm.plugin.vlog.ui.thumb.c)new s(l, (com.tencent.mm.plugin.vlog.ui.thumb.c)t.a.f(parambqs), (a)new a((e)localObject1));
      AppMethodBeat.o(203908);
      return parambqs;
    }
    parambqs = (com.tencent.mm.plugin.vlog.ui.thumb.c)new f(parambqs);
    AppMethodBeat.o(203908);
    return parambqs;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements a<y>
  {
    a(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.m
 * JD-Core Version:    0.7.0.1
 */