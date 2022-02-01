package com.tencent.mm.plugin.fav.ui;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FavBaseUI$7
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  FavBaseUI$7(FavBaseUI paramFavBaseUI, TextView paramTextView1, TextView paramTextView2) {}
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(106617);
    this.tdo.tdf.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    int i = this.tdo.tdf.findViewById(2131300533).getWidth() / 4;
    if ((i > 0) && (this.tdq.getWidth() < i))
    {
      this.tdq.setWidth(i);
      this.tdr.setWidth(i);
    }
    AppMethodBeat.o(106617);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavBaseUI.7
 * JD-Core Version:    0.7.0.1
 */