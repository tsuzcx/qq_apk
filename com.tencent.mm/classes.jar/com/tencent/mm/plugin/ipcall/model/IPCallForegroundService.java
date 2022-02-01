package com.tencent.mm.plugin.ipcall.model;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aq;
import com.tencent.mm.plugin.ipcall.ui.IPCallTalkUI;
import com.tencent.mm.plugin.voip.widget.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/ipcall/model/IPCallForegroundService;", "Landroid/app/Service;", "()V", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "", "onDestroy", "onStartCommand", "", "flags", "startId", "setNotificationBind", "Companion", "app_release"})
public final class IPCallForegroundService
  extends Service
{
  private static final String TAG = "MicroMsg.IPCallForegroundService";
  public static final IPCallForegroundService.a szV;
  
  static
  {
    AppMethodBeat.i(39607);
    szV = new IPCallForegroundService.a((byte)0);
    TAG = "MicroMsg.IPCallForegroundService";
    AppMethodBeat.o(39607);
  }
  
  public final IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(39606);
    d.g.b.k.h(paramIntent, "intent");
    ad.i(TAG, "onBind");
    AppMethodBeat.o(39606);
    return null;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(39604);
    ad.i(TAG, "IPCallForegroundService onCreate");
    super.onCreate();
    if (!g.afz().aeI())
    {
      stopSelf();
      AppMethodBeat.o(39604);
      return;
    }
    if (d.lf(26))
    {
      Notification localNotification = com.tencent.mm.plugin.voip.b.k.c(com.tencent.mm.br.a.bD(aj.getContext(), "reminder_channel_id").g(System.currentTimeMillis()).as(b.cYf()).dN());
      try
      {
        if (aj.eFN()) {
          ad.i(TAG, "current mmprocess is exits");
        }
        startForeground(42, localNotification);
        AppMethodBeat.o(39604);
        return;
      }
      catch (Exception localException)
      {
        ad.i(TAG, "start foreground service happened error %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(39604);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(39605);
    ad.i(TAG, "IPCallForegroundService onDestroy");
    try
    {
      stopForeground(true);
      com.tencent.mm.kernel.b.a locala = g.ad(com.tencent.mm.plugin.notification.b.a.class);
      d.g.b.k.g(locala, "MMKernel.plugin(IPluginNotification::class.java)");
      ((com.tencent.mm.plugin.notification.b.a)locala).getNotification().cancel(42);
      super.onDestroy();
      AppMethodBeat.o(39605);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e(TAG, "onDestroy happened error %s", new Object[] { localException });
      }
    }
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(39603);
    if (!g.afz().aeI())
    {
      ad.e(TAG, "error called ipcall foreground service in onStartCommand process");
      stopSelf();
      AppMethodBeat.o(39603);
      return 2;
    }
    Object localObject;
    if ((d.lf(26)) && (paramIntent != null))
    {
      ad.i(TAG, "foreground service is on bind ");
      d.g.b.k.h(paramIntent, "intent");
      ad.i(TAG, "setNotificationBind");
      paramIntent.setClass(aj.getContext(), IPCallTalkUI.class);
      paramIntent.setFlags(268435456);
      paramIntent.putExtra("IPCallTalkUI_isFromMiniNotification", true);
      localObject = aj.getContext().getString(2131760458);
      ad.i(TAG, "IPCallForegroundService notification type is 42");
      if (g.afz().aeI()) {
        break label138;
      }
      ad.e(TAG, "error called ipcall foreground service in setNotification process");
      stopSelf();
    }
    for (;;)
    {
      AppMethodBeat.o(39603);
      return 3;
      label138:
      paramIntent = PendingIntent.getActivity(aj.getContext(), 42, paramIntent, 134217728);
      paramIntent = com.tencent.mm.plugin.voip.b.k.c(com.tencent.mm.br.a.bD(aj.getContext(), "reminder_channel_id").i((CharSequence)localObject).g(System.currentTimeMillis()).f((CharSequence)aj.getContext().getString(2131760448)).g((CharSequence)localObject).as(b.cYf()).a(paramIntent).dN());
      paramIntent.flags |= 0x20;
      localObject = g.ad(com.tencent.mm.plugin.notification.b.a.class);
      d.g.b.k.g(localObject, "MMKernel.plugin(IPluginNotification::class.java)");
      ((com.tencent.mm.plugin.notification.b.a)localObject).getNotification().a(42, paramIntent, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.IPCallForegroundService
 * JD-Core Version:    0.7.0.1
 */