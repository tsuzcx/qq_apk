package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.sdk.platformtools.ai;

final class i$3
  implements Runnable
{
  i$3(xv paramxv, Context paramContext, String paramString, Runnable paramRunnable) {}
  
  public final void run()
  {
    if (this.kdj.aYU == 15) {
      i.a(this.val$context, this.bxX, this.kdj);
    }
    for (;;)
    {
      ai.d(this.bxs);
      return;
      i.b(this.val$context, this.bxX, this.kdj);
    }
  }
  
  public final String toString()
  {
    return super.toString() + "|sendFavVideo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.i.3
 * JD-Core Version:    0.7.0.1
 */