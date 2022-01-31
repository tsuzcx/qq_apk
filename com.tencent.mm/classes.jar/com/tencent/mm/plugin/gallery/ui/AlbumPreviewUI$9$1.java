package com.tencent.mm.plugin.gallery.ui;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AlbumPreviewUI$9$1
  implements Runnable
{
  AlbumPreviewUI$9$1(AlbumPreviewUI.9 param9) {}
  
  public final void run()
  {
    AppMethodBeat.i(21404);
    Animation localAnimation = AnimationUtils.loadAnimation(this.nfc.neV.getContext(), 2131034182);
    AlbumPreviewUI.O(this.nfc.neV).startAnimation(localAnimation);
    AlbumPreviewUI.O(this.nfc.neV).setVisibility(8);
    AppMethodBeat.o(21404);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.AlbumPreviewUI.9.1
 * JD-Core Version:    0.7.0.1
 */