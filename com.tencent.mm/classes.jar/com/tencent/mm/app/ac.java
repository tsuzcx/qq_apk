package com.tencent.mm.app;

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
import java.util.ListIterator;

public final class ac
  implements Application.ActivityLifecycleCallbacks
{
  static volatile ac hhF;
  final List<b> eNV;
  public boolean eny;
  int hhG;
  boolean hhH;
  public a hhI;
  
  private ac(Context paramContext)
  {
    AppMethodBeat.i(239169);
    this.hhG = 0;
    this.hhH = false;
    this.eny = false;
    this.eNV = new LinkedList();
    int i = cz(paramContext);
    if (i != -1)
    {
      if (i <= 100) {
        bool = true;
      }
      this.eny = bool;
    }
    this.hhI = new a()
    {
      public final List<Class<? extends View>> aCQ()
      {
        AppMethodBeat.i(239272);
        List localList = Collections.emptyList();
        AppMethodBeat.o(239272);
        return localList;
      }
      
      public final boolean aCR()
      {
        return false;
      }
    };
    AppMethodBeat.o(239169);
  }
  
  public static ac aCN()
  {
    AppMethodBeat.i(239165);
    if (hhF == null) {
      try
      {
        if (hhF == null)
        {
          IllegalStateException localIllegalStateException = new IllegalStateException("Call #init() first!");
          AppMethodBeat.o(239165);
          throw localIllegalStateException;
        }
      }
      finally
      {
        AppMethodBeat.o(239165);
      }
    }
    ac localac = hhF;
    AppMethodBeat.o(239165);
    return localac;
  }
  
  private static List<View> aCP()
  {
    AppMethodBeat.i(239196);
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
        AppMethodBeat.o(239196);
        return localArrayList;
      }
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.ProcForegroundDelegate", localThrowable, "getBallInfoListSync fail!", new Object[0]);
      List localList = Collections.emptyList();
      AppMethodBeat.o(239196);
      return localList;
    }
  }
  
  private static boolean bk(List<? extends Class<? extends View>> paramList)
  {
    AppMethodBeat.i(239178);
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(239178);
      return false;
    }
    Iterator localIterator = aCP().iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (!paramList.contains(((View)localIterator.next()).getClass()));
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(239178);
      return bool;
    }
  }
  
  public static void c(Application paramApplication)
  {
    AppMethodBeat.i(239160);
    if (hhF == null) {
      try
      {
        if (hhF == null)
        {
          hhF = new ac(paramApplication);
          paramApplication.registerActivityLifecycleCallbacks(hhF);
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(239160);
      }
    }
    AppMethodBeat.o(239160);
  }
  
  private static int cz(Context paramContext)
  {
    AppMethodBeat.i(239205);
    Object localObject = (ActivityManager)paramContext.getSystemService("activity");
    if (localObject == null)
    {
      AppMethodBeat.o(239205);
      return -1;
    }
    localObject = ((ActivityManager)localObject).getRunningAppProcesses();
    if (localObject == null)
    {
      AppMethodBeat.o(239205);
      return -1;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      if ((!TextUtils.isEmpty(localRunningAppProcessInfo.processName)) && (localRunningAppProcessInfo.processName.startsWith(paramContext.getPackageName())))
      {
        int i = localRunningAppProcessInfo.importance;
        AppMethodBeat.o(239205);
        return i;
      }
    }
    AppMethodBeat.o(239205);
    return -1;
  }
  
  public static boolean it(String paramString)
  {
    AppMethodBeat.i(239187);
    Iterator localIterator = aCP().iterator();
    while (localIterator.hasNext()) {
      if (((View)localIterator.next()).toString().contains(paramString))
      {
        AppMethodBeat.o(239187);
        return true;
      }
    }
    AppMethodBeat.o(239187);
    return false;
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(239210);
    synchronized (this.eNV)
    {
      if (!this.eNV.contains(paramb)) {
        this.eNV.add(paramb);
      }
      AppMethodBeat.o(239210);
      return;
    }
  }
  
  public final boolean aCO()
  {
    AppMethodBeat.i(239223);
    if (MMApplicationContext.isMainProcess())
    {
      bool = this.hhI.aCR();
      AppMethodBeat.o(239223);
      return bool;
    }
    boolean bool = bk(this.hhI.aCQ());
    AppMethodBeat.o(239223);
    return bool;
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(239218);
    synchronized (this.eNV)
    {
      ListIterator localListIterator = this.eNV.listIterator();
      while (localListIterator.hasNext()) {
        if ((b)localListIterator.next() == paramb) {
          localListIterator.remove();
        }
      }
    }
    AppMethodBeat.o(239218);
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity) {}
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity arg1)
  {
    AppMethodBeat.i(239226);
    String str = ???.getClass().getName() + "@" + ???.hashCode();
    Log.i("MicroMsg.ProcForegroundDelegate", "#onStarted: " + str + ", refs = " + this.hhG);
    int i = this.hhG + 1;
    this.hhG = i;
    if ((i == 1) && (!this.hhH))
    {
      this.eny = true;
      Log.i("MicroMsg.ProcForegroundDelegate", "onProcessForeground");
      synchronized (this.eNV)
      {
        Iterator localIterator = this.eNV.iterator();
        while (localIterator.hasNext())
        {
          b localb = (b)localIterator.next();
          if (localb != null) {
            localb.onProcessForeground(str);
          }
        }
      }
      AppMethodBeat.o(239226);
      return;
    }
    AppMethodBeat.o(239226);
  }
  
  public final void onActivityStopped(Activity arg1)
  {
    AppMethodBeat.i(239232);
    String str = ???.getClass().getName() + "@" + ???.hashCode();
    Log.i("MicroMsg.ProcForegroundDelegate", "#onStopped: " + str + ", refs = " + this.hhG);
    this.hhH = ???.isChangingConfigurations();
    int i = this.hhG - 1;
    this.hhG = i;
    if ((i == 0) && (!this.hhH))
    {
      this.eny = false;
      Log.i("MicroMsg.ProcForegroundDelegate", "onProcessBackground");
      synchronized (this.eNV)
      {
        Iterator localIterator = this.eNV.iterator();
        while (localIterator.hasNext())
        {
          b localb = (b)localIterator.next();
          if (localb != null) {
            localb.onProcessBackground(str);
          }
        }
      }
      AppMethodBeat.o(239232);
      return;
    }
    AppMethodBeat.o(239232);
  }
  
  public static abstract interface a
  {
    public abstract List<? extends Class<? extends View>> aCQ();
    
    public abstract boolean aCR();
  }
  
  public static abstract interface b
  {
    public abstract void onProcessBackground(String paramString);
    
    public abstract void onProcessForeground(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.app.ac
 * JD-Core Version:    0.7.0.1
 */