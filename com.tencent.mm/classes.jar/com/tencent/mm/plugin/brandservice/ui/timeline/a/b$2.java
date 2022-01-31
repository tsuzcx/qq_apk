package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.r;

final class b$2
  implements View.OnClickListener
{
  b$2(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(14238);
    long l = ((com.tencent.mm.plugin.brandservice.a.a)g.E(com.tencent.mm.plugin.brandservice.a.a.class)).db(paramView);
    paramView = z.afo().C(l, "msgId");
    if (paramView != null)
    {
      this.jXF.jXV.jVS.d(paramView, 4);
      AppMethodBeat.o(14238);
      return;
    }
    ab.w("MicroMsg.BizTimeLineItem", "mediaIconClickListener info is null");
    AppMethodBeat.o(14238);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.b.2
 * JD-Core Version:    0.7.0.1
 */