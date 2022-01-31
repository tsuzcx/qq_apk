package com.tencent.mm.booter.notification;

import android.app.Notification;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mm.booter.notification.a.g;
import com.tencent.mm.booter.notification.queue.NotificationQueue;
import com.tencent.mm.booter.notification.queue.NotificationQueue.ParcelNotificationQueue;
import com.tencent.mm.m.f;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.LauncherUI;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d
{
  private static Uri djA = Uri.parse("content://com.android.badge/badge");
  private static boolean djp = true;
  private static boolean djq = true;
  private static boolean djr = false;
  private static int djs = -1;
  private static int djt = -1;
  private static boolean dju = true;
  private static String djv = "samsung";
  public static boolean djw = true;
  public static boolean djx = false;
  private static int djy = -1;
  private static boolean djz = true;
  
  public static int a(Notification paramNotification, g paramg)
  {
    if ((paramNotification == null) || (!djp)) {
      return 0;
    }
    int i;
    if (paramg == null) {
      i = 0;
    }
    try
    {
      paramg = Class.forName("android.app.MiuiNotification").newInstance();
      Field localField = paramg.getClass().getDeclaredField("messageCount");
      localField.setAccessible(true);
      localField.set(paramg, Integer.valueOf(i));
      paramNotification.getClass().getField("extraNotification").set(paramNotification, paramg);
      y.i("MicroMsg.BusinessNotification", "miuiNotification: %d", new Object[] { Integer.valueOf(i) });
      return i;
    }
    catch (NoSuchFieldException paramNotification)
    {
      for (;;)
      {
        djp = false;
        return i;
        int j = paramg.dko;
        paramg = com.tencent.mm.booter.notification.queue.b.wz().djP;
        if (paramg.djO == null) {
          paramg.restore();
        }
        paramg = paramg.djO.iterator();
        for (i = 0; paramg.hasNext(); i = ((NotificationItem)paramg.next()).djI + i) {}
        i = j - i;
      }
    }
    catch (IllegalArgumentException paramNotification)
    {
      djp = false;
      return i;
    }
    catch (IllegalAccessException paramNotification)
    {
      djp = false;
      return i;
    }
    catch (ClassNotFoundException paramNotification)
    {
      djp = false;
      return i;
    }
    catch (InstantiationException paramNotification)
    {
      djp = false;
      return i;
    }
    catch (Exception paramNotification)
    {
      djp = false;
    }
    return i;
  }
  
  public static void be(boolean paramBoolean)
  {
    if (!djz) {}
    for (;;)
    {
      return;
      Object localObject1 = ae.getContext();
      if (localObject1 != null)
      {
        localObject1 = ((Context)localObject1).getContentResolver();
        if (localObject1 != null)
        {
          try
          {
            y.i("MicroMsg.BusinessNotification", "sync all user badge");
            localObject1 = ((ContentResolver)localObject1).call(djA, "getShortcutList", null, null);
            if (localObject1 == null)
            {
              y.i("MicroMsg.BusinessNotification", "getShortcutList return null");
              return;
            }
          }
          catch (Exception localException)
          {
            y.printErrStackTrace("MicroMsg.BusinessNotification", localException, "sync all user badge: no support getShortcutList", new Object[0]);
            return;
          }
          Object localObject2 = localException.getString("shortcut_list");
          if (localObject2 != null)
          {
            localObject2 = new JSONArray((String)localObject2);
            int i = 0;
            while (i < ((JSONArray)localObject2).length())
            {
              String str = ((JSONObject)((JSONArray)localObject2).get(i)).getString("app_shortcut_custom_id");
              if ((str != null) && (!str.equalsIgnoreCase("null")))
              {
                str = com.tencent.mm.plugin.base.model.b.xG(str);
                if (paramBoolean) {}
                for (int j = 0;; j = f.fl(str))
                {
                  u(str, j);
                  break;
                }
              }
              i += 1;
            }
          }
        }
      }
    }
  }
  
  private static boolean c(Context paramContext, String paramString, int paramInt)
  {
    boolean bool = true;
    if (!djz) {
      return false;
    }
    for (;;)
    {
      try
      {
        Bundle localBundle = new Bundle();
        if (paramString != null)
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(paramString);
          localBundle.putStringArrayList("app_shortcut_custom_id", localArrayList);
          localBundle.putInt("app_badge_count", paramInt);
          localBundle.putString("app_shortcut_class_name", ae.cqQ() + ".ui.LauncherUI");
          paramContext = paramContext.getContentResolver();
          if ((paramContext != null) && (paramContext.call(djA, "setAppBadgeCount", null, localBundle) != null))
          {
            y.i("MicroMsg.BusinessNotification", "shortcutId: %s, normalNotification badge count: %d, result: %b", new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(bool) });
            return bool;
          }
        }
        else
        {
          localBundle.putStringArrayList("app_shortcut_custom_id", null);
          continue;
        }
        bool = false;
      }
      catch (Exception paramContext)
      {
        djz = false;
        y.i("MicroMsg.BusinessNotification", "no support normal badge");
        y.e("MicroMsg.BusinessNotification", "alvin: no support normal badge");
        return false;
      }
    }
  }
  
  public static void fW(int paramInt)
  {
    Object localObject;
    int i;
    if ((ae.getContext() != null) && (wx()))
    {
      localObject = ae.getContext();
      if (paramInt != -1) {
        break label242;
      }
      i = f.Ax();
    }
    for (;;)
    {
      if ((localObject != null) && (wx()) && (djy != i))
      {
        djy = i;
        Intent localIntent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
        localIntent.putExtra("badge_count", i);
        localIntent.putExtra("badge_count_package_name", ae.getPackageName());
        localIntent.putExtra("badge_count_class_name", LauncherUI.class.getName());
        y.i("MicroMsg.BusinessNotification", "samsungNotification: %d, %s", new Object[] { Integer.valueOf(i), Build.BRAND });
        ((Context)localObject).sendBroadcast(localIntent);
      }
      label144:
      boolean bool;
      if (dju)
      {
        if (Build.VERSION.SDK_INT < 11) {
          dju = false;
        }
      }
      else
      {
        if (!djr) {
          break label399;
        }
        bool = djq;
        label154:
        if ((!bool) || (djs == paramInt)) {}
      }
      try
      {
        localObject = new Intent("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
        ((Intent)localObject).putExtra("packageName", ae.getPackageName());
        ((Intent)localObject).putExtra("className", LauncherUI.class.getName());
        ((Intent)localObject).putExtra("notificationNum", paramInt);
        ae.getContext().sendBroadcast((Intent)localObject);
        y.i("MicroMsg.BusinessNotification", "vivo badge: %d", new Object[] { Integer.valueOf(paramInt) });
        v(null, paramInt);
        return;
        label242:
        i = paramInt;
        continue;
        if (djt == paramInt) {
          break label144;
        }
        for (;;)
        {
          try
          {
            localObject = new Bundle();
            ((Bundle)localObject).putString("package", ae.getPackageName());
            ((Bundle)localObject).putString("class", LauncherUI.class.getName());
            ((Bundle)localObject).putInt("badgenumber", paramInt);
            if (ae.getContext().getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", null, (Bundle)localObject) == null) {
              break label394;
            }
            bool = true;
            dju = bool;
            y.i("MicroMsg.BusinessNotification", "huawei badge: %d, %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(dju) });
          }
          catch (Exception localException1)
          {
            y.i("MicroMsg.BusinessNotification", "no huawei badge");
            y.e("MicroMsg.BusinessNotification", "alvin: no badge" + localException1.toString());
            dju = false;
          }
          break;
          label394:
          bool = false;
        }
        label399:
        djr = true;
        if (!Build.BRAND.equals("vivo"))
        {
          djq = false;
          bool = false;
          break label154;
        }
        djq = true;
        bool = true;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          djq = false;
          y.printErrStackTrace("MicroMsg.BusinessNotification", localException2, "", new Object[0]);
        }
      }
    }
  }
  
  public static void u(String paramString, int paramInt)
  {
    if (ah.bl(paramString)) {
      y.printErrStackTrace("MicroMsg.BusinessNotification", null, "syncUserBadge username is null", new Object[0]);
    }
    do
    {
      return;
      paramString = com.tencent.mm.plugin.base.model.b.xH(paramString);
    } while (ah.bl(paramString));
    v(paramString, paramInt);
  }
  
  private static void v(String paramString, int paramInt)
  {
    if (ae.getContext() == null)
    {
      y.printErrStackTrace("MicroMsg.BusinessNotification", null, "normal badge context is null", new Object[0]);
      return;
    }
    Context localContext = ae.getContext();
    int i = paramInt;
    if (paramInt < 0) {
      i = f.Ax();
    }
    c(localContext, paramString, i);
  }
  
  private static boolean wx()
  {
    if (djx) {
      return djw;
    }
    djx = true;
    if (!Build.BRAND.equals(djv))
    {
      djw = false;
      return false;
    }
    djw = true;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.notification.d
 * JD-Core Version:    0.7.0.1
 */