package com.tencent.mm.plugin.gallery.picker.c;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d.a.b;
import com.tencent.mm.loader.d.b.g;
import com.tencent.mm.loader.f;
import com.tencent.mm.loader.g.b.a;
import com.tencent.mm.loader.g.e;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.p;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gallery/picker/loader/MediaThumbProducer;", "Lcom/tencent/mm/loader/impr/imageproducer/ImageBitmapProducer;", "()V", "asResource", "Lcom/tencent/mm/loader/model/Resource;", "Landroid/graphics/Bitmap;", "targetView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "input", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends b
{
  public final e<Bitmap> a(g<?> paramg, f<?, Bitmap> paramf, a parama)
  {
    AppMethodBeat.i(164900);
    s.u(paramg, "targetView");
    s.u(paramf, "reaper");
    s.u(parama, "input");
    paramg = parama.nsy;
    if (paramg == null)
    {
      paramg = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem");
      AppMethodBeat.o(164900);
      throw paramg;
    }
    paramf = (GalleryItem.MediaItem)paramg;
    if (paramf.getType() == 2) {
      paramg = p.a(paramf.HHJ, paramf.getType(), paramf.Gcc, paramf.Gcc);
    }
    for (;;)
    {
      paramg = new e(paramg);
      AppMethodBeat.o(164900);
      return paramg;
      if (paramf.HHQ)
      {
        paramg = p.iK(paramf.Gcc, paramf.Gcc);
      }
      else
      {
        paramg = p.aH(paramf.Gcc, paramf.HHJ);
        if (paramg == null) {
          paramg = p.iK(paramf.Gcc, paramf.Gcc);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.c.d
 * JD-Core Version:    0.7.0.1
 */