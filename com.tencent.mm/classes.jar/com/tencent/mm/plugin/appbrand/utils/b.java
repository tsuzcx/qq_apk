package com.tencent.mm.plugin.appbrand.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.luggage.sdk.config.c;
import com.tencent.luggage.sdk.config.c.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.Class<+Landroid.app.Activity;>;
import kotlin.a.j;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/utils/AppBrandComponentUtil;", "", "()V", "generateInstanceId", "", "uin", "", "hasPreLoading", "", "triggerServiceName", "isActivityHasSpecificTaskAffinity", "clazz", "Ljava/lang/Class;", "Landroid/app/Activity;", "plugin-appbrand-integration_release"})
public final class b
{
  public static final b ogD;
  
  static
  {
    AppMethodBeat.i(51400);
    ogD = new b();
    AppMethodBeat.o(51400);
  }
  
  public static final boolean aI(Class<? extends Activity> paramClass)
  {
    AppMethodBeat.i(51397);
    kotlin.g.b.p.h(paramClass, "clazz");
    try
    {
      Context localContext = MMApplicationContext.getContext();
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
      kotlin.g.b.p.g(localContext, "appContext");
      paramClass = localContext.getPackageName();
      label71:
      boolean bool = kotlin.g.b.p.j(paramClass, localContext.getPackageName());
      AppMethodBeat.o(51397);
      return bool ^ true;
    }
    catch (PackageManager.NameNotFoundException paramClass)
    {
      AppMethodBeat.o(51397);
    }
    return false;
  }
  
  public static final boolean afF(String paramString)
  {
    AppMethodBeat.i(229594);
    paramString = (CharSequence)paramString;
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(229594);
      return true;
    }
    AppMethodBeat.o(229594);
    return false;
  }
  
  public static final String zF(int paramInt)
  {
    AppMethodBeat.i(51399);
    Object localObject = c.a.czh;
    if (localObject != null)
    {
      localObject = ((c)localObject).NI();
      kotlin.g.b.p.g(localObject, "factory.createInstanceId()");
      AppMethodBeat.o(51399);
      return localObject;
    }
    localObject = com.tencent.mm.b.p.getString(paramInt);
    kotlin.g.b.p.g(localObject, "UIN.getString(uin)");
    localObject = j.a((Iterable)j.listOf(new String[] { localObject, String.valueOf(Util.nowMilliSecond()) }), (CharSequence)"_", null, null, 0, null, null, 62);
    AppMethodBeat.o(51399);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.b
 * JD-Core Version:    0.7.0.1
 */