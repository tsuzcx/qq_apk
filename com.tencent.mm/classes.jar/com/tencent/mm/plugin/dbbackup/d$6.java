package com.tencent.mm.plugin.dbbackup;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;

final class d$6
  implements Runnable
{
  d$6(d paramd, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(18975);
    Object localObject = this.kUy + "corrupted/EnMicroMsg.db";
    if (e.cN((String)localObject + ".corrupt"))
    {
      AppMethodBeat.o(18975);
      return;
    }
    long l = System.currentTimeMillis();
    localObject = new b(this.kUy + "corrupted");
    if (!((b)localObject).isDirectory())
    {
      AppMethodBeat.o(18975);
      return;
    }
    b[] arrayOfb = ((b)localObject).dQL();
    int j = arrayOfb.length;
    int i = 0;
    while (i < j)
    {
      if (l - arrayOfb[i].lastModified() < 7776000000L)
      {
        AppMethodBeat.o(18975);
        return;
      }
      i += 1;
    }
    if (e.O(j.p(((b)localObject).mUri), true)) {
      ab.i("MicroMsg.SubCoreDBBackup", "Corrupted databases removed.");
    }
    AppMethodBeat.o(18975);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.d.6
 * JD-Core Version:    0.7.0.1
 */