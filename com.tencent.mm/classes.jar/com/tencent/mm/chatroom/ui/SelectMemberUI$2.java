package com.tencent.mm.chatroom.ui;

import android.os.HandlerThread;
import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;

final class SelectMemberUI$2
  implements TextWatcher
{
  private am dsc = new am(g.DS().mnU.getLooper(), new SelectMemberUI.2.1(this), false);
  
  SelectMemberUI$2(SelectMemberUI paramSelectMemberUI) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.dsc.stopTimer();
    this.dsc.S(500L, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectMemberUI.2
 * JD-Core Version:    0.7.0.1
 */