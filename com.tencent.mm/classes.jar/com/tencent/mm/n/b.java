package com.tencent.mm.n;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.a;
import com.tencent.mm.network.af;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.vendor.MIUI;

public class b
{
  private static int gLW = -1;
  public static final String gLX = null;
  private static String gLY = "";
  private static SharedPreferences gLZ = null;
  private static NotificationChannel gMa;
  private static String gMb = gLX;
  private static boolean gMc = false;
  private static boolean gMd = false;
  
  static void Ej(String paramString)
  {
    AppMethodBeat.i(149979);
    apK().edit().putString("settings.ringtone", paramString).commit();
    AppMethodBeat.o(149979);
  }
  
  public static String apJ()
  {
    AppMethodBeat.i(149964);
    if (Util.isNullOrNil(gLY)) {
      gLY = a.apK().getString("message_channel_id", "message_channel_new_id");
    }
    String str = gLY;
    AppMethodBeat.o(149964);
    return str;
  }
  
  protected static SharedPreferences apK()
  {
    AppMethodBeat.i(149965);
    if (gLZ != null)
    {
      localSharedPreferences = gLZ;
      AppMethodBeat.o(149965);
      return localSharedPreferences;
    }
    SharedPreferences localSharedPreferences = a.apK();
    gLZ = localSharedPreferences;
    AppMethodBeat.o(149965);
    return localSharedPreferences;
  }
  
  public static SharedPreferences apL()
  {
    AppMethodBeat.i(149966);
    SharedPreferences localSharedPreferences = af.bke();
    AppMethodBeat.o(149966);
    return localSharedPreferences;
  }
  
  public static boolean apM()
  {
    AppMethodBeat.i(149967);
    if (d.oD(26))
    {
      AppMethodBeat.o(149967);
      return true;
    }
    AppMethodBeat.o(149967);
    return false;
  }
  
  public static boolean apN()
  {
    AppMethodBeat.i(149968);
    boolean bool = apK().getBoolean("settings_new_msg_notification", true);
    AppMethodBeat.o(149968);
    return bool;
  }
  
  public static boolean apO()
  {
    AppMethodBeat.i(149969);
    if (!v.P(MMApplicationContext.getContext()).areNotificationsEnabled())
    {
      AppMethodBeat.o(149969);
      return false;
    }
    if (d.oD(26))
    {
      if (gMa == null) {
        gMa = ((NotificationManager)MMApplicationContext.getContext().getSystemService(NotificationManager.class)).getNotificationChannel(apJ());
      }
      if ((gMa != null) && (gMa.getImportance() <= 0))
      {
        AppMethodBeat.o(149969);
        return false;
      }
    }
    AppMethodBeat.o(149969);
    return true;
  }
  
  public static boolean apP()
  {
    AppMethodBeat.i(149970);
    boolean bool = apK().getBoolean("settings_new_voip_msg_notification", true);
    AppMethodBeat.o(149970);
    return bool;
  }
  
  public static boolean apQ()
  {
    AppMethodBeat.i(149971);
    boolean bool = apK().getBoolean("settings_show_detail", true);
    AppMethodBeat.o(149971);
    return bool;
  }
  
