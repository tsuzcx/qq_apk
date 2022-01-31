package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.y.f;
import com.tencent.mm.plugin.appbrand.y.j;

final class s$5
  implements Runnable
{
  s$5(s params) {}
  
  public final void run()
  {
    if (s.e(this.fTl).aeC())
    {
      s.f(this.fTl).setImageResource(y.f.app_brand_remote_debug_normal_dot);
      s.g(this.fTl).setText(this.fTl.getContext().getString(y.j.app_brand_remote_debug_connect_hit_break_point));
    }
    for (;;)
    {
      s.h(this.fTl);
      return;
      if (s.e(this.fTl).isReady())
      {
        s.f(this.fTl).setImageResource(y.f.app_brand_remote_debug_normal_dot);
        s.g(this.fTl).setText(this.fTl.getContext().getString(y.j.app_brand_remote_debug_connect_normal));
      }
      else
      {
        s.f(this.fTl).setImageResource(y.f.app_brand_remote_debug_abnormal_dot);
        s.g(this.fTl).setText(this.fTl.getContext().getString(y.j.app_brand_remote_debug_connect_abnormal));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.s.5
 * JD-Core Version:    0.7.0.1
 */