package com.tencent.mm.booter.notification;

import android.app.Notification;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.notification.a.g;
import com.tencent.mm.booter.notification.queue.NotificationQueue;
import com.tencent.mm.booter.notification.queue.NotificationQueue.ParcelNotificationQueue;
import com.tencent.mm.m.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.LauncherUI;
import java.lang.reflect.Field;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d
{
  private static boolean eaH;
  private static boolean eaI;
  private static boolean eaJ;
  private static int eaK;
  private static int eaL;
  private static boolean eaM;
  private static String eaN;
  public static boolean eaO;
  public static boolean eaP;
  private static int eaQ;
  private static boolean eaR;
  private static Uri eaS;
  
  static
  {
    AppMethodBeat.i(15950);
    eaH = true;
    eaI = true;
    eaJ = false;
    eaK = -1;
    eaL = -1;
    eaM = true;
    eaN = "samsung";
    eaO = true;
    eaP = false;
    eaQ = -1;
    eaR = true;
    eaS = Uri.parse("content://com.android.badge/badge");
    AppMethodBeat.o(15950);
  }
  
  private static void A(String paramString, int paramInt)
  {
    AppMethodBeat.i(15947);
    if (com.tencent.mm.sdk.platformtools.ah.getContext() == null)
    {
      ab.printErrStackTrace("MicroMsg.BusinessNotification", null, "normal badge context is null", new Object[0]);
      AppMethodBeat.o(15947);
      return;
    }
    Context localContext = com.tencent.mm.sdk.platformtools.ah.getContext();
    int i = paramInt;
    if (paramInt < 0) {
      i = f.Nm();
    }
    c(localContext, paramString, i);
    AppMethodBeat.o(15947);
  }
  
  private static boolean IM()
  {
    AppMethodBeat.i(15946);
    if (eaP)
    {
      boolean bool = eaO;
      AppMethodBeat.o(15946);
      return bool;
    }
    eaP = true;
    if (!Build.BRAND.equals(eaN))
    {
      eaO = false;
      AppMethodBeat.o(15946);
      return false;
    }
    eaO = true;
    AppMethodBeat.o(15946);
    return true;
  }
  
  public static int a(Notification paramNotification, g paramg)
  {
    AppMethodBeat.i(15945);
    if ((paramNotification == null) || (!eaH))
    {
      AppMethodBeat.o(15945);
      return 0;
    }
    int i;
    if (paramg == null) {
      i = 0;
    }
    try
    {
      for (;;)
      {
        paramg = Class.forName("android.app.MiuiNotification").newInstance();
        Field localField = paramg.getClass().getDeclaredField("messageCount");
        localField.setAccessible(true);
        localField.set(paramg, Integer.valueOf(i));
        paramNotification.getClass().getField("extraNotification").set(paramNotification, paramg);
        ab.i("MicroMsg.BusinessNotification", "miuiNotification: %d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(15945);
        return i;
        int j = paramg.ebJ;
        paramg = com.tencent.mm.booter.notification.queue.b.IO().ebj;
        if (paramg.ebi == null) {
          paramg.restore();
        }
        paramg = paramg.ebi.iterator();
        for (i = 0; paramg.hasNext(); i = ((NotificationItem)paramg.next()).ebc + i) {}
        i = j - i;
      }
    }
    catch (NoSuchFieldException paramNotification)
    {
      for (;;)
      {
        eaH = false;
      }
    }
    catch (IllegalArgumentException paramNotification)
    {
      for (;;)
      {
        eaH = false;
      }
    }
    catch (IllegalAccessException paramNotification)
    {
      for (;;)
      {
        eaH = false;
      }
    }
    catch (ClassNotFoundException paramNotification)
    {
      for (;;)
      {
        eaH = false;
      }
    }
    catch (InstantiationException paramNotification)
    {
      for (;;)
      {
        eaH = false;
      }
    }
    catch (Exception paramNotification)
    {
      for (;;)
      {
        eaH = false;
      }
    }
  }
  
  public static void bG(boolean paramBoolean)
  {
    AppMethodBeat.i(15944);
    if (!eaR)
    {
      AppMethodBeat.o(15944);
      return;
    }
    Object localObject = com.tencent.mm.sdk.platformtools.ah.getContext();
    if (localObject == null)
    {
      AppMethodBeat.o(15944);
      return;
    }
    localObject = ((Context)localObject).getContentResolver();
    if (localObject == null)
    {
      AppMethodBeat.o(15944);
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        ab.i("MicroMsg.BusinessNotification", "sync all user badge");
        localObject = ((ContentResolver)localObject).call(eaS, "getShortcutList", null, null);
        if (localObject == null)
        {
          ab.i("MicroMsg.BusinessNotification", "getShortcutList return null");
          AppMethodBeat.o(15944);
          return;
        }
        localObject = ((Bundle)localObject).getString("shortcut_list");
        if (localObject != null)
        {
          localObject = new JSONArray((String)localObject);
          i = 0;
          if (i < ((JSONArray)localObject).length())
          {
            String str = ((JSONObject)((JSONArray)localObject).get(i)).getString("app_shortcut_custom_id");
            if ((str == null) || (str.equalsIgnoreCase("null"))) {
              break label208;
            }
            str = com.tencent.mm.plugin.base.model.b.Gz(str);
            if (paramBoolean)
            {
              j = 0;
              z(str, j);
              break label208;
            }
            int j = f.ly(str);
            continue;
          }
        }
        AppMethodBeat.o(15944);
        return;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.BusinessNotification", localException, "sync all user badge: no support getShortcutList", new Object[0]);
        AppMethodBeat.o(15944);
        return;
      }
      label208:
      i += 1;
    }
  }
  
  private static boolean c(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(15948);
    com.tencent.mm.sdk.g.d.post(new d.1(paramContext, paramString, paramInt), "normalNotification");
    AppMethodBeat.o(15948);
    return true;
  }
  
  public static void ik(int paramInt)
  {
    AppMethodBeat.i(15942);
    Object localObject;
    int i;
    if ((com.tencent.mm.sdk.platformtools.ah.getContext() != null) && (IM()))
    {
      localObject = com.tencent.mm.sdk.platformtools.ah.getContext();
      if (paramInt != -1) {
        break label254;
      }
      i = f.Nm();
    }
    for (;;)
    {
      if ((localObject != null) && (IM()) && (eaQ != i))
      {
        eaQ = i;
        Intent localIntent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
        localIntent.putExtra("badge_count", i);
        localIntent.putExtra("badge_count_package_name", com.tencent.mm.sdk.platformtools.ah.getPackageName());
        localIntent.putExtra("badge_count_class_name", LauncherUI.class.getName());
        ab.i("MicroMsg.BusinessNotification", "samsungNotification: %d, %s", new Object[] { Integer.valueOf(i), Build.BRAND });
        ((Context)localObject).sendBroadcast(localIntent);
      }
      label150:
      boolean bool;
      if (eaM)
      {
        if (Build.VERSION.SDK_INT < 11) {
          eaM = false;
        }
      }
      else
      {
        if (!eaJ) {
          break label411;
        }
        bool = eaI;
        label160:
        if ((!bool) || (eaK == paramInt)) {}
      }
      try
      {
        localObject = new Intent("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
        ((Intent)localObject).putExtra("packageName", com.tencent.mm.sdk.platformtools.ah.getPackageName());
        ((Intent)localObject).putExtra("className", LauncherUI.class.getName());
        ((Intent)localObject).putExtra("notificationNum", paramInt);
        com.tencent.mm.sdk.platformtools.ah.getContext().sendBroadcast((Intent)localObject);
        ab.i("MicroMsg.BusinessNotification", "vivo badge: %d", new Object[] { Integer.valueOf(paramInt) });
        A(null, paramInt);
        AppMethodBeat.o(15942);
        return;
        label254:
        i = paramInt;
        continue;
        if (eaL == paramInt) {
          break label150;
        }
        for (;;)
        {
          try
          {
            localObject = new Bundle();
            ((Bundle)localObject).putString("package", com.tencent.mm.sdk.platformtools.ah.getPackageName());
            ((Bundle)localObject).putString("class", LauncherUI.class.getName());
            ((Bundle)localObject).putInt("badgenumber", paramInt);
            if (com.tencent.mm.sdk.platformtools.ah.getContext().getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", null, (Bundle)localObject) == null) {
              break label406;
            }
            bool = true;
            eaM = bool;
            ab.i("MicroMsg.BusinessNotification", "huawei badge: %d, %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(eaM) });
          }
          catch (Exception localException1)
          {
            ab.i("MicroMsg.BusinessNotification", "no huawei badge");
            ab.e("MicroMsg.BusinessNotification", "alvin: no badge" + localException1.toString());
            eaM = false;
          }
          break;
          label406:
          bool = false;
        }
        label411:
        eaJ = true;
        if (!Build.BRAND.equals("vivo"))
        {
          eaI = false;
          bool = false;
          break label160;
        }
        eaI = true;
        bool = true;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          eaI = false;
          ab.printErrStackTrace("MicroMsg.BusinessNotification", localException2, "", new Object[0]);
        }
      }
    }
  }
  
  public static void z(String paramString, int paramInt)
  {
    AppMethodBeat.i(15943);
    if (com.tencent.mm.platformtools.ah.isNullOrNil(paramString))
    {
      ab.printErrStackTrace("MicroMsg.BusinessNotification", null, "syncUserBadge username is null", new Object[0]);
      AppMethodBeat.o(15943);
      return;
    }
    paramString = com.tencent.mm.plugin.base.model.b.GA(paramString);
    if (com.tencent.mm.platformtools.ah.isNullOrNil(paramString))
    {
      AppMethodBeat.o(15943);
      return;
    }
    A(paramString, paramInt);
    AppMethodBeat.o(15943);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.notification.d
 * JD-Core Version:    0.7.0.1
 */