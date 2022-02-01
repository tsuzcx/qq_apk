package com.tencent.mm.plugin.game.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.ArrayList;
import java.util.LinkedList;

final class GameLocalGalleryView$4
  implements a.c
{
  GameLocalGalleryView$4(GameLocalGalleryView paramGameLocalGalleryView) {}
  
  public final void aP(LinkedList<GalleryItem.MediaItem> paramLinkedList)
  {
    AppMethodBeat.i(41000);
    ArrayList localArrayList = new ArrayList();
    if (paramLinkedList != null) {
      localArrayList.addAll(paramLinkedList);
    }
    MMHandlerThread.postToMainThread(new GameLocalGalleryView.c.3(GameLocalGalleryView.a(this.xBe), localArrayList));
    AppMethodBeat.o(41000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GameLocalGalleryView.4
 * JD-Core Version:    0.7.0.1
 */