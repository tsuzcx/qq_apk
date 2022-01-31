package com.tencent.mm.chatroom.ui;

import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashMap;

final class SelectDateUI$1
  implements Runnable
{
  SelectDateUI$1(SelectDateUI paramSelectDateUI) {}
  
  public final void run()
  {
    SelectDateUI.a(this.drM);
    SelectDateUI.f(this.drM).post(new Runnable()
    {
      public final void run()
      {
        DayPickerView localDayPickerView = SelectDateUI.c(SelectDateUI.1.this.drM);
        if (SelectDateUI.b(SelectDateUI.1.this.drM) == -1L) {}
        for (long l = System.currentTimeMillis() * 1000L;; l = SelectDateUI.b(SelectDateUI.1.this.drM))
        {
          localDayPickerView.setBeginDate(l);
          SelectDateUI.c(SelectDateUI.1.this.drM).a(SelectDateUI.1.this.drM, SelectDateUI.d(SelectDateUI.1.this.drM).values());
          if (SelectDateUI.d(SelectDateUI.1.this.drM).size() != 0) {
            break;
          }
          SelectDateUI.e(SelectDateUI.1.this.drM).setVisibility(0);
          SelectDateUI.c(SelectDateUI.1.this.drM).setVisibility(8);
          SelectDateUI.e(SelectDateUI.1.this.drM).setText(SelectDateUI.1.this.drM.getString(a.i.chatting_record_noting_hint));
          return;
        }
        SelectDateUI.e(SelectDateUI.1.this.drM).setVisibility(8);
        SelectDateUI.c(SelectDateUI.1.this.drM).setVisibility(0);
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectDateUI.1
 * JD-Core Version:    0.7.0.1
 */