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
import com.tencent.mm.booter.notification.queue.NotificationQueue;
import com.tencent.mm.booter.notification.queue.NotificationQueue.ParcelNotificationQueue;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.LauncherUI;
import java.lang.reflect.Field;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e
{
  private static boolean gnO;
  private static boolean gnP;
  private static boolean gnQ;
  private static int gnR;
  private static int gnS;
  private static boolean gnT;
  private static String gnU;
  public static boolean gnV;
  public static boolean gnW;
  private static int gnX;
  private static boolean gnY;
  private static Uri gnZ;
  
  static
  {
    AppMethodBeat.i(19982);
    gnO = true;
    gnP = true;
    gnQ = false;
    gnR = -1;
    gnS = -1;
    gnT = true;
    gnU = "samsung";
    gnV = true;
    gnW = false;
    gnX = -1;
    gnY = true;
    gnZ = Uri.parse("content://com.android.badge/badge");
    AppMethodBeat.o(19982);
  }
  
  public static void D(String paramString, int paramInt)
  {
    AppMethodBeat.i(19975);
    if (Util.isNullOrNil(paramString))
    {
      Log.printErrStackTrace("MicroMsg.BusinessNotification", null, "syncUserBadge username is null", new Object[0]);
      AppMethodBeat.o(19975);
      return;
    }
    paramString = com.tencent.mm.plugin.base.model.b.agZ(paramString);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(19975);
      return;
    }
    E(paramString, paramInt);
    AppMethodBeat.o(19975);
  }
  
  private static void E(String paramString, int paramInt)
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
      i = com.tencent.mm.n.g.aqG();
    }
    c(localContext, paramString, i);
    AppMethodBeat.o(19979);
  }
  
  public static int a(Notification paramNotification, com.tencent.mm.booter.notification.a.g paramg)
  {
    AppMethodBeat.i(19977);
    if ((paramNotification == null) || (!gnO))
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
        int j = paramg.alw();
        paramg = com.tencent.mm.booter.notification.queue.b.alj().goq;
        if (paramg.goo == null) {
          paramg.restore();
        }
        paramg = paramg.goo.iterator();
        for (i = 0; paramg.hasNext(); i = ((NotificationItem)paramg.next()).goj + i) {}
        i = j - i;
      }
    }
    catch (NoSuchFieldException paramNotification)
    {
      for (;;)
      {
        gnO = false;
      }
    }
    catch (IllegalArgumentException paramNotification)
    {
      for (;;)
      {
        gnO = false;
      }
    }
    catch (IllegalAccessException paramNotification)
    {
      for (;;)
      {
        gnO = false;
      }
    }
    catch (ClassNotFoundException paramNotification)
    {
      for (;;)
      {
        gnO = false;
      }
    }
    catch (InstantiationException paramNotification)
    {
      for (;;)
      {
        gnO = false;
      }
    }
    catch (Exception paramNotification)
    {
      for (;;)
      {
        gnO = false;
      }
    }
  }
  
  private static boolean alh()
  {
    AppMethodBeat.i(19978);
    if (gnW)
    {
      boolean bool = gnV;
      AppMethodBeat.o(19978);
      return bool;
    }
    gnW = true;
    if (!Build.BRAND.equals(gnU))
    {
      gnV = false;
      AppMethodBeat.o(19978);
      return false;
    }
    gnV = true;
    AppMethodBeat.o(19978);
    return true;
  }
  
  private static boolean c(Context paramContext, final String paramString, final int paramInt)
  {
    AppMethodBeat.i(19980);
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(184895);
        e.d(this.val$context, paramString, paramInt);
        AppMethodBeat.o(184895);
      }
    }, "normalNotification");
    AppMethodBeat.o(19980);
    return true;
  }
  
  public static void dk(boolean paramBoolean)
  {
    AppMethodBeat.i(19976);
    if (!gnY)
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
        localObject = ((ContentResolver)localObject).call(gnZ, "getShortcutList", null, null);
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
              break label212;
            }
            str = com.tencent.mm.plugin.base.model.b.agY(str);
            if (paramBoolean)
            {
              j = 0;
              D(str, j);
              break label212;
            }
            int j = com.tencent.mm.n.g.Eo(str);
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
      label212:
      i += 1;
    }
  }
  
  public static void nU(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(19974);
    Object localObject;
    int i;
    if ((MMApplicationContext.getContext() != null) && (alh()))
    {
      localObject = MMApplicationContext.getContext();
      if (paramInt != -1) {
        break label256;
      }
      i = com.tencent.mm.n.g.aqG();
    }
    for (;;)
    {
      if ((localObject != null) && (alh()) && (gnX != i))
      {
        gnX = i;
        Intent localIntent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
        localIntent.putExtra("badge_count", i);
        localIntent.putExtra("badge_count_package_name", MMApplicationContext.getPackageName());
        localIntent.putExtra("badge_count_class_name", LauncherUI.class.getName());
        Log.i("MicroMsg.BusinessNotification", "samsungNotification: %d, %s", new Object[] { Integer.valueOf(i), Build.BRAND });
        ((Context)localObject).sendBroadcast(localIntent);
      }
      if (gnT)
      {
        if (Build.VERSION.SDK_INT < 11) {
          gnT = false;
        }
      }
      else
      {
        label152:
        if (!gnQ) {
          break label285;
        }
        bool = gnP;
        label162:
        if ((!bool) || (gnR == paramInt)) {}
      }
      try
      {
        localObject = new Intent("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
        ((Intent)localObject).putExtra("packageName", MMApplicationContext.getPackageName());
        ((Intent)localObject).putExtra("className", LauncherUI.class.getName());
        ((Intent)localObject).putExtra("notificationNum", paramInt);
        MMApplicationContext.getContext().sendBroadcast((Intent)localObject);
        Log.i("MicroMsg.BusinessNotification", "vivo badge: %d", new Object[] { Integer.valueOf(paramInt) });
        E(null, paramInt);
        AppMethodBeat.o(19974);
        return;
        label256:
        i = paramInt;
        continue;
        if (gnS == paramInt) {
          break label152;
        }
        ThreadPool.post(new e.1(paramInt), "huaweiNotification");
        break label152;
        label285:
        gnQ = true;
        if (!Build.BRAND.equals("vivo"))
        {
          gnP = false;
          bool = false;
          break label162;
        }
        gnP = true;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          gnP = false;
          Log.printErrStackTrace("MicroMsg.BusinessNotification", localException, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.notification.e
 * JD-Core Version:    0.7.0.1
 */