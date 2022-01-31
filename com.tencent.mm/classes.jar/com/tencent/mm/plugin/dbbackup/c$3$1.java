package com.tencent.mm.plugin.dbbackup;

import android.app.ProgressDialog;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$3$1
  implements Runnable
{
  c$3$1(c.3 param3, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(18931);
    if (this.kTt.kTo != null) {
      this.kTt.kTo.dismiss();
    }
    String str;
    if (this.fMh == 0) {
      str = String.format("Database recovery succeeded, elapsed %.2f seconds.", new Object[] { Float.valueOf((float)(System.nanoTime() - this.kTt.fET) / 1.0E+009F) });
    }
    for (;;)
    {
      Toast.makeText(this.kTt.val$context, str, 0).show();
      AppMethodBeat.o(18931);
      return;
      if (this.fMh == 1) {
        str = "Database recovery canceled.";
      } else {
        str = "Database recovery failed.";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.c.3.1
 * JD-Core Version:    0.7.0.1
 */