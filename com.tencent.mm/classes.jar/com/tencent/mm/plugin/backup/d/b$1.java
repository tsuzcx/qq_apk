package com.tencent.mm.plugin.backup.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.backup.g.e;
import com.tencent.mm.sdk.platformtools.ab;

final class b$1
  implements Runnable
{
  b$1(b paramb, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(17235);
    Object localObject = b.aTr().aTu();
    String str = this.val$url;
    ab.w("MicroMsg.BackupMoveRecoverServer", "~~~~~~~~~~~~  start by url:%s", new Object[] { str });
    com.tencent.mm.plugin.backup.g.b.aUs();
    aw.Rc().a(595, ((c)localObject).jBE);
    localObject = new e(str);
    aw.Rc().a((m)localObject, 0);
    AppMethodBeat.o(17235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.b.1
 * JD-Core Version:    0.7.0.1
 */