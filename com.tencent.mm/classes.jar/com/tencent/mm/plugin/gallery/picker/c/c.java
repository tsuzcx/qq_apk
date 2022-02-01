package com.tencent.mm.plugin.gallery.picker.c;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.e.a.b;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.loader.f;
import com.tencent.mm.loader.h.b.a;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.h;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gallery/picker/loader/MediaHDProducer;", "Lcom/tencent/mm/loader/impr/imageproducer/ImageBitmapProducer;", "()V", "asResource", "Lcom/tencent/mm/loader/model/Resource;", "Landroid/graphics/Bitmap;", "targetView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "input", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "plugin-gallery_release"})
public final class c
  extends b
{
  public final com.tencent.mm.loader.h.e<Bitmap> a(g<?> paramg, f<?, Bitmap> paramf, a parama)
  {
    AppMethodBeat.i(164899);
    p.h(paramg, "targetView");
    p.h(paramf, "reaper");
    p.h(parama, "input");
    paramg = parama.getTag();
    if (paramg == null)
    {
      paramg = new v("null cannot be cast to non-null type com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem");
      AppMethodBeat.o(164899);
      throw paramg;
    }
    paramg = (GalleryItem.MediaItem)paramg;
    int i = paramf.hfd.hgG;
    int j = paramf.hfd.hgF;
    paramf = h.d(paramg.tRJ, i, j, false);
    i = h.aRB(paramg.tRJ);
    paramg = h.d(h.aRB(paramg.tRJ), paramf);
    paramf = new StringBuilder("bitmapW=");
    p.g(paramg, "result");
    ae.i("MicroMsg.Loader.ImageBitmapProducer", paramg.getWidth() + " bitmapH=" + paramg.getHeight() + " degree=" + i);
    paramg = new com.tencent.mm.loader.h.e(paramg);
    AppMethodBeat.o(164899);
    return paramg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.c.c
 * JD-Core Version:    0.7.0.1
 */