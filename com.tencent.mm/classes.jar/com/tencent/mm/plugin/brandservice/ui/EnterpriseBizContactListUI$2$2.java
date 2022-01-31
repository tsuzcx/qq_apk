package com.tencent.mm.plugin.brandservice.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.brandservice.b;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.ui.base.n.d;

final class EnterpriseBizContactListUI$2$2
  implements n.d
{
  EnterpriseBizContactListUI$2$2(EnterpriseBizContactListUI.2 param2) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(13944);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(13944);
      return;
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Select_Talker_Name", this.jUh.jUg.jUc);
      paramMenuItem.putExtra("Select_block_List", this.jUh.jUg.jUc);
      paramMenuItem.putExtra("Select_Send_Card", true);
      paramMenuItem.putExtra("Select_Conv_Type", 3);
      d.b(this.jUh.jUg, ".ui.transmit.SelectConversationUI", paramMenuItem, 1);
      AppMethodBeat.o(13944);
      return;
      paramMenuItem = new Intent(this.jUh.jUg, EnterpriseBizContactPlainListUI.class);
      paramMenuItem.putExtra("enterprise_biz_name", this.jUh.jUg.jUc);
      paramMenuItem.putExtra("enterprise_scene", 2);
      this.jUh.jUg.startActivity(paramMenuItem);
      AppMethodBeat.o(13944);
      return;
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Contact_User", this.jUh.jUg.jUc);
      b.gmO.c(paramMenuItem, this.jUh.jUg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListUI.2.2
 * JD-Core Version:    0.7.0.1
 */