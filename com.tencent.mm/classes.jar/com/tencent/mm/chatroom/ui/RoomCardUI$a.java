package com.tencent.mm.chatroom.ui;

import android.text.Editable;
import android.text.TextWatcher;

final class RoomCardUI$a
  implements TextWatcher
{
  private int dpU = 280;
  private String dpV = "";
  private boolean dpW = false;
  
  private RoomCardUI$a(RoomCardUI paramRoomCardUI) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    RoomCardUI.d(this.dpS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomCardUI.a
 * JD-Core Version:    0.7.0.1
 */