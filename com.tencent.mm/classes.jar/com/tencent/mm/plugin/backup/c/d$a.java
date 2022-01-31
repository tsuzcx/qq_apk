package com.tencent.mm.plugin.backup.c;

import com.tencent.mm.cf.h;
import com.tencent.mm.plugin.backup.h.b;
import com.tencent.mm.sdk.platformtools.bk;

final class d$a
{
  private long beginTime;
  private long hHf = -1L;
  boolean hHg = false;
  
  private d$a(d paramd) {}
  
  public final void atL()
  {
    if (bk.co(this.beginTime) > 500L) {
      end();
    }
    try
    {
      Thread.sleep(5L);
      label24:
      begin();
      this.beginTime = bk.UY();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label24;
    }
  }
  
  public final void begin()
  {
    if (com.tencent.mm.plugin.backup.h.d.avi().avj().dKu != null)
    {
      this.hHf = com.tencent.mm.plugin.backup.h.d.avi().avj().dKu.eV(Thread.currentThread().getId());
      this.hHg = true;
      this.beginTime = bk.UY();
    }
  }
  
  public final void end()
  {
    if ((this.hHg) && (com.tencent.mm.plugin.backup.h.d.avi().avj().dKu != null))
    {
      com.tencent.mm.plugin.backup.h.d.avi().avj().dKu.hI(this.hHf);
      this.hHg = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.d.a
 * JD-Core Version:    0.7.0.1
 */