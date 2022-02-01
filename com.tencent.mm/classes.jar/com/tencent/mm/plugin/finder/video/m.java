package com.tencent.mm.plugin.finder.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.v;
import com.tencent.mm.protocal.protobuf.aaq;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.videocomposition.a.a;
import com.tencent.mm.videocomposition.h;
import d.g.a.b;
import d.g.b.q;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/video/FinderVideoThumbFetcherFactory;", "", "()V", "getThumbFetcher", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "width", "", "height", "plugin-finder_release"})
public final class m
{
  public static final m tbn;
  
  static
  {
    AppMethodBeat.i(205486);
    tbn = new m();
    AppMethodBeat.o(205486);
  }
  
  public static com.tencent.mm.videocomposition.c f(bvz parambvz)
  {
    AppMethodBeat.i(205485);
    d.g.b.p.h(parambvz, "media");
    Object localObject1 = parambvz.HiW;
    Object localObject2 = com.tencent.mm.plugin.finder.utils.p.sXz;
    if ((!com.tencent.mm.plugin.finder.utils.p.d(parambvz)) && (localObject1 != null))
    {
      parambvz = com.tencent.mm.plugin.vlog.model.f.a((aaq)localObject1);
      localObject1 = com.tencent.mm.plugin.vlog.model.f.b((aaq)localObject1);
      ((com.tencent.mm.plugin.recordvideo.ui.editor.b.c)localObject1).start();
      parambvz.F((b)localObject1);
      long l = parambvz.BXI.getPlayStart();
      localObject2 = com.tencent.mm.videocomposition.a.LJa;
      parambvz = (com.tencent.mm.videocomposition.c)new s(l, (com.tencent.mm.videocomposition.c)a.a.b(parambvz.getComposition()), (d.g.a.a)new a((com.tencent.mm.plugin.recordvideo.ui.editor.b.c)localObject1));
      AppMethodBeat.o(205485);
      return parambvz;
    }
    parambvz = (com.tencent.mm.videocomposition.c)new f(parambvz);
    AppMethodBeat.o(205485);
    return parambvz;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.m
 * JD-Core Version:    0.7.0.1
 */