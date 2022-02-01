package com.tencent.mm.k;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.acn;
import com.tencent.mm.autogen.a.acn.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class h
  extends b
{
  private static String TAG = "MicroMsg.NotificationConfig";
  
  public static void DJ(String paramString)
  {
    AppMethodBeat.i(150004);
    b.DJ(paramString);
    Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveSoundTone: %s", new Object[] { paramString });
    AppMethodBeat.o(150004);
  }
  
  public static boolean DM(String paramString)
  {
    AppMethodBeat.i(150015);
    acn localacn = new acn();
    localacn.ifU.hId = 1;
    localacn.ifU.content = paramString;
    localacn.publish();
    if ((localacn.ifV.type == 2) || (paramString.equals(cc.adkp)))
    {
      AppMethodBeat.o(150015);
      return true;
    }
    AppMethodBeat.o(150015);
    return false;
  }
  
  public static boolean DN(String paramString)
  {
    AppMethodBeat.i(150016);
    acn localacn = new acn();
    localacn.ifU.hId = 1;
    localacn.ifU.content = paramString;
    localacn.publish();
    if ((localacn.ifV.type == 3) || (paramString.equals(cc.adko)))
    {
      AppMethodBeat.o(150016);
      return true;
    }
    AppMethodBeat.o(150016);
    return false;
  }
  
  public static int DO(String paramString)
  {
    AppMethodBeat.i(150021);
    int i = ac.b(paramString, null);
    AppMethodBeat.o(150021);
    return i;
  }
  
  public static boolean DP(String paramString)
  {
    AppMethodBeat.i(150022);
    boolean bool = au.bwS(paramString);
    AppMethodBeat.o(150022);
    return bool;
  }
  
  public static boolean DQ(String paramString)
  {
    AppMethodBeat.i(150023);
    boolean bool = au.bwE(paramString);
    AppMethodBeat.o(150023);
    return bool;
  }
  
  public static boolean DR(String paramString)
  {
    AppMethodBeat.i(150024);
    if ((ab.Ja(paramString)) || ((au.bwE(paramString)) && (!ab.IZ(paramString))) || ((au.bwF(paramString)) && (!ab.IZ(paramString))))
    {
      AppMethodBeat.o(150024);
      return true;
    }
    AppMethodBeat.o(150024);
    return false;
  }
  
  public static int DS(String paramString)
  {
    AppMethodBeat.i(150025);
    int i = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG().byf(paramString);
    AppMethodBeat.o(150025);
    return i;
  }
  
  public static boolean aRA()
  {
    AppMethodBeat.i(150027);
    boolean bool = ((Boolean)com.tencent.mm.kernel.h.baE().ban().d(73217, Boolean.TRUE)).booleanValue();
    AppMethodBeat.o(150027);
    return bool;
  }
  
  public static boolean aRB()
  {
    AppMethodBeat.i(150028);
    boolean bool = ((Boolean)com.tencent.mm.kernel.h.baE().ban().d(73218, Boolean.TRUE)).booleanValue();
    AppMethodBeat.o(150028);
    return bool;
  }
  
  public static boolean aRw()
  {
    AppMethodBeat.i(150012);
    boolean bool = com.tencent.mm.kernel.b.sy(com.tencent.mm.kernel.b.aZL());
    AppMethodBeat.o(150012);
    return bool;
  }
  
  public static boolean aRx()
  {
    AppMethodBeat.i(150014);
    boolean bool = z.uW(aQC().getInt("notification.status.webonline.push.open", 0));
    AppMethodBeat.o(150014);
    return bool;
  }
  
  public static int aRy()
  {
    AppMethodBeat.i(150017);
    if (!com.tencent.mm.kernel.h.baz())
    {
      Log.w(TAG, "getUnReadTalkerCount, but mmcore not ready");
      AppMethodBeat.o(150017);
      return 0;
    }
    int i = ac.Jh(ab.ojZ).size();
    AppMethodBeat.o(150017);
    return i;
  }
  
  public static int aRz()
  {
    AppMethodBeat.i(150019);
    if (!com.tencent.mm.kernel.h.baz())
    {
      Log.w(TAG, "getUnReadMsgCoun, but mmcore not ready");
      AppMethodBeat.o(150019);
      return 0;
    }
    int i = ac.bBY();
    AppMethodBeat.o(150019);
    return i;
  }
  
  public static void dC(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150010);
    SharedPreferences localSharedPreferences = aQC();
    localSharedPreferences.edit().putInt("settings_active_begin_time_hour", paramInt1).commit();
    localSharedPreferences.edit().putInt("settings_active_begin_time_min", paramInt2).commit();
    Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveActiveBegine: %d:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(150010);
  }
  
  public static void dD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150011);
    SharedPreferences localSharedPreferences = aQC();
    localSharedPreferences.edit().putInt("settings_active_end_time_hour", paramInt1).commit();
    localSharedPreferences.edit().putInt("settings_active_end_time_min", paramInt2).commit();
    Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveActiveEnd: %d:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(150011);
  }
  
  public static void eM(boolean paramBoolean)
  {
    AppMethodBeat.i(149999);
    aQC().edit().putBoolean("settings_new_msg_notification", paramBoolean).commit();
    Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveNewMsgNotification: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(149999);
  }
  
  public static void eN(boolean paramBoolean)
  {
    AppMethodBeat.i(150000);
    aQC().edit().putBoolean("settings_new_voip_msg_notification", paramBoolean).commit();
    Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveNewVoIPMsgNotification: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150000);
  }
  
  public static void eO(boolean paramBoolean)
  {
    AppMethodBeat.i(150001);
    aQC().edit().putBoolean("settings_show_detail", paramBoolean).commit();
    Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShowDetail: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150001);
  }
  
  public static void eP(boolean paramBoolean)
  {
    AppMethodBeat.i(150002);
    aQC().edit().putBoolean("settings_sound", paramBoolean).commit();
    Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsSound: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150002);
  }
  
  public static void eQ(boolean paramBoolean)
  {
    AppMethodBeat.i(231806);
    aQC().edit().putBoolean("settings_ringtone_allow_hear", paramBoolean).commit();
    Log.i(TAG, "[NOTIFICATION SETTINGS]double write : KEY_RINGTONE_CAN_HEAR: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(231806);
  }
  
  public static void eR(boolean paramBoolean)
  {
    AppMethodBeat.i(150003);
    aQC().edit().putBoolean("settings_shake", paramBoolean).commit();
    Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShake: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150003);
  }
  
  public static void eS(boolean paramBoolean)
  {
    AppMethodBeat.i(150005);
    aQC().edit().putBoolean("settings_special_scene_sound", paramBoolean).commit();
    Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsSoundInSpecialScene: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150005);
  }
  
  public static void eT(boolean paramBoolean)
  {
    AppMethodBeat.i(150006);
    aQC().edit().putBoolean("settings_special_scene_shake", paramBoolean).commit();
    Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShakeInSpecialScene: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150006);
  }
  
  public static void eU(boolean paramBoolean)
  {
    AppMethodBeat.i(150007);
    aQC().edit().putBoolean("settings_voip_scene_sound", paramBoolean).commit();
    Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsSoundInVoip: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150007);
  }
  
  public static void eV(boolean paramBoolean)
  {
    AppMethodBeat.i(150008);
    aQC().edit().putBoolean("settings_voip_scene_shake", paramBoolean).commit();
    Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShakeInVoip: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150008);
  }
  
  public static void eW(boolean paramBoolean)
  {
    AppMethodBeat.i(150009);
    aQC().edit().putBoolean("settings_active_time_full", paramBoolean).commit();
    Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsActiveTime: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150009);
  }
  
  public static boolean p(cc paramcc)
  {
    AppMethodBeat.i(150026);
    if (paramcc == null)
    {
      AppMethodBeat.o(150026);
      return false;
    }
    boolean bool = paramcc.byr(z.bAM());
    AppMethodBeat.o(150026);
    return bool;
  }
  
  public static void rj(int paramInt)
  {
    AppMethodBeat.i(150013);
    aQC().edit().putInt("notification.status.webonline.push.open", paramInt).commit();
    AppMethodBeat.o(150013);
  }
  
  public static boolean rk(int paramInt)
  {
    return (paramInt == 50) || (paramInt == 53);
  }
  
  public static List<String> rl(int paramInt)
  {
    AppMethodBeat.i(231849);
    ArrayList localArrayList = new ArrayList();
    Map localMap = ac.Jh(ab.ojZ);
    Iterator localIterator = localMap.keySet().iterator();
    int i;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      String str = (String)localIterator.next();
      i = paramInt - 1;
      localArrayList.add(((au)localMap.get(str)).aSU());
      paramInt = i;
    } while (i != 0);
    AppMethodBeat.o(231849);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.k.h
 * JD-Core Version:    0.7.0.1
 */