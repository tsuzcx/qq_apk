package com.tencent.mm.plugin.ipcall.model;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.core.app.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.bq.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.ipcall.ui.IPCallTalkUI;
import com.tencent.mm.plugin.voip.f.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ipcall/model/IPCallForegroundService;", "Landroid/app/Service;", "()V", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "", "onDestroy", "onStartCommand", "", "flags", "startId", "setNotificationBind", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class IPCallForegroundService
  extends Service
{
  public static final a JFX;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(39607);
    JFX = new a((byte)0);
    TAG = "MicroMsg.IPCallForegroundService";
    AppMethodBeat.o(39607);
  }
  
  public final IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(39606);
    s.u(paramIntent, "intent");
    Log.i(TAG, "onBind");
    AppMethodBeat.o(39606);
    return null;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(39604);
    Log.i(TAG, "IPCallForegroundService onCreate");
    super.onCreate();
    if (!h.baC().aZN())
    {
      stopSelf();
      AppMethodBeat.o(39604);
      return;
    }
    if (d.rb(26))
    {
      Object localObject = a.cA(MMApplicationContext.getContext(), "reminder_channel_id").bt(System.currentTimeMillis()).eb(com.tencent.mm.plugin.voip.widget.b.guX());
      ((f.d)localObject).q(2, true);
      localObject = m.e((f.d)localObject);
      try
      {
        if (MMApplicationContext.isMMProcessExist()) {
          Log.i(TAG, "current mmprocess is exits");
        }
        startForeground(42, (Notification)localObject);
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
      ((com.tencent.mm.plugin.notification.b.b)h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification().cancel(42);
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
    if (!h.baC().aZN())
    {
      Log.e(TAG, "error called ipcall foreground service in onStartCommand process");
      stopSelf();
      AppMethodBeat.o(39603);
      return 2;
    }
    Object localObject;
    if ((d.rb(26)) && (paramIntent != null))
    {
      Log.i(TAG, "foreground service is on bind ");
      s.u(paramIntent, "intent");
      Log.i(TAG, "setNotificationBind");
      paramIntent.setClass(MMApplicationContext.getContext(), IPCallTalkUI.class);
      paramIntent.setFlags(268435456);
      paramIntent.putExtra("IPCallTalkUI_isFromMiniNotification", true);
      localObject = MMApplicationContext.getContext().getString(R.l.gKy);
      s.s(localObject, "getContext().getString(c…ip_call_minimize_wording)");
      Log.i(TAG, "IPCallForegroundService notification type is 42");
      if (h.baC().aZN()) {
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
      localObject = a.cA(MMApplicationContext.getContext(), "reminder_channel_id").o((CharSequence)localObject).bt(System.currentTimeMillis()).l((CharSequence)MMApplicationContext.getContext().getString(R.l.ip_call_func_name)).m((CharSequence)localObject).eb(com.tencent.mm.plugin.voip.widget.b.guX());
      ((f.d)localObject).bor = paramIntent;
      ((f.d)localObject).q(2, true);
      paramIntent = m.e((f.d)localObject);
      paramIntent.flags |= 0x20;
      ((com.tencent.mm.plugin.notification.b.b)h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification().a(42, paramIntent, false);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ipcall/model/IPCallForegroundService$Companion;", "", "()V", "TAG", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.IPCallForegroundService
 * JD-Core Version:    0.7.0.1
 */