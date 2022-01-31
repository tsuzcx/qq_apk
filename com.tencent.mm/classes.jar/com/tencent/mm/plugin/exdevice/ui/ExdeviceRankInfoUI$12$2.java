package com.tencent.mm.plugin.exdevice.ui;

import android.widget.Toast;
import com.tencent.mm.R.l;

final class ExdeviceRankInfoUI$12$2
  implements Runnable
{
  ExdeviceRankInfoUI$12$2(ExdeviceRankInfoUI.12 param12) {}
  
  public final void run()
  {
    Toast.makeText(this.jFW.jFV, R.l.exdevice_open_rank_list_failed, 1).show();
    this.jFW.jFV.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.12.2
 * JD-Core Version:    0.7.0.1
 */