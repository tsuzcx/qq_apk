package com.tencent.mm.plugin.dbbackup;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;

final class c$3
  implements b
{
  c$3(c paramc, ProgressDialog paramProgressDialog, long paramLong, Context paramContext) {}
  
  public final void AF(final int paramInt)
  {
    AppMethodBeat.i(23041);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(23040);
        if (c.3.this.oDo != null) {
          c.3.this.oDo.dismiss();
        }
        String str;
        if (paramInt == 0) {
          str = String.format("Database recovery succeeded, elapsed %.2f seconds.", new Object[] { Float.valueOf((float)(System.nanoTime() - c.3.this.hHV) / 1.0E+009F) });
        }
        for (;;)
        {
          Toast.makeText(c.3.this.val$context, str, 0).show();
          AppMethodBeat.o(23040);
          return;
          if (paramInt == 1) {
            str = "Database recovery canceled.";
          } else {
            str = "Database recovery failed.";
          }
        }
      }
    });
    AppMethodBeat.o(23041);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.c.3
 * JD-Core Version:    0.7.0.1
 */