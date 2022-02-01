package com.tencent.mm.plugin.finder.loader;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.e.a.c;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.loader.f;
import com.tencent.mm.loader.h.b.a;
import com.tencent.mm.plugin.finder.utils.n;
import d.g.b.k;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/loader/FinderBitmapProducer;", "Lcom/tencent/mm/loader/impr/imageproducer/InputStreamBitmapProducer;", "()V", "asResource", "Lcom/tencent/mm/loader/model/Resource;", "Landroid/graphics/Bitmap;", "targetView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "input", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "Companion", "plugin-finder_release"})
public final class b
  extends c
{
  public static final b.a rtg;
  
  static
  {
    AppMethodBeat.i(166301);
    rtg = new b.a((byte)0);
    AppMethodBeat.o(166301);
  }
  
  public final com.tencent.mm.loader.h.e<Bitmap> a(g<?> paramg, f<?, Bitmap> paramf, a parama)
  {
    AppMethodBeat.i(166300);
    k.h(paramg, "targetView");
    k.h(paramf, "reaper");
    k.h(parama, "input");
    paramg = null;
    com.tencent.mm.ac.b localb = new com.tencent.mm.ac.b("FinderBitmapProducer");
    parama = parama.aoS();
    if (parama != null)
    {
      int i = paramf.gIF.gKg;
      int j = paramf.gIF.gKh;
      paramg = n.rPN;
      paramg = n.a(parama, i, j);
      paramf = y.KTp;
    }
    localb.aic();
    paramg = new com.tencent.mm.loader.h.e(paramg);
    AppMethodBeat.o(166300);
    return paramg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.b
 * JD-Core Version:    0.7.0.1
 */