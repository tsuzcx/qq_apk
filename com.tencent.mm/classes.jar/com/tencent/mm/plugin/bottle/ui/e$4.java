package com.tencent.mm.plugin.bottle.ui;

import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.p;
import java.util.TimerTask;

final class e$4
  extends TimerTask
{
  e$4(p paramp, ah paramah) {}
  
  public final void run()
  {
    if (this.hZQ != null)
    {
      this.hZQ.dismiss();
      this.hZR.sendEmptyMessage(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.e.4
 * JD-Core Version:    0.7.0.1
 */