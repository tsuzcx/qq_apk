package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.content.Intent;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.d.a;
import com.tencent.mm.protocal.c.blq;

final class d$2
  implements d.a
{
  d$2(d paramd) {}
  
  public final void c(int paramInt, Intent paramIntent)
  {
    paramIntent = new Intent().putExtra("sendId", this.lMJ.lMG.txv);
    if (paramInt == -1) {
      paramIntent.putExtra("result_share_msg", true);
    }
    for (;;)
    {
      d locald = this.lMJ;
      locald.lMH = false;
      if (locald.lMF != null) {
        locald.lMF.b(-1, paramIntent);
      }
      return;
      paramIntent.putExtra("result_share_msg", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.d.2
 * JD-Core Version:    0.7.0.1
 */