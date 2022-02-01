package com.tencent.mm.plugin.appbrand.backgroundrunning;

import android.app.Notification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e
{
  public static Class<? extends CustomBackgroundRunningNotificationLogic> Jt(String paramString)
  {
    AppMethodBeat.i(186393);
    try
    {
      paramString = Class.forName(paramString);
      AppMethodBeat.o(186393);
      return paramString;
    }
    catch (Exception paramString)
    {
      ac.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "getCustomNotificationLogicClass fail since " + paramString.toString());
      AppMethodBeat.o(186393);
    }
    return null;
  }
  
  public static List<b> ba(List<AppBrandBackgroundRunningApp> paramList)
  {
    AppMethodBeat.i(186392);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ac.i("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildCustomForegroundNotifications, apps is null");
      AppMethodBeat.o(186392);
      return null;
    }
    ac.i("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildCustomForegroundNotifications, apps:%s", new Object[] { paramList });
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      AppBrandBackgroundRunningApp localAppBrandBackgroundRunningApp = (AppBrandBackgroundRunningApp)localIterator.next();
      if ((bs.isNullOrNil(localAppBrandBackgroundRunningApp.jxV)) || (bs.isNullOrNil(localAppBrandBackgroundRunningApp.appId)))
      {
        ac.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildCustomForegroundNotifications, customNotificationLogicClassName:%s, appId: %s", new Object[] { localAppBrandBackgroundRunningApp.jxV, localAppBrandBackgroundRunningApp.appId });
      }
      else
      {
        o localo = a.GU(localAppBrandBackgroundRunningApp.appId);
        if (localo == null)
        {
          ac.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildCustomForegroundNotifications, runtime of %s is null", new Object[] { localAppBrandBackgroundRunningApp.appId });
        }
        else
        {
          paramList = Jt(localAppBrandBackgroundRunningApp.jxV);
          if (paramList == null)
          {
            ac.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildCustomForegroundNotifications, customNotificationLogicClass of %s is null", new Object[] { localAppBrandBackgroundRunningApp.appId });
          }
          else
          {
            CustomBackgroundRunningNotificationLogic localCustomBackgroundRunningNotificationLogic = (CustomBackgroundRunningNotificationLogic)localo.as(paramList);
            paramList = localCustomBackgroundRunningNotificationLogic;
            if (localCustomBackgroundRunningNotificationLogic == null)
            {
              paramList = cw(localAppBrandBackgroundRunningApp.jxV, localAppBrandBackgroundRunningApp.appId);
              if (paramList == null) {
                ac.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildCustomForegroundNotifications, customNotificationLogic of %s is null", new Object[] { localAppBrandBackgroundRunningApp.appId });
              } else {
                localo.a(paramList);
              }
            }
            else
            {
              paramList.aZw();
              localArrayList.add(new b(paramList.aZu(), paramList.aZv()));
            }
          }
        }
      }
    }
    AppMethodBeat.o(186392);
    return localArrayList;
  }
  
  private static CustomBackgroundRunningNotificationLogic cw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(186394);
    ac.i("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "createCustomNotificationLogic, customNotificationLogicClassName:%s, appId: %s", new Object[] { paramString1, paramString2 });
    try
    {
      paramString1 = (CustomBackgroundRunningNotificationLogic)Jt(paramString1).getConstructor(new Class[] { String.class }).newInstance(new Object[] { paramString2 });
      AppMethodBeat.o(186394);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      ac.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "createCustomNotificationLogic fail since " + paramString1.toString());
      AppMethodBeat.o(186394);
    }
    return null;
  }
  
  public static final class a
  {
    public List<AppBrandBackgroundRunningApp> jym;
    public List<AppBrandBackgroundRunningApp> jyn;
  }
  
  public static final class b
  {
    public final Notification jyo;
    public final int notificationId;
    
    public b(Notification paramNotification, int paramInt)
    {
      this.jyo = paramNotification;
      this.notificationId = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.e
 * JD-Core Version:    0.7.0.1
 */