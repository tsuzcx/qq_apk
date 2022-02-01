package com.tencent.mm.plugin.gallery.picker.c;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.e.a.b;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.loader.f;
import com.tencent.mm.loader.h.b.a;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gallery/picker/loader/MediaHDProducer;", "Lcom/tencent/mm/loader/impr/imageproducer/ImageBitmapProducer;", "()V", "asResource", "Lcom/tencent/mm/loader/model/Resource;", "Landroid/graphics/Bitmap;", "targetView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "input", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "plugin-gallery_release"})
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
      paramg = new t("null cannot be cast to non-null type com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem");
      AppMethodBeat.o(164899);
      throw paramg;
    }
    paramg = (GalleryItem.MediaItem)paramg;
    int i = paramf.hXX.hZA;
    int j = paramf.hXX.hZz;
    paramf = BitmapUtil.extractThumbNail(paramg.xiW, i, j, false);
    i = BitmapUtil.checkDegree(paramg.xiW);
    paramg = BitmapUtil.handleDegree(BitmapUtil.checkDegree(paramg.xiW), paramf);
    paramf = new StringBuilder("bitmapW=");
    p.g(paramg, "result");
    Log.i("MicroMsg.Loader.ImageBitmapProducer", paramg.getWidth() + " bitmapH=" + paramg.getHeight() + " degree=" + i);
    paramg = new com.tencent.mm.loader.h.e(paramg);
    AppMethodBeat.o(164899);
    return paramg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.c.c
 * JD-Core Version:    0.7.0.1
 */