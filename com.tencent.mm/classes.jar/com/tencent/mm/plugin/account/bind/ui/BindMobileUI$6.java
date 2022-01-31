package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.pluginsdk.n;

final class BindMobileUI$6
  implements View.OnClickListener
{
  BindMobileUI$6(BindMobileUI paramBindMobileUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(13514);
    paramView = new Intent();
    paramView.putExtra("country_name", BindMobileUI.f(this.gus));
    paramView.putExtra("couttry_code", BindMobileUI.g(this.gus));
    a.gmO.b(paramView, this.gus);
    AppMethodBeat.o(13514);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMobileUI.6
 * JD-Core Version:    0.7.0.1
 */