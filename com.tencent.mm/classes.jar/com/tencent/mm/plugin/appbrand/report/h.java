package com.tencent.mm.plugin.appbrand.report;

import com.tencent.mm.sdk.d.c;
import com.tencent.mm.sdk.platformtools.y;

public abstract class h
  extends c
{
  public void enter()
  {
    super.enter();
    y.i("MicroMsg.LoggerState", getName() + " [ENTERING]");
  }
  
  public void exit()
  {
    super.exit();
    y.i("MicroMsg.LoggerState", getName() + " [EXITING]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.h
 * JD-Core Version:    0.7.0.1
 */