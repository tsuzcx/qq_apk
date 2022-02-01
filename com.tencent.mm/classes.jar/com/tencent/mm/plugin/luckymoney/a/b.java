package com.tencent.mm.plugin.luckymoney.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.l;
import com.tencent.mm.protocal.protobuf.cnf;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  private static Map<String, l> ufU;
  private static Map<String, cng> ufV;
  private static Map<Long, cnf> ufW;
  
  static
  {
    AppMethodBeat.i(168789);
    ufU = new HashMap();
    ufV = new HashMap();
    ufW = new HashMap();
    AppMethodBeat.o(168789);
  }
  
  public static void a(Long paramLong, cnf paramcnf)
  {
    AppMethodBeat.i(168785);
    ufW.put(paramLong, paramcnf);
    AppMethodBeat.o(168785);
  }
  
  public static void a(String paramString, l paraml)
  {
    AppMethodBeat.i(168781);
    ufU.put(paramString, paraml);
    AppMethodBeat.o(168781);
  }
  
  public static void a(String paramString, cng paramcng)
  {
    AppMethodBeat.i(168783);
    ufV.put(paramString, paramcng);
    AppMethodBeat.o(168783);
  }
  
  public static l akc(String paramString)
  {
    AppMethodBeat.i(168782);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(168782);
      return null;
    }
    paramString = (l)ufU.get(paramString);
    AppMethodBeat.o(168782);
    return paramString;
  }
  
  public static cng akd(String paramString)
  {
    AppMethodBeat.i(168784);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(168784);
      return null;
    }
    paramString = (cng)ufV.get(paramString);
    AppMethodBeat.o(168784);
    return paramString;
  }
  
  public static void cYq()
  {
    AppMethodBeat.i(168788);
    ufW.clear();
    AppMethodBeat.o(168788);
  }
  
  public static void clear()
  {
    AppMethodBeat.i(168787);
    ufU.clear();
    ufV.clear();
    AppMethodBeat.o(168787);
  }
  
  public static cnf e(Long paramLong)
  {
    AppMethodBeat.i(168786);
    if (paramLong == null)
    {
      AppMethodBeat.o(168786);
      return null;
    }
    paramLong = (cnf)ufW.get(paramLong);
    AppMethodBeat.o(168786);
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.a.b
 * JD-Core Version:    0.7.0.1
 */