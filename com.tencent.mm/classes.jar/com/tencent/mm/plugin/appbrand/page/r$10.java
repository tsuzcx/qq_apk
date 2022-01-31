package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.sdk.platformtools.ab;

final class r$10
  implements Runnable
{
  r$10(r paramr) {}
  
  public final void run()
  {
    AppMethodBeat.i(141666);
    if ((this.iwq.getRuntime() == null) || (!this.iwq.getRuntime().mInitialized) || (this.iwq.getRuntime().mFinished))
    {
      AppMethodBeat.o(141666);
      return;
    }
    if (r.d(this.iwq) != null)
    {
      AppMethodBeat.o(141666);
      return;
    }
    long l = System.currentTimeMillis();
    Object localObject2 = r.e(this.iwq);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new v();
    }
    ((v)localObject1).iwn = this.iwq.getDecorWidgetFactory();
    ((v)localObject1).a(this.iwq.getContext(), r.b(this.iwq));
    localObject2 = ((c)localObject1).getContentView();
    if (localObject2 != null) {
      ((View)localObject2).setVisibility(4);
    }
    this.iwq.addView(((v)localObject1).hmw, 0);
    r.a(this.iwq, (v)localObject1);
    ab.i("MicroMsg.AppBrandPageContainer", "preloadNextPageView: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(141666);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.r.10
 * JD-Core Version:    0.7.0.1
 */