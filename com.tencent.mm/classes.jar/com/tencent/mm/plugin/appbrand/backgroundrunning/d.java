package com.tencent.mm.plugin.appbrand.backgroundrunning;

import android.app.Notification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
{
  public static Class<? extends CustomBackgroundRunningNotificationLogic> WB(String paramString)
  {
    AppMethodBeat.i(226447);
    try
    {
      paramString = Class.forName(paramString);
      AppMethodBeat.o(226447);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "getCustomNotificationLogicClass fail since " + paramString.toString());
      AppMethodBeat.o(226447);
    }
    return null;
  }
  
  public static List<b> bp(List<AppBrandBackgroundRunningApp> paramList)
  {
    AppMethodBeat.i(226446);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      Log.i("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildCustomForegroundNotifications, apps is null");
      AppMethodBeat.o(226446);
      return null;
    }
    Log.i("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildCustomForegroundNotifications, apps:%s", new Object[] { paramList });
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      AppBrandBackgroundRunningApp localAppBrandBackgroundRunningApp = (AppBrandBackgroundRunningApp)localIterator.next();
      if ((Util.isNullOrNil(localAppBrandBackgroundRunningApp.kYf)) || (Util.isNullOrNil(localAppBrandBackgroundRunningApp.appId)))
      {
        Log.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildCustomForegroundNotifications, customNotificationLogicClassName:%s, appId: %s", new Object[] { localAppBrandBackgroundRunningApp.kYf, localAppBrandBackgroundRunningApp.appId });
      }
      else
      {
        q localq = a.TQ(localAppBrandBackgroundRunningApp.appId);
        if (localq == null)
        {
          Log.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildCustomForegroundNotifications, runtime of %s is null", new Object[] { localAppBrandBackgroundRunningApp.appId });
        }
        else
        {
          paramList = WB(localAppBrandBackgroundRunningApp.kYf);
          if (paramList == null)
          {
            Log.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildCustomForegroundNotifications, customNotificationLogicClass of %s is null", new Object[] { localAppBrandBackgroundRunningApp.appId });
          }
          else
          {
            CustomBackgroundRunningNotificationLogic localCustomBackgroundRunningNotificationLogic = (CustomBackgroundRunningNotificationLogic)localq.aw(paramList);
            paramList = localCustomBackgroundRunningNotificationLogic;
            if (localCustomBackgroundRunningNotificationLogic == null)
            {
              paramList = cO(localAppBrandBackgroundRunningApp.kYf, localAppBrandBackgroundRunningApp.appId);
              if (paramList == null) {
                Log.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildCustomForegroundNotifications, customNotificationLogic of %s is null", new Object[] { localAppBrandBackgroundRunningApp.appId });
              } else {
                localq.a(paramList);
              }
            }
            else
            {
              paramList.byQ();
              localArrayList.add(new b(paramList.byP(), paramList.getNotificationId()));
            }
          }
        }
      }
    }
    AppMethodBeat.o(226446);
    return localArrayList;
  }
  
  private static CustomBackgroundRunningNotificationLogic cO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(226448);
    Log.i("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "createCustomNotificationLogic, customNotificationLogicClassName:%s, appId: %s", new Object[] { paramString1, paramString2 });
    try
    {
      paramString1 = (CustomBackgroundRunningNotificationLogic)WB(paramString1).getConstructor(new Class[] { String.class }).newInstance(new Object[] { paramString2 });
      AppMethodBeat.o(226448);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      Log.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "createCustomNotificationLogic fail since " + paramString1.toString());
      AppMethodBeat.o(226448);
    }
    return null;
  }
  
  public static final class a
  {
    public List<AppBrandBackgroundRunningApp> kYw;
    public List<AppBrandBackgroundRunningApp> kYx;
  }
  
  public static final class b
  {
    public final Notification kYy;
    public final int notificationId;
    
    public b(Notification paramNotification, int paramInt)
    {
      this.kYy = paramNotification;
      this.notificationId = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.d
 * JD-Core Version:    0.7.0.1
 */