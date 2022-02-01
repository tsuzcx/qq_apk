package com.tencent.mm.plugin.gallery.picker.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.i.c;
import d.g.a.q;
import d.l;
import d.z;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gallery/picker/loader/PickerDataLoader$QueryMediaListener;", "Lcom/tencent/mm/plugin/gallery/model/IMediaQuery$IQueryMediaInAlbumFinished;", "()V", "callback", "Lkotlin/Function3;", "", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "", "", "getCallback", "()Lkotlin/jvm/functions/Function3;", "setCallback", "(Lkotlin/jvm/functions/Function3;)V", "ticket", "getTicket", "()J", "setTicket", "(J)V", "onQueryMediaFinished", "mediaItems", "t", "isFirstNotify", "plugin-gallery_release"})
public final class e$b
  implements i.c
{
  long itF;
  q<? super Boolean, ? super LinkedList<GalleryItem.MediaItem>, ? super Long, z> tUf;
  
  public e$b()
  {
    AppMethodBeat.i(164904);
    this.itF = System.currentTimeMillis();
    AppMethodBeat.o(164904);
  }
  
  public final void b(LinkedList<GalleryItem.MediaItem> paramLinkedList, long paramLong, boolean paramBoolean)
  {
    z localz = null;
    AppMethodBeat.i(164903);
    long l = System.currentTimeMillis() - this.itF;
    int i;
    if (this.itF == paramLong)
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
        q localq = this.tUf;
        if (localq != null)
        {
          localq.d(Boolean.TRUE, paramLinkedList, Long.valueOf(l));
          localz = z.Nhr;
        }
        if (localz != null) {}
      }
      else
      {
        paramLinkedList = ((b)this).tUf;
        if (paramLinkedList != null)
        {
          paramLinkedList.d(Boolean.FALSE, new LinkedList(), Long.valueOf(l));
          paramLinkedList = z.Nhr;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.picker.c.e.b
 * JD-Core Version:    0.7.0.1
 */