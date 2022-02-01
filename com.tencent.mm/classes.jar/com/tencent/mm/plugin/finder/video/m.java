package com.tencent.mm.plugin.finder.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.f;
import com.tencent.mm.plugin.vlog.model.v;
import com.tencent.mm.plugin.vlog.model.x;
import com.tencent.mm.plugin.vlog.model.x.a;
import com.tencent.mm.plugin.vlog.ui.thumb.c;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.protocal.protobuf.dxw;
import d.g.a.a;
import d.g.a.b;
import d.g.b.k;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/FinderVideoThumbFetcherFactory;", "", "()V", "getThumbFetcher", "Lcom/tencent/mm/plugin/vlog/ui/thumb/ITrackThumbFetcher;", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "width", "", "height", "plugin-finder_release"})
public final class m
{
  public static final m LcV;
  
  static
  {
    AppMethodBeat.i(199844);
    LcV = new m();
    AppMethodBeat.o(199844);
  }
  
  public static c a(bmd parambmd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199843);
    k.h(parambmd, "media");
    Object localObject1 = parambmd.LzL;
    Object localObject2 = com.tencent.mm.plugin.finder.utils.i.qTa;
    if ((!com.tencent.mm.plugin.finder.utils.i.c(parambmd)) && (localObject1 != null))
    {
      parambmd = com.tencent.mm.plugin.vlog.model.m.a((dxw)localObject1);
      parambmd.lg(paramInt1, paramInt2);
      localObject1 = com.tencent.mm.plugin.vlog.model.m.b((dxw)localObject1);
      ((f)localObject1).start();
      parambmd.K((b)localObject1);
      localObject2 = x.Lrh;
      parambmd = (c)new r((c)x.a.f(parambmd), (a)new a((f)localObject1));
      AppMethodBeat.o(199843);
      return parambmd;
    }
    parambmd = (c)new i(parambmd);
    AppMethodBeat.o(199843);
    return parambmd;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements a<y>
  {
    a(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.m
 * JD-Core Version:    0.7.0.1
 */