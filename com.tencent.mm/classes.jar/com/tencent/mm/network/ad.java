package com.tencent.mm.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.ay;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;

public final class ad
{
  private static boolean hasInit = false;
  private static ad imT;
  private static boolean inb = false;
  private t flG;
  private ao handler;
  private ae imU;
  private af imV;
  private Context imW;
  private a imX;
  private ac imY;
  private ab imZ;
  private z ina;
  
  public static void a(ab paramab)
  {
    AppMethodBeat.i(132927);
    aLW().imZ = paramab;
    AppMethodBeat.o(132927);
  }
  
  public static void a(ac paramac)
  {
    AppMethodBeat.i(132925);
    aLW().imY = paramac;
    AppMethodBeat.o(132925);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(132921);
    aLW().imX = parama;
    AppMethodBeat.o(132921);
  }
  
  public static void a(ae paramae)
  {
    AppMethodBeat.i(132913);
    aLW().imU = paramae;
    AppMethodBeat.o(132913);
  }
  
  public static void a(af paramaf)
  {
    AppMethodBeat.i(132915);
    aLW().imV = paramaf;
    AppMethodBeat.o(132915);
  }
  
  public static void a(z paramz)
  {
    AppMethodBeat.i(132930);
    aLW().ina = paramz;
    AppMethodBeat.o(132930);
  }
  
  public static void a(ao paramao)
  {
    AppMethodBeat.i(132919);
    aLW().handler = paramao;
    AppMethodBeat.o(132919);
  }
  
  private static ad aLW()
  {
    AppMethodBeat.i(132907);
    if (imT == null) {
      imT = new ad();
    }
    ad localad = imT;
    AppMethodBeat.o(132907);
    return localad;
  }
  
  private static SharedPreferences aLX()
  {
    AppMethodBeat.i(132908);
    SharedPreferences localSharedPreferences = ai.getContext().getSharedPreferences("notify_key_pref_no_account", g.YK());
    aw localaw = aw.aKT("notify_key_pref_no_account");
    aw.a(localSharedPreferences, localaw);
    AppMethodBeat.o(132908);
    return localaw;
  }
  
  public static SharedPreferences aLY()
  {
    AppMethodBeat.i(132909);
    Object localObject2 = aLX().getString("login_weixin_username", "");
    Object localObject1 = localObject2;
    if (bs.isNullOrNil((String)localObject2))
    {
      localObject2 = ay.hnA.aw("login_weixin_username", "");
      localObject1 = localObject2;
      if (!bs.isNullOrNil((String)localObject2))
      {
        aLX().edit().putString("login_weixin_username", (String)localObject2).commit();
        localObject1 = localObject2;
      }
    }
    localObject2 = localObject1;
    if (localObject1 != null) {
      localObject2 = ((String)localObject1).replace("[\\/\\\\]", "#").trim();
    }
    localObject1 = "notify_key_pref".concat(String.valueOf(localObject2));
    localObject2 = aw.aKT((String)localObject1);
    aw.a(ai.getContext().getSharedPreferences((String)localObject1, g.YK()), (aw)localObject2);
    AppMethodBeat.o(132909);
    return localObject2;
  }
  
  public static void aLZ()
  {
    AppMethodBeat.i(132910);
    SharedPreferences localSharedPreferences;
    int i;
    if (!hasInit)
    {
      localSharedPreferences = aLY();
      long l = localSharedPreferences.getLong("wakeup_alarm_last_tick", 0L);
      i = localSharedPreferences.getInt("wakeup_alarm_last_cnt", 0);
      if ((l == 0L) || (l > bs.eWj()))
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MMPushCore", "dealWithOnCreate, invalid time, thisCnt:%d", new Object[] { Integer.valueOf(i) });
        localSharedPreferences.edit().putLong("wakeup_alarm_last_tick", bs.eWj()).commit();
        localSharedPreferences.edit().putInt("wakeup_alarm_last_cnt", 1).commit();
        AppMethodBeat.o(132910);
        return;
      }
      if (bs.Ap(l) <= 86400000L) {
        break label216;
      }
      localSharedPreferences.edit().putInt("wakeup_alarm_launch_cnt", i).commit();
      localSharedPreferences.edit().putLong("wakeup_alarm_last_tick", bs.eWj()).commit();
      localSharedPreferences.edit().putInt("wakeup_alarm_last_cnt", 1).commit();
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MMPushCore", "dealWithOnCreate, statistics cycle expire, thisCnt:%d", new Object[] { Integer.valueOf(i) });
    }
    for (;;)
    {
      hasInit = true;
      AppMethodBeat.o(132910);
      return;
      label216:
      localSharedPreferences.edit().putInt("wakeup_alarm_last_cnt", i + 1).commit();
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MMPushCore", "dealWithOnCreate, add up launch count to:%d", new Object[] { Integer.valueOf(i + 1) });
    }
  }
  
  public static boolean aMa()
  {
    AppMethodBeat.i(132911);
    String str = ay.hnA.aw("login_user_name", "");
    Object localObject = str;
    if (str != null) {
      localObject = str.replaceAll("[/\\\\]", "#").trim();
    }
    localObject = ai.getContext().getSharedPreferences("notify_key_pref".concat(String.valueOf(localObject)), g.YK());
    int i = ((SharedPreferences)localObject).getInt("wakeup_alarm_launch_cnt", 0);
    int j = ((SharedPreferences)localObject).getInt("wakeup_alarm_last_cnt", 0);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.MMPushCore", "isFrequentlyLaunch cnt:%d, thisCnt:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
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
      AppMethodBeat.o(132911);
      return j | i;
      i = 0;
      break;
    }
  }
  
  public static ae aMb()
  {
    AppMethodBeat.i(132912);
    ae localae = aLW().imU;
    AppMethodBeat.o(132912);
    return localae;
  }
  
  public static af aMc()
  {
    AppMethodBeat.i(132914);
    af localaf = aLW().imV;
    AppMethodBeat.o(132914);
    return localaf;
  }
  
  public static ao aMd()
  {
    AppMethodBeat.i(132918);
    ao localao = aLW().handler;
    AppMethodBeat.o(132918);
    return localao;
  }
  
  public static a aMe()
  {
    AppMethodBeat.i(132920);
    a locala = aLW().imX;
    AppMethodBeat.o(132920);
    return locala;
  }
  
  public static t aMf()
  {
    AppMethodBeat.i(132922);
    t localt = aLW().flG;
    AppMethodBeat.o(132922);
    return localt;
  }
  
  public static ac aMg()
  {
    AppMethodBeat.i(132924);
    ac localac = aLW().imY;
    AppMethodBeat.o(132924);
    return localac;
  }
  
  public static ab aMh()
  {
    AppMethodBeat.i(132926);
    ab localab = aLW().imZ;
    AppMethodBeat.o(132926);
    return localab;
  }
  
  public static z aMi()
  {
    AppMethodBeat.i(132929);
    z localz = aLW().ina;
    AppMethodBeat.o(132929);
    return localz;
  }
  
  public static void g(t paramt)
  {
    AppMethodBeat.i(132923);
    aLW().flG = paramt;
    AppMethodBeat.o(132923);
  }
  
  public static Context getContext()
  {
    AppMethodBeat.i(132916);
    Context localContext = aLW().imW;
    AppMethodBeat.o(132916);
    return localContext;
  }
  
  public static void setContext(Context paramContext)
  {
    AppMethodBeat.i(132917);
    aLW().imW = paramContext;
    AppMethodBeat.o(132917);
  }
  
  public static abstract interface a
  {
    public abstract void cv(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.network.ad
 * JD-Core Version:    0.7.0.1
 */