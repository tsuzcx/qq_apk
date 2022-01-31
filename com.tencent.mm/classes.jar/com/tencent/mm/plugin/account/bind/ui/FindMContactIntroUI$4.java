package com.tencent.mm.plugin.account.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.ui.base.h;

final class FindMContactIntroUI$4
  implements View.OnClickListener
{
  FindMContactIntroUI$4(FindMContactIntroUI paramFindMContactIntroUI) {}
  
  public final void onClick(View paramView)
  {
    h.a(this.fdm, this.fdm.getString(a.i.find_mcontact_skip_alert), null, this.fdm.getString(a.i.find_mcontact_skip_btn), this.fdm.getString(a.i.find_mcontact_skip_add_friend), new FindMContactIntroUI.4.1(this), new FindMContactIntroUI.4.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.FindMContactIntroUI.4
 * JD-Core Version:    0.7.0.1
 */