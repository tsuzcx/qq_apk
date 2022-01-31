package com.tencent.mm.plugin.appbrand.task;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

class j
{
  final String iLf;
  final Class<? extends Activity> iLg;
  final String iLh;
  private final Class iLi;
  final LinkedHashMap<String, Integer> iLj;
  final LinkedHashMap<String, AppBrandRemoteTaskController> iLk;
  g iLl;
  final Class ijw;
  
  j(Class<? extends Activity> paramClass, Class paramClass1, Class paramClass2)
  {
    AppMethodBeat.i(132874);
    this.iLj = new LinkedHashMap();
    this.iLk = new LinkedHashMap();
    this.iLl = g.iKU;
    this.iLf = paramClass.getName();
    this.iLg = paramClass;
    this.iLi = paramClass1;
    this.ijw = paramClass2;
    this.iLh = ae(this.iLg);
    AppMethodBeat.o(132874);
  }
  
  private static String ae(Class<?> paramClass)
  {
    AppMethodBeat.i(143587);
    PackageManager localPackageManager = ah.getContext().getPackageManager();
    if (localPackageManager == null)
    {
      AppMethodBeat.o(143587);
      return null;
    }
    try
    {
      paramClass = localPackageManager.getActivityInfo(new ComponentName(ah.getContext(), paramClass), 128).processName;
      AppMethodBeat.o(143587);
      return paramClass;
    }
    catch (Exception paramClass)
    {
      AppMethodBeat.o(143587);
    }
    return null;
  }
  
  void Do()
  {
    AppMethodBeat.i(132876);
    if (this.iLi == null)
    {
      AppMethodBeat.o(132876);
      return;
    }
    try
    {
      Intent localIntent = new Intent();
      AppBrandPreloadProfiler localAppBrandPreloadProfiler = new AppBrandPreloadProfiler();
      localAppBrandPreloadProfiler.iJW = SystemClock.elapsedRealtime();
      localIntent.putExtra("preloadProfiler", localAppBrandPreloadProfiler);
      localIntent.putExtra("EXTRA_KEY_UI_CLASS", this.iLf);
      localIntent.setClass(ah.getContext(), this.iLi);
      localIntent.addFlags(268435456);
      localIntent.putExtra("AppBrandServiceType", this.iLl.code);
      ah.getContext().sendBroadcast(localIntent);
      AppMethodBeat.o(132876);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(132876);
    }
  }
  
  void EN(String paramString)
  {
    AppMethodBeat.i(132878);
    this.iLj.remove(paramString);
    this.iLk.remove(paramString);
    if (this.iLj.isEmpty()) {
      this.iLl = g.iKU;
    }
    AppMethodBeat.o(132878);
  }
  
  final Integer Fb(String paramString)
  {
    AppMethodBeat.i(132880);
    paramString = (Integer)this.iLj.get(paramString);
    AppMethodBeat.o(132880);
    return paramString;
  }
  
  final AppBrandRemoteTaskController Fc(String paramString)
  {
    AppMethodBeat.i(132881);
    paramString = (AppBrandRemoteTaskController)this.iLk.get(paramString);
    AppMethodBeat.o(132881);
    return paramString;
  }
  
  void a(String paramString, int paramInt, AppBrandRemoteTaskController paramAppBrandRemoteTaskController)
  {
    AppMethodBeat.i(132877);
    this.iLj.put(paramString, Integer.valueOf(paramInt));
    this.iLk.put(paramString, paramAppBrandRemoteTaskController);
    AppMethodBeat.o(132877);
  }
  
  protected boolean a(g paramg)
  {
    return true;
  }
  
  void aLF()
  {
    AppMethodBeat.i(132879);
    if (!this.iLj.isEmpty())
    {
      AppMethodBeat.o(132879);
      return;
    }
    if (TextUtils.isEmpty(this.iLh))
    {
      AppMethodBeat.o(132879);
      return;
    }
    Object localObject = (ActivityManager)ah.getContext().getSystemService("activity");
    if (localObject == null)
    {
      AppMethodBeat.o(132879);
      return;
    }
    String str = this.iLh;
    localObject = ((ActivityManager)localObject).getRunningAppProcesses();
    if (localObject == null)
    {
      AppMethodBeat.o(132879);
      return;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      if (localRunningAppProcessInfo.processName.equals(str)) {
        try
        {
          Process.killProcess(localRunningAppProcessInfo.pid);
          AppMethodBeat.o(132879);
          return;
        }
        catch (Exception localException)
        {
          AppMethodBeat.o(132879);
          return;
        }
      }
    }
    AppMethodBeat.o(132879);
  }
  
  final void f(g paramg)
  {
    AppMethodBeat.i(132875);
    if (!a(paramg))
    {
      paramg = new IllegalStateException("AppBrandUITask not support this type. [" + paramg.name() + "]");
      AppMethodBeat.o(132875);
      throw paramg;
    }
    this.iLl = paramg;
    AppMethodBeat.o(132875);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.j
 * JD-Core Version:    0.7.0.1
 */