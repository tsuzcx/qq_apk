package com.tencent.mm.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.ay;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;

public final class ad
{
  private static boolean hME = false;
  private static ad hMw;
  private static boolean hasInit = false;
  private t fil;
  private ad.a hMA;
  private ac hMB;
  private ab hMC;
  private z hMD;
  private ae hMx;
  private af hMy;
  private Context hMz;
  private ap handler;
  
  public static void a(ab paramab)
  {
    AppMethodBeat.i(132927);
    aFf().hMC = paramab;
    AppMethodBeat.o(132927);
  }
  
  public static void a(ac paramac)
  {
    AppMethodBeat.i(132925);
    aFf().hMB = paramac;
    AppMethodBeat.o(132925);
  }
  
  public static void a(ad.a parama)
  {
    AppMethodBeat.i(132921);
    aFf().hMA = parama;
    AppMethodBeat.o(132921);
  }
  
  public static void a(ae paramae)
  {
    AppMethodBeat.i(132913);
    aFf().hMx = paramae;
    AppMethodBeat.o(132913);
  }
  
  public static void a(af paramaf)
  {
    AppMethodBeat.i(132915);
    aFf().hMy = paramaf;
    AppMethodBeat.o(132915);
  }
  
  public static void a(z paramz)
  {
    AppMethodBeat.i(132930);
    aFf().hMD = paramz;
    AppMethodBeat.o(132930);
  }
  
  public static void a(ap paramap)
  {
    AppMethodBeat.i(132919);
    aFf().handler = paramap;
    AppMethodBeat.o(132919);
  }
  
  private static ad aFf()
  {
    AppMethodBeat.i(132907);
    if (hMw == null) {
      hMw = new ad();
    }
    ad localad = hMw;
    AppMethodBeat.o(132907);
    return localad;
  }
  
  private static SharedPreferences aFg()
  {
    AppMethodBeat.i(132908);
    SharedPreferences localSharedPreferences = aj.getContext().getSharedPreferences("notify_key_pref_no_account", g.XN());
    ax localax = ax.aFC("notify_key_pref_no_account");
    ax.a(localSharedPreferences, localax);
    AppMethodBeat.o(132908);
    return localax;
  }
  
  public static SharedPreferences aFh()
  {
    AppMethodBeat.i(132909);
    Object localObject2 = aFg().getString("login_weixin_username", "");
    Object localObject1 = localObject2;
    if (bt.isNullOrNil((String)localObject2))
    {
      localObject2 = ay.gNa.ao("login_weixin_username", "");
      localObject1 = localObject2;
      if (!bt.isNullOrNil((String)localObject2))
      {
        aFg().edit().putString("login_weixin_username", (String)localObject2).commit();
        localObject1 = localObject2;
      }
    }
    localObject2 = localObject1;
    if (localObject1 != null) {
      localObject2 = ((String)localObject1).replace("[\\/\\\\]", "#").trim();
    }
    localObject1 = "notify_key_pref".concat(String.valueOf(localObject2));
    localObject2 = ax.aFC((String)localObject1);
    ax.a(aj.getContext().getSharedPreferences((String)localObject1, g.XN()), (ax)localObject2);
    AppMethodBeat.o(132909);
    return localObject2;
  }
  
  public static void aFi()
  {
    AppMethodBeat.i(132910);
    SharedPreferences localSharedPreferences;
    int i;
    if (!hasInit)
    {
      localSharedPreferences = aFh();
      long l = localSharedPreferences.getLong("wakeup_alarm_last_tick", 0L);
      i = localSharedPreferences.getInt("wakeup_alarm_last_cnt", 0);
      if ((l == 0L) || (l > bt.eGO()))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MMPushCore", "dealWithOnCreate, invalid time, thisCnt:%d", new Object[] { Integer.valueOf(i) });
        localSharedPreferences.edit().putLong("wakeup_alarm_last_tick", bt.eGO()).commit();
        localSharedPreferences.edit().putInt("wakeup_alarm_last_cnt", 1).commit();
        AppMethodBeat.o(132910);
        return;
      }
      if (bt.vM(l) <= 86400000L) {
        break label216;
      }
      localSharedPreferences.edit().putInt("wakeup_alarm_launch_cnt", i).commit();
      localSharedPreferences.edit().putLong("wakeup_alarm_last_tick", bt.eGO()).commit();
      localSharedPreferences.edit().putInt("wakeup_alarm_last_cnt", 1).commit();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MMPushCore", "dealWithOnCreate, statistics cycle expire, thisCnt:%d", new Object[] { Integer.valueOf(i) });
    }
    for (;;)
    {
      hasInit = true;
      AppMethodBeat.o(132910);
      return;
      label216:
      localSharedPreferences.edit().putInt("wakeup_alarm_last_cnt", i + 1).commit();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MMPushCore", "dealWithOnCreate, add up launch count to:%d", new Object[] { Integer.valueOf(i + 1) });
    }
  }
  
  public static boolean aFj()
  {
    AppMethodBeat.i(132911);
    String str = ay.gNa.ao("login_user_name", "");
    Object localObject = str;
    if (str != null) {
      localObject = str.replaceAll("[/\\\\]", "#").trim();
    }
    localObject = aj.getContext().getSharedPreferences("notify_key_pref".concat(String.valueOf(localObject)), g.XN());
    int i = ((SharedPreferences)localObject).getInt("wakeup_alarm_launch_cnt", 0);
    int j = ((SharedPreferences)localObject).getInt("wakeup_alarm_last_cnt", 0);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MMPushCore", "isFrequentlyLaunch cnt:%d, thisCnt:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
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
  
  public static ae aFk()
  {
    AppMethodBeat.i(132912);
    ae localae = aFf().hMx;
    AppMethodBeat.o(132912);
    return localae;
  }
  
  public static af aFl()
  {
    AppMethodBeat.i(132914);
    af localaf = aFf().hMy;
    AppMethodBeat.o(132914);
    return localaf;
  }
  
  public static ap aFm()
  {
    AppMethodBeat.i(132918);
    ap localap = aFf().handler;
    AppMethodBeat.o(132918);
    return localap;
  }
  
  public static ad.a aFn()
  {
    AppMethodBeat.i(132920);
    ad.a locala = aFf().hMA;
    AppMethodBeat.o(132920);
    return locala;
  }
  
  public static t aFo()
  {
    AppMethodBeat.i(132922);
    t localt = aFf().fil;
    AppMethodBeat.o(132922);
    return localt;
  }
  
  public static ac aFp()
  {
    AppMethodBeat.i(132924);
    ac localac = aFf().hMB;
    AppMethodBeat.o(132924);
    return localac;
  }
  
  public static ab aFq()
  {
    AppMethodBeat.i(132926);
    ab localab = aFf().hMC;
    AppMethodBeat.o(132926);
    return localab;
  }
  
  public static z aFr()
  {
    AppMethodBeat.i(132929);
    z localz = aFf().hMD;
    AppMethodBeat.o(132929);
    return localz;
  }
  
  public static void g(t paramt)
  {
    AppMethodBeat.i(132923);
    aFf().fil = paramt;
    AppMethodBeat.o(132923);
  }
  
  public static Context getContext()
  {
    AppMethodBeat.i(132916);
    Context localContext = aFf().hMz;
    AppMethodBeat.o(132916);
    return localContext;
  }
  
  public static void setContext(Context paramContext)
  {
    AppMethodBeat.i(132917);
    aFf().hMz = paramContext;
    AppMethodBeat.o(132917);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.network.ad
 * JD-Core Version:    0.7.0.1
 */