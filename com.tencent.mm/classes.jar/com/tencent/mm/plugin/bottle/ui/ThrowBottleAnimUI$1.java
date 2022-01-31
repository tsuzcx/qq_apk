package com.tencent.mm.plugin.bottle.ui;

import android.widget.TextView;

final class ThrowBottleAnimUI$1
  implements Runnable
{
  ThrowBottleAnimUI$1(ThrowBottleAnimUI paramThrowBottleAnimUI) {}
  
  public final void run()
  {
    if ((ThrowBottleAnimUI.a(this.ibk) == null) || (ThrowBottleAnimUI.a(this.ibk).isFinishing()) || (ThrowBottleAnimUI.b(this.ibk) == null) || (ThrowBottleAnimUI.c(this.ibk) == null)) {
      return;
    }
    ThrowBottleAnimUI.b(this.ibk).setVisibility(0);
    ThrowBottleAnimUI.a(this.ibk).hYT = false;
    ThrowBottleAnimUI.a(this.ibk).ol(-1);
    ThrowBottleAnimUI.d(this.ibk);
    ThrowBottleAnimUI.e(this.ibk);
    ThrowBottleAnimUI.f(this.ibk);
    ThrowBottleAnimUI.c(this.ibk).startAnimation(ThrowBottleAnimUI.g(this.ibk));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.ThrowBottleAnimUI.1
 * JD-Core Version:    0.7.0.1
 */