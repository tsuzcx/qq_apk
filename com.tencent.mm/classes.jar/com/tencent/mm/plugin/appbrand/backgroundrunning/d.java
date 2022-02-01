package com.tencent.mm.plugin.appbrand.backgroundrunning;

import android.app.Notification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
{
  public static Class<? extends CustomBackgroundRunningNotificationLogic> aem(String paramString)
  {
    AppMethodBeat.i(282880);
    try
    {
      paramString = Class.forName(paramString);
      AppMethodBeat.o(282880);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "getCustomNotificationLogicClass fail since " + paramString.toString());
      AppMethodBeat.o(282880);
    }
    return null;
  }
  
  public static List<b> bn(List<AppBrandBackgroundRunningApp> paramList)
  {
    AppMethodBeat.i(282879);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      Log.i("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildCustomForegroundNotifications, apps is null");
      AppMethodBeat.o(282879);
      return null;
    }
    Log.i("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildCustomForegroundNotifications, apps:%s", new Object[] { paramList });
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      AppBrandBackgroundRunningApp localAppBrandBackgroundRunningApp = (AppBrandBackgroundRunningApp)localIterator.next();
      if ((Util.isNullOrNil(localAppBrandBackgroundRunningApp.nSr)) || (Util.isNullOrNil(localAppBrandBackgroundRunningApp.appId)))
      {
        Log.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildCustomForegroundNotifications, customNotificationLogicClassName:%s, appId: %s", new Object[] { localAppBrandBackgroundRunningApp.nSr, localAppBrandBackgroundRunningApp.appId });
      }
      else
      {
        t localt = com.tencent.mm.plugin.appbrand.d.abA(localAppBrandBackgroundRunningApp.appId);
        if (localt == null)
        {
          Log.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildCustomForegroundNotifications, runtime of %s is null", new Object[] { localAppBrandBackgroundRunningApp.appId });
        }
        else
        {
          paramList = aem(localAppBrandBackgroundRunningApp.nSr);
          if (paramList == null)
          {
            Log.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildCustomForegroundNotifications, customNotificationLogicClass of %s is null", new Object[] { localAppBrandBackgroundRunningApp.appId });
          }
          else
          {
            CustomBackgroundRunningNotificationLogic localCustomBackgroundRunningNotificationLogic = (CustomBackgroundRunningNotificationLogic)localt.av(paramList);
            paramList = localCustomBackgroundRunningNotificationLogic;
            if (localCustomBackgroundRunningNotificationLogic == null)
            {
              paramList = cX(localAppBrandBackgroundRunningApp.nSr, localAppBrandBackgroundRunningApp.appId);
              if (paramList == null) {
                Log.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildCustomForegroundNotifications, customNotificationLogic of %s is null", new Object[] { localAppBrandBackgroundRunningApp.appId });
              } else {
                localt.a(paramList);
              }
            }
            else
            {
              paramList.bKf();
              localArrayList.add(new b(paramList.bKd(), paramList.bKe()));
            }
          }
        }
      }
    }
    AppMethodBeat.o(282879);
    return localArrayList;
  }
  
  private static CustomBackgroundRunningNotificationLogic cX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(282881);
    Log.i("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "createCustomNotificationLogic, customNotificationLogicClassName:%s, appId: %s", new Object[] { paramString1, paramString2 });
    try
    {
      paramString1 = (CustomBackgroundRunningNotificationLogic)aem(paramString1).getConstructor(new Class[] { String.class }).newInstance(new Object[] { paramString2 });
      AppMethodBeat.o(282881);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      Log.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "createCustomNotificationLogic fail since " + paramString1.toString());
      AppMethodBeat.o(282881);
    }
    return null;
  }
  
  public static final class a
  {
    public List<AppBrandBackgroundRunningApp> nSH;
    public List<AppBrandBackgroundRunningApp> nSI;
  }
  
  public static final class b
  {
    public final Notification nSJ;
    public final int notificationId;
    
    public b(Notification paramNotification, int paramInt)
    {
      this.nSJ = paramNotification;
      this.notificationId = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.d
 * JD-Core Version:    0.7.0.1
 */