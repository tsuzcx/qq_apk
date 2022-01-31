package com.tencent.mm.plugin.appbrand.phonenumber;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class PhoneNumberManagerUI$e
  implements MenuItem.OnMenuItemClickListener
{
  PhoneNumberManagerUI$e(PhoneNumberManagerUI paramPhoneNumberManagerUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(134863);
    paramMenuItem = PhoneNumberManagerUI.iEq;
    paramMenuItem = this.iEr.getContext();
    j.p(paramMenuItem, "context");
    paramMenuItem = (Context)paramMenuItem;
    String str = PhoneNumberManagerUI.a(this.iEr);
    j.q(paramMenuItem, "context");
    j.q(str, "appId");
    Intent localIntent = new Intent(paramMenuItem, PhoneNumberManagerUI.class);
    localIntent.putExtra("APPID", str);
    localIntent.putExtra("SHOW_DELETE", true);
    paramMenuItem.startActivity(localIntent);
    AppMethodBeat.o(134863);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberManagerUI.e
 * JD-Core Version:    0.7.0.1
 */