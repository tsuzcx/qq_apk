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
import com.tencent.mm.network.ad;
import com.tencent.mm.sdk.h.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;

public class a
{
  private static int ggr = -1;
  public static final String ggs = null;
  private static String ggt = "";
  private static SharedPreferences ggu = null;
  private static NotificationChannel ggv;
  private static String ggw = ggs;
  private static boolean ggx = false;
  private static boolean ggy = false;
  
  public static String abK()
  {
    AppMethodBeat.i(149964);
    if (bu.isNullOrNil(ggt)) {
      ggt = com.tencent.mm.kernel.a.abL().getString("message_channel_id", "message_channel_new_id");
    }
    String str = ggt;
    AppMethodBeat.o(149964);
    return str;
  }
  
  protected static SharedPreferences abL()
  {
    AppMethodBeat.i(149965);
    if (ggu != null)
    {
      localSharedPreferences = ggu;
      AppMethodBeat.o(149965);
      return localSharedPreferences;
    }
    SharedPreferences localSharedPreferences = com.tencent.mm.kernel.a.abL();
    ggu = localSharedPreferences;
    AppMethodBeat.o(149965);
    return localSharedPreferences;
  }
  
  public static SharedPreferences abM()
  {
    AppMethodBeat.i(149966);
    SharedPreferences localSharedPreferences = ad.aPD();
    AppMethodBeat.o(149966);
    return localSharedPreferences;
  }
  
  public static boolean abN()
  {
    AppMethodBeat.i(149967);
    if (d.lA(26))
    {
      AppMethodBeat.o(149967);
      return true;
    }
    AppMethodBeat.o(149967);
    return false;
  }
  
  public static boolean abO()
  {
    AppMethodBeat.i(149968);
    boolean bool = abL().getBoolean("settings_new_msg_notification", true);
    AppMethodBeat.o(149968);
    return bool;
  }
  
  public static boolean abP()
  {
    AppMethodBeat.i(149969);
    if (!v.O(ak.getContext()).areNotificationsEnabled())
    {
      AppMethodBeat.o(149969);
      return false;
    }
    if (d.lA(26))
    {
      if (ggv == null) {
        ggv = ((NotificationManager)ak.getContext().getSystemService(NotificationManager.class)).getNotificationChannel(abK());
      }
      if ((ggv != null) && (ggv.getImportance() <= 0))
      {
        AppMethodBeat.o(149969);
        return false;
      }
    }
    AppMethodBeat.o(149969);
    return true;
  }
  
  public static boolean abQ()
  {
    AppMethodBeat.i(149970);
    boolean bool = abL().getBoolean("settings_new_voip_msg_notification", true);
    AppMethodBeat.o(149970);
    return bool;
  }
  
  public static boolean abR()
  {
    AppMethodBeat.i(149971);
    boolean bool = abL().getBoolean("settings_show_detail", true);
    AppMethodBeat.o(149971);
    return bool;
  }
  
