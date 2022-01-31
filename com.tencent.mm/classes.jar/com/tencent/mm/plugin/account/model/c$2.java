package com.tencent.mm.plugin.account.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.p;

final class c$2
  implements Runnable
{
  c$2(c paramc, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(124672);
    if (this.gAK.tipDialog != null) {
      this.gAK.tipDialog.setMessage(this.gAK.context.getString(2131296988) + this.gAL + "%");
    }
    AppMethodBeat.o(124672);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.c.2
 * JD-Core Version:    0.7.0.1
 */