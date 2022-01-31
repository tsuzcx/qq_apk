package com.tencent.mm.plugin.gallery.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;

final class AlbumPreviewUI$8
  implements Animation.AnimationListener
{
  private Runnable kIJ = new AlbumPreviewUI.8.1(this);
  
  AlbumPreviewUI$8(AlbumPreviewUI paramAlbumPreviewUI) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AlbumPreviewUI.G(this.kIF).setVisibility(0);
    AlbumPreviewUI.G(this.kIF).postDelayed(this.kIJ, 4000L);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.8
 * JD-Core Version:    0.7.0.1
 */