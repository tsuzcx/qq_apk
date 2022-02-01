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
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class AppBrandMainProcessService
  extends Service
{
  private static d lvI;
  private static ServiceConnection lvJ;
  private static final LinkedList<Parcel> lvK;
  private static final Map<String, WeakReference<MainProcessTask>> lvL;
  private static final Handler lvM;
  private static Messenger lvN;
  private static final Set<Runnable> lvO;
  private static final Set<AppBrandMainProcessService.a> lvP;
  private static final ConcurrentHashMap<String, b> lvQ;
  private final HashMap<String, IBinder.DeathRecipient> lvF;
  private final Messenger lvG;
  private final d.a lvH;
  private final Handler mHandler;
  
  static
  {
    AppMethodBeat.i(140616);
    lvK = new LinkedList();
    lvL = new ConcurrentHashMap();
    lvM = new Handler(Looper.getMainLooper())
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
        MainProcessTask localMainProcessTask = AppBrandMainProcessService.YV(paramAnonymousMessage.jEY);
        if (localMainProcessTask == null)
        {
          Log.e("MicroMsg.AppBrandMainProcessService", "receive client msg, get null task by id %s", new Object[] { paramAnonymousMessage.jEY });
          AppMethodBeat.o(140596);
          return;
        }
        AppBrandMainProcessService.b(paramAnonymousMessage, localMainProcessTask);
        localMainProcessTask.bjk();
        AppMethodBeat.o(140596);
      }
    };
    lvN = new Messenger(lvM);
    lvO = new HashSet();
    lvP = Collections.newSetFromMap(new ConcurrentHashMap());
    lvQ = new ConcurrentHashMap();
    AppMethodBeat.o(140616);
  }
  
  public AppBrandMainProcessService()
  {
    AppMethodBeat.i(140599);
    this.lvF = new HashMap();
    this.mHandler = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(final Message paramAnonymousMessage)
      {
        AppMethodBeat.i(140591);
        paramAnonymousMessage = AppBrandMainProcessService.b(paramAnonymousMessage.getData(), true);
        if (paramAnonymousMessage != null) {
          h.RTc.b(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(221213);
              paramAnonymousMessage.bjj();
              AppMethodBeat.o(221213);
            }
          }, "MicroMsg.AppBrandMainProcessService");
        }
        AppMethodBeat.o(140591);
      }
    };
    this.lvG = new Messenger(this.mHandler);
    this.lvH = new d.a()
    {
      public final void N(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(140593);
        Message localMessage = Message.obtain();
        localMessage.setData(paramAnonymousBundle);
        AppBrandMainProcessService.a(AppBrandMainProcessService.this).send(localMessage);
        AppMethodBeat.o(140593);
      }
      
      public final void O(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(140594);
        paramAnonymousBundle = AppBrandMainProcessService.b(paramAnonymousBundle, false);
        if (paramAnonymousBundle != null) {
          paramAnonymousBundle.bjj();
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
            AppBrandMainProcessService.UG(paramAnonymousString);
            Log.e("MicroMsg.AppBrandMainProcessService", "Client Process Died: %s", new Object[] { paramAnonymousString });
            AppMethodBeat.o(140592);
          }
        };
        try
        {
          paramAnonymousIBinder.linkToDeath(local1, 0);
          AppBrandMainProcessService.b(AppBrandMainProcessService.this).put(paramAnonymousString, local1);
          AppBrandMainProcessService.fV(paramAnonymousString);
          AppMethodBeat.o(140595);
          return;
        }
        catch (Exception paramAnonymousIBinder)
        {
          Log.e("MicroMsg.AppBrandMainProcessService", "registerDeathRecipient: %s", new Object[] { paramAnonymousIBinder });
          AppMethodBeat.o(140595);
        }
      }
    };
    AppMethodBeat.o(140599);
  }
  
  private static boolean K(Bundle paramBundle)
  {
    AppMethodBeat.i(140602);
    boolean bool = true;
    try
    {
      lvI.O(paramBundle);
      AppMethodBeat.o(140602);
      return bool;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        bool = false;
        Log.e("MicroMsg.AppBrandMainProcessService", paramBundle.getMessage());
      }
    }
  }
  
  private static void L(Bundle paramBundle)
  {
    AppMethodBeat.i(140603);
    if (lvI == null)
    {
      Y(null);
      synchronized (lvK)
      {
        lvK.add(M(paramBundle));
        AppMethodBeat.o(140603);
        return;
      }
    }
    try
    {
      lvI.N(paramBundle);
      AppMethodBeat.o(140603);
      return;
    }
    catch (Exception paramBundle)
    {
      Log.e("MicroMsg.AppBrandMainProcessService", paramBundle.getMessage());
      AppMethodBeat.o(140603);
    }
  }
  
  private static Parcel M(Bundle paramBundle)
  {
    AppMethodBeat.i(140608);
    Parcel localParcel = Parcel.obtain();
    paramBundle.writeToParcel(localParcel, 0);
    AppMethodBeat.o(140608);
    return localParcel;
  }
  
  public static void Y(Runnable paramRunnable)
  {
    AppMethodBeat.i(221217);
    if ((paramRunnable != null) && (lvI != null))
    {
      paramRunnable.run();
      AppMethodBeat.o(221217);
      return;
    }
    if (paramRunnable != null) {}
    synchronized (lvO)
    {
      lvO.add(paramRunnable);
      if (lvJ == null) {
        lvJ = new ServiceConnection()
        {
          public final void onServiceConnected(ComponentName arg1, IBinder paramAnonymousIBinder)
          {
            AppMethodBeat.i(140597);
            AppBrandMainProcessService.a(d.a.r(paramAnonymousIBinder));
            AppBrandMainProcessService.WB();
            AppBrandMainProcessService.fV(MMApplicationContext.getPackageName());
            try
            {
              AppBrandMainProcessService.bDE().a(new Binder(), MMApplicationContext.getProcessName());
              Log.i("MicroMsg.AppBrandMainProcessService", "onServiceConnected(%s)", new Object[] { MMApplicationContext.getProcessName() });
              AppMethodBeat.o(140597);
            }
            catch (Exception ???)
            {
              synchronized (AppBrandMainProcessService.akK())
              {
                paramAnonymousIBinder = new HashSet(AppBrandMainProcessService.akK());
                AppBrandMainProcessService.akK().clear();
                ??? = paramAnonymousIBinder.iterator();
                while (???.hasNext())
                {
                  paramAnonymousIBinder = (Runnable)???.next();
                  if (paramAnonymousIBinder != null)
                  {
                    paramAnonymousIBinder.run();
                    continue;
                    ??? = ???;
                    Log.e("MicroMsg.AppBrandMainProcessService", "onServiceConnected, registerDeathRecipient, %s", new Object[] { ??? });
                  }
                }
              }
            }
          }
          
          public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
          {
            AppMethodBeat.i(140598);
            AppBrandMainProcessService.a(null);
            AppBrandMainProcessService.UG(MMApplicationContext.getPackageName());
            AppBrandMainProcessService.bDD();
            Log.i("MicroMsg.AppBrandMainProcessService", "onServiceDisconnected(%s)", new Object[] { MMApplicationContext.getProcessName() });
            AppMethodBeat.o(140598);
          }
        };
      }
      Log.i("MicroMsg.AppBrandMainProcessService", "tryBindService");
      paramRunnable = MMApplicationContext.getContext();
      ??? = new Intent(paramRunnable, AppBrandMainProcessService.class);
    }
    try
    {
      paramRunnable.bindService((Intent)???, lvJ, 1);
      AppMethodBeat.o(221217);
      return;
    }
    catch (Exception paramRunnable)
    {
      Log.e("MicroMsg.AppBrandMainProcessService", "bindService() Exception:%s", new Object[] { paramRunnable.getMessage() });
      AppMethodBeat.o(221217);
    }
    paramRunnable = finally;
    AppMethodBeat.o(221217);
    throw paramRunnable;
  }
  
  private static MainProcessTask YT(String paramString)
  {
    AppMethodBeat.i(221215);
    synchronized (lvL)
    {
      Object localObject = (WeakReference)lvL.get(paramString);
      if (localObject == null)
      {
        localObject = null;
        if (localObject == null) {
          lvL.remove(paramString);
        }
        AppMethodBeat.o(221215);
        return localObject;
      }
      localObject = (MainProcessTask)((WeakReference)localObject).get();
    }
  }
  
  private static void YU(String paramString)
  {
    AppMethodBeat.i(221218);
    Iterator localIterator = lvP.iterator();
    while (localIterator.hasNext()) {
      ((AppBrandMainProcessService.a)localIterator.next()).Uf(paramString);
    }
    AppMethodBeat.o(221218);
  }
  
  public static Bundle a(MainProcessTask paramMainProcessTask, boolean paramBoolean)
  {
    AppMethodBeat.i(140609);
    Bundle localBundle = new Bundle(3);
    localBundle.putParcelable("task_object", paramMainProcessTask);
    if (paramBoolean) {
      localBundle.putParcelable("task_client", lvN);
    }
    localBundle.putString("task_id", paramMainProcessTask.jEY);
    AppMethodBeat.o(140609);
    return localBundle;
  }
  
  public static void a(AppBrandMainProcessService.a parama)
  {
    AppMethodBeat.i(140605);
    lvP.add(parama);
    if (lvQ.size() != 0)
    {
      parama = lvQ.entrySet().iterator();
      while (parama.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)parama.next();
        if (((b)localEntry.getValue()).aMp) {
          YU((String)localEntry.getKey());
        }
      }
    }
    AppMethodBeat.o(140605);
  }
  
  public static void a(MainProcessTask paramMainProcessTask)
  {
    AppMethodBeat.i(140600);
    c(paramMainProcessTask);
    L(a(paramMainProcessTask, true));
    AppMethodBeat.o(140600);
  }
  
  private static void a(MainProcessTask paramMainProcessTask1, MainProcessTask paramMainProcessTask2)
  {
    AppMethodBeat.i(140607);
    Parcel localParcel = Parcel.obtain();
    paramMainProcessTask1.writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    paramMainProcessTask2.f(localParcel);
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
        Log.e("MicroMsg.AppBrandMainProcessService", "convertBundleToTask e=%s", new Object[] { localClassCastException });
        localMainProcessTask2 = null;
      }
      if (paramBoolean) {
        localMainProcessTask2.lxa = ((Messenger)paramBundle.getParcelable("task_client"));
      }
      localMainProcessTask2.jEY = paramBundle.getString("task_id");
      AppMethodBeat.o(140610);
      return localMainProcessTask2;
    }
  }
  
  public static void b(AppBrandMainProcessService.a parama)
  {
    AppMethodBeat.i(140606);
    lvP.remove(parama);
    AppMethodBeat.o(140606);
  }
  
  public static boolean b(MainProcessTask paramMainProcessTask)
  {
    AppMethodBeat.i(140601);
    Bundle localBundle = a(paramMainProcessTask, false);
    if (K(localBundle)) {
      try
      {
        a(b(localBundle, false), paramMainProcessTask);
        paramMainProcessTask.bjk();
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
  
  public static void bDD()
  {
    AppMethodBeat.i(258650);
    Y(null);
    AppMethodBeat.o(258650);
  }
  
  static void c(MainProcessTask paramMainProcessTask)
  {
    AppMethodBeat.i(221214);
    synchronized (lvL)
    {
      lvL.put(paramMainProcessTask.jEY, new WeakReference(paramMainProcessTask));
      AppMethodBeat.o(221214);
      return;
    }
  }
  
  public static boolean isLive()
  {
    return lvI != null;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.lvH;
  }
  
  static final class b
  {
    public boolean aMp;
    public String processName;
    
    public b(String paramString)
    {
      this.processName = paramString;
      this.aMp = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService
 * JD-Core Version:    0.7.0.1
 */