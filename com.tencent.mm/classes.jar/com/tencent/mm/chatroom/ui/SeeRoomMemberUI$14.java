package com.tencent.mm.chatroom.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.h;

final class SeeRoomMemberUI$14
  implements AdapterView.OnItemLongClickListener
{
  SeeRoomMemberUI$14(SeeRoomMemberUI paramSeeRoomMemberUI) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (SeeRoomMemberUI.j(this.drs))
    {
      paramAdapterView = SeeRoomMemberUI.c(this.drs).gn(paramInt).dnp;
      if (paramAdapterView == null) {}
      do
      {
        return true;
        paramAdapterView = paramAdapterView.field_username;
      } while (SeeRoomMemberUI.f(this.drs).field_roomowner.equals(paramAdapterView));
      h.a(this.drs, this.drs.getString(a.i.room_del_this_member_tip), "", new SeeRoomMemberUI.14.1(this, paramInt), new SeeRoomMemberUI.14.2(this));
      return true;
    }
    y.i("MicroMsg.SeeRoomMemberUI", "U are not a roomowner");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeRoomMemberUI.14
 * JD-Core Version:    0.7.0.1
 */