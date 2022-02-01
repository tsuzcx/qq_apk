package com.tencent.mm.plugin.finder.ui;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.util.LongSparseArray;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import d.g.b.k;
import d.l;
import java.util.ArrayList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
final class FinderMediaCropUI$ac
  implements Runnable
{
  FinderMediaCropUI$ac(FinderMediaCropUI paramFinderMediaCropUI, FinderMediaCropUI.b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(199255);
    this.KYG.setItems(this.qMY.crc().subList(0, 1));
    FinderMediaCropUI.a(this.qMY).put(0L, new FinderMediaCropUI.d());
    FinderMediaCropUI localFinderMediaCropUI = this.qMY;
    Object localObject = this.qMY.crf().ci(0);
    if (localObject != null) {}
    for (localObject = ((RecyclerView.v)localObject).arI;; localObject = null)
    {
      if (localObject == null) {
        k.fvU();
      }
      k.g(localObject, "previewRecyclerView.find…utPosition(0)?.itemView!!");
      GalleryItem.MediaItem localMediaItem = this.qMY.KYA;
      if (localMediaItem == null) {
        k.fvU();
      }
      localFinderMediaCropUI.a(0, (View)localObject, localMediaItem);
      AppMethodBeat.o(199255);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderMediaCropUI.ac
 * JD-Core Version:    0.7.0.1
 */