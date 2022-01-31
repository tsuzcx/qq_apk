package com.tencent.mm.m;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.h.a.td;
import com.tencent.mm.h.a.td.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.List;

public final class f
  extends a
{
  private static String TAG = "MicroMsg.NotificationConfig";
  
  public static boolean As()
  {
    return com.tencent.mm.kernel.a.hw(com.tencent.mm.kernel.a.CZ());
  }
  
  public static boolean At()
  {
    return q.hH(com.tencent.mm.kernel.a.Da().getInt("notification.status.webonline.push.open", 0));
  }
  
  public static void Au()
  {
    SharedPreferences localSharedPreferences = ae.cqS();
    SharedPreferences.Editor localEditor = com.tencent.mm.kernel.a.Da().edit();
    boolean bool1 = localSharedPreferences.getBoolean("settings_new_msg_notification", true);
    localEditor.putBoolean("settings_new_msg_notification", bool1);
    localEditor.putBoolean("settings_new_voip_msg_notification", localSharedPreferences.getBoolean("settings_new_voip_msg_notification", true));
    boolean bool2 = localSharedPreferences.getBoolean("settings_show_detail", true);
    localEditor.putBoolean("settings_show_detail", bool2);
    boolean bool3 = localSharedPreferences.getBoolean("settings_sound", true);
    localEditor.putBoolean("settings_sound", bool3);
    String str = localSharedPreferences.getString("settings.ringtone", dAe);
    localEditor.putString("settings.ringtone", str);
    boolean bool4 = localSharedPreferences.getBoolean("settings_shake", true);
    localEditor.putBoolean("settings_shake", bool4);
    boolean bool5 = localSharedPreferences.getBoolean("settings_active_time_full", true);
    localEditor.putBoolean("settings_active_time_full", bool5);
    int i = localSharedPreferences.getInt("settings_active_begin_time_hour", 8);
    localEditor.putInt("settings_active_begin_time_hour", i);
    int j = localSharedPreferences.getInt("settings_active_begin_time_min", 0);
    localEditor.putInt("settings_active_begin_time_min", j);
    int k = localSharedPreferences.getInt("settings_active_end_time_hour", 23);
    localEditor.putInt("settings_active_end_time_hour", k);
    int m = localSharedPreferences.getInt("settings_active_end_time_min", 0);
    localEditor.putInt("settings_active_end_time_min", m);
    localEditor.commit();
    y.i(TAG, "notification config copyDefault, newMsgNotification: %B, showDetail: %B, isSound: %B, ringTone: %s, isShake: %B, isActiveTime: %B, begin: %d:%d, end: %d:Td", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), str, Boolean.valueOf(bool4), Boolean.valueOf(bool5), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
  }
  
  public static int Av()
  {
    if (!g.DK())
    {
      y.w(TAG, "getUnReadTalkerCount, but mmcore not ready");
      return 0;
    }
    return t.jdMethod_if(s.dUT);
  }
  
  public static List<String> Aw()
  {
    return t.ig(s.dUT);
  }
  
  public static int Ax()
  {
    if (!g.DK())
    {
      y.w(TAG, "getUnReadMsgCoun, but mmcore not ready");
      return 0;
    }
    String str = s.dUT;
    ArrayList localArrayList = new ArrayList();
    if (!g.DK()) {
      y.w(TAG, "getUnReadTalkerCount, but mmcore not ready");
    }
    for (;;)
    {
      return t.e(str, localArrayList);
      if (!g.DP().Dz().getBoolean(ac.a.uty, true))
      {
        localArrayList.add("notifymessage");
        y.d(TAG, "add service notify message into show unread count blacklist.");
      }
      if (!g.DP().Dz().getBoolean(ac.a.utz, true))
      {
        localArrayList.add("appbrandcustomerservicemsg");
        y.d(TAG, "add wxa custom session notify message into show unread count blacklist.");
      }
    }
  }
  
  public static boolean Ay()
  {
    return ((Boolean)g.DP().Dz().get(73217, Boolean.valueOf(true))).booleanValue();
  }
  
  public static boolean Az()
  {
    return ((Boolean)g.DP().Dz().get(73218, Boolean.valueOf(true))).booleanValue();
  }
  
  public static void aZ(int paramInt1, int paramInt2)
  {
    SharedPreferences localSharedPreferences = ae.cqS();
    localSharedPreferences.edit().putInt("settings_active_begin_time_hour", paramInt1).commit();
    localSharedPreferences.edit().putInt("settings_active_begin_time_min", paramInt2).commit();
    localSharedPreferences = com.tencent.mm.kernel.a.Da();
    localSharedPreferences.edit().putInt("settings_active_begin_time_hour", paramInt1).commit();
    localSharedPreferences.edit().putInt("settings_active_begin_time_min", paramInt2).commit();
    y.i(TAG, "[NOTIFICATION SETTINGS]double write : saveActiveBegine: %d:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public static void bA(boolean paramBoolean)
  {
    ae.cqS().edit().putBoolean("settings_active_time_full", paramBoolean).commit();
    com.tencent.mm.kernel.a.Da().edit().putBoolean("settings_active_time_full", paramBoolean).commit();
    y.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsActiveTime: %B", new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void ba(int paramInt1, int paramInt2)
  {
    SharedPreferences localSharedPreferences = ae.cqS();
    localSharedPreferences.edit().putInt("settings_active_end_time_hour", paramInt1).commit();
    localSharedPreferences.edit().putInt("settings_active_end_time_min", paramInt2).commit();
    localSharedPreferences = com.tencent.mm.kernel.a.Da();
    localSharedPreferences.edit().putInt("settings_active_end_time_hour", paramInt1).commit();
    localSharedPreferences.edit().putInt("settings_active_end_time_min", paramInt2).commit();
    y.i(TAG, "[NOTIFICATION SETTINGS]double write : saveActiveEnd: %d:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public static void bu(boolean paramBoolean)
  {
    ae.cqS().edit().putBoolean("settings_new_msg_notification", paramBoolean).commit();
    com.tencent.mm.kernel.a.Da().edit().putBoolean("settings_new_msg_notification", paramBoolean).commit();
    y.i(TAG, "[NOTIFICATION SETTINGS]double write : saveNewMsgNotification: %B", new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void bv(boolean paramBoolean)
  {
    ae.cqS().edit().putBoolean("settings_new_voip_msg_notification", paramBoolean).commit();
    com.tencent.mm.kernel.a.Da().edit().putBoolean("settings_new_voip_msg_notification", paramBoolean).commit();
    y.i(TAG, "[NOTIFICATION SETTINGS]double write : saveNewVoIPMsgNotification: %B", new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void bw(boolean paramBoolean)
  {
    ae.cqS().edit().putBoolean("settings_show_detail", paramBoolean).commit();
    com.tencent.mm.kernel.a.Da().edit().putBoolean("settings_show_detail", paramBoolean).commit();
    y.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShowDetail: %B", new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void bx(boolean paramBoolean)
  {
    com.tencent.mm.kernel.a.Da().edit().putBoolean("command_notification_status", paramBoolean).commit();
    y.i(TAG, "[NOTIFICATION SETTINGS]is notification by system: %B", new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void by(boolean paramBoolean)
  {
    ae.cqS().edit().putBoolean("settings_sound", paramBoolean).commit();
    com.tencent.mm.kernel.a.Da().edit().putBoolean("settings_sound", paramBoolean).commit();
    y.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsSound: %B", new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static void bz(boolean paramBoolean)
  {
    ae.cqS().edit().putBoolean("settings_shake", paramBoolean).commit();
    com.tencent.mm.kernel.a.Da().edit().putBoolean("settings_shake", paramBoolean).commit();
    y.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShake: %B", new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public static boolean e(bi parambi)
  {
    if (parambi == null) {
      return false;
    }
    return parambi.abY(q.Gj());
  }
  
  public static void fg(String paramString)
  {
    a.fg(paramString);
    y.i(TAG, "[NOTIFICATION SETTINGS]double write : saveSoundTone: %s", new Object[] { paramString });
  }
  
  public static boolean fj(String paramString)
  {
    td localtd = new td();
    localtd.ccJ.bNb = 1;
    localtd.ccJ.content = paramString;
    com.tencent.mm.sdk.b.a.udP.m(localtd);
    return (localtd.ccK.type == 2) || (paramString.equals(bi.uBQ));
  }
  
  public static boolean fk(String paramString)
  {
    td localtd = new td();
    localtd.ccJ.bNb = 1;
    localtd.ccJ.content = paramString;
    com.tencent.mm.sdk.b.a.udP.m(localtd);
    return (localtd.ccK.type == 3) || (paramString.equals(bi.uBP));
  }
  
  public static int fl(String paramString)
  {
    return t.Q(paramString, null);
  }
  
  public static boolean fm(String paramString)
  {
    return ad.hd(paramString);
  }
  
  public static boolean fn(String paramString)
  {
    return s.gZ(paramString);
  }
  
  public static boolean fo(String paramString)
  {
    return (s.hZ(paramString)) || ((s.fn(paramString)) && (!s.hY(paramString))) || ((s.hb(paramString)) && (!s.hY(paramString)));
  }
  
  public static int fp(String paramString)
  {
    return ((j)g.r(j.class)).FB().abL(paramString);
  }
  
  public static void gJ(int paramInt)
  {
    com.tencent.mm.kernel.a.Da().edit().putInt("notification.status.webonline.push.open", paramInt).commit();
  }
  
  public static boolean gK(int paramInt)
  {
    return (paramInt == 50) || (paramInt == 53);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.m.f
 * JD-Core Version:    0.7.0.1
 */