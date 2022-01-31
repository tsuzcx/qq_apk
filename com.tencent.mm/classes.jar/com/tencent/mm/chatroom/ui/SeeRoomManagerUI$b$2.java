package com.tencent.mm.chatroom.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import java.util.List;

final class SeeRoomManagerUI$b$2
  implements View.OnClickListener
{
  SeeRoomManagerUI$b$2(SeeRoomManagerUI.b paramb, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(104288);
    paramView = (SeeRoomManagerUI.a)this.eiR.dataList.get(this.lU);
    if (paramView.type == 1)
    {
      paramView = ((SeeRoomManagerUI.a)this.eiR.dataList.get(this.lU)).contact;
      SeeRoomManagerUI.a(this.eiR.eiP, paramView.field_username, SeeRoomManagerUI.b.a(this.eiR, paramView), paramView.field_nickname);
      AppMethodBeat.o(104288);
      return;
    }
    if (paramView.type == 2)
    {
      paramView = new Intent(this.eiR.eiP, SelectAddRoomManagerUI.class);
      paramView.putExtra("RoomInfo_Id", SeeRoomManagerUI.c(this.eiR.eiP));
      this.eiR.eiP.startActivityForResult(paramView, 0);
      AppMethodBeat.o(104288);
      return;
    }
    if (paramView.type == 3)
    {
      paramView = new Intent(this.eiR.eiP, SelectDelRoomManagerUI.class);
      paramView.putExtra("RoomInfo_Id", SeeRoomManagerUI.c(this.eiR.eiP));
      paramView.putExtra("RoomManagers", SeeRoomManagerUI.e(this.eiR.eiP));
      this.eiR.eiP.startActivityForResult(paramView, 1);
    }
    AppMethodBeat.o(104288);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeRoomManagerUI.b.2
 * JD-Core Version:    0.7.0.1
 */