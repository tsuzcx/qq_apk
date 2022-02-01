package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.el;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import java.util.HashMap;
import java.util.Map;

public final class u
{
  private static Map<String, Long> hNq;
  private static Map<String, Long> hNr;
  private static Map<String, Long> hNs;
  private static Map<String, Long> hNt;
  private static Map<String, a> hNu;
  
  static
  {
    AppMethodBeat.i(76390);
    hNq = new HashMap();
    hNr = new HashMap();
    hNs = new HashMap();
    hNt = new HashMap();
    hNu = new HashMap();
    AppMethodBeat.o(76390);
  }
  
  public static void CH(String paramString)
  {
    AppMethodBeat.i(76378);
    Object localObject = (a)hNu.get(paramString);
    if (localObject != null)
    {
      if (((a)localObject).hNx)
      {
        i("SearchWidgetStartTrace", "do not report draw succ agagin", new Object[0]);
        AppMethodBeat.o(76378);
        return;
      }
      ((a)localObject).hNx = true;
    }
    v.md(20);
    localObject = new el().oa(CK(paramString));
    ((el)localObject).ejC = CI(paramString);
    ((el)localObject).ejz = 12L;
    ((el)localObject).ejB = 1L;
    paramString = ((el)localObject).nZ(paramString);
    paramString.ejA = System.currentTimeMillis();
    paramString.ob(az.iW(ak.getContext())).aLH();
    AppMethodBeat.o(76378);
  }
  
  public static int CI(String paramString)
  {
    AppMethodBeat.i(76380);
    paramString = (a)hNu.get(paramString);
    if (paramString != null)
    {
      int i = paramString.cRx;
      AppMethodBeat.o(76380);
      return i;
    }
    AppMethodBeat.o(76380);
    return 0;
  }
  
  public static boolean CJ(String paramString)
  {
    AppMethodBeat.i(76381);
    boolean bool = hNu.containsKey(paramString);
    AppMethodBeat.o(76381);
    return bool;
  }
  
  public static String CK(String paramString)
  {
    AppMethodBeat.i(76382);
    a locala = (a)hNu.get(paramString);
    if (locala != null)
    {
      paramString = locala.hNv;
      AppMethodBeat.o(76382);
      return paramString;
    }
    AppMethodBeat.o(76382);
    return paramString;
  }
  
  public static int CL(String paramString)
  {
    AppMethodBeat.i(76383);
    paramString = (a)hNu.get(paramString);
    if (paramString != null)
    {
      int i = paramString.hNw;
      AppMethodBeat.o(76383);
      return i;
    }
    AppMethodBeat.o(76383);
    return 0;
  }
  
  public static void CM(String paramString)
  {
    AppMethodBeat.i(76387);
    ae.i("SearchWidgetStartTrace", "realInsert %s", new Object[] { paramString });
    AppMethodBeat.o(76387);
  }
  
  public static void I(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(76388);
    ae.i("SearchWidgetStartTrace", "drawEnd %s,succ %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      if (hNq.containsKey(paramString)) {}
      for (long l = ((Long)hNq.get(paramString)).longValue(); l > 0L; l = 0L)
      {
        System.currentTimeMillis();
        AppMethodBeat.o(76388);
        return;
      }
      ae.e("SearchWidgetStartTrace", "can't find widget Recv timestamp for appid %s", new Object[] { paramString });
    }
    AppMethodBeat.o(76388);
  }
  
  public static void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(76379);
    a locala2 = (a)hNu.get(paramString1);
    a locala1 = locala2;
    if (locala2 == null) {
      locala1 = new a();
    }
    locala1.dwb = paramString2;
    locala1.cRx = paramInt1;
    locala1.hNw = paramInt2;
    locala1.hNv = paramString3;
    hNu.put(paramString1, locala1);
    AppMethodBeat.o(76379);
  }
  
  public static void aEf()
  {
    AppMethodBeat.i(76389);
    ae.i("SearchWidgetStartTrace", "hasInitData %s", new Object[] { Boolean.TRUE });
    AppMethodBeat.o(76389);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(76386);
    ae.e("SearchWidgetStartTrace", "widget trace - " + paramString1 + "-" + paramString2, paramVarArgs);
    AppMethodBeat.o(76386);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(76385);
    ae.i("SearchWidgetStartTrace", "widget trace - " + paramString1 + "-" + paramString2, paramVarArgs);
    AppMethodBeat.o(76385);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(76384);
    ae.i("SearchWidgetStartTrace", "widget trace - " + paramString1 + "-" + paramString2, paramVarArgs);
    AppMethodBeat.o(76384);
  }
  
  public static final class a
  {
    public int cRx;
    public String dwb;
    public String hNv;
    public int hNw;
    public boolean hNx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.u
 * JD-Core Version:    0.7.0.1
 */