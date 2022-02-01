package com.tencent.mm.m;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ww;
import com.tencent.mm.g.a.ww.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bl;
import java.util.ArrayList;
import java.util.List;

public final class f
  extends a
{
  private static String TAG = "MicroMsg.NotificationConfig";
  
  public static boolean YV()
  {
    AppMethodBeat.i(150012);
    boolean bool = com.tencent.mm.kernel.a.mp(com.tencent.mm.kernel.a.aeF());
    AppMethodBeat.o(150012);
    return bool;
  }
  
  public static boolean YW()
  {
    AppMethodBeat.i(150014);
    boolean bool = u.mY(Yf().getInt("notification.status.webonline.push.open", 0));
    AppMethodBeat.o(150014);
    return bool;
  }
  
  public static int YX()
  {
    AppMethodBeat.i(150017);
    if (!g.afw())
    {
      ad.w(TAG, "getUnReadTalkerCount, but mmcore not ready");
      AppMethodBeat.o(150017);
      return 0;
    }
    int i = x.e(w.gMn, Za());
    AppMethodBeat.o(150017);
    return i;
  }
  
  public static List<String> YY()
  {
    AppMethodBeat.i(150018);
    List localList = x.X(w.gMn, -1);
    AppMethodBeat.o(150018);
    return localList;
  }
  
  public static int YZ()
  {
    AppMethodBeat.i(150019);
    if (!g.afw())
    {
      ad.w(TAG, "getUnReadMsgCoun, but mmcore not ready");
      AppMethodBeat.o(150019);
      return 0;
    }
    int i = x.d(w.gMn, Za());
    AppMethodBeat.o(150019);
    return i;
  }
  
  private static List<String> Za()
  {
    AppMethodBeat.i(150020);
    ArrayList localArrayList = new ArrayList();
    if (!g.afw())
    {
      ad.w(TAG, "getUnReadTalkerCount, but mmcore not ready");
      AppMethodBeat.o(150020);
      return localArrayList;
    }
    if (!g.afB().afk().getBoolean(ae.a.FlZ, true))
    {
      localArrayList.add("notifymessage");
      ad.d(TAG, "add service notify message into show unread count blacklist.");
    }
    if (!g.afB().afk().getBoolean(ae.a.Fma, true))
    {
      localArrayList.add("appbrandcustomerservicemsg");
      ad.d(TAG, "add wxa custom session notify message into show unread count blacklist.");
    }
    localArrayList.add("appbrand_notify_message");
    ad.d(TAG, "add appbrand notify message into show unread count blacklist.");
    AppMethodBeat.o(150020);
    return localArrayList;
  }
  
  public static boolean Zb()
  {
    AppMethodBeat.i(150027);
    boolean bool = ((Boolean)g.afB().afk().get(73217, Boolean.TRUE)).booleanValue();
    AppMethodBeat.o(150027);
    return bool;
  }
  
  public static boolean Zc()
  {
    AppMethodBeat.i(150028);
    boolean bool = ((Boolean)g.afB().afk().get(73218, Boolean.TRUE)).booleanValue();
    AppMethodBeat.o(150028);
    return bool;
  }
  
  public static void cP(boolean paramBoolean)
  {
    AppMethodBeat.i(149999);
    Yf().edit().putBoolean("settings_new_msg_notification", paramBoolean).commit();
    ad.i(TAG, "[NOTIFICATION SETTINGS]double write : saveNewMsgNotification: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(149999);
  }
  
  public static void cQ(boolean paramBoolean)
  {
    AppMethodBeat.i(150000);
    Yf().edit().putBoolean("settings_new_voip_msg_notification", paramBoolean).commit();
    ad.i(TAG, "[NOTIFICATION SETTINGS]double write : saveNewVoIPMsgNotification: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150000);
  }
  
  public static void cR(boolean paramBoolean)
  {
    AppMethodBeat.i(150001);
    Yf().edit().putBoolean("settings_show_detail", paramBoolean).commit();
    ad.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShowDetail: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150001);
  }
  
  public static void cS(boolean paramBoolean)
  {
    AppMethodBeat.i(150002);
    Yf().edit().putBoolean("settings_sound", paramBoolean).commit();
    ad.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsSound: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150002);
  }
  
  public static void cT(boolean paramBoolean)
  {
    AppMethodBeat.i(150003);
    Yf().edit().putBoolean("settings_shake", paramBoolean).commit();
    ad.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShake: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150003);
  }
  
  public static void cU(boolean paramBoolean)
  {
    AppMethodBeat.i(150005);
    Yf().edit().putBoolean("settings_special_scene_sound", paramBoolean).commit();
    ad.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsSoundInSpecialScene: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150005);
  }
  
  public static void cV(boolean paramBoolean)
  {
    AppMethodBeat.i(150006);
    Yf().edit().putBoolean("settings_special_scene_shake", paramBoolean).commit();
    ad.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShakeInSpecialScene: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150006);
  }
  
  public static void cW(boolean paramBoolean)
  {
    AppMethodBeat.i(150007);
    Yf().edit().putBoolean("settings_voip_scene_sound", paramBoolean).commit();
    ad.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsSoundInVoip: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150007);
  }
  
  public static void cX(boolean paramBoolean)
  {
    AppMethodBeat.i(150008);
    Yf().edit().putBoolean("settings_voip_scene_shake", paramBoolean).commit();
    ad.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShakeInVoip: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150008);
  }
  
  public static void cY(boolean paramBoolean)
  {
    AppMethodBeat.i(150009);
    Yf().edit().putBoolean("settings_active_time_full", paramBoolean).commit();
    ad.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsActiveTime: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150009);
  }
  
  public static void cs(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150010);
    SharedPreferences localSharedPreferences = Yf();
    localSharedPreferences.edit().putInt("settings_active_begin_time_hour", paramInt1).commit();
    localSharedPreferences.edit().putInt("settings_active_begin_time_min", paramInt2).commit();
    ad.i(TAG, "[NOTIFICATION SETTINGS]double write : saveActiveBegine: %d:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(150010);
  }
  
  public static void ct(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150011);
    SharedPreferences localSharedPreferences = Yf();
    localSharedPreferences.edit().putInt("settings_active_end_time_hour", paramInt1).commit();
    localSharedPreferences.edit().putInt("settings_active_end_time_min", paramInt2).commit();
    ad.i(TAG, "[NOTIFICATION SETTINGS]double write : saveActiveEnd: %d:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(150011);
  }
  
  public static void lk(int paramInt)
  {
    AppMethodBeat.i(150013);
    Yf().edit().putInt("notification.status.webonline.push.open", paramInt).commit();
    AppMethodBeat.o(150013);
  }
  
  public static boolean ll(int paramInt)
  {
    return (paramInt == 50) || (paramInt == 53);
  }
  
  public static boolean p(bl parambl)
  {
    AppMethodBeat.i(150026);
    if (parambl == null)
    {
      AppMethodBeat.o(150026);
      return false;
    }
    boolean bool = parambl.aIN(u.aqG());
    AppMethodBeat.o(150026);
    return bool;
  }
  
  public static boolean pB(String paramString)
  {
    AppMethodBeat.i(150015);
    ww localww = new ww();
    localww.dCp.djq = 1;
    localww.dCp.content = paramString;
    com.tencent.mm.sdk.b.a.ESL.l(localww);
    if ((localww.dCq.type == 2) || (paramString.equals(bl.FzN)))
    {
      AppMethodBeat.o(150015);
      return true;
    }
    AppMethodBeat.o(150015);
    return false;
  }
  
  public static boolean pC(String paramString)
  {
    AppMethodBeat.i(150016);
    ww localww = new ww();
    localww.dCp.djq = 1;
    localww.dCp.content = paramString;
    com.tencent.mm.sdk.b.a.ESL.l(localww);
    if ((localww.dCq.type == 3) || (paramString.equals(bl.FzM)))
    {
      AppMethodBeat.o(150016);
      return true;
    }
    AppMethodBeat.o(150016);
    return false;
  }
  
  public static int pD(String paramString)
  {
    AppMethodBeat.i(150021);
    int i = x.av(paramString, null);
    AppMethodBeat.o(150021);
    return i;
  }
  
  public static boolean pE(String paramString)
  {
    AppMethodBeat.i(150022);
    boolean bool = af.st(paramString);
    AppMethodBeat.o(150022);
    return bool;
  }
  
  public static boolean pF(String paramString)
  {
    AppMethodBeat.i(150023);
    boolean bool = w.sl(paramString);
    AppMethodBeat.o(150023);
    return bool;
  }
  
  public static boolean pG(String paramString)
  {
    AppMethodBeat.i(150024);
    if ((w.tt(paramString)) || ((w.pF(paramString)) && (!w.ts(paramString))) || ((w.sn(paramString)) && (!w.ts(paramString))))
    {
      AppMethodBeat.o(150024);
      return true;
    }
    AppMethodBeat.o(150024);
    return false;
  }
  
  public static int pH(String paramString)
  {
    AppMethodBeat.i(150025);
    int i = ((k)g.ab(k.class)).apR().aIB(paramString);
    AppMethodBeat.o(150025);
    return i;
  }
  
  public static void py(String paramString)
  {
    AppMethodBeat.i(150004);
    a.py(paramString);
    ad.i(TAG, "[NOTIFICATION SETTINGS]double write : saveSoundTone: %s", new Object[] { paramString });
    AppMethodBeat.o(150004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.m.f
 * JD-Core Version:    0.7.0.1
 */