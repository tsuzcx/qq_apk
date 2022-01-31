package com.tencent.mm.plugin.facedetectlight.ui.a;

import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$2
  implements Runnable
{
  a$2(a parama, int paramInt1, int paramInt2, Animation paramAnimation) {}
  
  public final void run()
  {
    AppMethodBeat.i(824);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.mso.msn.getLayoutParams();
    localMarginLayoutParams.width = ((int)(this.val$width * 0.7D));
    localMarginLayoutParams.height = ((int)(this.val$width * 0.7D));
    localMarginLayoutParams.topMargin = ((int)(this.val$height * 0.4D - this.val$width * 0.35D));
    this.mso.msn.setLayoutParams(localMarginLayoutParams);
    this.mso.msn.setVisibility(0);
    this.mso.msn.startAnimation(this.msp);
    AppMethodBeat.o(824);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.a.a.2
 * JD-Core Version:    0.7.0.1
 */