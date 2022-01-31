package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R.l;

final class BakOperatingUI$10$1
  implements Runnable
{
  BakOperatingUI$10$1(BakOperatingUI.10 param10) {}
  
  public final void run()
  {
    this.hPd.hPc.showOptionMenu(false);
    if (BakOperatingUI.h(this.hPd.hPc) != null) {
      BakOperatingUI.h(this.hPd.hPc).setProgress(0);
    }
    if (BakOperatingUI.k(this.hPd.hPc) != null) {
      BakOperatingUI.k(this.hPd.hPc).setText(this.hPd.hPc.getString(R.l.bak_chat_to_pc_merging_tip));
    }
    if (BakOperatingUI.l(this.hPd.hPc) != null) {
      BakOperatingUI.l(this.hPd.hPc).setText(this.hPd.hPc.getString(R.l.bak_chat_to_pc_merge_operating_tip));
    }
    if (BakOperatingUI.i(this.hPd.hPc) != null) {
      BakOperatingUI.i(this.hPd.hPc).setText(this.hPd.hPc.getString(R.l.bak_chat_pc_merge_progress_tip) + "0%");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakOperatingUI.10.1
 * JD-Core Version:    0.7.0.1
 */