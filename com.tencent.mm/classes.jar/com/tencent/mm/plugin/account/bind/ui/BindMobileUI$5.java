package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.pluginsdk.n;

final class BindMobileUI$5
  implements View.OnClickListener
{
  BindMobileUI$5(BindMobileUI paramBindMobileUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(13513);
    paramView = new Intent();
    paramView.putExtra("country_name", BindMobileUI.f(this.gus));
    paramView.putExtra("couttry_code", BindMobileUI.g(this.gus));
    a.gmO.b(paramView, this.gus);
    AppMethodBeat.o(13513);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMobileUI.5
 * JD-Core Version:    0.7.0.1
 */