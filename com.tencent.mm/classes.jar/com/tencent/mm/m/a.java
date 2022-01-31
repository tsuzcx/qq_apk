package com.tencent.mm.m;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.media.RingtoneManager;
import android.net.Uri;
import com.tencent.mm.network.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

public class a
{
  public static final String dAe = null;
  private static SharedPreferences dAf = null;
  private static SharedPreferences dAg = null;
  private static String dAh = dAe;
  
  public static int Aa()
  {
    return com.tencent.mm.kernel.a.Da().getInt("settings_active_end_time_min", 0);
  }
  
  public static boolean aY(int paramInt1, int paramInt2)
  {
    if (zW()) {}
    int i;
    int j;
    int k;
    int m;
    do
    {
      do
      {
        do
        {
          return true;
          i = zX();
          j = zZ();
          k = zY();
          m = Aa();
          if ((i == k) && (j == m)) {
            return false;
          }
          if ((i != k) || (j >= m)) {
            break;
          }
        } while ((paramInt1 == i) && (paramInt2 > j) && (paramInt2 < m));
        return false;
        if (k <= i) {
          break;
        }
      } while (((paramInt1 > i) && (paramInt1 < k)) || ((paramInt1 == i) && (paramInt2 > j)) || ((paramInt1 == k) && (paramInt2 < m)));
      return false;
    } while (((k >= i) && ((i != k) || (j <= m))) || ((paramInt1 > i) && (paramInt1 <= 23)) || ((paramInt1 == i) && (paramInt2 > j)) || ((paramInt1 == k) && (paramInt2 < m)) || ((paramInt1 > 0) && (paramInt1 < k)));
    return false;
  }
  
  static void fg(String paramString)
  {
    ae.cqS().edit().putString("settings.ringtone", paramString).commit();
    com.tencent.mm.kernel.a.Da().edit().putString("settings.ringtone", paramString).commit();
  }
  
  public static SharedPreferences zO()
  {
    SharedPreferences localSharedPreferences = aa.Un();
    dAg = localSharedPreferences;
    return localSharedPreferences;
  }
  
  public static boolean zP()
  {
    return com.tencent.mm.kernel.a.Da().getBoolean("command_notification_status", false);
  }
  
  public static boolean zQ()
  {
    return com.tencent.mm.kernel.a.Da().getBoolean("settings_new_msg_notification", true);
  }
  
  public static boolean zR()
  {
    return com.tencent.mm.kernel.a.Da().getBoolean("settings_new_voip_msg_notification", true);
  }
  
  public static boolean zS()
  {
    return com.tencent.mm.kernel.a.Da().getBoolean("settings_show_detail", true);
  }
  
  public static boolean zT()
  {
    return com.tencent.mm.kernel.a.Da().getBoolean("settings_sound", true);
  }
  
  public static String zU()
  {
    String str2 = com.tencent.mm.kernel.a.Da().getString("settings.ringtone", dAe);
    String str1 = str2;
    if (str2 != dAe)
    {
      str1 = str2;
      if (!str2.equals(dAh))
      {
        RingtoneManager localRingtoneManager = new RingtoneManager(ae.getContext());
        localRingtoneManager.setType(2);
        str1 = str2;
        if (localRingtoneManager.getRingtonePosition(Uri.parse(str2)) < 0)
        {
          str1 = dAe;
          fg(str1);
          y.i("MicroMsg.BaseNotificationConfig", "reset ringTone");
        }
        dAh = str1;
      }
    }
    return str1;
  }
  
  public static boolean zV()
  {
    return com.tencent.mm.kernel.a.Da().getBoolean("settings_shake", true);
  }
  
  public static boolean zW()
  {
    return com.tencent.mm.kernel.a.Da().getBoolean("settings_active_time_full", true);
  }
  
  public static int zX()
  {
    return com.tencent.mm.kernel.a.Da().getInt("settings_active_begin_time_hour", 8);
  }
  
  public static int zY()
  {
    return com.tencent.mm.kernel.a.Da().getInt("settings_active_end_time_hour", 23);
  }
  
  public static int zZ()
  {
    return com.tencent.mm.kernel.a.Da().getInt("settings_active_begin_time_min", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.m.a
 * JD-Core Version:    0.7.0.1
 */