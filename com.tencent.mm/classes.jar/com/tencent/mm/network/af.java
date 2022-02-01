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

public final class af
{
  private static boolean hasInit = false;
  private static af mwk;
  private static boolean mws = false;
  private static a mwt = null;
  private MMHandler handler;
  private v iPi;
  private ag mwl;
  private ah mwm;
  private Context mwn;
  private List<b> mwo;
  private ae mwp;
  private ad mwq;
  private ab mwr;
  
  private af()
  {
    AppMethodBeat.i(194973);
    this.mwo = new ArrayList();
    AppMethodBeat.o(194973);
  }
  
  public static void a(ab paramab)
  {
    AppMethodBeat.i(132930);
    btL().mwr = paramab;
    AppMethodBeat.o(132930);
  }
  
  public static void a(ad paramad)
  {
    AppMethodBeat.i(132927);
    btL().mwq = paramad;
    AppMethodBeat.o(132927);
  }
  
  public static void a(ae paramae)
  {
    AppMethodBeat.i(132925);
    btL().mwp = paramae;
    AppMethodBeat.o(132925);
  }
  
  public static void a(a parama)
  {
    mwt = parama;
  }
  
  public static void a(b paramb)
  {
    AppMethodBeat.i(195007);
    if (!btL().mwo.contains(paramb)) {
      btL().mwo.add(paramb);
    }
    AppMethodBeat.o(195007);
  }
  
  public static void a(ag paramag)
  {
    AppMethodBeat.i(132913);
    btL().mwl = paramag;
    AppMethodBeat.o(132913);
  }
  
  public static void a(ah paramah)
  {
    AppMethodBeat.i(132915);
    btL().mwm = paramah;
    AppMethodBeat.o(132915);
  }
  
  public static void a(MMHandler paramMMHandler)
  {
    AppMethodBeat.i(132919);
    btL().handler = paramMMHandler;
    AppMethodBeat.o(132919);
  }
  
  private static af btL()
  {
    AppMethodBeat.i(132907);
    if (mwk == null) {
      mwk = new af();
    }
    af localaf = mwk;
    AppMethodBeat.o(132907);
    return localaf;
  }
  
  private static SharedPreferences btM()
  {
    AppMethodBeat.i(132908);
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("notify_key_pref_no_account", g.avK());
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("notify_key_pref_no_account");
    MultiProcessMMKV.transport2MMKV(localSharedPreferences, localMultiProcessMMKV);
    AppMethodBeat.o(132908);
    return localMultiProcessMMKV;
  }
  
  public static SharedPreferences btN()
  {
    AppMethodBeat.i(132909);
    Object localObject2 = btM().getString("login_weixin_username", "");
    Object localObject1 = localObject2;
    if (Util.isNullOrNil((String)localObject2))
    {
      localObject2 = bg.ltv.aD("login_weixin_username", "");
      localObject1 = localObject2;
      if (!Util.isNullOrNil((String)localObject2))
      {
        btM().edit().putString("login_weixin_username", (String)localObject2).commit();
        localObject1 = localObject2;
      }
    }
    localObject2 = localObject1;
    if (localObject1 != null) {
      localObject2 = ((String)localObject1).replace("[\\/\\\\]", "#").trim();
    }
    localObject1 = "notify_key_pref".concat(String.valueOf(localObject2));
    localObject2 = MultiProcessMMKV.getMMKV((String)localObject1);
    MultiProcessMMKV.transport2MMKV(MMApplicationContext.getContext().getSharedPreferences((String)localObject1, g.avK()), (MultiProcessMMKV)localObject2);
    AppMethodBeat.o(132909);
    return localObject2;
  }
  
  public static void btO()
  {
    AppMethodBeat.i(132910);
    SharedPreferences localSharedPreferences;
    int i;
    if (!hasInit)
    {
      localSharedPreferences = btN();
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
  
  public static boolean btP()
  {
    AppMethodBeat.i(132911);
    String str = bg.ltv.aD("login_user_name", "");
    Object localObject = str;
    if (str != null) {
      localObject = str.replaceAll("[/\\\\]", "#").trim();
    }
    localObject = MMApplicationContext.getContext().getSharedPreferences("notify_key_pref".concat(String.valueOf(localObject)), g.avK());
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
  
  public static ag btQ()
  {
    AppMethodBeat.i(132912);
    ag localag = btL().mwl;
    AppMethodBeat.o(132912);
    return localag;
  }
  
  public static ah btR()
  {
    AppMethodBeat.i(132914);
    ah localah = btL().mwm;
    AppMethodBeat.o(132914);
    return localah;
  }
  
  public static MMHandler btS()
  {
    AppMethodBeat.i(132918);
    MMHandler localMMHandler = btL().handler;
    AppMethodBeat.o(132918);
    return localMMHandler;
  }
  
  public static boolean btT()
  {
    AppMethodBeat.i(195006);
    boolean bool = btL().mwo.isEmpty();
    AppMethodBeat.o(195006);
    return bool;
  }
  
  public static v btU()
  {
    AppMethodBeat.i(132922);
    v localv = btL().iPi;
    AppMethodBeat.o(132922);
    return localv;
  }
  
  public static ae btV()
  {
    AppMethodBeat.i(132924);
    ae localae = btL().mwp;
    AppMethodBeat.o(132924);
    return localae;
  }
  
  public static ad btW()
  {
    AppMethodBeat.i(132926);
    ad localad = btL().mwq;
    AppMethodBeat.o(132926);
    return localad;
  }
  
  public static ab btX()
  {
    AppMethodBeat.i(132929);
    ab localab = btL().mwr;
    AppMethodBeat.o(132929);
    return localab;
  }
  
  public static a btY()
  {
    return mwt;
  }
  
  public static void g(v paramv)
  {
    AppMethodBeat.i(132923);
    btL().iPi = paramv;
    AppMethodBeat.o(132923);
  }
  
  public static void gO(boolean paramBoolean)
  {
    AppMethodBeat.i(195003);
    Iterator localIterator = btL().mwo.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).dF(paramBoolean);
    }
    AppMethodBeat.o(195003);
  }
  
  public static Context getContext()
  {
    AppMethodBeat.i(132916);
    Context localContext = btL().mwn;
    AppMethodBeat.o(132916);
    return localContext;
  }
  
  public static void setContext(Context paramContext)
  {
    AppMethodBeat.i(132917);
    btL().mwn = paramContext;
    AppMethodBeat.o(132917);
  }
  
  public static abstract interface a
  {
    public abstract void F(int paramInt, long paramLong);
    
    public abstract void J(String paramString, long paramLong);
  }
  
  public static abstract interface b
  {
    public abstract void dF(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.network.af
 * JD-Core Version:    0.7.0.1
 */