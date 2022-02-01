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
import com.tencent.mm.n.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.LauncherUI;
import java.lang.reflect.Field;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e
{
  private static int fGA;
  private static boolean fGB;
  private static String fGC;
  public static boolean fGD;
  public static boolean fGE;
  private static int fGF;
  private static boolean fGG;
  private static Uri fGH;
  private static boolean fGw;
  private static boolean fGx;
  private static boolean fGy;
  private static int fGz;
  
  static
  {
    AppMethodBeat.i(19982);
    fGw = true;
    fGx = true;
    fGy = false;
    fGz = -1;
    fGA = -1;
    fGB = true;
    fGC = "samsung";
    fGD = true;
    fGE = false;
    fGF = -1;
    fGG = true;
    fGH = Uri.parse("content://com.android.badge/badge");
    AppMethodBeat.o(19982);
  }
  
  public static void B(String paramString, int paramInt)
  {
    AppMethodBeat.i(19975);
    if (bt.isNullOrNil(paramString))
    {
      ad.printErrStackTrace("MicroMsg.BusinessNotification", null, "syncUserBadge username is null", new Object[0]);
      AppMethodBeat.o(19975);
      return;
    }
    paramString = com.tencent.mm.plugin.base.model.b.Wt(paramString);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(19975);
      return;
    }
    C(paramString, paramInt);
    AppMethodBeat.o(19975);
  }
  
  private static void C(String paramString, int paramInt)
  {
    AppMethodBeat.i(19979);
    if (aj.getContext() == null)
    {
      ad.printErrStackTrace("MicroMsg.BusinessNotification", null, "normal badge context is null", new Object[0]);
      AppMethodBeat.o(19979);
      return;
    }
    Context localContext = aj.getContext();
    int i = paramInt;
    if (paramInt < 0) {
      i = f.acx();
    }
    c(localContext, paramString, i);
    AppMethodBeat.o(19979);
  }
  
  private static boolean Xm()
  {
    AppMethodBeat.i(19978);
    if (fGE)
    {
      boolean bool = fGD;
      AppMethodBeat.o(19978);
      return bool;
    }
    fGE = true;
    if (!Build.BRAND.equals(fGC))
    {
      fGD = false;
      AppMethodBeat.o(19978);
      return false;
    }
    fGD = true;
    AppMethodBeat.o(19978);
    return true;
  }
  
  public static int a(Notification paramNotification, g paramg)
  {
    AppMethodBeat.i(19977);
    if ((paramNotification == null) || (!fGw))
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
        ad.i("MicroMsg.BusinessNotification", "miuiNotification: %d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(19977);
        return i;
        int j = paramg.Mo();
        paramg = com.tencent.mm.booter.notification.queue.b.Xo().fGX;
        if (paramg.fGW == null) {
          paramg.restore();
        }
        paramg = paramg.fGW.iterator();
        for (i = 0; paramg.hasNext(); i = ((NotificationItem)paramg.next()).fGR + i) {}
        i = j - i;
      }
    }
    catch (NoSuchFieldException paramNotification)
    {
      for (;;)
      {
        fGw = false;
      }
    }
    catch (IllegalArgumentException paramNotification)
    {
      for (;;)
      {
        fGw = false;
      }
    }
    catch (IllegalAccessException paramNotification)
    {
      for (;;)
      {
        fGw = false;
      }
    }
    catch (ClassNotFoundException paramNotification)
    {
      for (;;)
      {
        fGw = false;
      }
    }
    catch (InstantiationException paramNotification)
    {
      for (;;)
      {
        fGw = false;
      }
    }
    catch (Exception paramNotification)
    {
      for (;;)
      {
        fGw = false;
      }
    }
  }
  
  private static boolean c(Context paramContext, final String paramString, final int paramInt)
  {
    AppMethodBeat.i(19980);
    com.tencent.mm.sdk.g.b.c(new Runnable()
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
  
  public static void cB(boolean paramBoolean)
  {
    AppMethodBeat.i(19976);
    if (!fGG)
    {
      AppMethodBeat.o(19976);
      return;
    }
    Object localObject = aj.getContext();
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
        ad.i("MicroMsg.BusinessNotification", "sync all user badge");
        localObject = ((ContentResolver)localObject).call(fGH, "getShortcutList", null, null);
        if (localObject == null)
        {
          ad.i("MicroMsg.BusinessNotification", "getShortcutList return null");
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
            str = com.tencent.mm.plugin.base.model.b.Ws(str);
            if (paramBoolean)
            {
              j = 0;
              B(str, j);
              break label211;
            }
            int j = f.vD(str);
            continue;
          }
        }
        AppMethodBeat.o(19976);
        return;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.BusinessNotification", localException, "sync all user badge: no support getShortcutList", new Object[0]);
        AppMethodBeat.o(19976);
        return;
      }
      label211:
      i += 1;
    }
  }
  
  public static void kQ(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(19974);
    Object localObject;
    int i;
    if ((aj.getContext() != null) && (Xm()))
    {
      localObject = aj.getContext();
      if (paramInt != -1) {
        break label256;
      }
      i = f.acx();
    }
    for (;;)
    {
      if ((localObject != null) && (Xm()) && (fGF != i))
      {
        fGF = i;
        Intent localIntent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
        localIntent.putExtra("badge_count", i);
        localIntent.putExtra("badge_count_package_name", aj.getPackageName());
        localIntent.putExtra("badge_count_class_name", LauncherUI.class.getName());
        ad.i("MicroMsg.BusinessNotification", "samsungNotification: %d, %s", new Object[] { Integer.valueOf(i), Build.BRAND });
        ((Context)localObject).sendBroadcast(localIntent);
      }
      if (fGB)
      {
        if (Build.VERSION.SDK_INT < 11) {
          fGB = false;
        }
      }
      else
      {
        label152:
        if (!fGy) {
          break label285;
        }
        bool = fGx;
        label162:
        if ((!bool) || (fGz == paramInt)) {}
      }
      try
      {
        localObject = new Intent("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
        ((Intent)localObject).putExtra("packageName", aj.getPackageName());
        ((Intent)localObject).putExtra("className", LauncherUI.class.getName());
        ((Intent)localObject).putExtra("notificationNum", paramInt);
        aj.getContext().sendBroadcast((Intent)localObject);
        ad.i("MicroMsg.BusinessNotification", "vivo badge: %d", new Object[] { Integer.valueOf(paramInt) });
        C(null, paramInt);
        AppMethodBeat.o(19974);
        return;
        label256:
        i = paramInt;
        continue;
        if (fGA == paramInt) {
          break label152;
        }
        com.tencent.mm.sdk.g.b.c(new e.1(paramInt), "huaweiNotification");
        break label152;
        label285:
        fGy = true;
        if (!Build.BRAND.equals("vivo"))
        {
          fGx = false;
          bool = false;
          break label162;
        }
        fGx = true;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          fGx = false;
          ad.printErrStackTrace("MicroMsg.BusinessNotification", localException, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.notification.e
 * JD-Core Version:    0.7.0.1
 */