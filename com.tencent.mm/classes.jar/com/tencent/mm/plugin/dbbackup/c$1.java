package com.tencent.mm.plugin.dbbackup;

import android.app.ProgressDialog;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.model.cj;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.h;

final class c$1
  implements b
{
  c$1(c paramc, cj paramcj, ProgressDialog paramProgressDialog, Context paramContext) {}
  
  public final void onResult(final int paramInt)
  {
    AppMethodBeat.i(23037);
    this.uca.bfw();
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(23036);
        if (c.1.this.ucb != null) {
          c.1.this.ucb.dismiss();
        }
        int i;
        switch (paramInt)
        {
        case -1: 
        default: 
          i = R.l.eQs;
        }
        for (;;)
        {
          h.p(c.1.this.val$context, i, R.l.app_tip);
          AppMethodBeat.o(23036);
          return;
          i = R.l.eQw;
          continue;
          i = R.l.eQv;
          continue;
          i = R.l.eQu;
        }
      }
    });
    AppMethodBeat.o(23037);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.c.1
 * JD-Core Version:    0.7.0.1
 */