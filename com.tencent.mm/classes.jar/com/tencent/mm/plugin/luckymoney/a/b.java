package com.tencent.mm.plugin.luckymoney.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.l;
import com.tencent.mm.protocal.protobuf.cib;
import com.tencent.mm.protocal.protobuf.cic;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  private static Map<String, l> sXH;
  private static Map<String, cic> sXI;
  private static Map<Long, cib> sXJ;
  
  static
  {
    AppMethodBeat.i(168789);
    sXH = new HashMap();
    sXI = new HashMap();
    sXJ = new HashMap();
    AppMethodBeat.o(168789);
  }
  
  public static void a(Long paramLong, cib paramcib)
  {
    AppMethodBeat.i(168785);
    sXJ.put(paramLong, paramcib);
    AppMethodBeat.o(168785);
  }
  
  public static void a(String paramString, l paraml)
  {
    AppMethodBeat.i(168781);
    sXH.put(paramString, paraml);
    AppMethodBeat.o(168781);
  }
  
  public static void a(String paramString, cic paramcic)
  {
    AppMethodBeat.i(168783);
    sXI.put(paramString, paramcic);
    AppMethodBeat.o(168783);
  }
  
  public static l afi(String paramString)
  {
    AppMethodBeat.i(168782);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(168782);
      return null;
    }
    paramString = (l)sXH.get(paramString);
    AppMethodBeat.o(168782);
    return paramString;
  }
  
  public static cic afj(String paramString)
  {
    AppMethodBeat.i(168784);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(168784);
      return null;
    }
    paramString = (cic)sXI.get(paramString);
    AppMethodBeat.o(168784);
    return paramString;
  }
  
  public static void cKL()
  {
    AppMethodBeat.i(168788);
    sXJ.clear();
    AppMethodBeat.o(168788);
  }
  
  public static void clear()
  {
    AppMethodBeat.i(168787);
    sXH.clear();
    sXI.clear();
    AppMethodBeat.o(168787);
  }
  
  public static cib d(Long paramLong)
  {
    AppMethodBeat.i(168786);
    if (paramLong == null)
    {
      AppMethodBeat.o(168786);
      return null;
    }
    paramLong = (cib)sXJ.get(paramLong);
    AppMethodBeat.o(168786);
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.a.b
 * JD-Core Version:    0.7.0.1
 */