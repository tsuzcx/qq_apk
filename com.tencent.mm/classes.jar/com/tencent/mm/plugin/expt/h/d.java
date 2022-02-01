package com.tencent.mm.plugin.expt.h;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.b.h;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;

public final class d
{
  private static String TAG;
  private static d rjM;
  private static final f<Integer, Long> rjN;
  private String name;
  private f<Integer, c> riw;
  
  static
  {
    AppMethodBeat.i(196728);
    TAG = "MicroMsg.ExptManager";
    rjN = new h(50);
    AppMethodBeat.o(196728);
  }
  
  protected d()
  {
    AppMethodBeat.i(156049);
    this.riw = new h(50);
    this.name = null;
    AppMethodBeat.o(156049);
  }
  
  public static boolean DO(int paramInt)
  {
    AppMethodBeat.i(182039);
    ay localay = ay.aRW("WxExptConfig");
    if (localay != null)
    {
      boolean bool = localay.putInt("expt_uin", paramInt).commit();
      AppMethodBeat.o(182039);
      return bool;
    }
    AppMethodBeat.o(182039);
    return false;
  }
  
  private c DP(int paramInt)
  {
    AppMethodBeat.i(156052);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(156052);
      return null;
    }
    Object localObject = bOc();
    if (localObject == null)
    {
      AppMethodBeat.o(156052);
      return null;
    }
    String str = ((ay)localObject).getString(String.valueOf(paramInt), "");
    if (bu.isNullOrNil(str))
    {
      AppMethodBeat.o(156052);
      return null;
    }
    localObject = (c)this.riw.get(Integer.valueOf(paramInt));
    if (localObject != null)
    {
      if (bu.lX(str, ((c)localObject).field_exptContent))
      {
        AppMethodBeat.o(156052);
        return localObject;
      }
      this.riw.remove(Integer.valueOf(paramInt));
    }
    localObject = new c();
    if (((c)localObject).agx(str)) {
      this.riw.put(Integer.valueOf(paramInt), localObject);
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
    AppMethodBeat.i(196727);
    String str = String.format("%d,%d,%d,%d,%d,%s,%s", new Object[] { Integer.valueOf(paramc.field_exptId), Integer.valueOf(paramc.field_groupId), Integer.valueOf(paramc.field_exptSeq), Long.valueOf(paramc.field_startTime), Long.valueOf(paramc.field_endTime), paramString1, paramString2 });
    int i = str.hashCode();
    Long localLong = (Long)rjN.get(Integer.valueOf(i));
    if (localLong != null) {}
    for (long l = localLong.longValue();; l = 0L)
    {
      if (bu.DD(l) < 300000L)
      {
        ae.v(TAG, "clock report [%s] less than 5 min, don't report", new Object[] { str });
        AppMethodBeat.o(196727);
        return false;
      }
      rjN.put(Integer.valueOf(i), Long.valueOf(bu.fpO()));
      e.ywz.f(15452, new Object[] { Integer.valueOf(paramc.field_exptId), Integer.valueOf(paramc.field_groupId), Integer.valueOf(paramc.field_exptSeq), Long.valueOf(paramc.field_startTime), Long.valueOf(paramc.field_endTime), paramString1, paramString2 });
      AppMethodBeat.o(196727);
      return true;
    }
  }
  
  private int agy(String paramString)
  {
    AppMethodBeat.i(156051);
    ay localay = bOc();
    if (localay == null)
    {
      AppMethodBeat.o(156051);
      return -1;
    }
    int i = localay.getInt(paramString, -1);
    AppMethodBeat.o(156051);
    return i;
  }
  
  public static d ctr()
  {
    AppMethodBeat.i(156048);
    if (rjM == null) {
      rjM = new d();
    }
    d locald = rjM;
    AppMethodBeat.o(156048);
    return locald;
  }
  
  public static int getUin()
  {
    AppMethodBeat.i(182040);
    int i = ak.getContext().getSharedPreferences("system_config_prefs", g.abv()).getInt("default_uin", 0);
    if (i != 0)
    {
      AppMethodBeat.o(182040);
      return i;
    }
    ay localay = ay.aRW("WxExptConfig");
    if (localay != null)
    {
      i = localay.getInt("expt_uin", 0);
      AppMethodBeat.o(182040);
      return i;
    }
    AppMethodBeat.o(182040);
    return 0;
  }
  
  private String info()
  {
    AppMethodBeat.i(156056);
    String str = hashCode();
    AppMethodBeat.o(156056);
    return str;
  }
  
  public final String b(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(156054);
    Object localObject1 = new PString();
    if (b.ctb().a(paramString1, paramString2, (PString)localObject1) > 0)
    {
      paramString1 = ((PString)localObject1).value;
      AppMethodBeat.o(156054);
      return paramString1;
    }
    long l = bu.HQ();
    int i = agy(paramString1);
    Object localObject2;
    if (i > 0)
    {
      c localc = DP(i);
      if ((localc != null) && (localc.isReady()))
      {
        localObject1 = localc.cta();
        if ((localObject1 != null) && (!((HashMap)localObject1).isEmpty()))
        {
          localObject2 = (String)((HashMap)localObject1).get(paramString1);
          if (!paramBoolean1)
          {
            localObject1 = localObject2;
            if (!localc.ctn()) {}
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
        ae.i(TAG, "%s get mulit expt result[%s] key[%s] def[%s] cost[%d]", new Object[] { info(), localObject2, paramString1, paramString2, Long.valueOf(bu.aO(l)) });
      }
      AppMethodBeat.o(156054);
      return localObject2;
    }
  }
  
  public final ay bOc()
  {
    AppMethodBeat.i(156050);
    int i = getUin();
    if (i == 0)
    {
      AppMethodBeat.o(156050);
      return null;
    }
    Object localObject = i + "_WxExptmmkv";
    if (!bu.lX(this.name, (String)localObject))
    {
      ae.i(TAG, "%s get mmkv change uin old[%s] new[%s]", new Object[] { info(), this.name, localObject });
      this.name = ((String)localObject);
    }
    localObject = ay.aRW(this.name);
    AppMethodBeat.o(156050);
    return localObject;
  }
  
  public final String gg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(156053);
    paramString1 = b(paramString1, paramString2, false, true);
    AppMethodBeat.o(156053);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.h.d
 * JD-Core Version:    0.7.0.1
 */