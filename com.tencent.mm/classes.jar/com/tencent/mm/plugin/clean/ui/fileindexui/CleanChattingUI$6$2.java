package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.widget.TextView;
import com.tencent.mm.R.l;

final class CleanChattingUI$6$2
  implements Runnable
{
  CleanChattingUI$6$2(CleanChattingUI.6 param6) {}
  
  public final void run()
  {
    CleanChattingUI.a(this.iDd.iDb).notifyDataSetChanged();
    CleanChattingUI.e(this.iDd.iDb).setText(R.l.clean_chatting_empty);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingUI.6.2
 * JD-Core Version:    0.7.0.1
 */