package com.tencent.mm.plugin.luckymoney.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.q;
import com.tencent.mm.protocal.protobuf.dvk;
import com.tencent.mm.protocal.protobuf.dvl;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  private static Map<String, q> EsR;
  private static Map<String, dvl> EsS;
  private static Map<Long, dvk> EsT;
  
  static
  {
    AppMethodBeat.i(168789);
    EsR = new HashMap();
    EsS = new HashMap();
    EsT = new HashMap();
    AppMethodBeat.o(168789);
  }
  
  public static void a(Long paramLong, dvk paramdvk)
  {
    AppMethodBeat.i(168785);
    EsT.put(paramLong, paramdvk);
    AppMethodBeat.o(168785);
  }
  
  public static void a(String paramString, q paramq)
  {
    AppMethodBeat.i(168781);
    EsR.put(paramString, paramq);
    AppMethodBeat.o(168781);
  }
  
  public static void a(String paramString, dvl paramdvl)
  {
    AppMethodBeat.i(168783);
    EsS.put(paramString, paramdvl);
    AppMethodBeat.o(168783);
  }
  
  public static q aNx(String paramString)
  {
    AppMethodBeat.i(168782);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(168782);
      return null;
    }
    paramString = (q)EsR.get(paramString);
    AppMethodBeat.o(168782);
    return paramString;
  }
  
  public static dvl aNy(String paramString)
  {
    AppMethodBeat.i(168784);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(168784);
      return null;
    }
    paramString = (dvl)EsS.get(paramString);
    AppMethodBeat.o(168784);
    return paramString;
  }
  
  public static void clear()
  {
    AppMethodBeat.i(168787);
    EsR.clear();
    EsS.clear();
    AppMethodBeat.o(168787);
  }
  
  public static void eNM()
  {
    AppMethodBeat.i(168788);
    EsT.clear();
    AppMethodBeat.o(168788);
  }
  
  public static dvk k(Long paramLong)
  {
    AppMethodBeat.i(168786);
    if (paramLong == null)
    {
      AppMethodBeat.o(168786);
      return null;
    }
    paramLong = (dvk)EsT.get(paramLong);
    AppMethodBeat.o(168786);
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.a.b
 * JD-Core Version:    0.7.0.1
 */