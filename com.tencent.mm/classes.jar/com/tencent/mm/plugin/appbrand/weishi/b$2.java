package com.tencent.mm.plugin.appbrand.weishi;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.d;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.sdk.platformtools.ab;

final class b$2
  implements View.OnClickListener
{
  b$2(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(133624);
    ab.i("MicroMsg.AppBrandThumbLoadingSplash", "thumb click close button");
    g.aOu();
    if (b.a(this.jaf) != null)
    {
      e.a(b.a(this.jaf).mAppId, e.d.gPe);
      b.a(this.jaf).close();
    }
    AppMethodBeat.o(133624);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.weishi.b.2
 * JD-Core Version:    0.7.0.1
 */