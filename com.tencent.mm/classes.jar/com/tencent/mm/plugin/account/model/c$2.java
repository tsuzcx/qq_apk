package com.tencent.mm.plugin.account.model;

import android.content.Context;
import com.tencent.mm.plugin.account.ui.q.j;
import com.tencent.mm.ui.base.p;

final class c$2
  implements Runnable
{
  c$2(c paramc, int paramInt) {}
  
  public final void run()
  {
    if (this.fjs.tipDialog != null) {
      this.fjs.tipDialog.setMessage(this.fjs.context.getString(q.j.app_loading_data) + this.fjt + "%");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.c.2
 * JD-Core Version:    0.7.0.1
 */