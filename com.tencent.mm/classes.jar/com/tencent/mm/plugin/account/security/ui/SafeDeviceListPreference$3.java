package com.tencent.mm.plugin.account.security.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class SafeDeviceListPreference$3
  implements View.OnClickListener
{
  SafeDeviceListPreference$3(SafeDeviceListPreference paramSafeDeviceListPreference) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(125576);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/account/security/ui/SafeDeviceListPreference$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    SafeDeviceListPreference.d(this.jlo);
    a.a(this, "com/tencent/mm/plugin/account/security/ui/SafeDeviceListPreference$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(125576);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.ui.SafeDeviceListPreference.3
 * JD-Core Version:    0.7.0.1
 */