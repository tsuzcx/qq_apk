package com.tencent.mm.plugin.bottle.ui;

import android.graphics.drawable.AnimationDrawable;

final class LightHouseImageView$1
  implements Runnable
{
  LightHouseImageView$1(LightHouseImageView paramLightHouseImageView, int paramInt) {}
  
  public final void run()
  {
    LightHouseImageView.a(this.hZT, this.amW);
    LightHouseImageView.a(this.hZT, (AnimationDrawable)this.hZT.getBackground());
    if (LightHouseImageView.a(this.hZT) != null)
    {
      LightHouseImageView.b(this.hZT);
      LightHouseImageView.a(this.hZT).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.LightHouseImageView.1
 * JD-Core Version:    0.7.0.1
 */