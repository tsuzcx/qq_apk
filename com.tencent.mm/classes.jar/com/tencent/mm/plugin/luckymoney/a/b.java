package com.tencent.mm.plugin.luckymoney.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.l;
import com.tencent.mm.protocal.protobuf.csi;
import com.tencent.mm.protocal.protobuf.csj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  private static Map<String, l> viE;
  private static Map<String, csj> viF;
  private static Map<Long, csi> viG;
  
  static
  {
    AppMethodBeat.i(168789);
    viE = new HashMap();
    viF = new HashMap();
    viG = new HashMap();
    AppMethodBeat.o(168789);
  }
  
  public static void a(Long paramLong, csi paramcsi)
  {
    AppMethodBeat.i(168785);
    viG.put(paramLong, paramcsi);
    AppMethodBeat.o(168785);
  }
  
  public static void a(String paramString, l paraml)
  {
    AppMethodBeat.i(168781);
    viE.put(paramString, paraml);
    AppMethodBeat.o(168781);
  }
  
  public static void a(String paramString, csj paramcsj)
  {
    AppMethodBeat.i(168783);
    viF.put(paramString, paramcsj);
    AppMethodBeat.o(168783);
  }
  
  public static l aoP(String paramString)
  {
    AppMethodBeat.i(168782);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(168782);
      return null;
    }
    paramString = (l)viE.get(paramString);
    AppMethodBeat.o(168782);
    return paramString;
  }
  
  public static csj aoQ(String paramString)
  {
    AppMethodBeat.i(168784);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(168784);
      return null;
    }
    paramString = (csj)viF.get(paramString);
    AppMethodBeat.o(168784);
    return paramString;
  }
  
  public static void clear()
  {
    AppMethodBeat.i(168787);
    viE.clear();
    viF.clear();
    AppMethodBeat.o(168787);
  }
  
  public static void dhC()
  {
    AppMethodBeat.i(168788);
    viG.clear();
    AppMethodBeat.o(168788);
  }
  
  public static csi e(Long paramLong)
  {
    AppMethodBeat.i(168786);
    if (paramLong == null)
    {
      AppMethodBeat.o(168786);
      return null;
    }
    paramLong = (csi)viG.get(paramLong);
    AppMethodBeat.o(168786);
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.a.b
 * JD-Core Version:    0.7.0.1
 */