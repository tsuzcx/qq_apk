package com.tencent.mm.plugin.exdevice.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R.k;
import com.tencent.mm.plugin.sport.b.d;
import com.tencent.mm.sdk.platformtools.bk;

final class ExdeviceRankInfoUI$12$3
  implements Runnable
{
  ExdeviceRankInfoUI$12$3(ExdeviceRankInfoUI.12 param12) {}
  
  public final void run()
  {
    ExdeviceRankInfoUI.h(this.jFW.jFV);
    if (!bk.bl(ExdeviceRankInfoUI.i(this.jFW.jFV))) {
      this.jFW.jFV.addIconOptionMenu(0, R.k.actionbar_icon_dark_more, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          d.jdMethod_if(11);
          ExdeviceRankInfoUI.j(ExdeviceRankInfoUI.12.3.this.jFW.jFV);
          return true;
        }
      });
    }
    if (ExdeviceRankInfoUI.k(this.jFW.jFV) != null) {
      ExdeviceRankInfoUI.k(this.jFW.jFV).BQ(ExdeviceRankInfoUI.l(this.jFW.jFV));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.12.3
 * JD-Core Version:    0.7.0.1
 */