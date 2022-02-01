package com.tencent.mm.plugin.finder.loader;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d.b.g;
import com.tencent.mm.loader.f;
import com.tencent.mm.loader.g.b.a;
import com.tencent.mm.plugin.finder.utils.av;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/loader/FinderBitmapProducer;", "Lcom/tencent/mm/loader/impr/imageproducer/InputStreamBitmapProducer;", "()V", "asResource", "Lcom/tencent/mm/loader/model/Resource;", "Landroid/graphics/Bitmap;", "targetView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "input", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class e
  extends com.tencent.mm.loader.d.a.c
{
  public static final e.a Exl;
  
  static
  {
    AppMethodBeat.i(166301);
    Exl = new e.a((byte)0);
    AppMethodBeat.o(166301);
  }
  
  public com.tencent.mm.loader.g.e<Bitmap> a(g<?> paramg, f<?, Bitmap> paramf, a parama)
  {
    AppMethodBeat.i(166300);
    s.u(paramg, "targetView");
    s.u(paramf, "reaper");
    s.u(parama, "input");
    paramg = null;
    com.tencent.mm.ae.c localc = new com.tencent.mm.ae.c("FinderBitmapProducer");
    parama = parama.bmk();
    if (parama != null)
    {
      int i = paramf.nou.npU;
      int j = paramf.nou.npV;
      paramg = av.GiL;
      paramg = av.d(parama, i, j);
      paramf = ah.aiuX;
    }
    localc.bbW();
    paramg = new com.tencent.mm.loader.g.e(paramg);
    AppMethodBeat.o(166300);
    return paramg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.e
 * JD-Core Version:    0.7.0.1
 */