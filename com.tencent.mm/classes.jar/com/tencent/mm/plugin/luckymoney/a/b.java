package com.tencent.mm.plugin.luckymoney.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.q;
import com.tencent.mm.protocal.protobuf.dls;
import com.tencent.mm.protocal.protobuf.dlt;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  private static Map<String, q> yOT;
  private static Map<String, dlt> yOU;
  private static Map<Long, dls> yOV;
  
  static
  {
    AppMethodBeat.i(168789);
    yOT = new HashMap();
    yOU = new HashMap();
    yOV = new HashMap();
    AppMethodBeat.o(168789);
  }
  
  public static void a(Long paramLong, dls paramdls)
  {
    AppMethodBeat.i(168785);
    yOV.put(paramLong, paramdls);
    AppMethodBeat.o(168785);
  }
  
  public static void a(String paramString, q paramq)
  {
    AppMethodBeat.i(168781);
    yOT.put(paramString, paramq);
    AppMethodBeat.o(168781);
  }
  
  public static void a(String paramString, dlt paramdlt)
  {
    AppMethodBeat.i(168783);
    yOU.put(paramString, paramdlt);
    AppMethodBeat.o(168783);
  }
  
  public static q aDn(String paramString)
  {
    AppMethodBeat.i(168782);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(168782);
      return null;
    }
    paramString = (q)yOT.get(paramString);
    AppMethodBeat.o(168782);
    return paramString;
  }
  
  public static dlt aDo(String paramString)
  {
    AppMethodBeat.i(168784);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(168784);
      return null;
    }
    paramString = (dlt)yOU.get(paramString);
    AppMethodBeat.o(168784);
    return paramString;
  }
  
  public static void clear()
  {
    AppMethodBeat.i(168787);
    yOT.clear();
    yOU.clear();
    AppMethodBeat.o(168787);
  }
  
  public static void ees()
  {
    AppMethodBeat.i(168788);
    yOV.clear();
    AppMethodBeat.o(168788);
  }
  
  public static dls j(Long paramLong)
  {
    AppMethodBeat.i(168786);
    if (paramLong == null)
    {
      AppMethodBeat.o(168786);
      return null;
    }
    paramLong = (dls)yOV.get(paramLong);
    AppMethodBeat.o(168786);
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.a.b
 * JD-Core Version:    0.7.0.1
 */