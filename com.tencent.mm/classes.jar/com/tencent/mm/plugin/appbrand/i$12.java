package com.tencent.mm.plugin.appbrand;

import android.os.Handler;

final class i$12
  implements Runnable
{
  i$12(i parami) {}
  
  public final void run()
  {
    i.a(this.fyM);
    this.fyM.dNk = true;
    i locali = this.fyM;
    locali.mHandler.removeCallbacks(locali.fyK);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.i.12
 * JD-Core Version:    0.7.0.1
 */