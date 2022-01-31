package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;

final class g$1
  implements ap.a
{
  g$1(g paramg, Long paramLong1, int paramInt, Long paramLong2) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(17666);
    Long localLong1 = Long.valueOf(bo.aoy());
    Long localLong2 = Long.valueOf(this.jFN.D(this.jFK.longValue(), localLong1.longValue()));
    ab.i("MicroMsg.BackupLogManager", "backupAfterLogTimeHandler, backupMode[%d], endAfterLogTime[%d], startAfterLogTime[%d], endAfterLogSize[%d], startAfterLogSize[%d]", new Object[] { Integer.valueOf(this.jFL), localLong1, this.jFK, localLong2, this.jFM });
    if ((localLong2.longValue() != 0L) && (localLong2.longValue() > this.jFM.longValue())) {
      this.jFN.a(this.jFL, localLong1.longValue() - this.jFK.longValue(), localLong2.longValue() - this.jFM.longValue(), true);
    }
    AppMethodBeat.o(17666);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.g.g.1
 * JD-Core Version:    0.7.0.1
 */