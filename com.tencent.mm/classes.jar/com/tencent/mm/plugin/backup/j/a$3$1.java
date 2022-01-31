package com.tencent.mm.plugin.backup.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ke;
import com.tencent.mm.g.a.ke.a;
import com.tencent.mm.plugin.q.b;
import com.tencent.mm.plugin.q.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

final class a$3$1
  implements Runnable
{
  a$3$1(a.3 param3, ke paramke) {}
  
  public final void run()
  {
    AppMethodBeat.i(18089);
    Object localObject = this.jKZ;
    ab.i("MicroMsg.BackupCore", "receive msgSynchronizeStartEvent run userCloseMsgSync[%b]", new Object[] { Boolean.valueOf(((ke)localObject).czM.czP) });
    if (((ke)localObject).czM.czP)
    {
      h.qsU.idkeyStat(466L, 13L, 1L, false);
      AppMethodBeat.o(18089);
      return;
    }
    byte[] arrayOfByte = ((ke)localObject).czM.czN;
    if (arrayOfByte == null)
    {
      ab.e("MicroMsg.BackupCore", "msgsynchronize loginconfirmok key is null!");
      h.qsU.idkeyStat(466L, 14L, 1L, false);
      AppMethodBeat.o(18089);
      return;
    }
    int i = ((ke)localObject).czM.czO;
    localObject = f.jw(true);
    String str = b.oSm;
    ((f)localObject).czO = i;
    ((f)localObject).e(str, "", arrayOfByte);
    AppMethodBeat.o(18089);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.j.a.3.1
 * JD-Core Version:    0.7.0.1
 */