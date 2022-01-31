package com.tencent.mm.plugin.brandservice.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.brandservice.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.ui.base.n.d;

final class EnterpriseBizContactListUI$2$2
  implements n.d
{
  EnterpriseBizContactListUI$2$2(EnterpriseBizContactListUI.2 param2) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return;
    case 2: 
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Select_Talker_Name", this.idt.ids.ido);
      paramMenuItem.putExtra("Select_block_List", this.idt.ids.ido);
      paramMenuItem.putExtra("Select_Send_Card", true);
      paramMenuItem.putExtra("Select_Conv_Type", 3);
      d.c(this.idt.ids, ".ui.transmit.SelectConversationUI", paramMenuItem, 1);
      return;
    case 3: 
      paramMenuItem = new Intent(this.idt.ids, EnterpriseBizContactPlainListUI.class);
      paramMenuItem.putExtra("enterprise_biz_name", this.idt.ids.ido);
      paramMenuItem.putExtra("enterprise_scene", 2);
      this.idt.ids.startActivity(paramMenuItem);
      return;
    }
    paramMenuItem = new Intent();
    paramMenuItem.putExtra("Contact_User", this.idt.ids.ido);
    a.eUR.d(paramMenuItem, this.idt.ids);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListUI.2.2
 * JD-Core Version:    0.7.0.1
 */