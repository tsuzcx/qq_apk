package com.tencent.mm.plugin.bottle.ui;

import android.os.Message;
import com.tencent.mm.R.h;
import com.tencent.mm.sdk.platformtools.ah;

final class ThrowBottleAnimUI$4
  extends ah
{
  ThrowBottleAnimUI$4(ThrowBottleAnimUI paramThrowBottleAnimUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if ((ThrowBottleAnimUI.i(this.ibk) == null) && (ThrowBottleAnimUI.a(this.ibk) != null)) {
      ThrowBottleAnimUI.a(this.ibk, (SprayLayout)ThrowBottleAnimUI.a(this.ibk).findViewById(R.h.bottle_spray_fl));
    }
    if (ThrowBottleAnimUI.i(this.ibk) != null) {
      ThrowBottleAnimUI.i(this.ibk).stop();
    }
    if (ThrowBottleAnimUI.m(this.ibk) != null) {
      ThrowBottleAnimUI.m(this.ibk).axd();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.ThrowBottleAnimUI.4
 * JD-Core Version:    0.7.0.1
 */