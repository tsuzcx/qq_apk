package com.tencent.mm.plugin.messenger.foundation.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.abu;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public abstract interface ab
{
  public abstract void a(abu paramabu, byte[] paramArrayOfByte, boolean paramBoolean, ae paramae);
  
  public static final class a
  {
    private static ConcurrentHashMap<Integer, ab> EVC;
    
    static
    {
      AppMethodBeat.i(43065);
      EVC = new ConcurrentHashMap();
      AppMethodBeat.o(43065);
    }
    
    public static ab WA(int paramInt)
    {
      AppMethodBeat.i(43064);
      ab localab = (ab)EVC.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(43064);
      return localab;
    }
    
    public static void a(int paramInt, ab paramab)
    {
      AppMethodBeat.i(43063);
      if (EVC.get(Integer.valueOf(paramInt)) == null) {}
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        EVC.put(Integer.valueOf(paramInt), paramab);
        AppMethodBeat.o(43063);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a.ab
 * JD-Core Version:    0.7.0.1
 */