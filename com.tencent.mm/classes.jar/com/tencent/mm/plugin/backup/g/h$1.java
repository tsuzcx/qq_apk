package com.tencent.mm.plugin.backup.g;

import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class h$1
  implements am.a
{
  h$1(h paramh) {}
  
  public final boolean tC()
  {
    if (h.a(this.hMq))
    {
      y.e("MicroMsg.BackupReconnectHandler", "backupReconnectTimeHandler stopped is true, index[%d]", new Object[] { Integer.valueOf(h.access$100()) });
      this.hMq.hMn = 0;
      return false;
    }
    y.i("MicroMsg.BackupReconnectHandler", "backupReconnectTimeHandler start reconnect, index[%d]", new Object[] { Integer.valueOf(h.access$100()) });
    if (h.access$100() < h.b(this.hMq).length)
    {
      h.c(this.hMq).auD();
      am localam = h.d(this.hMq);
      long l = h.b(this.hMq)[h.access$100()];
      localam.S(l, l);
      h.Kf();
      return false;
    }
    h.e(this.hMq);
    this.hMq.hMn = 0;
    h.c(this.hMq).auE();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.h.1
 * JD-Core Version:    0.7.0.1
 */