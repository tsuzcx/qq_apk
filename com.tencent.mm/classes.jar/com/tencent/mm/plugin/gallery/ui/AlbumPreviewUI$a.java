package com.tencent.mm.plugin.gallery.ui;

import android.app.ProgressDialog;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

final class AlbumPreviewUI$a
  implements Runnable
{
  public WeakReference<a> kIL;
  public WeakReference<ProgressDialog> kIM;
  public ArrayList<GalleryItem.MediaItem> kIN;
  
  public final void run()
  {
    int i;
    if (this.kIN == null)
    {
      i = -1;
      y.d("MicroMsg.AlbumPreviewUI", "on NotifyMediaItemsChanged, size %d", new Object[] { Integer.valueOf(i) });
      if (this.kIL != null) {
        break label46;
      }
    }
    label46:
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          i = this.kIN.size();
          break;
          localObject = (a)this.kIL.get();
        } while (localObject == null);
        AlbumPreviewUI.C(this.kIN);
        ArrayList localArrayList = this.kIN;
        ((a)localObject).kHC.addAll(localArrayList);
        ((a)localObject).notifyDataSetChanged();
      } while (this.kIM == null);
      localObject = (ProgressDialog)this.kIM.get();
    } while ((localObject == null) || (!((ProgressDialog)localObject).isShowing()));
    ((ProgressDialog)localObject).dismiss();
    y.i("MicroMsg.AlbumPreviewUI", "[NotifyMediaItemsChanged] cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - AlbumPreviewUI.start) });
  }
  
  public final String toString()
  {
    return super.toString() + "|notifyRunnable";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.a
 * JD-Core Version:    0.7.0.1
 */