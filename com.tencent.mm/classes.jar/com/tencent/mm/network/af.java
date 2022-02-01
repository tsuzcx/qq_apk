package com.tencent.mm.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;

public final class af
{
  private static boolean hasInit = false;
  private static af jFH;
  private static boolean jFP = false;
  private static a jFQ = null;
  private v glb;
  private MMHandler handler;
  private ag jFI;
  private ah jFJ;
  private Context jFK;
  private b jFL;
  private ae jFM;
  private ad jFN;
  private ab jFO;
  
  public static void a(ab paramab)
  {
    AppMethodBeat.i(132930);
    bkc().jFO = paramab;
    AppMethodBeat.o(132930);
  }
  
  public static void a(ad paramad)
  {
    AppMethodBeat.i(132927);
    bkc().jFN = paramad;
    AppMethodBeat.o(132927);
  }
  
  public static void a(ae paramae)
  {
    AppMethodBeat.i(132925);
    bkc().jFM = paramae;
    AppMethodBeat.o(132925);
  }
  
  public static void a(a parama)
  {
    jFQ = parama;
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(132921);
    bkc().jFL = paramb;
    AppMethodBeat.o(132921);
  }
  
  public static void a(ag paramag)
  {
    AppMethodBeat.i(132913);
    bkc().jFI = paramag;
    AppMethodBeat.o(132913);
  }
  
  public static void a(ah paramah)
  {
    AppMethodBeat.i(132915);
    bkc().jFJ = paramah;
    AppMethodBeat.o(132915);
  }
  
  public static void a(MMHandler paramMMHandler)
  {
    AppMethodBeat.i(132919);
    bkc().handler = paramMMHandler;
    AppMethodBeat.o(132919);
  }
  
  private static af bkc()
  {
    AppMethodBeat.i(132907);
    if (jFH == null) {
      jFH = new af();
    }
    af localaf = jFH;
    AppMethodBeat.o(132907);
    return localaf;
  }
  
  private static SharedPreferences bkd()
  {
    AppMethodBeat.i(132908);
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("notify_key_pref_no_account", g.aps());
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("notify_key_pref_no_account");
    MultiProcessMMKV.transport2MMKV(localSharedPreferences, localMultiProcessMMKV);
    AppMethodBeat.o(132908);
    return localMultiProcessMMKV;
  }
  
  public static SharedPreferences bke()
  {
    AppMethodBeat.i(132909);
    Object localObject2 = bkd().getString("login_weixin_username", "");
    Object localObject1 = localObject2;
    if (Util.isNullOrNil((String)localObject2))
    {
      localObject2 = bf.iDu.aA("login_weixin_username", "");
      localObject1 = localObject2;
      if (!Util.isNullOrNil((String)localObject2))
      {
        bkd().edit().putString("login_weixin_username", (String)localObject2).commit();
        localObject1 = localObject2;
      }
    }
    localObject2 = localObject1;
    if (localObject1 != null) {
      localObject2 = ((String)localObject1).replace("[\\/\\\\]", "#").trim();
    }
    localObject1 = "notify_key_pref".concat(String.valueOf(localObject2));
    localObject2 = MultiProcessMMKV.getMMKV((String)localObject1);
    MultiProcessMMKV.transport2MMKV(MMApplicationContext.getContext().getSharedPreferences((String)localObject1, g.aps()), (MultiProcessMMKV)localObject2);
    AppMethodBeat.o(132909);
    return localObject2;
  }
  
