package com.tencent.mm.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class z
  implements Application.ActivityLifecycleCallbacks
{
  static volatile z fdP;
  public List<b> cSF;
  boolean cvA;
  int fdQ;
  boolean fdR;
  public a fdS;
  
  private z(Context paramContext)
  {
    AppMethodBeat.i(194681);
    this.fdQ = 0;
    this.fdR = false;
    this.cvA = false;
    this.cSF = new LinkedList();
    int i = bM(paramContext);
    if (i != -1)
    {
      if (i <= 100) {
        bool = true;
      }
      this.cvA = bool;
    }
    this.fdS = new a()
    {
      public final List<Class<? extends View>> abe()
      {
        AppMethodBeat.i(193869);
        List localList = Collections.emptyList();
        AppMethodBeat.o(193869);
        return localList;
      }
      
      public final boolean abf()
      {
        return false;
      }
    };
    AppMethodBeat.o(194681);
  }
  
  @SuppressLint({"ObsoleteSdkInt"})
  private static boolean K(List<? extends Class<? extends View>> paramList)
  {
    AppMethodBeat.i(194685);
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(194685);
      return false;
    }
    Iterator localIterator = abd().iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (!paramList.contains(((View)localIterator.next()).getClass()));
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(194685);
      return bool;
    }
  }
  
  public static z abb()
  {
    AppMethodBeat.i(194676);
    if (fdP == null) {
      try
      {
        if (fdP == null)
        {
          IllegalStateException localIllegalStateException = new IllegalStateException("Call #init() first!");
          AppMethodBeat.o(194676);
          throw localIllegalStateException;
        }
      }
      finally
      {
        AppMethodBeat.o(194676);
      }
    }
    z localz = fdP;
    AppMethodBeat.o(194676);
    return localz;
  }
  
  private static List<View> abd()
  {
    AppMethodBeat.i(194689);
    try
    {
      Class localClass = Class.forName("android.view.WindowManagerGlobal");
      Object localObject1 = localClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
      String[] arrayOfString = (String[])localClass.getDeclaredMethod("getViewRootNames", new Class[0]).invoke(localObject1, new Object[0]);
      if (arrayOfString != null)
      {
        ArrayList localArrayList = new ArrayList();
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = arrayOfString[i];
          localObject2 = localClass.getDeclaredMethod("getRootView", new Class[] { String.class }).invoke(localObject1, new Object[] { localObject2 });
          if ((localObject2 instanceof View)) {
            localArrayList.add((View)localObject2);
          }
          i += 1;
        }
        AppMethodBeat.o(194689);
        return localArrayList;
      }
    }
    catch (Throwable localThrowable)
    {
      Log.printErrStackTrace("MicroMsg.ProcForegroundDelegate", localThrowable, "getBallInfoListSync fail!", new Object[0]);
      List localList = Collections.emptyList();
      AppMethodBeat.o(194689);
      return localList;
    }
  }
  
  private static int bM(Context paramContext)
  {
    AppMethodBeat.i(194705);
    Object localObject = (ActivityManager)paramContext.getSystemService("activity");
    if (localObject == null)
    {
      AppMethodBeat.o(194705);
      return -1;
    }
    localObject = ((ActivityManager)localObject).getRunningAppProcesses();
    if (localObject == null)
    {
      AppMethodBeat.o(194705);
      return -1;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      if ((!TextUtils.isEmpty(localRunningAppProcessInfo.processName)) && (localRunningAppProcessInfo.processName.startsWith(paramContext.getPackageName())))
      {
        int i = localRunningAppProcessInfo.importance;
        AppMethodBeat.o(194705);
        return i;
      }
    }
    AppMethodBeat.o(194705);
    return -1;
  }
  
  public static void c(Application paramApplication)
  {
    AppMethodBeat.i(194674);
    if (fdP == null) {
      try
      {
        if (fdP == null)
        {
          fdP = new z(paramApplication);
          paramApplication.registerActivityLifecycleCallbacks(fdP);
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(194674);
      }
    }
    AppMethodBeat.o(194674);
  }
  
  public final boolean abc()
  {
    AppMethodBeat.i(194682);
    if (MMApplicationContext.isMainProcess())
    {
      bool = this.fdS.abf();
      AppMethodBeat.o(194682);
      return bool;
    }
    boolean bool = K(this.fdS.abe());
    AppMethodBeat.o(194682);
    return bool;
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity) {}
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity)
  {
    AppMethodBeat.i(194694);
    paramActivity = paramActivity.getClass().getName() + "@" + paramActivity.hashCode();
    Log.i("MicroMsg.ProcForegroundDelegate", "#onStarted: " + paramActivity + ", refs = " + this.fdQ);
    int i = this.fdQ + 1;
    this.fdQ = i;
    if ((i == 1) && (!this.fdR))
    {
      this.cvA = true;
      Log.i("MicroMsg.ProcForegroundDelegate", "onProcessForeground");
      Iterator localIterator = this.cSF.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        if (localb != null) {
          localb.fm(paramActivity);
        }
      }
    }
    AppMethodBeat.o(194694);
  }
  
  public final void onActivityStopped(Activity paramActivity)
  {
    AppMethodBeat.i(194699);
    String str = paramActivity.getClass().getName() + "@" + paramActivity.hashCode();
    Log.i("MicroMsg.ProcForegroundDelegate", "#onStopped: " + str + ", refs = " + this.fdQ);
    this.fdR = paramActivity.isChangingConfigurations();
    int i = this.fdQ - 1;
    this.fdQ = i;
    if ((i == 0) && (!this.fdR))
    {
      this.cvA = false;
      Log.i("MicroMsg.ProcForegroundDelegate", "onProcessBackground");
      paramActivity = this.cSF.iterator();
      while (paramActivity.hasNext())
      {
        b localb = (b)paramActivity.next();
        if (localb != null) {
          localb.fn(str);
        }
      }
    }
    AppMethodBeat.o(194699);
  }
  
  public static abstract interface a
  {
    public abstract List<? extends Class<? extends View>> abe();
    
    public abstract boolean abf();
  }
  
  public static abstract interface b
  {
    public abstract void fm(String paramString);
    
    public abstract void fn(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.z
 * JD-Core Version:    0.7.0.1
 */