  public static boolean abS()
  {
    AppMethodBeat.i(149972);
    boolean bool2 = abL().getBoolean("settings_sound", true);
    boolean bool1;
    if (d.lA(26)) {
      if (ggr == 0)
      {
        boolean bool3 = abT();
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
      bool1 = abZ();
      continue;
      bool1 = bool2;
    }
  }
  
  public static boolean abT()
  {
    AppMethodBeat.i(149973);
    if (d.lA(26))
    {
      NotificationChannel localNotificationChannel = ((NotificationManager)ak.getContext().getSystemService(NotificationManager.class)).getNotificationChannel(abK());
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
      int i = v.O(ak.getContext()).getImportance();
      if ((i < 3) && (i != -1000))
      {
        AppMethodBeat.o(149973);
        return false;
      }
    }
    AppMethodBeat.o(149973);
    return true;
  }
  
  public static boolean abU()
  {
    AppMethodBeat.i(149974);
    if (d.lC(28))
    {
      NotificationChannel localNotificationChannel = ((NotificationManager)ak.getContext().getSystemService(NotificationManager.class)).getNotificationChannel("voip_notify_channel_new_id");
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
  
  public static boolean abV()
  {
    AppMethodBeat.i(149975);
    if (d.lC(28))
    {
      NotificationChannel localNotificationChannel = ((NotificationManager)ak.getContext().getSystemService(NotificationManager.class)).getNotificationChannel("voip_notify_channel_new_id");
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
  
  public static boolean abW()
  {
    AppMethodBeat.i(149976);
    boolean bool2 = abL().getBoolean("settings_shake", true);
    boolean bool1;
    if (d.lA(26)) {
      if (ggr == 0)
      {
        boolean bool3 = abX();
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
      bool1 = aca();
      continue;
      bool1 = bool2;
    }
  }
  
  public static boolean abX()
  {
    AppMethodBeat.i(149977);
    if (d.lA(26))
    {
      NotificationChannel localNotificationChannel = ((NotificationManager)ak.getContext().getSystemService(NotificationManager.class)).getNotificationChannel(abK());
      if ((localNotificationChannel != null) && ((localNotificationChannel.getImportance() < 3) || (!localNotificationChannel.shouldVibrate())))
      {
        AppMethodBeat.o(149977);
        return false;
      }
    }
    else
    {
      int i = v.O(ak.getContext()).getImportance();
      if ((i < 3) && (i != -1000))
      {
        AppMethodBeat.o(149977);
        return false;
      }
    }
    AppMethodBeat.o(149977);
    return true;
  }
  
  public static String abY()
  {
    AppMethodBeat.i(149978);
    Object localObject1;
    RingtoneManager localRingtoneManager;
    if (!d.lA(26))
    {
      Object localObject4 = abL().getString("settings.ringtone", ggs);
      localObject1 = localObject4;
      Object localObject6;
      if (localObject4 != ggs)
      {
        localObject1 = localObject4;
        if (!((String)localObject4).equals(ggw))
        {
          localRingtoneManager = new RingtoneManager(ak.getContext());
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
          localObject6 = ggs;
          localObject1 = localObject6;
          vU((String)localObject6);
          localObject1 = localObject6;
          ae.i("MicroMsg.BaseNotificationConfig", "reset ringTone");
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
          ae.printErrStackTrace("MicroMsg.BaseNotificationConfig", localException, "ringTone() Exception:%s", new Object[] { localException.getMessage() });
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
      ggw = (String)localObject4;
      localObject1 = localObject4;
      AppMethodBeat.o(149978);
      return localObject1;
    }
    label193:
    Object localObject3 = ((NotificationManager)ak.getContext().getSystemService(NotificationManager.class)).getNotificationChannel(abK());
    if ((localObject3 != null) && (((NotificationChannel)localObject3).getSound() != null))
    {
      localObject3 = ((NotificationChannel)localObject3).getSound().toString();
      AppMethodBeat.o(149978);
      return localObject3;
    }
    AppMethodBeat.o(149978);
    return "";
  }
  
  public static boolean abZ()
  {
    AppMethodBeat.i(149980);
    SharedPreferences localSharedPreferences = abL();
    boolean bool = localSharedPreferences.getBoolean("settings_special_scene_sound", localSharedPreferences.getBoolean("settings_sound", true));
    AppMethodBeat.o(149980);
    return bool;
  }
  
  public static boolean aca()
  {
    AppMethodBeat.i(149981);
    SharedPreferences localSharedPreferences = abL();
    boolean bool = localSharedPreferences.getBoolean("settings_special_scene_shake", localSharedPreferences.getBoolean("settings_shake", true));
    AppMethodBeat.o(149981);
    return bool;
  }
  
  public static boolean acb()
  {
    AppMethodBeat.i(149982);
    SharedPreferences localSharedPreferences = abL();
    boolean bool = localSharedPreferences.getBoolean("settings_voip_scene_sound", abS());
    if (!ggx)
    {
      ggx = true;
      localSharedPreferences.edit().putBoolean("settings_voip_scene_sound", bool).commit();
    }
    AppMethodBeat.o(149982);
    return bool;
  }
  
  public static boolean acc()
  {
    AppMethodBeat.i(149983);
    SharedPreferences localSharedPreferences = abL();
    boolean bool = localSharedPreferences.getBoolean("settings_voip_scene_shake", abW());
    if (!ggy)
    {
      ggy = true;
      localSharedPreferences.edit().putBoolean("settings_voip_scene_shake", bool).commit();
    }
    AppMethodBeat.o(149983);
    return bool;
  }
  
  public static int acd()
  {
    return ggr;
  }
  
  public static void ace()
  {
    AppMethodBeat.i(149984);
    if (b.fqp())
    {
      ggr = 1;
      ae.i("MicroMsg.BaseNotificationConfig", "iniSpecialSceneSwitchEnable() mSpecialSceneSwitchEnable:%s", new Object[] { Integer.valueOf(ggr) });
      AppMethodBeat.o(149984);
      return;
    }
    int i = abL().getInt("special_scene_enable", -1);
    if (bu.jB(i, -1)) {}
    for (ggr = 0;; ggr = i)
    {
      ae.i("MicroMsg.BaseNotificationConfig", "iniSpecialSceneSwitchEnable() sceneEnable:%s mSpecialSceneSwitchEnable:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(ggr) });
      AppMethodBeat.o(149984);
      return;
    }
  }
  
  public static boolean acf()
  {
    AppMethodBeat.i(149985);
    boolean bool = abL().getBoolean("settings_active_time_full", true);
    AppMethodBeat.o(149985);
    return bool;
  }
  
  public static int acg()
  {
    AppMethodBeat.i(149986);
    int i = abL().getInt("settings_active_begin_time_hour", 8);
    AppMethodBeat.o(149986);
    return i;
  }
  
  public static int ach()
  {
    AppMethodBeat.i(149987);
    int i = abL().getInt("settings_active_end_time_hour", 23);
    AppMethodBeat.o(149987);
    return i;
  }
  
  public static int aci()
  {
    AppMethodBeat.i(149988);
    int i = abL().getInt("settings_active_begin_time_min", 0);
    AppMethodBeat.o(149988);
    return i;
  }
  
  public static int acj()
  {
    AppMethodBeat.i(149989);
    int i = abL().getInt("settings_active_end_time_min", 0);
    AppMethodBeat.o(149989);
    return i;
  }
  
  public static boolean cr(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(149990);
    if (acf())
    {
      AppMethodBeat.o(149990);
      return true;
    }
    int i = acg();
    int j = aci();
    int k = ach();
    int m = acj();
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
  
  static void vU(String paramString)
  {
    AppMethodBeat.i(149979);
    abL().edit().putString("settings.ringtone", paramString).commit();
    AppMethodBeat.o(149979);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.n.a
 * JD-Core Version:    0.7.0.1
 */