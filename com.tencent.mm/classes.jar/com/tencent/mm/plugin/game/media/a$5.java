package com.tencent.mm.plugin.game.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.i.c;
import java.util.LinkedList;

final class a$5
  implements i.c
{
  a$5(a.c paramc) {}
  
  public final void b(LinkedList<GalleryItem.MediaItem> paramLinkedList, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(40911);
    if ((a.cCb() == paramLong) && (this.rRl != null)) {
      this.rRl.al(paramLinkedList);
    }
    AppMethodBeat.o(40911);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.a.5
 * JD-Core Version:    0.7.0.1
 */