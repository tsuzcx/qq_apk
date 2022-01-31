package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

final class AppBrandMainProcessService$2
  extends c.a
{
  AppBrandMainProcessService$2(AppBrandMainProcessService paramAppBrandMainProcessService) {}
  
  public final void B(Bundle paramBundle)
  {
    AppMethodBeat.i(90982);
    Message localMessage = Message.obtain();
    localMessage.setData(paramBundle);
    AppBrandMainProcessService.a(this.hvM).send(localMessage);
    AppMethodBeat.o(90982);
  }
  
  public final void C(Bundle paramBundle)
  {
    AppMethodBeat.i(90983);
    paramBundle = AppBrandMainProcessService.b(paramBundle, false);
    if (paramBundle != null) {
      paramBundle.ata();
    }
    AppMethodBeat.o(90983);
  }
  
  public final void a(IBinder paramIBinder, String paramString)
  {
    AppMethodBeat.i(90984);
    AppBrandMainProcessService.2.1 local1 = new AppBrandMainProcessService.2.1(this, paramString, paramIBinder);
    try
    {
      paramIBinder.linkToDeath(local1, 0);
      AppBrandMainProcessService.b(this.hvM).put(paramString, local1);
      AppBrandMainProcessService.aBc();
      AppMethodBeat.o(90984);
      return;
    }
    catch (Exception paramIBinder)
    {
      ab.e("MicroMsg.AppBrandMainProcessService", "registerDeathRecipient: %s", new Object[] { paramIBinder });
      AppMethodBeat.o(90984);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.2
 * JD-Core Version:    0.7.0.1
 */