package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.br.d;

final class BizTimeLineUI$16
  implements MenuItem.OnMenuItemClickListener
{
  BizTimeLineUI$16(BizTimeLineUI paramBizTimeLineUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new Intent();
    paramMenuItem.addFlags(67108864);
    paramMenuItem.putExtra("biz_from_scene", 2);
    paramMenuItem.putExtra("biz_time_line_line_session_id", BizTimeLineUI.i(this.ihl));
    d.e(this.ihl, ".ui.conversation.NewBizConversationUI", paramMenuItem);
    BizTimeLineUI.e(this.ihl).a("", 0L, 7);
    BizTimeLineUI.j(this.ihl);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.16
 * JD-Core Version:    0.7.0.1
 */