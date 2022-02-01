package com.tencent.mm.plugin.expt.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.b.h;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;

public final class b
{
  private static String TAG;
  private static b qse;
  private static final f<Integer, Long> qsf;
  private String name;
  private f<Integer, a> qqW;
  
  static
  {
    AppMethodBeat.i(193560);
    TAG = "MicroMsg.ExptManager";
    qsf = new h(50);
    AppMethodBeat.o(193560);
  }
  
  protected b()
  {
    AppMethodBeat.i(156049);
    this.qqW = new h(50);
    this.name = null;
    AppMethodBeat.o(156049);
  }
  
  public static boolean CJ(int paramInt)
  {
    AppMethodBeat.i(182039);
    aw localaw = aw.aKT("WxExptConfig");
    if (localaw != null)
    {
      boolean bool = localaw.putInt("expt_uin", paramInt).commit();
      AppMethodBeat.o(182039);
      return bool;
    }
    AppMethodBeat.o(182039);
    return false;
  }
  
  private a CK(int paramInt)
  {
    AppMethodBeat.i(156052);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(156052);
      return null;
    }
    Object localObject = bJa();
    if (localObject == null)
    {
      AppMethodBeat.o(156052);
      return null;
    }
    String str = ((aw)localObject).getString(String.valueOf(paramInt), "");
    if (bs.isNullOrNil(str))
    {
      AppMethodBeat.o(156052);
      return null;
    }
    localObject = (a)this.qqW.get(Integer.valueOf(paramInt));
    if (localObject != null)
    {
      if (bs.lr(str, ((a)localObject).field_exptContent))
      {
        AppMethodBeat.o(156052);
        return localObject;
      }
      this.qqW.remove(Integer.valueOf(paramInt));
    }
    localObject = new a();
    if (((a)localObject).abN(str)) {
      this.qqW.put(Integer.valueOf(paramInt), localObject);
    }
    for (;;)
    {
      AppMethodBeat.o(156052);
      return localObject;
      localObject = null;
    }
  }
  
  private static boolean a(a parama, String paramString1, String paramString2)
  {
    AppMethodBeat.i(193559);
    String str = String.format("%d,%d,%d,%d,%d,%s,%s", new Object[] { Integer.valueOf(parama.field_exptId), Integer.valueOf(parama.field_groupId), Integer.valueOf(parama.field_exptSeq), Long.valueOf(parama.field_startTime), Long.valueOf(parama.field_endTime), paramString1, paramString2 });
    int i = str.hashCode();
    Long localLong = (Long)qsf.get(Integer.valueOf(i));
    if (localLong != null) {}
    for (long l = localLong.longValue();; l = 0L)
    {
      if (bs.Ap(l) < 300000L)
      {
        ac.v(TAG, "clock report [%s] less than 5 min, don't report", new Object[] { str });
        AppMethodBeat.o(193559);
        return false;
      }
      qsf.put(Integer.valueOf(i), Long.valueOf(bs.eWj()));
      e.wTc.f(15452, new Object[] { Integer.valueOf(parama.field_exptId), Integer.valueOf(parama.field_groupId), Integer.valueOf(parama.field_exptSeq), Long.valueOf(parama.field_startTime), Long.valueOf(parama.field_endTime), paramString1, paramString2 });
      AppMethodBeat.o(193559);
      return true;
    }
  }
  
  private int abP(String paramString)
  {
    AppMethodBeat.i(156051);
    aw localaw = bJa();
    if (localaw == null)
    {
      AppMethodBeat.o(156051);
      return -1;
    }
    int i = localaw.getInt(paramString, -1);
    AppMethodBeat.o(156051);
    return i;
  }
  
  public static b cmk()
  {
    AppMethodBeat.i(156048);
    if (qse == null) {
      qse = new b();
    }
    b localb = qse;
    AppMethodBeat.o(156048);
    return localb;
  }
  
  public static int getUin()
  {
    AppMethodBeat.i(182040);
    int i = ai.getContext().getSharedPreferences("system_config_prefs", g.YK()).getInt("default_uin", 0);
    if (i != 0)
    {
      AppMethodBeat.o(182040);
      return i;
    }
    aw localaw = aw.aKT("WxExptConfig");
    if (localaw != null)
    {
      i = localaw.getInt("expt_uin", 0);
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
    long l = bs.Gn();
    int i = abP(paramString1);
    Object localObject2;
    if (i > 0)
    {
      a locala = CK(i);
      if ((locala != null) && (locala.isReady()))
      {
        localObject1 = locala.cmj();
        if ((localObject1 != null) && (!((HashMap)localObject1).isEmpty()))
        {
          localObject2 = (String)((HashMap)localObject1).get(paramString1);
          if (!paramBoolean1)
          {
            localObject1 = localObject2;
            if (!locala.cmf()) {}
          }
          else
          {
            a(locala, paramString1, (String)localObject2);
          }
        }
      }
    }
    for (Object localObject1 = localObject2;; localObject1 = paramString2)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = paramString2;
      }
      if (paramBoolean2) {
        ac.i(TAG, "%s get mulit expt result[%s] key[%s] def[%s] cost[%d]", new Object[] { info(), localObject2, paramString1, paramString2, Long.valueOf(bs.aO(l)) });
      }
      AppMethodBeat.o(156054);
      return localObject2;
    }
  }
  
  public final aw bJa()
  {
    AppMethodBeat.i(156050);
    int i = getUin();
    if (i == 0)
    {
      AppMethodBeat.o(156050);
      return null;
    }
    Object localObject = i + "_WxExptmmkv";
    if (!bs.lr(this.name, (String)localObject))
    {
      ac.i(TAG, "%s get mmkv change uin old[%s] new[%s]", new Object[] { info(), this.name, localObject });
      this.name = ((String)localObject);
    }
    localObject = aw.aKT(this.name);
    AppMethodBeat.o(156050);
    return localObject;
  }
  
  public final String fS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(156053);
    paramString1 = b(paramString1, paramString2, false, true);
    AppMethodBeat.o(156053);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.e.b
 * JD-Core Version:    0.7.0.1
 */