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
import com.tencent.mm.network.ad;
import com.tencent.mm.sdk.h.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;

public class a
{
  private static int fKI = -1;
  public static final String fKJ = null;
  private static String fKK = "";
  private static SharedPreferences fKL = null;
  private static NotificationChannel fKM;
  private static String fKN = fKJ;
  private static boolean fKO = false;
  private static boolean fKP = false;
  
  public static int ZA()
  {
    AppMethodBeat.i(149989);
    int i = Zc().getInt("settings_active_end_time_min", 0);
    AppMethodBeat.o(149989);
    return i;
  }
  
  public static String Zb()
  {
    AppMethodBeat.i(149964);
    if (bs.isNullOrNil(fKK)) {
      fKK = com.tencent.mm.kernel.a.Zc().getString("message_channel_id", "message_channel_new_id");
    }
    String str = fKK;
    AppMethodBeat.o(149964);
    return str;
  }
  
  protected static SharedPreferences Zc()
  {
    AppMethodBeat.i(149965);
    if (fKL != null)
    {
      localSharedPreferences = fKL;
      AppMethodBeat.o(149965);
      return localSharedPreferences;
    }
    SharedPreferences localSharedPreferences = com.tencent.mm.kernel.a.Zc();
    fKL = localSharedPreferences;
    AppMethodBeat.o(149965);
    return localSharedPreferences;
  }
  
  public static SharedPreferences Zd()
  {
    AppMethodBeat.i(149966);
    SharedPreferences localSharedPreferences = ad.aLY();
    AppMethodBeat.o(149966);
    return localSharedPreferences;
  }
  
  public static boolean Ze()
  {
    AppMethodBeat.i(149967);
    if (d.kZ(26))
    {
      AppMethodBeat.o(149967);
      return true;
    }
    AppMethodBeat.o(149967);
    return false;
  }
  
  public static boolean Zf()
  {
    AppMethodBeat.i(149968);
    boolean bool = Zc().getBoolean("settings_new_msg_notification", true);
    AppMethodBeat.o(149968);
    return bool;
  }
  
  public static boolean Zg()
  {
    AppMethodBeat.i(149969);
    if (!v.N(ai.getContext()).areNotificationsEnabled())
    {
      AppMethodBeat.o(149969);
      return false;
    }
    if (d.kZ(26))
    {
      if (fKM == null) {
        fKM = ((NotificationManager)ai.getContext().getSystemService(NotificationManager.class)).getNotificationChannel(Zb());
      }
      if ((fKM != null) && (fKM.getImportance() <= 0))
      {
        AppMethodBeat.o(149969);
        return false;
      }
    }
    AppMethodBeat.o(149969);
    return true;
  }
  
  public static boolean Zh()
  {
    AppMethodBeat.i(149970);
    boolean bool = Zc().getBoolean("settings_new_voip_msg_notification", true);
    AppMethodBeat.o(149970);
    return bool;
  }
  
  public static boolean Zi()
  {
    AppMethodBeat.i(149971);
    boolean bool = Zc().getBoolean("settings_show_detail", true);
    AppMethodBeat.o(149971);
    return bool;
  }
  
