package com.tencent.mm.plugin.fav.ui;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.ui.tools.MMGestureGallery;

final class FavImgGalleryUI$12
  implements Runnable
{
  FavImgGalleryUI$12(FavImgGalleryUI paramFavImgGalleryUI, c paramc) {}
  
  public final void run()
  {
    int j = 0;
    AppMethodBeat.i(74011);
    Object localObject = FavImgGalleryUI.a(this.mwu).getSelectedView();
    if (localObject == null)
    {
      AppMethodBeat.o(74011);
      return;
    }
    localObject = (FavImgGalleryUI.c)((View)localObject).getTag();
    int i;
    if (this.mwy.field_totalLen > 0)
    {
      i = this.mwy.field_offset * 100 / this.mwy.field_totalLen - 1;
      if (i >= 0) {
        break label144;
      }
      i = j;
    }
    label144:
    for (;;)
    {
      ((FavImgGalleryUI.c)localObject).progressBar.setProgress(i);
      ((FavImgGalleryUI.c)localObject).mwG.setText(i + "%");
      if ((i >= 100) || (this.mwy.isFinished())) {
        FavImgGalleryUI.f(this.mwu).notifyDataSetChanged();
      }
      AppMethodBeat.o(74011);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavImgGalleryUI.12
 * JD-Core Version:    0.7.0.1
 */