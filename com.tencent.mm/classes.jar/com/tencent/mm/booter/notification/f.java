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
import com.tencent.mm.k.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.LauncherUI;
import java.lang.reflect.Field;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f
{
  private static boolean ltU;
  private static boolean ltV;
  private static boolean ltW;
  private static int ltX;
  private static int ltY;
  private static boolean ltZ;
  private static String lua;
  public static boolean lub;
  public static boolean luc;
  private static int lud;
  private static boolean lue;
  private static Uri luf;
  
  static
  {
    AppMethodBeat.i(19982);
    ltU = true;
    ltV = true;
    ltW = false;
    ltX = -1;
    ltY = -1;
    ltZ = true;
    lua = "samsung";
    lub = true;
    luc = false;
    lud = -1;
    lue = true;
    luf = Uri.parse("content://com.android.badge/badge");
    AppMethodBeat.o(19982);
  }
  
  public static int a(Notification paramNotification, g paramg)
  {
    AppMethodBeat.i(19977);
    if ((paramNotification == null) || (!ltU))
    {
      AppMethodBeat.o(19977);
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
        Log.i("MicroMsg.BusinessNotification", "miuiNotification: %d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(19977);
        return i;
        int j = paramg.aLq();
        paramg = com.tencent.mm.booter.notification.queue.b.aLd().luv;
        if (paramg.luu == null) {
          paramg.restore();
        }
        paramg = paramg.luu.iterator();
        for (i = 0; paramg.hasNext(); i = ((NotificationItem)paramg.next()).lup + i) {}
        i = j - i;
      }
    }
    catch (NoSuchFieldException paramNotification)
    {
      for (;;)
      {
        ltU = false;
      }
    }
    catch (IllegalArgumentException paramNotification)
    {
      for (;;)
      {
        ltU = false;
      }
    }
    catch (IllegalAccessException paramNotification)
    {
      for (;;)
      {
        ltU = false;
      }
    }
    catch (ClassNotFoundException paramNotification)
    {
      for (;;)
      {
        ltU = false;
      }
    }
    catch (InstantiationException paramNotification)
    {
      for (;;)
      {
        ltU = false;
      }
    }
    catch (Exception paramNotification)
    {
      for (;;)
      {
        ltU = false;
      }
    }
  }
  
  public static void ae(String paramString, int paramInt)
  {
    AppMethodBeat.i(19975);
    if (Util.isNullOrNil(paramString))
    {
      Log.printErrStackTrace("MicroMsg.BusinessNotification", null, "syncUserBadge username is null", new Object[0]);
      AppMethodBeat.o(19975);
      return;
    }
    paramString = com.tencent.mm.plugin.base.model.b.aib(paramString);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(19975);
      return;
    }
    af(paramString, paramInt);
    AppMethodBeat.o(19975);
  }
  
  private static void af(String paramString, int paramInt)
  {
    AppMethodBeat.i(19979);
    if (MMApplicationContext.getContext() == null)
    {
      Log.printErrStackTrace("MicroMsg.BusinessNotification", null, "normal badge context is null", new Object[0]);
      AppMethodBeat.o(19979);
      return;
    }
    Context localContext = MMApplicationContext.getContext();
    int i = paramInt;
    if (paramInt < 0) {
      i = h.aRz();
    }
    c(localContext, paramString, i);
    AppMethodBeat.o(19979);
  }
  
  private static boolean c(Context paramContext, final String paramString, final int paramInt)
  {
    AppMethodBeat.i(19980);
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(184895);
        f.d(f.this, paramString, paramInt);
        AppMethodBeat.o(184895);
      }
    }, "normalNotification");
    AppMethodBeat.o(19980);
    return true;
  }
  
  public static void ew(boolean paramBoolean)
  {
    AppMethodBeat.i(19976);
    if (!lue)
    {
      AppMethodBeat.o(19976);
      return;
    }
    Object localObject = MMApplicationContext.getContext();
    if (localObject == null)
    {
      AppMethodBeat.o(19976);
      return;
    }
    localObject = ((Context)localObject).getContentResolver();
    if (localObject == null)
    {
      AppMethodBeat.o(19976);
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        Log.i("MicroMsg.BusinessNotification", "sync all user badge");
        localObject = ((ContentResolver)localObject).call(luf, "getShortcutList", null, null);
        if (localObject == null)
        {
          Log.i("MicroMsg.BusinessNotification", "getShortcutList return null");
          AppMethodBeat.o(19976);
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
              break label211;
            }
            str = com.tencent.mm.plugin.base.model.b.aia(str);
            if (paramBoolean)
            {
              j = 0;
              ae(str, j);
              break label211;
            }
            int j = h.DO(str);
            continue;
          }
        }
        AppMethodBeat.o(19976);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.BusinessNotification", localException, "sync all user badge: no support getShortcutList", new Object[0]);
        AppMethodBeat.o(19976);
        return;
      }
      label211:
      i += 1;
    }
  }
  
  private static boolean isSamsung()
  {
    AppMethodBeat.i(19978);
    if (luc)
    {
      boolean bool = lub;
      AppMethodBeat.o(19978);
      return bool;
    }
    luc = true;
    if (!Build.BRAND.equals(lua))
    {
      lub = false;
      AppMethodBeat.o(19978);
      return false;
    }
    lub = true;
    AppMethodBeat.o(19978);
    return true;
  }
  
  public static void qj(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(19974);
    Object localObject;
    int i;
    if ((MMApplicationContext.getContext() != null) && (isSamsung()))
    {
      localObject = MMApplicationContext.getContext();
      if (paramInt != -1) {
        break label256;
      }
      i = h.aRz();
    }
    for (;;)
    {
      if ((localObject != null) && (isSamsung()) && (lud != i))
      {
        lud = i;
        Intent localIntent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
        localIntent.putExtra("badge_count", i);
        localIntent.putExtra("badge_count_package_name", MMApplicationContext.getPackageName());
        localIntent.putExtra("badge_count_class_name", LauncherUI.class.getName());
        Log.i("MicroMsg.BusinessNotification", "samsungNotification: %d, %s", new Object[] { Integer.valueOf(i), Build.BRAND });
        ((Context)localObject).sendBroadcast(localIntent);
      }
      if (ltZ)
      {
        if (Build.VERSION.SDK_INT < 11) {
          ltZ = false;
        }
      }
      else
      {
        label152:
        if (!ltW) {
          break label285;
        }
        bool = ltV;
        label162:
        if ((!bool) || (ltX == paramInt)) {}
      }
      try
      {
        localObject = new Intent("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
        ((Intent)localObject).putExtra("packageName", MMApplicationContext.getPackageName());
        ((Intent)localObject).putExtra("className", LauncherUI.class.getName());
        ((Intent)localObject).putExtra("notificationNum", paramInt);
        MMApplicationContext.getContext().sendBroadcast((Intent)localObject);
        Log.i("MicroMsg.BusinessNotification", "vivo badge: %d", new Object[] { Integer.valueOf(paramInt) });
        af(null, paramInt);
        AppMethodBeat.o(19974);
        return;
        label256:
        i = paramInt;
        continue;
        if (ltY == paramInt) {
          break label152;
        }
        ThreadPool.post(new f.1(paramInt), "huaweiNotification");
        break label152;
        label285:
        ltW = true;
        if (!Build.BRAND.equals("vivo"))
        {
          ltV = false;
          bool = false;
          break label162;
        }
        ltV = true;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ltV = false;
          Log.printErrStackTrace("MicroMsg.BusinessNotification", localException, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.notification.f
 * JD-Core Version:    0.7.0.1
 */