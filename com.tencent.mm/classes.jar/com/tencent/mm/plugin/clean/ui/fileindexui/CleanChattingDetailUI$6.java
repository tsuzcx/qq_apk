package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.app.ProgressDialog;
import android.content.Intent;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.h;

final class CleanChattingDetailUI$6
  implements Runnable
{
  CleanChattingDetailUI$6(CleanChattingDetailUI paramCleanChattingDetailUI, long paramLong) {}
  
  public final void run()
  {
    CleanChattingDetailUI.c(this.iCT).dismiss();
    Intent localIntent = new Intent();
    localIntent.putExtra("key_pos", CleanChattingDetailUI.d(this.iCT));
    localIntent.putExtra("key_delete_size", CleanChattingDetailUI.e(this.iCT));
    this.iCT.setResult(1000, localIntent);
    h.b(this.iCT, this.iCT.getString(R.l.clean_del_data_ok_tip, new Object[] { bk.cm(this.iCV) }), "", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingDetailUI.6
 * JD-Core Version:    0.7.0.1
 */