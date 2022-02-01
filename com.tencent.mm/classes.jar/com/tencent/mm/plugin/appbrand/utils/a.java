package com.tencent.mm.plugin.appbrand.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.task.f;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import d.a.j;
import d.g.b.k;
import d.l;
import java.lang.Class<+Landroid.app.Activity;>;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/utils/AppBrandComponentUtil;", "", "()V", "genAppBrandInstanceId", "", "parcel", "Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "appId", "generateInstanceId", "uin", "", "hasPreLoading", "", "triggerServiceName", "isActivityHasSpecificTaskAffinity", "clazz", "Ljava/lang/Class;", "Landroid/app/Activity;", "plugin-appbrand-integration_release"})
public final class a
{
  public static final a mnT;
  
  static
  {
    AppMethodBeat.i(51400);
    mnT = new a();
    AppMethodBeat.o(51400);
  }
  
  public static final boolean Rs(String paramString)
  {
    AppMethodBeat.i(187450);
    paramString = (CharSequence)paramString;
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(187450);
      return true;
    }
    AppMethodBeat.o(187450);
    return false;
  }
  
  public static final boolean aI(Class<? extends Activity> paramClass)
  {
    AppMethodBeat.i(51397);
    k.h(paramClass, "clazz");
    try
    {
      Context localContext = ai.getContext();
      if (localContext != null)
      {
        Object localObject = localContext.getPackageManager();
        if (localObject != null)
        {
          paramClass = ((PackageManager)localObject).getActivityInfo(new ComponentName(localContext, paramClass), 128);
          if (paramClass != null)
          {
            localObject = paramClass.taskAffinity;
            paramClass = (Class<? extends Activity>)localObject;
            if (localObject != null) {
              break label71;
            }
          }
        }
      }
      k.g(localContext, "appContext");
      paramClass = localContext.getPackageName();
      label71:
      boolean bool = k.g(paramClass, localContext.getPackageName());
      AppMethodBeat.o(51397);
      return bool ^ true;
    }
    catch (PackageManager.NameNotFoundException paramClass)
    {
      AppMethodBeat.o(51397);
    }
    return false;
  }
  
  public static final String c(LaunchParcel paramLaunchParcel, String paramString)
  {
    AppMethodBeat.i(51398);
    k.h(paramLaunchParcel, "parcel");
    paramString = f.bY(paramString, paramLaunchParcel.hxM);
    paramLaunchParcel = paramString;
    if (paramString == null)
    {
      k.g(g.agP(), "MMKernel.account()");
      paramLaunchParcel = vf(com.tencent.mm.kernel.a.getUin());
    }
    if (paramLaunchParcel == null) {
      k.fOy();
    }
    AppMethodBeat.o(51398);
    return paramLaunchParcel;
  }
  
  public static final String vf(int paramInt)
  {
    AppMethodBeat.i(51399);
    String str = p.getString(paramInt);
    k.g(str, "UIN.getString(uin)");
    str = j.a((Iterable)j.listOf(new String[] { str, String.valueOf(bs.eWj()) }), (CharSequence)"_", null, null, 0, null, null, 62);
    AppMethodBeat.o(51399);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.a
 * JD-Core Version:    0.7.0.1
 */