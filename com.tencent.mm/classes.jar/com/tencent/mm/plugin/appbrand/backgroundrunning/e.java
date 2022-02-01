package com.tencent.mm.plugin.appbrand.backgroundrunning;

import android.app.Notification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e
{
  public static Class<? extends CustomBackgroundRunningNotificationLogic> MM(String paramString)
  {
    AppMethodBeat.i(188086);
    try
    {
      paramString = Class.forName(paramString);
      AppMethodBeat.o(188086);
      return paramString;
    }
    catch (Exception paramString)
    {
      ad.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "getCustomNotificationLogicClass fail since " + paramString.toString());
      AppMethodBeat.o(188086);
    }
    return null;
  }
  
  public static List<b> bc(List<AppBrandBackgroundRunningApp> paramList)
  {
    AppMethodBeat.i(188085);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ad.i("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildCustomForegroundNotifications, apps is null");
      AppMethodBeat.o(188085);
      return null;
    }
    ad.i("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildCustomForegroundNotifications, apps:%s", new Object[] { paramList });
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      AppBrandBackgroundRunningApp localAppBrandBackgroundRunningApp = (AppBrandBackgroundRunningApp)localIterator.next();
      if ((bt.isNullOrNil(localAppBrandBackgroundRunningApp.jRR)) || (bt.isNullOrNil(localAppBrandBackgroundRunningApp.appId)))
      {
        ad.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildCustomForegroundNotifications, customNotificationLogicClassName:%s, appId: %s", new Object[] { localAppBrandBackgroundRunningApp.jRR, localAppBrandBackgroundRunningApp.appId });
      }
      else
      {
        o localo = a.Kj(localAppBrandBackgroundRunningApp.appId);
        if (localo == null)
        {
          ad.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildCustomForegroundNotifications, runtime of %s is null", new Object[] { localAppBrandBackgroundRunningApp.appId });
        }
        else
        {
          paramList = MM(localAppBrandBackgroundRunningApp.jRR);
          if (paramList == null)
          {
            ad.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildCustomForegroundNotifications, customNotificationLogicClass of %s is null", new Object[] { localAppBrandBackgroundRunningApp.appId });
          }
          else
          {
            CustomBackgroundRunningNotificationLogic localCustomBackgroundRunningNotificationLogic = (CustomBackgroundRunningNotificationLogic)localo.as(paramList);
            paramList = localCustomBackgroundRunningNotificationLogic;
            if (localCustomBackgroundRunningNotificationLogic == null)
            {
              paramList = cy(localAppBrandBackgroundRunningApp.jRR, localAppBrandBackgroundRunningApp.appId);
              if (paramList == null) {
                ad.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildCustomForegroundNotifications, customNotificationLogic of %s is null", new Object[] { localAppBrandBackgroundRunningApp.appId });
              } else {
                localo.a(paramList);
              }
            }
            else
            {
              paramList.bcU();
              localArrayList.add(new b(paramList.bcS(), paramList.bcT()));
            }
          }
        }
      }
    }
    AppMethodBeat.o(188085);
    return localArrayList;
  }
  
  private static CustomBackgroundRunningNotificationLogic cy(String paramString1, String paramString2)
  {
    AppMethodBeat.i(188087);
    ad.i("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "createCustomNotificationLogic, customNotificationLogicClassName:%s, appId: %s", new Object[] { paramString1, paramString2 });
    try
    {
      paramString1 = (CustomBackgroundRunningNotificationLogic)MM(paramString1).getConstructor(new Class[] { String.class }).newInstance(new Object[] { paramString2 });
      AppMethodBeat.o(188087);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      ad.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "createCustomNotificationLogic fail since " + paramString1.toString());
      AppMethodBeat.o(188087);
    }
    return null;
  }
  
  public static final class a
  {
    public List<AppBrandBackgroundRunningApp> jSj;
    public List<AppBrandBackgroundRunningApp> jSk;
  }
  
  public static final class b
  {
    public final Notification jSl;
    public final int notificationId;
    
    public b(Notification paramNotification, int paramInt)
    {
      this.jSl = paramNotification;
      this.notificationId = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.e
 * JD-Core Version:    0.7.0.1
 */