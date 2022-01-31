package com.tencent.mm.plugin.gallery.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

final class ImageFolderMgrView$2
  implements Animation.AnimationListener
{
  ImageFolderMgrView$2(ImageFolderMgrView paramImageFolderMgrView) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    ImageFolderMgrView.a(this.kJo, true);
    ImageFolderMgrView.b(this.kJo);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImageFolderMgrView.2
 * JD-Core Version:    0.7.0.1
 */