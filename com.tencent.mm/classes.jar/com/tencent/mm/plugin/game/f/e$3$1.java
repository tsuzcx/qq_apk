package com.tencent.mm.plugin.game.f;

import android.graphics.Bitmap;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

final class e$3$1
  implements Runnable
{
  e$3$1(e.3 param3, Bitmap paramBitmap) {}
  
  public final void run()
  {
    this.lgv.jxK.setImageBitmap(this.ara);
    ViewGroup.LayoutParams localLayoutParams = this.lgv.jxK.getLayoutParams();
    float f = this.lgv.aUp / this.lgv.aUo;
    localLayoutParams.width = this.lgv.lgu;
    localLayoutParams.height = ((int)(f * this.lgv.lgu));
    this.lgv.jxK.setLayoutParams(localLayoutParams);
    this.lgv.jxK.setScaleType(ImageView.ScaleType.FIT_XY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.f.e.3.1
 * JD-Core Version:    0.7.0.1
 */