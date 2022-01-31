package com.tencent.mm.chatroom.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;

final class DelChatroomMemberUI$a$1
  implements View.OnClickListener
{
  DelChatroomMemberUI$a$1(DelChatroomMemberUI.a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(104089);
    int i = ((Integer)paramView.getTag()).intValue();
    paramView = (ad)this.egn.getItem(i);
    String str = this.egn.egi.getString(2131302688, new Object[] { this.egn.c(paramView) });
    h.a(this.egn.egi, str, null, this.egn.egi.getString(2131302696), this.egn.egi.getString(2131296888), true, new DelChatroomMemberUI.a.1.1(this, paramView), new DelChatroomMemberUI.a.1.2(this));
    AppMethodBeat.o(104089);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.DelChatroomMemberUI.a.1
 * JD-Core Version:    0.7.0.1
 */