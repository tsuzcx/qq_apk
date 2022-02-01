package com.tencent.mm.plugin.finder.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.thumbplayer.e.b.b;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.protocal.protobuf.afb;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.vfs.y;
import com.tencent.mm.videocomposition.a.a;
import com.tencent.mm.videocomposition.j;
import com.tencent.mm.xeffect.effect.EffectManager;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/FinderVideoThumbFetcherFactory;", "", "()V", "getThumbFetcher", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "width", "", "height", "extra", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
{
  public static final p Grl;
  
  static
  {
    AppMethodBeat.i(334822);
    Grl = new p();
    AppMethodBeat.o(334822);
  }
  
  public static com.tencent.mm.videocomposition.c a(final dji paramdji, int paramInt1, int paramInt2, Object paramObject)
  {
    AppMethodBeat.i(334816);
    s.u(paramdji, "media");
    Object localObject1 = paramdji.aaDI;
    Object localObject2 = av.GiL;
    if ((!av.i(paramdji)) && (localObject1 != null))
    {
      paramdji = new EffectManager();
      paramObject = com.tencent.mm.plugin.vlog.model.h.d((afb)localObject1, paramdji);
      localObject1 = com.tencent.mm.plugin.vlog.model.h.e((afb)localObject1);
      ((com.tencent.mm.plugin.recordvideo.ui.editor.b.c)localObject1).start();
      paramObject.aK((kotlin.g.a.b)localObject1);
      long l = paramObject.Uaw.getPlayStart();
      localObject2 = com.tencent.mm.videocomposition.a.agDr;
      paramdji = (com.tencent.mm.videocomposition.c)new z(l, (com.tencent.mm.videocomposition.c)a.a.e(paramObject.getComposition()), (kotlin.g.a.a)new a((com.tencent.mm.plugin.recordvideo.ui.editor.b.c)localObject1, paramdji));
      AppMethodBeat.o(334816);
      return paramdji;
    }
    if (y.ZC(paramdji.url))
    {
      paramdji = (com.tencent.mm.videocomposition.c)new h(paramdji);
      AppMethodBeat.o(334816);
      return paramdji;
    }
    localObject1 = new com.tencent.mm.plugin.finder.loader.v(paramdji, com.tencent.mm.plugin.finder.storage.v.FLk, 0, null, 12);
    localObject1 = new com.tencent.mm.plugin.thumbplayer.a.b(((com.tencent.mm.plugin.finder.loader.v)localObject1).aUt(), ((com.tencent.mm.plugin.finder.loader.v)localObject1).getPath(), ((com.tencent.mm.plugin.finder.loader.v)localObject1).getUrl() + '/' + ((com.tencent.mm.plugin.finder.loader.v)localObject1).eCf(), (int)paramdji.width, (int)paramdji.height);
    ((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).decodeKey = paramdji.decodeKey;
    localObject1 = new com.tencent.mm.plugin.finder.video.thumb.c((com.tencent.mm.plugin.thumbplayer.a.b)localObject1);
    ((com.tencent.mm.plugin.vlog.ui.thumb.a)localObject1).width = paramInt1;
    ((com.tencent.mm.plugin.vlog.ui.thumb.a)localObject1).height = paramInt2;
    if ((paramObject instanceof b.b)) {}
    for (paramdji = (b.b)paramObject;; paramdji = null)
    {
      paramdji = (com.tencent.mm.videocomposition.c)new com.tencent.mm.plugin.finder.video.thumb.b((com.tencent.mm.plugin.finder.video.thumb.c)localObject1, paramdji);
      AppMethodBeat.o(334816);
      return paramdji;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(com.tencent.mm.plugin.recordvideo.ui.editor.b.c paramc, EffectManager paramEffectManager)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.p
 * JD-Core Version:    0.7.0.1
 */