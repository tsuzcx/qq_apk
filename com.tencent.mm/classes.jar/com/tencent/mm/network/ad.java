package com.tencent.mm.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.bb;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;

public final class ad
{
  private static boolean hasInit = false;
  private static ad iJd;
  private static boolean iJl = false;
  private static a iJm = null;
  private t fFR;
  private aq handler;
  private ae iJe;
  private af iJf;
  private Context iJg;
  private b iJh;
  private ac iJi;
  private ab iJj;
  private z iJk;
  
  public static void a(ab paramab)
  {
    AppMethodBeat.i(132927);
    aPB().iJj = paramab;
    AppMethodBeat.o(132927);
  }
  
  public static void a(ac paramac)
  {
    AppMethodBeat.i(132925);
    aPB().iJi = paramac;
    AppMethodBeat.o(132925);
  }
  
  public static void a(a parama)
  {
    iJm = parama;
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(132921);
    aPB().iJh = paramb;
    AppMethodBeat.o(132921);
  }
  
  public static void a(ae paramae)
  {
    AppMethodBeat.i(132913);
    aPB().iJe = paramae;
    AppMethodBeat.o(132913);
  }
  
  public static void a(af paramaf)
  {
    AppMethodBeat.i(132915);
    aPB().iJf = paramaf;
    AppMethodBeat.o(132915);
  }
  
  public static void a(z paramz)
  {
    AppMethodBeat.i(132930);
    aPB().iJk = paramz;
    AppMethodBeat.o(132930);
  }
  
  public static void a(aq paramaq)
  {
    AppMethodBeat.i(132919);
    aPB().handler = paramaq;
    AppMethodBeat.o(132919);
  }
  
  private static ad aPB()
  {
    AppMethodBeat.i(132907);
    if (iJd == null) {
      iJd = new ad();
    }
    ad localad = iJd;
    AppMethodBeat.o(132907);
    return localad;
  }
  
  private static SharedPreferences aPC()
  {
    AppMethodBeat.i(132908);
    SharedPreferences localSharedPreferences = ak.getContext().getSharedPreferences("notify_key_pref_no_account", g.abv());
    ay localay = ay.aRW("notify_key_pref_no_account");
    ay.a(localSharedPreferences, localay);
    AppMethodBeat.o(132908);
    return localay;
  }
  
  public static SharedPreferences aPD()
  {
    AppMethodBeat.i(132909);
    Object localObject2 = aPC().getString("login_weixin_username", "");
    Object localObject1 = localObject2;
    if (bu.isNullOrNil((String)localObject2))
    {
      localObject2 = bb.hIK.ay("login_weixin_username", "");
      localObject1 = localObject2;
      if (!bu.isNullOrNil((String)localObject2))
      {
        aPC().edit().putString("login_weixin_username", (String)localObject2).commit();
        localObject1 = localObject2;
      }
    }
    localObject2 = localObject1;
    if (localObject1 != null) {
      localObject2 = ((String)localObject1).replace("[\\/\\\\]", "#").trim();
    }
    localObject1 = "notify_key_pref".concat(String.valueOf(localObject2));
    localObject2 = ay.aRW((String)localObject1);
    ay.a(ak.getContext().getSharedPreferences((String)localObject1, g.abv()), (ay)localObject2);
    AppMethodBeat.o(132909);
    return localObject2;
  }
  
