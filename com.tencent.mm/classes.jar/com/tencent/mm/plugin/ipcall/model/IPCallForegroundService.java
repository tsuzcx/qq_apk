package com.tencent.mm.plugin.ipcall.model;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.core.app.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.ipcall.ui.IPCallTalkUI;
import com.tencent.mm.plugin.voip.c.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/ipcall/model/IPCallForegroundService;", "Landroid/app/Service;", "()V", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "", "onDestroy", "onStartCommand", "", "flags", "startId", "setNotificationBind", "Companion", "app_release"})
public final class IPCallForegroundService
  extends Service
{
  public static final IPCallForegroundService.a DOI;
  private static final String TAG = "MicroMsg.IPCallForegroundService";
  
  static
  {
    AppMethodBeat.i(39607);
    DOI = new IPCallForegroundService.a((byte)0);
    TAG = "MicroMsg.IPCallForegroundService";
    AppMethodBeat.o(39607);
  }
  
  public final IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(39606);
    p.k(paramIntent, "intent");
    Log.i(TAG, "onBind");
    AppMethodBeat.o(39606);
    return null;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(39604);
    Log.i(TAG, "IPCallForegroundService onCreate");
    super.onCreate();
    if (!h.aHE().aGM())
    {
      stopSelf();
      AppMethodBeat.o(39604);
      return;
    }
    if (d.qV(26))
    {
      Notification localNotification = m.e(com.tencent.mm.bx.a.cp(MMApplicationContext.getContext(), "reminder_channel_id").e(System.currentTimeMillis()).bn(com.tencent.mm.plugin.voip.widget.b.fkG()).gp());
      try
      {
        if (MMApplicationContext.isMMProcessExist()) {
          Log.i(TAG, "current mmprocess is exits");
        }
        startForeground(42, localNotification);
        AppMethodBeat.o(39604);
        return;
      }
      catch (Exception localException)
      {
        Log.i(TAG, "start foreground service happened error %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(39604);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(39605);
    Log.i(TAG, "IPCallForegroundService onDestroy");
    try
    {
      stopForeground(true);
      com.tencent.mm.kernel.b.a locala = h.ag(com.tencent.mm.plugin.notification.b.a.class);
      p.j(locala, "MMKernel.plugin(IPluginNotification::class.java)");
      ((com.tencent.mm.plugin.notification.b.a)locala).getNotification().cancel(42);
      super.onDestroy();
      AppMethodBeat.o(39605);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e(TAG, "onDestroy happened error %s", new Object[] { localException });
      }
    }
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(39603);
    if (!h.aHE().aGM())
    {
      Log.e(TAG, "error called ipcall foreground service in onStartCommand process");
      stopSelf();
      AppMethodBeat.o(39603);
      return 2;
    }
    Object localObject;
    if ((d.qV(26)) && (paramIntent != null))
    {
      Log.i(TAG, "foreground service is on bind ");
      p.k(paramIntent, "intent");
      Log.i(TAG, "setNotificationBind");
      paramIntent.setClass(MMApplicationContext.getContext(), IPCallTalkUI.class);
      paramIntent.setFlags(268435456);
      paramIntent.putExtra("IPCallTalkUI_isFromMiniNotification", true);
      localObject = MMApplicationContext.getContext().getString(R.l.eIR);
      p.j(localObject, "MMApplicationContext.get…ip_call_minimize_wording)");
      Log.i(TAG, "IPCallForegroundService notification type is 42");
      if (h.aHE().aGM()) {
        break label146;
      }
      Log.e(TAG, "error called ipcall foreground service in setNotification process");
      stopSelf();
    }
    for (;;)
    {
      AppMethodBeat.o(39603);
      return 3;
      label146:
      paramIntent = PendingIntent.getActivity(MMApplicationContext.getContext(), 42, paramIntent, 134217728);
      paramIntent = m.e(com.tencent.mm.bx.a.cp(MMApplicationContext.getContext(), "reminder_channel_id").n((CharSequence)localObject).e(System.currentTimeMillis()).k((CharSequence)MMApplicationContext.getContext().getString(R.l.ip_call_func_name)).l((CharSequence)localObject).bn(com.tencent.mm.plugin.voip.widget.b.fkG()).a(paramIntent).gp());
      paramIntent.flags |= 0x20;
      localObject = h.ag(com.tencent.mm.plugin.notification.b.a.class);
      p.j(localObject, "MMKernel.plugin(IPluginNotification::class.java)");
      ((com.tencent.mm.plugin.notification.b.a)localObject).getNotification().a(42, paramIntent, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.IPCallForegroundService
 * JD-Core Version:    0.7.0.1
 */