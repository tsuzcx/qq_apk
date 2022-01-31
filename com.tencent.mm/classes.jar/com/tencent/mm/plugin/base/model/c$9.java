package com.tencent.mm.plugin.base.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.e.a;
import com.tencent.mm.ui.widget.b.e.b;

final class c$9
  implements e.b
{
  c$9(Context paramContext, String paramString, boolean paramBoolean, e.a parama, c.a parama1) {}
  
  public final void u(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(155987);
    if (paramBoolean1) {
      c.a(this.val$context, false, this.iqK, this.val$appId, this.jLm);
    }
    for (;;)
    {
      this.jLu.d(paramBoolean2, this.val$appId, this.iqK);
      AppMethodBeat.o(155987);
      return;
      c.a(this.jLl, this.iqK, this.val$appId, this.jLm);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.base.model.c.9
 * JD-Core Version:    0.7.0.1
 */