  public static boolean Zj()
  {
    AppMethodBeat.i(149972);
    boolean bool2 = Zc().getBoolean("settings_sound", true);
    boolean bool1;
    if (d.kZ(26)) {
      if (fKI == 0)
      {
        boolean bool3 = Zk();
        bool1 = bool3;
        if (bool2 != bool3)
        {
          f.cR(bool3);
          bool1 = bool3;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(149972);
      return bool1;
      bool1 = Zq();
      continue;
      bool1 = bool2;
    }
  }
  
  public static boolean Zk()
  {
    AppMethodBeat.i(149973);
    if (d.kZ(26))
    {
      NotificationChannel localNotificationChannel = ((NotificationManager)ai.getContext().getSystemService(NotificationManager.class)).getNotificationChannel(Zb());
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
      int i = v.N(ai.getContext()).getImportance();
      if ((i < 3) && (i != -1000))
      {
        AppMethodBeat.o(149973);
        return false;
      }
    }
    AppMethodBeat.o(149973);
    return true;
  }
  
  public static boolean Zl()
  {
    AppMethodBeat.i(149974);
    if (d.lb(28))
    {
      NotificationChannel localNotificationChannel = ((NotificationManager)ai.getContext().getSystemService(NotificationManager.class)).getNotificationChannel("voip_notify_channel_new_id");
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
  
  public static boolean Zm()
  {
    AppMethodBeat.i(149975);
    if (d.lb(28))
    {
      NotificationChannel localNotificationChannel = ((NotificationManager)ai.getContext().getSystemService(NotificationManager.class)).getNotificationChannel("voip_notify_channel_new_id");
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
  
  public static boolean Zn()
  {
    AppMethodBeat.i(149976);
    boolean bool2 = Zc().getBoolean("settings_shake", true);
    boolean bool1;
    if (d.kZ(26)) {
      if (fKI == 0)
      {
        boolean bool3 = Zo();
        bool1 = bool3;
        if (bool3 != bool2)
        {
          f.cS(bool3);
          bool1 = bool3;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(149976);
      return bool1;
      bool1 = Zr();
      continue;
      bool1 = bool2;
    }
  }
  
  public static boolean Zo()
  {
    AppMethodBeat.i(149977);
    if (d.kZ(26))
    {
      NotificationChannel localNotificationChannel = ((NotificationManager)ai.getContext().getSystemService(NotificationManager.class)).getNotificationChannel(Zb());
      if ((localNotificationChannel != null) && ((localNotificationChannel.getImportance() < 3) || (!localNotificationChannel.shouldVibrate())))
      {
        AppMethodBeat.o(149977);
        return false;
      }
    }
    else
    {
      int i = v.N(ai.getContext()).getImportance();
      if ((i < 3) && (i != -1000))
      {
        AppMethodBeat.o(149977);
        return false;
      }
    }
    AppMethodBeat.o(149977);
    return true;
  }
  
  public static String Zp()
  {
    AppMethodBeat.i(149978);
    Object localObject1;
    RingtoneManager localRingtoneManager;
    if (!d.kZ(26))
    {
      Object localObject4 = Zc().getString("settings.ringtone", fKJ);
      localObject1 = localObject4;
      Object localObject6;
      if (localObject4 != fKJ)
      {
        localObject1 = localObject4;
        if (!((String)localObject4).equals(fKN))
        {
          localRingtoneManager = new RingtoneManager(ai.getContext());
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
          localObject6 = fKJ;
          localObject1 = localObject6;
          sJ((String)localObject6);
          localObject1 = localObject6;
          ac.i("MicroMsg.BaseNotificationConfig", "reset ringTone");
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
          ac.printErrStackTrace("MicroMsg.BaseNotificationConfig", localException, "ringTone() Exception:%s", new Object[] { localException.getMessage() });
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
      fKN = (String)localObject4;
      localObject1 = localObject4;
      AppMethodBeat.o(149978);
      return localObject1;
    }
    label193:
    Object localObject3 = ((NotificationManager)ai.getContext().getSystemService(NotificationManager.class)).getNotificationChannel(Zb());
    if ((localObject3 != null) && (((NotificationChannel)localObject3).getSound() != null))
    {
      localObject3 = ((NotificationChannel)localObject3).getSound().toString();
      AppMethodBeat.o(149978);
      return localObject3;
    }
    AppMethodBeat.o(149978);
    return "";
  }
  
  public static boolean Zq()
  {
    AppMethodBeat.i(149980);
    SharedPreferences localSharedPreferences = Zc();
    boolean bool = localSharedPreferences.getBoolean("settings_special_scene_sound", localSharedPreferences.getBoolean("settings_sound", true));
    AppMethodBeat.o(149980);
    return bool;
  }
  
  public static boolean Zr()
  {
    AppMethodBeat.i(149981);
    SharedPreferences localSharedPreferences = Zc();
    boolean bool = localSharedPreferences.getBoolean("settings_special_scene_shake", localSharedPreferences.getBoolean("settings_shake", true));
    AppMethodBeat.o(149981);
    return bool;
  }
  
  public static boolean Zs()
  {
    AppMethodBeat.i(149982);
    SharedPreferences localSharedPreferences = Zc();
    boolean bool = localSharedPreferences.getBoolean("settings_voip_scene_sound", Zj());
    if (!fKO)
    {
      fKO = true;
      localSharedPreferences.edit().putBoolean("settings_voip_scene_sound", bool).commit();
    }
    AppMethodBeat.o(149982);
    return bool;
  }
  
  public static boolean Zt()
  {
    AppMethodBeat.i(149983);
    SharedPreferences localSharedPreferences = Zc();
    boolean bool = localSharedPreferences.getBoolean("settings_voip_scene_shake", Zn());
    if (!fKP)
    {
      fKP = true;
      localSharedPreferences.edit().putBoolean("settings_voip_scene_shake", bool).commit();
    }
    AppMethodBeat.o(149983);
    return bool;
  }
  
  public static int Zu()
  {
    return fKI;
  }
  
  public static void Zv()
  {
    AppMethodBeat.i(149984);
    if (b.eWK())
    {
      fKI = 1;
      ac.i("MicroMsg.BaseNotificationConfig", "iniSpecialSceneSwitchEnable() mSpecialSceneSwitchEnable:%s", new Object[] { Integer.valueOf(fKI) });
      AppMethodBeat.o(149984);
      return;
    }
    int i = Zc().getInt("special_scene_enable", -1);
    if (bs.jl(i, -1)) {}
    for (fKI = 0;; fKI = i)
    {
      ac.i("MicroMsg.BaseNotificationConfig", "iniSpecialSceneSwitchEnable() sceneEnable:%s mSpecialSceneSwitchEnable:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(fKI) });
      AppMethodBeat.o(149984);
      return;
    }
  }
  
  public static boolean Zw()
  {
    AppMethodBeat.i(149985);
    boolean bool = Zc().getBoolean("settings_active_time_full", true);
    AppMethodBeat.o(149985);
    return bool;
  }
  
  public static int Zx()
  {
    AppMethodBeat.i(149986);
    int i = Zc().getInt("settings_active_begin_time_hour", 8);
    AppMethodBeat.o(149986);
    return i;
  }
  
  public static int Zy()
  {
    AppMethodBeat.i(149987);
    int i = Zc().getInt("settings_active_end_time_hour", 23);
    AppMethodBeat.o(149987);
    return i;
  }
  
  public static int Zz()
  {
    AppMethodBeat.i(149988);
    int i = Zc().getInt("settings_active_begin_time_min", 0);
    AppMethodBeat.o(149988);
    return i;
  }
  
  public static boolean cp(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(149990);
    if (Zw())
    {
      AppMethodBeat.o(149990);
      return true;
    }
    int i = Zx();
    int j = Zz();
    int k = Zy();
    int m = ZA();
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
  
  static void sJ(String paramString)
  {
    AppMethodBeat.i(149979);
    Zc().edit().putString("settings.ringtone", paramString).commit();
    AppMethodBeat.o(149979);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.m.a
 * JD-Core Version:    0.7.0.1
 */