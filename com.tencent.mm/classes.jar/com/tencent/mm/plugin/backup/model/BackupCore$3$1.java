package com.tencent.mm.plugin.backup.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.oq;
import com.tencent.mm.autogen.a.oq.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.z.b;
import com.tencent.mm.plugin.z.f;
import com.tencent.mm.sdk.platformtools.Log;

final class BackupCore$3$1
  implements Runnable
{
  BackupCore$3$1(BackupCore.3 param3, oq paramoq) {}
  
  public final void run()
  {
    AppMethodBeat.i(22144);
    Object localObject = this.vit;
    Log.i("MicroMsg.BackupCore", "receive msgSynchronizeStartEvent run userCloseMsgSync[%b]", new Object[] { Boolean.valueOf(((oq)localObject).hRr.hRu) });
    if (((oq)localObject).hRr.hRu)
    {
      h.OAn.idkeyStat(466L, 13L, 1L, false);
      AppMethodBeat.o(22144);
      return;
    }
    byte[] arrayOfByte = ((oq)localObject).hRr.hRs;
    if (arrayOfByte == null)
    {
      Log.e("MicroMsg.BackupCore", "msgsynchronize loginconfirmok key is null!");
      h.OAn.idkeyStat(466L, 14L, 1L, false);
      AppMethodBeat.o(22144);
      return;
    }
    int i = ((oq)localObject).hRr.hRt;
    f localf = f.yH(true);
    String str = b.LgZ;
    localObject = ((oq)localObject).hRr.hRv;
    localf.hRt = i;
    localf.a(str, "", arrayOfByte, (String)localObject);
    AppMethodBeat.o(22144);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.model.BackupCore.3.1
 * JD-Core Version:    0.7.0.1
 */