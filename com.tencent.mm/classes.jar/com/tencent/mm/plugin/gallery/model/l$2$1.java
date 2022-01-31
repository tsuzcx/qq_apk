package com.tencent.mm.plugin.gallery.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

final class l$2$1
  implements i.d
{
  l$2$1(l.2 param2) {}
  
  public final void c(LinkedList<GalleryItem.MediaItem> paramLinkedList, long paramLong)
  {
    AppMethodBeat.i(21320);
    ab.i("MicroMsg.MediaQueryService", "queryMediaItemsInAlbum end...");
    l.a(this.ndC.ndA, paramLinkedList, paramLong);
    AppMethodBeat.o(21320);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.l.2.1
 * JD-Core Version:    0.7.0.1
 */