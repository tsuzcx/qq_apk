package com.tencent.mm.plugin.clean.c.a;

import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public abstract class a
  implements Runnable
{
  private long iHc = 0L;
  private a.a kHg;
  c kHh;
  
  public a(a.a parama)
  {
    this.kHg = parama;
  }
  
  public String alu()
  {
    return this.iHc;
  }
  
  public abstract void execute();
  
  public void run()
  {
    try
    {
      this.iHc = bo.yB();
      execute();
      this.iHc = bo.av(this.iHc);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.AbstractTask", localException, "", new Object[0]);
      return;
    }
    finally
    {
      if (this.kHh != null) {
        this.kHh.f(Long.valueOf(Thread.currentThread().getId()));
      }
      if (this.kHg != null) {
        this.kHg.a(this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.c.a.a
 * JD-Core Version:    0.7.0.1
 */