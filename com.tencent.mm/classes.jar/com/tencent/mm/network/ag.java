package com.tencent.mm.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ag
{
  private static boolean hasInit = false;
  private static ag ppJ;
  private static boolean ppR = false;
  private static a ppS = null;
  private MMHandler handler;
  private w lre;
  private ah ppK;
  private ai ppL;
  private Context ppM;
  private List<b> ppN;
  private af ppO;
  private ae ppP;
  private ac ppQ;
  
  private ag()
  {
    AppMethodBeat.i(241114);
    this.ppN = new ArrayList();
    AppMethodBeat.o(241114);
  }
  
  public static void a(ac paramac)
  {
    AppMethodBeat.i(132930);
    bRp().ppQ = paramac;
    AppMethodBeat.o(132930);
  }
  
  public static void a(ae paramae)
  {
    AppMethodBeat.i(132927);
    bRp().ppP = paramae;
    AppMethodBeat.o(132927);
  }
  
  public static void a(af paramaf)
  {
    AppMethodBeat.i(132925);
    bRp().ppO = paramaf;
    AppMethodBeat.o(132925);
  }
  
  public static void a(a parama)
  {
    ppS = parama;
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(241152);
    if (!bRp().ppN.contains(paramb)) {
      bRp().ppN.add(paramb);
    }
    AppMethodBeat.o(241152);
  }
  
  public static void a(ah paramah)
  {
    AppMethodBeat.i(132913);
    bRp().ppK = paramah;
    AppMethodBeat.o(132913);
  }
  
  public static void a(ai paramai)
  {
    AppMethodBeat.i(132915);
    bRp().ppL = paramai;
    AppMethodBeat.o(132915);
  }
  
  public static void a(MMHandler paramMMHandler)
  {
    AppMethodBeat.i(132919);
    bRp().handler = paramMMHandler;
    AppMethodBeat.o(132919);
  }
  
  public static ac bRA()
  {
    AppMethodBeat.i(132929);
    ac localac = bRp().ppQ;
    AppMethodBeat.o(132929);
    return localac;
  }
  
  public static a bRB()
  {
    return ppS;
  }
  
  private static ag bRp()
  {
    AppMethodBeat.i(132907);
    if (ppJ == null) {
      ppJ = new ag();
    }
    ag localag = ppJ;
    AppMethodBeat.o(132907);
    return localag;
  }
  
  private static SharedPreferences bRq()
  {
    AppMethodBeat.i(132908);
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("notify_key_pref_no_account", g.aQe());
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("notify_key_pref_no_account");
    MultiProcessMMKV.transport2MMKV(localSharedPreferences, localMultiProcessMMKV);
    AppMethodBeat.o(132908);
    return localMultiProcessMMKV;
  }
  
  public static SharedPreferences bRr()
  {
    AppMethodBeat.i(132909);
    Object localObject2 = bRq().getString("login_weixin_username", "");
    Object localObject1 = localObject2;
    if (Util.isNullOrNil((String)localObject2))
    {
      localObject2 = bg.okT.aM("login_weixin_username", "");
      localObject1 = localObject2;
      if (!Util.isNullOrNil((String)localObject2))
      {
        bRq().edit().putString("login_weixin_username", (String)localObject2).commit();
        localObject1 = localObject2;
      }
    }
    localObject2 = localObject1;
    if (localObject1 != null) {
      localObject2 = ((String)localObject1).replace("[\\/\\\\]", "#").trim();
    }
    localObject1 = "notify_key_pref".concat(String.valueOf(localObject2));
    localObject2 = MultiProcessMMKV.getMMKV((String)localObject1);
    MultiProcessMMKV.transport2MMKV(MMApplicationContext.getContext().getSharedPreferences((String)localObject1, g.aQe()), (MultiProcessMMKV)localObject2);
    AppMethodBeat.o(132909);
    return localObject2;
  }
  
  public static void bRs()
  {
    AppMethodBeat.i(132910);
    SharedPreferences localSharedPreferences;
    int i;
    if (!hasInit)
    {
      localSharedPreferences = bRr();
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
        break label218;
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
      label218:
      localSharedPreferences.edit().putInt("wakeup_alarm_last_cnt", i + 1).commit();
      Log.i("MicroMsg.MMPushCore", "dealWithOnCreate, add up launch count to:%d", new Object[] { Integer.valueOf(i + 1) });
    }
  }
  
  public static boolean bRt()
  {
    AppMethodBeat.i(132911);
    String str = bg.okT.aM("login_user_name", "");
    Object localObject = str;
    if (str != null) {
      localObject = str.replaceAll("[/\\\\]", "#").trim();
    }
    localObject = MMApplicationContext.getContext().getSharedPreferences("notify_key_pref".concat(String.valueOf(localObject)), g.aQe());
    int i = ((SharedPreferences)localObject).getInt("wakeup_alarm_launch_cnt", 0);
    int j = ((SharedPreferences)localObject).getInt("wakeup_alarm_last_cnt", 0);
    Log.i("MicroMsg.MMPushCore", "isFrequentlyLaunch cnt:%d, thisCnt:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if (i > 10)
    {
      i = 1;
      if (j <= 10) {
        break label134;
      }
    }
    label134:
    for (j = 1;; j = 0)
    {
      AppMethodBeat.o(132911);
      return j | i;
      i = 0;
      break;
    }
  }
  
  public static ah bRu()
  {
    AppMethodBeat.i(132912);
    ah localah = bRp().ppK;
    AppMethodBeat.o(132912);
    return localah;
  }
  
  public static ai bRv()
  {
    AppMethodBeat.i(132914);
    ai localai = bRp().ppL;
    AppMethodBeat.o(132914);
    return localai;
  }
  
  public static boolean bRw()
  {
    AppMethodBeat.i(241149);
    boolean bool = bRp().ppN.isEmpty();
    AppMethodBeat.o(241149);
    return bool;
  }
  
  public static w bRx()
  {
    AppMethodBeat.i(132922);
    w localw = bRp().lre;
    AppMethodBeat.o(132922);
    return localw;
  }
  
  public static af bRy()
  {
    AppMethodBeat.i(132924);
    af localaf = bRp().ppO;
    AppMethodBeat.o(132924);
    return localaf;
  }
  
  public static ae bRz()
  {
    AppMethodBeat.i(132926);
    ae localae = bRp().ppP;
    AppMethodBeat.o(132926);
    return localae;
  }
  
  public static void g(w paramw)
  {
    AppMethodBeat.i(132923);
    bRp().lre = paramw;
    AppMethodBeat.o(132923);
  }
  
  public static Context getContext()
  {
    AppMethodBeat.i(132916);
    Context localContext = bRp().ppM;
    AppMethodBeat.o(132916);
    return localContext;
  }
  
  public static MMHandler getHandler()
  {
    AppMethodBeat.i(132918);
    MMHandler localMMHandler = bRp().handler;
    AppMethodBeat.o(132918);
    return localMMHandler;
  }
  
  public static void hD(boolean paramBoolean)
  {
    AppMethodBeat.i(241147);
    Iterator localIterator = bRp().ppN.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).er(paramBoolean);
    }
    AppMethodBeat.o(241147);
  }
  
  public static void setContext(Context paramContext)
  {
    AppMethodBeat.i(132917);
    bRp().ppM = paramContext;
    AppMethodBeat.o(132917);
  }
  
  public static abstract interface a
  {
    public abstract void I(int paramInt, long paramLong);
    
    public abstract void N(String paramString, long paramLong);
  }
  
  public static abstract interface b
  {
    public abstract void er(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.network.ag
 * JD-Core Version:    0.7.0.1
 */