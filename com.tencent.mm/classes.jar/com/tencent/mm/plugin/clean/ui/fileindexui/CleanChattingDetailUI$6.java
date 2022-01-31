package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.app.ProgressDialog;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;

final class CleanChattingDetailUI$6
  implements Runnable
{
  CleanChattingDetailUI$6(CleanChattingDetailUI paramCleanChattingDetailUI, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(18771);
    CleanChattingDetailUI.c(this.kIa).dismiss();
    Intent localIntent = new Intent();
    localIntent.putExtra("key_pos", CleanChattingDetailUI.d(this.kIa));
    localIntent.putExtra("key_delete_size", CleanChattingDetailUI.e(this.kIa));
    this.kIa.setResult(1000, localIntent);
    h.b(this.kIa, this.kIa.getString(2131298375, new Object[] { bo.hk(this.kIc) }), "", true);
    AppMethodBeat.o(18771);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingDetailUI.6
 * JD-Core Version:    0.7.0.1
 */