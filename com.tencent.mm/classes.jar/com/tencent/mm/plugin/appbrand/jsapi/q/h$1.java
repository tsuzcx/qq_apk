package com.tencent.mm.plugin.appbrand.jsapi.q;

import android.app.Activity;
import com.tencent.mm.plugin.appbrand.jsapi.c;

final class h$1
  implements Runnable
{
  h$1(h paramh, c paramc, int paramInt) {}
  
  public final void run()
  {
    if (this.ggE == null) {}
    Activity localActivity;
    do
    {
      return;
      localActivity = (Activity)this.ggE.getContext();
    } while (localActivity == null);
    localActivity.setRequestedOrientation(1);
    switch (this.gCi)
    {
    default: 
      localActivity.setRequestedOrientation(9);
      return;
    case 90: 
      localActivity.setRequestedOrientation(0);
      return;
    case -90: 
      localActivity.setRequestedOrientation(8);
      return;
    }
    localActivity.setRequestedOrientation(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q.h.1
 * JD-Core Version:    0.7.0.1
 */