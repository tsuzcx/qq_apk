package com.tencent.mm.plugin.dbbackup;

import android.app.ProgressDialog;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$2$1
  implements Runnable
{
  c$2$1(c.2 param2, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(18929);
    if (this.kTs.kTo != null) {
      this.kTs.kTo.dismiss();
    }
    String str;
    if (this.fMh == 0) {
      if (this.kTs.kTr)
      {
        str = "incremental";
        str = String.format("Database (%s) backup succeeded, elapsed %.2f seconds.", new Object[] { str, Float.valueOf((float)(System.nanoTime() - this.kTs.fET) / 1.0E+009F) });
      }
    }
    for (;;)
    {
      Toast.makeText(this.kTs.val$context, str, 0).show();
      AppMethodBeat.o(18929);
      return;
      str = "new";
      break;
      if (this.fMh == 1) {
        str = "Database backup canceled.";
      } else {
        str = "Database backup failed.";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.c.2.1
 * JD-Core Version:    0.7.0.1
 */