package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Util;

final class FreeWifiSuccUI$2
  implements View.OnClickListener
{
  FreeWifiSuccUI$2(FreeWifiSuccUI paramFreeWifiSuccUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(25146);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/freewifi/ui/FreeWifiSuccUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (!Util.isNullOrNil(FreeWifiSuccUI.b(this.wSR)))
    {
      paramView = new Intent();
      paramView.putExtra("Contact_User", FreeWifiSuccUI.b(this.wSR));
      c.b(this.wSR, "profile", ".ui.ContactInfoUI", paramView);
    }
    a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiSuccUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(25146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiSuccUI.2
 * JD-Core Version:    0.7.0.1
 */