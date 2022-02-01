package com.tencent.mm.plugin.dbbackup;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;

final class d$6
  implements Runnable
{
  d$6(d paramd, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(23084);
    Object localObject = this.oEB + "corrupted/EnMicroMsg.db";
    if (i.eA((String)localObject + ".corrupt"))
    {
      AppMethodBeat.o(23084);
      return;
    }
    long l = System.currentTimeMillis();
    localObject = new e(this.oEB + "corrupted");
    if (!((e)localObject).isDirectory())
    {
      AppMethodBeat.o(23084);
      return;
    }
    e[] arrayOfe = ((e)localObject).fxX();
    int j = arrayOfe.length;
    int i = 0;
    while (i < j)
    {
      if (l - arrayOfe[i].lastModified() < 7776000000L)
      {
        AppMethodBeat.o(23084);
        return;
      }
      i += 1;
    }
    if (i.cU(q.B(((e)localObject).mUri), true)) {
      ac.i("MicroMsg.SubCoreDBBackup", "Corrupted databases removed.");
    }
    AppMethodBeat.o(23084);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.d.6
 * JD-Core Version:    0.7.0.1
 */