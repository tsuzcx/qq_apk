package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ca;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import java.util.HashMap;
import java.util.Map;

public final class u
{
  private static Map<String, Long> gRF;
  private static Map<String, Long> gRG;
  private static Map<String, Long> gRH;
  private static Map<String, Long> gRI;
  private static Map<String, a> gRJ;
  
  static
  {
    AppMethodBeat.i(76390);
    gRF = new HashMap();
    gRG = new HashMap();
    gRH = new HashMap();
    gRI = new HashMap();
    gRJ = new HashMap();
    AppMethodBeat.o(76390);
  }
  
  public static void H(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(76388);
    ad.i("SearchWidgetStartTrace", "drawEnd %s,succ %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      if (gRF.containsKey(paramString)) {}
      for (long l = ((Long)gRF.get(paramString)).longValue(); l > 0L; l = 0L)
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
    a locala2 = (a)gRJ.get(paramString1);
    a locala1 = locala2;
    if (locala2 == null) {
      locala1 = new a();
    }
    locala1.dlB = paramString2;
    locala1.cIB = paramInt1;
    locala1.gRL = paramInt2;
    locala1.gRK = paramString3;
    gRJ.put(paramString1, locala1);
    AppMethodBeat.o(76379);
  }
  
  public static void atV()
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
  
  public static void va(String paramString)
  {
    AppMethodBeat.i(76378);
    Object localObject = (a)gRJ.get(paramString);
    if (localObject != null)
    {
      if (((a)localObject).gRM)
      {
        i("SearchWidgetStartTrace", "do not report draw succ agagin", new Object[0]);
        AppMethodBeat.o(76378);
        return;
      }
      ((a)localObject).gRM = true;
    }
    v.lI(20);
    localObject = new ca().iI(vd(paramString));
    ((ca)localObject).dQy = vb(paramString);
    ((ca)localObject).dQv = 12L;
    ((ca)localObject).dQx = 1L;
    paramString = ((ca)localObject).iH(paramString);
    paramString.dQw = System.currentTimeMillis();
    paramString.iJ(ay.iw(aj.getContext())).aBj();
    AppMethodBeat.o(76378);
  }
  
  public static int vb(String paramString)
  {
    AppMethodBeat.i(76380);
    paramString = (a)gRJ.get(paramString);
    if (paramString != null)
    {
      int i = paramString.cIB;
      AppMethodBeat.o(76380);
      return i;
    }
    AppMethodBeat.o(76380);
    return 0;
  }
  
  public static boolean vc(String paramString)
  {
    AppMethodBeat.i(76381);
    boolean bool = gRJ.containsKey(paramString);
    AppMethodBeat.o(76381);
    return bool;
  }
  
  public static String vd(String paramString)
  {
    AppMethodBeat.i(76382);
    a locala = (a)gRJ.get(paramString);
    if (locala != null)
    {
      paramString = locala.gRK;
      AppMethodBeat.o(76382);
      return paramString;
    }
    AppMethodBeat.o(76382);
    return paramString;
  }
  
  public static int ve(String paramString)
  {
    AppMethodBeat.i(76383);
    paramString = (a)gRJ.get(paramString);
    if (paramString != null)
    {
      int i = paramString.gRL;
      AppMethodBeat.o(76383);
      return i;
    }
    AppMethodBeat.o(76383);
    return 0;
  }
  
  public static void vf(String paramString)
  {
    AppMethodBeat.i(76387);
    ad.i("SearchWidgetStartTrace", "realInsert %s", new Object[] { paramString });
    AppMethodBeat.o(76387);
  }
  
  public static final class a
  {
    public int cIB;
    public String dlB;
    public String gRK;
    public int gRL;
    public boolean gRM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.u
 * JD-Core Version:    0.7.0.1
 */