package com.tencent.mm.plugin.base.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.an.a.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.widget.a.g.c;

final class c$11
  implements g.c
{
  c$11(a.a parama, Context paramContext, boolean paramBoolean, String paramString) {}
  
  public final void onDialogClick(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(151464);
    this.vrc.jJ(this.val$context);
    if (this.vqY) {
      h.OAn.b(15783, new Object[] { Integer.valueOf(this.tkb), Integer.valueOf(0), this.etl });
    }
    AppMethodBeat.o(151464);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.base.model.c.11
 * JD-Core Version:    0.7.0.1
 */