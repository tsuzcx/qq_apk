package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.mn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.util.HashMap;
import java.util.Map;

public final class u
{
  private static Map<String, Long> opZ;
  private static Map<String, Long> oqa;
  private static Map<String, Long> oqb;
  private static Map<String, Long> oqc;
  private static Map<String, a> oqd;
  
  static
  {
    AppMethodBeat.i(76390);
    opZ = new HashMap();
    oqa = new HashMap();
    oqb = new HashMap();
    oqc = new HashMap();
    oqd = new HashMap();
    AppMethodBeat.o(76390);
  }
  
  public static void KN(String paramString)
  {
    AppMethodBeat.i(76378);
    Object localObject = (a)oqd.get(paramString);
    if (localObject != null)
    {
      if (((a)localObject).oqg)
      {
        i("SearchWidgetStartTrace", "do not report draw succ agagin", new Object[0]);
        AppMethodBeat.o(76378);
        return;
      }
      ((a)localObject).oqg = true;
    }
    v.rG(20);
    localObject = new mn().uY(KQ(paramString));
    ((mn)localObject).iKD = KO(paramString);
    ((mn)localObject).jbJ = 12L;
    ((mn)localObject).jbL = 1L;
    paramString = ((mn)localObject).uX(paramString);
    paramString.jbK = System.currentTimeMillis();
    paramString.uZ(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bMH();
    AppMethodBeat.o(76378);
  }
  
  public static int KO(String paramString)
  {
    AppMethodBeat.i(76380);
    paramString = (a)oqd.get(paramString);
    if (paramString != null)
    {
      int i = paramString.serviceType;
      AppMethodBeat.o(76380);
      return i;
    }
    AppMethodBeat.o(76380);
    return 0;
  }
  
  public static boolean KP(String paramString)
  {
    AppMethodBeat.i(76381);
    boolean bool = oqd.containsKey(paramString);
    AppMethodBeat.o(76381);
    return bool;
  }
  
  public static String KQ(String paramString)
  {
    AppMethodBeat.i(76382);
    a locala = (a)oqd.get(paramString);
    if (locala != null)
    {
      paramString = locala.oqe;
      AppMethodBeat.o(76382);
      return paramString;
    }
    AppMethodBeat.o(76382);
    return paramString;
  }
  
  public static int KR(String paramString)
  {
    AppMethodBeat.i(76383);
    paramString = (a)oqd.get(paramString);
    if (paramString != null)
    {
      int i = paramString.oqf;
      AppMethodBeat.o(76383);
      return i;
    }
    AppMethodBeat.o(76383);
    return 0;
  }
  
  public static void KS(String paramString)
  {
    AppMethodBeat.i(76387);
    Log.i("SearchWidgetStartTrace", "realInsert %s", new Object[] { paramString });
    AppMethodBeat.o(76387);
  }
  
  public static void P(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(76388);
    Log.i("SearchWidgetStartTrace", "drawEnd %s,succ %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      if (opZ.containsKey(paramString)) {}
      for (long l = ((Long)opZ.get(paramString)).longValue(); l > 0L; l = 0L)
      {
        System.currentTimeMillis();
        AppMethodBeat.o(76388);
        return;
      }
      Log.e("SearchWidgetStartTrace", "can't find widget Recv timestamp for appid %s", new Object[] { paramString });
    }
    AppMethodBeat.o(76388);
  }
  
  public static void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(76379);
    a locala2 = (a)oqd.get(paramString1);
    a locala1 = locala2;
    if (locala2 == null) {
      locala1 = new a();
    }
    locala1.appid = paramString2;
    locala1.serviceType = paramInt1;
    locala1.oqf = paramInt2;
    locala1.oqe = paramString3;
    oqd.put(paramString1, locala1);
    AppMethodBeat.o(76379);
  }
  
  public static void bES()
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
    public String oqe;
    public int oqf;
    public boolean oqg;
    public int serviceType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.u
 * JD-Core Version:    0.7.0.1
 */