package com.tencent.mm.chatroom.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.contact.z;
import com.tencent.mm.ui.widget.MMEditText;

final class SeeRoomMemberUI$13
  implements AdapterView.OnItemClickListener
{
  SeeRoomMemberUI$13(SeeRoomMemberUI paramSeeRoomMemberUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(104319);
    paramAdapterView = SeeRoomMemberUI.c(this.eja).iC(paramInt);
    if (paramAdapterView.type == 2)
    {
      ab.i("MicroMsg.SeeRoomMemberUI", "[onItemClick] Add member");
      h.qsU.idkeyStat(219L, 6L, 1L, true);
      SeeRoomMemberUI.d(this.eja);
      AppMethodBeat.o(104319);
      return;
    }
    if (paramAdapterView.type == 3)
    {
      ab.i("MicroMsg.SeeRoomMemberUI", "[onItemClick] Delete member");
      SeeRoomMemberUI.e(this.eja);
      AppMethodBeat.o(104319);
      return;
    }
    String str;
    if (paramAdapterView.type == 1)
    {
      paramAdapterView = SeeRoomMemberUI.c(this.eja).iC(paramInt).contact;
      if (paramAdapterView == null)
      {
        ab.e("MicroMsg.SeeRoomMemberUI", "cont is null");
        AppMethodBeat.o(104319);
        return;
      }
      SeeRoomMemberUI.a(this.eja, paramAdapterView.field_username);
      paramView = paramAdapterView.field_nickname;
      str = SeeRoomMemberUI.a(SeeRoomMemberUI.f(this.eja), SeeRoomMemberUI.g(this.eja));
      if (!bo.isNullOrNil(str)) {
        break label233;
      }
      SeeRoomMemberUI.b(this.eja, paramAdapterView.Of());
    }
    for (;;)
    {
      z.r(SeeRoomMemberUI.h(this.eja).getText().toString(), 1, 6, paramInt + 1);
      SeeRoomMemberUI.a(this.eja, SeeRoomMemberUI.g(this.eja), SeeRoomMemberUI.i(this.eja), paramView);
      AppMethodBeat.o(104319);
      return;
      label233:
      SeeRoomMemberUI.b(this.eja, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeRoomMemberUI.13
 * JD-Core Version:    0.7.0.1
 */