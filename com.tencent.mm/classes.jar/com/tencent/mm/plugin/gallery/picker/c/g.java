package com.tencent.mm.plugin.gallery.picker.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.c.b;
import com.tencent.mm.loader.c.b.b;
import com.tencent.mm.loader.g.a.a;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gallery/picker/loader/UnusedImageDownloader;", "Lcom/tencent/mm/loader/common/IDataFetcher;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "()V", "loadDataImp", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "callback", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends b<GalleryItem.MediaItem>
{
  public final void a(a<GalleryItem.MediaItem> parama, com.tencent.mm.loader.e.g paramg, b.b paramb)
  {
    AppMethodBeat.i(164912);
    s.u(parama, "url");
    s.u(paramg, "fileNameCreator");
    s.u(paramb, "callback");
    AppMethodBeat.o(164912);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.c.g
 * JD-Core Version:    0.7.0.1
 */