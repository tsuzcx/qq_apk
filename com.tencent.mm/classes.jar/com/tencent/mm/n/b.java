package com.tencent.mm.n;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.net.Uri;
import androidx.core.app.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.network.af;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.vendor.MIUI;

public class b
{
  private static int jwl = -1;
  public static final String jwm = null;
  private static String jwn = "";
  private static SharedPreferences jwo = null;
  private static NotificationChannel jwp;
  private static String jwq = jwm;
  private static boolean jwr = false;
  private static boolean jws = false;
  
  static void Lc(String paramString)
  {
    AppMethodBeat.i(149979);
    awd().edit().putString("settings.ringtone", paramString).commit();
    AppMethodBeat.o(149979);
  }
  
  public static int awA()
  {
    AppMethodBeat.i(149988);
    int i = awd().getInt("settings_active_begin_time_min", 0);
    AppMethodBeat.o(149988);
    return i;
  }
  
  public static int awB()
  {
    AppMethodBeat.i(149989);
    int i = awd().getInt("settings_active_end_time_min", 0);
    AppMethodBeat.o(149989);
    return i;
  }
  
  public static String awc()
  {
    AppMethodBeat.i(149964);
    if (Util.isNullOrNil(jwn)) {
      jwn = com.tencent.mm.kernel.b.awd().getString("message_channel_id", "message_channel_new_id");
    }
    String str = jwn;
    AppMethodBeat.o(149964);
    return str;
  }
  
  protected static SharedPreferences awd()
  {
    AppMethodBeat.i(149965);
    if (jwo != null)
    {
      localSharedPreferences = jwo;
      AppMethodBeat.o(149965);
      return localSharedPreferences;
    }
    SharedPreferences localSharedPreferences = com.tencent.mm.kernel.b.awd();
    jwo = localSharedPreferences;
    AppMethodBeat.o(149965);
    return localSharedPreferences;
  }
  
  public static SharedPreferences awe()
  {
    AppMethodBeat.i(149966);
    SharedPreferences localSharedPreferences = af.btN();
    AppMethodBeat.o(149966);
    return localSharedPreferences;
  }
  
  public static boolean awf()
  {
    AppMethodBeat.i(149967);
    if (d.qV(26))
    {
      AppMethodBeat.o(149967);
      return true;
    }
    AppMethodBeat.o(149967);
    return false;
  }
  
  public static boolean awg()
  {
    AppMethodBeat.i(149968);
    boolean bool = awd().getBoolean("settings_new_msg_notification", true);
    AppMethodBeat.o(149968);
    return bool;
  }
  
  public static boolean awh()
  {
    AppMethodBeat.i(149969);
    if (!h.M(MMApplicationContext.getContext()).gs())
    {
      AppMethodBeat.o(149969);
      return false;
    }
    if (d.qV(26))
    {
      if (jwp == null) {
        jwp = ((NotificationManager)MMApplicationContext.getContext().getSystemService(NotificationManager.class)).getNotificationChannel(awc());
      }
      if ((jwp != null) && (jwp.getImportance() <= 0))
      {
        AppMethodBeat.o(149969);
        return false;
      }
    }
    AppMethodBeat.o(149969);
    return true;
  }
  
  public static boolean awi()
  {
    AppMethodBeat.i(149970);
    boolean bool = awd().getBoolean("settings_new_voip_msg_notification", true);
    AppMethodBeat.o(149970);
    return bool;
  }
  
  public static boolean awj()
  {
    AppMethodBeat.i(149971);
    boolean bool = awd().getBoolean("settings_show_detail", true);
    AppMethodBeat.o(149971);
    return bool;
  }
  
