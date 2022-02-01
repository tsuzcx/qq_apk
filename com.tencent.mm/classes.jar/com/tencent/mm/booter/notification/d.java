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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.LauncherUI;
import java.lang.reflect.Field;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d
{
  private static boolean fkU;
  private static boolean fkV;
  private static boolean fkW;
  private static int fkX;
  private static int fkY;
  private static boolean fkZ;
  private static String fla;
  public static boolean flb;
  public static boolean flc;
  private static int fld;
  private static boolean fle;
  private static Uri flf;
  
  static
  {
    AppMethodBeat.i(19982);
    fkU = true;
    fkV = true;
    fkW = false;
    fkX = -1;
    fkY = -1;
    fkZ = true;
    fla = "samsung";
    flb = true;
    flc = false;
    fld = -1;
    fle = true;
    flf = Uri.parse("content://com.android.badge/badge");
    AppMethodBeat.o(19982);
  }
  
  private static void A(String paramString, int paramInt)
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
      i = f.YZ();
    }
    c(localContext, paramString, i);
    AppMethodBeat.o(19979);
  }
  
  private static boolean Ua()
  {
    AppMethodBeat.i(19978);
    if (flc)
    {
      boolean bool = flb;
      AppMethodBeat.o(19978);
      return bool;
    }
    flc = true;
    if (!Build.BRAND.equals(fla))
    {
      flb = false;
      AppMethodBeat.o(19978);
      return false;
    }
    flb = true;
    AppMethodBeat.o(19978);
    return true;
  }
  
  public static int a(Notification paramNotification, g paramg)
  {
    AppMethodBeat.i(19977);
    if ((paramNotification == null) || (!fkU))
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
        int j = paramg.flV;
        paramg = com.tencent.mm.booter.notification.queue.b.Uc().flv;
        if (paramg.flu == null) {
          paramg.restore();
        }
        paramg = paramg.flu.iterator();
        for (i = 0; paramg.hasNext(); i = ((NotificationItem)paramg.next()).flp + i) {}
        i = j - i;
      }
    }
    catch (NoSuchFieldException paramNotification)
    {
      for (;;)
      {
        fkU = false;
      }
    }
    catch (IllegalArgumentException paramNotification)
    {
      for (;;)
      {
        fkU = false;
      }
    }
    catch (IllegalAccessException paramNotification)
    {
      for (;;)
      {
        fkU = false;
      }
    }
    catch (ClassNotFoundException paramNotification)
    {
      for (;;)
      {
        fkU = false;
      }
    }
    catch (InstantiationException paramNotification)
    {
      for (;;)
      {
        fkU = false;
      }
    }
    catch (Exception paramNotification)
    {
      for (;;)
      {
        fkU = false;
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
        d.d(this.val$context, paramString, paramInt);
        AppMethodBeat.o(184895);
      }
    }, "normalNotification");
    AppMethodBeat.o(19980);
    return true;
  }
  
  public static void cy(boolean paramBoolean)
  {
    AppMethodBeat.i(19976);
    if (!fle)
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
        localObject = ((ContentResolver)localObject).call(flf, "getShortcutList", null, null);
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
              break label208;
            }
            str = com.tencent.mm.plugin.base.model.b.OL(str);
            if (paramBoolean)
            {
              j = 0;
              z(str, j);
              break label208;
            }
            int j = f.pD(str);
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
      label208:
      i += 1;
    }
  }
  
  public static void kw(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(19974);
    Object localObject;
    int i;
    if ((aj.getContext() != null) && (Ua()))
    {
      localObject = aj.getContext();
      if (paramInt != -1) {
        break label256;
      }
      i = f.YZ();
    }
    for (;;)
    {
      if ((localObject != null) && (Ua()) && (fld != i))
      {
        fld = i;
        Intent localIntent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
        localIntent.putExtra("badge_count", i);
        localIntent.putExtra("badge_count_package_name", aj.getPackageName());
        localIntent.putExtra("badge_count_class_name", LauncherUI.class.getName());
        ad.i("MicroMsg.BusinessNotification", "samsungNotification: %d, %s", new Object[] { Integer.valueOf(i), Build.BRAND });
        ((Context)localObject).sendBroadcast(localIntent);
      }
      if (fkZ)
      {
        if (Build.VERSION.SDK_INT < 11) {
          fkZ = false;
        }
      }
      else
      {
        label152:
        if (!fkW) {
          break label285;
        }
        bool = fkV;
        label162:
        if ((!bool) || (fkX == paramInt)) {}
      }
      try
      {
        localObject = new Intent("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
        ((Intent)localObject).putExtra("packageName", aj.getPackageName());
        ((Intent)localObject).putExtra("className", LauncherUI.class.getName());
        ((Intent)localObject).putExtra("notificationNum", paramInt);
        aj.getContext().sendBroadcast((Intent)localObject);
        ad.i("MicroMsg.BusinessNotification", "vivo badge: %d", new Object[] { Integer.valueOf(paramInt) });
        A(null, paramInt);
        AppMethodBeat.o(19974);
        return;
        label256:
        i = paramInt;
        continue;
        if (fkY == paramInt) {
          break label152;
        }
        com.tencent.mm.sdk.g.b.c(new Runnable()
        {
          public final void run()
          {
            boolean bool = true;
            AppMethodBeat.i(19973);
            try
            {
              Bundle localBundle = new Bundle();
              localBundle.putString("package", aj.getPackageName());
              localBundle.putString("class", LauncherUI.class.getName());
              localBundle.putInt("badgenumber", this.flg);
              if (aj.getContext().getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", null, localBundle) != null) {}
              for (;;)
              {
                d.cz(bool);
                ad.i("MicroMsg.BusinessNotification", "huawei badge: %d, %b", new Object[] { Integer.valueOf(this.flg), Boolean.valueOf(d.fkZ) });
                AppMethodBeat.o(19973);
                return;
                bool = false;
              }
              return;
            }
            catch (Exception localException)
            {
              ad.i("MicroMsg.BusinessNotification", "no huawei badge");
              ad.e("MicroMsg.BusinessNotification", "alvin: no badge" + localException.toString());
              d.cz(false);
              AppMethodBeat.o(19973);
            }
          }
        }, "huaweiNotification");
        break label152;
        label285:
        fkW = true;
        if (!Build.BRAND.equals("vivo"))
        {
          fkV = false;
          bool = false;
          break label162;
        }
        fkV = true;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          fkV = false;
          ad.printErrStackTrace("MicroMsg.BusinessNotification", localException, "", new Object[0]);
        }
      }
    }
  }
  
  public static void z(String paramString, int paramInt)
  {
    AppMethodBeat.i(19975);
    if (bt.isNullOrNil(paramString))
    {
      ad.printErrStackTrace("MicroMsg.BusinessNotification", null, "syncUserBadge username is null", new Object[0]);
      AppMethodBeat.o(19975);
      return;
    }
    paramString = com.tencent.mm.plugin.base.model.b.OM(paramString);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(19975);
      return;
    }
    A(paramString, paramInt);
    AppMethodBeat.o(19975);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.booter.notification.d
 * JD-Core Version:    0.7.0.1
 */