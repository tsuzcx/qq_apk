package com.tencent.mm.plugin.fav.ui.gallery;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.ui.tools.MMGestureGallery;

final class FavMediaGalleryUI$10
  implements Runnable
{
  FavMediaGalleryUI$10(FavMediaGalleryUI paramFavMediaGalleryUI, c paramc) {}
  
  public final void run()
  {
    int j = 0;
    Object localObject = FavMediaGalleryUI.g(this.khg).getSelectedView();
    if (localObject == null) {
      break label17;
    }
    label17:
    while ((((View)localObject).getTag() == null) || (!(((View)localObject).getTag() instanceof FavMediaGalleryUI.b))) {
      return;
    }
    localObject = (FavMediaGalleryUI.b)((View)localObject).getTag();
    int i;
    if (this.kbY.field_totalLen > 0)
    {
      i = this.kbY.field_offset * 100 / this.kbY.field_totalLen - 1;
      label74:
      if (i >= 0) {
        break label146;
      }
      i = j;
    }
    label146:
    for (;;)
    {
      ((FavMediaGalleryUI.b)localObject).frw.setProgress(i);
      ((FavMediaGalleryUI.b)localObject).kcd.setText(i + "%");
      if ((i < 100) && (!this.kbY.isFinished())) {
        break;
      }
      FavMediaGalleryUI.d(this.khg).notifyDataSetChanged();
      return;
      i = 0;
      break label74;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.FavMediaGalleryUI.10
 * JD-Core Version:    0.7.0.1
 */