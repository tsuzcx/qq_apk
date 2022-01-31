package com.tencent.mm.m;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ux;
import com.tencent.mm.g.a.ux.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
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
  
  public static boolean Ni()
  {
    AppMethodBeat.i(77677);
    boolean bool = com.tencent.mm.kernel.a.jM(com.tencent.mm.kernel.a.QS());
    AppMethodBeat.o(77677);
    return bool;
  }
  
  public static boolean Nj()
  {
    AppMethodBeat.i(77679);
    boolean bool = r.kt(Mu().getInt("notification.status.webonline.push.open", 0));
    AppMethodBeat.o(77679);
    return bool;
  }
  
  public static int Nk()
  {
    AppMethodBeat.i(77682);
    if (!g.RG())
    {
      ab.w(TAG, "getUnReadTalkerCount, but mmcore not ready");
      AppMethodBeat.o(77682);
      return 0;
    }
    int i = u.f(t.flc, Nn());
    AppMethodBeat.o(77682);
    return i;
  }
  
  public static List<String> Nl()
  {
    AppMethodBeat.i(77683);
    List localList = u.P(t.flc, -1);
    AppMethodBeat.o(77683);
    return localList;
  }
  
  public static int Nm()
  {
    AppMethodBeat.i(77684);
    if (!g.RG())
    {
      ab.w(TAG, "getUnReadMsgCoun, but mmcore not ready");
      AppMethodBeat.o(77684);
      return 0;
    }
    int i = u.e(t.flc, Nn());
    AppMethodBeat.o(77684);
    return i;
  }
  
  private static List<String> Nn()
  {
    AppMethodBeat.i(151539);
    ArrayList localArrayList = new ArrayList();
    if (!g.RG())
    {
      ab.w(TAG, "getUnReadTalkerCount, but mmcore not ready");
      AppMethodBeat.o(151539);
      return localArrayList;
    }
    if (!g.RL().Ru().getBoolean(ac.a.yDB, true))
    {
      localArrayList.add("notifymessage");
      ab.d(TAG, "add service notify message into show unread count blacklist.");
    }
    if (!g.RL().Ru().getBoolean(ac.a.yDC, true))
    {
      localArrayList.add("appbrandcustomerservicemsg");
      ab.d(TAG, "add wxa custom session notify message into show unread count blacklist.");
    }
    AppMethodBeat.o(151539);
    return localArrayList;
  }
  
  public static boolean No()
  {
    AppMethodBeat.i(77691);
    boolean bool = ((Boolean)g.RL().Ru().get(73217, Boolean.TRUE)).booleanValue();
    AppMethodBeat.o(77691);
    return bool;
  }
  
  public static boolean Np()
  {
    AppMethodBeat.i(77692);
    boolean bool = ((Boolean)g.RL().Ru().get(73218, Boolean.TRUE)).booleanValue();
    AppMethodBeat.o(77692);
    return bool;
  }
  
  public static void bT(boolean paramBoolean)
  {
    AppMethodBeat.i(77664);
    Mu().edit().putBoolean("settings_new_msg_notification", paramBoolean).commit();
    ab.i(TAG, "[NOTIFICATION SETTINGS]double write : saveNewMsgNotification: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(77664);
  }
  
  public static void bU(boolean paramBoolean)
  {
    AppMethodBeat.i(77665);
    Mu().edit().putBoolean("settings_new_voip_msg_notification", paramBoolean).commit();
    ab.i(TAG, "[NOTIFICATION SETTINGS]double write : saveNewVoIPMsgNotification: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(77665);
  }
  
  public static void bV(boolean paramBoolean)
  {
    AppMethodBeat.i(77666);
    Mu().edit().putBoolean("settings_show_detail", paramBoolean).commit();
    ab.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShowDetail: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(77666);
  }
  
  public static void bW(boolean paramBoolean)
  {
    AppMethodBeat.i(77667);
    Mu().edit().putBoolean("settings_sound", paramBoolean).commit();
    ab.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsSound: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(77667);
  }
  
  public static void bX(boolean paramBoolean)
  {
    AppMethodBeat.i(77668);
    Mu().edit().putBoolean("settings_shake", paramBoolean).commit();
    ab.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShake: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(77668);
  }
  
  public static void bY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(77675);
    SharedPreferences localSharedPreferences = Mu();
    localSharedPreferences.edit().putInt("settings_active_begin_time_hour", paramInt1).commit();
    localSharedPreferences.edit().putInt("settings_active_begin_time_min", paramInt2).commit();
    ab.i(TAG, "[NOTIFICATION SETTINGS]double write : saveActiveBegine: %d:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(77675);
  }
  
  public static void bY(boolean paramBoolean)
  {
    AppMethodBeat.i(77670);
    Mu().edit().putBoolean("settings_special_scene_sound", paramBoolean).commit();
    ab.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsSoundInSpecialScene: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(77670);
  }
  
  public static void bZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(77676);
    SharedPreferences localSharedPreferences = Mu();
    localSharedPreferences.edit().putInt("settings_active_end_time_hour", paramInt1).commit();
    localSharedPreferences.edit().putInt("settings_active_end_time_min", paramInt2).commit();
    ab.i(TAG, "[NOTIFICATION SETTINGS]double write : saveActiveEnd: %d:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(77676);
  }
  
  public static void bZ(boolean paramBoolean)
  {
    AppMethodBeat.i(77671);
    Mu().edit().putBoolean("settings_special_scene_shake", paramBoolean).commit();
    ab.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShakeInSpecialScene: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(77671);
  }
  
  public static void ca(boolean paramBoolean)
  {
    AppMethodBeat.i(77672);
    Mu().edit().putBoolean("settings_voip_scene_sound", paramBoolean).commit();
    ab.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsSoundInVoip: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(77672);
  }
  
  public static void cb(boolean paramBoolean)
  {
    AppMethodBeat.i(77673);
    Mu().edit().putBoolean("settings_voip_scene_shake", paramBoolean).commit();
    ab.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShakeInVoip: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(77673);
  }
  
  public static void cc(boolean paramBoolean)
  {
    AppMethodBeat.i(77674);
    Mu().edit().putBoolean("settings_active_time_full", paramBoolean).commit();
    ab.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsActiveTime: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(77674);
  }
  
  public static boolean i(bi parambi)
  {
    AppMethodBeat.i(77690);
    if (parambi == null)
    {
      AppMethodBeat.o(77690);
      return false;
    }
    boolean bool = parambi.asi(r.Zn());
    AppMethodBeat.o(77690);
    return bool;
  }
  
  public static void iW(int paramInt)
  {
    AppMethodBeat.i(77678);
    Mu().edit().putInt("notification.status.webonline.push.open", paramInt).commit();
    AppMethodBeat.o(77678);
  }
  
  public static boolean iX(int paramInt)
  {
    return (paramInt == 50) || (paramInt == 53);
  }
  
  public static boolean lA(String paramString)
  {
    AppMethodBeat.i(77687);
    boolean bool = t.nI(paramString);
    AppMethodBeat.o(77687);
    return bool;
  }
  
  public static boolean lB(String paramString)
  {
    AppMethodBeat.i(77688);
    if ((t.oI(paramString)) || ((t.lA(paramString)) && (!t.oH(paramString))) || ((t.nK(paramString)) && (!t.oH(paramString))))
    {
      AppMethodBeat.o(77688);
      return true;
    }
    AppMethodBeat.o(77688);
    return false;
  }
  
  public static int lC(String paramString)
  {
    AppMethodBeat.i(77689);
    int i = ((j)g.E(j.class)).YF().arV(paramString);
    AppMethodBeat.o(77689);
    return i;
  }
  
  public static void lt(String paramString)
  {
    AppMethodBeat.i(77669);
    a.lt(paramString);
    ab.i(TAG, "[NOTIFICATION SETTINGS]double write : saveSoundTone: %s", new Object[] { paramString });
    AppMethodBeat.o(77669);
  }
  
  public static boolean lw(String paramString)
  {
    AppMethodBeat.i(77680);
    ux localux = new ux();
    localux.cLs.cut = 1;
    localux.cLs.content = paramString;
    com.tencent.mm.sdk.b.a.ymk.l(localux);
    if ((localux.cLt.type == 2) || (paramString.equals(bi.yOc)))
    {
      AppMethodBeat.o(77680);
      return true;
    }
    AppMethodBeat.o(77680);
    return false;
  }
  
  public static boolean lx(String paramString)
  {
    AppMethodBeat.i(77681);
    ux localux = new ux();
    localux.cLs.cut = 1;
    localux.cLs.content = paramString;
    com.tencent.mm.sdk.b.a.ymk.l(localux);
    if ((localux.cLt.type == 3) || (paramString.equals(bi.yOb)))
    {
      AppMethodBeat.o(77681);
      return true;
    }
    AppMethodBeat.o(77681);
    return false;
  }
  
  public static int ly(String paramString)
  {
    AppMethodBeat.i(77685);
    int i = u.ag(paramString, null);
    AppMethodBeat.o(77685);
    return i;
  }
  
  public static boolean lz(String paramString)
  {
    AppMethodBeat.i(77686);
    boolean bool = ad.nM(paramString);
    AppMethodBeat.o(77686);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.m.f
 * JD-Core Version:    0.7.0.1
 */