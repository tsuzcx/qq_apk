package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.app.ActivityManager.TaskDescription;
import android.graphics.Bitmap;
import com.tencent.mm.modelappbrand.a.b.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;

final class i$6
  extends b.b
{
  i$6(i parami, int paramInt) {}
  
  public final void p(Bitmap paramBitmap)
  {
    this.fyM.fyk.setTaskDescription(new ActivityManager.TaskDescription(this.fyM.ZA().bJw, paramBitmap, this.fyP));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.i.6
 * JD-Core Version:    0.7.0.1
 */