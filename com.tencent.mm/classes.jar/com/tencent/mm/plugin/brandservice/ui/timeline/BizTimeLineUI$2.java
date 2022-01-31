package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;

final class BizTimeLineUI$2
  implements MenuItem.OnMenuItemClickListener
{
  BizTimeLineUI$2(BizTimeLineUI paramBizTimeLineUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(14184);
    paramMenuItem = new Intent();
    paramMenuItem.addFlags(67108864);
    paramMenuItem.putExtra("biz_from_scene", 2);
    paramMenuItem.putExtra("biz_time_line_line_session_id", BizTimeLineUI.k(this.jXh));
    paramMenuItem.putExtra("biz_enter_source", BizTimeLineUI.g(this.jXh));
    d.f(this.jXh, ".ui.conversation.NewBizConversationUI", paramMenuItem);
    BizTimeLineUI.h(this.jXh).sg(7);
    BizTimeLineUI.l(this.jXh);
    AppMethodBeat.o(14184);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.2
 * JD-Core Version:    0.7.0.1
 */