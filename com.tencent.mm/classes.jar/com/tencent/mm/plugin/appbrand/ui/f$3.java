package com.tencent.mm.plugin.appbrand.ui;

import android.view.ViewGroup;

final class f$3
  implements Runnable
{
  f$3(f paramf) {}
  
  public final void run()
  {
    this.hdm.setVisibility(8);
    if (this.hdm.getParent() != null) {
      ((ViewGroup)this.hdm.getParent()).removeView(this.hdm);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.f.3
 * JD-Core Version:    0.7.0.1
 */