package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class FreeWifiSuccUI$4
  implements View.OnClickListener
{
  FreeWifiSuccUI$4(FreeWifiSuccUI paramFreeWifiSuccUI, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(25148);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/freewifi/ui/FreeWifiSuccUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    paramView = new Intent();
    paramView.putExtra("Contact_User", this.wSS);
    c.b(this.wSR, "profile", ".ui.ContactInfoUI", paramView);
    a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiSuccUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(25148);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiSuccUI.4
 * JD-Core Version:    0.7.0.1
 */