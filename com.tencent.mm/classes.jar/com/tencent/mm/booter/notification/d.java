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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.LauncherUI;
import java.lang.reflect.Field;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d
{
  private static boolean foo;
  private static boolean fop;
  private static boolean foq;
  private static int jdField_for;
  private static int fos;
  private static boolean fot;
  private static String fou;
  public static boolean fov;
  public static boolean fow;
  private static int fox;
  private static boolean foy;
  private static Uri foz;
  
  static
  {
    AppMethodBeat.i(19982);
    foo = true;
    fop = true;
    foq = false;
    jdField_for = -1;
    fos = -1;
    fot = true;
    fou = "samsung";
    fov = true;
    fow = false;
    fox = -1;
    foy = true;
    foz = Uri.parse("content://com.android.badge/badge");
    AppMethodBeat.o(19982);
  }
  
  private static void A(String paramString, int paramInt)
  {
    AppMethodBeat.i(19979);
    if (ai.getContext() == null)
    {
      ac.printErrStackTrace("MicroMsg.BusinessNotification", null, "normal badge context is null", new Object[0]);
      AppMethodBeat.o(19979);
      return;
    }
    Context localContext = ai.getContext();
    int i = paramInt;
    if (paramInt < 0) {
      i = f.ZV();
    }
    c(localContext, paramString, i);
    AppMethodBeat.o(19979);
  }
  
  private static boolean UV()
  {
    AppMethodBeat.i(19978);
    if (fow)
    {
      boolean bool = fov;
      AppMethodBeat.o(19978);
      return bool;
    }
    fow = true;
    if (!Build.BRAND.equals(fou))
    {
      fov = false;
      AppMethodBeat.o(19978);
      return false;
    }
    fov = true;
    AppMethodBeat.o(19978);
    return true;
  }
  
  public static int a(Notification paramNotification, g paramg)
  {
    AppMethodBeat.i(19977);
    if ((paramNotification == null) || (!foo))
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
        ac.i("MicroMsg.BusinessNotification", "miuiNotification: %d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(19977);
        return i;
        int j = paramg.fpp;
        paramg = com.tencent.mm.booter.notification.queue.b.UX().foP;
        if (paramg.foO == null) {
          paramg.restore();
        }
        paramg = paramg.foO.iterator();
        for (i = 0; paramg.hasNext(); i = ((NotificationItem)paramg.next()).foJ + i) {}
        i = j - i;
      }
    }
    catch (NoSuchFieldException paramNotification)
    {
      for (;;)
      {
        foo = false;
      }
    }
    catch (IllegalArgumentException paramNotification)
    {
      for (;;)
      {
        foo = false;
      }
    }
    catch (IllegalAccessException paramNotification)
    {
      for (;;)
      {
        foo = false;
      }
    }
    catch (ClassNotFoundException paramNotification)
    {
      for (;;)
      {
        foo = false;
      }
    }
    catch (InstantiationException paramNotification)
    {
      for (;;)
      {
        foo = false;
      }
    }
    catch (Exception paramNotification)
    {
      for (;;)
      {
        foo = false;
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
  
  public static void cz(boolean paramBoolean)
  {
    AppMethodBeat.i(19976);
    if (!foy)
    {
      AppMethodBeat.o(19976);
      return;
    }
    Object localObject = ai.getContext();
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
        ac.i("MicroMsg.BusinessNotification", "sync all user badge");
        localObject = ((ContentResolver)localObject).call(foz, "getShortcutList", null, null);
        if (localObject == null)
        {
          ac.i("MicroMsg.BusinessNotification", "getShortcutList return null");
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
            str = com.tencent.mm.plugin.base.model.b.SV(str);
            if (paramBoolean)
            {
              j = 0;
              z(str, j);
              break label208;
            }
            int j = f.sO(str);
            continue;
          }
        }
        AppMethodBeat.o(19976);
        return;
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.BusinessNotification", localException, "sync all user badge: no support getShortcutList", new Object[0]);
        AppMethodBeat.o(19976);
        return;
      }
      label208:
      i += 1;
    }
  }
  
  public static void kt(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(19974);
    Object localObject;
    int i;
    if ((ai.getContext() != null) && (UV()))
    {
      localObject = ai.getContext();
      if (paramInt != -1) {
        break label256;
      }
      i = f.ZV();
    }
    for (;;)
    {
      if ((localObject != null) && (UV()) && (fox != i))
      {
        fox = i;
        Intent localIntent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
        localIntent.putExtra("badge_count", i);
        localIntent.putExtra("badge_count_package_name", ai.getPackageName());
        localIntent.putExtra("badge_count_class_name", LauncherUI.class.getName());
        ac.i("MicroMsg.BusinessNotification", "samsungNotification: %d, %s", new Object[] { Integer.valueOf(i), Build.BRAND });
        ((Context)localObject).sendBroadcast(localIntent);
      }
      if (fot)
      {
        if (Build.VERSION.SDK_INT < 11) {
          fot = false;
        }
      }
      else
      {
        label152:
        if (!foq) {
          break label285;
        }
        bool = fop;
        label162:
        if ((!bool) || (jdField_for == paramInt)) {}
      }
      try
      {
        localObject = new Intent("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
        ((Intent)localObject).putExtra("packageName", ai.getPackageName());
        ((Intent)localObject).putExtra("className", LauncherUI.class.getName());
        ((Intent)localObject).putExtra("notificationNum", paramInt);
        ai.getContext().sendBroadcast((Intent)localObject);
        ac.i("MicroMsg.BusinessNotification", "vivo badge: %d", new Object[] { Integer.valueOf(paramInt) });
        A(null, paramInt);
        AppMethodBeat.o(19974);
        return;
        label256:
        i = paramInt;
        continue;
        if (fos == paramInt) {
          break label152;
        }
        com.tencent.mm.sdk.g.b.c(new d.1(paramInt), "huaweiNotification");
        break label152;
        label285:
        foq = true;
        if (!Build.BRAND.equals("vivo"))
        {
          fop = false;
          bool = false;
          break label162;
        }
        fop = true;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          fop = false;
          ac.printErrStackTrace("MicroMsg.BusinessNotification", localException, "", new Object[0]);
        }
      }
    }
  }
  
  public static void z(String paramString, int paramInt)
  {
    AppMethodBeat.i(19975);
    if (bs.isNullOrNil(paramString))
    {
      ac.printErrStackTrace("MicroMsg.BusinessNotification", null, "syncUserBadge username is null", new Object[0]);
      AppMethodBeat.o(19975);
      return;
    }
    paramString = com.tencent.mm.plugin.base.model.b.SW(paramString);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(19975);
      return;
    }
    A(paramString, paramInt);
    AppMethodBeat.o(19975);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.notification.d
 * JD-Core Version:    0.7.0.1
 */