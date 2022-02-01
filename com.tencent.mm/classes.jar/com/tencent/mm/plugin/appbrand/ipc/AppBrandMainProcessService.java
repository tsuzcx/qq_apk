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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
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
  private static d krZ;
  private static ServiceConnection ksa;
  private static final LinkedList<Parcel> ksb;
  private static Map<String, WeakReference<MainProcessTask>> ksc;
  private static final Handler ksd;
  private static Messenger kse;
  private static final Set<Runnable> ksf;
  private static final Set<a> ksg;
  private final HashMap<String, IBinder.DeathRecipient> krW;
  private final Messenger krX;
  private final d.a krY;
  private final Handler mHandler;
  
  static
  {
    AppMethodBeat.i(140616);
    ksb = new LinkedList();
    ksc = new ConcurrentHashMap();
    ksd = new Handler(Looper.getMainLooper())
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
        MainProcessTask localMainProcessTask = AppBrandMainProcessService.PG(paramAnonymousMessage.iIu);
        if (localMainProcessTask == null)
        {
          ae.e("MicroMsg.AppBrandMainProcessService", "receive client msg, get null task by id %s", new Object[] { paramAnonymousMessage.iIu });
          AppMethodBeat.o(140596);
          return;
        }
        AppBrandMainProcessService.b(paramAnonymousMessage, localMainProcessTask);
        localMainProcessTask.aOY();
        AppMethodBeat.o(140596);
      }
    };
    kse = new Messenger(ksd);
    ksf = new HashSet();
    ksg = Collections.newSetFromMap(new ConcurrentHashMap());
    AppMethodBeat.o(140616);
  }
  
  public AppBrandMainProcessService()
  {
    AppMethodBeat.i(140599);
    this.krW = new HashMap();
    this.mHandler = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(final Message paramAnonymousMessage)
      {
        AppMethodBeat.i(140591);
        paramAnonymousMessage = AppBrandMainProcessService.b(paramAnonymousMessage.getData(), true);
        if (paramAnonymousMessage != null) {
          h.MqF.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(201174);
              paramAnonymousMessage.aOX();
              AppMethodBeat.o(201174);
            }
          }, "MicroMsg.AppBrandMainProcessService");
        }
        AppMethodBeat.o(140591);
      }
    };
    this.krX = new Messenger(this.mHandler);
    this.krY = new d.a()
    {
      public final void H(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(140593);
        Message localMessage = Message.obtain();
        localMessage.setData(paramAnonymousBundle);
        AppBrandMainProcessService.a(AppBrandMainProcessService.this).send(localMessage);
        AppMethodBeat.o(140593);
      }
      
      public final void I(Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(140594);
        paramAnonymousBundle = AppBrandMainProcessService.b(paramAnonymousBundle, false);
        if (paramAnonymousBundle != null) {
          paramAnonymousBundle.aOX();
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
            AppBrandMainProcessService.Lx(paramAnonymousString);
            ae.e("MicroMsg.AppBrandMainProcessService", "Client Process Died: %s", new Object[] { paramAnonymousString });
            AppMethodBeat.o(140592);
          }
        };
        try
        {
          paramAnonymousIBinder.linkToDeath(local1, 0);
          AppBrandMainProcessService.b(AppBrandMainProcessService.this).put(paramAnonymousString, local1);
          AppBrandMainProcessService.fi(paramAnonymousString);
          AppMethodBeat.o(140595);
          return;
        }
        catch (Exception paramAnonymousIBinder)
        {
          ae.e("MicroMsg.AppBrandMainProcessService", "registerDeathRecipient: %s", new Object[] { paramAnonymousIBinder });
          AppMethodBeat.o(140595);
        }
      }
    };
    AppMethodBeat.o(140599);
  }
  
  private static boolean E(Bundle paramBundle)
  {
    AppMethodBeat.i(140602);
    boolean bool = true;
    try
    {
      krZ.I(paramBundle);
      AppMethodBeat.o(140602);
      return bool;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        bool = false;
        ae.e("MicroMsg.AppBrandMainProcessService", paramBundle.getMessage());
      }
    }
  }
  
  private static void F(Bundle paramBundle)
  {
    AppMethodBeat.i(140603);
    if (krZ == null)
    {
      T(null);
      synchronized (ksb)
      {
        ksb.add(G(paramBundle));
        AppMethodBeat.o(140603);
        return;
      }
    }
    try
    {
      krZ.H(paramBundle);
      AppMethodBeat.o(140603);
      return;
    }
    catch (Exception paramBundle)
    {
      ae.e("MicroMsg.AppBrandMainProcessService", paramBundle.getMessage());
      AppMethodBeat.o(140603);
    }
  }
  
  private static Parcel G(Bundle paramBundle)
  {
    AppMethodBeat.i(140608);
    Parcel localParcel = Parcel.obtain();
    paramBundle.writeToParcel(localParcel, 0);
    AppMethodBeat.o(140608);
    return localParcel;
  }
  
  public static void T(Runnable paramRunnable)
  {
    AppMethodBeat.i(201176);
    if ((paramRunnable != null) && (krZ != null))
    {
      paramRunnable.run();
      AppMethodBeat.o(201176);
      return;
    }
    if (paramRunnable != null) {}
    synchronized (ksf)
    {
      ksf.add(paramRunnable);
      if (ksa == null) {
        ksa = new ServiceConnection()
        {
          public final void onServiceConnected(ComponentName arg1, IBinder paramAnonymousIBinder)
          {
            AppMethodBeat.i(140597);
            AppBrandMainProcessService.a(d.a.r(paramAnonymousIBinder));
            AppBrandMainProcessService.biq();
            AppBrandMainProcessService.fi(ak.getPackageName());
            try
            {
              AppBrandMainProcessService.bir().a(new Binder(), ak.getProcessName());
              ae.i("MicroMsg.AppBrandMainProcessService", "onServiceConnected(%s)", new Object[] { ak.getProcessName() });
              AppMethodBeat.o(140597);
            }
            catch (Exception ???)
            {
              synchronized (AppBrandMainProcessService.WX())
              {
                paramAnonymousIBinder = new HashSet(AppBrandMainProcessService.WX());
                AppBrandMainProcessService.WX().clear();
                ??? = paramAnonymousIBinder.iterator();
                while (???.hasNext())
                {
                  paramAnonymousIBinder = (Runnable)???.next();
                  if (paramAnonymousIBinder != null)
                  {
                    paramAnonymousIBinder.run();
                    continue;
                    ??? = ???;
                    ae.e("MicroMsg.AppBrandMainProcessService", "onServiceConnected, registerDeathRecipient, %s", new Object[] { ??? });
                  }
                }
              }
            }
          }
          
          public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
          {
            AppMethodBeat.i(140598);
            AppBrandMainProcessService.a(null);
            AppBrandMainProcessService.Lx(ak.getPackageName());
            AppBrandMainProcessService.bio();
            ae.i("MicroMsg.AppBrandMainProcessService", "onServiceDisconnected(%s)", new Object[] { ak.getProcessName() });
            AppMethodBeat.o(140598);
          }
        };
      }
      ae.i("MicroMsg.AppBrandMainProcessService", "tryBindService");
      paramRunnable = ak.getContext();
      ??? = new Intent(paramRunnable, AppBrandMainProcessService.class);
    }
    try
    {
      paramRunnable.bindService((Intent)???, ksa, 1);
      AppMethodBeat.o(201176);
      return;
    }
    catch (Exception paramRunnable)
    {
      ae.e("MicroMsg.AppBrandMainProcessService", "bindService() Exception:%s", new Object[] { paramRunnable.getMessage() });
      AppMethodBeat.o(201176);
    }
    paramRunnable = finally;
    AppMethodBeat.o(201176);
    throw paramRunnable;
  }
  
  public static Bundle a(MainProcessTask paramMainProcessTask, boolean paramBoolean)
  {
    AppMethodBeat.i(140609);
    Bundle localBundle = new Bundle(3);
    localBundle.putParcelable("task_object", paramMainProcessTask);
    if (paramBoolean) {
      localBundle.putParcelable("task_client", kse);
    }
    localBundle.putString("task_id", paramMainProcessTask.iIu);
    AppMethodBeat.o(140609);
    return localBundle;
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(140605);
    ksg.add(parama);
    AppMethodBeat.o(140605);
  }
  
  public static void a(MainProcessTask paramMainProcessTask)
  {
    AppMethodBeat.i(140600);
    ksc.put(paramMainProcessTask.iIu, new WeakReference(paramMainProcessTask));
    F(a(paramMainProcessTask, true));
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
        ae.e("MicroMsg.AppBrandMainProcessService", "convertBundleToTask e=%s", new Object[] { localClassCastException });
        localMainProcessTask2 = null;
      }
      if (paramBoolean) {
        localMainProcessTask2.kto = ((Messenger)paramBundle.getParcelable("task_client"));
      }
      localMainProcessTask2.iIu = paramBundle.getString("task_id");
      AppMethodBeat.o(140610);
      return localMainProcessTask2;
    }
  }
  
  public static void b(a parama)
  {
    AppMethodBeat.i(140606);
    ksg.remove(parama);
    AppMethodBeat.o(140606);
  }
  
  public static boolean b(MainProcessTask paramMainProcessTask)
  {
    AppMethodBeat.i(140601);
    Bundle localBundle = a(paramMainProcessTask, false);
    if (E(localBundle)) {
      try
      {
        a(b(localBundle, false), paramMainProcessTask);
        paramMainProcessTask.aOY();
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
  
  public static void bio()
  {
    AppMethodBeat.i(224447);
    T(null);
    AppMethodBeat.o(224447);
  }
  
  public static boolean bip()
  {
    return krZ != null;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.krY;
  }
  
  public static class a
  {
    public void KW(String paramString) {}
    
    public void onDisconnected(String paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService
 * JD-Core Version:    0.7.0.1
 */