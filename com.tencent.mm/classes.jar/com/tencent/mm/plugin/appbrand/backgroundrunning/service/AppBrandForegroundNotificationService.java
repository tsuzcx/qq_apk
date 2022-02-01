package com.tencent.mm.plugin.appbrand.backgroundrunning.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.s.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.a;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningApp;
import com.tencent.mm.plugin.appbrand.backgroundrunning.d;
import com.tencent.mm.plugin.appbrand.backgroundrunning.e;
import com.tencent.mm.plugin.appbrand.backgroundrunning.e.a;
import com.tencent.mm.plugin.appbrand.backgroundrunning.e.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class AppBrandForegroundNotificationService
  extends Service
{
  public static int jyC = 1025;
  private NotificationManager Gu;
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(44807);
    super.onCreate();
    ac.i("MicroMsg.AppBrandForegroundNotificationService", "onCreate");
    AppMethodBeat.o(44807);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(44808);
    ac.i("MicroMsg.AppBrandForegroundNotificationService", "onDestroy");
    stopForeground(false);
    super.onDestroy();
    AppMethodBeat.o(44808);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    paramInt1 = 1;
    AppMethodBeat.i(44809);
    ac.i("MicroMsg.AppBrandForegroundNotificationService", "onStartCommand");
    if ((paramIntent == null) || (paramIntent.getExtras() == null))
    {
      ac.i("MicroMsg.AppBrandForegroundNotificationService", "onStartCommand, intent is null");
      AppMethodBeat.o(44809);
      return 2;
    }
    Object localObject2 = paramIntent.getParcelableArrayListExtra("key_apps");
    if ((localObject2 == null) || (((List)localObject2).isEmpty()))
    {
      ac.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildForegroundNotifications, apps is null");
      paramIntent = null;
    }
    while ((paramIntent == null) || (paramIntent.isEmpty()))
    {
      ac.i("MicroMsg.AppBrandForegroundNotificationService", "onStartCommand, notificationWrappers is empty");
      AppMethodBeat.o(44809);
      return 2;
      ac.i("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "preProcessApps");
      Object localObject3;
      if (((List)localObject2).isEmpty())
      {
        paramIntent = null;
        if (paramIntent == null)
        {
          ac.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildForegroundNotifications, backgroundRunningApps is null");
          paramIntent = null;
        }
      }
      else
      {
        localObject1 = new e.a((byte)0);
        localObject3 = ((List)localObject2).iterator();
        for (;;)
        {
          paramIntent = (Intent)localObject1;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          paramIntent = (AppBrandBackgroundRunningApp)((Iterator)localObject3).next();
          if (!bs.isNullOrNil(paramIntent.jxV))
          {
            if (((e.a)localObject1).jym == null) {
              ((e.a)localObject1).jym = new ArrayList(((List)localObject2).size());
            }
            ((e.a)localObject1).jym.add(paramIntent);
          }
          else
          {
            if (((e.a)localObject1).jyn == null) {
              ((e.a)localObject1).jyn = new ArrayList(((List)localObject2).size());
            }
            ((e.a)localObject1).jyn.add(paramIntent);
          }
        }
      }
      localObject2 = paramIntent.jyn;
      if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
        ac.i("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildNormalForegroundNotification, apps is null");
      }
      for (localObject1 = null;; localObject1 = new e.b((Notification)localObject1, jyC))
      {
        localObject2 = e.ba(paramIntent.jym);
        if ((localObject1 != null) || ((localObject2 != null) && (!((List)localObject2).isEmpty()))) {
          break label448;
        }
        paramIntent = null;
        break;
        ac.i("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildNormalForegroundNotification, apps:%s", new Object[] { localObject2 });
        localObject1 = d.aX((List)localObject2);
        localObject2 = d.aZ((List)localObject2);
        localObject3 = new s.c(ai.getContext(), "reminder_channel_id");
        ((s.c)localObject3).f(2, true);
        ((s.c)localObject3).f((CharSequence)localObject1).g((CharSequence)localObject2).as(a.dlN()).i(System.currentTimeMillis());
        localObject1 = ((s.c)localObject3).build();
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
    Object localObject1 = (e.b)paramIntent.get(0);
    startForeground(((e.b)localObject1).notificationId, ((e.b)localObject1).jyo);
    paramInt2 = paramIntent.size();
    if (1 < paramInt2) {
      while (paramInt1 < paramInt2)
      {
        localObject1 = (e.b)paramIntent.get(paramInt1);
        if (this.Gu == null) {
          this.Gu = ((NotificationManager)getSystemService("notification"));
        }
        this.Gu.notify(((e.b)localObject1).notificationId, ((e.b)localObject1).jyo);
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
    ac.i("MicroMsg.AppBrandForegroundNotificationService", "onTaskRemoved");
    ((NotificationManager)ai.getContext().getSystemService("notification")).cancel(jyC);
    stopSelf();
    AppMethodBeat.o(44810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.service.AppBrandForegroundNotificationService
 * JD-Core Version:    0.7.0.1
 */