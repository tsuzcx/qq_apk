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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.LauncherUI;
import java.lang.reflect.Field;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e
{
  private static boolean fIA;
  private static boolean fIB;
  private static boolean fIC;
  private static int fID;
  private static int fIE;
  private static boolean fIF;
  private static String fIG;
  public static boolean fIH;
  public static boolean fII;
  private static int fIJ;
  private static boolean fIK;
  private static Uri fIL;
  
  static
  {
    AppMethodBeat.i(19982);
    fIA = true;
    fIB = true;
    fIC = false;
    fID = -1;
    fIE = -1;
    fIF = true;
    fIG = "samsung";
    fIH = true;
    fII = false;
    fIJ = -1;
    fIK = true;
    fIL = Uri.parse("content://com.android.badge/badge");
    AppMethodBeat.o(19982);
  }
  
  public static void C(String paramString, int paramInt)
  {
    AppMethodBeat.i(19975);
    if (bu.isNullOrNil(paramString))
    {
      ae.printErrStackTrace("MicroMsg.BusinessNotification", null, "syncUserBadge username is null", new Object[0]);
      AppMethodBeat.o(19975);
      return;
    }
    paramString = com.tencent.mm.plugin.base.model.b.Xf(paramString);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(19975);
      return;
    }
    D(paramString, paramInt);
    AppMethodBeat.o(19975);
  }
  
  private static void D(String paramString, int paramInt)
  {
    AppMethodBeat.i(19979);
    if (ak.getContext() == null)
    {
      ae.printErrStackTrace("MicroMsg.BusinessNotification", null, "normal badge context is null", new Object[0]);
      AppMethodBeat.o(19979);
      return;
    }
    Context localContext = ak.getContext();
    int i = paramInt;
    if (paramInt < 0) {
      i = f.acI();
    }
    c(localContext, paramString, i);
    AppMethodBeat.o(19979);
  }
  
  private static boolean Xu()
  {
    AppMethodBeat.i(19978);
    if (fII)
    {
      boolean bool = fIH;
      AppMethodBeat.o(19978);
      return bool;
    }
    fII = true;
    if (!Build.BRAND.equals(fIG))
    {
      fIH = false;
      AppMethodBeat.o(19978);
      return false;
    }
    fIH = true;
    AppMethodBeat.o(19978);
    return true;
  }
  
  public static int a(Notification paramNotification, g paramg)
  {
    AppMethodBeat.i(19977);
    if ((paramNotification == null) || (!fIA))
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
        ae.i("MicroMsg.BusinessNotification", "miuiNotification: %d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(19977);
        return i;
        int j = paramg.XJ();
        paramg = com.tencent.mm.booter.notification.queue.b.Xw().fJb;
        if (paramg.fJa == null) {
          paramg.restore();
        }
        paramg = paramg.fJa.iterator();
        for (i = 0; paramg.hasNext(); i = ((NotificationItem)paramg.next()).fIV + i) {}
        i = j - i;
      }
    }
    catch (NoSuchFieldException paramNotification)
    {
      for (;;)
      {
        fIA = false;
      }
    }
    catch (IllegalArgumentException paramNotification)
    {
      for (;;)
      {
        fIA = false;
      }
    }
    catch (IllegalAccessException paramNotification)
    {
      for (;;)
      {
        fIA = false;
      }
    }
    catch (ClassNotFoundException paramNotification)
    {
      for (;;)
      {
        fIA = false;
      }
    }
    catch (InstantiationException paramNotification)
    {
      for (;;)
      {
        fIA = false;
      }
    }
    catch (Exception paramNotification)
    {
      for (;;)
      {
        fIA = false;
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
    if (!fIK)
    {
      AppMethodBeat.o(19976);
      return;
    }
    Object localObject = ak.getContext();
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
        ae.i("MicroMsg.BusinessNotification", "sync all user badge");
        localObject = ((ContentResolver)localObject).call(fIL, "getShortcutList", null, null);
        if (localObject == null)
        {
          ae.i("MicroMsg.BusinessNotification", "getShortcutList return null");
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
            str = com.tencent.mm.plugin.base.model.b.Xe(str);
            if (paramBoolean)
            {
              j = 0;
              C(str, j);
              break label212;
            }
            int j = f.vZ(str);
            continue;
          }
        }
        AppMethodBeat.o(19976);
        return;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.BusinessNotification", localException, "sync all user badge: no support getShortcutList", new Object[0]);
        AppMethodBeat.o(19976);
        return;
      }
      label212:
      i += 1;
    }
  }
  
  public static void kS(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(19974);
    Object localObject;
    int i;
    if ((ak.getContext() != null) && (Xu()))
    {
      localObject = ak.getContext();
      if (paramInt != -1) {
        break label256;
      }
      i = f.acI();
    }
    for (;;)
    {
      if ((localObject != null) && (Xu()) && (fIJ != i))
      {
        fIJ = i;
        Intent localIntent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
        localIntent.putExtra("badge_count", i);
        localIntent.putExtra("badge_count_package_name", ak.getPackageName());
        localIntent.putExtra("badge_count_class_name", LauncherUI.class.getName());
        ae.i("MicroMsg.BusinessNotification", "samsungNotification: %d, %s", new Object[] { Integer.valueOf(i), Build.BRAND });
        ((Context)localObject).sendBroadcast(localIntent);
      }
      if (fIF)
      {
        if (Build.VERSION.SDK_INT < 11) {
          fIF = false;
        }
      }
      else
      {
        label152:
        if (!fIC) {
          break label285;
        }
        bool = fIB;
        label162:
        if ((!bool) || (fID == paramInt)) {}
      }
      try
      {
        localObject = new Intent("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
        ((Intent)localObject).putExtra("packageName", ak.getPackageName());
        ((Intent)localObject).putExtra("className", LauncherUI.class.getName());
        ((Intent)localObject).putExtra("notificationNum", paramInt);
        ak.getContext().sendBroadcast((Intent)localObject);
        ae.i("MicroMsg.BusinessNotification", "vivo badge: %d", new Object[] { Integer.valueOf(paramInt) });
        D(null, paramInt);
        AppMethodBeat.o(19974);
        return;
        label256:
        i = paramInt;
        continue;
        if (fIE == paramInt) {
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
              localBundle.putString("package", ak.getPackageName());
              localBundle.putString("class", LauncherUI.class.getName());
              localBundle.putInt("badgenumber", this.fIM);
              if (ak.getContext().getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", null, localBundle) != null) {}
              for (;;)
              {
                e.access$002(bool);
                ae.i("MicroMsg.BusinessNotification", "huawei badge: %d, %b", new Object[] { Integer.valueOf(this.fIM), Boolean.valueOf(e.fIF) });
                AppMethodBeat.o(19973);
                return;
                bool = false;
              }
              return;
            }
            catch (Exception localException)
            {
              ae.i("MicroMsg.BusinessNotification", "no huawei badge");
              ae.e("MicroMsg.BusinessNotification", "alvin: no badge" + localException.toString());
              e.access$002(false);
              AppMethodBeat.o(19973);
            }
          }
        }, "huaweiNotification");
        break label152;
        label285:
        fIC = true;
        if (!Build.BRAND.equals("vivo"))
        {
          fIB = false;
          bool = false;
          break label162;
        }
        fIB = true;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          fIB = false;
          ae.printErrStackTrace("MicroMsg.BusinessNotification", localException, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.notification.e
 * JD-Core Version:    0.7.0.1
 */