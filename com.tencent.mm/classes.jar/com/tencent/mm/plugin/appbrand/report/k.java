package com.tencent.mm.plugin.appbrand.report;

import com.tencent.mm.sdk.d.c;
import com.tencent.mm.sdk.platformtools.ab;

public abstract class k
  extends c
{
  public void enter()
  {
    super.enter();
    ab.i("MicroMsg.LoggerState", getName() + " [ENTERING]");
  }
  
  public void exit()
  {
    super.exit();
    ab.i("MicroMsg.LoggerState", getName() + " [EXITING]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.k
 * JD-Core Version:    0.7.0.1
 */