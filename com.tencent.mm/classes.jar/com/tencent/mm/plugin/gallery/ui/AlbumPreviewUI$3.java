package com.tencent.mm.plugin.gallery.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.sdk.platformtools.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

final class AlbumPreviewUI$3
  implements a.b
{
  AlbumPreviewUI$3(AlbumPreviewUI paramAlbumPreviewUI) {}
  
  public final void V(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(21390);
    Object localObject = AlbumPreviewUI.a(this.neV).wO(AlbumPreviewUI.a(this.neV).ndR.size() + paramInt2);
    if (paramInt3 == 0) {
      if ((localObject != null) && (((GalleryItem.MediaItem)localObject).getType() == 1))
      {
        AlbumPreviewUI.a(this.neV, (GalleryItem.MediaItem)localObject);
        AlbumPreviewUI.b(this.neV, paramInt1);
        this.neV.X(paramInt2, true);
      }
    }
    for (;;)
    {
      localObject = AlbumPreviewUI.a(this.neV).bEn().iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (r.aoY((String)((Iterator)localObject).next()));
      AppMethodBeat.o(21390);
      return;
      if ((localObject != null) && (((GalleryItem.MediaItem)localObject).getType() == 2))
      {
        if (!AlbumPreviewUI.b(this.neV, (GalleryItem.MediaItem)localObject))
        {
          AlbumPreviewUI.a(this.neV).ndN.remove(localObject);
          AlbumPreviewUI.a(this.neV).notifyDataSetChanged();
        }
        else
        {
          AlbumPreviewUI.b(this.neV, paramInt1);
          this.neV.X(paramInt2, true);
        }
      }
      else
      {
        AlbumPreviewUI.b(this.neV, paramInt1);
        this.neV.X(paramInt2, true);
        continue;
        AlbumPreviewUI.b(this.neV, paramInt1);
        this.neV.X(paramInt2, false);
      }
    }
    AlbumPreviewUI.a(this.neV, true);
    AppMethodBeat.o(21390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.3
 * JD-Core Version:    0.7.0.1
 */