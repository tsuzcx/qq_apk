package com.tencent.mm.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mm.model.at;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;

public final class aa
{
  private static aa eON;
  private static boolean eOW = false;
  private static boolean hasInit = false;
  private t dhp;
  private ab eOO;
  private ac eOP;
  private Context eOQ;
  private aa.a eOR;
  private z eOS;
  private y eOT;
  private Looper eOU;
  private w eOV;
  private ah handler;
  
  private static aa Ul()
  {
    if (eON == null) {
      eON = new aa();
    }
    return eON;
  }
  
  private static SharedPreferences Um()
  {
    return ae.getContext().getSharedPreferences("notify_key_pref_no_account", 4);
  }
  
  public static SharedPreferences Un()
  {
    Object localObject2 = Um().getString("login_weixin_username", "");
    Object localObject1 = localObject2;
    if (bk.bl((String)localObject2))
    {
      localObject2 = at.dVC.L("login_weixin_username", "");
      localObject1 = localObject2;
      if (!bk.bl((String)localObject2))
      {
        Um().edit().putString("login_weixin_username", (String)localObject2).commit();
        localObject1 = localObject2;
      }
    }
    localObject2 = localObject1;
    if (localObject1 != null) {
      localObject2 = ((String)localObject1).replace("[\\/\\\\]", "#").trim();
    }
    localObject1 = "notify_key_pref" + (String)localObject2;
    return ae.getContext().getSharedPreferences((String)localObject1, 4);
  }
  
  public static void Uo()
  {
    SharedPreferences localSharedPreferences;
    int i;
    if (!hasInit)
    {
      localSharedPreferences = Un();
      long l = localSharedPreferences.getLong("wakeup_alarm_last_tick", 0L);
      i = localSharedPreferences.getInt("wakeup_alarm_last_cnt", 0);
      if ((l == 0L) || (l > bk.UY()))
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMPushCore", "dealWithOnCreate, invalid time, thisCnt:%d", new Object[] { Integer.valueOf(i) });
        localSharedPreferences.edit().putLong("wakeup_alarm_last_tick", bk.UY()).commit();
        localSharedPreferences.edit().putInt("wakeup_alarm_last_cnt", 1).commit();
        return;
      }
      if (bk.co(l) <= 86400000L) {
        break label201;
      }
      localSharedPreferences.edit().putInt("wakeup_alarm_launch_cnt", i).commit();
      localSharedPreferences.edit().putLong("wakeup_alarm_last_tick", bk.UY()).commit();
      localSharedPreferences.edit().putInt("wakeup_alarm_last_cnt", 1).commit();
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMPushCore", "dealWithOnCreate, statistics cycle expire, thisCnt:%d", new Object[] { Integer.valueOf(i) });
    }
    for (;;)
    {
      hasInit = true;
      return;
      label201:
      localSharedPreferences.edit().putInt("wakeup_alarm_last_cnt", i + 1).commit();
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMPushCore", "dealWithOnCreate, add up launch count to:%d", new Object[] { Integer.valueOf(i + 1) });
    }
  }
  
  public static boolean Up()
  {
    String str = at.dVC.L("login_user_name", "");
    Object localObject = str;
    if (str != null) {
      localObject = str.replaceAll("[/\\\\]", "#").trim();
    }
    localObject = ae.getContext().getSharedPreferences("notify_key_pref" + (String)localObject, 4);
    int i = ((SharedPreferences)localObject).getInt("wakeup_alarm_launch_cnt", 0);
    int j = ((SharedPreferences)localObject).getInt("wakeup_alarm_last_cnt", 0);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMPushCore", "isFrequentlyLaunch cnt:%d, thisCnt:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if (i > 10)
    {
      i = 1;
      if (j <= 10) {
        break label123;
      }
    }
    label123:
    for (j = 1;; j = 0)
    {
      return j | i;
      i = 0;
      break;
    }
  }
  
  public static ab Uq()
  {
    return Ul().eOO;
  }
  
  public static ac Ur()
  {
    return Ul().eOP;
  }
  
  public static ah Us()
  {
    return Ul().handler;
  }
  
  public static aa.a Ut()
  {
    return Ul().eOR;
  }
  
  public static t Uu()
  {
    return Ul().dhp;
  }
  
  public static z Uv()
  {
    return Ul().eOS;
  }
  
  public static y Uw()
  {
    return Ul().eOT;
  }
  
  public static Looper Ux()
  {
    if (Ul().eOU == null)
    {
      HandlerThread localHandlerThread = e.aap("MMPushCore_handlerThread");
      localHandlerThread.start();
      Ul().eOU = localHandlerThread.getLooper();
    }
    return Ul().eOU;
  }
  
  public static w Uy()
  {
    return Ul().eOV;
  }
  
  public static boolean Uz()
  {
    Ul();
    return eOW;
  }
  
  public static void a(aa.a parama)
  {
    Ul().eOR = parama;
  }
  
  public static void a(ab paramab)
  {
    Ul().eOO = paramab;
  }
  
  public static void a(ac paramac)
  {
    Ul().eOP = paramac;
  }
  
  public static void a(w paramw)
  {
    Ul().eOV = paramw;
  }
  
  public static void a(y paramy)
  {
    Ul().eOT = paramy;
  }
  
  public static void a(z paramz)
  {
    Ul().eOS = paramz;
  }
  
  public static void a(ah paramah)
  {
    Ul().handler = paramah;
  }
  
  public static void b(t paramt)
  {
    Ul().dhp = paramt;
  }
  
  public static void co(boolean paramBoolean)
  {
    Ul();
    eOW = paramBoolean;
  }
  
  public static Context getContext()
  {
    return Ul().eOQ;
  }
  
  public static void setContext(Context paramContext)
  {
    Ul().eOQ = paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.network.aa
 * JD-Core Version:    0.7.0.1
 */