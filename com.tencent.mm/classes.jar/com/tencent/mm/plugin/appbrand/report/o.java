package com.tencent.mm.plugin.appbrand.report;

import com.tencent.mm.sdk.d.c;
import com.tencent.mm.sdk.platformtools.ae;

public abstract class o
  extends c
{
  public void enter()
  {
    super.enter();
    ae.i("MicroMsg.LoggerState", getName() + " [ENTERING]");
  }
  
  public final void exit()
  {
    super.exit();
    ae.i("MicroMsg.LoggerState", getName() + " [EXITING]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.o
 * JD-Core Version:    0.7.0.1
 */