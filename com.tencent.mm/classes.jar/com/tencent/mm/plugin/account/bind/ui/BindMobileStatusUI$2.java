package com.tencent.mm.plugin.account.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.plugin.account.bind.a.h;

final class BindMobileStatusUI$2
  implements View.OnClickListener
{
  BindMobileStatusUI$2(BindMobileStatusUI paramBindMobileStatusUI) {}
  
  public final void onClick(View paramView)
  {
    boolean bool2 = true;
    paramView = this.fcx;
    if (!BindMobileStatusUI.b(this.fcx).booleanValue())
    {
      bool1 = true;
      BindMobileStatusUI.a(paramView, Boolean.valueOf(bool1));
      if (!BindMobileStatusUI.b(this.fcx).booleanValue()) {
        break label94;
      }
      BindMobileStatusUI.c(this.fcx).setImageResource(a.h.checkbox_selected);
      label57:
      paramView = this.fcx;
      if (BindMobileStatusUI.b(this.fcx).booleanValue()) {
        break label110;
      }
    }
    label94:
    label110:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      BindMobileStatusUI.a(paramView, bool1, 512, 8);
      return;
      bool1 = false;
      break;
      BindMobileStatusUI.c(this.fcx).setImageResource(a.h.checkbox_unselected);
      break label57;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMobileStatusUI.2
 * JD-Core Version:    0.7.0.1
 */