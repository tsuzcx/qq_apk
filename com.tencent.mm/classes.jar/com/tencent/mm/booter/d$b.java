package com.tencent.mm.booter;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.x5.sdk.d;

public final class d$b
  implements MMReceivers.a
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramContext == null) || (paramIntent == null)) {
      return;
    }
    y.i("MicroMsg.SandBoxProcessReceiver", "onReceive");
    d.reset(paramContext);
    ai.l(new d.b.1(this), 5000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.booter.d.b
 * JD-Core Version:    0.7.0.1
 */