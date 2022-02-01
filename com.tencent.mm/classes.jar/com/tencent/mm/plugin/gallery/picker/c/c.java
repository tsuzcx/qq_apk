package com.tencent.mm.plugin.gallery.picker.c;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.e.a.b;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.loader.h.b.a;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/gallery/picker/loader/MediaHDProducer;", "Lcom/tencent/mm/loader/impr/imageproducer/ImageBitmapProducer;", "()V", "asResource", "Lcom/tencent/mm/loader/model/Resource;", "Landroid/graphics/Bitmap;", "targetView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "input", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "plugin-gallery_release"})
public final class c
  extends b
{
  public final com.tencent.mm.loader.h.e<Bitmap> a(g<?> paramg, com.tencent.mm.loader.f<?, Bitmap> paramf, a parama)
  {
    AppMethodBeat.i(164899);
    k.h(paramg, "targetView");
    k.h(paramf, "reaper");
    k.h(parama, "input");
    paramg = parama.getTag();
    if (paramg == null)
    {
      paramg = new v("null cannot be cast to non-null type com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem");
      AppMethodBeat.o(164899);
      throw paramg;
    }
    paramg = (GalleryItem.MediaItem)paramg;
    int i = paramf.gIF.gKh;
    int j = paramf.gIF.gKg;
    paramf = com.tencent.mm.sdk.platformtools.f.e(paramg.sKh, i, j, false);
    i = com.tencent.mm.sdk.platformtools.f.aKy(paramg.sKh);
    paramg = com.tencent.mm.sdk.platformtools.f.d(com.tencent.mm.sdk.platformtools.f.aKy(paramg.sKh), paramf);
    paramf = new StringBuilder("bitmapW=");
    k.g(paramg, "result");
    ac.i("MicroMsg.Loader.ImageBitmapProducer", paramg.getWidth() + " bitmapH=" + paramg.getHeight() + " degree=" + i);
    paramg = new com.tencent.mm.loader.h.e(paramg);
    AppMethodBeat.o(164899);
    return paramg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.c.c
 * JD-Core Version:    0.7.0.1
 */