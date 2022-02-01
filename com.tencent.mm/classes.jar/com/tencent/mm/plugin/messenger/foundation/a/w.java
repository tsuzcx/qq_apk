package com.tencent.mm.plugin.messenger.foundation.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.zu;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public abstract interface w
{
  public abstract void a(zu paramzu, byte[] paramArrayOfByte, boolean paramBoolean, z paramz);
  
  public static final class a
  {
    private static ConcurrentHashMap<Integer, w> vJU;
    
    static
    {
      AppMethodBeat.i(43065);
      vJU = new ConcurrentHashMap();
      AppMethodBeat.o(43065);
    }
    
    public static w JM(int paramInt)
    {
      AppMethodBeat.i(43064);
      w localw = (w)vJU.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(43064);
      return localw;
    }
    
    public static void a(int paramInt, w paramw)
    {
      AppMethodBeat.i(43063);
      if (vJU.get(Integer.valueOf(paramInt)) == null) {}
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        vJU.put(Integer.valueOf(paramInt), paramw);
        AppMethodBeat.o(43063);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a.w
 * JD-Core Version:    0.7.0.1
 */