package com.tencent.mm.plugin.account.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a.a;
import com.tencent.mm.storage.z;

final class FindMContactLearmMoreUI$1
  implements View.OnClickListener
{
  FindMContactLearmMoreUI$1(FindMContactLearmMoreUI paramFindMContactLearmMoreUI) {}
  
  public final void onClick(View paramView)
  {
    g.DP().Dz().o(12322, Boolean.valueOf(true));
    ((a)g.t(a.class)).syncUploadMContactStatus(true, false);
    FindMContactLearmMoreUI.a(this.fdq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.FindMContactLearmMoreUI.1
 * JD-Core Version:    0.7.0.1
 */