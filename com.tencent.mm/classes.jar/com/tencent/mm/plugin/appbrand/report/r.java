package com.tencent.mm.plugin.appbrand.report;

import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.statemachine.State;

public abstract class r
  extends State
{
  public void enter()
  {
    super.enter();
    Log.i("MicroMsg.LoggerState", getName() + " [ENTERING]");
  }
  
  public void exit()
  {
    super.exit();
    Log.i("MicroMsg.LoggerState", getName() + " [EXITING]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.r
 * JD-Core Version:    0.7.0.1
 */