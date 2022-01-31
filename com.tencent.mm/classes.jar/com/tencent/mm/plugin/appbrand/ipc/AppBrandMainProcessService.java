package com.tencent.mm.plugin.appbrand.ipc;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Looper;
import android.os.Messenger;
import android.os.Parcel;
import com.tencent.mm.plugin.appbrand.u.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class AppBrandMainProcessService
  extends Service
{
  private static c gdI;
  private static ServiceConnection gdJ;
  private static final LinkedList<Parcel> gdK = new LinkedList();
  private static Map<String, WeakReference<MainProcessTask>> gdL = new ConcurrentHashMap();
  private static final Handler gdM = new AppBrandMainProcessService.3(Looper.getMainLooper());
  private static Messenger gdN = new Messenger(gdM);
  private static final Set<AppBrandMainProcessService.a> gdO = Collections.newSetFromMap(new ConcurrentHashMap());
  private final HashMap<String, IBinder.DeathRecipient> gdF = new HashMap();
  private final Messenger gdG = new Messenger(this.mHandler);
  private final c.a gdH = new AppBrandMainProcessService.2(this);
  private final Handler mHandler = new AppBrandMainProcessService.1(this, n.DS().mnU.getLooper());
  
  static Bundle a(MainProcessTask paramMainProcessTask, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle(3);
    localBundle.putParcelable("task_object", paramMainProcessTask);
    if (paramBoolean) {
      localBundle.putParcelable("task_client", gdN);
    }
    localBundle.putString("task_id", paramMainProcessTask.gep);
    return localBundle;
  }
  
  private static MainProcessTask a(Bundle paramBundle, boolean paramBoolean)
  {
    paramBundle.setClassLoader(MainProcessTask.class.getClassLoader());
    MainProcessTask localMainProcessTask = (MainProcessTask)paramBundle.getParcelable("task_object");
    if (paramBoolean) {
      localMainProcessTask.geD = ((Messenger)paramBundle.getParcelable("task_client"));
    }
    localMainProcessTask.gep = paramBundle.getString("task_id");
    return localMainProcessTask;
  }
  
  public static void a(AppBrandMainProcessService.a parama)
  {
    gdO.add(parama);
  }
  
  public static void a(MainProcessTask paramMainProcessTask)
  {
    gdL.put(paramMainProcessTask.gep, new WeakReference(paramMainProcessTask));
    r(a(paramMainProcessTask, true));
  }
  
  private static void a(MainProcessTask paramMainProcessTask1, MainProcessTask paramMainProcessTask2)
  {
    Parcel localParcel = Parcel.obtain();
    paramMainProcessTask1.writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    paramMainProcessTask2.e(localParcel);
    localParcel.recycle();
  }
  
  public static void aht()
  {
    if (gdJ == null) {
      gdJ = new AppBrandMainProcessService.4();
    }
    y.i("MicroMsg.AppBrandMainProcessService", "tryBindService");
    Context localContext = ae.getContext();
    localContext.bindService(new Intent(localContext, AppBrandMainProcessService.class), gdJ, 1);
  }
  
  public static void b(AppBrandMainProcessService.a parama)
  {
    gdO.remove(parama);
  }
  
  public static boolean b(MainProcessTask paramMainProcessTask)
  {
    boolean bool = false;
    Bundle localBundle = a(paramMainProcessTask, false);
    if (q(localBundle))
    {
      a(a(localBundle, false), paramMainProcessTask);
      paramMainProcessTask.Zv();
      bool = true;
    }
    return bool;
  }
  
  private static boolean q(Bundle paramBundle)
  {
    try
    {
      gdI.t(paramBundle);
      return true;
    }
    catch (Exception paramBundle)
    {
      y.e("MicroMsg.AppBrandMainProcessService", paramBundle.getMessage());
    }
    return false;
  }
  
  private static void r(Bundle paramBundle)
  {
    if (gdI == null)
    {
      aht();
      synchronized (gdK)
      {
        LinkedList localLinkedList2 = gdK;
        Parcel localParcel = Parcel.obtain();
        paramBundle.writeToParcel(localParcel, 0);
        localLinkedList2.add(localParcel);
        return;
      }
    }
    try
    {
      gdI.s(paramBundle);
      return;
    }
    catch (Exception paramBundle)
    {
      y.e("MicroMsg.AppBrandMainProcessService", paramBundle.getMessage());
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.gdH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService
 * JD-Core Version:    0.7.0.1
 */