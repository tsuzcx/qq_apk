package com.tencent.mm.plugin.dbbackup;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;

final class d$6
  implements Runnable
{
  d$6(d paramd, String paramString) {}
  
  public final void run()
  {
    Object localObject = this.iNy + "corrupted/EnMicroMsg.db";
    if (e.bK((String)localObject + ".corrupt")) {}
    label135:
    do
    {
      long l;
      do
      {
        return;
        l = System.currentTimeMillis();
        localObject = new b(this.iNy + "corrupted");
      } while (!((b)localObject).isDirectory());
      b[] arrayOfb = ((b)localObject).cLt();
      int j = arrayOfb.length;
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label135;
        }
        if (l - arrayOfb[i].lastModified() < 7776000000L) {
          break;
        }
        i += 1;
      }
    } while (!e.K(j.n(((b)localObject).mUri), true));
    y.i("MicroMsg.SubCoreDBBackup", "Corrupted databases removed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.d.6
 * JD-Core Version:    0.7.0.1
 */