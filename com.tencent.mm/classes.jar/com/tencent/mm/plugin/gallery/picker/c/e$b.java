package com.tencent.mm.plugin.gallery.picker.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.l.c;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gallery/picker/loader/PickerDataLoader$QueryMediaListener;", "Lcom/tencent/mm/plugin/gallery/model/IMediaQuery$IQueryMediaInAlbumFinished;", "()V", "callback", "Lkotlin/Function3;", "", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "", "", "getCallback", "()Lkotlin/jvm/functions/Function3;", "setCallback", "(Lkotlin/jvm/functions/Function3;)V", "ticket", "getTicket", "()J", "setTicket", "(J)V", "onQueryMediaFinished", "mediaItems", "t", "isFirstNotify", "plugin-gallery_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e$b
  implements l.c
{
  q<? super Boolean, ? super LinkedList<GalleryItem.MediaItem>, ? super Long, ah> HJY;
  long oXa;
  
  public e$b()
  {
    AppMethodBeat.i(164904);
    this.oXa = System.currentTimeMillis();
    AppMethodBeat.o(164904);
  }
  
  public final void b(LinkedList<GalleryItem.MediaItem> paramLinkedList, long paramLong, boolean paramBoolean)
  {
    ah localah = null;
    AppMethodBeat.i(164903);
    long l = System.currentTimeMillis() - this.oXa;
    int i;
    if (this.oXa == paramLong)
    {
      i = 1;
      if (i == 0) {
        break label90;
      }
      label35:
      if (paramLinkedList != null) {
        break label95;
      }
    }
    for (;;)
    {
      if (localah == null)
      {
        paramLinkedList = ((b)this).HJY;
        if (paramLinkedList != null) {
          paramLinkedList.invoke(Boolean.FALSE, new LinkedList(), Long.valueOf(l));
        }
      }
      AppMethodBeat.o(164903);
      return;
      i = 0;
      break;
      label90:
      paramLinkedList = null;
      break label35;
      label95:
      q localq = this.HJY;
      if (localq != null)
      {
        localq.invoke(Boolean.TRUE, paramLinkedList, Long.valueOf(l));
        localah = ah.aiuX;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.c.e.b
 * JD-Core Version:    0.7.0.1
 */