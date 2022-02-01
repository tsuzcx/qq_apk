package com.tencent.mm.plugin.expt.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.h;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public final class d
{
  private static String TAG;
  private static d zNm;
  private static final com.tencent.mm.b.f<Integer, Long> zNn;
  private String name;
  private com.tencent.mm.b.f<Integer, c> zMa;
  
  static
  {
    AppMethodBeat.i(299524);
    TAG = "MicroMsg.ExptManager";
    zNn = new h(50);
    AppMethodBeat.o(299524);
  }
  
  protected d()
  {
    AppMethodBeat.i(156049);
    this.zMa = new h(50);
    this.name = null;
    AppMethodBeat.o(156049);
  }
  
  public static boolean Mi(int paramInt)
  {
    AppMethodBeat.i(182039);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("WxExptConfig");
    if (localMultiProcessMMKV != null)
    {
      boolean bool = localMultiProcessMMKV.putInt("expt_uin", paramInt).commit();
      AppMethodBeat.o(182039);
      return bool;
    }
    AppMethodBeat.o(182039);
    return false;
  }
  
  private c Mj(int paramInt)
  {
    AppMethodBeat.i(156052);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(156052);
      return null;
    }
    Object localObject = atj();
    if (localObject == null)
    {
      AppMethodBeat.o(156052);
      return null;
    }
    String str = ((MultiProcessMMKV)localObject).getString(String.valueOf(paramInt), "");
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(156052);
      return null;
    }
    localObject = (c)this.zMa.get(Integer.valueOf(paramInt));
    if (localObject != null)
    {
      if (Util.isEqual(str, ((c)localObject).field_exptContent))
      {
        AppMethodBeat.o(156052);
        return localObject;
      }
      this.zMa.remove(Integer.valueOf(paramInt));
    }
    localObject = new c();
    if (((c)localObject).TZ(str)) {
      this.zMa.put(Integer.valueOf(paramInt), localObject);
    }
    for (;;)
    {
      AppMethodBeat.o(156052);
      return localObject;
      localObject = null;
    }
  }
  
  private static boolean a(c paramc, String paramString1, String paramString2)
  {
    AppMethodBeat.i(299519);
    paramc = String.format("%d,%d,%d,%d,%d,%s,%s", new Object[] { Integer.valueOf(paramc.field_exptId), Integer.valueOf(paramc.field_groupId), Integer.valueOf(paramc.field_exptSeq), Long.valueOf(paramc.field_startTime), Long.valueOf(paramc.field_endTime), paramString1, paramString2 });
    int i = paramc.hashCode();
    paramString1 = (Long)zNn.get(Integer.valueOf(i));
    if (paramString1 != null) {}
    for (long l = paramString1.longValue();; l = 0L)
    {
      if (Util.milliSecondsToNow(l) < 300000L)
      {
        Log.v(TAG, "clock report [%s] less than 5 min, don't report", new Object[] { paramc });
        AppMethodBeat.o(299519);
        return false;
      }
      if (com.tencent.mm.plugin.report.f.Ozc.cH(15452, paramc)) {
        zNn.put(Integer.valueOf(i), Long.valueOf(Util.nowMilliSecond()));
      }
      AppMethodBeat.o(299519);
      return true;
    }
  }
  
  private int atq(String paramString)
  {
    AppMethodBeat.i(156051);
    MultiProcessMMKV localMultiProcessMMKV = atj();
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(156051);
      return -1;
    }
    int i = localMultiProcessMMKV.getInt(paramString, -1);
    AppMethodBeat.o(156051);
    return i;
  }
  
  public static d dNI()
  {
    AppMethodBeat.i(156048);
    if (zNm == null) {
      zNm = new d();
    }
    d locald = zNm;
    AppMethodBeat.o(156048);
    return locald;
  }
  
  public static int getUin()
  {
    AppMethodBeat.i(182040);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("WxExptConfig");
    if (localMultiProcessMMKV != null) {}
    for (int i = localMultiProcessMMKV.getInt("expt_uin", 0); i != 0; i = 0)
    {
      AppMethodBeat.o(182040);
      return i;
    }
    i = MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", g.aQe()).getInt("default_uin", 0);
    AppMethodBeat.o(182040);
    return i;
  }
  
  private String info()
  {
    AppMethodBeat.i(156056);
    String str = hashCode();
    AppMethodBeat.o(156056);
    return str;
  }
  
  public final String a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(156054);
    Object localObject1 = new PString();
    if (b.dNr().a(paramString1, paramString2, (PString)localObject1) > 0)
    {
      paramString1 = ((PString)localObject1).value;
      AppMethodBeat.o(156054);
      return paramString1;
    }
    long l = Util.currentTicks();
    int i = atq(paramString1);
    Object localObject2;
    if (i > 0)
    {
      c localc = Mj(i);
      if ((localc != null) && (localc.isReady()))
      {
        localObject1 = localc.dNo();
        if ((localObject1 != null) && (!((HashMap)localObject1).isEmpty()))
        {
          localObject2 = (String)((HashMap)localObject1).get(paramString1);
          if (!paramBoolean1)
          {
            localObject1 = localObject2;
            if (!localc.dNE()) {}
          }
          else
          {
            a(localc, paramString1, (String)localObject2);
          }
        }
      }
    }
    for (localObject1 = localObject2;; localObject1 = paramString2)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = paramString2;
      }
      if (paramBoolean2) {
        Log.i(TAG, "%s get mulit expt result[%s] key[%s] def[%s] cost[%d]", new Object[] { info(), localObject2, paramString1, paramString2, Long.valueOf(Util.ticksToNow(l)) });
      }
      AppMethodBeat.o(156054);
      return localObject2;
    }
  }
  
  public final MultiProcessMMKV atj()
  {
    AppMethodBeat.i(156050);
    int i = getUin();
    if (i == 0)
    {
      AppMethodBeat.o(156050);
      return null;
    }
    Object localObject = i + "_WxExptmmkv";
    if (!Util.isEqual(this.name, (String)localObject))
    {
      Log.i(TAG, "%s get mmkv change uin old[%s] new[%s]", new Object[] { info(), this.name, localObject });
      this.name = ((String)localObject);
    }
    localObject = MultiProcessMMKV.getMMKV(this.name);
    AppMethodBeat.o(156050);
    return localObject;
  }
  
  public final String hx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(156053);
    paramString1 = a(paramString1, paramString2, false, true);
    AppMethodBeat.o(156053);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.e.d
 * JD-Core Version:    0.7.0.1
 */