package com.tencent.mm.plugin.appbrand.backgroundrunning;

import android.app.Notification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
{
  public static Class<? extends CustomBackgroundRunningNotificationLogic> WP(String paramString)
  {
    AppMethodBeat.i(318153);
    try
    {
      paramString = Class.forName(paramString);
      AppMethodBeat.o(318153);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "getCustomNotificationLogicClass fail since " + paramString.toString());
      AppMethodBeat.o(318153);
    }
    return null;
  }
  
  public static List<b> cY(List<AppBrandBackgroundRunningApp> paramList)
  {
    AppMethodBeat.i(318149);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      Log.i("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildCustomForegroundNotifications, apps is null");
      AppMethodBeat.o(318149);
      return null;
    }
    Log.i("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildCustomForegroundNotifications, apps:%s", new Object[] { paramList });
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      AppBrandBackgroundRunningApp localAppBrandBackgroundRunningApp = (AppBrandBackgroundRunningApp)localIterator.next();
      if ((Util.isNullOrNil(localAppBrandBackgroundRunningApp.qSc)) || (Util.isNullOrNil(localAppBrandBackgroundRunningApp.appId)))
      {
        Log.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildCustomForegroundNotifications, customNotificationLogicClassName:%s, appId: %s", new Object[] { localAppBrandBackgroundRunningApp.qSc, localAppBrandBackgroundRunningApp.appId });
      }
      else
      {
        w localw = com.tencent.mm.plugin.appbrand.d.Uc(localAppBrandBackgroundRunningApp.appId);
        if (localw == null)
        {
          Log.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildCustomForegroundNotifications, runtime of %s is null", new Object[] { localAppBrandBackgroundRunningApp.appId });
        }
        else
        {
          paramList = WP(localAppBrandBackgroundRunningApp.qSc);
          if (paramList == null)
          {
            Log.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildCustomForegroundNotifications, customNotificationLogicClass of %s is null", new Object[] { localAppBrandBackgroundRunningApp.appId });
          }
          else
          {
            CustomBackgroundRunningNotificationLogic localCustomBackgroundRunningNotificationLogic = (CustomBackgroundRunningNotificationLogic)localw.aO(paramList);
            paramList = localCustomBackgroundRunningNotificationLogic;
            if (localCustomBackgroundRunningNotificationLogic == null)
            {
              paramList = jdMethod_do(localAppBrandBackgroundRunningApp.qSc, localAppBrandBackgroundRunningApp.appId);
              if (paramList == null) {
                Log.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildCustomForegroundNotifications, customNotificationLogic of %s is null", new Object[] { localAppBrandBackgroundRunningApp.appId });
              } else {
                localw.a(paramList);
              }
            }
            else
            {
              paramList.cjG();
              localArrayList.add(new b(paramList.cjE(), paramList.cjF()));
            }
          }
        }
      }
    }
    AppMethodBeat.o(318149);
    return localArrayList;
  }
  
  private static CustomBackgroundRunningNotificationLogic jdMethod_do(String paramString1, String paramString2)
  {
    AppMethodBeat.i(318157);
    Log.i("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "createCustomNotificationLogic, customNotificationLogicClassName:%s, appId: %s", new Object[] { paramString1, paramString2 });
    try
    {
      paramString1 = (CustomBackgroundRunningNotificationLogic)WP(paramString1).getConstructor(new Class[] { String.class }).newInstance(new Object[] { paramString2 });
      AppMethodBeat.o(318157);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      Log.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "createCustomNotificationLogic fail since " + paramString1.toString());
      AppMethodBeat.o(318157);
    }
    return null;
  }
  
  public static final class a
  {
    public List<AppBrandBackgroundRunningApp> qSt;
    public List<AppBrandBackgroundRunningApp> qSu;
  }
  
  public static final class b
  {
    public final int notificationId;
    public final Notification qSv;
    
    public b(Notification paramNotification, int paramInt)
    {
      this.qSv = paramNotification;
      this.notificationId = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.d
 * JD-Core Version:    0.7.0.1
 */