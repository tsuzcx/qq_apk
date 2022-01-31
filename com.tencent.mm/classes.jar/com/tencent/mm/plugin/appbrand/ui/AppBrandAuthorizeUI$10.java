package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

final class AppBrandAuthorizeUI$10
  implements DialogInterface.OnClickListener
{
  AppBrandAuthorizeUI$10(AppBrandAuthorizeUI paramAppBrandAuthorizeUI, fs paramfs, Preference paramPreference, f paramf) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(132902);
    ab.d("MicroMsg.AppBrandAuthorizeUI", "set authItem.state open");
    this.iLP.state = 1;
    ((CheckBoxPreference)this.iLK).vxW = true;
    this.iLO.notifyDataSetChanged();
    AppMethodBeat.o(132902);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.10
 * JD-Core Version:    0.7.0.1
 */