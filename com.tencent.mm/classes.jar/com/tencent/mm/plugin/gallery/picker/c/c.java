package com.tencent.mm.plugin.gallery.picker.c;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d.a.b;
import com.tencent.mm.loader.d.b.g;
import com.tencent.mm.loader.f;
import com.tencent.mm.loader.g.b.a;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gallery/picker/loader/MediaHDProducer;", "Lcom/tencent/mm/loader/impr/imageproducer/ImageBitmapProducer;", "()V", "asResource", "Lcom/tencent/mm/loader/model/Resource;", "Landroid/graphics/Bitmap;", "targetView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "input", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends b
{
  public final com.tencent.mm.loader.g.e<Bitmap> a(g<?> paramg, f<?, Bitmap> paramf, a parama)
  {
    AppMethodBeat.i(164899);
    s.u(paramg, "targetView");
    s.u(paramf, "reaper");
    s.u(parama, "input");
    paramg = parama.nsy;
    if (paramg == null)
    {
      paramg = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem");
      AppMethodBeat.o(164899);
      throw paramg;
    }
    paramg = (GalleryItem.MediaItem)paramg;
    int i = paramf.nou.npV;
    int j = paramf.nou.npU;
    paramf = BitmapUtil.extractThumbNail(paramg.Gcc, i, j, false);
    i = BitmapUtil.checkDegree(paramg.Gcc);
    paramg = BitmapUtil.handleDegree(BitmapUtil.checkDegree(paramg.Gcc), paramf);
    Log.i("MicroMsg.Loader.ImageBitmapProducer", "bitmapW=" + paramg.getWidth() + " bitmapH=" + paramg.getHeight() + " degree=" + i);
    paramg = new com.tencent.mm.loader.g.e(paramg);
    AppMethodBeat.o(164899);
    return paramg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.c.c
 * JD-Core Version:    0.7.0.1
 */