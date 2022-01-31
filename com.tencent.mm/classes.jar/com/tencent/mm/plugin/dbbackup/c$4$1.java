package com.tencent.mm.plugin.dbbackup;

import android.app.ProgressDialog;
import android.widget.Toast;

final class c$4$1
  implements Runnable
{
  c$4$1(c.4 param4, int paramInt) {}
  
  public final void run()
  {
    if (this.iMw.iMq != null) {
      this.iMw.iMq.dismiss();
    }
    String str;
    if (this.ewr == 0) {
      str = String.format("Database recovery succeeded, elapsed %.2f seconds.", new Object[] { Float.valueOf((float)(System.nanoTime() - this.iMw.eow) / 1.0E+009F) });
    }
    for (;;)
    {
      Toast.makeText(this.iMw.val$context, str, 0).show();
      return;
      if (this.ewr == 1) {
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