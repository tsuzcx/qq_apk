package com.tencent.mm.plugin.appbrand.debugger;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.appbrand.y.g;

final class s$3
  implements View.OnClickListener
{
  s$3(s params) {}
  
  public final void onClick(View paramView)
  {
    s locals = this.fTl;
    if (paramView.getId() == y.g.app_brand_remote_debug_expand_tv)
    {
      locals.fTi = true;
      locals.show();
      paramView = locals.fSW;
      paramView.postDelayed(new RemoteDebugMoveView.2(paramView), 50L);
    }
    do
    {
      return;
      if (paramView.getId() == y.g.app_brand_remote_debug_collapse_tv)
      {
        locals.fTi = false;
        locals.show();
        return;
      }
    } while (paramView.getId() != y.g.app_brand_remote_debug_quit_tv);
    locals.aeQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.s.3
 * JD-Core Version:    0.7.0.1
 */