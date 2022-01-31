package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.protocal.c.ep;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

final class AppBrandAuthorizeUI$3
  implements DialogInterface.OnClickListener
{
  AppBrandAuthorizeUI$3(AppBrandAuthorizeUI paramAppBrandAuthorizeUI, ep paramep, Preference paramPreference, f paramf) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.d("MicroMsg.AppBrandAuthorizeUI", "set authItem.state open");
    this.hcv.state = 1;
    ((CheckBoxPreference)this.hcw).rHo = true;
    this.hcx.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.3
 * JD-Core Version:    0.7.0.1
 */