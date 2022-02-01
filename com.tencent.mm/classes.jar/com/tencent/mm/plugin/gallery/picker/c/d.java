package com.tencent.mm.plugin.gallery.picker.c;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.e.a.b;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.loader.f;
import com.tencent.mm.loader.h.b.a;
import com.tencent.mm.loader.h.e;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.n;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gallery/picker/loader/MediaThumbProducer;", "Lcom/tencent/mm/loader/impr/imageproducer/ImageBitmapProducer;", "()V", "asResource", "Lcom/tencent/mm/loader/model/Resource;", "Landroid/graphics/Bitmap;", "targetView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "input", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "plugin-gallery_release"})
public final class d
  extends b
{
  public final e<Bitmap> a(g<?> paramg, f<?, Bitmap> paramf, a parama)
  {
    AppMethodBeat.i(164900);
    p.h(paramg, "targetView");
    p.h(paramf, "reaper");
    p.h(parama, "input");
    paramg = parama.getTag();
    if (paramg == null)
    {
      paramg = new t("null cannot be cast to non-null type com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem");
      AppMethodBeat.o(164900);
      throw paramg;
    }
    paramf = (GalleryItem.MediaItem)paramg;
    if (paramf.getType() == 2) {
      paramg = n.a(paramf.xiZ, paramf.getType(), paramf.xiW, paramf.xiW);
    }
    for (;;)
    {
      paramg = new e(paramg);
      AppMethodBeat.o(164900);
      return paramg;
      if (paramf.xjd)
      {
        paramg = n.hB(paramf.xiW, paramf.xiW);
      }
      else
      {
        paramg = n.aw(paramf.xiW, paramf.xiZ);
        if (paramg == null) {
          paramg = n.hB(paramf.xiW, paramf.xiW);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.c.d
 * JD-Core Version:    0.7.0.1
 */