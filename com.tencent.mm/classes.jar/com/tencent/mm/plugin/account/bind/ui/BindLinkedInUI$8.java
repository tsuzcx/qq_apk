package com.tencent.mm.plugin.account.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.ui.base.h;

final class BindLinkedInUI$8
  implements View.OnClickListener
{
  BindLinkedInUI$8(BindLinkedInUI paramBindLinkedInUI) {}
  
  public final void onClick(View paramView)
  {
    h.a(this.fbn, this.fbn.getString(a.i.contact_info_linkedin_account_unbind_alert), null, new BindLinkedInUI.8.1(this), new BindLinkedInUI.8.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI.8
 * JD-Core Version:    0.7.0.1
 */