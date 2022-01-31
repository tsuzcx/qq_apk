package com.tencent.mm.plugin.account.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;

final class BindLinkedInUI$7
  implements View.OnClickListener
{
  BindLinkedInUI$7(BindLinkedInUI paramBindLinkedInUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(13392);
    if (!BindLinkedInUI.b(this.gtf))
    {
      BindLinkedInUI.c(this.gtf);
      AppMethodBeat.o(13392);
      return;
    }
    if (!BindLinkedInUI.d(this.gtf))
    {
      BindLinkedInUI.e(this.gtf);
      AppMethodBeat.o(13392);
      return;
    }
    h.a(this.gtf, this.gtf.getString(2131298642), null, new BindLinkedInUI.7.1(this), new BindLinkedInUI.7.2(this));
    AppMethodBeat.o(13392);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI.7
 * JD-Core Version:    0.7.0.1
 */