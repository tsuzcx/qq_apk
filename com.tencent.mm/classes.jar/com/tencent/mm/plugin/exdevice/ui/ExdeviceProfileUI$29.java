package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.exdevice.f.b.c;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.s;

final class ExdeviceProfileUI$29
  implements n.d
{
  ExdeviceProfileUI$29(ExdeviceProfileUI paramExdeviceProfileUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return;
    case 1: 
      com.tencent.mm.plugin.sport.b.d.jdMethod_if(27);
      ExdeviceProfileUI.r(this.jEM);
      return;
    case 0: 
      com.tencent.mm.plugin.sport.b.d.jdMethod_if(26);
      ExdeviceProfileUI.s(this.jEM);
      return;
    case 2: 
      ExdeviceProfileUI.t(this.jEM);
      return;
    case 3: 
      h.a(this.jEM.mController.uMN, this.jEM.getString(R.l.exdevice_we_sport_black_intro), null, true, new ExdeviceProfileUI.29.1(this), null);
      return;
    case 4: 
      ExdeviceProfileUI.b(this.jEM, true);
      com.tencent.mm.plugin.sport.b.d.jdMethod_if(10);
      ad.aLT();
      c.d("", ExdeviceProfileUI.w(this.jEM), ExdeviceProfileUI.u(this.jEM), 3);
      return;
    }
    com.tencent.mm.plugin.sport.b.d.jdMethod_if(41);
    paramMenuItem = new Intent();
    paramMenuItem.putExtra("rawUrl", ExdeviceProfileUI.o(this.jEM));
    com.tencent.mm.br.d.b(this.jEM, "webview", ".ui.tools.WebViewUI", paramMenuItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceProfileUI.29
 * JD-Core Version:    0.7.0.1
 */