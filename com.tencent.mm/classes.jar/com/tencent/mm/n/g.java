package com.tencent.mm.n;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.g.a.zj.b;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class g
  extends b
{
  private static String TAG = "MicroMsg.NotificationConfig";
  
  public static void Ej(String paramString)
  {
    AppMethodBeat.i(150004);
    b.Ej(paramString);
    Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveSoundTone: %s", new Object[] { paramString });
    AppMethodBeat.o(150004);
  }
  
  public static boolean Em(String paramString)
  {
    AppMethodBeat.i(150015);
    zj localzj = new zj();
    localzj.efx.dKy = 1;
    localzj.efx.content = paramString;
    EventCenter.instance.publish(localzj);
    if ((localzj.efy.type == 2) || (paramString.equals(ca.OqC)))
    {
      AppMethodBeat.o(150015);
      return true;
    }
    AppMethodBeat.o(150015);
    return false;
  }
  
  public static boolean En(String paramString)
  {
    AppMethodBeat.i(150016);
    zj localzj = new zj();
    localzj.efx.dKy = 1;
    localzj.efx.content = paramString;
    EventCenter.instance.publish(localzj);
    if ((localzj.efy.type == 3) || (paramString.equals(ca.OqB)))
    {
      AppMethodBeat.o(150016);
      return true;
    }
    AppMethodBeat.o(150016);
    return false;
  }
  
  public static int Eo(String paramString)
  {
    AppMethodBeat.i(150021);
    int i = ac.aI(paramString, null);
    AppMethodBeat.o(150021);
    return i;
  }
  
  public static boolean Ep(String paramString)
  {
    AppMethodBeat.i(150022);
    boolean bool = as.IG(paramString);
    AppMethodBeat.o(150022);
    return bool;
  }
  
  public static boolean Eq(String paramString)
  {
    AppMethodBeat.i(150023);
    boolean bool = ab.Iw(paramString);
    AppMethodBeat.o(150023);
    return bool;
  }
  
  public static boolean Er(String paramString)
  {
    AppMethodBeat.i(150024);
    if ((ab.JJ(paramString)) || ((ab.Eq(paramString)) && (!ab.JI(paramString))) || ((ab.Iy(paramString)) && (!ab.JI(paramString))))
    {
      AppMethodBeat.o(150024);
      return true;
    }
    AppMethodBeat.o(150024);
    return false;
  }
  
  public static int Es(String paramString)
  {
    AppMethodBeat.i(150025);
    int i = ((l)com.tencent.mm.kernel.g.af(l.class)).aST().bkn(paramString);
    AppMethodBeat.o(150025);
    return i;
  }
  
  public static boolean aqD()
  {
    AppMethodBeat.i(150012);
    boolean bool = a.qd(a.azm());
    AppMethodBeat.o(150012);
    return bool;
  }
  
  public static boolean aqE()
  {
    AppMethodBeat.i(150014);
    boolean bool = z.rP(apK().getInt("notification.status.webonline.push.open", 0));
    AppMethodBeat.o(150014);
    return bool;
  }
  
  public static int aqF()
  {
    AppMethodBeat.i(150017);
    if (!com.tencent.mm.kernel.g.aAc())
    {
      Log.w(TAG, "getUnReadTalkerCount, but mmcore not ready");
      AppMethodBeat.o(150017);
      return 0;
    }
    int i = ac.JR(ab.iCF).size();
    AppMethodBeat.o(150017);
    return i;
  }
  
  public static int aqG()
  {
    AppMethodBeat.i(150019);
    if (!com.tencent.mm.kernel.g.aAc())
    {
      Log.w(TAG, "getUnReadMsgCoun, but mmcore not ready");
      AppMethodBeat.o(150019);
      return 0;
    }
    int i = ac.JP(ab.iCF);
    AppMethodBeat.o(150019);
    return i;
  }
  
  public static boolean aqH()
  {
    AppMethodBeat.i(150027);
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.aAh().azQ().get(73217, Boolean.TRUE)).booleanValue();
    AppMethodBeat.o(150027);
    return bool;
  }
  
  public static boolean aqI()
  {
    AppMethodBeat.i(150028);
    boolean bool = ((Boolean)com.tencent.mm.kernel.g.aAh().azQ().get(73218, Boolean.TRUE)).booleanValue();
    AppMethodBeat.o(150028);
    return bool;
  }
  
  public static void cu(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150010);
    SharedPreferences localSharedPreferences = apK();
    localSharedPreferences.edit().putInt("settings_active_begin_time_hour", paramInt1).commit();
    localSharedPreferences.edit().putInt("settings_active_begin_time_min", paramInt2).commit();
    Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveActiveBegine: %d:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(150010);
  }
  
  public static void cv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150011);
    SharedPreferences localSharedPreferences = apK();
    localSharedPreferences.edit().putInt("settings_active_end_time_hour", paramInt1).commit();
    localSharedPreferences.edit().putInt("settings_active_end_time_min", paramInt2).commit();
    Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveActiveEnd: %d:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(150011);
  }
  
  public static void dA(boolean paramBoolean)
  {
    AppMethodBeat.i(149999);
    apK().edit().putBoolean("settings_new_msg_notification", paramBoolean).commit();
    Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveNewMsgNotification: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(149999);
  }
  
  public static void dB(boolean paramBoolean)
  {
    AppMethodBeat.i(150000);
    apK().edit().putBoolean("settings_new_voip_msg_notification", paramBoolean).commit();
    Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveNewVoIPMsgNotification: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150000);
  }
  
  public static void dC(boolean paramBoolean)
  {
    AppMethodBeat.i(150001);
    apK().edit().putBoolean("settings_show_detail", paramBoolean).commit();
    Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShowDetail: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150001);
  }
  
  public static void dD(boolean paramBoolean)
  {
    AppMethodBeat.i(150002);
    apK().edit().putBoolean("settings_sound", paramBoolean).commit();
    Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsSound: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150002);
  }
  
  public static void dE(boolean paramBoolean)
  {
    AppMethodBeat.i(150003);
    apK().edit().putBoolean("settings_shake", paramBoolean).commit();
    Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShake: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150003);
  }
  
  public static void dF(boolean paramBoolean)
  {
    AppMethodBeat.i(150005);
    apK().edit().putBoolean("settings_special_scene_sound", paramBoolean).commit();
    Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsSoundInSpecialScene: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150005);
  }
  
  public static void dG(boolean paramBoolean)
  {
    AppMethodBeat.i(150006);
    apK().edit().putBoolean("settings_special_scene_shake", paramBoolean).commit();
    Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShakeInSpecialScene: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150006);
  }
  
  public static void dH(boolean paramBoolean)
  {
    AppMethodBeat.i(150007);
    apK().edit().putBoolean("settings_voip_scene_sound", paramBoolean).commit();
    Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsSoundInVoip: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150007);
  }
  
  public static void dI(boolean paramBoolean)
  {
    AppMethodBeat.i(150008);
    apK().edit().putBoolean("settings_voip_scene_shake", paramBoolean).commit();
    Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShakeInVoip: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150008);
  }
  
  public static void dJ(boolean paramBoolean)
  {
    AppMethodBeat.i(150009);
    apK().edit().putBoolean("settings_active_time_full", paramBoolean).commit();
    Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsActiveTime: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150009);
  }
  
  public static void oI(int paramInt)
  {
    AppMethodBeat.i(150013);
    apK().edit().putInt("notification.status.webonline.push.open", paramInt).commit();
    AppMethodBeat.o(150013);
  }
  
  public static boolean oJ(int paramInt)
  {
    return (paramInt == 50) || (paramInt == 53);
  }
  
  public static List<String> oK(int paramInt)
  {
    AppMethodBeat.i(223500);
    ArrayList localArrayList = new ArrayList();
    Map localMap = ac.JR(ab.iCF);
    Iterator localIterator = localMap.keySet().iterator();
    int i;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      String str = (String)localIterator.next();
      i = paramInt - 1;
      localArrayList.add(((as)localMap.get(str)).arI());
      paramInt = i;
    } while (i != 0);
    AppMethodBeat.o(223500);
    return localArrayList;
  }
  
  public static boolean p(ca paramca)
  {
    AppMethodBeat.i(150026);
    if (paramca == null)
    {
      AppMethodBeat.o(150026);
      return false;
    }
    boolean bool = paramca.bkz(z.aTY());
    AppMethodBeat.o(150026);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.n.g
 * JD-Core Version:    0.7.0.1
 */