package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import d.l;
import java.lang.ref.WeakReference;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "ok", "", "hasSentVerify", "respUsername", "", "googleItemID", "canAddContact"})
final class p$c
  implements a.a
{
  p$c(p paramp) {}
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(209770);
    d.g.b.p.h(paramString1, "respUsername");
    d.g.b.p.h(paramString2, "googleItemID");
    if ((paramBoolean1) && (this.oeh.mXV != null) && (this.oeh.mXV.get() != null))
    {
      this.oeh.bOI().setVisibility(0);
      this.oeh.bOH().setVisibility(8);
    }
    AppMethodBeat.o(209770);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.p.c
 * JD-Core Version:    0.7.0.1
 */