package com.tencent.mm.plugin.account.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BindMobileStatusUI$2
  implements View.OnClickListener
{
  BindMobileStatusUI$2(BindMobileStatusUI paramBindMobileStatusUI) {}
  
  public final void onClick(View paramView)
  {
    boolean bool2 = true;
    AppMethodBeat.i(13496);
    paramView = this.guh;
    if (!BindMobileStatusUI.b(this.guh).booleanValue())
    {
      bool1 = true;
      BindMobileStatusUI.a(paramView, Boolean.valueOf(bool1));
      if (!BindMobileStatusUI.b(this.guh).booleanValue()) {
        break label105;
      }
      BindMobileStatusUI.c(this.guh).setImageResource(2131231137);
      label62:
      paramView = this.guh;
      if (BindMobileStatusUI.b(this.guh).booleanValue()) {
        break label120;
      }
    }
    label105:
    label120:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      BindMobileStatusUI.a(paramView, bool1, 512, 8);
      AppMethodBeat.o(13496);
      return;
      bool1 = false;
      break;
      BindMobileStatusUI.c(this.guh).setImageResource(2131231142);
      break label62;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMobileStatusUI.2
 * JD-Core Version:    0.7.0.1
 */