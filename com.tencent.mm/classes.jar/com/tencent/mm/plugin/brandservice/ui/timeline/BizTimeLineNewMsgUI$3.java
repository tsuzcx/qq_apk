package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.q;

final class BizTimeLineNewMsgUI$3
  implements AdapterView.OnItemClickListener
{
  BizTimeLineNewMsgUI$3(BizTimeLineNewMsgUI paramBizTimeLineNewMsgUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(14158);
    paramAdapterView = BizTimeLineNewMsgUI.a(this.jWx).se(paramInt);
    if (paramAdapterView == null)
    {
      ab.e("MicroMsg.BizTimeLineNewMsgUI", "onItemClick info is null");
      AppMethodBeat.o(14158);
      return;
    }
    if (((j)g.E(j.class)).bPQ().kB(paramAdapterView.field_msgId).field_msgId == 0L)
    {
      com.tencent.mm.ui.base.h.bO(this.jWx, this.jWx.getString(2131297714));
      AppMethodBeat.o(14158);
      return;
    }
    paramView = new Intent();
    paramView.putExtra("Chat_User", paramAdapterView.field_talker);
    paramView.putExtra("finish_direct", true);
    paramView.putExtra("from_global_search", true);
    paramView.putExtra("msg_local_id", paramAdapterView.field_msgId);
    paramView.putExtra("specific_chat_from_scene", 9);
    paramView.putExtra("preChatTYPE", 13);
    d.f(this.jWx.getContext(), ".ui.chatting.ChattingUI", paramView);
    AppMethodBeat.o(14158);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineNewMsgUI.3
 * JD-Core Version:    0.7.0.1
 */