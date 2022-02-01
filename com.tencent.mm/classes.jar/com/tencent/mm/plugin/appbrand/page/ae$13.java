package com.tencent.mm.plugin.appbrand.page;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.appbrand.widget.tabbar.e;
import com.tencent.mm.sdk.platformtools.ad;

final class ae$13
  extends e
{
  ae$13(ae paramae) {}
  
  public final void a(Bitmap paramBitmap, com.tencent.mm.plugin.appbrand.widget.tabbar.d paramd)
  {
    AppMethodBeat.i(47883);
    super.a(paramBitmap, paramd);
    this.mcH.bux().a(paramBitmap, new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(47882);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$9$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.i("MicroMsg.AppBrandPageViewWC", "CustomRightButton click");
        com.tencent.mm.plugin.appbrand.page.d.d.h(ae.13.this.mcH);
        a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$9$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(47882);
      }
    });
    AppMethodBeat.o(47883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ae.13
 * JD-Core Version:    0.7.0.1
 */