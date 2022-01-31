package com.tencent.mm.plugin.backup.d;

import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.backup.g.e;
import com.tencent.mm.sdk.platformtools.y;

final class b$1
  implements Runnable
{
  b$1(b paramb, String paramString) {}
  
  public final void run()
  {
    Object localObject = b.atS().atV();
    String str = this.val$url;
    y.w("MicroMsg.BackupMoveRecoverServer", "~~~~~~~~~~~~  start by url:%s", new Object[] { str });
    com.tencent.mm.plugin.backup.g.b.auQ();
    au.Dk().a(595, ((c)localObject).hIg);
    localObject = new e(str);
    au.Dk().a((m)localObject, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.b.1
 * JD-Core Version:    0.7.0.1
 */