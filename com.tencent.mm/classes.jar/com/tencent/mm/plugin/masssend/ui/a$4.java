package com.tencent.mm.plugin.masssend.ui;

import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.p;
import java.util.TimerTask;

final class a$4
  extends TimerTask
{
  a$4(p paramp, ah paramah) {}
  
  public final void run()
  {
    if (this.hZQ != null)
    {
      this.hZQ.dismiss();
      this.hZR.sendEmptyMessage(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.a.4
 * JD-Core Version:    0.7.0.1
 */