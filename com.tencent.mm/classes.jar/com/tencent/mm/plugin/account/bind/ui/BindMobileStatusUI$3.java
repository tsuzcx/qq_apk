package com.tencent.mm.plugin.account.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.plugin.account.bind.a.h;

final class BindMobileStatusUI$3
  implements View.OnClickListener
{
  BindMobileStatusUI$3(BindMobileStatusUI paramBindMobileStatusUI) {}
  
  public final void onClick(View paramView)
  {
    boolean bool2 = true;
    paramView = this.fcx;
    if (!BindMobileStatusUI.d(this.fcx).booleanValue())
    {
      bool1 = true;
      BindMobileStatusUI.b(paramView, Boolean.valueOf(bool1));
      if (!BindMobileStatusUI.d(this.fcx).booleanValue()) {
        break label120;
      }
      BindMobileStatusUI.e(this.fcx).setImageResource(a.h.checkbox_selected);
      label57:
      paramView = this.fcx;
      if (BindMobileStatusUI.d(this.fcx).booleanValue()) {
        break label136;
      }
    }
    label136:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      BindMobileStatusUI.a(paramView, bool1, 256, 7);
      if (!BindMobileStatusUI.d(this.fcx).booleanValue()) {
        BindMobileStatusUI.a(this.fcx, false, 2097152, 32);
      }
      return;
      bool1 = false;
      break;
      label120:
      BindMobileStatusUI.e(this.fcx).setImageResource(a.h.checkbox_unselected);
      break label57;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMobileStatusUI.3
 * JD-Core Version:    0.7.0.1
 */