package com.tencent.mm.plugin.backup.g;

import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class g$1
  implements am.a
{
  g$1(g paramg, Long paramLong1, int paramInt, Long paramLong2) {}
  
  public final boolean tC()
  {
    Long localLong1 = Long.valueOf(bk.UY());
    Long localLong2 = Long.valueOf(this.hMl.t(this.hMi.longValue(), localLong1.longValue()));
    y.i("MicroMsg.BackupLogManager", "backupAfterLogTimeHandler, backupMode[%d], endAfterLogTime[%d], startAfterLogTime[%d], endAfterLogSize[%d], startAfterLogSize[%d]", new Object[] { Integer.valueOf(this.hMj), localLong1, this.hMi, localLong2, this.hMk });
    if ((localLong2.longValue() != 0L) && (localLong2.longValue() > this.hMk.longValue())) {
      this.hMl.a(this.hMj, localLong1.longValue() - this.hMi.longValue(), localLong2.longValue() - this.hMk.longValue(), true);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.g.1
 * JD-Core Version:    0.7.0.1
 */