package com.tencent.mm.plugin.game.ui;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;

final class r$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  r$1(r paramr, TextView paramTextView1, TextView paramTextView2) {}
  
  public final void onGlobalLayout()
  {
    if (this.leP.getLineCount() > 1)
    {
      this.leP.setMaxLines(2);
      this.leQ.setMaxLines(1);
      return;
    }
    this.leQ.setMaxLines(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.r.1
 * JD-Core Version:    0.7.0.1
 */