  public static void bkf()
  {
    AppMethodBeat.i(132910);
    SharedPreferences localSharedPreferences;
    int i;
    if (!hasInit)
    {
      localSharedPreferences = bke();
      long l = localSharedPreferences.getLong("wakeup_alarm_last_tick", 0L);
      i = localSharedPreferences.getInt("wakeup_alarm_last_cnt", 0);
      if ((l == 0L) || (l > Util.nowMilliSecond()))
      {
        Log.i("MicroMsg.MMPushCore", "dealWithOnCreate, invalid time, thisCnt:%d", new Object[] { Integer.valueOf(i) });
        localSharedPreferences.edit().putLong("wakeup_alarm_last_tick", Util.nowMilliSecond()).commit();
        localSharedPreferences.edit().putInt("wakeup_alarm_last_cnt", 1).commit();
        AppMethodBeat.o(132910);
        return;
      }
      if (Util.milliSecondsToNow(l) <= 86400000L) {
        break label216;
      }
      localSharedPreferences.edit().putInt("wakeup_alarm_launch_cnt", i).commit();
      localSharedPreferences.edit().putLong("wakeup_alarm_last_tick", Util.nowMilliSecond()).commit();
      localSharedPreferences.edit().putInt("wakeup_alarm_last_cnt", 1).commit();
      Log.i("MicroMsg.MMPushCore", "dealWithOnCreate, statistics cycle expire, thisCnt:%d", new Object[] { Integer.valueOf(i) });
    }
    for (;;)
    {
      hasInit = true;
      AppMethodBeat.o(132910);
      return;
      label216:
      localSharedPreferences.edit().putInt("wakeup_alarm_last_cnt", i + 1).commit();
      Log.i("MicroMsg.MMPushCore", "dealWithOnCreate, add up launch count to:%d", new Object[] { Integer.valueOf(i + 1) });
    }
  }
  
  public static boolean bkg()
  {
    AppMethodBeat.i(132911);
    String str = bf.iDu.aA("login_user_name", "");
    Object localObject = str;
    if (str != null) {
      localObject = str.replaceAll("[/\\\\]", "#").trim();
    }
    localObject = MMApplicationContext.getContext().getSharedPreferences("notify_key_pref".concat(String.valueOf(localObject)), g.aps());
    int i = ((SharedPreferences)localObject).getInt("wakeup_alarm_launch_cnt", 0);
    int j = ((SharedPreferences)localObject).getInt("wakeup_alarm_last_cnt", 0);
    Log.i("MicroMsg.MMPushCore", "isFrequentlyLaunch cnt:%d, thisCnt:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
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
  
  public static ag bkh()
  {
    AppMethodBeat.i(132912);
    ag localag = bkc().jFI;
    AppMethodBeat.o(132912);
    return localag;
  }
  
  public static ah bki()
  {
    AppMethodBeat.i(132914);
    ah localah = bkc().jFJ;
    AppMethodBeat.o(132914);
    return localah;
  }
  
  public static MMHandler bkj()
  {
    AppMethodBeat.i(132918);
    MMHandler localMMHandler = bkc().handler;
    AppMethodBeat.o(132918);
    return localMMHandler;
  }
  
  public static b bkk()
  {
    AppMethodBeat.i(132920);
    b localb = bkc().jFL;
    AppMethodBeat.o(132920);
    return localb;
  }
  
  public static v bkl()
  {
    AppMethodBeat.i(132922);
    v localv = bkc().glb;
    AppMethodBeat.o(132922);
    return localv;
  }
  
  public static ae bkm()
  {
    AppMethodBeat.i(132924);
    ae localae = bkc().jFM;
    AppMethodBeat.o(132924);
    return localae;
  }
  
  public static ad bkn()
  {
    AppMethodBeat.i(132926);
    ad localad = bkc().jFN;
    AppMethodBeat.o(132926);
    return localad;
  }
  
  public static ab bko()
  {
    AppMethodBeat.i(132929);
    ab localab = bkc().jFO;
    AppMethodBeat.o(132929);
    return localab;
  }
  
  public static a bkp()
  {
    return jFQ;
  }
  
  public static void g(v paramv)
  {
    AppMethodBeat.i(132923);
    bkc().glb = paramv;
    AppMethodBeat.o(132923);
  }
  
  public static Context getContext()
  {
    AppMethodBeat.i(132916);
    Context localContext = bkc().jFK;
    AppMethodBeat.o(132916);
    return localContext;
  }
  
  public static void setContext(Context paramContext)
  {
    AppMethodBeat.i(132917);
    bkc().jFK = paramContext;
    AppMethodBeat.o(132917);
  }
  
  public static abstract interface a
  {
    public abstract void F(int paramInt, long paramLong);
    
    public abstract void K(String paramString, long paramLong);
  }
  
  public static abstract interface b
  {
    public abstract void df(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.network.af
 * JD-Core Version:    0.7.0.1
 */