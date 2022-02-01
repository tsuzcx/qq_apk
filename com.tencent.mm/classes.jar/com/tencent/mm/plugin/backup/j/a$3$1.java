package com.tencent.mm.plugin.backup.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lj;
import com.tencent.mm.g.a.lj.a;
import com.tencent.mm.plugin.r.b;
import com.tencent.mm.plugin.r.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;

final class a$3$1
  implements Runnable
{
  a$3$1(a.3 param3, lj paramlj) {}
  
  public final void run()
  {
    AppMethodBeat.i(22144);
    Object localObject = this.mCp;
    ad.i("MicroMsg.BackupCore", "receive msgSynchronizeStartEvent run userCloseMsgSync[%b]", new Object[] { Boolean.valueOf(((lj)localObject).dpV.dpY) });
    if (((lj)localObject).dpV.dpY)
    {
      h.vKh.idkeyStat(466L, 13L, 1L, false);
      AppMethodBeat.o(22144);
      return;
    }
    byte[] arrayOfByte = ((lj)localObject).dpV.dpW;
    if (arrayOfByte == null)
    {
      ad.e("MicroMsg.BackupCore", "msgsynchronize loginconfirmok key is null!");
      h.vKh.idkeyStat(466L, 14L, 1L, false);
      AppMethodBeat.o(22144);
      return;
    }
    int i = ((lj)localObject).dpV.dpX;
    localObject = f.nq(true);
    String str = b.tNw;
    ((f)localObject).dpX = i;
    ((f)localObject).d(str, "", arrayOfByte);
    AppMethodBeat.o(22144);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.j.a.3.1
 * JD-Core Version:    0.7.0.1
 */