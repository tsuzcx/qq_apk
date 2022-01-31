package com.tencent.mm.plugin.messenger.foundation.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class r$a
{
  private static ConcurrentHashMap<Integer, r> oDF;
  
  static
  {
    AppMethodBeat.i(60006);
    oDF = new ConcurrentHashMap();
    AppMethodBeat.o(60006);
  }
  
  public static void a(int paramInt, r paramr)
  {
    AppMethodBeat.i(60004);
    if (oDF.get(Integer.valueOf(paramInt)) == null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      oDF.put(Integer.valueOf(paramInt), paramr);
      AppMethodBeat.o(60004);
      return;
    }
  }
  
  public static r yT(int paramInt)
  {
    AppMethodBeat.i(60005);
    r localr = (r)oDF.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(60005);
    return localr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a.r.a
 * JD-Core Version:    0.7.0.1
 */