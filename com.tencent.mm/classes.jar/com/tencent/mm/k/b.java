package com.tencent.mm.k;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.net.Uri;
import android.util.Pair;
import androidx.core.app.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.network.ag;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.vendor.MIUI;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;

public class b
{
  private static int lZD = -1;
  public static final String lZE = null;
  private static String lZF = "";
  private static SharedPreferences lZG = null;
  private static NotificationChannel lZH;
  private static String lZI = lZE;
  private static boolean lZJ = false;
  private static boolean lZK = false;
  
  public static void DG(String paramString)
  {
    lZF = paramString;
  }
  
  public static boolean DH(String paramString)
  {
    AppMethodBeat.i(231808);
    if (d.rd(28))
    {
      paramString = ((NotificationManager)MMApplicationContext.getContext().getSystemService(NotificationManager.class)).getNotificationChannel(paramString);
      if ((paramString != null) && (paramString.getImportance() < 3))
      {
        AppMethodBeat.o(231808);
        return false;
      }
      if ((paramString == null) || (paramString.getSound() != null))
      {
        AppMethodBeat.o(231808);
        return true;
      }
      AppMethodBeat.o(231808);
      return false;
    }
    AppMethodBeat.o(231808);
    return true;
  }
  
  public static boolean DI(String paramString)
  {
    AppMethodBeat.i(231809);
    if (d.rd(28))
    {
      paramString = ((NotificationManager)MMApplicationContext.getContext().getSystemService(NotificationManager.class)).getNotificationChannel(paramString);
      if ((paramString == null) || ((paramString.getImportance() >= 3) && (paramString.shouldVibrate())))
      {
        AppMethodBeat.o(231809);
        return true;
      }
      AppMethodBeat.o(231809);
      return false;
    }
    AppMethodBeat.o(231809);
    return true;
  }
  
  static void DJ(String paramString)
  {
    AppMethodBeat.i(149979);
    aQC().edit().putString("settings.ringtone", paramString).commit();
    AppMethodBeat.o(149979);
  }
  
  public static String J(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(231839);
    String str = paramContext.getString(c.h.app_lang_sys);
    switch (paramInt)
    {
    default: 
      paramContext = str;
    }
    for (;;)
    {
      AppMethodBeat.o(231839);
      return paramContext;
      paramContext = paramContext.getString(c.h.app_lang_sys);
      continue;
      paramContext = paramContext.getString(c.h.setting_message_ringtone_default_brick);
      continue;
      paramContext = paramContext.getString(c.h.setting_message_ringtone_default_loveliness);
      continue;
      paramContext = paramContext.getString(c.h.setting_message_ringtone_default_intangible);
      continue;
      paramContext = paramContext.getString(c.h.setting_message_ringtone_default_good_looking);
      continue;
      paramContext = paramContext.getString(c.h.setting_message_ringtone_default_clear_and_melodious);
      continue;
      paramContext = paramContext.getString(c.h.setting_message_ringtone_default_etherealize);
      continue;
      paramContext = paramContext.getString(c.h.setting_message_ringtone_default_grace);
    }
  }
  
  public static String aQB()
  {
    AppMethodBeat.i(149964);
    if (Util.isNullOrNil(lZF)) {
      lZF = com.tencent.mm.kernel.b.aQC().getString("message_channel_id", "message_channel_new_id");
    }
    String str = lZF;
    AppMethodBeat.o(149964);
    return str;
  }
  
  protected static SharedPreferences aQC()
  {
    AppMethodBeat.i(149965);
    if (lZG != null)
    {
      localSharedPreferences = lZG;
      AppMethodBeat.o(149965);
      return localSharedPreferences;
    }
    SharedPreferences localSharedPreferences = com.tencent.mm.kernel.b.aQC();
    lZG = localSharedPreferences;
    AppMethodBeat.o(149965);
    return localSharedPreferences;
  }
  
  public static SharedPreferences aQD()
  {
    AppMethodBeat.i(149966);
    SharedPreferences localSharedPreferences = ag.bRr();
    AppMethodBeat.o(149966);
    return localSharedPreferences;
  }
  
