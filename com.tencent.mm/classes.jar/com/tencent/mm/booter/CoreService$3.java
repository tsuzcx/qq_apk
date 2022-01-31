package com.tencent.mm.booter;

import com.tencent.mm.network.aa;

final class CoreService$3
  implements Runnable
{
  CoreService$3(CoreService paramCoreService) {}
  
  public final void run()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.CoreService", "NetNotifyAdapter NeedNotifyGCM after init");
    aa.Uw().onPush(2147480001, new byte[0]);
  }
  
  public final String toString()
  {
    return "NotifyGCM";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.booter.CoreService.3
 * JD-Core Version:    0.7.0.1
 */