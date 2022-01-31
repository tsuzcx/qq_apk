package com.tencent.mm.plugin.dbbackup;

import android.app.ProgressDialog;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$4$1
  implements Runnable
{
  c$4$1(c.4 param4, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(18933);
    if (this.kTu.kTo != null) {
      this.kTu.kTo.dismiss();
    }
    String str;
    if (this.fMh == 0) {
      str = String.format("Database recovery succeeded, elapsed %.2f seconds.", new Object[] { Float.valueOf((float)(System.nanoTime() - this.kTu.fET) / 1.0E+009F) });
    }
    for (;;)
    {
      Toast.makeText(this.kTu.val$context, str, 0).show();
      AppMethodBeat.o(18933);
      return;
      if (this.fMh == 1) {
        str = "Database recovery canceled.";
      } else {
        str = "Database recovery failed.";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.c.4.1
 * JD-Core Version:    0.7.0.1
 */