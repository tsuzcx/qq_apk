package com.tencent.mm.plugin.bottle.ui;

import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;

final class PickedBottleImageView$1
  implements Runnable
{
  PickedBottleImageView$1(PickedBottleImageView paramPickedBottleImageView) {}
  
  public final void run()
  {
    FrameLayout localFrameLayout = (FrameLayout)this.iaG.getParent();
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)PickedBottleImageView.a(this.iaG).getLayoutParams();
    if (localFrameLayout != null) {
      localMarginLayoutParams.setMargins(localFrameLayout.getWidth() / 2, localFrameLayout.getHeight() * 530 / 800, localMarginLayoutParams.rightMargin, localMarginLayoutParams.bottomMargin);
    }
    PickedBottleImageView.a(this.iaG).setLayoutParams(localMarginLayoutParams);
    PickedBottleImageView.a(this.iaG).setVisibility(0);
    this.iaG.clearAnimation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.PickedBottleImageView.1
 * JD-Core Version:    0.7.0.1
 */