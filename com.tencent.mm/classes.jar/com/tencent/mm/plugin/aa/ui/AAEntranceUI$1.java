package com.tencent.mm.plugin.aa.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.aa.a.h;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class AAEntranceUI$1
  implements View.OnClickListener
{
  AAEntranceUI$1(AAEntranceUI paramAAEntranceUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("key_from_scene", 1);
    paramView.putExtra("Select_Conv_Type", 3);
    paramView.putExtra("select_is_ret", false);
    paramView.putExtra("mutil_select_is_ret", false);
    paramView.putExtra("Select_block_List", q.Gj());
    paramView.putExtra("recent_remittance_contact_list", h.Vs());
    d.b(this.eXp.mController.uMN, "remittance", ".ui.SelectRemittanceContactUI", paramView, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AAEntranceUI.1
 * JD-Core Version:    0.7.0.1
 */