  public static boolean apR()
  {
    AppMethodBeat.i(149972);
    boolean bool2 = apK().getBoolean("settings_sound", true);
    boolean bool1;
    if (d.oD(26)) {
      if (gLW == 0)
      {
        boolean bool3 = apS();
        bool1 = bool3;
        if (bool2 != bool3)
        {
          g.dD(bool3);
          bool1 = bool3;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(149972);
      return bool1;
      bool1 = apY();
      continue;
      bool1 = bool2;
    }
  }
  
  public static boolean apS()
  {
    AppMethodBeat.i(149973);
    if (d.oD(26))
    {
      NotificationChannel localNotificationChannel = ((NotificationManager)MMApplicationContext.getContext().getSystemService(NotificationManager.class)).getNotificationChannel(apJ());
      if ((localNotificationChannel != null) && (localNotificationChannel.getImportance() < 3))
      {
        AppMethodBeat.o(149973);
        return false;
      }
      if ((localNotificationChannel != null) && (localNotificationChannel.getSound() == null))
      {
        AppMethodBeat.o(149973);
        return false;
      }
    }
    else
    {
      int i = v.P(MMApplicationContext.getContext()).getImportance();
      if ((i < 3) && (i != -1000))
      {
        AppMethodBeat.o(149973);
        return false;
      }
    }
    AppMethodBeat.o(149973);
    return true;
  }
  
  public static boolean apT()
  {
    AppMethodBeat.i(149974);
    if (d.oF(28))
    {
      NotificationChannel localNotificationChannel = ((NotificationManager)MMApplicationContext.getContext().getSystemService(NotificationManager.class)).getNotificationChannel("voip_notify_channel_new_id");
      if ((localNotificationChannel != null) && (localNotificationChannel.getImportance() < 3))
      {
        AppMethodBeat.o(149974);
        return false;
      }
      if ((localNotificationChannel == null) || (localNotificationChannel.getSound() != null))
      {
        AppMethodBeat.o(149974);
        return true;
      }
      AppMethodBeat.o(149974);
      return false;
    }
    AppMethodBeat.o(149974);
    return true;
  }
  
  public static boolean apU()
  {
    AppMethodBeat.i(149975);
    if (d.oF(28))
    {
      NotificationChannel localNotificationChannel = ((NotificationManager)MMApplicationContext.getContext().getSystemService(NotificationManager.class)).getNotificationChannel("voip_notify_channel_new_id");
      if ((localNotificationChannel == null) || ((localNotificationChannel.getImportance() >= 3) && (localNotificationChannel.shouldVibrate())))
      {
        AppMethodBeat.o(149975);
        return true;
      }
      AppMethodBeat.o(149975);
      return false;
    }
    AppMethodBeat.o(149975);
    return true;
  }
  
  public static boolean apV()
  {
    AppMethodBeat.i(149976);
    boolean bool2 = apK().getBoolean("settings_shake", true);
    boolean bool1;
    if (d.oD(26)) {
      if (gLW == 0)
      {
        boolean bool3 = apW();
        bool1 = bool3;
        if (bool3 != bool2)
        {
          g.dE(bool3);
          bool1 = bool3;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(149976);
      return bool1;
      bool1 = apZ();
      continue;
      bool1 = bool2;
    }
  }
  
  public static boolean apW()
  {
    AppMethodBeat.i(149977);
    if (d.oD(26))
    {
      NotificationChannel localNotificationChannel = ((NotificationManager)MMApplicationContext.getContext().getSystemService(NotificationManager.class)).getNotificationChannel(apJ());
      if ((localNotificationChannel != null) && ((localNotificationChannel.getImportance() < 3) || (!localNotificationChannel.shouldVibrate())))
      {
        AppMethodBeat.o(149977);
        return false;
      }
    }
    else
    {
      int i = v.P(MMApplicationContext.getContext()).getImportance();
      if ((i < 3) && (i != -1000))
      {
        AppMethodBeat.o(149977);
        return false;
      }
    }
    AppMethodBeat.o(149977);
    return true;
  }
  
  public static String apX()
  {
    AppMethodBeat.i(149978);
    Object localObject1;
    RingtoneManager localRingtoneManager;
    if (!d.oD(26))
    {
      Object localObject4 = apK().getString("settings.ringtone", gLX);
      localObject1 = localObject4;
      Object localObject6;
      if (localObject4 != gLX)
      {
        localObject1 = localObject4;
        if (!((String)localObject4).equals(gMb))
        {
          localRingtoneManager = new RingtoneManager(MMApplicationContext.getContext());
          localRingtoneManager.setType(2);
          localObject6 = localObject4;
          localObject1 = localObject4;
        }
      }
      try
      {
        if (localRingtoneManager.getRingtonePosition(Uri.parse((String)localObject4)) < 0)
        {
          localObject1 = localObject4;
          localObject6 = gLX;
          localObject1 = localObject6;
          Ej((String)localObject6);
          localObject1 = localObject6;
          Log.i("MicroMsg.BaseNotificationConfig", "reset ringTone");
        }
        localObject4 = localObject6;
        if (localRingtoneManager.getCursor() != null)
        {
          localRingtoneManager.getCursor().close();
          localObject4 = localObject6;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.BaseNotificationConfig", localException, "ringTone() Exception:%s", new Object[] { localException.getMessage() });
          Object localObject5 = localObject1;
          if (localRingtoneManager.getCursor() != null)
          {
            localRingtoneManager.getCursor().close();
            localObject5 = localObject1;
          }
        }
      }
      finally
      {
        if (localRingtoneManager.getCursor() == null) {
          break label194;
        }
        localRingtoneManager.getCursor().close();
        AppMethodBeat.o(149978);
      }
      gMb = (String)localObject4;
      localObject1 = localObject4;
      AppMethodBeat.o(149978);
      return localObject1;
    }
    label194:
    Object localObject3 = ((NotificationManager)MMApplicationContext.getContext().getSystemService(NotificationManager.class)).getNotificationChannel(apJ());
    if ((localObject3 != null) && (((NotificationChannel)localObject3).getSound() != null))
    {
      localObject3 = ((NotificationChannel)localObject3).getSound().toString();
      AppMethodBeat.o(149978);
      return localObject3;
    }
    AppMethodBeat.o(149978);
    return "";
  }
  
  public static boolean apY()
  {
    AppMethodBeat.i(149980);
    SharedPreferences localSharedPreferences = apK();
    boolean bool = localSharedPreferences.getBoolean("settings_special_scene_sound", localSharedPreferences.getBoolean("settings_sound", true));
    AppMethodBeat.o(149980);
    return bool;
  }
  
  public static boolean apZ()
  {
    AppMethodBeat.i(149981);
    SharedPreferences localSharedPreferences = apK();
    boolean bool = localSharedPreferences.getBoolean("settings_special_scene_shake", localSharedPreferences.getBoolean("settings_shake", true));
    AppMethodBeat.o(149981);
    return bool;
  }
  
  public static boolean aqa()
  {
    AppMethodBeat.i(149982);
    SharedPreferences localSharedPreferences = apK();
    boolean bool = localSharedPreferences.getBoolean("settings_voip_scene_sound", apR());
    if (!gMc)
    {
      gMc = true;
      localSharedPreferences.edit().putBoolean("settings_voip_scene_sound", bool).commit();
    }
    AppMethodBeat.o(149982);
    return bool;
  }
  
  public static boolean aqb()
  {
    AppMethodBeat.i(149983);
    SharedPreferences localSharedPreferences = apK();
    boolean bool = localSharedPreferences.getBoolean("settings_voip_scene_shake", apV());
    if (!gMd)
    {
      gMd = true;
      localSharedPreferences.edit().putBoolean("settings_voip_scene_shake", bool).commit();
    }
    AppMethodBeat.o(149983);
    return bool;
  }
  
  public static int aqc()
  {
    return gLW;
  }
  
  public static void aqd()
  {
    AppMethodBeat.i(149984);
    if (MIUI.ifMIUI())
    {
      gLW = 1;
      Log.i("MicroMsg.BaseNotificationConfig", "iniSpecialSceneSwitchEnable() mSpecialSceneSwitchEnable:%s", new Object[] { Integer.valueOf(gLW) });
      AppMethodBeat.o(149984);
      return;
    }
    int i = apK().getInt("special_scene_enable", -1);
    if (Util.isEqual(i, -1)) {}
    for (gLW = 0;; gLW = i)
    {
      Log.i("MicroMsg.BaseNotificationConfig", "iniSpecialSceneSwitchEnable() sceneEnable:%s mSpecialSceneSwitchEnable:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(gLW) });
      AppMethodBeat.o(149984);
      return;
    }
  }
  
  public static boolean aqe()
  {
    AppMethodBeat.i(149985);
    boolean bool = apK().getBoolean("settings_active_time_full", true);
    AppMethodBeat.o(149985);
    return bool;
  }
  
  public static int aqf()
  {
    AppMethodBeat.i(149986);
    int i = apK().getInt("settings_active_begin_time_hour", 8);
    AppMethodBeat.o(149986);
    return i;
  }
  
  public static int aqg()
  {
    AppMethodBeat.i(149987);
    int i = apK().getInt("settings_active_end_time_hour", 23);
    AppMethodBeat.o(149987);
    return i;
  }
  
  public static int aqh()
  {
    AppMethodBeat.i(149988);
    int i = apK().getInt("settings_active_begin_time_min", 0);
    AppMethodBeat.o(149988);
    return i;
  }
  
  public static int aqi()
  {
    AppMethodBeat.i(149989);
    int i = apK().getInt("settings_active_end_time_min", 0);
    AppMethodBeat.o(149989);
    return i;
  }
  
  public static boolean ct(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(149990);
    if (aqe())
    {
      AppMethodBeat.o(149990);
      return true;
    }
    int i = aqf();
    int j = aqh();
    int k = aqg();
    int m = aqi();
    if ((i == k) && (j == m))
    {
      AppMethodBeat.o(149990);
      return false;
    }
    if ((i == k) && (j < m))
    {
      if ((paramInt1 == i) && (paramInt2 > j) && (paramInt2 < m))
      {
        AppMethodBeat.o(149990);
        return true;
      }
      AppMethodBeat.o(149990);
      return false;
    }
    if (k > i)
    {
      if (((paramInt1 > i) && (paramInt1 < k)) || ((paramInt1 == i) && (paramInt2 > j)) || ((paramInt1 == k) && (paramInt2 < m)))
      {
        AppMethodBeat.o(149990);
        return true;
      }
      AppMethodBeat.o(149990);
      return false;
    }
    if ((k < i) || ((i == k) && (j > m)))
    {
      if (((paramInt1 > i) && (paramInt1 <= 23)) || ((paramInt1 == i) && (paramInt2 > j)) || ((paramInt1 == k) && (paramInt2 < m)) || ((paramInt1 > 0) && (paramInt1 < k)))
      {
        AppMethodBeat.o(149990);
        return true;
      }
      AppMethodBeat.o(149990);
      return false;
    }
    AppMethodBeat.o(149990);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.n.b
 * JD-Core Version:    0.7.0.1
 */