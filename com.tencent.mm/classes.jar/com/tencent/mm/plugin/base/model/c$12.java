package com.tencent.mm.plugin.base.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.w.a.a.a;
import com.tencent.mm.ui.widget.b.e.c;

final class c$12
  implements e.c
{
  c$12(a.a parama, Context paramContext, boolean paramBoolean, String paramString) {}
  
  public final void d(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(155990);
    this.jLt.eR(this.val$context);
    if (this.jLm) {
      h.qsU.e(15783, new Object[] { Integer.valueOf(this.iqK), Integer.valueOf(0), this.val$appId });
    }
    AppMethodBeat.o(155990);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.base.model.c.12
 * JD-Core Version:    0.7.0.1
 */