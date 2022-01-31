package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.pluginsdk.n;

final class BindMContactUI$5
  implements View.OnClickListener
{
  BindMContactUI$5(BindMContactUI paramBindMContactUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(13465);
    paramView = new Intent();
    paramView.putExtra("country_name", BindMContactUI.h(this.gtN));
    paramView.putExtra("couttry_code", BindMContactUI.c(this.gtN));
    a.gmO.b(paramView, this.gtN);
    AppMethodBeat.o(13465);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactUI.5
 * JD-Core Version:    0.7.0.1
 */