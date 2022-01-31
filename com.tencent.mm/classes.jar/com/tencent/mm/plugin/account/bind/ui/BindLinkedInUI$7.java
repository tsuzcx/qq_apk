package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.ui.base.h;

final class BindLinkedInUI$7
  implements View.OnClickListener
{
  BindLinkedInUI$7(BindLinkedInUI paramBindLinkedInUI) {}
  
  public final void onClick(View paramView)
  {
    if (!BindLinkedInUI.b(this.fbn))
    {
      BindLinkedInUI.c(this.fbn);
      return;
    }
    if (!BindLinkedInUI.d(this.fbn))
    {
      BindLinkedInUI.e(this.fbn);
      return;
    }
    h.a(this.fbn, this.fbn.getString(a.i.contact_info_linkedin_account_overwrite_binded_account), null, new BindLinkedInUI.7.1(this), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI.7
 * JD-Core Version:    0.7.0.1
 */