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
  private static d koJ;
  private static ServiceConnection koK;
  private static final LinkedList<Parcel> koL;
  private static Map<String, WeakReference<MainProcessTask>> koM;
  private static final Handler koN;
  private static Messenger koO;
  private static final Set<Runnable> koP;
  private static final Set<a> koQ;
  private final HashMap<String, IBinder.DeathRecipient> koG;
  private final Messenger koH;
  private final d.a koI;
  private final Handler mHandler;
  
  static
  {
    AppMethodBeat.i(140616);
    koL = new LinkedList();
    koM = new ConcurrentHashMap();
    koN = new Handler(Looper.getMainLooper())
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
        MainProcessTask localMainProcessTask = AppBrandMainProcessService.OY(paramAnonymousMessage.iFB);
        if (localMainProcessTask == null)
        {
          ad.e("MicroMsg.AppBrandMainProcessService", "receive client msg, get null task by id %s", new Object[] { paramAnonymousMessage.iFB });
          AppMethodBeat.o(140596);
          return;
        }
        AppBrandMainProcessService.b(paramAnonymousMessage, localMainProcessTask);
        localMainProcessTask.aOB();
        AppMethodBeat.o(140596);
      }
    };
    koO = new Messenger(koN);
    koP = new HashSet();
    koQ = Collections.newSetFromMap(new ConcurrentHashMap());
    AppMethodBeat.o(140616);
  }
  
  public AppBrandMainProcessService()
  {
    AppMethodBeat.i(140599);
    this.koG = new HashMap();
    this.mHandler = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(final Message paramAnonymousMessage)
      {
        AppMethodBeat.i(140591);
        paramAnonymousMessage = AppBrandMainProcessService.b(paramAnonymousMessage.getData(), true);
        if (paramAnonymousMessage != null) {
          h.LTJ.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(187607);
              paramAnonymousMessage.aOA();
              AppMethodBeat.o(187607);
            }
          }, "MicroMsg.AppBrandMainProcessService");
        }
        AppMethodBeat.o(140591);
      }
    };
    this.koH = new Messenger(this.mHandler);
    this.koI = new d.a()
    {
      public final void G(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(140593);
        Message localMessage = Message.obtain();
        localMessage.setData(paramAnonymousBundle);
        AppBrandMainProcessService.a(AppBrandMainProcessService.this).send(localMessage);
        AppMethodBeat.o(140593);
      }
      
      public final void H(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(140594);
        paramAnonymousBundle = AppBrandMainProcessService.b(paramAnonymousBundle, false);
        if (paramAnonymousBundle != null) {
          paramAnonymousBundle.aOA();
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
            AppBrandMainProcessService.KX(paramAnonymousString);
            ad.e("MicroMsg.AppBrandMainProcessService", "Client Process Died: %s", new Object[] { paramAnonymousString });
            AppMethodBeat.o(140592);
          }
        };
        try
        {
          paramAnonymousIBinder.linkToDeath(local1, 0);
          AppBrandMainProcessService.b(AppBrandMainProcessService.this).put(paramAnonymousString, local1);
          AppBrandMainProcessService.fd(paramAnonymousString);
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
  
  private static boolean D(Bundle paramBundle)
  {
    AppMethodBeat.i(140602);
    boolean bool = true;
    try
    {
      koJ.H(paramBundle);
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
  
  private static void E(Bundle paramBundle)
  {
    AppMethodBeat.i(140603);
    if (koJ == null)
    {
      V(null);
      synchronized (koL)
      {
        koL.add(F(paramBundle));
        AppMethodBeat.o(140603);
        return;
      }
    }
    try
    {
      koJ.G(paramBundle);
      AppMethodBeat.o(140603);
      return;
    }
    catch (Exception paramBundle)
    {
      ad.e("MicroMsg.AppBrandMainProcessService", paramBundle.getMessage());
      AppMethodBeat.o(140603);
    }
  }
  
  private static Parcel F(Bundle paramBundle)
  {
    AppMethodBeat.i(140608);
    Parcel localParcel = Parcel.obtain();
    paramBundle.writeToParcel(localParcel, 0);
    AppMethodBeat.o(140608);
    return localParcel;
  }
  
  public static void V(Runnable paramRunnable)
  {
    AppMethodBeat.i(187609);
    if ((paramRunnable != null) && (koJ != null))
    {
      paramRunnable.run();
      AppMethodBeat.o(187609);
      return;
    }
    if (paramRunnable != null) {}
    synchronized (koP)
    {
      koP.add(paramRunnable);
      if (koK == null) {
        koK = new ServiceConnection()
        {
          public final void onServiceConnected(ComponentName arg1, IBinder paramAnonymousIBinder)
          {
            AppMethodBeat.i(140597);
            AppBrandMainProcessService.a(d.a.q(paramAnonymousIBinder));
            AppBrandMainProcessService.Mw();
            AppBrandMainProcessService.fd(aj.getPackageName());
            try
            {
              AppBrandMainProcessService.bhI().a(new Binder(), aj.getProcessName());
              ad.i("MicroMsg.AppBrandMainProcessService", "onServiceConnected(%s)", new Object[] { aj.getProcessName() });
              AppMethodBeat.o(140597);
            }
            catch (Exception ???)
            {
              synchronized (AppBrandMainProcessService.WP())
              {
                paramAnonymousIBinder = new HashSet(AppBrandMainProcessService.WP());
                AppBrandMainProcessService.WP().clear();
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
            AppBrandMainProcessService.KX(aj.getPackageName());
            AppBrandMainProcessService.bhG();
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
      paramRunnable.bindService((Intent)???, koK, 1);
      AppMethodBeat.o(187609);
      return;
    }
    catch (Exception paramRunnable)
    {
      ad.e("MicroMsg.AppBrandMainProcessService", "bindService() Exception:%s", new Object[] { paramRunnable.getMessage() });
      AppMethodBeat.o(187609);
    }
    paramRunnable = finally;
    AppMethodBeat.o(187609);
    throw paramRunnable;
  }
  
  public static Bundle a(MainProcessTask paramMainProcessTask, boolean paramBoolean)
  {
    AppMethodBeat.i(140609);
    Bundle localBundle = new Bundle(3);
    localBundle.putParcelable("task_object", paramMainProcessTask);
    if (paramBoolean) {
      localBundle.putParcelable("task_client", koO);
    }
    localBundle.putString("task_id", paramMainProcessTask.iFB);
    AppMethodBeat.o(140609);
    return localBundle;
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(140605);
    koQ.add(parama);
    AppMethodBeat.o(140605);
  }
  
  public static void a(MainProcessTask paramMainProcessTask)
  {
    AppMethodBeat.i(140600);
    koM.put(paramMainProcessTask.iFB, new WeakReference(paramMainProcessTask));
    E(a(paramMainProcessTask, true));
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
        localMainProcessTask2.kpZ = ((Messenger)paramBundle.getParcelable("task_client"));
      }
      localMainProcessTask2.iFB = paramBundle.getString("task_id");
      AppMethodBeat.o(140610);
      return localMainProcessTask2;
    }
  }
  
  public static void b(a parama)
  {
    AppMethodBeat.i(140606);
    koQ.remove(parama);
    AppMethodBeat.o(140606);
  }
  
  public static boolean b(MainProcessTask paramMainProcessTask)
  {
    AppMethodBeat.i(140601);
    Bundle localBundle = a(paramMainProcessTask, false);
    if (D(localBundle)) {
      try
      {
        a(b(localBundle, false), paramMainProcessTask);
        paramMainProcessTask.aOB();
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
  
  public static void bhG()
  {
    AppMethodBeat.i(221671);
    V(null);
    AppMethodBeat.o(221671);
  }
  
  public static boolean bhH()
  {
    return koJ != null;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.koI;
  }
  
  public static class a
  {
    public void Ky(String paramString) {}
    
    public void onDisconnected(String paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService
 * JD-Core Version:    0.7.0.1
 */