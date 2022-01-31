package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.protocal.c.ep;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

final class AppBrandAuthorizeUI$4
  implements DialogInterface.OnCancelListener
{
  AppBrandAuthorizeUI$4(AppBrandAuthorizeUI paramAppBrandAuthorizeUI, ep paramep, Preference paramPreference, f paramf) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    y.d("MicroMsg.AppBrandAuthorizeUI", "on cancel click!");
    this.hcv.state = 1;
    ((CheckBoxPreference)this.hcw).rHo = true;
    this.hcx.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.4
 * JD-Core Version:    0.7.0.1
 */