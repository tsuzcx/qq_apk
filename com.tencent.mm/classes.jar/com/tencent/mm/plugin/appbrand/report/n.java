package com.tencent.mm.plugin.appbrand.report;

import com.tencent.mm.sdk.d.c;
import com.tencent.mm.sdk.platformtools.ac;

public abstract class n
  extends c
{
  public void enter()
  {
    super.enter();
    ac.i("MicroMsg.LoggerState", getName() + " [ENTERING]");
  }
  
  public final void exit()
  {
    super.exit();
    ac.i("MicroMsg.LoggerState", getName() + " [EXITING]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.n
 * JD-Core Version:    0.7.0.1
 */