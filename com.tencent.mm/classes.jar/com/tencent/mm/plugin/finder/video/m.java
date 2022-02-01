package com.tencent.mm.plugin.finder.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.v;
import com.tencent.mm.protocal.protobuf.aan;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.videocomposition.a.a;
import com.tencent.mm.videocomposition.h;
import d.g.a.b;
import d.g.b.q;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/video/FinderVideoThumbFetcherFactory;", "", "()V", "getThumbFetcher", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "width", "", "height", "plugin-finder_release"})
public final class m
{
  public static final m sQc;
  
  static
  {
    AppMethodBeat.i(204861);
    sQc = new m();
    AppMethodBeat.o(204861);
  }
  
  public static com.tencent.mm.videocomposition.c f(bvf parambvf)
  {
    AppMethodBeat.i(204860);
    d.g.b.p.h(parambvf, "media");
    Object localObject1 = parambvf.GPu;
    Object localObject2 = com.tencent.mm.plugin.finder.utils.p.sMo;
    if ((!com.tencent.mm.plugin.finder.utils.p.d(parambvf)) && (localObject1 != null))
    {
      parambvf = com.tencent.mm.plugin.vlog.model.f.a((aan)localObject1);
      localObject1 = com.tencent.mm.plugin.vlog.model.f.b((aan)localObject1);
      ((com.tencent.mm.plugin.recordvideo.ui.editor.b.c)localObject1).start();
      parambvf.E((b)localObject1);
      long l = parambvf.BGk.getPlayStart();
      localObject2 = com.tencent.mm.videocomposition.a.Lmq;
      parambvf = (com.tencent.mm.videocomposition.c)new s(l, (com.tencent.mm.videocomposition.c)a.a.b(parambvf.getComposition()), (d.g.a.a)new a((com.tencent.mm.plugin.recordvideo.ui.editor.b.c)localObject1));
      AppMethodBeat.o(204860);
      return parambvf;
    }
    parambvf = (com.tencent.mm.videocomposition.c)new f(parambvf);
    AppMethodBeat.o(204860);
    return parambvf;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<z>
  {
    a(com.tencent.mm.plugin.recordvideo.ui.editor.b.c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.m
 * JD-Core Version:    0.7.0.1
 */