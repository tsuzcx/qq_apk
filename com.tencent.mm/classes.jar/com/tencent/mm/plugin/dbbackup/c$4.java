package com.tencent.mm.plugin.dbbackup;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;

final class c$4
  implements b
{
  c$4(c paramc, ProgressDialog paramProgressDialog, long paramLong, Context paramContext) {}
  
  public final void AF(final int paramInt)
  {
    AppMethodBeat.i(23043);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(23042);
        if (c.4.this.oDo != null) {
          c.4.this.oDo.dismiss();
        }
        String str;
        if (paramInt == 0) {
          str = String.format("Database recovery succeeded, elapsed %.2f seconds.", new Object[] { Float.valueOf((float)(System.nanoTime() - c.4.this.hHV) / 1.0E+009F) });
        }
        for (;;)
        {
          Toast.makeText(c.4.this.val$context, str, 0).show();
          AppMethodBeat.o(23042);
          return;
          if (paramInt == 1) {
            str = "Database recovery canceled.";
          } else {
            str = "Database recovery failed.";
          }
        }
      }
    });
    AppMethodBeat.o(23043);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.c.4
 * JD-Core Version:    0.7.0.1
 */