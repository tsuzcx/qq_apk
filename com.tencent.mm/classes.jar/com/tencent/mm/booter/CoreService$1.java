package com.tencent.mm.booter;

import com.tencent.mm.sdk.platformtools.ac.b;

final class CoreService$1
  implements ac.b
{
  CoreService$1(CoreService paramCoreService) {}
  
  public final void cancel()
  {
    MMReceivers.AlarmReceiver.aU(this.dhA.getApplicationContext());
  }
  
  public final void prepare()
  {
    MMReceivers.AlarmReceiver.aT(this.dhA.getApplicationContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.booter.CoreService.1
 * JD-Core Version:    0.7.0.1
 */