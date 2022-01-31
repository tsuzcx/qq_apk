package com.tencent.mm.plugin.appbrand.menu;

import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.y.j;

final class e$1$1
  implements Runnable
{
  e$1$1(e.1 param1, boolean paramBoolean) {}
  
  public final void run()
  {
    if (this.gOT) {}
    for (int i = y.j.app_brand_performance_dump_trace_success;; i = y.j.app_brand_performance_dump_trace_fail)
    {
      Toast.makeText(this.gOU.val$context, i, 0).show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.e.1.1
 * JD-Core Version:    0.7.0.1
 */