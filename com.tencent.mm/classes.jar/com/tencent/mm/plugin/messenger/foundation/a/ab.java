package com.tencent.mm.plugin.messenger.foundation.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.adw;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public abstract interface ab
{
  public abstract void a(adw paramadw, byte[] paramArrayOfByte, boolean paramBoolean, ae paramae);
  
  public static final class a
  {
    private static ConcurrentHashMap<Integer, ab> KRc;
    
    static
    {
      AppMethodBeat.i(43065);
      KRc = new ConcurrentHashMap();
      AppMethodBeat.o(43065);
    }
    
    public static void a(int paramInt, ab paramab)
    {
      AppMethodBeat.i(43063);
      if (KRc.get(Integer.valueOf(paramInt)) == null) {}
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        KRc.put(Integer.valueOf(paramInt), paramab);
        AppMethodBeat.o(43063);
        return;
      }
    }
    
    public static ab aaC(int paramInt)
    {
      AppMethodBeat.i(43064);
      ab localab = (ab)KRc.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(43064);
      return localab;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a.ab
 * JD-Core Version:    0.7.0.1
 */