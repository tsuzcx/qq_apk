package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.plugin.brandservice.b.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;

final class BizTimeLineNewMsgUI$3
  implements AdapterView.OnItemClickListener
{
  BizTimeLineNewMsgUI$3(BizTimeLineNewMsgUI paramBizTimeLineNewMsgUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = BizTimeLineNewMsgUI.a(this.igE).oy(paramInt);
    if (paramAdapterView == null)
    {
      y.e("MicroMsg.BizTimeLineNewMsgUI", "onItemClick info is null");
      return;
    }
    if (((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(paramAdapterView.field_msgId).field_msgId == 0L)
    {
      h.bC(this.igE, this.igE.getString(b.h.biz_time_line_new_msg_delete_tips));
      return;
    }
    paramView = new Intent();
    paramView.putExtra("Chat_User", paramAdapterView.field_talker);
    paramView.putExtra("finish_direct", true);
    paramView.putExtra("from_global_search", true);
    paramView.putExtra("msg_local_id", paramAdapterView.field_msgId);
    d.e(this.igE.mController.uMN, ".ui.chatting.ChattingUI", paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineNewMsgUI.3
 * JD-Core Version:    0.7.0.1
 */