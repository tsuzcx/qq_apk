package com.tencent.mm.n;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yb;
import com.tencent.mm.g.a.yb.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class f
  extends a
{
  private static String TAG = "MicroMsg.NotificationConfig";
  
  public static boolean acu()
  {
    AppMethodBeat.i(150012);
    boolean bool = com.tencent.mm.kernel.a.mN(com.tencent.mm.kernel.a.aiH());
    AppMethodBeat.o(150012);
    return bool;
  }
  
  public static boolean acv()
  {
    AppMethodBeat.i(150014);
    boolean bool = u.om(abC().getInt("notification.status.webonline.push.open", 0));
    AppMethodBeat.o(150014);
    return bool;
  }
  
  public static int acw()
  {
    AppMethodBeat.i(150017);
    if (!g.ajx())
    {
      ad.w(TAG, "getUnReadTalkerCount, but mmcore not ready");
      AppMethodBeat.o(150017);
      return 0;
    }
    int i = x.AC(w.hFd).size();
    AppMethodBeat.o(150017);
    return i;
  }
  
  public static int acx()
  {
    AppMethodBeat.i(150019);
    if (!g.ajx())
    {
      ad.w(TAG, "getUnReadMsgCoun, but mmcore not ready");
      AppMethodBeat.o(150019);
      return 0;
    }
    int i = x.AA(w.hFd);
    AppMethodBeat.o(150019);
    return i;
  }
  
  public static boolean acy()
  {
    AppMethodBeat.i(150027);
    boolean bool = ((Boolean)g.ajC().ajl().get(73217, Boolean.TRUE)).booleanValue();
    AppMethodBeat.o(150027);
    return bool;
  }
  
  public static boolean acz()
  {
    AppMethodBeat.i(150028);
    boolean bool = ((Boolean)g.ajC().ajl().get(73218, Boolean.TRUE)).booleanValue();
    AppMethodBeat.o(150028);
    return bool;
  }
  
  public static void cQ(boolean paramBoolean)
  {
    AppMethodBeat.i(149999);
    abC().edit().putBoolean("settings_new_msg_notification", paramBoolean).commit();
    ad.i(TAG, "[NOTIFICATION SETTINGS]double write : saveNewMsgNotification: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(149999);
  }
  
  public static void cR(boolean paramBoolean)
  {
    AppMethodBeat.i(150000);
    abC().edit().putBoolean("settings_new_voip_msg_notification", paramBoolean).commit();
    ad.i(TAG, "[NOTIFICATION SETTINGS]double write : saveNewVoIPMsgNotification: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150000);
  }
  
  public static void cS(boolean paramBoolean)
  {
    AppMethodBeat.i(150001);
    abC().edit().putBoolean("settings_show_detail", paramBoolean).commit();
    ad.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShowDetail: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150001);
  }
  
  public static void cT(boolean paramBoolean)
  {
    AppMethodBeat.i(150002);
    abC().edit().putBoolean("settings_sound", paramBoolean).commit();
    ad.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsSound: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150002);
  }
  
  public static void cU(boolean paramBoolean)
  {
    AppMethodBeat.i(150003);
    abC().edit().putBoolean("settings_shake", paramBoolean).commit();
    ad.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShake: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150003);
  }
  
  public static void cV(boolean paramBoolean)
  {
    AppMethodBeat.i(150005);
    abC().edit().putBoolean("settings_special_scene_sound", paramBoolean).commit();
    ad.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsSoundInSpecialScene: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150005);
  }
  
  public static void cW(boolean paramBoolean)
  {
    AppMethodBeat.i(150006);
    abC().edit().putBoolean("settings_special_scene_shake", paramBoolean).commit();
    ad.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShakeInSpecialScene: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150006);
  }
  
  public static void cX(boolean paramBoolean)
  {
    AppMethodBeat.i(150007);
    abC().edit().putBoolean("settings_voip_scene_sound", paramBoolean).commit();
    ad.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsSoundInVoip: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150007);
  }
  
  public static void cY(boolean paramBoolean)
  {
    AppMethodBeat.i(150008);
    abC().edit().putBoolean("settings_voip_scene_shake", paramBoolean).commit();
    ad.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShakeInVoip: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150008);
  }
  
  public static void cZ(boolean paramBoolean)
  {
    AppMethodBeat.i(150009);
    abC().edit().putBoolean("settings_active_time_full", paramBoolean).commit();
    ad.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsActiveTime: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150009);
  }
  
  public static void cs(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150010);
    SharedPreferences localSharedPreferences = abC();
    localSharedPreferences.edit().putInt("settings_active_begin_time_hour", paramInt1).commit();
    localSharedPreferences.edit().putInt("settings_active_begin_time_min", paramInt2).commit();
    ad.i(TAG, "[NOTIFICATION SETTINGS]double write : saveActiveBegine: %d:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(150010);
  }
  
  public static void ct(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150011);
    SharedPreferences localSharedPreferences = abC();
    localSharedPreferences.edit().putInt("settings_active_end_time_hour", paramInt1).commit();
    localSharedPreferences.edit().putInt("settings_active_end_time_min", paramInt2).commit();
    ad.i(TAG, "[NOTIFICATION SETTINGS]double write : saveActiveEnd: %d:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(150011);
  }
  
  public static void lD(int paramInt)
  {
    AppMethodBeat.i(150013);
    abC().edit().putInt("notification.status.webonline.push.open", paramInt).commit();
    AppMethodBeat.o(150013);
  }
  
  public static boolean lE(int paramInt)
  {
    return (paramInt == 50) || (paramInt == 53);
  }
  
  public static List<String> lF(int paramInt)
  {
    AppMethodBeat.i(195195);
    ArrayList localArrayList = new ArrayList();
    Map localMap = x.AC(w.hFd);
    Iterator localIterator = localMap.keySet().iterator();
    int i;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      String str = (String)localIterator.next();
      i = paramInt - 1;
      localArrayList.add(((am)localMap.get(str)).adu());
      paramInt = i;
    } while (i != 0);
    AppMethodBeat.o(195195);
    return localArrayList;
  }
  
  public static boolean p(bu parambu)
  {
    AppMethodBeat.i(150026);
    if (parambu == null)
    {
      AppMethodBeat.o(150026);
      return false;
    }
    boolean bool = parambu.aUa(u.aAm());
    AppMethodBeat.o(150026);
    return bool;
  }
  
  public static boolean vB(String paramString)
  {
    AppMethodBeat.i(150015);
    yb localyb = new yb();
    localyb.dMo.dsi = 1;
    localyb.dMo.content = paramString;
    com.tencent.mm.sdk.b.a.IbL.l(localyb);
    if ((localyb.dMp.type == 2) || (paramString.equals(bu.IMe)))
    {
      AppMethodBeat.o(150015);
      return true;
    }
    AppMethodBeat.o(150015);
    return false;
  }
  
  public static boolean vC(String paramString)
  {
    AppMethodBeat.i(150016);
    yb localyb = new yb();
    localyb.dMo.dsi = 1;
    localyb.dMo.content = paramString;
    com.tencent.mm.sdk.b.a.IbL.l(localyb);
    if ((localyb.dMp.type == 3) || (paramString.equals(bu.IMd)))
    {
      AppMethodBeat.o(150016);
      return true;
    }
    AppMethodBeat.o(150016);
    return false;
  }
  
  public static int vD(String paramString)
  {
    AppMethodBeat.i(150021);
    int i = x.aF(paramString, null);
    AppMethodBeat.o(150021);
    return i;
  }
  
  public static boolean vE(String paramString)
  {
    AppMethodBeat.i(150022);
    boolean bool = am.zs(paramString);
    AppMethodBeat.o(150022);
    return bool;
  }
  
  public static boolean vF(String paramString)
  {
    AppMethodBeat.i(150023);
    boolean bool = w.zj(paramString);
    AppMethodBeat.o(150023);
    return bool;
  }
  
  public static boolean vG(String paramString)
  {
    AppMethodBeat.i(150024);
    if ((w.Au(paramString)) || ((w.vF(paramString)) && (!w.At(paramString))) || ((w.zl(paramString)) && (!w.At(paramString))))
    {
      AppMethodBeat.o(150024);
      return true;
    }
    AppMethodBeat.o(150024);
    return false;
  }
  
  public static int vH(String paramString)
  {
    AppMethodBeat.i(150025);
    int i = ((l)g.ab(l.class)).azv().aTO(paramString);
    AppMethodBeat.o(150025);
    return i;
  }
  
  public static void vy(String paramString)
  {
    AppMethodBeat.i(150004);
    a.vy(paramString);
    ad.i(TAG, "[NOTIFICATION SETTINGS]double write : saveSoundTone: %s", new Object[] { paramString });
    AppMethodBeat.o(150004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.n.f
 * JD-Core Version:    0.7.0.1
 */