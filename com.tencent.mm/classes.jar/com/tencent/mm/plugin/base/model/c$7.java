package com.tencent.mm.plugin.base.model;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$7
  implements View.OnClickListener
{
  c$7(Context paramContext, String paramString, boolean paramBoolean) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(155985);
    c.a(this.val$context, false, this.iqK, this.val$appId, this.jLm);
    AppMethodBeat.o(155985);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.base.model.c.7
 * JD-Core Version:    0.7.0.1
 */