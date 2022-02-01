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
import com.tencent.mm.sdk.h.b;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public class a
{
  private static int gej = -1;
  public static final String gek = null;
  private static String gel = "";
  private static SharedPreferences gem = null;
  private static NotificationChannel gen;
  private static String geo = gek;
  private static boolean gep = false;
  private static boolean geq = false;
  
  public static String abB()
  {
    AppMethodBeat.i(149964);
    if (bt.isNullOrNil(gel)) {
      gel = com.tencent.mm.kernel.a.abC().getString("message_channel_id", "message_channel_new_id");
    }
    String str = gel;
    AppMethodBeat.o(149964);
    return str;
  }
  
  protected static SharedPreferences abC()
  {
    AppMethodBeat.i(149965);
    if (gem != null)
    {
      localSharedPreferences = gem;
      AppMethodBeat.o(149965);
      return localSharedPreferences;
    }
    SharedPreferences localSharedPreferences = com.tencent.mm.kernel.a.abC();
    gem = localSharedPreferences;
    AppMethodBeat.o(149965);
    return localSharedPreferences;
  }
  
  public static SharedPreferences abD()
  {
    AppMethodBeat.i(149966);
    SharedPreferences localSharedPreferences = com.tencent.mm.network.ad.aPf();
    AppMethodBeat.o(149966);
    return localSharedPreferences;
  }
  
  public static boolean abE()
  {
    AppMethodBeat.i(149967);
    if (d.ly(26))
    {
      AppMethodBeat.o(149967);
      return true;
    }
    AppMethodBeat.o(149967);
    return false;
  }
  
  public static boolean abF()
  {
    AppMethodBeat.i(149968);
    boolean bool = abC().getBoolean("settings_new_msg_notification", true);
    AppMethodBeat.o(149968);
    return bool;
  }
  
  public static boolean abG()
  {
    AppMethodBeat.i(149969);
    if (!v.N(aj.getContext()).areNotificationsEnabled())
    {
      AppMethodBeat.o(149969);
      return false;
    }
    if (d.ly(26))
    {
      if (gen == null) {
        gen = ((NotificationManager)aj.getContext().getSystemService(NotificationManager.class)).getNotificationChannel(abB());
      }
      if ((gen != null) && (gen.getImportance() <= 0))
      {
        AppMethodBeat.o(149969);
        return false;
      }
    }
    AppMethodBeat.o(149969);
    return true;
  }
  
  public static boolean abH()
  {
    AppMethodBeat.i(149970);
    boolean bool = abC().getBoolean("settings_new_voip_msg_notification", true);
    AppMethodBeat.o(149970);
    return bool;
  }
  
  public static boolean abI()
  {
    AppMethodBeat.i(149971);
    boolean bool = abC().getBoolean("settings_show_detail", true);
    AppMethodBeat.o(149971);
    return bool;
  }
  
  public static boolean abJ()
  {
    AppMethodBeat.i(149972);
    boolean bool2 = abC().getBoolean("settings_sound", true);
    boolean bool1;
    if (d.ly(26)) {
      if (gej == 0)
      {
        boolean bool3 = abK();
        bool1 = bool3;
        if (bool2 != bool3)
        {
          f.cT(bool3);
          bool1 = bool3;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(149972);
      return bool1;
      bool1 = abQ();
      continue;
      bool1 = bool2;
    }
  }
  
  public static boolean abK()
  {
    AppMethodBeat.i(149973);
    if (d.ly(26))
    {
      NotificationChannel localNotificationChannel = ((NotificationManager)aj.getContext().getSystemService(NotificationManager.class)).getNotificationChannel(abB());
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
      int i = v.N(aj.getContext()).getImportance();
      if ((i < 3) && (i != -1000))
      {
        AppMethodBeat.o(149973);
        return false;
      }
    }
    AppMethodBeat.o(149973);
    return true;
  }
  
  public static boolean abL()
  {
    AppMethodBeat.i(149974);
    if (d.lA(28))
    {
      NotificationChannel localNotificationChannel = ((NotificationManager)aj.getContext().getSystemService(NotificationManager.class)).getNotificationChannel("voip_notify_channel_new_id");
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
  
  public static boolean abM()
  {
    AppMethodBeat.i(149975);
    if (d.lA(28))
    {
      NotificationChannel localNotificationChannel = ((NotificationManager)aj.getContext().getSystemService(NotificationManager.class)).getNotificationChannel("voip_notify_channel_new_id");
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
  
  public static boolean abN()
  {
    AppMethodBeat.i(149976);
    boolean bool2 = abC().getBoolean("settings_shake", true);
    boolean bool1;
    if (d.ly(26)) {
      if (gej == 0)
      {
        boolean bool3 = abO();
        bool1 = bool3;
        if (bool3 != bool2)
        {
          f.cU(bool3);
          bool1 = bool3;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(149976);
      return bool1;
      bool1 = abR();
      continue;
      bool1 = bool2;
    }
  }
  
  public static boolean abO()
  {
    AppMethodBeat.i(149977);
    if (d.ly(26))
    {
      NotificationChannel localNotificationChannel = ((NotificationManager)aj.getContext().getSystemService(NotificationManager.class)).getNotificationChannel(abB());
      if ((localNotificationChannel != null) && ((localNotificationChannel.getImportance() < 3) || (!localNotificationChannel.shouldVibrate())))
      {
        AppMethodBeat.o(149977);
        return false;
      }
    }
    else
    {
      int i = v.N(aj.getContext()).getImportance();
      if ((i < 3) && (i != -1000))
      {
        AppMethodBeat.o(149977);
        return false;
      }
    }
    AppMethodBeat.o(149977);
    return true;
  }
  
  public static String abP()
  {
    AppMethodBeat.i(149978);
    Object localObject1;
    RingtoneManager localRingtoneManager;
    if (!d.ly(26))
    {
      Object localObject4 = abC().getString("settings.ringtone", gek);
      localObject1 = localObject4;
      Object localObject6;
      if (localObject4 != gek)
      {
        localObject1 = localObject4;
        if (!((String)localObject4).equals(geo))
        {
          localRingtoneManager = new RingtoneManager(aj.getContext());
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
          localObject6 = gek;
          localObject1 = localObject6;
          vy((String)localObject6);
          localObject1 = localObject6;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BaseNotificationConfig", "reset ringTone");
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
          com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.BaseNotificationConfig", localException, "ringTone() Exception:%s", new Object[] { localException.getMessage() });
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
          break label193;
        }
        localRingtoneManager.getCursor().close();
        AppMethodBeat.o(149978);
      }
      geo = (String)localObject4;
      localObject1 = localObject4;
      AppMethodBeat.o(149978);
      return localObject1;
    }
    label193:
    Object localObject3 = ((NotificationManager)aj.getContext().getSystemService(NotificationManager.class)).getNotificationChannel(abB());
    if ((localObject3 != null) && (((NotificationChannel)localObject3).getSound() != null))
    {
      localObject3 = ((NotificationChannel)localObject3).getSound().toString();
      AppMethodBeat.o(149978);
      return localObject3;
    }
    AppMethodBeat.o(149978);
    return "";
  }
  
  public static boolean abQ()
  {
    AppMethodBeat.i(149980);
    SharedPreferences localSharedPreferences = abC();
    boolean bool = localSharedPreferences.getBoolean("settings_special_scene_sound", localSharedPreferences.getBoolean("settings_sound", true));
    AppMethodBeat.o(149980);
    return bool;
  }
  
  public static boolean abR()
  {
    AppMethodBeat.i(149981);
    SharedPreferences localSharedPreferences = abC();
    boolean bool = localSharedPreferences.getBoolean("settings_special_scene_shake", localSharedPreferences.getBoolean("settings_shake", true));
    AppMethodBeat.o(149981);
    return bool;
  }
  
  public static boolean abS()
  {
    AppMethodBeat.i(149982);
    SharedPreferences localSharedPreferences = abC();
    boolean bool = localSharedPreferences.getBoolean("settings_voip_scene_sound", abJ());
    if (!gep)
    {
      gep = true;
      localSharedPreferences.edit().putBoolean("settings_voip_scene_sound", bool).commit();
    }
    AppMethodBeat.o(149982);
    return bool;
  }
  
  public static boolean abT()
  {
    AppMethodBeat.i(149983);
    SharedPreferences localSharedPreferences = abC();
    boolean bool = localSharedPreferences.getBoolean("settings_voip_scene_shake", abN());
    if (!geq)
    {
      geq = true;
      localSharedPreferences.edit().putBoolean("settings_voip_scene_shake", bool).commit();
    }
    AppMethodBeat.o(149983);
    return bool;
  }
  
  public static int abU()
  {
    return gej;
  }
  
  public static void abV()
  {
    AppMethodBeat.i(149984);
    if (b.fmu())
    {
      gej = 1;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BaseNotificationConfig", "iniSpecialSceneSwitchEnable() mSpecialSceneSwitchEnable:%s", new Object[] { Integer.valueOf(gej) });
      AppMethodBeat.o(149984);
      return;
    }
    int i = abC().getInt("special_scene_enable", -1);
    if (bt.jx(i, -1)) {}
    for (gej = 0;; gej = i)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BaseNotificationConfig", "iniSpecialSceneSwitchEnable() sceneEnable:%s mSpecialSceneSwitchEnable:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(gej) });
      AppMethodBeat.o(149984);
      return;
    }
  }
  
  public static boolean abW()
  {
    AppMethodBeat.i(149985);
    boolean bool = abC().getBoolean("settings_active_time_full", true);
    AppMethodBeat.o(149985);
    return bool;
  }
  
  public static int abX()
  {
    AppMethodBeat.i(149986);
    int i = abC().getInt("settings_active_begin_time_hour", 8);
    AppMethodBeat.o(149986);
    return i;
  }
  
  public static int abY()
  {
    AppMethodBeat.i(149987);
    int i = abC().getInt("settings_active_end_time_hour", 23);
    AppMethodBeat.o(149987);
    return i;
  }
  
  public static int abZ()
  {
    AppMethodBeat.i(149988);
    int i = abC().getInt("settings_active_begin_time_min", 0);
    AppMethodBeat.o(149988);
    return i;
  }
  
  public static int aca()
  {
    AppMethodBeat.i(149989);
    int i = abC().getInt("settings_active_end_time_min", 0);
    AppMethodBeat.o(149989);
    return i;
  }
  
  public static boolean cr(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(149990);
    if (abW())
    {
      AppMethodBeat.o(149990);
      return true;
    }
    int i = abX();
    int j = abZ();
    int k = abY();
    int m = aca();
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
  
  static void vy(String paramString)
  {
    AppMethodBeat.i(149979);
    abC().edit().putString("settings.ringtone", paramString).commit();
    AppMethodBeat.o(149979);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.n.a
 * JD-Core Version:    0.7.0.1
 */