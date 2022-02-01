package com.tencent.mm.plugin.gallery.picker.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.i.c;
import java.util.LinkedList;
import kotlin.g.a.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gallery/picker/loader/PickerDataLoader$QueryMediaListener;", "Lcom/tencent/mm/plugin/gallery/model/IMediaQuery$IQueryMediaInAlbumFinished;", "()V", "callback", "Lkotlin/Function3;", "", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "", "", "getCallback", "()Lkotlin/jvm/functions/Function3;", "setCallback", "(Lkotlin/jvm/functions/Function3;)V", "ticket", "getTicket", "()J", "setTicket", "(J)V", "onQueryMediaFinished", "mediaItems", "t", "isFirstNotify", "plugin-gallery_release"})
public final class e$b
  implements i.c
{
  long meh;
  q<? super Boolean, ? super LinkedList<GalleryItem.MediaItem>, ? super Long, x> nmO;
  
  public e$b()
  {
    AppMethodBeat.i(164904);
    this.meh = System.currentTimeMillis();
    AppMethodBeat.o(164904);
  }
  
  public final void b(LinkedList<GalleryItem.MediaItem> paramLinkedList, long paramLong, boolean paramBoolean)
  {
    x localx = null;
    AppMethodBeat.i(164903);
    long l = System.currentTimeMillis() - this.meh;
    int i;
    if (this.meh == paramLong)
    {
      i = 1;
      if (i == 0) {
        break label127;
      }
    }
    for (;;)
    {
      if (paramLinkedList != null)
      {
        q localq = this.nmO;
        if (localq != null)
        {
          localq.c(Boolean.TRUE, paramLinkedList, Long.valueOf(l));
          localx = x.aazN;
        }
        if (localx != null) {}
      }
      else
      {
        paramLinkedList = ((b)this).nmO;
        if (paramLinkedList != null)
        {
          paramLinkedList.c(Boolean.FALSE, new LinkedList(), Long.valueOf(l));
          paramLinkedList = x.aazN;
        }
      }
      AppMethodBeat.o(164903);
      return;
      i = 0;
      break;
      label127:
      paramLinkedList = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.c.e.b
 * JD-Core Version:    0.7.0.1
 */