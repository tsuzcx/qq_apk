package com.tencent.mm.plugin.location.ui.impl;

import android.app.ProgressDialog;

final class i$6
  implements Runnable
{
  i$6(i parami) {}
  
  public final void run()
  {
    if (this.lKF.lIf)
    {
      if (this.lKF.dnm != null) {
        this.lKF.dnm.dismiss();
      }
      this.lKF.beZ();
    }
    this.lKF.lIf = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.i.6
 * JD-Core Version:    0.7.0.1
 */