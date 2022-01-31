package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.AppCompatActivity;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.MMEditText;

final class RoomCardUI$11
  implements DialogInterface.OnClickListener
{
  RoomCardUI$11(RoomCardUI paramRoomCardUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.dpS;
    AppCompatActivity localAppCompatActivity = this.dpS.mController.uMN;
    this.dpS.getString(a.i.app_tip);
    RoomCardUI.a(paramDialogInterface, h.b(localAppCompatActivity, this.dpS.getString(a.i.room_saving_notice), false, null));
    if (RoomCardUI.e(this.dpS))
    {
      RoomCardUI.f(this.dpS);
      RoomCardUI.a(this.dpS, RoomCardUI.b(this.dpS).getText().toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomCardUI.11
 * JD-Core Version:    0.7.0.1
 */