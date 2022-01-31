package com.tencent.mm.plugin.clean.c.a;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public abstract class a
  implements Runnable
{
  private long gYL = 0L;
  private a.a iBZ;
  c iCa;
  
  public a(a.a parama)
  {
    this.iBZ = parama;
  }
  
  public String Sj()
  {
    return this.gYL;
  }
  
  public abstract void execute();
  
  public void run()
  {
    try
    {
      this.gYL = bk.UZ();
      execute();
      this.gYL = bk.cp(this.gYL);
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.AbstractTask", localException, "", new Object[0]);
      return;
    }
    finally
    {
      if (this.iCa != null) {
        this.iCa.g(Long.valueOf(Thread.currentThread().getId()));
      }
      if (this.iBZ != null) {
        this.iBZ.a(this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.c.a.a
 * JD-Core Version:    0.7.0.1
 */