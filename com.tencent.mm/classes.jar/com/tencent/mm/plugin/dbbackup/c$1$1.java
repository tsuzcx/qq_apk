package com.tencent.mm.plugin.dbbackup;

import android.app.ProgressDialog;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.h;

final class c$1$1
  implements Runnable
{
  c$1$1(c.1 param1, int paramInt) {}
  
  public final void run()
  {
    if (this.iMs.iMq != null) {
      this.iMs.iMq.dismiss();
    }
    int i;
    switch (this.ewr)
    {
    case -1: 
    default: 
      i = R.l.recover_db_fail;
    }
    for (;;)
    {
      h.h(this.iMs.val$context, i, R.l.app_tip);
      return;
      i = R.l.recover_db_success;
      continue;
      i = R.l.recover_db_no_enough_space;
      continue;
      i = R.l.recover_db_no_datafile;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.c.1.1
 * JD-Core Version:    0.7.0.1
 */