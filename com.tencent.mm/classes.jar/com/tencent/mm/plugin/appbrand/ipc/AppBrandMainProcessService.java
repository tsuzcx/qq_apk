package com.tencent.mm.plugin.appbrand.ipc;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class AppBrandMainProcessService
  extends Service
{
  private static d jua;
  private static ServiceConnection jub;
  private static final LinkedList<Parcel> juc;
  private static Map<String, WeakReference<MainProcessTask>> jud;
  private static final Handler jue;
  private static Messenger juf;
  private static final Set<Runnable> jug;
  private static final Set<a> juh;
  private final HashMap<String, IBinder.DeathRecipient> jtX;
  private final Messenger jtY;
  private final d.a jtZ;
  private final Handler mHandler;
  
  static
  {
    AppMethodBeat.i(140616);
    juc = new LinkedList();
    jud = new ConcurrentHashMap();
    jue = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(140596);
        paramAnonymousMessage = AppBrandMainProcessService.b(paramAnonymousMessage.getData(), false);
        if (paramAnonymousMessage == null)
        {
          AppMethodBeat.o(140596);
          return;
        }
        MainProcessTask localMainProcessTask = AppBrandMainProcessService.HA(paramAnonymousMessage.hLO);
        if (localMainProcessTask == null)
        {
          ad.e("MicroMsg.AppBrandMainProcessService", "receive client msg, get null task by id %s", new Object[] { paramAnonymousMessage.hLO });
          AppMethodBeat.o(140596);
          return;
        }
        AppBrandMainProcessService.b(paramAnonymousMessage, localMainProcessTask);
        localMainProcessTask.aEA();
        AppMethodBeat.o(140596);
      }
    };
    juf = new Messenger(jue);
    jug = new HashSet();
    juh = Collections.newSetFromMap(new ConcurrentHashMap());
    AppMethodBeat.o(140616);
  }
  
  public AppBrandMainProcessService()
  {
    AppMethodBeat.i(140599);
    this.jtX = new HashMap();
    this.mHandler = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(final Message paramAnonymousMessage)
      {
        AppMethodBeat.i(140591);
        paramAnonymousMessage = AppBrandMainProcessService.b(paramAnonymousMessage.getData(), true);
        if (paramAnonymousMessage != null) {
          h.Iye.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(194795);
              paramAnonymousMessage.aEz();
              AppMethodBeat.o(194795);
            }
          }, "MicroMsg.AppBrandMainProcessService");
        }
        AppMethodBeat.o(140591);
      }
    };
    this.jtY = new Messenger(this.mHandler);
    this.jtZ = new d.a()
    {
      public final void F(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(140593);
        Message localMessage = Message.obtain();
        localMessage.setData(paramAnonymousBundle);
        AppBrandMainProcessService.a(AppBrandMainProcessService.this).send(localMessage);
        AppMethodBeat.o(140593);
      }
      
      public final void G(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(140594);
        paramAnonymousBundle = AppBrandMainProcessService.b(paramAnonymousBundle, false);
        if (paramAnonymousBundle != null) {
          paramAnonymousBundle.aEz();
        }
        AppMethodBeat.o(140594);
      }
      
      public final void a(final IBinder paramAnonymousIBinder, final String paramAnonymousString)
      {
        AppMethodBeat.i(140595);
        IBinder.DeathRecipient local1 = new IBinder.DeathRecipient()
        {
          public final void binderDied()
          {
            AppMethodBeat.i(140592);
            IBinder.DeathRecipient localDeathRecipient = (IBinder.DeathRecipient)AppBrandMainProcessService.b(AppBrandMainProcessService.this).get(paramAnonymousString);
            if (localDeathRecipient == null)
            {
              AppMethodBeat.o(140592);
              return;
            }
            paramAnonymousIBinder.unlinkToDeath(localDeathRecipient, 0);
            AppBrandMainProcessService.b(AppBrandMainProcessService.this).remove(paramAnonymousString);
            AppBrandMainProcessService.DC(paramAnonymousString);
            ad.e("MicroMsg.AppBrandMainProcessService", "Client Process Died: %s", new Object[] { paramAnonymousString });
            AppMethodBeat.o(140592);
          }
        };
        try
        {
          paramAnonymousIBinder.linkToDeath(local1, 0);
          AppBrandMainProcessService.b(AppBrandMainProcessService.this).put(paramAnonymousString, local1);
          AppBrandMainProcessService.et(paramAnonymousString);
          AppMethodBeat.o(140595);
          return;
        }
        catch (Exception paramAnonymousIBinder)
        {
          ad.e("MicroMsg.AppBrandMainProcessService", "registerDeathRecipient: %s", new Object[] { paramAnonymousIBinder });
          AppMethodBeat.o(140595);
        }
      }
    };
    AppMethodBeat.o(140599);
  }
  
  private static boolean C(Bundle paramBundle)
  {
    AppMethodBeat.i(140602);
    boolean bool = true;
    try
    {
      jua.G(paramBundle);
      AppMethodBeat.o(140602);
      return bool;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        bool = false;
        ad.e("MicroMsg.AppBrandMainProcessService", paramBundle.getMessage());
      }
    }
  }
  
  private static void D(Bundle paramBundle)
  {
    AppMethodBeat.i(140603);
    if (jua == null)
    {
      U(null);
      synchronized (juc)
      {
        juc.add(E(paramBundle));
        AppMethodBeat.o(140603);
        return;
      }
    }
    try
    {
      jua.F(paramBundle);
      AppMethodBeat.o(140603);
      return;
    }
    catch (Exception paramBundle)
    {
      ad.e("MicroMsg.AppBrandMainProcessService", paramBundle.getMessage());
      AppMethodBeat.o(140603);
    }
  }
  
  private static Parcel E(Bundle paramBundle)
  {
    AppMethodBeat.i(140608);
    Parcel localParcel = Parcel.obtain();
    paramBundle.writeToParcel(localParcel, 0);
    AppMethodBeat.o(140608);
    return localParcel;
  }
  
  public static void U(Runnable paramRunnable)
  {
    AppMethodBeat.i(194797);
    if ((paramRunnable != null) && (jua != null))
    {
      paramRunnable.run();
      AppMethodBeat.o(194797);
      return;
    }
    if (paramRunnable != null) {}
    synchronized (jug)
    {
      jug.add(paramRunnable);
      if (jub == null) {
        jub = new ServiceConnection()
        {
          public final void onServiceConnected(ComponentName arg1, IBinder paramAnonymousIBinder)
          {
            AppMethodBeat.i(140597);
            AppBrandMainProcessService.a(d.a.q(paramAnonymousIBinder));
            AppBrandMainProcessService.aXg();
            AppBrandMainProcessService.et(aj.getPackageName());
            try
            {
              AppBrandMainProcessService.aXh().a(new Binder(), aj.getProcessName());
              ad.i("MicroMsg.AppBrandMainProcessService", "onServiceConnected(%s)", new Object[] { aj.getProcessName() });
              AppMethodBeat.o(140597);
            }
            catch (Exception ???)
            {
              synchronized (AppBrandMainProcessService.TE())
              {
                paramAnonymousIBinder = new HashSet(AppBrandMainProcessService.TE());
                AppBrandMainProcessService.TE().clear();
                ??? = paramAnonymousIBinder.iterator();
                while (???.hasNext())
                {
                  paramAnonymousIBinder = (Runnable)???.next();
                  if (paramAnonymousIBinder != null)
                  {
                    paramAnonymousIBinder.run();
                    continue;
                    ??? = ???;
                    ad.e("MicroMsg.AppBrandMainProcessService", "onServiceConnected, registerDeathRecipient, %s", new Object[] { ??? });
                  }
                }
              }
            }
          }
          
          public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
          {
            AppMethodBeat.i(140598);
            AppBrandMainProcessService.a(null);
            AppBrandMainProcessService.DC(aj.getPackageName());
            AppBrandMainProcessService.aXe();
            ad.i("MicroMsg.AppBrandMainProcessService", "onServiceDisconnected(%s)", new Object[] { aj.getProcessName() });
            AppMethodBeat.o(140598);
          }
        };
      }
      ad.i("MicroMsg.AppBrandMainProcessService", "tryBindService");
      paramRunnable = aj.getContext();
      ??? = new Intent(paramRunnable, AppBrandMainProcessService.class);
    }
    try
    {
      paramRunnable.bindService((Intent)???, jub, 1);
      AppMethodBeat.o(194797);
      return;
    }
    catch (Exception paramRunnable)
    {
      ad.e("MicroMsg.AppBrandMainProcessService", "bindService() Exception:%s", new Object[] { paramRunnable.getMessage() });
      AppMethodBeat.o(194797);
    }
    paramRunnable = finally;
    AppMethodBeat.o(194797);
    throw paramRunnable;
  }
  
  public static Bundle a(MainProcessTask paramMainProcessTask, boolean paramBoolean)
  {
    AppMethodBeat.i(140609);
    Bundle localBundle = new Bundle(3);
    localBundle.putParcelable("task_object", paramMainProcessTask);
    if (paramBoolean) {
      localBundle.putParcelable("task_client", juf);
    }
    localBundle.putString("task_id", paramMainProcessTask.hLO);
    AppMethodBeat.o(140609);
    return localBundle;
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(140605);
    juh.add(parama);
    AppMethodBeat.o(140605);
  }
  
  public static void a(MainProcessTask paramMainProcessTask)
  {
    AppMethodBeat.i(140600);
    jud.put(paramMainProcessTask.hLO, new WeakReference(paramMainProcessTask));
    D(a(paramMainProcessTask, true));
    AppMethodBeat.o(140600);
  }
  
  private static void a(MainProcessTask paramMainProcessTask1, MainProcessTask paramMainProcessTask2)
  {
    AppMethodBeat.i(140607);
    Parcel localParcel = Parcel.obtain();
    paramMainProcessTask1.writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    paramMainProcessTask2.e(localParcel);
    localParcel.recycle();
    AppMethodBeat.o(140607);
  }
  
  public static void aXe()
  {
    AppMethodBeat.i(201303);
    U(null);
    AppMethodBeat.o(201303);
  }
  
  public static boolean aXf()
  {
    return jua != null;
  }
  
  public static MainProcessTask b(Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(140610);
    paramBundle.setClassLoader(MainProcessTask.class.getClassLoader());
    try
    {
      MainProcessTask localMainProcessTask1 = (MainProcessTask)paramBundle.getParcelable("task_object");
      if (localMainProcessTask1 == null)
      {
        AppMethodBeat.o(140610);
        return null;
      }
    }
    catch (ClassCastException localClassCastException)
    {
      MainProcessTask localMainProcessTask2;
      for (;;)
      {
        ad.e("MicroMsg.AppBrandMainProcessService", "convertBundleToTask e=%s", new Object[] { localClassCastException });
        localMainProcessTask2 = null;
      }
      if (paramBoolean) {
        localMainProcessTask2.jvp = ((Messenger)paramBundle.getParcelable("task_client"));
      }
      localMainProcessTask2.hLO = paramBundle.getString("task_id");
      AppMethodBeat.o(140610);
      return localMainProcessTask2;
    }
  }
  
  public static void b(a parama)
  {
    AppMethodBeat.i(140606);
    juh.remove(parama);
    AppMethodBeat.o(140606);
  }
  
  public static boolean b(MainProcessTask paramMainProcessTask)
  {
    AppMethodBeat.i(140601);
    Bundle localBundle = a(paramMainProcessTask, false);
    if (C(localBundle)) {
      try
      {
        a(b(localBundle, false), paramMainProcessTask);
        paramMainProcessTask.aEA();
        AppMethodBeat.o(140601);
        return true;
      }
      catch (NullPointerException paramMainProcessTask)
      {
        AppMethodBeat.o(140601);
        return false;
      }
    }
    AppMethodBeat.o(140601);
    return false;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.jtZ;
  }
  
  public static class a
  {
    public void Dh(String paramString) {}
    
    public void onDisconnected(String paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService
 * JD-Core Version:    0.7.0.1
 */