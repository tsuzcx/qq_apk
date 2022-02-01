package com.tencent.mm.plugin.luckymoney.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.q;
import com.tencent.mm.protocal.protobuf.eog;
import com.tencent.mm.protocal.protobuf.eoh;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  private static Map<String, q> Klx;
  private static Map<String, eoh> Kly;
  private static Map<Long, eog> Klz;
  
  static
  {
    AppMethodBeat.i(168789);
    Klx = new HashMap();
    Kly = new HashMap();
    Klz = new HashMap();
    AppMethodBeat.o(168789);
  }
  
  public static void a(Long paramLong, eog parameog)
  {
    AppMethodBeat.i(168785);
    Klz.put(paramLong, parameog);
    AppMethodBeat.o(168785);
  }
  
  public static void a(String paramString, q paramq)
  {
    AppMethodBeat.i(168781);
    Klx.put(paramString, paramq);
    AppMethodBeat.o(168781);
  }
  
  public static void a(String paramString, eoh parameoh)
  {
    AppMethodBeat.i(168783);
    Kly.put(paramString, parameoh);
    AppMethodBeat.o(168783);
  }
  
  public static q aKs(String paramString)
  {
    AppMethodBeat.i(168782);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(168782);
      return null;
    }
    paramString = (q)Klx.get(paramString);
    AppMethodBeat.o(168782);
    return paramString;
  }
  
  public static eoh aKt(String paramString)
  {
    AppMethodBeat.i(168784);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(168784);
      return null;
    }
    paramString = (eoh)Kly.get(paramString);
    AppMethodBeat.o(168784);
    return paramString;
  }
  
  public static void clear()
  {
    AppMethodBeat.i(168787);
    Klx.clear();
    Kly.clear();
    AppMethodBeat.o(168787);
  }
  
  public static void fWf()
  {
    AppMethodBeat.i(168788);
    Klz.clear();
    AppMethodBeat.o(168788);
  }
  
  public static eog l(Long paramLong)
  {
    AppMethodBeat.i(168786);
    if (paramLong == null)
    {
      AppMethodBeat.o(168786);
      return null;
    }
    paramLong = (eog)Klz.get(paramLong);
    AppMethodBeat.o(168786);
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.a.b
 * JD-Core Version:    0.7.0.1
 */