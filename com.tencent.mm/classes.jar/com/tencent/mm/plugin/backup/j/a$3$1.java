package com.tencent.mm.plugin.backup.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ls;
import com.tencent.mm.g.a.ls.a;
import com.tencent.mm.plugin.r.b;
import com.tencent.mm.plugin.r.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;

final class a$3$1
  implements Runnable
{
  a$3$1(a.3 param3, ls paramls) {}
  
  public final void run()
  {
    AppMethodBeat.i(22144);
    Object localObject = this.neq;
    ac.i("MicroMsg.BackupCore", "receive msgSynchronizeStartEvent run userCloseMsgSync[%b]", new Object[] { Boolean.valueOf(((ls)localObject).dnG.dnJ) });
    if (((ls)localObject).dnG.dnJ)
    {
      h.wUl.idkeyStat(466L, 13L, 1L, false);
      AppMethodBeat.o(22144);
      return;
    }
    byte[] arrayOfByte = ((ls)localObject).dnG.dnH;
    if (arrayOfByte == null)
    {
      ac.e("MicroMsg.BackupCore", "msgsynchronize loginconfirmok key is null!");
      h.wUl.idkeyStat(466L, 14L, 1L, false);
      AppMethodBeat.o(22144);
      return;
    }
    int i = ((ls)localObject).dnG.dnI;
    localObject = f.ok(true);
    String str = b.uVZ;
    ((f)localObject).dnI = i;
    ((f)localObject).d(str, "", arrayOfByte);
    AppMethodBeat.o(22144);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.j.a.3.1
 * JD-Core Version:    0.7.0.1
 */