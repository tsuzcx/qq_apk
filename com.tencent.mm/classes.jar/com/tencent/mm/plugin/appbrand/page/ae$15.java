package com.tencent.mm.plugin.appbrand.page;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.plugin.appbrand.widget.tabbar.e;
import com.tencent.mm.sdk.platformtools.ad;

final class ae$15
  extends e
{
  ae$15(ae paramae) {}
  
  public final void a(Bitmap paramBitmap, com.tencent.mm.plugin.appbrand.widget.tabbar.d paramd)
  {
    AppMethodBeat.i(47883);
    super.a(paramBitmap, paramd);
    this.lbG.bjH().a(paramBitmap, new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(47882);
        ad.i("MicroMsg.AppBrandPageViewWC", "CustomRightButton click");
        com.tencent.mm.plugin.appbrand.page.d.d.h(ae.15.this.lbG);
        AppMethodBeat.o(47882);
      }
    });
    AppMethodBeat.o(47883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ae.15
 * JD-Core Version:    0.7.0.1
 */