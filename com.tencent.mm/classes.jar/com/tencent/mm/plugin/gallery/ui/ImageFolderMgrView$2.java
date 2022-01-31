package com.tencent.mm.plugin.gallery.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ImageFolderMgrView$2
  implements Animation.AnimationListener
{
  ImageFolderMgrView$2(ImageFolderMgrView paramImageFolderMgrView) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(21473);
    ImageFolderMgrView.a(this.nfM, true);
    ImageFolderMgrView.b(this.nfM);
    AppMethodBeat.o(21473);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImageFolderMgrView.2
 * JD-Core Version:    0.7.0.1
 */