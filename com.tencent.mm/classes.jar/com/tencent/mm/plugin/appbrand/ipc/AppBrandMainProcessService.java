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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
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
  private static Messenger jUA;
  private static final Set<Runnable> jUB;
  private static final Set<a> jUC;
  private static d jUv;
  private static ServiceConnection jUw;
  private static final LinkedList<Parcel> jUx;
  private static Map<String, WeakReference<MainProcessTask>> jUy;
  private static final Handler jUz;
  private final HashMap<String, IBinder.DeathRecipient> jUs;
  private final Messenger jUt;
  private final d.a jUu;
  private final Handler mHandler;
  
  static
  {
    AppMethodBeat.i(140616);
    jUx = new LinkedList();
    jUy = new ConcurrentHashMap();
    jUz = new Handler(Looper.getMainLooper())
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
        MainProcessTask localMainProcessTask = AppBrandMainProcessService.LE(paramAnonymousMessage.imk);
        if (localMainProcessTask == null)
        {
          ac.e("MicroMsg.AppBrandMainProcessService", "receive client msg, get null task by id %s", new Object[] { paramAnonymousMessage.imk });
          AppMethodBeat.o(140596);
          return;
        }
        AppBrandMainProcessService.b(paramAnonymousMessage, localMainProcessTask);
        localMainProcessTask.aLr();
        AppMethodBeat.o(140596);
      }
    };
    jUA = new Messenger(jUz);
    jUB = new HashSet();
    jUC = Collections.newSetFromMap(new ConcurrentHashMap());
    AppMethodBeat.o(140616);
  }
  
  public AppBrandMainProcessService()
  {
    AppMethodBeat.i(140599);
    this.jUs = new HashMap();
    this.mHandler = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(final Message paramAnonymousMessage)
      {
        AppMethodBeat.i(140591);
        paramAnonymousMessage = AppBrandMainProcessService.b(paramAnonymousMessage.getData(), true);
        if (paramAnonymousMessage != null) {
          h.JZN.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(200933);
              paramAnonymousMessage.aLq();
              AppMethodBeat.o(200933);
            }
          }, "MicroMsg.AppBrandMainProcessService");
        }
        AppMethodBeat.o(140591);
      }
    };
    this.jUt = new Messenger(this.mHandler);
    this.jUu = new d.a()
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
          paramAnonymousBundle.aLq();
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
            AppBrandMainProcessService.HG(paramAnonymousString);
            ac.e("MicroMsg.AppBrandMainProcessService", "Client Process Died: %s", new Object[] { paramAnonymousString });
            AppMethodBeat.o(140592);
          }
        };
        try
        {
          paramAnonymousIBinder.linkToDeath(local1, 0);
          AppBrandMainProcessService.b(AppBrandMainProcessService.this).put(paramAnonymousString, local1);
          AppBrandMainProcessService.ei(paramAnonymousString);
          AppMethodBeat.o(140595);
          return;
        }
        catch (Exception paramAnonymousIBinder)
        {
          ac.e("MicroMsg.AppBrandMainProcessService", "registerDeathRecipient: %s", new Object[] { paramAnonymousIBinder });
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
      jUv.G(paramBundle);
      AppMethodBeat.o(140602);
      return bool;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        bool = false;
        ac.e("MicroMsg.AppBrandMainProcessService", paramBundle.getMessage());
      }
    }
  }
  
  private static void D(Bundle paramBundle)
  {
    AppMethodBeat.i(140603);
    if (jUv == null)
    {
      W(null);
      synchronized (jUx)
      {
        jUx.add(E(paramBundle));
        AppMethodBeat.o(140603);
        return;
      }
    }
    try
    {
      jUv.F(paramBundle);
      AppMethodBeat.o(140603);
      return;
    }
    catch (Exception paramBundle)
    {
      ac.e("MicroMsg.AppBrandMainProcessService", paramBundle.getMessage());
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
  
  public static void W(Runnable paramRunnable)
  {
    AppMethodBeat.i(200935);
    if ((paramRunnable != null) && (jUv != null))
    {
      paramRunnable.run();
      AppMethodBeat.o(200935);
      return;
    }
    if (paramRunnable != null) {}
    synchronized (jUB)
    {
      jUB.add(paramRunnable);
      if (jUw == null) {
        jUw = new ServiceConnection()
        {
          public final void onServiceConnected(ComponentName arg1, IBinder paramAnonymousIBinder)
          {
            AppMethodBeat.i(140597);
            AppBrandMainProcessService.a(d.a.q(paramAnonymousIBinder));
            AppBrandMainProcessService.KP();
            AppBrandMainProcessService.ei(ai.getPackageName());
            try
            {
              AppBrandMainProcessService.bee().a(new Binder(), ai.getProcessName());
              ac.i("MicroMsg.AppBrandMainProcessService", "onServiceConnected(%s)", new Object[] { ai.getProcessName() });
              AppMethodBeat.o(140597);
            }
            catch (Exception ???)
            {
              synchronized (AppBrandMainProcessService.Uy())
              {
                paramAnonymousIBinder = new HashSet(AppBrandMainProcessService.Uy());
                AppBrandMainProcessService.Uy().clear();
                ??? = paramAnonymousIBinder.iterator();
                while (???.hasNext())
                {
                  paramAnonymousIBinder = (Runnable)???.next();
                  if (paramAnonymousIBinder != null)
                  {
                    paramAnonymousIBinder.run();
                    continue;
                    ??? = ???;
                    ac.e("MicroMsg.AppBrandMainProcessService", "onServiceConnected, registerDeathRecipient, %s", new Object[] { ??? });
                  }
                }
              }
            }
          }
          
          public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
          {
            AppMethodBeat.i(140598);
            AppBrandMainProcessService.a(null);
            AppBrandMainProcessService.HG(ai.getPackageName());
            AppBrandMainProcessService.bec();
            ac.i("MicroMsg.AppBrandMainProcessService", "onServiceDisconnected(%s)", new Object[] { ai.getProcessName() });
            AppMethodBeat.o(140598);
          }
        };
      }
      ac.i("MicroMsg.AppBrandMainProcessService", "tryBindService");
      paramRunnable = ai.getContext();
      ??? = new Intent(paramRunnable, AppBrandMainProcessService.class);
    }
    try
    {
      paramRunnable.bindService((Intent)???, jUw, 1);
      AppMethodBeat.o(200935);
      return;
    }
    catch (Exception paramRunnable)
    {
      ac.e("MicroMsg.AppBrandMainProcessService", "bindService() Exception:%s", new Object[] { paramRunnable.getMessage() });
      AppMethodBeat.o(200935);
    }
    paramRunnable = finally;
    AppMethodBeat.o(200935);
    throw paramRunnable;
  }
  
  public static Bundle a(MainProcessTask paramMainProcessTask, boolean paramBoolean)
  {
    AppMethodBeat.i(140609);
    Bundle localBundle = new Bundle(3);
    localBundle.putParcelable("task_object", paramMainProcessTask);
    if (paramBoolean) {
      localBundle.putParcelable("task_client", jUA);
    }
    localBundle.putString("task_id", paramMainProcessTask.imk);
    AppMethodBeat.o(140609);
    return localBundle;
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(140605);
    jUC.add(parama);
    AppMethodBeat.o(140605);
  }
  
  public static void a(MainProcessTask paramMainProcessTask)
  {
    AppMethodBeat.i(140600);
    jUy.put(paramMainProcessTask.imk, new WeakReference(paramMainProcessTask));
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
        ac.e("MicroMsg.AppBrandMainProcessService", "convertBundleToTask e=%s", new Object[] { localClassCastException });
        localMainProcessTask2 = null;
      }
      if (paramBoolean) {
        localMainProcessTask2.jVL = ((Messenger)paramBundle.getParcelable("task_client"));
      }
      localMainProcessTask2.imk = paramBundle.getString("task_id");
      AppMethodBeat.o(140610);
      return localMainProcessTask2;
    }
  }
  
  public static void b(a parama)
  {
    AppMethodBeat.i(140606);
    jUC.remove(parama);
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
        paramMainProcessTask.aLr();
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
  
  public static void bec()
  {
    AppMethodBeat.i(210331);
    W(null);
    AppMethodBeat.o(210331);
  }
  
  public static boolean bed()
  {
    return jUv != null;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.jUu;
  }
  
  public static class a
  {
    public void Hk(String paramString) {}
    
    public void onDisconnected(String paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService
 * JD-Core Version:    0.7.0.1
 */