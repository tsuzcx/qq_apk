package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.sdk.platformtools.bk;

final class FreeWifiSuccUI$2
  implements View.OnClickListener
{
  FreeWifiSuccUI$2(FreeWifiSuccUI paramFreeWifiSuccUI) {}
  
  public final void onClick(View paramView)
  {
    if (!bk.bl(FreeWifiSuccUI.b(this.ksY)))
    {
      paramView = new Intent();
      paramView.putExtra("Contact_User", FreeWifiSuccUI.b(this.ksY));
      d.b(this.ksY, "profile", ".ui.ContactInfoUI", paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiSuccUI.2
 * JD-Core Version:    0.7.0.1
 */