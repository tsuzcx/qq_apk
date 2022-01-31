package com.tencent.mm.plugin.fav.ui.widget;

import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public boolean mDP = false;
  public View mDQ;
  public ImageButton mDU;
  public ImageButton mDV;
  public ImageButton mDW;
  public b.a mDX;
  
  public final void hide()
  {
    AppMethodBeat.i(74675);
    if (!this.mDP)
    {
      AppMethodBeat.o(74675);
      return;
    }
    if (this.mDQ.getVisibility() != 8)
    {
      this.mDQ.setVisibility(8);
      this.mDQ.startAnimation(AnimationUtils.loadAnimation(this.mDQ.getContext(), 2131034182));
    }
    AppMethodBeat.o(74675);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.b
 * JD-Core Version:    0.7.0.1
 */