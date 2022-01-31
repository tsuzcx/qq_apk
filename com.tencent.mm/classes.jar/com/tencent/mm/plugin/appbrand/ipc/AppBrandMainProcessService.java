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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
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
  private static c hvF;
  private static ServiceConnection hvG;
  private static final LinkedList<Parcel> hvH;
  private static Map<String, WeakReference<MainProcessTask>> hvI;
  private static final Handler hvJ;
  private static Messenger hvK;
  private static final Set<AppBrandMainProcessService.a> hvL;
  private final HashMap<String, IBinder.DeathRecipient> hvC;
  private final Messenger hvD;
  private final c.a hvE;
  private final Handler mHandler;
  
  static
  {
    AppMethodBeat.i(91006);
    hvH = new LinkedList();
    hvI = new ConcurrentHashMap();
    hvJ = new AppBrandMainProcessService.3(Looper.getMainLooper());
    hvK = new Messenger(hvJ);
    hvL = Collections.newSetFromMap(new ConcurrentHashMap());
    AppMethodBeat.o(91006);
  }
  
  public AppBrandMainProcessService()
  {
    AppMethodBeat.i(90988);
    this.hvC = new HashMap();
    this.mHandler = new AppBrandMainProcessService.1(this, m.aNS().oNc.getLooper());
    this.hvD = new Messenger(this.mHandler);
    this.hvE = new AppBrandMainProcessService.2(this);
    AppMethodBeat.o(90988);
  }
  
  private static Parcel A(Bundle paramBundle)
  {
    AppMethodBeat.i(90997);
    Parcel localParcel = Parcel.obtain();
    paramBundle.writeToParcel(localParcel, 0);
    AppMethodBeat.o(90997);
    return localParcel;
  }
  
  public static Bundle a(MainProcessTask paramMainProcessTask, boolean paramBoolean)
  {
    AppMethodBeat.i(90998);
    Bundle localBundle = new Bundle(3);
    localBundle.putParcelable("task_object", paramMainProcessTask);
    if (paramBoolean) {
      localBundle.putParcelable("task_client", hvK);
    }
    localBundle.putString("task_id", paramMainProcessTask.hwp);
    AppMethodBeat.o(90998);
    return localBundle;
  }
  
  public static void a(AppBrandMainProcessService.a parama)
  {
    AppMethodBeat.i(90994);
    hvL.add(parama);
    AppMethodBeat.o(90994);
  }
  
  public static void a(MainProcessTask paramMainProcessTask)
  {
    AppMethodBeat.i(90989);
    hvI.put(paramMainProcessTask.hwp, new WeakReference(paramMainProcessTask));
    z(a(paramMainProcessTask, true));
    AppMethodBeat.o(90989);
  }
  
  private static void a(MainProcessTask paramMainProcessTask1, MainProcessTask paramMainProcessTask2)
  {
    AppMethodBeat.i(90996);
    Parcel localParcel = Parcel.obtain();
    paramMainProcessTask1.writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    paramMainProcessTask2.f(localParcel);
    localParcel.recycle();
    AppMethodBeat.o(90996);
  }
  
  public static void aBa()
  {
    AppMethodBeat.i(90993);
    if (hvG == null) {
      hvG = new AppBrandMainProcessService.4();
    }
    ab.i("MicroMsg.AppBrandMainProcessService", "tryBindService");
    Context localContext = ah.getContext();
    Intent localIntent = new Intent(localContext, AppBrandMainProcessService.class);
    try
    {
      localContext.bindService(localIntent, hvG, 1);
      AppMethodBeat.o(90993);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.AppBrandMainProcessService", "bindService() Exception:%s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(90993);
    }
  }
  
  public static MainProcessTask b(Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(90999);
    paramBundle.setClassLoader(MainProcessTask.class.getClassLoader());
    MainProcessTask localMainProcessTask = (MainProcessTask)paramBundle.getParcelable("task_object");
    if (localMainProcessTask == null)
    {
      AppMethodBeat.o(90999);
      return null;
    }
    if (paramBoolean) {
      localMainProcessTask.hwC = ((Messenger)paramBundle.getParcelable("task_client"));
    }
    localMainProcessTask.hwp = paramBundle.getString("task_id");
    AppMethodBeat.o(90999);
    return localMainProcessTask;
  }
  
  public static void b(AppBrandMainProcessService.a parama)
  {
    AppMethodBeat.i(90995);
    hvL.remove(parama);
    AppMethodBeat.o(90995);
  }
  
  public static boolean b(MainProcessTask paramMainProcessTask)
  {
    AppMethodBeat.i(90990);
    Bundle localBundle = a(paramMainProcessTask, false);
    if (y(localBundle)) {
      try
      {
        a(b(localBundle, false), paramMainProcessTask);
        paramMainProcessTask.atb();
        AppMethodBeat.o(90990);
        return true;
      }
      catch (NullPointerException paramMainProcessTask)
      {
        AppMethodBeat.o(90990);
        return false;
      }
    }
    AppMethodBeat.o(90990);
    return false;
  }
  
  private static boolean y(Bundle paramBundle)
  {
    AppMethodBeat.i(90991);
    boolean bool = true;
    try
    {
      hvF.C(paramBundle);
      AppMethodBeat.o(90991);
      return bool;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        bool = false;
        ab.e("MicroMsg.AppBrandMainProcessService", paramBundle.getMessage());
      }
    }
  }
  
  private static void z(Bundle paramBundle)
  {
    AppMethodBeat.i(90992);
    if (hvF == null)
    {
      aBa();
      synchronized (hvH)
      {
        hvH.add(A(paramBundle));
        AppMethodBeat.o(90992);
        return;
      }
    }
    try
    {
      hvF.B(paramBundle);
      AppMethodBeat.o(90992);
      return;
    }
    catch (Exception paramBundle)
    {
      ab.e("MicroMsg.AppBrandMainProcessService", paramBundle.getMessage());
      AppMethodBeat.o(90992);
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return this.hvE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService
 * JD-Core Version:    0.7.0.1
 */