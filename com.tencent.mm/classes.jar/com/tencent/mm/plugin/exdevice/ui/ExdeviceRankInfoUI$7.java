package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class ExdeviceRankInfoUI$7
  implements View.OnClickListener
{
  ExdeviceRankInfoUI$7(ExdeviceRankInfoUI paramExdeviceRankInfoUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(179636);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceRankInfoUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    com.tencent.mm.plugin.sport.a.c.pl(24);
    paramView = new Intent();
    paramView.putExtra("Select_Talker_Name", "gh_43f2581f6fd6");
    paramView.putExtra("Select_block_List", "gh_43f2581f6fd6");
    paramView.putExtra("Select_Conv_Type", 3);
    paramView.putExtra("mutil_select_is_ret", true);
    paramView.putExtra("Select_Send_Card", true);
    com.tencent.mm.br.c.c(this.rKI, ".ui.transmit.SelectConversationUI", paramView, 3);
    a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankInfoUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(179636);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.7
 * JD-Core Version:    0.7.0.1
 */