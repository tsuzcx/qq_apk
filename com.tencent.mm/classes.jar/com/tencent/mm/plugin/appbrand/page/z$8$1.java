package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.c.d;
import com.tencent.mm.sdk.platformtools.ab;

final class z$8$1
  implements View.OnClickListener
{
  z$8$1(z.8 param8) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(143502);
    ab.i("MicroMsg.AppBrandPageViewWC", "CustomRightButton click");
    d.d(this.ixI.ixG);
    AppMethodBeat.o(143502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.z.8.1
 * JD-Core Version:    0.7.0.1
 */