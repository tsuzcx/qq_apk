package com.tencent.mm.plugin.appbrand.ac;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.sdk.platformtools.ad;

final class b$2
  implements View.OnClickListener
{
  b$2(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(49335);
    ad.i("MicroMsg.AppBrandThumbLoadingSplash", "splash click close button");
    g.bqO();
    if (b.a(this.lOW) != null)
    {
      com.tencent.mm.plugin.appbrand.g.a(b.a(this.lOW).mAppId, g.d.iDc);
      b.a(this.lOW).close();
    }
    AppMethodBeat.o(49335);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ac.b.2
 * JD-Core Version:    0.7.0.1
 */