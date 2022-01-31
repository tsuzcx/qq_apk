package com.tencent.mm.chatroom.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RoomCardUI$a
  implements TextWatcher
{
  private int ehr = 280;
  private String ehs = "";
  private boolean eht = false;
  
  private RoomCardUI$a(RoomCardUI paramRoomCardUI) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(104157);
    RoomCardUI.d(this.ehp);
    AppMethodBeat.o(104157);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomCardUI.a
 * JD-Core Version:    0.7.0.1
 */