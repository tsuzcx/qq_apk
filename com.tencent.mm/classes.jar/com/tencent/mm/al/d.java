package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.concurrent.ConcurrentHashMap;

public abstract interface d
  extends e
{
  public abstract int adG();
  
  public abstract int adH();
  
  public static final class a
  {
    private static ConcurrentHashMap<Object, d> hNR;
    
    static
    {
      AppMethodBeat.i(43001);
      hNR = new ConcurrentHashMap();
      AppMethodBeat.o(43001);
    }
    
    public static void a(d paramd)
    {
      AppMethodBeat.i(42998);
      ad.i("MicroMsg.IFunctionMessageExtension.Factory", "registerExtensionFor %s, %s", new Object[] { Integer.valueOf(paramd.adG()), Integer.valueOf(paramd.adH()) });
      hNR.put(Integer.valueOf(paramd.adH()), paramd);
      e.d.a(Integer.valueOf(paramd.adG()), paramd);
      AppMethodBeat.o(42998);
    }
    
    public static void b(d paramd)
    {
      AppMethodBeat.i(42999);
      ad.i("MicroMsg.IFunctionMessageExtension.Factory", "unregisterExtensionFor %s, %s", new Object[] { Integer.valueOf(paramd.adG()), Integer.valueOf(paramd.adH()) });
      hNR.remove(Integer.valueOf(paramd.adH()));
      e.d.b(Integer.valueOf(paramd.adG()), paramd);
      AppMethodBeat.o(42999);
    }
    
    public static d bZ(Object paramObject)
    {
      AppMethodBeat.i(43000);
      paramObject = (d)hNR.get(paramObject);
      AppMethodBeat.o(43000);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.d
 * JD-Core Version:    0.7.0.1
 */