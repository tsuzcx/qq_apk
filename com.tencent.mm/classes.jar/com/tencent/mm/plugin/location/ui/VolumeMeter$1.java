package com.tencent.mm.plugin.location.ui;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ah;

final class VolumeMeter$1
  implements Runnable
{
  VolumeMeter$1(VolumeMeter paramVolumeMeter) {}
  
  public final void run()
  {
    Looper.prepare();
    VolumeMeter.a(this.lHN, new ah());
    Looper.loop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.VolumeMeter.1
 * JD-Core Version:    0.7.0.1
 */