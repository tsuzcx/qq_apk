package com.tencent.mm.chatroom.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

final class SelectDateUI$1$1
  implements Runnable
{
  SelectDateUI$1$1(SelectDateUI.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(104379);
    DayPickerView localDayPickerView = SelectDateUI.c(this.ejv.eju);
    if (SelectDateUI.b(this.ejv.eju) == -1L) {}
    for (long l = System.currentTimeMillis() * 1000L;; l = SelectDateUI.b(this.ejv.eju))
    {
      localDayPickerView.setBeginDate(l);
      SelectDateUI.c(this.ejv.eju).a(this.ejv.eju, SelectDateUI.d(this.ejv.eju).values());
      if (SelectDateUI.d(this.ejv.eju).size() != 0) {
        break;
      }
      SelectDateUI.e(this.ejv.eju).setVisibility(0);
      SelectDateUI.c(this.ejv.eju).setVisibility(8);
      SelectDateUI.e(this.ejv.eju).setText(this.ejv.eju.getString(2131298288));
      AppMethodBeat.o(104379);
      return;
    }
    SelectDateUI.e(this.ejv.eju).setVisibility(8);
    SelectDateUI.c(this.ejv.eju).setVisibility(0);
    AppMethodBeat.o(104379);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectDateUI.1.1
 * JD-Core Version:    0.7.0.1
 */