package com.tencent.mm.plugin.dbbackup;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;

final class c$1$1
  implements Runnable
{
  c$1$1(c.1 param1, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(18927);
    if (this.kTq.kTo != null) {
      this.kTq.kTo.dismiss();
    }
    int i;
    switch (this.fMh)
    {
    case -1: 
    default: 
      i = 2131302367;
    }
    for (;;)
    {
      h.h(this.kTq.val$context, i, 2131297087);
      AppMethodBeat.o(18927);
      return;
      i = 2131302371;
      continue;
      i = 2131302370;
      continue;
      i = 2131302369;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.c.1.1
 * JD-Core Version:    0.7.0.1
 */