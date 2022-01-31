package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;

final class FreeWifiSuccUI$4
  implements View.OnClickListener
{
  FreeWifiSuccUI$4(FreeWifiSuccUI paramFreeWifiSuccUI, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(21088);
    paramView = new Intent();
    paramView.putExtra("Contact_User", this.mON);
    d.b(this.mOM, "profile", ".ui.ContactInfoUI", paramView);
    AppMethodBeat.o(21088);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiSuccUI.4
 * JD-Core Version:    0.7.0.1
 */