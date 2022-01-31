package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.plugin.appbrand.task.h.a;

final class AppBrandUI$3
  implements h
{
  AppBrandUI$3(AppBrandUI paramAppBrandUI) {}
  
  public final void a(h.a parama)
  {
    AppBrandUI.a(this.hep, parama);
  }
  
  public final FrameLayout aoN()
  {
    return (FrameLayout)AppBrandUI.b(this.hep);
  }
  
  public final boolean aoO()
  {
    return this.hep.aoO();
  }
  
  public final void finish()
  {
    this.hep.finish();
  }
  
  public final Activity getContext()
  {
    return this.hep;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandUI.3
 * JD-Core Version:    0.7.0.1
 */