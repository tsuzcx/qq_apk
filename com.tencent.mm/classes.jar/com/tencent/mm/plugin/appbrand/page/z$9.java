package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.d;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.weishi.g;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.plugin.appbrand.widget.actionbar.d;
import com.tencent.mm.sdk.platformtools.ab;

final class z$9
  implements Runnable
{
  z$9(z paramz) {}
  
  public final void run()
  {
    AppMethodBeat.i(132397);
    if (this.ixG.ixl != null)
    {
      ab.i("MicroMsg.AppBrandPageViewWC", "weishi customActionBar");
      this.ixG.ixl.setNavResetStyleListener(new z.9.1(this));
      this.ixG.ixl.setFullscreenMode(true);
      this.ixG.ixl.setForegroundStyle(false);
      this.ixG.ixl.fb(false);
      this.ixG.ixl.aOM();
      this.ixG.ixl.setBackButtonClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(143505);
          ab.i("MicroMsg.AppBrandPageViewWC", "pageview click close button");
          g.aOu();
          if (z.e(z.9.this.ixG) != null)
          {
            e.a(z.9.this.ixG.getAppId(), e.d.gPe);
            z.e(z.9.this.ixG).close();
          }
          AppMethodBeat.o(143505);
        }
      });
    }
    if (this.ixG.ixk != null) {
      this.ixG.ixk.setForceTopInsetsHeight(this.ixG.getContext().getResources().getDimensionPixelSize(2131428104));
    }
    AppMethodBeat.o(132397);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.z.9
 * JD-Core Version:    0.7.0.1
 */