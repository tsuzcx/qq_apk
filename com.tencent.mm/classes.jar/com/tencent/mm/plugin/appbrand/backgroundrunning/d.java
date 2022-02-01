package com.tencent.mm.plugin.appbrand.backgroundrunning;

import android.app.Notification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
{
  public static Class<? extends CustomBackgroundRunningNotificationLogic> Nt(String paramString)
  {
    AppMethodBeat.i(222206);
    try
    {
      paramString = Class.forName(paramString);
      AppMethodBeat.o(222206);
      return paramString;
    }
    catch (Exception paramString)
    {
      ae.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "getCustomNotificationLogicClass fail since " + paramString.toString());
      AppMethodBeat.o(222206);
    }
    return null;
  }
  
  public static List<b> be(List<AppBrandBackgroundRunningApp> paramList)
  {
    AppMethodBeat.i(222205);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ae.i("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildCustomForegroundNotifications, apps is null");
      AppMethodBeat.o(222205);
      return null;
    }
    ae.i("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildCustomForegroundNotifications, apps:%s", new Object[] { paramList });
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      AppBrandBackgroundRunningApp localAppBrandBackgroundRunningApp = (AppBrandBackgroundRunningApp)localIterator.next();
      if ((bu.isNullOrNil(localAppBrandBackgroundRunningApp.jVj)) || (bu.isNullOrNil(localAppBrandBackgroundRunningApp.appId)))
      {
        ae.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildCustomForegroundNotifications, customNotificationLogicClassName:%s, appId: %s", new Object[] { localAppBrandBackgroundRunningApp.jVj, localAppBrandBackgroundRunningApp.appId });
      }
      else
      {
        p localp = a.KI(localAppBrandBackgroundRunningApp.appId);
        if (localp == null)
        {
          ae.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildCustomForegroundNotifications, runtime of %s is null", new Object[] { localAppBrandBackgroundRunningApp.appId });
        }
        else
        {
          paramList = Nt(localAppBrandBackgroundRunningApp.jVj);
          if (paramList == null)
          {
            ae.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildCustomForegroundNotifications, customNotificationLogicClass of %s is null", new Object[] { localAppBrandBackgroundRunningApp.appId });
          }
          else
          {
            CustomBackgroundRunningNotificationLogic localCustomBackgroundRunningNotificationLogic = (CustomBackgroundRunningNotificationLogic)localp.as(paramList);
            paramList = localCustomBackgroundRunningNotificationLogic;
            if (localCustomBackgroundRunningNotificationLogic == null)
            {
              paramList = cA(localAppBrandBackgroundRunningApp.jVj, localAppBrandBackgroundRunningApp.appId);
              if (paramList == null) {
                ae.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "buildCustomForegroundNotifications, customNotificationLogic of %s is null", new Object[] { localAppBrandBackgroundRunningApp.appId });
              } else {
                localp.a(paramList);
              }
            }
            else
            {
              paramList.bdz();
              localArrayList.add(new b(paramList.bdx(), paramList.bdy()));
            }
          }
        }
      }
    }
    AppMethodBeat.o(222205);
    return localArrayList;
  }
  
  private static CustomBackgroundRunningNotificationLogic cA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(222207);
    ae.i("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "createCustomNotificationLogic, customNotificationLogicClassName:%s, appId: %s", new Object[] { paramString1, paramString2 });
    try
    {
      paramString1 = (CustomBackgroundRunningNotificationLogic)Nt(paramString1).getConstructor(new Class[] { String.class }).newInstance(new Object[] { paramString2 });
      AppMethodBeat.o(222207);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      ae.w("MicroMsg.AppBrand.AppBrandForegroundNotificationCommons", "createCustomNotificationLogic fail since " + paramString1.toString());
      AppMethodBeat.o(222207);
    }
    return null;
  }
  
  public static final class a
  {
    public List<AppBrandBackgroundRunningApp> jVA;
    public List<AppBrandBackgroundRunningApp> jVB;
  }
  
  public static final class b
  {
    public final Notification jVC;
    public final int notificationId;
    
    public b(Notification paramNotification, int paramInt)
    {
      this.jVC = paramNotification;
      this.notificationId = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundrunning.d
 * JD-Core Version:    0.7.0.1
 */