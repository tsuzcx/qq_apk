package com.tencent.mm.chatroom.ui;

import android.text.Editable;
import android.text.TextWatcher;

final class SeeRoomMemberUI$12
  implements TextWatcher
{
  SeeRoomMemberUI$12(SeeRoomMemberUI paramSeeRoomMemberUI) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    SeeRoomMemberUI.c(this.drs).eT(paramCharSequence.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeRoomMemberUI.12
 * JD-Core Version:    0.7.0.1
 */