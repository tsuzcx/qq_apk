package com.tencent.mm.plugin.gallery.ui;

import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.sdk.platformtools.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

final class AlbumPreviewUI$3
  implements a.b
{
  AlbumPreviewUI$3(AlbumPreviewUI paramAlbumPreviewUI) {}
  
  public final void J(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject;
    if (paramInt3 == 0)
    {
      localObject = AlbumPreviewUI.a(this.kIF).rS(AlbumPreviewUI.a(this.kIF).kHG.size() + paramInt2);
      if ((localObject != null) && (((GalleryItem.MediaItem)localObject).getType() == 1))
      {
        AlbumPreviewUI.a(this.kIF, (GalleryItem.MediaItem)localObject);
        AlbumPreviewUI.b(this.kIF, paramInt1);
        this.kIF.P(paramInt2, true);
      }
    }
    for (;;)
    {
      localObject = AlbumPreviewUI.a(this.kIF).aXJ().iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (o.Za((String)((Iterator)localObject).next()));
      return;
      if ((localObject == null) || (((GalleryItem.MediaItem)localObject).getType() != 2)) {
        break;
      }
      if (!AlbumPreviewUI.b(this.kIF, (GalleryItem.MediaItem)localObject))
      {
        AlbumPreviewUI.a(this.kIF).kHD.remove(localObject);
        AlbumPreviewUI.a(this.kIF).notifyDataSetChanged();
      }
      else
      {
        AlbumPreviewUI.b(this.kIF, paramInt1);
        this.kIF.P(paramInt2, true);
        continue;
        AlbumPreviewUI.b(this.kIF, paramInt1);
        this.kIF.P(paramInt2, false);
      }
    }
    AlbumPreviewUI.a(this.kIF, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.3
 * JD-Core Version:    0.7.0.1
 */