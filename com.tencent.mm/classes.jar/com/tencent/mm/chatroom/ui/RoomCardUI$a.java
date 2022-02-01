package com.tencent.mm.chatroom.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class RoomCardUI$a
  implements TextWatcher
{
  private int gyn = 280;
  private String gyo = "";
  private boolean gyp = false;
  
  private RoomCardUI$a(RoomCardUI paramRoomCardUI) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(12703);
    RoomCardUI.d(this.gyl);
    AppMethodBeat.o(12703);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomCardUI.a
 * JD-Core Version:    0.7.0.1
 */