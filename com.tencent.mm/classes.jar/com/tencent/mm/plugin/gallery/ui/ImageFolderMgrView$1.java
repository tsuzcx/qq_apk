package com.tencent.mm.plugin.gallery.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;

final class ImageFolderMgrView$1
  implements Animation.AnimationListener
{
  ImageFolderMgrView$1(ImageFolderMgrView paramImageFolderMgrView) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    ImageFolderMgrView.a(this.kJo).setVisibility(8);
    ImageFolderMgrView.a(this.kJo, false);
    ImageFolderMgrView.b(this.kJo);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImageFolderMgrView.1
 * JD-Core Version:    0.7.0.1
 */