package com.tencent.mm.m;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xh;
import com.tencent.mm.g.a.xh.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class f
  extends a
{
  private static String TAG = "MicroMsg.NotificationConfig";
  
  public static boolean ZS()
  {
    AppMethodBeat.i(150012);
    boolean bool = com.tencent.mm.kernel.a.mo(com.tencent.mm.kernel.a.afV());
    AppMethodBeat.o(150012);
    return bool;
  }
  
  public static boolean ZT()
  {
    AppMethodBeat.i(150014);
    boolean bool = u.nM(Zc().getInt("notification.status.webonline.push.open", 0));
    AppMethodBeat.o(150014);
    return bool;
  }
  
  public static int ZU()
  {
    AppMethodBeat.i(150017);
    if (!g.agM())
    {
      ac.w(TAG, "getUnReadTalkerCount, but mmcore not ready");
      AppMethodBeat.o(150017);
      return 0;
    }
    int i = x.xE(w.hmN).size();
    AppMethodBeat.o(150017);
    return i;
  }
  
  public static int ZV()
  {
    AppMethodBeat.i(150019);
    if (!g.agM())
    {
      ac.w(TAG, "getUnReadMsgCoun, but mmcore not ready");
      AppMethodBeat.o(150019);
      return 0;
    }
    int i = x.xC(w.hmN);
    AppMethodBeat.o(150019);
    return i;
  }
  
  public static boolean ZW()
  {
    AppMethodBeat.i(150027);
    boolean bool = ((Boolean)g.agR().agA().get(73217, Boolean.TRUE)).booleanValue();
    AppMethodBeat.o(150027);
    return bool;
  }
  
  public static boolean ZX()
  {
    AppMethodBeat.i(150028);
    boolean bool = ((Boolean)g.agR().agA().get(73218, Boolean.TRUE)).booleanValue();
    AppMethodBeat.o(150028);
    return bool;
  }
  
  public static void cO(boolean paramBoolean)
  {
    AppMethodBeat.i(149999);
    Zc().edit().putBoolean("settings_new_msg_notification", paramBoolean).commit();
    ac.i(TAG, "[NOTIFICATION SETTINGS]double write : saveNewMsgNotification: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(149999);
  }
  
  public static void cP(boolean paramBoolean)
  {
    AppMethodBeat.i(150000);
    Zc().edit().putBoolean("settings_new_voip_msg_notification", paramBoolean).commit();
    ac.i(TAG, "[NOTIFICATION SETTINGS]double write : saveNewVoIPMsgNotification: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150000);
  }
  
  public static void cQ(boolean paramBoolean)
  {
    AppMethodBeat.i(150001);
    Zc().edit().putBoolean("settings_show_detail", paramBoolean).commit();
    ac.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShowDetail: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150001);
  }
  
  public static void cR(boolean paramBoolean)
  {
    AppMethodBeat.i(150002);
    Zc().edit().putBoolean("settings_sound", paramBoolean).commit();
    ac.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsSound: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150002);
  }
  
  public static void cS(boolean paramBoolean)
  {
    AppMethodBeat.i(150003);
    Zc().edit().putBoolean("settings_shake", paramBoolean).commit();
    ac.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShake: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150003);
  }
  
  public static void cT(boolean paramBoolean)
  {
    AppMethodBeat.i(150005);
    Zc().edit().putBoolean("settings_special_scene_sound", paramBoolean).commit();
    ac.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsSoundInSpecialScene: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150005);
  }
  
  public static void cU(boolean paramBoolean)
  {
    AppMethodBeat.i(150006);
    Zc().edit().putBoolean("settings_special_scene_shake", paramBoolean).commit();
    ac.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShakeInSpecialScene: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150006);
  }
  
  public static void cV(boolean paramBoolean)
  {
    AppMethodBeat.i(150007);
    Zc().edit().putBoolean("settings_voip_scene_sound", paramBoolean).commit();
    ac.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsSoundInVoip: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150007);
  }
  
  public static void cW(boolean paramBoolean)
  {
    AppMethodBeat.i(150008);
    Zc().edit().putBoolean("settings_voip_scene_shake", paramBoolean).commit();
    ac.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShakeInVoip: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150008);
  }
  
  public static void cX(boolean paramBoolean)
  {
    AppMethodBeat.i(150009);
    Zc().edit().putBoolean("settings_active_time_full", paramBoolean).commit();
    ac.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsActiveTime: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150009);
  }
  
  public static void cq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150010);
    SharedPreferences localSharedPreferences = Zc();
    localSharedPreferences.edit().putInt("settings_active_begin_time_hour", paramInt1).commit();
    localSharedPreferences.edit().putInt("settings_active_begin_time_min", paramInt2).commit();
    ac.i(TAG, "[NOTIFICATION SETTINGS]double write : saveActiveBegine: %d:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(150010);
  }
  
  public static void cr(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150011);
    SharedPreferences localSharedPreferences = Zc();
    localSharedPreferences.edit().putInt("settings_active_end_time_hour", paramInt1).commit();
    localSharedPreferences.edit().putInt("settings_active_end_time_min", paramInt2).commit();
    ac.i(TAG, "[NOTIFICATION SETTINGS]double write : saveActiveEnd: %d:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(150011);
  }
  
  public static void le(int paramInt)
  {
    AppMethodBeat.i(150013);
    Zc().edit().putInt("notification.status.webonline.push.open", paramInt).commit();
    AppMethodBeat.o(150013);
  }
  
  public static boolean lf(int paramInt)
  {
    return (paramInt == 50) || (paramInt == 53);
  }
  
  public static List<String> lg(int paramInt)
  {
    AppMethodBeat.i(192591);
    ArrayList localArrayList = new ArrayList();
    Map localMap = x.xE(w.hmN);
    Iterator localIterator = localMap.keySet().iterator();
    int i;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      String str = (String)localIterator.next();
      i = paramInt - 1;
      localArrayList.add(((ai)localMap.get(str)).aaR());
      paramInt = i;
    } while (i != 0);
    AppMethodBeat.o(192591);
    return localArrayList;
  }
  
  public static boolean p(bo parambo)
  {
    AppMethodBeat.i(150026);
    if (parambo == null)
    {
      AppMethodBeat.o(150026);
      return false;
    }
    boolean bool = parambo.aOj(u.axw());
    AppMethodBeat.o(150026);
    return bool;
  }
  
  public static void sJ(String paramString)
  {
    AppMethodBeat.i(150004);
    a.sJ(paramString);
    ac.i(TAG, "[NOTIFICATION SETTINGS]double write : saveSoundTone: %s", new Object[] { paramString });
    AppMethodBeat.o(150004);
  }
  
  public static boolean sM(String paramString)
  {
    AppMethodBeat.i(150015);
    xh localxh = new xh();
    localxh.dAb.dgL = 1;
    localxh.dAb.content = paramString;
    com.tencent.mm.sdk.b.a.GpY.l(localxh);
    if ((localxh.dAc.type == 2) || (paramString.equals(bo.GYP)))
    {
      AppMethodBeat.o(150015);
      return true;
    }
    AppMethodBeat.o(150015);
    return false;
  }
  
  public static boolean sN(String paramString)
  {
    AppMethodBeat.i(150016);
    xh localxh = new xh();
    localxh.dAb.dgL = 1;
    localxh.dAb.content = paramString;
    com.tencent.mm.sdk.b.a.GpY.l(localxh);
    if ((localxh.dAc.type == 3) || (paramString.equals(bo.GYO)))
    {
      AppMethodBeat.o(150016);
      return true;
    }
    AppMethodBeat.o(150016);
    return false;
  }
  
  public static int sO(String paramString)
  {
    AppMethodBeat.i(150021);
    int i = x.aD(paramString, null);
    AppMethodBeat.o(150021);
    return i;
  }
  
  public static boolean sP(String paramString)
  {
    AppMethodBeat.i(150022);
    boolean bool = ai.ww(paramString);
    AppMethodBeat.o(150022);
    return bool;
  }
  
  public static boolean sQ(String paramString)
  {
    AppMethodBeat.i(150023);
    boolean bool = w.wo(paramString);
    AppMethodBeat.o(150023);
    return bool;
  }
  
  public static boolean sR(String paramString)
  {
    AppMethodBeat.i(150024);
    if ((w.xw(paramString)) || ((w.sQ(paramString)) && (!w.xv(paramString))) || ((w.wq(paramString)) && (!w.xv(paramString))))
    {
      AppMethodBeat.o(150024);
      return true;
    }
    AppMethodBeat.o(150024);
    return false;
  }
  
  public static int sS(String paramString)
  {
    AppMethodBeat.i(150025);
    int i = ((k)g.ab(k.class)).awG().aNX(paramString);
    AppMethodBeat.o(150025);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.m.f
 * JD-Core Version:    0.7.0.1
 */