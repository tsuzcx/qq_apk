package com.tencent.mm.plugin.finder.loader;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.loader.f;
import com.tencent.mm.loader.h.b.a;
import com.tencent.mm.plugin.finder.utils.aj;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/loader/FinderBitmapProducer;", "Lcom/tencent/mm/loader/impr/imageproducer/InputStreamBitmapProducer;", "()V", "asResource", "Lcom/tencent/mm/loader/model/Resource;", "Landroid/graphics/Bitmap;", "targetView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "input", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "Companion", "plugin-finder_release"})
public class i
  extends com.tencent.mm.loader.e.a.c
{
  public static final a zts;
  
  static
  {
    AppMethodBeat.i(166301);
    zts = new a((byte)0);
    AppMethodBeat.o(166301);
  }
  
  public com.tencent.mm.loader.h.e<Bitmap> a(g<?> paramg, f<?, Bitmap> paramf, a parama)
  {
    AppMethodBeat.i(166300);
    p.k(paramg, "targetView");
    p.k(paramf, "reaper");
    p.k(parama, "input");
    paramg = null;
    com.tencent.mm.ae.c localc = new com.tencent.mm.ae.c("FinderBitmapProducer");
    parama = parama.aSw();
    if (parama != null)
    {
      int i = paramf.kMB.kOf;
      int j = paramf.kMB.kOg;
      paramg = aj.AGc;
      paramg = aj.c(parama, i, j);
      paramf = x.aazN;
    }
    localc.aIZ();
    paramg = new com.tencent.mm.loader.h.e(paramg);
    AppMethodBeat.o(166300);
    return paramg;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/loader/FinderBitmapProducer$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.i
 * JD-Core Version:    0.7.0.1
 */