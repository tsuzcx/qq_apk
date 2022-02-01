package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.jw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.util.HashMap;
import java.util.Map;

public final class u
{
  private static Map<String, Long> lyA;
  private static Map<String, Long> lyB;
  private static Map<String, a> lyC;
  private static Map<String, Long> lyy;
  private static Map<String, Long> lyz;
  
  static
  {
    AppMethodBeat.i(76390);
    lyy = new HashMap();
    lyz = new HashMap();
    lyA = new HashMap();
    lyB = new HashMap();
    lyC = new HashMap();
    AppMethodBeat.o(76390);
  }
  
  public static void L(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(76388);
    Log.i("SearchWidgetStartTrace", "drawEnd %s,succ %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      if (lyy.containsKey(paramString)) {}
      for (long l = ((Long)lyy.get(paramString)).longValue(); l > 0L; l = 0L)
      {
        System.currentTimeMillis();
        AppMethodBeat.o(76388);
        return;
      }
      Log.e("SearchWidgetStartTrace", "can't find widget Recv timestamp for appid %s", new Object[] { paramString });
    }
    AppMethodBeat.o(76388);
  }
  
  public static void SL(String paramString)
  {
    AppMethodBeat.i(76378);
    Object localObject = (a)lyC.get(paramString);
    if (localObject != null)
    {
      if (((a)localObject).lyF)
      {
        i("SearchWidgetStartTrace", "do not report draw succ agagin", new Object[0]);
        AppMethodBeat.o(76378);
        return;
      }
      ((a)localObject).lyF = true;
    }
    v.rE(20);
    localObject = new jw().AS(SO(paramString));
    ((jw)localObject).gyo = SM(paramString);
    ((jw)localObject).gLX = 12L;
    ((jw)localObject).gLZ = 1L;
    paramString = ((jw)localObject).AR(paramString);
    paramString.gLY = System.currentTimeMillis();
    paramString.AT(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bpa();
    AppMethodBeat.o(76378);
  }
  
  public static int SM(String paramString)
  {
    AppMethodBeat.i(76380);
    paramString = (a)lyC.get(paramString);
    if (paramString != null)
    {
      int i = paramString.serviceType;
      AppMethodBeat.o(76380);
      return i;
    }
    AppMethodBeat.o(76380);
    return 0;
  }
  
  public static boolean SN(String paramString)
  {
    AppMethodBeat.i(76381);
    boolean bool = lyC.containsKey(paramString);
    AppMethodBeat.o(76381);
    return bool;
  }
  
  public static String SO(String paramString)
  {
    AppMethodBeat.i(76382);
    a locala = (a)lyC.get(paramString);
    if (locala != null)
    {
      paramString = locala.lyD;
      AppMethodBeat.o(76382);
      return paramString;
    }
    AppMethodBeat.o(76382);
    return paramString;
  }
  
  public static int SP(String paramString)
  {
    AppMethodBeat.i(76383);
    paramString = (a)lyC.get(paramString);
    if (paramString != null)
    {
      int i = paramString.lyE;
      AppMethodBeat.o(76383);
      return i;
    }
    AppMethodBeat.o(76383);
    return 0;
  }
  
  public static void SQ(String paramString)
  {
    AppMethodBeat.i(76387);
    Log.i("SearchWidgetStartTrace", "realInsert %s", new Object[] { paramString });
    AppMethodBeat.o(76387);
  }
  
  public static void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(76379);
    a locala2 = (a)lyC.get(paramString1);
    a locala1 = locala2;
    if (locala2 == null) {
      locala1 = new a();
    }
    locala1.appid = paramString2;
    locala1.serviceType = paramInt1;
    locala1.lyE = paramInt2;
    locala1.lyD = paramString3;
    lyC.put(paramString1, locala1);
    AppMethodBeat.o(76379);
  }
  
  public static void bhb()
  {
    AppMethodBeat.i(76389);
    Log.i("SearchWidgetStartTrace", "hasInitData %s", new Object[] { Boolean.TRUE });
    AppMethodBeat.o(76389);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(76386);
    Log.e("SearchWidgetStartTrace", "widget trace - " + paramString1 + "-" + paramString2, paramVarArgs);
    AppMethodBeat.o(76386);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(76385);
    Log.i("SearchWidgetStartTrace", "widget trace - " + paramString1 + "-" + paramString2, paramVarArgs);
    AppMethodBeat.o(76385);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(76384);
    Log.i("SearchWidgetStartTrace", "widget trace - " + paramString1 + "-" + paramString2, paramVarArgs);
    AppMethodBeat.o(76384);
  }
  
  public static final class a
  {
    public String appid;
    public String lyD;
    public int lyE;
    public boolean lyF;
    public int serviceType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.u
 * JD-Core Version:    0.7.0.1
 */