package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ej;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import java.util.HashMap;
import java.util.Map;

public final class u
{
  private static Map<String, Long> hKA;
  private static Map<String, a> hKB;
  private static Map<String, Long> hKx;
  private static Map<String, Long> hKy;
  private static Map<String, Long> hKz;
  
  static
  {
    AppMethodBeat.i(76390);
    hKx = new HashMap();
    hKy = new HashMap();
    hKz = new HashMap();
    hKA = new HashMap();
    hKB = new HashMap();
    AppMethodBeat.o(76390);
  }
  
  public static void Cf(String paramString)
  {
    AppMethodBeat.i(76378);
    Object localObject = (a)hKB.get(paramString);
    if (localObject != null)
    {
      if (((a)localObject).hKE)
      {
        i("SearchWidgetStartTrace", "do not report draw succ agagin", new Object[0]);
        AppMethodBeat.o(76378);
        return;
      }
      ((a)localObject).hKE = true;
    }
    v.ma(20);
    localObject = new ej().nF(Ci(paramString));
    ((ej)localObject).ehS = Cg(paramString);
    ((ej)localObject).ehP = 12L;
    ((ej)localObject).ehR = 1L;
    paramString = ((ej)localObject).nE(paramString);
    paramString.ehQ = System.currentTimeMillis();
    paramString.nG(ay.iR(aj.getContext())).aLk();
    AppMethodBeat.o(76378);
  }
  
  public static int Cg(String paramString)
  {
    AppMethodBeat.i(76380);
    paramString = (a)hKB.get(paramString);
    if (paramString != null)
    {
      int i = paramString.cQN;
      AppMethodBeat.o(76380);
      return i;
    }
    AppMethodBeat.o(76380);
    return 0;
  }
  
  public static boolean Ch(String paramString)
  {
    AppMethodBeat.i(76381);
    boolean bool = hKB.containsKey(paramString);
    AppMethodBeat.o(76381);
    return bool;
  }
  
  public static String Ci(String paramString)
  {
    AppMethodBeat.i(76382);
    a locala = (a)hKB.get(paramString);
    if (locala != null)
    {
      paramString = locala.hKC;
      AppMethodBeat.o(76382);
      return paramString;
    }
    AppMethodBeat.o(76382);
    return paramString;
  }
  
  public static int Cj(String paramString)
  {
    AppMethodBeat.i(76383);
    paramString = (a)hKB.get(paramString);
    if (paramString != null)
    {
      int i = paramString.hKD;
      AppMethodBeat.o(76383);
      return i;
    }
    AppMethodBeat.o(76383);
    return 0;
  }
  
  public static void Ck(String paramString)
  {
    AppMethodBeat.i(76387);
    ad.i("SearchWidgetStartTrace", "realInsert %s", new Object[] { paramString });
    AppMethodBeat.o(76387);
  }
  
  public static void I(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(76388);
    ad.i("SearchWidgetStartTrace", "drawEnd %s,succ %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      if (hKx.containsKey(paramString)) {}
      for (long l = ((Long)hKx.get(paramString)).longValue(); l > 0L; l = 0L)
      {
        System.currentTimeMillis();
        AppMethodBeat.o(76388);
        return;
      }
      ad.e("SearchWidgetStartTrace", "can't find widget Recv timestamp for appid %s", new Object[] { paramString });
    }
    AppMethodBeat.o(76388);
  }
  
  public static void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(76379);
    a locala2 = (a)hKB.get(paramString1);
    a locala1 = locala2;
    if (locala2 == null) {
      locala1 = new a();
    }
    locala1.duW = paramString2;
    locala1.cQN = paramInt1;
    locala1.hKD = paramInt2;
    locala1.hKC = paramString3;
    hKB.put(paramString1, locala1);
    AppMethodBeat.o(76379);
  }
  
  public static void aDP()
  {
    AppMethodBeat.i(76389);
    ad.i("SearchWidgetStartTrace", "hasInitData %s", new Object[] { Boolean.TRUE });
    AppMethodBeat.o(76389);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(76386);
    ad.e("SearchWidgetStartTrace", "widget trace - " + paramString1 + "-" + paramString2, paramVarArgs);
    AppMethodBeat.o(76386);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(76385);
    ad.i("SearchWidgetStartTrace", "widget trace - " + paramString1 + "-" + paramString2, paramVarArgs);
    AppMethodBeat.o(76385);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(76384);
    ad.i("SearchWidgetStartTrace", "widget trace - " + paramString1 + "-" + paramString2, paramVarArgs);
    AppMethodBeat.o(76384);
  }
  
  public static final class a
  {
    public int cQN;
    public String duW;
    public String hKC;
    public int hKD;
    public boolean hKE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.u
 * JD-Core Version:    0.7.0.1
 */