package com.tencent.mm.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.model.av;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

public final class ab
{
  private static ab geA;
  private static boolean geJ = false;
  private static boolean hasInit = false;
  private t dYA;
  private ac geB;
  private ad geC;
  private Context geD;
  private ab.a geE;
  private aa geF;
  private z geG;
  private Looper geH;
  private x geI;
  private ak handler;
  
  public static void a(aa paramaa)
  {
    AppMethodBeat.i(58675);
    anw().geF = paramaa;
    AppMethodBeat.o(58675);
  }
  
  public static void a(ab.a parama)
  {
    AppMethodBeat.i(58671);
    anw().geE = parama;
    AppMethodBeat.o(58671);
  }
  
  public static void a(ac paramac)
  {
    AppMethodBeat.i(58663);
    anw().geB = paramac;
    AppMethodBeat.o(58663);
  }
  
  public static void a(ad paramad)
  {
    AppMethodBeat.i(58665);
    anw().geC = paramad;
    AppMethodBeat.o(58665);
  }
  
  public static void a(x paramx)
  {
    AppMethodBeat.i(58680);
    anw().geI = paramx;
    AppMethodBeat.o(58680);
  }
  
  public static void a(z paramz)
  {
    AppMethodBeat.i(58677);
    anw().geG = paramz;
    AppMethodBeat.o(58677);
  }
  
  public static void a(ak paramak)
  {
    AppMethodBeat.i(58669);
    anw().handler = paramak;
    AppMethodBeat.o(58669);
  }
  
  public static boolean anA()
  {
    AppMethodBeat.i(58661);
    String str = av.flM.Y("login_user_name", "");
    Object localObject = str;
    if (str != null) {
      localObject = str.replaceAll("[/\\\\]", "#").trim();
    }
    localObject = ah.getContext().getSharedPreferences("notify_key_pref".concat(String.valueOf(localObject)), h.Mp());
    int i = ((SharedPreferences)localObject).getInt("wakeup_alarm_launch_cnt", 0);
    int j = ((SharedPreferences)localObject).getInt("wakeup_alarm_last_cnt", 0);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.MMPushCore", "isFrequentlyLaunch cnt:%d, thisCnt:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if (i > 10)
    {
      i = 1;
      if (j <= 10) {
        break label128;
      }
    }
    label128:
    for (j = 1;; j = 0)
    {
      AppMethodBeat.o(58661);
      return j | i;
      i = 0;
      break;
    }
  }
  
  public static ac anB()
  {
    AppMethodBeat.i(58662);
    ac localac = anw().geB;
    AppMethodBeat.o(58662);
    return localac;
  }
  
  public static ad anC()
  {
    AppMethodBeat.i(58664);
    ad localad = anw().geC;
    AppMethodBeat.o(58664);
    return localad;
  }
  
  public static ak anD()
  {
    AppMethodBeat.i(58668);
    ak localak = anw().handler;
    AppMethodBeat.o(58668);
    return localak;
  }
  
  public static ab.a anE()
  {
    AppMethodBeat.i(58670);
    ab.a locala = anw().geE;
    AppMethodBeat.o(58670);
    return locala;
  }
  
  public static t anF()
  {
    AppMethodBeat.i(58672);
    t localt = anw().dYA;
    AppMethodBeat.o(58672);
    return localt;
  }
  
  public static aa anG()
  {
    AppMethodBeat.i(58674);
    aa localaa = anw().geF;
    AppMethodBeat.o(58674);
    return localaa;
  }
  
  public static z anH()
  {
    AppMethodBeat.i(58676);
    z localz = anw().geG;
    AppMethodBeat.o(58676);
    return localz;
  }
  
  public static Looper anI()
  {
    AppMethodBeat.i(58678);
    if (anw().geH == null)
    {
      localObject = d.aqu("MMPushCore_handlerThread");
      ((HandlerThread)localObject).start();
      anw().geH = ((HandlerThread)localObject).getLooper();
    }
    Object localObject = anw().geH;
    AppMethodBeat.o(58678);
    return localObject;
  }
  
