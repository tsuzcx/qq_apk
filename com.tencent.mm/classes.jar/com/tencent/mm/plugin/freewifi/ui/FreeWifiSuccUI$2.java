package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.sdk.platformtools.bt;

final class FreeWifiSuccUI$2
  implements View.OnClickListener
{
  FreeWifiSuccUI$2(FreeWifiSuccUI paramFreeWifiSuccUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(25146);
    if (!bt.isNullOrNil(FreeWifiSuccUI.b(this.rlE)))
    {
      paramView = new Intent();
      paramView.putExtra("Contact_User", FreeWifiSuccUI.b(this.rlE));
      d.b(this.rlE, "profile", ".ui.ContactInfoUI", paramView);
    }
    AppMethodBeat.o(25146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiSuccUI.2
 * JD-Core Version:    0.7.0.1
 */