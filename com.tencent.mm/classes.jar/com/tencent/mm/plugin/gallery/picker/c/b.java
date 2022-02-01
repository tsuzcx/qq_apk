package com.tencent.mm.plugin.gallery.picker.c;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gallery/picker/loader/MediaBitmapMemoryCache;", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "Landroid/graphics/Bitmap;", "()V", "defaultImageMemoryCache", "Lcom/tencent/mm/memory/cache/BitmapResource;", "clear", "", "get", "Lcom/tencent/mm/loader/model/Resource;", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "head", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "put", "value", "remove", "Companion", "plugin-gallery_release"})
public final class b
  extends com.tencent.mm.loader.b.b.e<GalleryItem.MediaItem, Bitmap>
{
  public static final a BXF;
  private static final String TAG = "MicroMsg.Loader.MediaBitmapMemoryCache";
  private final com.tencent.mm.memory.a.b<Bitmap> kNp;
  
  static
  {
    AppMethodBeat.i(164898);
    BXF = new a((byte)0);
    TAG = "MicroMsg.Loader.MediaBitmapMemoryCache";
    AppMethodBeat.o(164898);
  }
  
  public b()
  {
    AppMethodBeat.i(164897);
    this.kNp = new com.tencent.mm.memory.a.b(200, getClass());
    AppMethodBeat.o(164897);
  }
  
  public final com.tencent.mm.loader.h.e<Bitmap> a(com.tencent.mm.loader.h.a.a<GalleryItem.MediaItem> parama, com.tencent.mm.loader.e.c.a<Bitmap> parama1)
  {
    AppMethodBeat.i(164895);
    p.k(parama, "url");
    parama = b(parama, parama1);
    parama = (Bitmap)this.kNp.get(parama);
    if (parama != null)
    {
      parama = new com.tencent.mm.loader.h.e(parama);
      AppMethodBeat.o(164895);
      return parama;
    }
    AppMethodBeat.o(164895);
    return null;
  }
  
  public final void a(com.tencent.mm.loader.h.a.a<GalleryItem.MediaItem> parama)
  {
    AppMethodBeat.i(244285);
    p.k(parama, "url");
    this.kNp.remove(b(parama, null));
    AppMethodBeat.o(244285);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gallery/picker/loader/MediaBitmapMemoryCache$Companion;", "", "()V", "MAX_DEFAULT_BITMAP_SIZE", "", "TAG", "", "plugin-gallery_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.c.b
 * JD-Core Version:    0.7.0.1
 */