  public static void aPE()
  {
    AppMethodBeat.i(132910);
    SharedPreferences localSharedPreferences;
    int i;
    if (!hasInit)
    {
      localSharedPreferences = aPD();
      long l = localSharedPreferences.getLong("wakeup_alarm_last_tick", 0L);
      i = localSharedPreferences.getInt("wakeup_alarm_last_cnt", 0);
      if ((l == 0L) || (l > bu.fpO()))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMPushCore", "dealWithOnCreate, invalid time, thisCnt:%d", new Object[] { Integer.valueOf(i) });
        localSharedPreferences.edit().putLong("wakeup_alarm_last_tick", bu.fpO()).commit();
        localSharedPreferences.edit().putInt("wakeup_alarm_last_cnt", 1).commit();
        AppMethodBeat.o(132910);
        return;
      }
      if (bu.DD(l) <= 86400000L) {
        break label216;
      }
      localSharedPreferences.edit().putInt("wakeup_alarm_launch_cnt", i).commit();
      localSharedPreferences.edit().putLong("wakeup_alarm_last_tick", bu.fpO()).commit();
      localSharedPreferences.edit().putInt("wakeup_alarm_last_cnt", 1).commit();
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMPushCore", "dealWithOnCreate, statistics cycle expire, thisCnt:%d", new Object[] { Integer.valueOf(i) });
    }
    for (;;)
    {
      hasInit = true;
      AppMethodBeat.o(132910);
      return;
      label216:
      localSharedPreferences.edit().putInt("wakeup_alarm_last_cnt", i + 1).commit();
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMPushCore", "dealWithOnCreate, add up launch count to:%d", new Object[] { Integer.valueOf(i + 1) });
    }
  }
  
  public static boolean aPF()
  {
    AppMethodBeat.i(132911);
    String str = bb.hIK.ay("login_user_name", "");
    Object localObject = str;
    if (str != null) {
      localObject = str.replaceAll("[/\\\\]", "#").trim();
    }
    localObject = ak.getContext().getSharedPreferences("notify_key_pref".concat(String.valueOf(localObject)), g.abv());
    int i = ((SharedPreferences)localObject).getInt("wakeup_alarm_launch_cnt", 0);
    int j = ((SharedPreferences)localObject).getInt("wakeup_alarm_last_cnt", 0);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MMPushCore", "isFrequentlyLaunch cnt:%d, thisCnt:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if (i > 10)
    {
      i = 1;
      if (j <= 10) {
        break label129;
      }
    }
    label129:
    for (j = 1;; j = 0)
    {
      AppMethodBeat.o(132911);
      return j | i;
      i = 0;
      break;
    }
  }
  
  public static ae aPG()
  {
    AppMethodBeat.i(132912);
    ae localae = aPB().iJe;
    AppMethodBeat.o(132912);
    return localae;
  }
  
  public static af aPH()
  {
    AppMethodBeat.i(132914);
    af localaf = aPB().iJf;
    AppMethodBeat.o(132914);
    return localaf;
  }
  
  public static aq aPI()
  {
    AppMethodBeat.i(132918);
    aq localaq = aPB().handler;
    AppMethodBeat.o(132918);
    return localaq;
  }
  
  public static b aPJ()
  {
    AppMethodBeat.i(132920);
    b localb = aPB().iJh;
    AppMethodBeat.o(132920);
    return localb;
  }
  
  public static t aPK()
  {
    AppMethodBeat.i(132922);
    t localt = aPB().fFR;
    AppMethodBeat.o(132922);
    return localt;
  }
  
  public static ac aPL()
  {
    AppMethodBeat.i(132924);
    ac localac = aPB().iJi;
    AppMethodBeat.o(132924);
    return localac;
  }
  
  public static ab aPM()
  {
    AppMethodBeat.i(132926);
    ab localab = aPB().iJj;
    AppMethodBeat.o(132926);
    return localab;
  }
  
  public static z aPN()
  {
    AppMethodBeat.i(132929);
    z localz = aPB().iJk;
    AppMethodBeat.o(132929);
    return localz;
  }
  
  public static a aPO()
  {
    return iJm;
  }
  
  public static void g(t paramt)
  {
    AppMethodBeat.i(132923);
    aPB().fFR = paramt;
    AppMethodBeat.o(132923);
  }
  
  public static Context getContext()
  {
    AppMethodBeat.i(132916);
    Context localContext = aPB().iJg;
    AppMethodBeat.o(132916);
    return localContext;
  }
  
  public static void setContext(Context paramContext)
  {
    AppMethodBeat.i(132917);
    aPB().iJg = paramContext;
    AppMethodBeat.o(132917);
  }
  
  public static abstract interface a
  {
    public abstract void C(int paramInt, long paramLong);
    
    public abstract void K(String paramString, long paramLong);
  }
  
  public static abstract interface b
  {
    public abstract void cx(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.network.ad
 * JD-Core Version:    0.7.0.1
 */