  public static boolean awk()
  {
    AppMethodBeat.i(149972);
    boolean bool2 = awd().getBoolean("settings_sound", true);
    boolean bool1;
    if (d.qV(26)) {
      if (jwl == 0)
      {
        boolean bool3 = awl();
        bool1 = bool3;
        if (bool2 != bool3)
        {
          g.ed(bool3);
          bool1 = bool3;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(149972);
      return bool1;
      bool1 = awr();
      continue;
      bool1 = bool2;
    }
  }
  
  public static boolean awl()
  {
    AppMethodBeat.i(149973);
    if (d.qV(26))
    {
      NotificationChannel localNotificationChannel = ((NotificationManager)MMApplicationContext.getContext().getSystemService(NotificationManager.class)).getNotificationChannel(awc());
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
      int i = h.M(MMApplicationContext.getContext()).gt();
      if ((i < 3) && (i != -1000))
      {
        AppMethodBeat.o(149973);
        return false;
      }
    }
    AppMethodBeat.o(149973);
    return true;
  }
  
  public static boolean awm()
  {
    AppMethodBeat.i(149974);
    if (d.qX(28))
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
  
  public static boolean awn()
  {
    AppMethodBeat.i(149975);
    if (d.qX(28))
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
  
  public static boolean awo()
  {
    AppMethodBeat.i(149976);
    boolean bool2 = awd().getBoolean("settings_shake", true);
    boolean bool1;
    if (d.qV(26)) {
      if (jwl == 0)
      {
        boolean bool3 = awp();
        bool1 = bool3;
        if (bool3 != bool2)
        {
          g.ee(bool3);
          bool1 = bool3;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(149976);
      return bool1;
      bool1 = aws();
      continue;
      bool1 = bool2;
    }
  }
  
  public static boolean awp()
  {
    AppMethodBeat.i(149977);
    if (d.qV(26))
    {
      NotificationChannel localNotificationChannel = ((NotificationManager)MMApplicationContext.getContext().getSystemService(NotificationManager.class)).getNotificationChannel(awc());
      if ((localNotificationChannel != null) && ((localNotificationChannel.getImportance() < 3) || (!localNotificationChannel.shouldVibrate())))
      {
        AppMethodBeat.o(149977);
        return false;
      }
    }
    else
    {
      int i = h.M(MMApplicationContext.getContext()).gt();
      if ((i < 3) && (i != -1000))
      {
        AppMethodBeat.o(149977);
        return false;
      }
    }
    AppMethodBeat.o(149977);
    return true;
  }
  
  public static String awq()
  {
    AppMethodBeat.i(149978);
    Object localObject1;
    RingtoneManager localRingtoneManager;
    if (!d.qV(26))
    {
      Object localObject4 = awd().getString("settings.ringtone", jwm);
      localObject1 = localObject4;
      Object localObject6;
      if (localObject4 != jwm)
      {
        localObject1 = localObject4;
        if (!((String)localObject4).equals(jwq))
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
          localObject6 = jwm;
          localObject1 = localObject6;
          Lc((String)localObject6);
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
          break label197;
        }
        localRingtoneManager.getCursor().close();
        AppMethodBeat.o(149978);
      }
      jwq = (String)localObject4;
      localObject1 = localObject4;
      AppMethodBeat.o(149978);
      return localObject1;
    }
    label197:
    Object localObject3 = ((NotificationManager)MMApplicationContext.getContext().getSystemService(NotificationManager.class)).getNotificationChannel(awc());
    if ((localObject3 != null) && (((NotificationChannel)localObject3).getSound() != null))
    {
      localObject3 = ((NotificationChannel)localObject3).getSound().toString();
      AppMethodBeat.o(149978);
      return localObject3;
    }
    AppMethodBeat.o(149978);
    return "";
  }
  
  public static boolean awr()
  {
    AppMethodBeat.i(149980);
    SharedPreferences localSharedPreferences = awd();
    boolean bool = localSharedPreferences.getBoolean("settings_special_scene_sound", localSharedPreferences.getBoolean("settings_sound", true));
    AppMethodBeat.o(149980);
    return bool;
  }
  
  public static boolean aws()
  {
    AppMethodBeat.i(149981);
    SharedPreferences localSharedPreferences = awd();
    boolean bool = localSharedPreferences.getBoolean("settings_special_scene_shake", localSharedPreferences.getBoolean("settings_shake", true));
    AppMethodBeat.o(149981);
    return bool;
  }
  
  public static boolean awt()
  {
    AppMethodBeat.i(149982);
    SharedPreferences localSharedPreferences = awd();
    boolean bool = localSharedPreferences.getBoolean("settings_voip_scene_sound", awk());
    if (!jwr)
    {
      jwr = true;
      localSharedPreferences.edit().putBoolean("settings_voip_scene_sound", bool).commit();
    }
    AppMethodBeat.o(149982);
    return bool;
  }
  
  public static boolean awu()
  {
    AppMethodBeat.i(149983);
    SharedPreferences localSharedPreferences = awd();
    boolean bool = localSharedPreferences.getBoolean("settings_voip_scene_shake", awo());
    if (!jws)
    {
      jws = true;
      localSharedPreferences.edit().putBoolean("settings_voip_scene_shake", bool).commit();
    }
    AppMethodBeat.o(149983);
    return bool;
  }
  
  public static int awv()
  {
    return jwl;
  }
  
  public static void aww()
  {
    AppMethodBeat.i(149984);
    if (MIUI.ifMIUI())
    {
      jwl = 1;
      Log.i("MicroMsg.BaseNotificationConfig", "iniSpecialSceneSwitchEnable() mSpecialSceneSwitchEnable:%s", new Object[] { Integer.valueOf(jwl) });
      AppMethodBeat.o(149984);
      return;
    }
    int i = awd().getInt("special_scene_enable", -1);
    if (Util.isEqual(i, -1)) {}
    for (jwl = 0;; jwl = i)
    {
      Log.i("MicroMsg.BaseNotificationConfig", "iniSpecialSceneSwitchEnable() sceneEnable:%s mSpecialSceneSwitchEnable:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(jwl) });
      AppMethodBeat.o(149984);
      return;
    }
  }
  
  public static boolean awx()
  {
    AppMethodBeat.i(149985);
    boolean bool = awd().getBoolean("settings_active_time_full", true);
    AppMethodBeat.o(149985);
    return bool;
  }
  
  public static int awy()
  {
    AppMethodBeat.i(149986);
    int i = awd().getInt("settings_active_begin_time_hour", 8);
    AppMethodBeat.o(149986);
    return i;
  }
  
  public static int awz()
  {
    AppMethodBeat.i(149987);
    int i = awd().getInt("settings_active_end_time_hour", 23);
    AppMethodBeat.o(149987);
    return i;
  }
  
  public static boolean cL(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(149990);
    if (awx())
    {
      AppMethodBeat.o(149990);
      return true;
    }
    int i = awy();
    int j = awA();
    int k = awz();
    int m = awB();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.n.b
 * JD-Core Version:    0.7.0.1
 */