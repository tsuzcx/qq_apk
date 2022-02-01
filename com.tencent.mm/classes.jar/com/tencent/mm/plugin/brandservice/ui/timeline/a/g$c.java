package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import d.g.b.k;
import d.l;
import java.lang.ref.WeakReference;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "ok", "", "hasSentVerify", "respUsername", "", "googleItemID", "canAddContact"})
final class g$c
  implements a.a
{
  g$c(g paramg) {}
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(193062);
    k.h(paramString1, "respUsername");
    k.h(paramString2, "googleItemID");
    if ((paramBoolean1) && (this.mZu.lVp != null) && (this.mZu.lVp.get() != null))
    {
      this.mZu.bCY().setVisibility(0);
      this.mZu.bCX().setVisibility(8);
    }
    AppMethodBeat.o(193062);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.g.c
 * JD-Core Version:    0.7.0.1
 */