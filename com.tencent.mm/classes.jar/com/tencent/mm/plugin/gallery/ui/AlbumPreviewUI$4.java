package com.tencent.mm.plugin.gallery.ui;

import com.tencent.map.geolocation.TencentLocationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.i.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

final class AlbumPreviewUI$4
  implements i.b
{
  AlbumPreviewUI$4(AlbumPreviewUI paramAlbumPreviewUI, double paramDouble) {}
  
  public final void b(LinkedList<GalleryItem.MediaItem> paramLinkedList, long paramLong)
  {
    AppMethodBeat.i(21391);
    ab.d("MicroMsg.AlbumPreviewUI", "onQueryMediaBusinessDoing");
    if (paramLong != AlbumPreviewUI.B(this.neV))
    {
      ab.w("MicroMsg.AlbumPreviewUI", "%s %s, not my query, ignore.", new Object[] { Long.valueOf(paramLong), Long.valueOf(AlbumPreviewUI.B(this.neV)) });
      ab.w("MicroMsg.AlbumPreviewUI", "If you saw too mush this log, maybe user had too many photos. This can be optimized.");
      AppMethodBeat.o(21391);
      return;
    }
    if ((paramLinkedList != null) && (paramLinkedList.isEmpty()))
    {
      ab.d("MicroMsg.AlbumPreviewUI", "mediaItems is empty.");
      AppMethodBeat.o(21391);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramLinkedList.iterator();
    while (localIterator.hasNext())
    {
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)localIterator.next();
      if (TencentLocationUtils.distanceBetween(AlbumPreviewUI.w(this.neV), AlbumPreviewUI.v(this.neV), localMediaItem.bnl, localMediaItem.bnm) <= this.neY)
      {
        localMediaItem.nds = "album_business_bubble_media_by_coordinate";
        localArrayList.add(localMediaItem);
      }
    }
    paramLinkedList.removeAll(localArrayList);
    ab.d("MicroMsg.AlbumPreviewUI", "target media size=%d", new Object[] { Integer.valueOf(localArrayList.size()) });
    localIterator = localArrayList.iterator();
    while (localIterator.hasNext()) {
      ab.d("MicroMsg.AlbumPreviewUI", "target media item=%s", new Object[] { ((GalleryItem.MediaItem)localIterator.next()).toString() });
    }
    if ((!paramLinkedList.isEmpty()) && (!localArrayList.isEmpty())) {
      paramLinkedList.addAll(0, localArrayList);
    }
    AppMethodBeat.o(21391);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.4
 * JD-Core Version:    0.7.0.1
 */