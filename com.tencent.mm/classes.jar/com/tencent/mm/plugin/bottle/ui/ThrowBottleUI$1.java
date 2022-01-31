package com.tencent.mm.plugin.bottle.ui;

import android.view.View;

final class ThrowBottleUI$1
  implements ThrowBottleFooter.a
{
  ThrowBottleUI$1(ThrowBottleUI paramThrowBottleUI) {}
  
  public final void axh()
  {
    if (ThrowBottleUI.a(this.ibL) == 0) {
      ThrowBottleUI.a(this.ibL, this.ibL.getHeight());
    }
    int[] arrayOfInt1 = new int[2];
    int[] tmp30_29 = arrayOfInt1;
    tmp30_29[0] = 0;
    int[] tmp34_30 = tmp30_29;
    tmp34_30[1] = 0;
    tmp34_30;
    int[] arrayOfInt2 = new int[2];
    int[] tmp44_43 = arrayOfInt2;
    tmp44_43[0] = 0;
    int[] tmp48_44 = tmp44_43;
    tmp48_44[1] = 0;
    tmp48_44;
    this.ibL.getLocationInWindow(arrayOfInt1);
    ThrowBottleUI.b(this.ibL).getLocationInWindow(arrayOfInt2);
    if ((arrayOfInt2[1] - arrayOfInt1[1]) * 1.0D / ThrowBottleUI.a(this.ibL) < 0.5D)
    {
      ThrowBottleUI.c(this.ibL).topMargin = ThrowBottleUI.d(this.ibL);
      ThrowBottleUI.c(this.ibL).bottomMargin = 0;
      ThrowBottleUI.e(this.ibL).setVisibility(0);
      this.ibL.requestLayout();
      return;
    }
    ThrowBottleUI.c(this.ibL).topMargin = (ThrowBottleUI.d(this.ibL) * 1 / 6);
    ThrowBottleUI.c(this.ibL).bottomMargin = ThrowBottleUI.b(this.ibL).getHeight();
    ThrowBottleUI.e(this.ibL).setVisibility(8);
    this.ibL.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.ThrowBottleUI.1
 * JD-Core Version:    0.7.0.1
 */