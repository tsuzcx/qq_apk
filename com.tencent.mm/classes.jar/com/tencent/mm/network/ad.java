package com.tencent.mm.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;

public final class ad
{
  private static boolean hasInit = false;
  private static ad iGk;
  private static boolean iGs = false;
  private static a iGt = null;
  private t fDN;
  private ap handler;
  private ae iGl;
  private af iGm;
  private Context iGn;
  private b iGo;
  private ac iGp;
  private ab iGq;
  private z iGr;
  
  public static void a(ab paramab)
  {
    AppMethodBeat.i(132927);
    aPd().iGq = paramab;
    AppMethodBeat.o(132927);
  }
  
  public static void a(ac paramac)
  {
    AppMethodBeat.i(132925);
    aPd().iGp = paramac;
    AppMethodBeat.o(132925);
  }
  
  public static void a(a parama)
  {
    iGt = parama;
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(132921);
    aPd().iGo = paramb;
    AppMethodBeat.o(132921);
  }
  
  public static void a(ae paramae)
  {
    AppMethodBeat.i(132913);
    aPd().iGl = paramae;
    AppMethodBeat.o(132913);
  }
  
  public static void a(af paramaf)
  {
    AppMethodBeat.i(132915);
    aPd().iGm = paramaf;
    AppMethodBeat.o(132915);
  }
  
  public static void a(z paramz)
  {
    AppMethodBeat.i(132930);
    aPd().iGr = paramz;
    AppMethodBeat.o(132930);
  }
  
  public static void a(ap paramap)
  {
    AppMethodBeat.i(132919);
    aPd().handler = paramap;
    AppMethodBeat.o(132919);
  }
  
  private static ad aPd()
  {
    AppMethodBeat.i(132907);
    if (iGk == null) {
      iGk = new ad();
    }
    ad localad = iGk;
    AppMethodBeat.o(132907);
    return localad;
  }
  
  private static SharedPreferences aPe()
  {
    AppMethodBeat.i(132908);
    SharedPreferences localSharedPreferences = aj.getContext().getSharedPreferences("notify_key_pref_no_account", g.abm());
    ax localax = ax.aQz("notify_key_pref_no_account");
    ax.a(localSharedPreferences, localax);
    AppMethodBeat.o(132908);
    return localax;
  }
  
  public static SharedPreferences aPf()
  {
    AppMethodBeat.i(132909);
    Object localObject2 = aPe().getString("login_weixin_username", "");
    Object localObject1 = localObject2;
    if (bt.isNullOrNil((String)localObject2))
    {
      localObject2 = az.hFS.ax("login_weixin_username", "");
      localObject1 = localObject2;
      if (!bt.isNullOrNil((String)localObject2))
      {
        aPe().edit().putString("login_weixin_username", (String)localObject2).commit();
        localObject1 = localObject2;
      }
    }
    localObject2 = localObject1;
    if (localObject1 != null) {
      localObject2 = ((String)localObject1).replace("[\\/\\\\]", "#").trim();
    }
    localObject1 = "notify_key_pref".concat(String.valueOf(localObject2));
    localObject2 = ax.aQz((String)localObject1);
    ax.a(aj.getContext().getSharedPreferences((String)localObject1, g.abm()), (ax)localObject2);
    AppMethodBeat.o(132909);
    return localObject2;
  }
  
  public static void aPg()
  {
    AppMethodBeat.i(132910);
    SharedPreferences localSharedPreferences;
    int i;
    if (!hasInit)
    {
      localSharedPreferences = aPf();
      long l = localSharedPreferences.getLong("wakeup_alarm_last_tick", 0L);
      i = localSharedPreferences.getInt("wakeup_alarm_last_cnt", 0);
      if ((l == 0L) || (l > bt.flT()))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MMPushCore", "dealWithOnCreate, invalid time, thisCnt:%d", new Object[] { Integer.valueOf(i) });
        localSharedPreferences.edit().putLong("wakeup_alarm_last_tick", bt.flT()).commit();
        localSharedPreferences.edit().putInt("wakeup_alarm_last_cnt", 1).commit();
        AppMethodBeat.o(132910);
        return;
      }
      if (bt.Df(l) <= 86400000L) {
        break label216;
      }
      localSharedPreferences.edit().putInt("wakeup_alarm_launch_cnt", i).commit();
      localSharedPreferences.edit().putLong("wakeup_alarm_last_tick", bt.flT()).commit();
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
  
  public static boolean aPh()
  {
    AppMethodBeat.i(132911);
    String str = az.hFS.ax("login_user_name", "");
    Object localObject = str;
    if (str != null) {
      localObject = str.replaceAll("[/\\\\]", "#").trim();
    }
    localObject = aj.getContext().getSharedPreferences("notify_key_pref".concat(String.valueOf(localObject)), g.abm());
    int i = ((SharedPreferences)localObject).getInt("wakeup_alarm_launch_cnt", 0);
    int j = ((SharedPreferences)localObject).getInt("wakeup_alarm_last_cnt", 0);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MMPushCore", "isFrequentlyLaunch cnt:%d, thisCnt:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
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
  
  public static ae aPi()
  {
    AppMethodBeat.i(132912);
    ae localae = aPd().iGl;
    AppMethodBeat.o(132912);
    return localae;
  }
  
  public static af aPj()
  {
    AppMethodBeat.i(132914);
    af localaf = aPd().iGm;
    AppMethodBeat.o(132914);
    return localaf;
  }
  
  public static ap aPk()
  {
    AppMethodBeat.i(132918);
    ap localap = aPd().handler;
    AppMethodBeat.o(132918);
    return localap;
  }
  
  public static b aPl()
  {
    AppMethodBeat.i(132920);
    b localb = aPd().iGo;
    AppMethodBeat.o(132920);
    return localb;
  }
  
  public static t aPm()
  {
    AppMethodBeat.i(132922);
    t localt = aPd().fDN;
    AppMethodBeat.o(132922);
    return localt;
  }
  
  public static ac aPn()
  {
    AppMethodBeat.i(132924);
    ac localac = aPd().iGp;
    AppMethodBeat.o(132924);
    return localac;
  }
  
  public static ab aPo()
  {
    AppMethodBeat.i(132926);
    ab localab = aPd().iGq;
    AppMethodBeat.o(132926);
    return localab;
  }
  
  public static z aPp()
  {
    AppMethodBeat.i(132929);
    z localz = aPd().iGr;
    AppMethodBeat.o(132929);
    return localz;
  }
  
  public static a aPq()
  {
    return iGt;
  }
  
  public static void g(t paramt)
  {
    AppMethodBeat.i(132923);
    aPd().fDN = paramt;
    AppMethodBeat.o(132923);
  }
  
  public static Context getContext()
  {
    AppMethodBeat.i(132916);
    Context localContext = aPd().iGn;
    AppMethodBeat.o(132916);
    return localContext;
  }
  
  public static void setContext(Context paramContext)
  {
    AppMethodBeat.i(132917);
    aPd().iGn = paramContext;
    AppMethodBeat.o(132917);
  }
  
  public static abstract interface a
  {
    public abstract void D(int paramInt, long paramLong);
    
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