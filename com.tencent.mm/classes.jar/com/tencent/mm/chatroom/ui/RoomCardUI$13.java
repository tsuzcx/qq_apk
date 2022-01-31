package com.tencent.mm.chatroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMEditText;

final class RoomCardUI$13
  implements DialogInterface.OnClickListener
{
  RoomCardUI$13(RoomCardUI paramRoomCardUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(104156);
    paramDialogInterface = this.ehp;
    AppCompatActivity localAppCompatActivity = this.ehp.getContext();
    this.ehp.getString(2131297087);
    RoomCardUI.a(paramDialogInterface, h.b(localAppCompatActivity, this.ehp.getString(2131302783), false, null));
    if (RoomCardUI.e(this.ehp))
    {
      RoomCardUI.f(this.ehp);
      RoomCardUI.a(this.ehp, RoomCardUI.b(this.ehp).getText().toString());
    }
    AppMethodBeat.o(104156);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomCardUI.13
 * JD-Core Version:    0.7.0.1
 */