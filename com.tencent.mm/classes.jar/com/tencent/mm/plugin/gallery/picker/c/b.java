package com.tencent.mm.plugin.gallery.picker.c;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.cache.memory.d;
import com.tencent.mm.loader.g.e;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gallery/picker/loader/MediaBitmapMemoryCache;", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Landroid/graphics/Bitmap;", "()V", "defaultImageMemoryCache", "Lcom/tencent/mm/memory/cache/BitmapResource;", "clear", "", "get", "Lcom/tencent/mm/loader/model/Resource;", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "head", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "put", "value", "remove", "Companion", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends d<GalleryItem.MediaItem, Bitmap>
{
  public static final b.a HJR;
  private static final String TAG;
  private final com.tencent.mm.memory.a.b<Bitmap> npe;
  
  static
  {
    AppMethodBeat.i(164898);
    HJR = new b.a((byte)0);
    TAG = "MicroMsg.Loader.MediaBitmapMemoryCache";
    AppMethodBeat.o(164898);
  }
  
  public b()
  {
    AppMethodBeat.i(164897);
    this.npe = new com.tencent.mm.memory.a.b(200, getClass());
    AppMethodBeat.o(164897);
  }
  
  public final e<Bitmap> a(com.tencent.mm.loader.g.a.a<GalleryItem.MediaItem> parama, com.tencent.mm.loader.d.c.a<Bitmap> parama1)
  {
    AppMethodBeat.i(164895);
    s.u(parama, "url");
    parama = b(parama, parama1);
    parama = (Bitmap)this.npe.get(parama);
    if (parama != null)
    {
      parama = new e(parama);
      AppMethodBeat.o(164895);
      return parama;
    }
    AppMethodBeat.o(164895);
    return null;
  }
  
  public final void c(com.tencent.mm.loader.g.a.a<GalleryItem.MediaItem> parama)
  {
    AppMethodBeat.i(289349);
    s.u(parama, "url");
    this.npe.remove(b(parama, null));
    AppMethodBeat.o(289349);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.c.b
 * JD-Core Version:    0.7.0.1
 */