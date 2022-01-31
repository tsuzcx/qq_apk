package com.tencent.mm.plugin.gallery.ui;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.mm.R.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class AlbumPreviewUI$8$1
  implements Runnable
{
  AlbumPreviewUI$8$1(AlbumPreviewUI.8 param8) {}
  
  public final void run()
  {
    Animation localAnimation = AnimationUtils.loadAnimation(this.kIK.kIF.mController.uMN, R.a.fast_faded_out);
    AlbumPreviewUI.G(this.kIK.kIF).startAnimation(localAnimation);
    AlbumPreviewUI.G(this.kIK.kIF).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.8.1
 * JD-Core Version:    0.7.0.1
 */