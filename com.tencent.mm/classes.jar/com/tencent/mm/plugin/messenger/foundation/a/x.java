package com.tencent.mm.plugin.messenger.foundation.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.abn;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public abstract interface x
{
  public abstract void a(abn paramabn, byte[] paramArrayOfByte, boolean paramBoolean, aa paramaa);
  
  public static final class a
  {
    private static ConcurrentHashMap<Integer, x> zqd;
    
    static
    {
      AppMethodBeat.i(43065);
      zqd = new ConcurrentHashMap();
      AppMethodBeat.o(43065);
    }
    
    public static x Qn(int paramInt)
    {
      AppMethodBeat.i(43064);
      x localx = (x)zqd.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(43064);
      return localx;
    }
    
    public static void a(int paramInt, x paramx)
    {
      AppMethodBeat.i(43063);
      if (zqd.get(Integer.valueOf(paramInt)) == null) {}
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        zqd.put(Integer.valueOf(paramInt), paramx);
        AppMethodBeat.o(43063);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.foundation.a.x
 * JD-Core Version:    0.7.0.1
 */