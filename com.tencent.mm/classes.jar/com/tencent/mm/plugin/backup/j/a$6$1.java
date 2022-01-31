package com.tencent.mm.plugin.backup.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.q.f;
import com.tencent.mm.sdk.platformtools.ab;

final class a$6$1
  implements Runnable
{
  a$6$1(a.6 param6, String paramString1, String paramString2, byte[] paramArrayOfByte) {}
  
  public final void run()
  {
    AppMethodBeat.i(18095);
    ab.i("MicroMsg.BackupCore.MsgSynchronize", "start MsgSynchronizeServer");
    f.jw(false).e(this.val$action, this.hyf, this.jLb);
    AppMethodBeat.o(18095);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.j.a.6.1
 * JD-Core Version:    0.7.0.1
 */