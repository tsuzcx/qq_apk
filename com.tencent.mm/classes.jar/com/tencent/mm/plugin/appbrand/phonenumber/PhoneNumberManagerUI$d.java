package com.tencent.mm.plugin.appbrand.phonenumber;

import a.l;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class PhoneNumberManagerUI$d
  implements MenuItem.OnMenuItemClickListener
{
  PhoneNumberManagerUI$d(PhoneNumberManagerUI paramPhoneNumberManagerUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(134862);
    this.iEr.finish();
    this.iEr.overridePendingTransition(2131034130, 2131034130);
    AppMethodBeat.o(134862);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberManagerUI.d
 * JD-Core Version:    0.7.0.1
 */