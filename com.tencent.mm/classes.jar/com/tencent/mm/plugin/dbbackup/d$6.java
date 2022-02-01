package com.tencent.mm.plugin.dbbackup;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

final class d$6
  implements Runnable
{
  d$6(d paramd, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(23084);
    Object localObject = this.qEn + "corrupted/EnMicroMsg.db";
    if (s.YS((String)localObject + ".corrupt"))
    {
      AppMethodBeat.o(23084);
      return;
    }
    long l = System.currentTimeMillis();
    localObject = new o(this.qEn + "corrupted");
    if (!((o)localObject).isDirectory())
    {
      AppMethodBeat.o(23084);
      return;
    }
    o[] arrayOfo = ((o)localObject).het();
    int j = arrayOfo.length;
    int i = 0;
    while (i < j)
    {
      if (l - arrayOfo[i].lastModified() < 7776000000L)
      {
        AppMethodBeat.o(23084);
        return;
      }
      i += 1;
    }
    if (s.dy(aa.z(((o)localObject).mUri), true)) {
      Log.i("MicroMsg.SubCoreDBBackup", "Corrupted databases removed.");
    }
    AppMethodBeat.o(23084);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.d.6
 * JD-Core Version:    0.7.0.1
 */