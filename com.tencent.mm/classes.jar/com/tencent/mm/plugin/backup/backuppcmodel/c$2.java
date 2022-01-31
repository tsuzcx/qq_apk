package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class c$2
  implements am.a
{
  c$2(c paramc) {}
  
  public final boolean tC()
  {
    if (!c.access$200())
    {
      y.e("MicroMsg.BackupPcProcessMgr", "tryConnect overtime failed.");
      if (c.c(this.hKH) != null) {
        c.c(this.hKH).stopTimer();
      }
      c.d(this.hKH);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.c.2
 * JD-Core Version:    0.7.0.1
 */