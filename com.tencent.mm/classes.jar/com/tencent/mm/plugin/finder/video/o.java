package com.tencent.mm.plugin.finder.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.i;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.videocomposition.c.a;
import com.tencent.mm.videocomposition.n;
import com.tencent.mm.xeffect.effect.EffectManager;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/FinderVideoThumbFetcherFactory;", "", "()V", "getThumbFetcher", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "width", "", "height", "plugin-finder_release"})
public final class o
{
  public static final o wfX;
  
  static
  {
    AppMethodBeat.i(254381);
    wfX = new o();
    AppMethodBeat.o(254381);
  }
  
  public static com.tencent.mm.videocomposition.g m(final cjl paramcjl)
  {
    AppMethodBeat.i(254380);
    p.h(paramcjl, "media");
    Object localObject1 = paramcjl.MfU;
    Object localObject2 = y.vXH;
    if ((!y.h(paramcjl)) && (localObject1 != null))
    {
      paramcjl = new EffectManager();
      localObject2 = i.d((acn)localObject1, paramcjl);
      localObject1 = i.d((acn)localObject1);
      ((com.tencent.mm.plugin.recordvideo.ui.editor.b.c)localObject1).start();
      ((ac)localObject2).O((b)localObject1);
      long l = ((ac)localObject2).Gez.getPlayStart();
      c.a locala = com.tencent.mm.videocomposition.c.RgU;
      paramcjl = (com.tencent.mm.videocomposition.g)new w(l, (com.tencent.mm.videocomposition.g)c.a.b(((ac)localObject2).getComposition()), (a)new a((com.tencent.mm.plugin.recordvideo.ui.editor.b.c)localObject1, paramcjl));
      AppMethodBeat.o(254380);
      return paramcjl;
    }
    paramcjl = (com.tencent.mm.videocomposition.g)new g(paramcjl);
    AppMethodBeat.o(254380);
    return paramcjl;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<x>
  {
    a(com.tencent.mm.plugin.recordvideo.ui.editor.b.c paramc, EffectManager paramEffectManager)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.o
 * JD-Core Version:    0.7.0.1
 */