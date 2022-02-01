package com.tencent.mm.plugin.dbbackup;

import android.app.ProgressDialog;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.model.ck;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.k;

final class c$1
  implements b
{
  c$1(c paramc, ck paramck, ProgressDialog paramProgressDialog, Context paramContext) {}
  
  public final void onResult(final int paramInt)
  {
    AppMethodBeat.i(23037);
    this.xie.bDo();
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(23036);
        if (c.1.this.xif != null) {
          c.1.this.xif.dismiss();
        }
        int i;
        switch (paramInt)
        {
        case -1: 
        default: 
          i = R.l.gSX;
        }
        for (;;)
        {
          k.s(c.1.this.val$context, i, R.l.app_tip);
          AppMethodBeat.o(23036);
          return;
          i = R.l.gTb;
          continue;
          i = R.l.gTa;
          continue;
          i = R.l.gSZ;
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