  public static boolean aQE()
  {
    AppMethodBeat.i(149967);
    if (d.rb(26))
    {
      AppMethodBeat.o(149967);
      return true;
    }
    AppMethodBeat.o(149967);
    return false;
  }
  
  public static boolean aQF()
  {
    AppMethodBeat.i(149968);
    boolean bool = aQC().getBoolean("settings_new_msg_notification", true);
    AppMethodBeat.o(149968);
    return bool;
  }
  
  public static boolean aQG()
  {
    AppMethodBeat.i(149969);
    if (!i.X(MMApplicationContext.getContext()).DB())
    {
      AppMethodBeat.o(149969);
      return false;
    }
    if (d.rb(26))
    {
      if (lZH == null) {
        lZH = ((NotificationManager)MMApplicationContext.getContext().getSystemService(NotificationManager.class)).getNotificationChannel(aQB());
      }
      if ((lZH != null) && (lZH.getImportance() <= 0))
      {
        AppMethodBeat.o(149969);
        return false;
      }
    }
    AppMethodBeat.o(149969);
    return true;
  }
  
  public static boolean aQH()
  {
    AppMethodBeat.i(149970);
    boolean bool = aQC().getBoolean("settings_new_voip_msg_notification", true);
    AppMethodBeat.o(149970);
    return bool;
  }
  
  public static boolean aQI()
  {
    AppMethodBeat.i(149971);
    boolean bool = aQC().getBoolean("settings_show_detail", true);
    AppMethodBeat.o(149971);
    return bool;
  }
  
  public static boolean aQJ()
  {
    AppMethodBeat.i(231800);
    boolean bool = aQC().getBoolean("settings_ringtone_allow_hear", true);
    AppMethodBeat.o(231800);
    return bool;
  }
  
  public static boolean aQK()
  {
    AppMethodBeat.i(231804);
    boolean bool = aQC().getBoolean("settings_voip_show_detail", true);
    AppMethodBeat.o(231804);
    return bool;
  }
  
