package com.tencent.mm.plugin.game.f;

import android.graphics.Bitmap;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$3$1
  implements Runnable
{
  e$3$1(e.3 param3, Bitmap paramBitmap) {}
  
  public final void run()
  {
    AppMethodBeat.i(112330);
    this.nEq.lHj.setImageBitmap(this.val$bitmap);
    ViewGroup.LayoutParams localLayoutParams = this.nEq.lHj.getLayoutParams();
    float f = this.nEq.val$height / this.nEq.val$width;
    localLayoutParams.width = this.nEq.nEp;
    localLayoutParams.height = ((int)(f * this.nEq.nEp));
    this.nEq.lHj.setLayoutParams(localLayoutParams);
    this.nEq.lHj.setScaleType(ImageView.ScaleType.FIT_XY);
    AppMethodBeat.o(112330);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.f.e.3.1
 * JD-Core Version:    0.7.0.1
 */