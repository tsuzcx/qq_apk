package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "ok", "", "hasSentVerify", "respUsername", "", "googleItemID", "canAddContact"})
final class w$c
  implements a.a
{
  w$c(w paramw) {}
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(195396);
    p.h(paramString1, "respUsername");
    p.h(paramString2, "googleItemID");
    if ((paramBoolean1) && (this.pvT.ooi != null) && (this.pvT.ooi.get() != null))
    {
      this.pvT.cmZ().setVisibility(0);
      this.pvT.cmY().setVisibility(8);
    }
    AppMethodBeat.o(195396);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.w.c
 * JD-Core Version:    0.7.0.1
 */