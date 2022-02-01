package com.tencent.mm.plugin.finder.loader;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.b;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.loader.f;
import com.tencent.mm.loader.h.b.a;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/loader/FinderBitmapProducer;", "Lcom/tencent/mm/loader/impr/imageproducer/InputStreamBitmapProducer;", "()V", "asResource", "Lcom/tencent/mm/loader/model/Resource;", "Landroid/graphics/Bitmap;", "targetView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "input", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "Companion", "plugin-finder_release"})
public final class c
  extends com.tencent.mm.loader.e.a.c
{
  public static final a srs;
  
  static
  {
    AppMethodBeat.i(166301);
    srs = new a((byte)0);
    AppMethodBeat.o(166301);
  }
  
  public final com.tencent.mm.loader.h.e<Bitmap> a(g<?> paramg, f<?, Bitmap> paramf, a parama)
  {
    AppMethodBeat.i(166300);
    d.g.b.p.h(paramg, "targetView");
    d.g.b.p.h(paramf, "reaper");
    d.g.b.p.h(parama, "input");
    paramg = null;
    b localb = new b("FinderBitmapProducer");
    parama = parama.arU();
    if (parama != null)
    {
      int i = paramf.hfd.hgF;
      int j = paramf.hfd.hgG;
      paramg = com.tencent.mm.plugin.finder.utils.p.sXz;
      paramg = com.tencent.mm.plugin.finder.utils.p.a(parama, i, j);
      paramf = z.Nhr;
    }
    localb.ald();
    paramg = new com.tencent.mm.loader.h.e(paramg);
    AppMethodBeat.o(166300);
    return paramg;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/loader/FinderBitmapProducer$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.c
 * JD-Core Version:    0.7.0.1
 */