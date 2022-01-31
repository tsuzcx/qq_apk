package com.tencent.mm.plugin.exdevice.ui;

import android.view.MenuItem;
import com.tencent.mm.plugin.exdevice.f.b.a.a;
import com.tencent.mm.plugin.exdevice.f.b.c;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.sport.b.d;
import com.tencent.mm.ui.base.n.d;

final class ExdeviceRankInfoUI$17
  implements n.d
{
  ExdeviceRankInfoUI$17(ExdeviceRankInfoUI paramExdeviceRankInfoUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    if (ExdeviceRankInfoUI.x(this.jFV) == null) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    }
    ExdeviceRankInfoUI.a(this.jFV, true);
    d.jdMethod_if(10);
    ad.aLT();
    c.d("", ExdeviceRankInfoUI.y(this.jFV), ExdeviceRankInfoUI.x(this.jFV).field_username, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.17
 * JD-Core Version:    0.7.0.1
 */