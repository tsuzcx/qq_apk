package com.tencent.mm.plugin.appbrand.ui.recents;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.compat.a.a;
import com.tencent.mm.sdk.platformtools.ab;

final class j$2
  implements View.OnClickListener
{
  j$2(j paramj, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(133471);
    ab.i("MicroMsg.AppBrandListRecentsListWAGameHeader", "Invoke H5 click listener, invoke h5");
    ((a)g.E(a.class)).U(this.iUR.gQx, this.iUS);
    AppMethodBeat.o(133471);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.j.2
 * JD-Core Version:    0.7.0.1
 */