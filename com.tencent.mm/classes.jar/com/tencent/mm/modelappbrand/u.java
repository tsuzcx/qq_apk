package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.do;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import java.util.HashMap;
import java.util.Map;

public final class u
{
  private static Map<String, Long> hsf;
  private static Map<String, Long> hsg;
  private static Map<String, Long> hsh;
  private static Map<String, Long> hsi;
  private static Map<String, a> hsj;
  
  static
  {
    AppMethodBeat.i(76390);
    hsf = new HashMap();
    hsg = new HashMap();
    hsh = new HashMap();
    hsi = new HashMap();
    hsj = new HashMap();
    AppMethodBeat.o(76390);
  }
  
  public static void I(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(76388);
    ac.i("SearchWidgetStartTrace", "drawEnd %s,succ %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      if (hsf.containsKey(paramString)) {}
      for (long l = ((Long)hsf.get(paramString)).longValue(); l > 0L; l = 0L)
      {
        System.currentTimeMillis();
        AppMethodBeat.o(76388);
        return;
      }
      ac.e("SearchWidgetStartTrace", "can't find widget Recv timestamp for appid %s", new Object[] { paramString });
    }
    AppMethodBeat.o(76388);
  }
  
  public static void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(76379);
    a locala2 = (a)hsj.get(paramString1);
    a locala1 = locala2;
    if (locala2 == null) {
      locala1 = new a();
    }
    locala1.djj = paramString2;
    locala1.cFI = paramInt1;
    locala1.hsl = paramInt2;
    locala1.hsk = paramString3;
    hsj.put(paramString1, locala1);
    AppMethodBeat.o(76379);
  }
  
  public static void aAM()
  {
    AppMethodBeat.i(76389);
    ac.i("SearchWidgetStartTrace", "hasInitData %s", new Object[] { Boolean.TRUE });
    AppMethodBeat.o(76389);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(76386);
    ac.e("SearchWidgetStartTrace", "widget trace - " + paramString1 + "-" + paramString2, paramVarArgs);
    AppMethodBeat.o(76386);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(76385);
    ac.i("SearchWidgetStartTrace", "widget trace - " + paramString1 + "-" + paramString2, paramVarArgs);
    AppMethodBeat.o(76385);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(76384);
    ac.i("SearchWidgetStartTrace", "widget trace - " + paramString1 + "-" + paramString2, paramVarArgs);
    AppMethodBeat.o(76384);
  }
  
  public static void zg(String paramString)
  {
    AppMethodBeat.i(76378);
    Object localObject = (a)hsj.get(paramString);
    if (localObject != null)
    {
      if (((a)localObject).hsm)
      {
        i("SearchWidgetStartTrace", "do not report draw succ agagin", new Object[0]);
        AppMethodBeat.o(76378);
        return;
      }
      ((a)localObject).hsm = true;
    }
    v.lA(20);
    localObject = new do().ly(zj(paramString));
    ((do)localObject).dSn = zh(paramString);
    ((do)localObject).dSk = 12L;
    ((do)localObject).dSm = 1L;
    paramString = ((do)localObject).lx(paramString);
    paramString.dSl = System.currentTimeMillis();
    paramString.lz(ax.iH(ai.getContext())).aHZ();
    AppMethodBeat.o(76378);
  }
  
  public static int zh(String paramString)
  {
    AppMethodBeat.i(76380);
    paramString = (a)hsj.get(paramString);
    if (paramString != null)
    {
      int i = paramString.cFI;
      AppMethodBeat.o(76380);
      return i;
    }
    AppMethodBeat.o(76380);
    return 0;
  }
  
  public static boolean zi(String paramString)
  {
    AppMethodBeat.i(76381);
    boolean bool = hsj.containsKey(paramString);
    AppMethodBeat.o(76381);
    return bool;
  }
  
  public static String zj(String paramString)
  {
    AppMethodBeat.i(76382);
    a locala = (a)hsj.get(paramString);
    if (locala != null)
    {
      paramString = locala.hsk;
      AppMethodBeat.o(76382);
      return paramString;
    }
    AppMethodBeat.o(76382);
    return paramString;
  }
  
  public static int zk(String paramString)
  {
    AppMethodBeat.i(76383);
    paramString = (a)hsj.get(paramString);
    if (paramString != null)
    {
      int i = paramString.hsl;
      AppMethodBeat.o(76383);
      return i;
    }
    AppMethodBeat.o(76383);
    return 0;
  }
  
  public static void zl(String paramString)
  {
    AppMethodBeat.i(76387);
    ac.i("SearchWidgetStartTrace", "realInsert %s", new Object[] { paramString });
    AppMethodBeat.o(76387);
  }
  
  public static final class a
  {
    public int cFI;
    public String djj;
    public String hsk;
    public int hsl;
    public boolean hsm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.u
 * JD-Core Version:    0.7.0.1
 */