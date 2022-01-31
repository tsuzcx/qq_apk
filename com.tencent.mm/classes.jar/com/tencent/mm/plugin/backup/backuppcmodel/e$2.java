package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.c.c;
import com.tencent.mm.plugin.backup.g.i;
import com.tencent.mm.plugin.backup.i.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

final class e$2
  implements f
{
  e$2(e parame) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(17544);
    com.tencent.mm.plugin.backup.g.b.b(11, this.jEz.jEx);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ab.e("MicroMsg.BackupPcServer", "requestSessionSceneEnd sessionName or timeInterval null or request session resp number error, errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      h.qsU.idkeyStat(400L, 119L, 1L, false);
      this.jEz.cancel(false);
      b.aTX().aSL().jyN = -5;
      this.jEz.rl(-5);
      AppMethodBeat.o(17544);
      return;
    }
    paramString = (i)paramm;
    paramString = g.b(paramString.jFU.jJw, paramString.jFU.jJx);
    ab.i("MicroMsg.BackupPcServer", "requestSessionSceneEnd receive requestsessionResp, backupSessionList size[%d]", new Object[] { Integer.valueOf(paramString.size()) });
    paramm = e.b(this.jEz);
    b.aTX().aTY();
    paramm.a(paramString, b.aTX().aSL().jyV, e.access$100());
    AppMethodBeat.o(17544);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.e.2
 * JD-Core Version:    0.7.0.1
 */