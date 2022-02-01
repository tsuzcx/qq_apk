package com.tencent.mm.plugin.appbrand.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.task.f;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import d.a.j;
import d.l;
import java.lang.Class<+Landroid.app.Activity;>;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/utils/AppBrandComponentUtil;", "", "()V", "genAppBrandInstanceId", "", "parcel", "Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "appId", "generateInstanceId", "uin", "", "hasPreLoading", "", "triggerServiceName", "isActivityHasSpecificTaskAffinity", "clazz", "Ljava/lang/Class;", "Landroid/app/Activity;", "plugin-appbrand-integration_release"})
public final class a
{
  public static final a mOv;
  
  static
  {
    AppMethodBeat.i(51400);
    mOv = new a();
    AppMethodBeat.o(51400);
  }
  
  public static final boolean UY(String paramString)
  {
    AppMethodBeat.i(189664);
    paramString = (CharSequence)paramString;
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(189664);
      return true;
    }
    AppMethodBeat.o(189664);
    return false;
  }
  
  public static final boolean aI(Class<? extends Activity> paramClass)
  {
    AppMethodBeat.i(51397);
    d.g.b.p.h(paramClass, "clazz");
    try
    {
      Context localContext = aj.getContext();
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
      d.g.b.p.g(localContext, "appContext");
      paramClass = localContext.getPackageName();
      label71:
      boolean bool = d.g.b.p.i(paramClass, localContext.getPackageName());
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
    d.g.b.p.h(paramLaunchParcel, "parcel");
    paramString = f.cb(paramString, paramLaunchParcel.hQh);
    paramLaunchParcel = paramString;
    if (paramString == null)
    {
      d.g.b.p.g(g.ajA(), "MMKernel.account()");
      paramLaunchParcel = vL(com.tencent.mm.kernel.a.getUin());
    }
    if (paramLaunchParcel == null) {
      d.g.b.p.gfZ();
    }
    AppMethodBeat.o(51398);
    return paramLaunchParcel;
  }
  
  public static final String vL(int paramInt)
  {
    AppMethodBeat.i(51399);
    String str = com.tencent.mm.b.p.getString(paramInt);
    d.g.b.p.g(str, "UIN.getString(uin)");
    str = j.a((Iterable)j.listOf(new String[] { str, String.valueOf(bt.flT()) }), (CharSequence)"_", null, null, 0, null, null, 62);
    AppMethodBeat.o(51399);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.a
 * JD-Core Version:    0.7.0.1
 */