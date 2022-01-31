package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.af;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import java.util.HashMap;
import java.util.Map;

public final class u
{
  private static Map<String, Long> fqa;
  private static Map<String, Long> fqb;
  private static Map<String, Long> fqc;
  private static Map<String, Long> fqd;
  private static Map<String, u.a> fqe;
  
  static
  {
    AppMethodBeat.i(70641);
    fqa = new HashMap();
    fqb = new HashMap();
    fqc = new HashMap();
    fqd = new HashMap();
    fqe = new HashMap();
    AppMethodBeat.o(70641);
  }
  
  public static void C(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(70639);
    ab.i("SearchWidgetStartTrace", "drawEnd %s,succ %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      if (fqa.containsKey(paramString)) {}
      for (long l = ((Long)fqa.get(paramString)).longValue(); l > 0L; l = 0L)
      {
        System.currentTimeMillis();
        AppMethodBeat.o(70639);
        return;
      }
      ab.e("SearchWidgetStartTrace", "can't find widget Recv timestamp for appid %s", new Object[] { paramString });
    }
    AppMethodBeat.o(70639);
  }
  
  public static void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(70631);
    u.a locala2 = (u.a)fqe.get(paramString1);
    u.a locala1 = locala2;
    if (locala2 == null) {
      locala1 = new u.a();
    }
    locala1.cwc = paramString2;
    locala1.fmF = paramInt1;
    locala1.fqg = paramInt2;
    locala1.fqf = paramString3;
    fqe.put(paramString1, locala1);
    AppMethodBeat.o(70631);
  }
  
  public static void acx()
  {
    AppMethodBeat.i(70640);
    ab.i("SearchWidgetStartTrace", "hasInitData %s", new Object[] { Boolean.TRUE });
    AppMethodBeat.o(70640);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(70637);
    ab.e("SearchWidgetStartTrace", "widget trace - " + paramString1 + "-" + paramString2, paramVarArgs);
    AppMethodBeat.o(70637);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(70636);
    ab.i("SearchWidgetStartTrace", "widget trace - " + paramString1 + "-" + paramString2, paramVarArgs);
    AppMethodBeat.o(70636);
  }
  
  public static void ql(String paramString)
  {
    AppMethodBeat.i(70630);
    Object localObject = (u.a)fqe.get(paramString);
    if (localObject != null)
    {
      if (((u.a)localObject).fqh)
      {
        i("SearchWidgetStartTrace", "do not report draw succ agagin", new Object[0]);
        AppMethodBeat.o(70630);
        return;
      }
      ((u.a)localObject).fqh = true;
    }
    v.kS(20);
    localObject = new af().fB(qn(paramString));
    ((af)localObject).cUl = qm(paramString);
    ((af)localObject).cUh = 12L;
    ((af)localObject).cUj = 1L;
    paramString = ((af)localObject).fA(paramString);
    paramString.cUi = System.currentTimeMillis();
    paramString.fC(at.gU(ah.getContext())).ake();
    AppMethodBeat.o(70630);
  }
  
  public static int qm(String paramString)
  {
    AppMethodBeat.i(70632);
    paramString = (u.a)fqe.get(paramString);
    if (paramString != null)
    {
      int i = paramString.fmF;
      AppMethodBeat.o(70632);
      return i;
    }
    AppMethodBeat.o(70632);
    return 0;
  }
  
  public static String qn(String paramString)
  {
    AppMethodBeat.i(70633);
    u.a locala = (u.a)fqe.get(paramString);
    if (locala != null)
    {
      paramString = locala.fqf;
      AppMethodBeat.o(70633);
      return paramString;
    }
    AppMethodBeat.o(70633);
    return paramString;
  }
  
  public static int qo(String paramString)
  {
    AppMethodBeat.i(70634);
    paramString = (u.a)fqe.get(paramString);
    if (paramString != null)
    {
      int i = paramString.fqg;
      AppMethodBeat.o(70634);
      return i;
    }
    AppMethodBeat.o(70634);
    return 0;
  }
  
  public static void qp(String paramString)
  {
    AppMethodBeat.i(70638);
    ab.i("SearchWidgetStartTrace", "realInsert %s", new Object[] { paramString });
    AppMethodBeat.o(70638);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    AppMethodBeat.i(70635);
    ab.i("SearchWidgetStartTrace", "widget trace - " + paramString1 + "-" + paramString2, paramVarArgs);
    AppMethodBeat.o(70635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.u
 * JD-Core Version:    0.7.0.1
 */