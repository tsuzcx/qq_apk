package com.tencent.mm.chatroom.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.h;

final class SeeRoomMemberUI$14
  implements AdapterView.OnItemLongClickListener
{
  SeeRoomMemberUI$14(SeeRoomMemberUI paramSeeRoomMemberUI) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(104321);
    if (SeeRoomMemberUI.j(this.eja))
    {
      paramAdapterView = SeeRoomMemberUI.c(this.eja).iC(paramInt).contact;
      if (paramAdapterView == null)
      {
        AppMethodBeat.o(104321);
        return true;
      }
      paramAdapterView = paramAdapterView.field_username;
      if (SeeRoomMemberUI.f(this.eja).field_roomowner.equals(paramAdapterView))
      {
        AppMethodBeat.o(104321);
        return true;
      }
      h.a(this.eja, this.eja.getString(2131302686), "", new SeeRoomMemberUI.14.1(this, paramInt), new SeeRoomMemberUI.14.2(this));
    }
    for (;;)
    {
      AppMethodBeat.o(104321);
      return true;
      ab.i("MicroMsg.SeeRoomMemberUI", "U are not a roomowner");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeRoomMemberUI.14
 * JD-Core Version:    0.7.0.1
 */