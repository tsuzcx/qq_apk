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
import com.tencent.mm.plugin.appbrand.backgroundrunning.c;
import com.tencent.mm.plugin.appbrand.backgroundrunning.d;
import com.tencent.mm.plugin.appbrand.backgroundrunning.d.a;
import com.tencent.mm.plugin.appbrand.backgroundrunning.d.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class AppBrandForegroundNotificationService
  extends Service
{
  public static int jVQ = 1025;
  private NotificationManager Im;
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(44807);
    super.onCreate();
    ae.i("MicroMsg.AppBrandForegroundNotificationService", "onCreate");
    AppMethodBeat.o(44807);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(44808);
    ae.i("MicroMsg.AppBrandForegroundNotificationService", "onDestroy");
    stopForeground(false);
    super.onDestroy();
    AppMethodBeat.o(44808);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    paramInt1 = 1;
    AppMethodBeat.i(44809);
    ae.i("MicroMsg.AppBrandForegroundNotificationService", "onStartCommand");
    if ((paramIntent == null) || (paramIntent.getExtras() == null))
    {
      ae.i("MicroMsg.AppBrandForegroundNotificationService", "onStartCommand, intent is null");
      AppMethodBeat.o(44809);
      return 2;
    }
    Object localObject2 = paramIntent.getParcelableArrayListExtra("key_apps");
    if ((localObject2 == null) || (((List)localObject2).isEmpty()))
    {
      ae.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildForegroundNotifications, apps is null");
      paramIntent = null;
    }
    while ((paramIntent == null) || (paramIntent.isEmpty()))
    {
      ae.i("MicroMsg.AppBrandForegroundNotificationService", "onStartCommand, notificationWrappers is empty");
      AppMethodBeat.o(44809);
      return 2;
      ae.i("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "preProcessApps");
      Object localObject3;
      if (((List)localObject2).isEmpty())
      {
        paramIntent = null;
        if (paramIntent == null)
        {
          ae.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildForegroundNotifications, backgroundRunningApps is null");
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
          if (!bu.isNullOrNil(paramIntent.jVj))
          {
            if (((d.a)localObject1).jVA == null) {
              ((d.a)localObject1).jVA = new ArrayList(((List)localObject2).size());
            }
            ((d.a)localObject1).jVA.add(paramIntent);
          }
          else
          {
            if (((d.a)localObject1).jVB == null) {
              ((d.a)localObject1).jVB = new ArrayList(((List)localObject2).size());
            }
            ((d.a)localObject1).jVB.add(paramIntent);
          }
        }
      }
      localObject2 = paramIntent.jVB;
      if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
        ae.i("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildNormalForegroundNotification, apps is null");
      }
      for (localObject1 = null;; localObject1 = new d.b((Notification)localObject1, jVQ))
      {
        localObject2 = d.be(paramIntent.jVA);
        if ((localObject1 != null) || ((localObject2 != null) && (!((List)localObject2).isEmpty()))) {
          break label448;
        }
        paramIntent = null;
        break;
        ae.i("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildNormalForegroundNotification, apps:%s", new Object[] { localObject2 });
        localObject1 = c.bb((List)localObject2);
        localObject2 = c.bd((List)localObject2);
        localObject3 = new s.c(ak.getContext(), "reminder_channel_id");
        ((s.c)localObject3).f(2, true);
        ((s.c)localObject3).f((CharSequence)localObject1).g((CharSequence)localObject2).as(a.dzu()).i(System.currentTimeMillis());
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
    Object localObject1 = (d.b)paramIntent.get(0);
    startForeground(((d.b)localObject1).notificationId, ((d.b)localObject1).jVC);
    paramInt2 = paramIntent.size();
    if (1 < paramInt2) {
      while (paramInt1 < paramInt2)
      {
        localObject1 = (d.b)paramIntent.get(paramInt1);
        if (this.Im == null) {
          this.Im = ((NotificationManager)getSystemService("notification"));
        }
        this.Im.notify(((d.b)localObject1).notificationId, ((d.b)localObject1).jVC);
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
    ae.i("MicroMsg.AppBrandForegroundNotificationService", "onTaskRemoved");
    ((NotificationManager)ak.getContext().getSystemService("notification")).cancel(jVQ);
    stopSelf();
    AppMethodBeat.o(44810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.service.AppBrandForegroundNotificationService
 * JD-Core Version:    0.7.0.1
 */