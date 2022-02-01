package com.tencent.mm.plugin.dbbackup;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;

final class d$6
  implements Runnable
{
  d$6(d paramd, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(23084);
    Object localObject = this.xjr + "corrupted/EnMicroMsg.db";
    if (y.ZC((String)localObject + ".corrupt"))
    {
      AppMethodBeat.o(23084);
      return;
    }
    long l = System.currentTimeMillis();
    localObject = new u(this.xjr + "corrupted");
    if (!((u)localObject).isDirectory())
    {
      AppMethodBeat.o(23084);
      return;
    }
    u[] arrayOfu = ((u)localObject).jKX();
    int j = arrayOfu.length;
    int i = 0;
    while (i < j)
    {
      if (l - arrayOfu[i].lastModified() < 7776000000L)
      {
        AppMethodBeat.o(23084);
        return;
      }
      i += 1;
    }
    if (y.ew(ah.v(((u)localObject).mUri), true)) {
      Log.i("MicroMsg.SubCoreDBBackup", "Corrupted databases removed.");
    }
    AppMethodBeat.o(23084);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.d.6
 * JD-Core Version:    0.7.0.1
 */