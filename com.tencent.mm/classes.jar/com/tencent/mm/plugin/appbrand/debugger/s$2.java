package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup;
import com.tencent.mm.plugin.appbrand.y.d;
import com.tencent.mm.sdk.platformtools.y;

final class s$2
  implements Runnable
{
  s$2(s params) {}
  
  public final void run()
  {
    if (s.b(this.fTl) == null)
    {
      y.w("MicroMsg.RemoteDebugView", "showDebugView mContentView is null");
      return;
    }
    if (s.c(this.fTl))
    {
      this.fTl.setVisibility(0);
      if (s.b(this.fTl).indexOfChild(this.fTl) == -1) {
        s.b(this.fTl).addView(this.fTl);
      }
      s.b(this.fTl).bringChildToFront(this.fTl);
      this.fTl.setBackgroundColor(this.fTl.getContext().getResources().getColor(y.d.half_alpha_black));
      return;
    }
    this.fTl.setBackgroundColor(this.fTl.getContext().getResources().getColor(y.d.transparent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.s.2
 * JD-Core Version:    0.7.0.1
 */