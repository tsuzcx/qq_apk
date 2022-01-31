package com.tencent.mm.plugin.bottle.ui;

import android.os.Message;
import android.widget.Button;
import com.tencent.mm.R.g;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ah;

final class ThrowBottleUI$8
  extends ah
{
  ThrowBottleUI$8(ThrowBottleUI paramThrowBottleUI) {}
  
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    ThrowBottleUI.f(this.ibL).setBackgroundDrawable(a.g(ThrowBottleUI.h(this.ibL), R.g.record_shape_normal));
    ThrowBottleUI.f(this.ibL).setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.ThrowBottleUI.8
 * JD-Core Version:    0.7.0.1
 */