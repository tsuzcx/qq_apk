package com.tencent.mm.plugin.bottle.ui;

import android.widget.ImageView;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.bottle.a.h.d;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class ThrowBottleUI$5
  implements am.a
{
  ThrowBottleUI$5(ThrowBottleUI paramThrowBottleUI) {}
  
  public final boolean tC()
  {
    int i = 0;
    if (ThrowBottleUI.r(this.ibL) == null)
    {
      y.w("MM.Bottle.ThrowBottleUI", "bottle recder is null");
      return false;
    }
    int j = ThrowBottleUI.r(this.ibL).getMaxAmplitude();
    for (;;)
    {
      if (i < ThrowBottleUI.axl().length)
      {
        if ((j >= ThrowBottleUI.axm()[i]) && (j < ThrowBottleUI.axm()[(i + 1)])) {
          ThrowBottleUI.s(this.ibL).setBackgroundDrawable(a.g(ThrowBottleUI.h(this.ibL), ThrowBottleUI.axl()[i]));
        }
      }
      else {
        return true;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.ThrowBottleUI.5
 * JD-Core Version:    0.7.0.1
 */