package com.tencent.mm.plugin.gallery.ui;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.mm.R.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class AlbumPreviewUI$4$1
  implements Runnable
{
  AlbumPreviewUI$4$1(AlbumPreviewUI.4 param4) {}
  
  public final void run()
  {
    Animation localAnimation = AnimationUtils.loadAnimation(this.kIH.kIF.mController.uMN, R.a.fast_faded_out);
    AlbumPreviewUI.x(this.kIH.kIF).startAnimation(localAnimation);
    AlbumPreviewUI.x(this.kIH.kIF).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.4.1
 * JD-Core Version:    0.7.0.1
 */