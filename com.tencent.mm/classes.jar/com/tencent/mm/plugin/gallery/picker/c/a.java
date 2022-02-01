package com.tencent.mm.plugin.gallery.picker.c;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gallery/picker/loader/MediaBitmapDiskCache;", "Lcom/tencent/mm/loader/cache/disk/BitmapDiskCache;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "()V", "clear", "", "opts", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "Landroid/graphics/Bitmap;", "get", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "onSaveCompleted", "", "diskResource", "Lcom/tencent/mm/loader/model/Resource;", "onSaveStarted", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "resource", "save", "source", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.loader.cache.a.a<GalleryItem.MediaItem>
{
  public final boolean a(com.tencent.mm.loader.g.a.a<GalleryItem.MediaItem> parama, com.tencent.mm.loader.b.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(164892);
    s.u(parama, "url");
    s.u(parame, "opts");
    s.u(paramf, "reaper");
    AppMethodBeat.o(164892);
    return false;
  }
  
  public final boolean a(com.tencent.mm.loader.g.a.a<GalleryItem.MediaItem> parama, com.tencent.mm.loader.g.f<?> paramf, com.tencent.mm.loader.b.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf1)
  {
    AppMethodBeat.i(164891);
    s.u(parama, "url");
    s.u(paramf, "httpResponse");
    s.u(parame, "opts");
    s.u(paramf1, "reaper");
    AppMethodBeat.o(164891);
    return false;
  }
  
  public final boolean a(com.tencent.mm.loader.g.a.a<GalleryItem.MediaItem> parama, com.tencent.mm.loader.g.f<?> paramf, com.tencent.mm.loader.g.e<Bitmap> parame1, com.tencent.mm.loader.g.e<Bitmap> parame2, com.tencent.mm.loader.b.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf1)
  {
    AppMethodBeat.i(164893);
    s.u(parama, "url");
    s.u(paramf, "httpResponse");
    s.u(parame1, "source");
    s.u(parame, "opts");
    s.u(paramf1, "reaper");
    AppMethodBeat.o(164893);
    return false;
  }
  
  public final com.tencent.mm.loader.g.b.a b(com.tencent.mm.loader.g.a.a<GalleryItem.MediaItem> parama, com.tencent.mm.loader.b.e parame, com.tencent.mm.loader.f<?, Bitmap> paramf)
  {
    AppMethodBeat.i(164894);
    s.u(parama, "url");
    s.u(parame, "opts");
    s.u(paramf, "reaper");
    parama = com.tencent.mm.loader.g.b.a.o(((GalleryItem.MediaItem)parama.bmg()).Gcc, parama.bmg());
    AppMethodBeat.o(164894);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.c.a
 * JD-Core Version:    0.7.0.1
 */