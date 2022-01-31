package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel;

import com.tencent.mm.cf.h;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class c
{
  public long dXA = 0L;
  private long hHf = -1L;
  boolean hHg = false;
  
  public final void begin()
  {
    y.d("MicroMsg.Recoverfaster", "begin");
    if (b.avO().avP().dKu != null)
    {
      this.hHf = b.avO().avP().dKu.eV(Thread.currentThread().getId());
      this.hHg = true;
    }
    this.dXA = bk.UY();
  }
  
  public final void end()
  {
    if ((this.hHg) && (b.avO().avP().dKu != null))
    {
      b.avO().avP().dKu.hI(this.hHf);
      this.hHg = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.c
 * JD-Core Version:    0.7.0.1
 */