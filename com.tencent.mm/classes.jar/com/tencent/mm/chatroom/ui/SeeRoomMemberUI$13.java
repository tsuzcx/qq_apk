package com.tencent.mm.chatroom.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.widget.MMEditText;

final class SeeRoomMemberUI$13
  implements AdapterView.OnItemClickListener
{
  SeeRoomMemberUI$13(SeeRoomMemberUI paramSeeRoomMemberUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = SeeRoomMemberUI.c(this.drs).gn(paramInt);
    if (paramAdapterView.type == 2)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SeeRoomMemberUI", "[onItemClick] Add member");
      h.nFQ.a(219L, 6L, 1L, true);
      SeeRoomMemberUI.d(this.drs);
    }
    do
    {
      return;
      if (paramAdapterView.type == 3)
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SeeRoomMemberUI", "[onItemClick] Delete member");
        SeeRoomMemberUI.e(this.drs);
        return;
      }
    } while (paramAdapterView.type != 1);
    paramAdapterView = SeeRoomMemberUI.c(this.drs).gn(paramInt).dnp;
    if (paramAdapterView == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SeeRoomMemberUI", "cont is null");
      return;
    }
    SeeRoomMemberUI.a(this.drs, paramAdapterView.field_username);
    paramView = paramAdapterView.field_nickname;
    String str = SeeRoomMemberUI.a(SeeRoomMemberUI.f(this.drs), SeeRoomMemberUI.g(this.drs));
    if (bk.bl(str)) {
      SeeRoomMemberUI.b(this.drs, paramAdapterView.Bq());
    }
    for (;;)
    {
      com.tencent.mm.ui.contact.y.o(SeeRoomMemberUI.h(this.drs).getText().toString(), 1, 6, paramInt + 1);
      SeeRoomMemberUI.a(this.drs, SeeRoomMemberUI.g(this.drs), SeeRoomMemberUI.i(this.drs), paramView);
      return;
      SeeRoomMemberUI.b(this.drs, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeRoomMemberUI.13
 * JD-Core Version:    0.7.0.1
 */