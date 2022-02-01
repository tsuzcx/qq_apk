package com.tencent.mm.plugin.gallery.picker.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d.b;
import com.tencent.mm.loader.d.b.b;
import com.tencent.mm.loader.h.a.a;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gallery/picker/loader/UnusedImageDownloader;", "Lcom/tencent/mm/loader/common/IDataFetcher;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "()V", "loadDataImp", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "callback", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "plugin-gallery_release"})
public final class g
  extends b<GalleryItem.MediaItem>
{
  public final void a(a<GalleryItem.MediaItem> parama, com.tencent.mm.loader.f.g paramg, b.b paramb)
  {
    AppMethodBeat.i(164912);
    p.k(parama, "url");
    p.k(paramg, "fileNameCreator");
    p.k(paramb, "callback");
    AppMethodBeat.o(164912);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.c.g
 * JD-Core Version:    0.7.0.1
 */