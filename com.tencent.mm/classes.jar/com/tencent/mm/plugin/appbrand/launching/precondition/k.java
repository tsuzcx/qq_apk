package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import com.tencent.luggage.b.e;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.launching.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.protocal.c.bfh;
import com.tencent.mm.protocal.c.fe;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vending.j.c;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

final class k
{
  static void a(Context paramContext, AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    y.i("MicroMsg.AppBrand.PreconditionUtil", "startAppOnInitConfigGot, %s", new Object[] { paramAppBrandInitConfigWC });
    int i;
    String str2;
    String str3;
    int j;
    com.tencent.mm.plugin.appbrand.backgroundfetch.g localg;
    if ((paramAppBrandInitConfigWC != null) && (!bk.bl(paramAppBrandInitConfigWC.appId)) && (!com.tencent.mm.plugin.appbrand.task.g.wr(paramAppBrandInitConfigWC.appId)))
    {
      i = 1;
      if (i != 0)
      {
        str2 = paramAppBrandInitConfigWC.appId;
        str3 = paramAppBrandInitConfigWC.username;
        j = paramAppBrandInitConfigWC.fEL;
        ??? = paramAppBrandInitConfigWC.fPq;
        i = paramAppBrandStatObject.scene;
        localg = new com.tencent.mm.plugin.appbrand.backgroundfetch.g();
        if (!bk.bl(str3)) {
          break label196;
        }
        y.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler.javayhu", "preFetchData, username is null");
      }
    }
    label190:
    label196:
    Object localObject2;
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.launching.b.b(paramAppBrandInitConfigWC, paramAppBrandStatObject);
      i = com.tencent.mm.plugin.appbrand.task.g.b(paramContext, paramAppBrandInitConfigWC, paramAppBrandStatObject);
      if ((paramContext instanceof Activity)) {
        ((com.tencent.mm.plugin.appbrand.ui.r)e.i(com.tencent.mm.plugin.appbrand.ui.r.class)).a((Activity)paramContext, paramAppBrandStatObject);
      }
      y.i("MicroMsg.AppBrand.AppLaunchLogic", "[applaunch] startAppOnInitConfigGot %s", new Object[] { paramAppBrandInitConfigWC });
      if (i == 1) {
        new d(paramAppBrandInitConfigWC, paramAppBrandStatObject).alD();
      }
      paramContext = com.tencent.mm.plugin.appbrand.config.g.aed();
      paramAppBrandStatObject = paramAppBrandInitConfigWC.username;
      if ((paramAppBrandInitConfigWC != null) && (!bk.bl(paramAppBrandInitConfigWC.appId))) {
        break label529;
      }
      return;
      i = 0;
      break;
      localObject2 = com.tencent.mm.plugin.appbrand.config.r.sr(str3);
      if ((localObject2 == null) || (((com.tencent.mm.plugin.appbrand.backgroundfetch.a)localObject2).fKF)) {
        break label243;
      }
      y.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler.javayhu", "preFetchData, app(%s_v%d) can not pre fetch data", new Object[] { str3, Integer.valueOf(j) });
    }
    label243:
    if (com.tencent.mm.plugin.appbrand.backgroundfetch.b.ay(str3, j))
    {
      if (bk.bl((String)???)) {
        break label609;
      }
      j = ((String)???).lastIndexOf('?');
      if (j > 0)
      {
        localObject2 = ((String)???).substring(0, j);
        if (j >= ((String)???).length() - 1) {
          break label603;
        }
        ??? = ((String)???).substring(j + 1);
      }
    }
    for (;;)
    {
      for (;;)
      {
        localObject2 = com.tencent.mm.vending.j.a.r(localObject2, ???);
        ??? = (String)((com.tencent.mm.vending.j.b)localObject2).get(0);
        String str1 = (String)((c)localObject2).get(1);
        y.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler.javayhu", "preFetchDataInternal, app(%s) pre fetch data start, path:%s, query:%s, scene:%d", new Object[] { str3, ???, str1, Integer.valueOf(i) });
        localObject2 = new fe();
        ((fe)localObject2).bOL = str2;
        ((fe)localObject2).username = str3;
        ((fe)localObject2).syS = 0;
        ((fe)localObject2).syT = new bfh();
        ((fe)localObject2).syT.scene = i;
        if (!bk.bl((String)???)) {
          ((fe)localObject2).syT.path = ((String)???);
        }
        if (!bk.bl(str1)) {
          ((fe)localObject2).syT.bVk = str1;
        }
        ??? = new LinkedList();
        ((List)???).add(localObject2);
        com.tencent.mm.plugin.appbrand.backgroundfetch.b.a(0, (List)???, localg);
        break;
        str1 = null;
        localObject2 = ???;
        ??? = str1;
        continue;
        y.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler.javayhu", "preFetchData, app(%s_v%d) is not star app", new Object[] { str3, Integer.valueOf(j) });
        break;
        label529:
        synchronized (paramContext.fPu)
        {
          paramContext.fPu.put(paramAppBrandInitConfigWC.appId, paramAppBrandInitConfigWC);
          if (bk.bl(paramAppBrandStatObject)) {
            break label190;
          }
          synchronized (paramContext.fPv)
          {
            paramContext.fPv.put(paramAppBrandStatObject, paramAppBrandInitConfigWC.appId);
            return;
          }
        }
      }
      label603:
      ??? = null;
      continue;
      label609:
      ??? = null;
      localObject2 = null;
    }
  }
  
  static String uY(String paramString)
  {
    if (bk.bl(paramString)) {
      return "";
    }
    paramString = new ComponentName(ae.getContext(), paramString);
    PackageManager localPackageManager = ae.getContext().getPackageManager();
    if (localPackageManager == null) {
      return "";
    }
    try
    {
      Object localObject = localPackageManager.getActivityInfo(paramString, 128);
      if (localObject == null) {
        return "";
      }
      localObject = ((ActivityInfo)localObject).processName;
      return localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      try
      {
        paramString = localPackageManager.getServiceInfo(paramString, 128);
        if (paramString == null) {
          return "";
        }
        paramString = paramString.processName;
        return paramString;
      }
      catch (PackageManager.NameNotFoundException paramString) {}
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.precondition.k
 * JD-Core Version:    0.7.0.1
 */