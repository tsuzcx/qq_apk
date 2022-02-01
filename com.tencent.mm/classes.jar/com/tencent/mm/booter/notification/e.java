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
  private static boolean iRX;
  private static boolean iRY;
  private static boolean iRZ;
  private static int iSa;
  private static int iSb;
  private static boolean iSc;
  private static String iSd;
  public static boolean iSe;
  public static boolean iSf;
  private static int iSg;
  private static boolean iSh;
  private static Uri iSi;
  
  static
  {
    AppMethodBeat.i(19982);
    iRX = true;
    iRY = true;
    iRZ = false;
    iSa = -1;
    iSb = -1;
    iSc = true;
    iSd = "samsung";
    iSe = true;
    iSf = false;
    iSg = -1;
    iSh = true;
    iSi = Uri.parse("content://com.android.badge/badge");
    AppMethodBeat.o(19982);
  }
  
  public static void V(String paramString, int paramInt)
  {
    AppMethodBeat.i(19975);
    if (Util.isNullOrNil(paramString))
    {
      Log.printErrStackTrace("MicroMsg.BusinessNotification", null, "syncUserBadge username is null", new Object[0]);
      AppMethodBeat.o(19975);
      return;
    }
    paramString = com.tencent.mm.plugin.base.model.b.aoF(paramString);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(19975);
      return;
    }
    W(paramString, paramInt);
    AppMethodBeat.o(19975);
  }
  
  private static void W(String paramString, int paramInt)
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
      i = com.tencent.mm.n.g.awZ();
    }
    c(localContext, paramString, i);
    AppMethodBeat.o(19979);
  }
  
  public static int a(Notification paramNotification, com.tencent.mm.booter.notification.a.g paramg)
  {
    AppMethodBeat.i(19977);
    if ((paramNotification == null) || (!iRX))
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
        int j = paramg.aru();
        paramg = com.tencent.mm.booter.notification.queue.b.arh().iSz;
        if (paramg.iSx == null) {
          paramg.restore();
        }
        paramg = paramg.iSx.iterator();
        for (i = 0; paramg.hasNext(); i = ((NotificationItem)paramg.next()).iSs + i) {}
        i = j - i;
      }
    }
    catch (NoSuchFieldException paramNotification)
    {
      for (;;)
      {
        iRX = false;
      }
    }
    catch (IllegalArgumentException paramNotification)
    {
      for (;;)
      {
        iRX = false;
      }
    }
    catch (IllegalAccessException paramNotification)
    {
      for (;;)
      {
        iRX = false;
      }
    }
    catch (ClassNotFoundException paramNotification)
    {
      for (;;)
      {
        iRX = false;
      }
    }
    catch (InstantiationException paramNotification)
    {
      for (;;)
      {
        iRX = false;
      }
    }
    catch (Exception paramNotification)
    {
      for (;;)
      {
        iRX = false;
      }
    }
  }
  
  private static boolean are()
  {
    AppMethodBeat.i(19978);
    if (iSf)
    {
      boolean bool = iSe;
      AppMethodBeat.o(19978);
      return bool;
    }
    iSf = true;
    if (!Build.BRAND.equals(iSd))
    {
      iSe = false;
      AppMethodBeat.o(19978);
      return false;
    }
    iSe = true;
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
  
  public static void dK(boolean paramBoolean)
  {
    AppMethodBeat.i(19976);
    if (!iSh)
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
        localObject = ((ContentResolver)localObject).call(iSi, "getShortcutList", null, null);
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
            str = com.tencent.mm.plugin.base.model.b.aoE(str);
            if (paramBoolean)
            {
              j = 0;
              V(str, j);
              break label212;
            }
            int j = com.tencent.mm.n.g.Lh(str);
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
  
  public static void qj(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(19974);
    Object localObject;
    int i;
    if ((MMApplicationContext.getContext() != null) && (are()))
    {
      localObject = MMApplicationContext.getContext();
      if (paramInt != -1) {
        break label256;
      }
      i = com.tencent.mm.n.g.awZ();
    }
    for (;;)
    {
      if ((localObject != null) && (are()) && (iSg != i))
      {
        iSg = i;
        Intent localIntent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
        localIntent.putExtra("badge_count", i);
        localIntent.putExtra("badge_count_package_name", MMApplicationContext.getPackageName());
        localIntent.putExtra("badge_count_class_name", LauncherUI.class.getName());
        Log.i("MicroMsg.BusinessNotification", "samsungNotification: %d, %s", new Object[] { Integer.valueOf(i), Build.BRAND });
        ((Context)localObject).sendBroadcast(localIntent);
      }
      if (iSc)
      {
        if (Build.VERSION.SDK_INT < 11) {
          iSc = false;
        }
      }
      else
      {
        label152:
        if (!iRZ) {
          break label285;
        }
        bool = iRY;
        label162:
        if ((!bool) || (iSa == paramInt)) {}
      }
      try
      {
        localObject = new Intent("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
        ((Intent)localObject).putExtra("packageName", MMApplicationContext.getPackageName());
        ((Intent)localObject).putExtra("className", LauncherUI.class.getName());
        ((Intent)localObject).putExtra("notificationNum", paramInt);
        MMApplicationContext.getContext().sendBroadcast((Intent)localObject);
        Log.i("MicroMsg.BusinessNotification", "vivo badge: %d", new Object[] { Integer.valueOf(paramInt) });
        W(null, paramInt);
        AppMethodBeat.o(19974);
        return;
        label256:
        i = paramInt;
        continue;
        if (iSb == paramInt) {
          break label152;
        }
        ThreadPool.post(new e.1(paramInt), "huaweiNotification");
        break label152;
        label285:
        iRZ = true;
        if (!Build.BRAND.equals("vivo"))
        {
          iRY = false;
          bool = false;
          break label162;
        }
        iRY = true;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          iRY = false;
          Log.printErrStackTrace("MicroMsg.BusinessNotification", localException, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.booter.notification.e
 * JD-Core Version:    0.7.0.1
 */