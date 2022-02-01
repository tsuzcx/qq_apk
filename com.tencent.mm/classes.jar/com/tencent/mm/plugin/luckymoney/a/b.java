package com.tencent.mm.plugin.luckymoney.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.l;
import com.tencent.mm.protocal.protobuf.ctc;
import com.tencent.mm.protocal.protobuf.ctd;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  private static Map<String, l> vuJ;
  private static Map<String, ctd> vuK;
  private static Map<Long, ctc> vuL;
  
  static
  {
    AppMethodBeat.i(168789);
    vuJ = new HashMap();
    vuK = new HashMap();
    vuL = new HashMap();
    AppMethodBeat.o(168789);
  }
  
  public static void a(Long paramLong, ctc paramctc)
  {
    AppMethodBeat.i(168785);
    vuL.put(paramLong, paramctc);
    AppMethodBeat.o(168785);
  }
  
  public static void a(String paramString, l paraml)
  {
    AppMethodBeat.i(168781);
    vuJ.put(paramString, paraml);
    AppMethodBeat.o(168781);
  }
  
  public static void a(String paramString, ctd paramctd)
  {
    AppMethodBeat.i(168783);
    vuK.put(paramString, paramctd);
    AppMethodBeat.o(168783);
  }
  
  public static l apU(String paramString)
  {
    AppMethodBeat.i(168782);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(168782);
      return null;
    }
    paramString = (l)vuJ.get(paramString);
    AppMethodBeat.o(168782);
    return paramString;
  }
  
  public static ctd apV(String paramString)
  {
    AppMethodBeat.i(168784);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(168784);
      return null;
    }
    paramString = (ctd)vuK.get(paramString);
    AppMethodBeat.o(168784);
    return paramString;
  }
  
  public static void clear()
  {
    AppMethodBeat.i(168787);
    vuJ.clear();
    vuK.clear();
    AppMethodBeat.o(168787);
  }
  
  public static void dkB()
  {
    AppMethodBeat.i(168788);
    vuL.clear();
    AppMethodBeat.o(168788);
  }
  
  public static ctc g(Long paramLong)
  {
    AppMethodBeat.i(168786);
    if (paramLong == null)
    {
      AppMethodBeat.o(168786);
      return null;
    }
    paramLong = (ctc)vuL.get(paramLong);
    AppMethodBeat.o(168786);
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.a.b
 * JD-Core Version:    0.7.0.1
 */