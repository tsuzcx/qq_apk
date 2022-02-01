package com.tencent.mm.plugin.appbrand.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.task.f;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import d.a.j;
import d.l;
import java.lang.Class<+Landroid.app.Activity;>;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/utils/AppBrandComponentUtil;", "", "()V", "genAppBrandInstanceId", "", "parcel", "Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "appId", "generateInstanceId", "uin", "", "hasPreLoading", "", "triggerServiceName", "isActivityHasSpecificTaskAffinity", "clazz", "Ljava/lang/Class;", "Landroid/app/Activity;", "plugin-appbrand-integration_release"})
public final class b
{
  public static final b mTA;
  
  static
  {
    AppMethodBeat.i(51400);
    mTA = new b();
    AppMethodBeat.o(51400);
  }
  
  public static final boolean VJ(String paramString)
  {
    AppMethodBeat.i(223936);
    paramString = (CharSequence)paramString;
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(223936);
      return true;
    }
    AppMethodBeat.o(223936);
    return false;
  }
  
  public static final boolean aI(Class<? extends Activity> paramClass)
  {
    AppMethodBeat.i(51397);
    d.g.b.p.h(paramClass, "clazz");
    try
    {
      Context localContext = ak.getContext();
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
    paramString = f.cf(paramString, paramLaunchParcel.hSZ);
    paramLaunchParcel = paramString;
    if (paramString == null)
    {
      d.g.b.p.g(g.ajP(), "MMKernel.account()");
      paramLaunchParcel = vQ(a.getUin());
    }
    if (paramLaunchParcel == null) {
      d.g.b.p.gkB();
    }
    AppMethodBeat.o(51398);
    return paramLaunchParcel;
  }
  
  public static final String vQ(int paramInt)
  {
    AppMethodBeat.i(51399);
    String str = com.tencent.mm.b.p.getString(paramInt);
    d.g.b.p.g(str, "UIN.getString(uin)");
    str = j.a((Iterable)j.listOf(new String[] { str, String.valueOf(bu.fpO()) }), (CharSequence)"_", null, null, 0, null, null, 62);
    AppMethodBeat.o(51399);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.b
 * JD-Core Version:    0.7.0.1
 */