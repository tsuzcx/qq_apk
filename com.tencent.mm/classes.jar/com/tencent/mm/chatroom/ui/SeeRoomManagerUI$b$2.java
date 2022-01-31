package com.tencent.mm.chatroom.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.h.c.ao;
import java.util.List;

final class SeeRoomManagerUI$b$2
  implements View.OnClickListener
{
  SeeRoomManagerUI$b$2(SeeRoomManagerUI.b paramb, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    paramView = (SeeRoomManagerUI.a)this.drj.dataList.get(this.kX);
    if (paramView.type == 1)
    {
      paramView = ((SeeRoomManagerUI.a)this.drj.dataList.get(this.kX)).dnp;
      SeeRoomManagerUI.a(this.drj.drh, paramView.field_username, SeeRoomManagerUI.b.a(this.drj, paramView), paramView.field_nickname);
    }
    do
    {
      return;
      if (paramView.type == 2)
      {
        paramView = new Intent(this.drj.drh, SelectAddRoomManagerUI.class);
        paramView.putExtra("RoomInfo_Id", SeeRoomManagerUI.c(this.drj.drh));
        this.drj.drh.startActivityForResult(paramView, 0);
        return;
      }
    } while (paramView.type != 3);
    paramView = new Intent(this.drj.drh, SelectDelRoomManagerUI.class);
    paramView.putExtra("RoomInfo_Id", SeeRoomManagerUI.c(this.drj.drh));
    paramView.putExtra("RoomManagers", SeeRoomManagerUI.e(this.drj.drh));
    this.drj.drh.startActivityForResult(paramView, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeRoomManagerUI.b.2
 * JD-Core Version:    0.7.0.1
 */