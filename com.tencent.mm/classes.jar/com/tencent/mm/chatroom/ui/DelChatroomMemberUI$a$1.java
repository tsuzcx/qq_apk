package com.tencent.mm.chatroom.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;

final class DelChatroomMemberUI$a$1
  implements View.OnClickListener
{
  DelChatroomMemberUI$a$1(DelChatroomMemberUI.a parama) {}
  
  public final void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    paramView = (ad)this.doR.getItem(i);
    String str = this.doR.doM.getString(a.i.room_delete_member_alert, new Object[] { this.doR.c(paramView) });
    h.a(this.doR.doM, str, null, this.doR.doM.getString(a.i.room_delete_member_remove_it), this.doR.doM.getString(a.i.app_cancel), true, new DelChatroomMemberUI.a.1.1(this, paramView), new DelChatroomMemberUI.a.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.DelChatroomMemberUI.a.1
 * JD-Core Version:    0.7.0.1
 */