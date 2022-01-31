package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.z;

final class FreeWifiIntroductionUI$2
  implements View.OnClickListener
{
  FreeWifiIntroductionUI$2(FreeWifiIntroductionUI paramFreeWifiIntroductionUI) {}
  
  public final void onClick(View paramView)
  {
    au.Hx();
    c.Dz().o(303104, Integer.valueOf(1));
    paramView = this.ksh.getIntent();
    paramView.setClass(this.ksh, FreeWifiEntryUI.class);
    this.ksh.startActivity(paramView);
    this.ksh.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiIntroductionUI.2
 * JD-Core Version:    0.7.0.1
 */