package com.tencent.mm.cache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;

public final class f$a
{
  private static Map<String, f> ecw;
  
  static
  {
    AppMethodBeat.i(57826);
    ecw = new HashMap();
    AppMethodBeat.o(57826);
  }
  
  public static <T> T M(String paramString1, String paramString2)
  {
    AppMethodBeat.i(57821);
    paramString1 = a(kS(paramString1), paramString2);
    AppMethodBeat.o(57821);
    return paramString1;
  }
  
  public static <T> void N(String paramString1, String paramString2)
  {
    AppMethodBeat.i(57823);
    b(kS(paramString1), paramString2);
    AppMethodBeat.o(57823);
  }
  
  private static <T> T a(f paramf, String paramString)
  {
    AppMethodBeat.i(57824);
    if (paramf == null)
    {
      ab.e("MicroMsg.ICacheService.Factory", "null service");
      AppMethodBeat.o(57824);
      return null;
    }
    try
    {
      paramf = paramf.get(paramString);
      AppMethodBeat.o(57824);
      return paramf;
    }
    catch (Exception paramf)
    {
      ab.e("MicroMsg.ICacheService.Factory", "cast failed, different type ?");
      ab.e("MicroMsg.ICacheService.Factory", "exception:%s", new Object[] { bo.l(paramf) });
      AppMethodBeat.o(57824);
    }
    return null;
  }
  
  public static void a(String paramString, f paramf)
  {
    AppMethodBeat.i(57819);
    ecw.put(paramString, paramf);
    AppMethodBeat.o(57819);
  }
  
  public static <T> void a(String paramString1, String paramString2, T paramT)
  {
    AppMethodBeat.i(57822);
    paramString1 = kS(paramString1);
    if (paramString1 == null)
    {
      ab.e("MicroMsg.ICacheService.Factory", "null service");
      AppMethodBeat.o(57822);
      return;
    }
    paramString1.d(paramString2, paramT);
    AppMethodBeat.o(57822);
  }
  
  private static <T> T b(f paramf, String paramString)
  {
    AppMethodBeat.i(57825);
    if (paramf == null)
    {
      ab.e("MicroMsg.ICacheService.Factory", "null service");
      AppMethodBeat.o(57825);
      return null;
    }
    try
    {
      paramf = paramf.remove(paramString);
      AppMethodBeat.o(57825);
      return paramf;
    }
    catch (Exception paramf)
    {
      ab.e("MicroMsg.ICacheService.Factory", "cast failed, different type ?");
      ab.e("MicroMsg.ICacheService.Factory", "exception:%s", new Object[] { bo.l(paramf) });
      AppMethodBeat.o(57825);
    }
    return null;
  }
  
  private static f kS(String paramString)
  {
    AppMethodBeat.i(57820);
    paramString = (f)ecw.get(paramString);
    AppMethodBeat.o(57820);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cache.f.a
 * JD-Core Version:    0.7.0.1
 */