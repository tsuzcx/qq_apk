package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ExdeviceRankInfoUI$6
  implements View.OnClickListener
{
  ExdeviceRankInfoUI$6(ExdeviceRankInfoUI paramExdeviceRankInfoUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(20140);
    com.tencent.mm.plugin.sport.a.d.kS(24);
    paramView = new Intent();
    paramView.putExtra("Select_Talker_Name", "gh_43f2581f6fd6");
    paramView.putExtra("Select_block_List", "gh_43f2581f6fd6");
    paramView.putExtra("Select_Conv_Type", 3);
    paramView.putExtra("mutil_select_is_ret", true);
    paramView.putExtra("Select_Send_Card", true);
    com.tencent.mm.bq.d.b(this.lPt, ".ui.transmit.SelectConversationUI", paramView, 3);
    AppMethodBeat.o(20140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.6
 * JD-Core Version:    0.7.0.1
 */