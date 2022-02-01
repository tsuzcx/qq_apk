package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.hr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.util.HashMap;
import java.util.Map;

public final class u
{
  private static Map<String, Long> iIv;
  private static Map<String, Long> iIw;
  private static Map<String, Long> iIx;
  private static Map<String, Long> iIy;
  private static Map<String, a> iIz;
  
  static
  {
    AppMethodBeat.i(76390);
    iIv = new HashMap();
    iIw = new HashMap();
    iIx = new HashMap();
    iIy = new HashMap();
    iIz = new HashMap();
    AppMethodBeat.o(76390);
  }
  
  public static void J(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(76388);
    Log.i("SearchWidgetStartTrace", "drawEnd %s,succ %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      if (iIv.containsKey(paramString)) {}
      for (long l = ((Long)iIv.get(paramString)).longValue(); l > 0L; l = 0L)
      {
        System.currentTimeMillis();
        AppMethodBeat.o(76388);
        return;
      }
      Log.e("SearchWidgetStartTrace", "can't find widget Recv timestamp for appid %s", new Object[] { paramString });
    }
    AppMethodBeat.o(76388);
  }
  
  public static void Ls(String paramString)
  {
    AppMethodBeat.i(76378);
    Object localObject = (a)iIz.get(paramString);
    if (localObject != null)
    {
      if (((a)localObject).iIC)
      {
        i("SearchWidgetStartTrace", "do not report draw succ agagin", new Object[0]);
        AppMethodBeat.o(76378);
        return;
      }
      ((a)localObject).iIC = true;
    }
    v.pl(20);
    localObject = new hr().vt(Lv(paramString));
    ((hr)localObject).eBS = Lt(paramString);
    ((hr)localObject).eMi = 12L;
    ((hr)localObject).eMk = 1L;
    paramString = ((hr)localObject).vs(paramString);
    paramString.eMj = System.currentTimeMillis();
    paramString.vu(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).bfK();
    AppMethodBeat.o(76378);
  }
  
  public static int Lt(String paramString)
  {
    AppMethodBeat.i(76380);
    paramString = (a)iIz.get(paramString);
    if (paramString != null)
    {
      int i = paramString.serviceType;
      AppMethodBeat.o(76380);
      return i;
    }
    AppMethodBeat.o(76380);
    return 0;
  }
  
  public static boolean Lu(String paramString)
  {
    AppMethodBeat.i(76381);
    boolean bool = iIz.containsKey(paramString);
    AppMethodBeat.o(76381);
    return bool;
  }
  
  public static String Lv(String paramString)
  {
    AppMethodBeat.i(76382);
    a locala = (a)iIz.get(paramString);
    if (locala != null)
    {
      paramString = locala.iIA;
      AppMethodBeat.o(76382);
      return paramString;
    }
    AppMethodBeat.o(76382);
    return paramString;
  }
  
  public static int Lw(String paramString)
  {
    AppMethodBeat.i(76383);
    paramString = (a)iIz.get(paramString);
    if (paramString != null)
    {
      int i = paramString.iIB;
      AppMethodBeat.o(76383);
      return i;
    }
    AppMethodBeat.o(76383);
    return 0;
  }
  
  public static void Lx(String paramString)
  {
    AppMethodBeat.i(76387);
    Log.i("SearchWidgetStartTrace", "realInsert %s", new Object[] { paramString });
    AppMethodBeat.o(76387);
  }
  
  public static void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(76379);
    a locala2 = (a)iIz.get(paramString1);
    a locala1 = locala2;
    if (locala2 == null) {
      locala1 = new a();
    }
    locala1.dNI = paramString2;
    locala1.serviceType = paramInt1;
    locala1.iIB = paramInt2;
    locala1.iIA = paramString3;
    iIz.put(paramString1, locala1);
    AppMethodBeat.o(76379);
  }
  
  public static void aXS()
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
    public String dNI;
    public String iIA;
    public int iIB;
    public boolean iIC;
    public int serviceType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.u
 * JD-Core Version:    0.7.0.1
 */