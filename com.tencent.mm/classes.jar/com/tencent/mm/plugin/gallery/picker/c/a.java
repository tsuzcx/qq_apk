package com.tencent.mm.plugin.gallery.picker.c;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gallery/picker/loader/MediaBitmapDiskCache;", "Lcom/tencent/mm/loader/cache/disk/BitmapDiskCache;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "()V", "clear", "", "opts", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "Landroid/graphics/Bitmap;", "get", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "onSaveCompleted", "", "diskResource", "Lcom/tencent/mm/loader/model/Resource;", "onSaveStarted", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "resource", "save", "source", "plugin-gallery_release"})
public final class a
  extends com.tencent.mm.loader.b.a.a<GalleryItem.MediaItem>
{
  public final boolean a(com.tencent.mm.loader.h.a.a<GalleryItem.MediaItem> parama, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(164892);
    p.h(parama, "url");
    p.h(parame, "opts");
    p.h(paramf, "reaper");
    AppMethodBeat.o(164892);
    return false;
  }
  
  public final boolean a(com.tencent.mm.loader.h.a.a<GalleryItem.MediaItem> parama, com.tencent.mm.loader.h.f<?> paramf, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf1)
  {
    AppMethodBeat.i(164891);
    p.h(parama, "url");
    p.h(paramf, "httpResponse");
    p.h(parame, "opts");
    p.h(paramf1, "reaper");
    AppMethodBeat.o(164891);
    return false;
  }
  
  public final boolean a(com.tencent.mm.loader.h.a.a<GalleryItem.MediaItem> parama, com.tencent.mm.loader.h.f<?> paramf, com.tencent.mm.loader.h.e<Bitmap> parame1, com.tencent.mm.loader.h.e<Bitmap> parame2, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf1)
  {
    AppMethodBeat.i(164893);
    p.h(parama, "url");
    p.h(paramf, "httpResponse");
    p.h(parame1, "source");
    p.h(parame, "opts");
    p.h(paramf1, "reaper");
    AppMethodBeat.o(164893);
    return false;
  }
  
  public final com.tencent.mm.loader.h.b.a b(com.tencent.mm.loader.h.a.a<GalleryItem.MediaItem> parama, com.tencent.mm.loader.c.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(164894);
    p.h(parama, "url");
    p.h(parame, "opts");
    p.h(paramf, "reaper");
    parama = com.tencent.mm.loader.h.b.a.j(((GalleryItem.MediaItem)parama.value()).xiW, parama.value());
    AppMethodBeat.o(164894);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.c.a
 * JD-Core Version:    0.7.0.1
 */