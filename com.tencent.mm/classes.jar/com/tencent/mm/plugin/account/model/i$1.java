package com.tencent.mm.plugin.account.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.plugin.notification.b.a;
import com.tencent.mm.sdk.platformtools.am.a;

final class i$1
  implements am.a
{
  public final boolean tC()
  {
    i.uC();
    if ((i.access$000() == 1) || (i.access$000() == 16) || (i.access$000() % 96 == 0)) {
      ((a)g.t(a.class)).getNotification().wq();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.i.1
 * JD-Core Version:    0.7.0.1
 */