  public static boolean aQL()
  {
    AppMethodBeat.i(149972);
    boolean bool2 = aQC().getBoolean("settings_sound", true);
    boolean bool1;
    if (d.rb(26)) {
      if (lZD == 0)
      {
        boolean bool3 = aQM();
        bool1 = bool3;
        if (bool2 != bool3)
        {
          h.eP(bool3);
          bool1 = bool3;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(149972);
      return bool1;
      bool1 = aQR();
      continue;
      bool1 = bool2;
    }
  }
  
  public static boolean aQM()
  {
    AppMethodBeat.i(149973);
    if (d.rb(26))
    {
      NotificationChannel localNotificationChannel = ((NotificationManager)MMApplicationContext.getContext().getSystemService(NotificationManager.class)).getNotificationChannel(aQB());
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
      int i = i.X(MMApplicationContext.getContext()).DC();
      if ((i < 3) && (i != -1000))
      {
        AppMethodBeat.o(149973);
        return false;
      }
    }
    AppMethodBeat.o(149973);
    return true;
  }
  
  public static boolean aQN()
  {
    AppMethodBeat.i(149976);
    boolean bool2 = aQC().getBoolean("settings_shake", true);
    boolean bool1;
    if (d.rb(26)) {
      if (lZD == 0)
      {
        boolean bool3 = aQO();
        bool1 = bool3;
        if (bool3 != bool2)
        {
          h.eR(bool3);
          bool1 = bool3;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(149976);
      return bool1;
      bool1 = aQS();
      continue;
      bool1 = bool2;
    }
  }
  
  public static boolean aQO()
  {
    AppMethodBeat.i(149977);
    if (d.rb(26))
    {
      NotificationChannel localNotificationChannel = ((NotificationManager)MMApplicationContext.getContext().getSystemService(NotificationManager.class)).getNotificationChannel(aQB());
      if ((localNotificationChannel != null) && ((localNotificationChannel.getImportance() < 3) || (!localNotificationChannel.shouldVibrate())))
      {
        AppMethodBeat.o(149977);
        return false;
      }
    }
    else
    {
      int i = i.X(MMApplicationContext.getContext()).DC();
      if ((i < 3) && (i != -1000))
      {
        AppMethodBeat.o(149977);
        return false;
      }
    }
    AppMethodBeat.o(149977);
    return true;
  }
  
  public static Pair<Boolean, String> aQP()
  {
    AppMethodBeat.i(231811);
    if (!d.rb(26))
    {
      int i = aQQ();
      Object localObject1;
      RingtoneManager localRingtoneManager;
      if (i == -1)
      {
        Object localObject4 = aQC().getString("settings.ringtone", lZE);
        localObject1 = localObject4;
        Object localObject6;
        if (localObject4 != lZE)
        {
          localObject1 = localObject4;
          if (!((String)localObject4).equals(lZI))
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
            localObject6 = lZE;
            localObject1 = localObject6;
            DJ((String)localObject6);
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
            break label227;
          }
          localRingtoneManager.getCursor().close();
          AppMethodBeat.o(231811);
        }
        lZI = (String)localObject4;
        localObject1 = localObject4;
        localObject1 = new Pair(Boolean.FALSE, localObject1);
        AppMethodBeat.o(231811);
        return localObject1;
      }
      label227:
      if (i == 0)
      {
        localObject3 = new Pair(Boolean.TRUE, lZE);
        AppMethodBeat.o(231811);
        return localObject3;
      }
      localObject3 = rg(i);
      if (y.ZC((String)localObject3))
      {
        localObject3 = new Pair(Boolean.TRUE, localObject3);
        AppMethodBeat.o(231811);
        return localObject3;
      }
      localObject3 = new Pair(Boolean.TRUE, lZE);
      AppMethodBeat.o(231811);
      return localObject3;
    }
    Object localObject3 = ((NotificationManager)MMApplicationContext.getContext().getSystemService(NotificationManager.class)).getNotificationChannel(aQB());
    if ((localObject3 != null) && (((NotificationChannel)localObject3).getSound() != null))
    {
      localObject3 = new Pair(Boolean.FALSE, ((NotificationChannel)localObject3).getSound().toString());
      AppMethodBeat.o(231811);
      return localObject3;
    }
    localObject3 = new Pair(Boolean.FALSE, "");
    AppMethodBeat.o(231811);
    return localObject3;
  }
  
  public static int aQQ()
  {
    int i = -1;
    AppMethodBeat.i(231812);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("setting_notification");
    if (localMultiProcessMMKV != null) {
      i = localMultiProcessMMKV.decodeInt("settings.ringtone.wechat", -1);
    }
    AppMethodBeat.o(231812);
    return i;
  }
  
  public static boolean aQR()
  {
    AppMethodBeat.i(149980);
    SharedPreferences localSharedPreferences = aQC();
    boolean bool = localSharedPreferences.getBoolean("settings_special_scene_sound", localSharedPreferences.getBoolean("settings_sound", true));
    AppMethodBeat.o(149980);
    return bool;
  }
  
  public static boolean aQS()
  {
    AppMethodBeat.i(149981);
    SharedPreferences localSharedPreferences = aQC();
    boolean bool = localSharedPreferences.getBoolean("settings_special_scene_shake", localSharedPreferences.getBoolean("settings_shake", true));
    AppMethodBeat.o(149981);
    return bool;
  }
  
  public static boolean aQT()
  {
    AppMethodBeat.i(149982);
    SharedPreferences localSharedPreferences = aQC();
    boolean bool = localSharedPreferences.getBoolean("settings_voip_scene_sound", aQL());
    if (!lZJ)
    {
      lZJ = true;
      localSharedPreferences.edit().putBoolean("settings_voip_scene_sound", bool).commit();
    }
    AppMethodBeat.o(149982);
    return bool;
  }
  
  public static boolean aQU()
  {
    AppMethodBeat.i(149983);
    SharedPreferences localSharedPreferences = aQC();
    boolean bool = localSharedPreferences.getBoolean("settings_voip_scene_shake", aQN());
    if (!lZK)
    {
      lZK = true;
      localSharedPreferences.edit().putBoolean("settings_voip_scene_shake", bool).commit();
    }
    AppMethodBeat.o(149983);
    return bool;
  }
  
  public static int aQV()
  {
    return lZD;
  }
  
  public static void aQW()
  {
    AppMethodBeat.i(149984);
    if (MIUI.ifMIUI())
    {
      lZD = 1;
      Log.i("MicroMsg.BaseNotificationConfig", "iniSpecialSceneSwitchEnable() mSpecialSceneSwitchEnable:%s", new Object[] { Integer.valueOf(lZD) });
      AppMethodBeat.o(149984);
      return;
    }
    int i = aQC().getInt("special_scene_enable", -1);
    if (Util.isEqual(i, -1)) {}
    for (lZD = 0;; lZD = i)
    {
      Log.i("MicroMsg.BaseNotificationConfig", "iniSpecialSceneSwitchEnable() sceneEnable:%s mSpecialSceneSwitchEnable:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(lZD) });
      AppMethodBeat.o(149984);
      return;
    }
  }
  
  public static boolean aQX()
  {
    AppMethodBeat.i(149985);
    if (((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.zxo, 0) == 0)
    {
      AppMethodBeat.o(149985);
      return true;
    }
    boolean bool = aQC().getBoolean("settings_active_time_full", true);
    AppMethodBeat.o(149985);
    return bool;
  }
  
  public static int aQY()
  {
    AppMethodBeat.i(149986);
    int i = aQC().getInt("settings_active_begin_time_hour", 8);
    AppMethodBeat.o(149986);
    return i;
  }
  
  public static int aQZ()
  {
    AppMethodBeat.i(149987);
    int i = aQC().getInt("settings_active_end_time_hour", 23);
    AppMethodBeat.o(149987);
    return i;
  }
  
  public static int aRa()
  {
    AppMethodBeat.i(149988);
    int i = aQC().getInt("settings_active_begin_time_min", 0);
    AppMethodBeat.o(149988);
    return i;
  }
  
  public static int aRb()
  {
    AppMethodBeat.i(149989);
    int i = aQC().getInt("settings_active_end_time_min", 0);
    AppMethodBeat.o(149989);
    return i;
  }
  
  public static boolean dB(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(149990);
    if (aQX())
    {
      AppMethodBeat.o(149990);
      return true;
    }
    int i = aQY();
    int j = aRa();
    int k = aQZ();
    int m = aRb();
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
  
  public static ArrayList<g> dk(Context paramContext)
  {
    AppMethodBeat.i(231837);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new g(0, paramContext.getString(c.h.app_lang_sys)));
    localArrayList.add(new g(1, paramContext.getString(c.h.setting_message_ringtone_default_brick)));
    localArrayList.add(new g(2, paramContext.getString(c.h.setting_message_ringtone_default_loveliness)));
    localArrayList.add(new g(3, paramContext.getString(c.h.setting_message_ringtone_default_intangible)));
    localArrayList.add(new g(4, paramContext.getString(c.h.setting_message_ringtone_default_good_looking)));
    localArrayList.add(new g(5, paramContext.getString(c.h.setting_message_ringtone_default_clear_and_melodious)));
    localArrayList.add(new g(6, paramContext.getString(c.h.setting_message_ringtone_default_etherealize)));
    localArrayList.add(new g(7, paramContext.getString(c.h.setting_message_ringtone_default_grace)));
    AppMethodBeat.o(231837);
    return localArrayList;
  }
  
  public static void rf(int paramInt)
  {
    AppMethodBeat.i(231813);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("setting_notification");
    if (localMultiProcessMMKV != null) {
      localMultiProcessMMKV.putInt("settings.ringtone.wechat", paramInt);
    }
    AppMethodBeat.o(231813);
  }
  
  public static String rg(int paramInt)
  {
    AppMethodBeat.i(231843);
    if ((paramInt == 0) || (paramInt == -1))
    {
      AppMethodBeat.o(231843);
      return "";
    }
    String str = "";
    switch (paramInt)
    {
    }
    for (;;)
    {
      str = com.tencent.mm.loader.i.b.bmr() + "newmsgringtone/" + MMApplicationContext.getContext().getString(c.h.setting_message_ringtone_file_name, new Object[] { str });
      AppMethodBeat.o(231843);
      return str;
      str = "Toys";
      continue;
      str = "Cupid";
      continue;
      str = "Celestial";
      continue;
      str = "Delight";
      continue;
      str = "Crystals";
      continue;
      str = "Fairy";
      continue;
      str = "Elegance";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.k.b
 * JD-Core Version:    0.7.0.1
 */