package com.tencent.mm.m;

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
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public class a
{
  private static int etC = -1;
  public static final String etD = null;
  private static String etE = "";
  private static SharedPreferences etF = null;
  private static NotificationChannel etG;
  private static String etH = etD;
  private static boolean etI = false;
  private static boolean etJ = false;
  
  public static boolean MA()
  {
    AppMethodBeat.i(77637);
    boolean bool = Mu().getBoolean("settings_show_detail", true);
    AppMethodBeat.o(77637);
    return bool;
  }
  
  public static boolean MB()
  {
    AppMethodBeat.i(77638);
    boolean bool2 = Mu().getBoolean("settings_sound", true);
    boolean bool1;
    if (d.fv(26)) {
      if (etC == 0)
      {
        boolean bool3 = MC();
        bool1 = bool3;
        if (bool2 != bool3)
        {
          f.bW(bool3);
          bool1 = bool3;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(77638);
      return bool1;
      bool1 = MG();
      continue;
      bool1 = bool2;
    }
  }
  
  public static boolean MC()
  {
    AppMethodBeat.i(77639);
    if (d.fv(26))
    {
      NotificationChannel localNotificationChannel = ((NotificationManager)ah.getContext().getSystemService(NotificationManager.class)).getNotificationChannel(Mt());
      if ((localNotificationChannel != null) && (localNotificationChannel.getImportance() < 3))
      {
        AppMethodBeat.o(77639);
        return false;
      }
      if ((localNotificationChannel != null) && (localNotificationChannel.getSound() == null))
      {
        AppMethodBeat.o(77639);
        return false;
      }
    }
    else
    {
      int i = v.K(ah.getContext()).getImportance();
      if ((i < 3) && (i != -1000))
      {
        AppMethodBeat.o(77639);
        return false;
      }
    }
    AppMethodBeat.o(77639);
    return true;
  }
  
  public static boolean MD()
  {
    AppMethodBeat.i(77640);
    boolean bool2 = Mu().getBoolean("settings_shake", true);
    boolean bool1;
    if (d.fv(26)) {
      if (etC == 0)
      {
        boolean bool3 = ME();
        bool1 = bool3;
        if (bool3 != bool2)
        {
          f.bX(bool3);
          bool1 = bool3;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(77640);
      return bool1;
      bool1 = MH();
      continue;
      bool1 = bool2;
    }
  }
  
  public static boolean ME()
  {
    AppMethodBeat.i(77641);
    if (d.fv(26))
    {
      NotificationChannel localNotificationChannel = ((NotificationManager)ah.getContext().getSystemService(NotificationManager.class)).getNotificationChannel(Mt());
      if ((localNotificationChannel != null) && ((localNotificationChannel.getImportance() < 3) || (!localNotificationChannel.shouldVibrate())))
      {
        AppMethodBeat.o(77641);
        return false;
      }
    }
    else
    {
      int i = v.K(ah.getContext()).getImportance();
      if ((i < 3) && (i != -1000))
      {
        AppMethodBeat.o(77641);
        return false;
      }
    }
    AppMethodBeat.o(77641);
    return true;
  }
  
  public static String MF()
  {
    AppMethodBeat.i(77642);
    Object localObject1;
    RingtoneManager localRingtoneManager;
    if (!d.fv(26))
    {
      Object localObject4 = Mu().getString("settings.ringtone", etD);
      localObject1 = localObject4;
      Object localObject6;
      if (localObject4 != etD)
      {
        localObject1 = localObject4;
        if (!((String)localObject4).equals(etH))
        {
          localRingtoneManager = new RingtoneManager(ah.getContext());
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
          localObject6 = etD;
          localObject1 = localObject6;
          lt((String)localObject6);
          localObject1 = localObject6;
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.BaseNotificationConfig", "reset ringTone");
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
          com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.BaseNotificationConfig", localException, "ringTone() Exception:%s", new Object[] { localException.getMessage() });
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
        AppMethodBeat.o(77642);
      }
      etH = (String)localObject4;
      localObject1 = localObject4;
      AppMethodBeat.o(77642);
      return localObject1;
    }
    label193:
    Object localObject3 = ((NotificationManager)ah.getContext().getSystemService(NotificationManager.class)).getNotificationChannel(Mt());
    if ((localObject3 != null) && (((NotificationChannel)localObject3).getSound() != null))
    {
      localObject3 = ((NotificationChannel)localObject3).getSound().toString();
      AppMethodBeat.o(77642);
      return localObject3;
    }
    AppMethodBeat.o(77642);
    return "";
  }
  
  public static boolean MG()
  {
    AppMethodBeat.i(77644);
    SharedPreferences localSharedPreferences = Mu();
    boolean bool = localSharedPreferences.getBoolean("settings_special_scene_sound", localSharedPreferences.getBoolean("settings_sound", true));
    AppMethodBeat.o(77644);
    return bool;
  }
  
  public static boolean MH()
  {
    AppMethodBeat.i(77645);
    SharedPreferences localSharedPreferences = Mu();
    boolean bool = localSharedPreferences.getBoolean("settings_special_scene_shake", localSharedPreferences.getBoolean("settings_shake", true));
    AppMethodBeat.o(77645);
    return bool;
  }
  
  public static boolean MI()
  {
    AppMethodBeat.i(77646);
    SharedPreferences localSharedPreferences = Mu();
    boolean bool = localSharedPreferences.getBoolean("settings_voip_scene_sound", MB());
    if (!etI)
    {
      etI = true;
      localSharedPreferences.edit().putBoolean("settings_voip_scene_sound", bool).commit();
    }
    AppMethodBeat.o(77646);
    return bool;
  }
  
  public static boolean MJ()
  {
    AppMethodBeat.i(77647);
    SharedPreferences localSharedPreferences = Mu();
    boolean bool = localSharedPreferences.getBoolean("settings_voip_scene_shake", MD());
    if (!etJ)
    {
      etJ = true;
      localSharedPreferences.edit().putBoolean("settings_voip_scene_shake", bool).commit();
    }
    AppMethodBeat.o(77647);
    return bool;
  }
  
  public static int MK()
  {
    return etC;
  }
  
  public static void ML()
  {
    AppMethodBeat.i(77648);
    if (b.duO())
    {
      etC = 1;
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.BaseNotificationConfig", "iniSpecialSceneSwitchEnable() mSpecialSceneSwitchEnable:%s", new Object[] { Integer.valueOf(etC) });
      AppMethodBeat.o(77648);
      return;
    }
    int i = Mu().getInt("special_scene_enable", -1);
    if (bo.hl(i, -1)) {}
    for (etC = 0;; etC = i)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.BaseNotificationConfig", "iniSpecialSceneSwitchEnable() sceneEnable:%s mSpecialSceneSwitchEnable:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(etC) });
      AppMethodBeat.o(77648);
      return;
    }
  }
  
  public static boolean MM()
  {
    AppMethodBeat.i(77649);
    boolean bool = Mu().getBoolean("settings_active_time_full", true);
    AppMethodBeat.o(77649);
    return bool;
  }
  
  public static int MN()
  {
    AppMethodBeat.i(77650);
    int i = Mu().getInt("settings_active_begin_time_hour", 8);
    AppMethodBeat.o(77650);
    return i;
  }
  
  public static int MO()
  {
    AppMethodBeat.i(77651);
    int i = Mu().getInt("settings_active_end_time_hour", 23);
    AppMethodBeat.o(77651);
    return i;
  }
  
  public static int MP()
  {
    AppMethodBeat.i(77652);
    int i = Mu().getInt("settings_active_begin_time_min", 0);
    AppMethodBeat.o(77652);
    return i;
  }
  
  public static int MQ()
  {
    AppMethodBeat.i(77653);
    int i = Mu().getInt("settings_active_end_time_min", 0);
    AppMethodBeat.o(77653);
    return i;
  }
  
  public static String Mt()
  {
    AppMethodBeat.i(77630);
    if (bo.isNullOrNil(etE)) {
      etE = com.tencent.mm.kernel.a.Mu().getString("message_channel_id", "message_channel_new_id");
    }
    String str = etE;
    AppMethodBeat.o(77630);
    return str;
  }
  
  protected static SharedPreferences Mu()
  {
    AppMethodBeat.i(77631);
    if (etF != null)
    {
      localSharedPreferences = etF;
      AppMethodBeat.o(77631);
      return localSharedPreferences;
    }
    SharedPreferences localSharedPreferences = com.tencent.mm.kernel.a.Mu();
    etF = localSharedPreferences;
    AppMethodBeat.o(77631);
    return localSharedPreferences;
  }
  
  public static SharedPreferences Mv()
  {
    AppMethodBeat.i(77632);
    SharedPreferences localSharedPreferences = com.tencent.mm.network.ab.any();
    AppMethodBeat.o(77632);
    return localSharedPreferences;
  }
  
  public static boolean Mw()
  {
    AppMethodBeat.i(77633);
    if (d.fv(26))
    {
      AppMethodBeat.o(77633);
      return true;
    }
    AppMethodBeat.o(77633);
    return false;
  }
  
  public static boolean Mx()
  {
    AppMethodBeat.i(77634);
    boolean bool = Mu().getBoolean("settings_new_msg_notification", true);
    AppMethodBeat.o(77634);
    return bool;
  }
  
  public static boolean My()
  {
    AppMethodBeat.i(77635);
    if (!v.K(ah.getContext()).areNotificationsEnabled())
    {
      AppMethodBeat.o(77635);
      return false;
    }
    if (d.fv(26))
    {
      if (etG == null) {
        etG = ((NotificationManager)ah.getContext().getSystemService(NotificationManager.class)).getNotificationChannel(Mt());
      }
      if ((etG != null) && (etG.getImportance() <= 0))
      {
        AppMethodBeat.o(77635);
        return false;
      }
    }
    AppMethodBeat.o(77635);
    return true;
  }
  
  public static boolean Mz()
  {
    AppMethodBeat.i(77636);
    boolean bool = Mu().getBoolean("settings_new_voip_msg_notification", true);
    AppMethodBeat.o(77636);
    return bool;
  }
  
  public static boolean bX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(77654);
    if (MM())
    {
      AppMethodBeat.o(77654);
      return true;
    }
    int i = MN();
    int j = MP();
    int k = MO();
    int m = MQ();
    if ((i == k) && (j == m))
    {
      AppMethodBeat.o(77654);
      return false;
    }
    if ((i == k) && (j < m))
    {
      if ((paramInt1 == i) && (paramInt2 > j) && (paramInt2 < m))
      {
        AppMethodBeat.o(77654);
        return true;
      }
      AppMethodBeat.o(77654);
      return false;
    }
    if (k > i)
    {
      if (((paramInt1 > i) && (paramInt1 < k)) || ((paramInt1 == i) && (paramInt2 > j)) || ((paramInt1 == k) && (paramInt2 < m)))
      {
        AppMethodBeat.o(77654);
        return true;
      }
      AppMethodBeat.o(77654);
      return false;
    }
    if ((k < i) || ((i == k) && (j > m)))
    {
      if (((paramInt1 > i) && (paramInt1 <= 23)) || ((paramInt1 == i) && (paramInt2 > j)) || ((paramInt1 == k) && (paramInt2 < m)) || ((paramInt1 > 0) && (paramInt1 < k)))
      {
        AppMethodBeat.o(77654);
        return true;
      }
      AppMethodBeat.o(77654);
      return false;
    }
    AppMethodBeat.o(77654);
    return true;
  }
  
  static void lt(String paramString)
  {
    AppMethodBeat.i(77643);
    Mu().edit().putString("settings.ringtone", paramString).commit();
    AppMethodBeat.o(77643);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.m.a
 * JD-Core Version:    0.7.0.1
 */