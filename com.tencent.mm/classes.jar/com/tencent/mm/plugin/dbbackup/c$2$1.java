package com.tencent.mm.plugin.dbbackup;

import android.app.ProgressDialog;
import android.widget.Toast;

final class c$2$1
  implements Runnable
{
  c$2$1(c.2 param2, int paramInt) {}
  
  public final void run()
  {
    if (this.iMu.iMq != null) {
      this.iMu.iMq.dismiss();
    }
    String str;
    if (this.ewr == 0) {
      if (this.iMu.iMt)
      {
        str = "incremental";
        str = String.format("Database (%s) backup succeeded, elapsed %.2f seconds.", new Object[] { str, Float.valueOf((float)(System.nanoTime() - this.iMu.eow) / 1.0E+009F) });
      }
    }
    for (;;)
    {
      Toast.makeText(this.iMu.val$context, str, 0).show();
      return;
      str = "new";
      break;
      if (this.ewr == 1) {
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