package com.tencent.mm.plugin.gallery.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AlbumPreviewUI$9
  implements Animation.AnimationListener
{
  private Runnable nfb;
  
  AlbumPreviewUI$9(AlbumPreviewUI paramAlbumPreviewUI)
  {
    AppMethodBeat.i(21405);
    this.nfb = new AlbumPreviewUI.9.1(this);
    AppMethodBeat.o(21405);
  }
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    AppMethodBeat.i(21406);
    AlbumPreviewUI.O(this.neV).setVisibility(0);
    AlbumPreviewUI.O(this.neV).postDelayed(this.nfb, 4000L);
    AppMethodBeat.o(21406);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.9
 * JD-Core Version:    0.7.0.1
 */