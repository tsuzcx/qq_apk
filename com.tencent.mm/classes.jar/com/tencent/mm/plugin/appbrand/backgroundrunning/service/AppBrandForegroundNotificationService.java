package com.tencent.mm.plugin.appbrand.backgroundrunning.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.core.app.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.a;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningApp;
import com.tencent.mm.plugin.appbrand.backgroundrunning.c;
import com.tencent.mm.plugin.appbrand.backgroundrunning.d;
import com.tencent.mm.plugin.appbrand.backgroundrunning.d.a;
import com.tencent.mm.plugin.appbrand.backgroundrunning.d.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class AppBrandForegroundNotificationService
  extends Service
{
  public static int qSJ = 1025;
  private NotificationManager bpy;
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(44807);
    super.onCreate();
    Log.i("MicroMsg.AppBrandForegroundNotificationService", "onCreate");
    AppMethodBeat.o(44807);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(44808);
    Log.i("MicroMsg.AppBrandForegroundNotificationService", "onDestroy");
    stopForeground(false);
    super.onDestroy();
    AppMethodBeat.o(44808);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    paramInt1 = 1;
    AppMethodBeat.i(44809);
    Log.i("MicroMsg.AppBrandForegroundNotificationService", "onStartCommand");
    if ((paramIntent == null) || (paramIntent.getExtras() == null))
    {
      Log.i("MicroMsg.AppBrandForegroundNotificationService", "onStartCommand, intent is null");
      AppMethodBeat.o(44809);
      return 2;
    }
    Object localObject2 = paramIntent.getParcelableArrayListExtra("key_apps");
    if ((localObject2 == null) || (((List)localObject2).isEmpty()))
    {
      Log.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildForegroundNotifications, apps is null");
      paramIntent = null;
    }
    while ((paramIntent == null) || (paramIntent.isEmpty()))
    {
      Log.i("MicroMsg.AppBrandForegroundNotificationService", "onStartCommand, notificationWrappers is empty");
      AppMethodBeat.o(44809);
      return 2;
      Log.i("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "preProcessApps");
      Object localObject3;
      if (((List)localObject2).isEmpty())
      {
        paramIntent = null;
        if (paramIntent == null)
        {
          Log.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildForegroundNotifications, backgroundRunningApps is null");
          paramIntent = null;
        }
      }
      else
      {
        localObject1 = new d.a((byte)0);
        localObject3 = ((List)localObject2).iterator();
        for (;;)
        {
          paramIntent = (Intent)localObject1;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          paramIntent = (AppBrandBackgroundRunningApp)((Iterator)localObject3).next();
          if (!Util.isNullOrNil(paramIntent.qSc))
          {
            if (((d.a)localObject1).qSt == null) {
              ((d.a)localObject1).qSt = new ArrayList(((List)localObject2).size());
            }
            ((d.a)localObject1).qSt.add(paramIntent);
          }
          else
          {
            if (((d.a)localObject1).qSu == null) {
              ((d.a)localObject1).qSu = new ArrayList(((List)localObject2).size());
            }
            ((d.a)localObject1).qSu.add(paramIntent);
          }
        }
      }
      localObject2 = paramIntent.qSu;
      if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
        Log.i("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildNormalForegroundNotification, apps is null");
      }
      for (localObject1 = null;; localObject1 = new d.b((Notification)localObject1, qSJ))
      {
        localObject2 = d.cY(paramIntent.qSt);
        if ((localObject1 != null) || ((localObject2 != null) && (!((List)localObject2).isEmpty()))) {
          break label448;
        }
        paramIntent = null;
        break;
        Log.i("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildNormalForegroundNotification, apps:%s", new Object[] { localObject2 });
        localObject1 = c.cV((List)localObject2);
        localObject2 = c.cX((List)localObject2);
        localObject3 = new f.d(MMApplicationContext.getContext(), "reminder_channel_id");
        ((f.d)localObject3).q(2, true);
        ((f.d)localObject3).l((CharSequence)localObject1).m((CharSequence)localObject2).eb(a.guX()).bt(System.currentTimeMillis());
        localObject1 = ((f.d)localObject3).DA();
        ((Notification)localObject1).flags = 8;
        ((Notification)localObject1).defaults = -1;
      }
      label448:
      paramIntent = new ArrayList();
      if (localObject1 != null) {
        paramIntent.add(localObject1);
      }
      if ((localObject2 != null) && (!((List)localObject2).isEmpty())) {
        paramIntent.addAll((Collection)localObject2);
      }
    }
    Object localObject1 = (d.b)paramIntent.get(0);
    startForeground(((d.b)localObject1).notificationId, ((d.b)localObject1).qSv);
    paramInt2 = paramIntent.size();
    if (1 < paramInt2) {
      while (paramInt1 < paramInt2)
      {
        localObject1 = (d.b)paramIntent.get(paramInt1);
        if (this.bpy == null) {
          this.bpy = ((NotificationManager)getSystemService("notification"));
        }
        this.bpy.notify(((d.b)localObject1).notificationId, ((d.b)localObject1).qSv);
        paramInt1 += 1;
      }
    }
    AppMethodBeat.o(44809);
    return 2;
  }
  
  public void onTaskRemoved(Intent paramIntent)
  {
    AppMethodBeat.i(44810);
    super.onTaskRemoved(paramIntent);
    Log.i("MicroMsg.AppBrandForegroundNotificationService", "onTaskRemoved");
    ((NotificationManager)MMApplicationContext.getContext().getSystemService("notification")).cancel(qSJ);
    stopSelf();
    AppMethodBeat.o(44810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.service.AppBrandForegroundNotificationService
 * JD-Core Version:    0.7.0.1
 */