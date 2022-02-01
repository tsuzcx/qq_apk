package com.tencent.mm.n;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yh;
import com.tencent.mm.g.a.yh.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class f
  extends a
{
  private static String TAG = "MicroMsg.NotificationConfig";
  
  public static boolean acF()
  {
    AppMethodBeat.i(150012);
    boolean bool = com.tencent.mm.kernel.a.mQ(com.tencent.mm.kernel.a.aiW());
    AppMethodBeat.o(150012);
    return bool;
  }
  
  public static boolean acG()
  {
    AppMethodBeat.i(150014);
    boolean bool = v.op(abL().getInt("notification.status.webonline.push.open", 0));
    AppMethodBeat.o(150014);
    return bool;
  }
  
  public static int acH()
  {
    AppMethodBeat.i(150017);
    if (!g.ajM())
    {
      ae.w(TAG, "getUnReadTalkerCount, but mmcore not ready");
      AppMethodBeat.o(150017);
      return 0;
    }
    int i = y.Bm(x.hHV).size();
    AppMethodBeat.o(150017);
    return i;
  }
  
  public static int acI()
  {
    AppMethodBeat.i(150019);
    if (!g.ajM())
    {
      ae.w(TAG, "getUnReadMsgCoun, but mmcore not ready");
      AppMethodBeat.o(150019);
      return 0;
    }
    int i = y.Bk(x.hHV);
    AppMethodBeat.o(150019);
    return i;
  }
  
  public static boolean acJ()
  {
    AppMethodBeat.i(150027);
    boolean bool = ((Boolean)g.ajR().ajA().get(73217, Boolean.TRUE)).booleanValue();
    AppMethodBeat.o(150027);
    return bool;
  }
  
  public static boolean acK()
  {
    AppMethodBeat.i(150028);
    boolean bool = ((Boolean)g.ajR().ajA().get(73218, Boolean.TRUE)).booleanValue();
    AppMethodBeat.o(150028);
    return bool;
  }
  
  public static void cQ(boolean paramBoolean)
  {
    AppMethodBeat.i(149999);
    abL().edit().putBoolean("settings_new_msg_notification", paramBoolean).commit();
    ae.i(TAG, "[NOTIFICATION SETTINGS]double write : saveNewMsgNotification: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(149999);
  }
  
  public static void cR(boolean paramBoolean)
  {
    AppMethodBeat.i(150000);
    abL().edit().putBoolean("settings_new_voip_msg_notification", paramBoolean).commit();
    ae.i(TAG, "[NOTIFICATION SETTINGS]double write : saveNewVoIPMsgNotification: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150000);
  }
  
  public static void cS(boolean paramBoolean)
  {
    AppMethodBeat.i(150001);
    abL().edit().putBoolean("settings_show_detail", paramBoolean).commit();
    ae.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShowDetail: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150001);
  }
  
  public static void cT(boolean paramBoolean)
  {
    AppMethodBeat.i(150002);
    abL().edit().putBoolean("settings_sound", paramBoolean).commit();
    ae.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsSound: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150002);
  }
  
  public static void cU(boolean paramBoolean)
  {
    AppMethodBeat.i(150003);
    abL().edit().putBoolean("settings_shake", paramBoolean).commit();
    ae.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShake: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150003);
  }
  
  public static void cV(boolean paramBoolean)
  {
    AppMethodBeat.i(150005);
    abL().edit().putBoolean("settings_special_scene_sound", paramBoolean).commit();
    ae.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsSoundInSpecialScene: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150005);
  }
  
  public static void cW(boolean paramBoolean)
  {
    AppMethodBeat.i(150006);
    abL().edit().putBoolean("settings_special_scene_shake", paramBoolean).commit();
    ae.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShakeInSpecialScene: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150006);
  }
  
  public static void cX(boolean paramBoolean)
  {
    AppMethodBeat.i(150007);
    abL().edit().putBoolean("settings_voip_scene_sound", paramBoolean).commit();
    ae.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsSoundInVoip: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150007);
  }
  
  public static void cY(boolean paramBoolean)
  {
    AppMethodBeat.i(150008);
    abL().edit().putBoolean("settings_voip_scene_shake", paramBoolean).commit();
    ae.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsShakeInVoip: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150008);
  }
  
  public static void cZ(boolean paramBoolean)
  {
    AppMethodBeat.i(150009);
    abL().edit().putBoolean("settings_active_time_full", paramBoolean).commit();
    ae.i(TAG, "[NOTIFICATION SETTINGS]double write : saveIsActiveTime: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(150009);
  }
  
  public static void cs(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150010);
    SharedPreferences localSharedPreferences = abL();
    localSharedPreferences.edit().putInt("settings_active_begin_time_hour", paramInt1).commit();
    localSharedPreferences.edit().putInt("settings_active_begin_time_min", paramInt2).commit();
    ae.i(TAG, "[NOTIFICATION SETTINGS]double write : saveActiveBegine: %d:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(150010);
  }
  
  public static void ct(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150011);
    SharedPreferences localSharedPreferences = abL();
    localSharedPreferences.edit().putInt("settings_active_end_time_hour", paramInt1).commit();
    localSharedPreferences.edit().putInt("settings_active_end_time_min", paramInt2).commit();
    ae.i(TAG, "[NOTIFICATION SETTINGS]double write : saveActiveEnd: %d:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(150011);
  }
  
  public static void lF(int paramInt)
  {
    AppMethodBeat.i(150013);
    abL().edit().putInt("notification.status.webonline.push.open", paramInt).commit();
    AppMethodBeat.o(150013);
  }
  
  public static boolean lG(int paramInt)
  {
    return (paramInt == 50) || (paramInt == 53);
  }
  
  public static List<String> lH(int paramInt)
  {
    AppMethodBeat.i(218645);
    ArrayList localArrayList = new ArrayList();
    Map localMap = y.Bm(x.hHV);
    Iterator localIterator = localMap.keySet().iterator();
    int i;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      String str = (String)localIterator.next();
      i = paramInt - 1;
      localArrayList.add(((an)localMap.get(str)).adF());
      paramInt = i;
    } while (i != 0);
    AppMethodBeat.o(218645);
    return localArrayList;
  }
  
  public static boolean p(bv parambv)
  {
    AppMethodBeat.i(150026);
    if (parambv == null)
    {
      AppMethodBeat.o(150026);
      return false;
    }
    boolean bool = parambv.aVB(v.aAC());
    AppMethodBeat.o(150026);
    return bool;
  }
  
  public static void vU(String paramString)
  {
    AppMethodBeat.i(150004);
    a.vU(paramString);
    ae.i(TAG, "[NOTIFICATION SETTINGS]double write : saveSoundTone: %s", new Object[] { paramString });
    AppMethodBeat.o(150004);
  }
  
  public static boolean vX(String paramString)
  {
    AppMethodBeat.i(150015);
    yh localyh = new yh();
    localyh.dNE.dto = 1;
    localyh.dNE.content = paramString;
    com.tencent.mm.sdk.b.a.IvT.l(localyh);
    if ((localyh.dNF.type == 2) || (paramString.equals(bv.JgL)))
    {
      AppMethodBeat.o(150015);
      return true;
    }
    AppMethodBeat.o(150015);
    return false;
  }
  
  public static boolean vY(String paramString)
  {
    AppMethodBeat.i(150016);
    yh localyh = new yh();
    localyh.dNE.dto = 1;
    localyh.dNE.content = paramString;
    com.tencent.mm.sdk.b.a.IvT.l(localyh);
    if ((localyh.dNF.type == 3) || (paramString.equals(bv.JgK)))
    {
      AppMethodBeat.o(150016);
      return true;
    }
    AppMethodBeat.o(150016);
    return false;
  }
  
  public static int vZ(String paramString)
  {
    AppMethodBeat.i(150021);
    int i = y.aG(paramString, null);
    AppMethodBeat.o(150021);
    return i;
  }
  
  public static boolean wa(String paramString)
  {
    AppMethodBeat.i(150022);
    boolean bool = an.Ac(paramString);
    AppMethodBeat.o(150022);
    return bool;
  }
  
  public static boolean wb(String paramString)
  {
    AppMethodBeat.i(150023);
    boolean bool = x.zT(paramString);
    AppMethodBeat.o(150023);
    return bool;
  }
  
  public static boolean wc(String paramString)
  {
    AppMethodBeat.i(150024);
    if ((x.Be(paramString)) || ((x.wb(paramString)) && (!x.Bd(paramString))) || ((x.zV(paramString)) && (!x.Bd(paramString))))
    {
      AppMethodBeat.o(150024);
      return true;
    }
    AppMethodBeat.o(150024);
    return false;
  }
  
  public static int wd(String paramString)
  {
    AppMethodBeat.i(150025);
    int i = ((l)g.ab(l.class)).azL().aVp(paramString);
    AppMethodBeat.o(150025);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.n.f
 * JD-Core Version:    0.7.0.1
 */