  public static x anJ()
  {
    AppMethodBeat.i(58679);
    x localx = anw().geI;
    AppMethodBeat.o(58679);
    return localx;
  }
  
  private static ab anw()
  {
    AppMethodBeat.i(58657);
    if (geA == null) {
      geA = new ab();
    }
    ab localab = geA;
    AppMethodBeat.o(58657);
    return localab;
  }
  
  private static SharedPreferences anx()
  {
    AppMethodBeat.i(58658);
    SharedPreferences localSharedPreferences = ah.getContext().getSharedPreferences("notify_key_pref_no_account", h.Mp());
    AppMethodBeat.o(58658);
    return localSharedPreferences;
  }
  
  public static SharedPreferences any()
  {
    AppMethodBeat.i(58659);
    Object localObject2 = anx().getString("login_weixin_username", "");
    Object localObject1 = localObject2;
    if (bo.isNullOrNil((String)localObject2))
    {
      localObject2 = av.flM.Y("login_weixin_username", "");
      localObject1 = localObject2;
      if (!bo.isNullOrNil((String)localObject2))
      {
        anx().edit().putString("login_weixin_username", (String)localObject2).commit();
        localObject1 = localObject2;
      }
    }
    localObject2 = localObject1;
    if (localObject1 != null) {
      localObject2 = ((String)localObject1).replace("[\\/\\\\]", "#").trim();
    }
    localObject1 = "notify_key_pref".concat(String.valueOf(localObject2));
    localObject1 = ah.getContext().getSharedPreferences((String)localObject1, h.Mp());
    AppMethodBeat.o(58659);
    return localObject1;
  }
  
  public static void anz()
  {
    AppMethodBeat.i(58660);
    SharedPreferences localSharedPreferences;
    int i;
    if (!hasInit)
    {
      localSharedPreferences = any();
      long l = localSharedPreferences.getLong("wakeup_alarm_last_tick", 0L);
      i = localSharedPreferences.getInt("wakeup_alarm_last_cnt", 0);
      if ((l == 0L) || (l > bo.aoy()))
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.MMPushCore", "dealWithOnCreate, invalid time, thisCnt:%d", new Object[] { Integer.valueOf(i) });
        localSharedPreferences.edit().putLong("wakeup_alarm_last_tick", bo.aoy()).commit();
        localSharedPreferences.edit().putInt("wakeup_alarm_last_cnt", 1).commit();
        AppMethodBeat.o(58660);
        return;
      }
      if (bo.hl(l) <= 86400000L) {
        break label224;
      }
      localSharedPreferences.edit().putInt("wakeup_alarm_launch_cnt", i).commit();
      localSharedPreferences.edit().putLong("wakeup_alarm_last_tick", bo.aoy()).commit();
      localSharedPreferences.edit().putInt("wakeup_alarm_last_cnt", 1).commit();
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.MMPushCore", "dealWithOnCreate, statistics cycle expire, thisCnt:%d", new Object[] { Integer.valueOf(i) });
    }
    for (;;)
    {
      hasInit = true;
      AppMethodBeat.o(58660);
      return;
      label224:
      localSharedPreferences.edit().putInt("wakeup_alarm_last_cnt", i + 1).commit();
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.MMPushCore", "dealWithOnCreate, add up launch count to:%d", new Object[] { Integer.valueOf(i + 1) });
    }
  }
  
  public static void b(t paramt)
  {
    AppMethodBeat.i(58673);
    anw().dYA = paramt;
    AppMethodBeat.o(58673);
  }
  
  public static Context getContext()
  {
    AppMethodBeat.i(58666);
    Context localContext = anw().geD;
    AppMethodBeat.o(58666);
    return localContext;
  }
  
  public static void setContext(Context paramContext)
  {
    AppMethodBeat.i(58667);
    anw().geD = paramContext;
    AppMethodBeat.o(58667);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.network.ab
 * JD-Core Version:    0.7.0.1
 */