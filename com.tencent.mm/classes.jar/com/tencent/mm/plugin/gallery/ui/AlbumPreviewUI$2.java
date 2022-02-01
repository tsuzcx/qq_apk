package com.tencent.mm.plugin.gallery.ui;

import com.tencent.map.geolocation.sapp.TencentLocationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.i.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

final class AlbumPreviewUI$2
  implements i.b
{
  AlbumPreviewUI$2(AlbumPreviewUI paramAlbumPreviewUI, double paramDouble) {}
  
  public final void c(LinkedList<GalleryItem.MediaItem> paramLinkedList, long paramLong)
  {
    AppMethodBeat.i(111423);
    Log.d("MicroMsg.AlbumPreviewUI", "onQueryMediaBusinessDoing");
    if (paramLong != AlbumPreviewUI.w(this.xoG))
    {
      Log.w("MicroMsg.AlbumPreviewUI", "%s %s, not my query, ignore.", new Object[] { Long.valueOf(paramLong), Long.valueOf(AlbumPreviewUI.w(this.xoG)) });
      Log.w("MicroMsg.AlbumPreviewUI", "If you saw too mush this log, maybe user had too many photos. This can be optimized.");
      AppMethodBeat.o(111423);
      return;
    }
    if ((paramLinkedList == null) || (paramLinkedList.isEmpty()))
    {
      Log.d("MicroMsg.AlbumPreviewUI", "mediaItems is invalid.");
      AppMethodBeat.o(111423);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramLinkedList.iterator();
    while (localIterator.hasNext())
    {
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)localIterator.next();
      if (TencentLocationUtils.distanceBetween(AlbumPreviewUI.x(this.xoG), AlbumPreviewUI.y(this.xoG), localMediaItem.cik, localMediaItem.cil) <= this.xoH)
      {
        localMediaItem.xjc = "album_business_bubble_media_by_coordinate";
        localArrayList.add(localMediaItem);
      }
    }
    paramLinkedList.removeAll(localArrayList);
    Log.d("MicroMsg.AlbumPreviewUI", "target media size=%d", new Object[] { Integer.valueOf(localArrayList.size()) });
    localIterator = localArrayList.iterator();
    while (localIterator.hasNext()) {
      Log.d("MicroMsg.AlbumPreviewUI", "target media item=%s", new Object[] { ((GalleryItem.MediaItem)localIterator.next()).toString() });
    }
    if ((!paramLinkedList.isEmpty()) && (!localArrayList.isEmpty())) {
      paramLinkedList.addAll(0, localArrayList);
    }
    AppMethodBeat.o(111423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.2
 * JD-Core Version:    0.7.0.1
 */