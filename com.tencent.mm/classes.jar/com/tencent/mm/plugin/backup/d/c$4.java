package com.tencent.mm.plugin.backup.d;

import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class c$4
  implements am.a
{
  c$4(c paramc) {}
  
  public final boolean tC()
  {
    if (!c.access$200())
    {
      y.e("MicroMsg.BackupMoveRecoverServer", "try connect overtime failed.");
      if (c.c(this.hIn) != null) {
        c.c(this.hIn).stopTimer();
      }
      c.d(this.hIn);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.c.4
 * JD-Core Version:    0.7.0.1
 */