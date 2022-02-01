package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "ok", "", "hasSentVerify", "respUsername", "", "googleItemID", "canAddContact"})
final class x$c
  implements a.a
{
  x$c(x paramx) {}
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(264768);
    p.k(paramString1, "respUsername");
    p.k(paramString2, "googleItemID");
    if ((paramBoolean1) && (this.sFl.sFh != null) && (this.sFl.sFh.get() != null))
    {
      this.sFl.cAH().setVisibility(0);
      this.sFl.cAG().setVisibility(8);
    }
    AppMethodBeat.o(264768);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.x.c
 * JD-Core Version:    0.7.0.1
 */