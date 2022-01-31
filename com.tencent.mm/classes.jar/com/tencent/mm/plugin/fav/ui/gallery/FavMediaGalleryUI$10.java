package com.tencent.mm.plugin.fav.ui.gallery;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.ui.tools.MMGestureGallery;

final class FavMediaGalleryUI$10
  implements Runnable
{
  FavMediaGalleryUI$10(FavMediaGalleryUI paramFavMediaGalleryUI, c paramc) {}
  
  public final void run()
  {
    int j = 0;
    AppMethodBeat.i(74517);
    Object localObject = FavMediaGalleryUI.g(this.mBV).getSelectedView();
    if (localObject == null)
    {
      AppMethodBeat.o(74517);
      return;
    }
    if ((((View)localObject).getTag() == null) || (!(((View)localObject).getTag() instanceof FavMediaGalleryUI.b)))
    {
      AppMethodBeat.o(74517);
      return;
    }
    localObject = (FavMediaGalleryUI.b)((View)localObject).getTag();
    int i;
    if (this.mwy.field_totalLen > 0)
    {
      i = this.mwy.field_offset * 100 / this.mwy.field_totalLen - 1;
      if (i >= 0) {
        break label167;
      }
      i = j;
    }
    label167:
    for (;;)
    {
      ((FavMediaGalleryUI.b)localObject).progressBar.setProgress(i);
      ((FavMediaGalleryUI.b)localObject).mwG.setText(i + "%");
      if ((i >= 100) || (this.mwy.isFinished())) {
        FavMediaGalleryUI.d(this.mBV).notifyDataSetChanged();
      }
      AppMethodBeat.o(74517);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.FavMediaGalleryUI.10
 * JD-Core Version:    0.7.0.1
 */