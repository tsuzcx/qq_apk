package com.tencent.mm.plugin.backup.d;

import com.tencent.mm.plugin.backup.c.b;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class a$1
  implements Runnable
{
  public a$1(a parama) {}
  
  public final void run()
  {
    if (this.hHz.hHr != null) {
      this.hHz.hHr.cancel();
    }
    this.hHz.hHr = new b();
    if ((this.hHz.atO() == null) || (this.hHz.atO().size() == 0))
    {
      y.e("MicroMsg.BackupMoveChooseServer", "backupSessionInfo is null or nill!");
      this.hHz.hHr.a(this.hHz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.a.1
 * JD-Core Version:    0.7.0.1
 */