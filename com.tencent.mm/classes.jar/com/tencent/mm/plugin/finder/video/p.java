package com.tencent.mm.plugin.finder.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.i;
import com.tencent.mm.protocal.protobuf.acu;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.videocomposition.a.a;
import com.tencent.mm.videocomposition.j;
import com.tencent.mm.xeffect.effect.EffectManager;
import kotlin.g.a.b;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/FinderVideoThumbFetcherFactory;", "", "()V", "getThumbFetcher", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "width", "", "height", "plugin-finder_release"})
public final class p
{
  public static final p AOS;
  
  static
  {
    AppMethodBeat.i(278734);
    AOS = new p();
    AppMethodBeat.o(278734);
  }
  
  public static com.tencent.mm.videocomposition.c j(final csg paramcsg)
  {
    AppMethodBeat.i(278733);
    kotlin.g.b.p.k(paramcsg, "media");
    Object localObject1 = paramcsg.TpG;
    Object localObject2 = aj.AGc;
    if ((!aj.g(paramcsg)) && (localObject1 != null))
    {
      paramcsg = new EffectManager();
      localObject2 = i.d((acu)localObject1, paramcsg);
      localObject1 = i.c((acu)localObject1);
      ((com.tencent.mm.plugin.recordvideo.ui.editor.b.c)localObject1).start();
      ((ac)localObject2).aa((b)localObject1);
      long l = ((ac)localObject2).NmT.getPlayStart();
      a.a locala = com.tencent.mm.videocomposition.a.YHM;
      paramcsg = (com.tencent.mm.videocomposition.c)new x(l, (com.tencent.mm.videocomposition.c)a.a.e(((ac)localObject2).getComposition()), (kotlin.g.a.a)new a((com.tencent.mm.plugin.recordvideo.ui.editor.b.c)localObject1, paramcsg));
      AppMethodBeat.o(278733);
      return paramcsg;
    }
    paramcsg = (com.tencent.mm.videocomposition.c)new g(paramcsg);
    AppMethodBeat.o(278733);
    return paramcsg;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<kotlin.x>
  {
    a(com.tencent.mm.plugin.recordvideo.ui.editor.b.c paramc, EffectManager paramEffectManager)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.p
 * JD-Core Version:    0.7.0.1
 */