package com.tencent.mm.plugin.appbrand;

import android.os.Looper;
import com.tencent.mm.cl.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;

final class u$2
  implements Runnable
{
  u$2(Runnable paramRunnable) {}
  
  public final void run()
  {
    ai.Fd(-2);
    if (WebView.hasInited())
    {
      this.fAr.run();
      return;
    }
    ah localah = new ah(Looper.myLooper());
    b.a(MMWebView.wkp, new u.2.1(this, localah));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.2
 * JD-Core Version:    0.7.0.1
 */