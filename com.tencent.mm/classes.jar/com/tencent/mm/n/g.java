package com.tencent.mm.n;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.aaq;
import com.tencent.mm.f.a.aaq.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.n;
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
  
  public static void Lc(String paramString)
  {
    AppMethodBeat.i(150004);
    b.Lc(paramString);
    Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveSoundTone: %s", new Object[] { paramString });
    AppMethodBeat.o(150004);
  }
  
  public static boolean Lf(String paramString)
  {
    AppMethodBeat.i(150015);
    aaq localaaq = new aaq();
    localaaq.fZM.fDn = 1;
    localaaq.fZM.content = paramString;
    EventCenter.instance.publish(localaaq);
    if ((localaaq.fZN.type == 2) || (paramString.equals(ca.VGy)))
    {
      AppMethodBeat.o(150015);
      return true;
    }
    AppMethodBeat.o(150015);
    return false;
  }
  
  public static boolean Lg(String paramString)
  {
    AppMethodBeat.i(150016);
    aaq localaaq = new aaq();
    localaaq.fZM.fDn = 1;
    localaaq.fZM.content = paramString;
    EventCenter.instance.publish(localaaq);
    if ((localaaq.fZN.type == 3) || (paramString.equals(ca.VGx)))
    {
      AppMethodBeat.o(150016);
      return true;
    }
    AppMethodBeat.o(150016);
    return false;
  }
  
  public static int Lh(String paramString)
  {
    AppMethodBeat.i(150021);
    int i = ac.aM(paramString, null);
    AppMethodBeat.o(150021);
    return i;
  }
  
  public static boolean Li(String paramString)
  {
    AppMethodBeat.i(150022);
    boolean bool = as.PY(paramString);
    AppMethodBeat.o(150022);
    return bool;
  }
  
  public static boolean Lj(String paramString)
  {
    AppMethodBeat.i(150023);
    boolean bool = ab.PO(paramString);
    AppMethodBeat.o(150023);
    return bool;
  }
  
  public static boolean Lk(String paramString)
  {
    AppMethodBeat.i(150024);
    if ((ab.Rc(paramString)) || ((ab.Lj(paramString)) && (!ab.Rb(paramString))) || ((ab.PQ(paramString)) && (!ab.Rb(paramString))))
    {
      AppMethodBeat.o(150024);
      return true;
    }
    AppMethodBeat.o(150024);
    return false;
  }
  
  public static int Ll(String paramString)
  {
    AppMethodBeat.i(150025);
    int i = ((n)h.ae(n.class)).bbR().bwM(paramString);
    AppMethodBeat.o(150025);
    return i;
  }
  
  public static boolean awW()
  {
    AppMethodBeat.i(150012);
    boolean bool = com.tencent.mm.kernel.b.sC(com.tencent.mm.kernel.b.aGJ());
    AppMethodBeat.o(150012);
    return bool;
  }
  
  public static boolean awX()
  {
    AppMethodBeat.i(150014);
    boolean bool = z.uJ(awd().getInt("notification.status.webonline.push.open", 0));
    AppMethodBeat.o(150014);
    return bool;
  }
  
  public static int awY()
  {
    AppMethodBeat.i(150017);
    if (!h.aHB())
    {
      Log.w(TAG, "getUnReadTalkerCount, but mmcore not ready");
      AppMethodBeat.o(150017);
      return 0;
    }
    int i = ac.Rj(ab.lsA).size();
    AppMethodBeat.o(150017);
    return i;
  }
  
  public static int awZ()
  {
    AppMethodBeat.i(150019);
    if (!h.aHB())
    {
      Log.w(TAG, "getUnReadMsgCoun, but mmcore not ready");
      AppMethodBeat.o(150019);
      return 0;
    }
    int i = ac.uM(1);
    AppMethodBeat.o(150019);
    return i;
  }
  
  public static boolean axa()
  {
    AppMethodBeat.i(150027);
    boolean bool = ((Boolean)h.aHG().aHp().b(73217, Boolean.TRUE)).booleanValue();
    AppMethodBeat.o(150027);
    return bool;
  }
  
  public static boolean axb()
  {
    AppMethodBeat.i(150028);
    boolean bool = ((Boolean)h.aHG().aHp().b(73218, Boolean.TRUE)).booleanValue();
    AppMethodBeat.o(150028);
    return bool;
  }
  
  public static void cM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150010);
    SharedPreferences localSharedPreferences = awd();
    localSharedPreferences.edit().putInt("settings_active_begin_time_hour", paramInt1).commit();
    localSharedPreferences.edit().putInt("settings_active_begin_time_min", paramInt2).commit();
    Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveActiveBegine: %d:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(150010);
  }
  
  public static void cN(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150011);
    SharedPreferences localSharedPreferences = awd();
    localSharedPreferences.edit().putInt("settings_active_end_time_hour", paramInt1).commit();
    localSharedPreferences.edit().putInt("settings_active_end_time_min", paramInt2).commit();
    Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveActiveEnd: %d:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(150011);
  }
  
  public static void ea(boolean paramBoolean)
  {
    AppMethodBeat.i(149999);
    awd().edit().putBoolean("settings_new_msg_notification", paramBoolean).commit();
    Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveNewMsgNotification: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(149999);
  }
  
  public static void eb(boolean paramBoolean)
  {
    AppMethodBeat.i(150000);
    awd().edit().putBoolean("settings_new_voip_msg_notification", paramBoolean).commit();
    Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveNewVoIPMsgNotification: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150000);
  }
  
  public static void ec(boolean paramBoolean)
  {
    AppMethodBeat.i(150001);
    awd().edit().putBoolean("settings_show_detail", paramBoolean).commit();
    Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShowDetail: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150001);
  }
  
  public static void ed(boolean paramBoolean)
  {
    AppMethodBeat.i(150002);
    awd().edit().putBoolean("settings_sound", paramBoolean).commit();
    Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsSound: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150002);
  }
  
  public static void ee(boolean paramBoolean)
  {
    AppMethodBeat.i(150003);
    awd().edit().putBoolean("settings_shake", paramBoolean).commit();
    Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShake: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150003);
  }
  
  public static void ef(boolean paramBoolean)
  {
    AppMethodBeat.i(150005);
    awd().edit().putBoolean("settings_special_scene_sound", paramBoolean).commit();
    Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsSoundInSpecialScene: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150005);
  }
  
  public static void eg(boolean paramBoolean)
  {
    AppMethodBeat.i(150006);
    awd().edit().putBoolean("settings_special_scene_shake", paramBoolean).commit();
    Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShakeInSpecialScene: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150006);
  }
  
  public static void eh(boolean paramBoolean)
  {
    AppMethodBeat.i(150007);
    awd().edit().putBoolean("settings_voip_scene_sound", paramBoolean).commit();
    Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsSoundInVoip: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150007);
  }
  
  public static void ei(boolean paramBoolean)
  {
    AppMethodBeat.i(150008);
    awd().edit().putBoolean("settings_voip_scene_shake", paramBoolean).commit();
    Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShakeInVoip: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150008);
  }
  
  public static void ej(boolean paramBoolean)
  {
    AppMethodBeat.i(150009);
    awd().edit().putBoolean("settings_active_time_full", paramBoolean).commit();
    Log.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsActiveTime: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150009);
  }
  
  public static boolean p(ca paramca)
  {
    AppMethodBeat.i(150026);
    if (paramca == null)
    {
      AppMethodBeat.o(150026);
      return false;
    }
    boolean bool = paramca.bwY(z.bcZ());
    AppMethodBeat.o(150026);
    return bool;
  }
  
  public static void rb(int paramInt)
  {
    AppMethodBeat.i(150013);
    awd().edit().putInt("notification.status.webonline.push.open", paramInt).commit();
    AppMethodBeat.o(150013);
  }
  
  public static boolean rc(int paramInt)
  {
    return (paramInt == 50) || (paramInt == 53);
  }
  
  public static List<String> rd(int paramInt)
  {
    AppMethodBeat.i(222143);
    ArrayList localArrayList = new ArrayList();
    Map localMap = ac.Rj(ab.lsA);
    Iterator localIterator = localMap.keySet().iterator();
    int i;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      String str = (String)localIterator.next();
      i = paramInt - 1;
      localArrayList.add(((as)localMap.get(str)).ayr());
      paramInt = i;
    } while (i != 0);
    AppMethodBeat.o(222143);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.n.g
 * JD-Core Version:    0.7.0.1
 */