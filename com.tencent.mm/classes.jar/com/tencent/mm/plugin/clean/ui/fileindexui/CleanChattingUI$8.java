package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.app.ProgressDialog;
import android.widget.TextView;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.h;

final class CleanChattingUI$8
  implements Runnable
{
  CleanChattingUI$8(CleanChattingUI paramCleanChattingUI, long paramLong) {}
  
  public final void run()
  {
    CleanChattingUI.g(this.iDb).dismiss();
    h.b(this.iDb, this.iDb.getString(R.l.clean_del_data_ok_tip, new Object[] { bk.cm(this.iCV) }), "", true);
    CleanChattingUI.e(this.iDb).setText(this.iDb.getString(R.l.analyse_file_profress, new Object[] { " " }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingUI.8
 * JD-Core Version:    0.7.0.1
 */