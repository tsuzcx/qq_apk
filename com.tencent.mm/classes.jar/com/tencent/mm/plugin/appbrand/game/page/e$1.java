package com.tencent.mm.plugin.appbrand.game.page;

import com.tencent.mm.plugin.appbrand.page.al;
import com.tencent.mm.plugin.appbrand.report.model.b;
import com.tencent.mm.sdk.platformtools.y;

final class e$1
  implements Runnable
{
  e$1(e parame, String paramString) {}
  
  public final void run()
  {
    e.a(this.gcv, new d(this.gcv.getContext(), this.gcv));
    this.gcv.addView(e.a(this.gcv), 0);
    e.a(this.gcv).getCurrentPageView().a(new e.1.1(this));
    e.a(this.gcv).loadUrl(this.val$url);
    e.a(this.gcv).a(al.gVL);
    e.a(this.gcv).agH();
    e.a(this.gcv).amV();
    try
    {
      this.gcv.getReporter().a(this.gcv.getCurrentPageView(), null, al.gVL);
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.WAGamePageContainer", "report APP_LAUNCH, e = %s", new Object[] { localException });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.page.e.1
 * JD-Core Version:    0.7.0.1
 */