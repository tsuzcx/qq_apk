package com.tencent.mm.plugin.bottle.ui;

import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.j.a;
import com.tencent.mm.plugin.bottle.a.h.d;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;

final class ThrowBottleUI$9
  implements j.a
{
  ThrowBottleUI$9(ThrowBottleUI paramThrowBottleUI) {}
  
  public final void onError()
  {
    ThrowBottleUI.r(this.ibL).reset();
    ThrowBottleUI.z(this.ibL).stopTimer();
    ThrowBottleUI.A(this.ibL).stopTimer();
    ag.Zn("keep_app_silent");
    ThrowBottleUI.x(this.ibL);
    y.v("MM.Bottle.ThrowBottleUI", "bottle record stop on error");
    Toast.makeText(ThrowBottleUI.h(this.ibL), ThrowBottleUI.h(this.ibL).getString(R.l.chatting_rcd_err), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.ThrowBottleUI.9
 * JD-Core Version:    0.7.0.1
 */