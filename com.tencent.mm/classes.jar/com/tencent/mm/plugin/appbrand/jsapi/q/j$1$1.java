package com.tencent.mm.plugin.appbrand.jsapi.q;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.g.c;

final class j$1$1
  extends g.b
{
  j$1$1(j.1 param1, WindowManager.LayoutParams paramLayoutParams, Activity paramActivity) {}
  
  public final void a(g.c paramc)
  {
    this.gCp.screenBrightness = this.gCq.gCo.gCm;
    this.val$activity.getWindow().setAttributes(this.gCp);
  }
  
  public final void onResume()
  {
    this.gCp.screenBrightness = this.gCq.gCo.gCn;
    this.val$activity.getWindow().setAttributes(this.gCp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.j.1.1
 * JD-Core Version:    0.7.0.1
 */