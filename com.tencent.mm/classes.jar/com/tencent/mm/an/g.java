package com.tencent.mm.an;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.rq;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.ConcurrentHashMap;

public abstract interface g
  extends h
{
  public abstract void a(b paramb);
  
  public abstract int aAq();
  
  public abstract long aAr();
  
  public abstract void aAs();
  
  public static final class a
  {
    private static ConcurrentHashMap<Long, g> lBZ;
    
    static
    {
      AppMethodBeat.i(43001);
      lBZ = new ConcurrentHashMap();
      AppMethodBeat.o(43001);
    }
    
    public static g Gp(long paramLong)
    {
      AppMethodBeat.i(238948);
      g localg = (g)lBZ.get(Long.valueOf(paramLong));
      AppMethodBeat.o(238948);
      return localg;
    }
    
    public static void a(g paramg)
    {
      AppMethodBeat.i(42998);
      Log.i("MicroMsg.IFunctionMessageExtension.Factory", "registerExtensionFor %s, %s", new Object[] { Integer.valueOf(paramg.aAq()), Long.valueOf(paramg.aAr()) });
      lBZ.put(Long.valueOf(paramg.aAr()), paramg);
      h.d.a(Integer.valueOf(paramg.aAq()), paramg);
      AppMethodBeat.o(42998);
    }
    
    public static void b(g paramg)
    {
      AppMethodBeat.i(42999);
      Log.i("MicroMsg.IFunctionMessageExtension.Factory", "unregisterExtensionFor %s, %s", new Object[] { Integer.valueOf(paramg.aAq()), Long.valueOf(paramg.aAr()) });
      lBZ.remove(Long.valueOf(paramg.aAr()));
      h.d.b(Integer.valueOf(paramg.aAq()), paramg);
      AppMethodBeat.o(42999);
    }
  }
  
  public static final class b
  {
    public rq lCa;
    public String lCb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.an.g
 * JD-Core Version:    0.7.0.1
 */