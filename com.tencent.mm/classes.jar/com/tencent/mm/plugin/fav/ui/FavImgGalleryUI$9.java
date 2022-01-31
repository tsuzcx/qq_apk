package com.tencent.mm.plugin.fav.ui;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.ui.tools.MMGestureGallery;

final class FavImgGalleryUI$9
  implements Runnable
{
  FavImgGalleryUI$9(FavImgGalleryUI paramFavImgGalleryUI, c paramc) {}
  
  public final void run()
  {
    int j = 0;
    Object localObject = FavImgGalleryUI.a(this.kbW).getSelectedView();
    if (localObject == null) {
      return;
    }
    localObject = (FavImgGalleryUI.b)((View)localObject).getTag();
    int i;
    if (this.kbY.field_totalLen > 0)
    {
      i = this.kbY.field_offset * 100 / this.kbY.field_totalLen - 1;
      label57:
      if (i >= 0) {
        break label129;
      }
      i = j;
    }
    label129:
    for (;;)
    {
      ((FavImgGalleryUI.b)localObject).frw.setProgress(i);
      ((FavImgGalleryUI.b)localObject).kcd.setText(i + "%");
      if ((i < 100) && (!this.kbY.isFinished())) {
        break;
      }
      FavImgGalleryUI.e(this.kbW).notifyDataSetChanged();
      return;
      i = 0;
      break label57;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavImgGalleryUI.9
 * JD-Core Version:    0.7.0.1
 */