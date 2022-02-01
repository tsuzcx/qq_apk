package com.tencent.mm.plugin.messenger.foundation.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.xv;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public abstract interface u
{
  public abstract void a(xv paramxv, byte[] paramArrayOfByte, boolean paramBoolean, x paramx);
  
  public static final class a
  {
    private static ConcurrentHashMap<Integer, u> uGR;
    
    static
    {
      AppMethodBeat.i(43065);
      uGR = new ConcurrentHashMap();
      AppMethodBeat.o(43065);
    }
    
    public static u Ip(int paramInt)
    {
      AppMethodBeat.i(43064);
      u localu = (u)uGR.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(43064);
      return localu;
    }
    
    public static void a(int paramInt, u paramu)
    {
      AppMethodBeat.i(43063);
      if (uGR.get(Integer.valueOf(paramInt)) == null) {}
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        uGR.put(Integer.valueOf(paramInt), paramu);
        AppMethodBeat.o(43063);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a.u
 * JD-Core Version:    0.7.0.1
 */