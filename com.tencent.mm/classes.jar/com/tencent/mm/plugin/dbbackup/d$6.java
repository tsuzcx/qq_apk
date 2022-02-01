package com.tencent.mm.plugin.dbbackup;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;

final class d$6
  implements Runnable
{
  d$6(d paramd, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(23084);
    Object localObject = this.poI + "corrupted/EnMicroMsg.db";
    if (o.fB((String)localObject + ".corrupt"))
    {
      AppMethodBeat.o(23084);
      return;
    }
    long l = System.currentTimeMillis();
    localObject = new k(this.poI + "corrupted");
    if (!((k)localObject).isDirectory())
    {
      AppMethodBeat.o(23084);
      return;
    }
    k[] arrayOfk = ((k)localObject).fTj();
    int j = arrayOfk.length;
    int i = 0;
    while (i < j)
    {
      if (l - arrayOfk[i].lastModified() < 7776000000L)
      {
        AppMethodBeat.o(23084);
        return;
      }
      i += 1;
    }
    if (o.dd(w.B(((k)localObject).mUri), true)) {
      ae.i("MicroMsg.SubCoreDBBackup", "Corrupted databases removed.");
    }
    AppMethodBeat.o(23084);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.d.6
 * JD-Core Version:    0.7.0.1
 */