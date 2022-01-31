package com.tencent.mm.chatroom.ui;

import android.text.Editable;
import android.text.TextUtils.TruncateAt;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMEditText;

final class ModRemarkRoomNameUI$1
  implements TextWatcher
{
  ModRemarkRoomNameUI$1(ModRemarkRoomNameUI paramModRemarkRoomNameUI, String paramString) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(104117);
    if (!this.egK.equals(paramCharSequence)) {
      this.egL.enableOptionMenu(true);
    }
    if (paramCharSequence.length() > 0)
    {
      ModRemarkRoomNameUI.a(this.egL).setEllipsize(null);
      AppMethodBeat.o(104117);
      return;
    }
    ModRemarkRoomNameUI.a(this.egL).setEllipsize(TextUtils.TruncateAt.END);
    AppMethodBeat.o(104117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ModRemarkRoomNameUI.1
 * JD-Core Version:    0.7.0.1
 */