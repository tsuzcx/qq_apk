package com.tencent.mm.plugin.base.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.snackbar.a.b;

final class c$4
  implements a.b
{
  c$4(Context paramContext, int paramInt, String paramString, boolean paramBoolean) {}
  
  public final void onMessageClick()
  {
    AppMethodBeat.i(151457);
    c.a(this.val$context, true, this.tkb, this.etl, this.vqY);
    AppMethodBeat.o(151457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.base.model.c.4
 * JD-Core Version:    0.7.0.1
 */