package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R.l;

final class BakOperatingUI$9
  implements Runnable
{
  BakOperatingUI$9(BakOperatingUI paramBakOperatingUI, int paramInt) {}
  
  public final void run()
  {
    if (BakOperatingUI.h(this.hPc) != null) {
      BakOperatingUI.h(this.hPc).setProgress(this.fjt);
    }
    if ((BakOperatingUI.i(this.hPc) != null) && (BakOperatingUI.k(this.hPc) != null))
    {
      BakOperatingUI.i(this.hPc).setText(this.hPc.getString(R.l.bak_chat_pc_merge_progress_tip) + this.fjt + "%");
      BakOperatingUI.k(this.hPc).setText(this.hPc.getString(R.l.bak_chat_to_pc_merging_tip));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakOperatingUI.9
 * JD-Core Version:    0.7.0.1
 */