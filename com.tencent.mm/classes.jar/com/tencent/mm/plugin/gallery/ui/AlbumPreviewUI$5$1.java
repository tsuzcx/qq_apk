package com.tencent.mm.plugin.gallery.ui;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AlbumPreviewUI$5$1
  implements Runnable
{
  AlbumPreviewUI$5$1(AlbumPreviewUI.5 param5) {}
  
  public final void run()
  {
    AppMethodBeat.i(21392);
    Animation localAnimation = AnimationUtils.loadAnimation(this.neZ.neV.getContext(), 2131034182);
    AlbumPreviewUI.C(this.neZ.neV).startAnimation(localAnimation);
    AlbumPreviewUI.C(this.neZ.neV).setVisibility(8);
    AppMethodBeat.o(21392);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.5.1
 * JD-Core Version:    0.7.0.1
 */