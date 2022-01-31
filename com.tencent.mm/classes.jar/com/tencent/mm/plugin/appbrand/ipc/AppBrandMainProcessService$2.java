package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

final class AppBrandMainProcessService$2
  extends c.a
{
  AppBrandMainProcessService$2(AppBrandMainProcessService paramAppBrandMainProcessService) {}
  
  public final void a(IBinder paramIBinder, String paramString)
  {
    AppBrandMainProcessService.2.1 local1 = new AppBrandMainProcessService.2.1(this, paramIBinder, paramString);
    try
    {
      paramIBinder.linkToDeath(local1, 0);
      AppBrandMainProcessService.b(this.gdP).put(paramString, local1);
      AppBrandMainProcessService.ahv();
      return;
    }
    catch (Exception paramIBinder)
    {
      y.e("MicroMsg.AppBrandMainProcessService", "registerDeathRecipient: %s", new Object[] { paramIBinder });
    }
  }
  
  public final void s(Bundle paramBundle)
  {
    Message localMessage = Message.obtain();
    localMessage.setData(paramBundle);
    AppBrandMainProcessService.a(this.gdP).send(localMessage);
  }
  
  public final void t(Bundle paramBundle)
  {
    AppBrandMainProcessService.b(paramBundle, false).Zu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.2
 * JD-Core Version:    0.7.0.1
 */