package com.tencent.mm.ak;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.qw;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.concurrent.ConcurrentHashMap;

public abstract interface d
  extends e
{
  public abstract int adS();
  
  public abstract int adT();
  
  public static final class a
  {
    private static ConcurrentHashMap<Object, d> hQK;
    
    static
    {
      AppMethodBeat.i(43001);
      hQK = new ConcurrentHashMap();
      AppMethodBeat.o(43001);
    }
    
    public static void a(d paramd)
    {
      AppMethodBeat.i(42998);
      ae.i("MicroMsg.IFunctionMessageExtension.Factory", "registerExtensionFor %s, %s", new Object[] { Integer.valueOf(paramd.adS()), Integer.valueOf(paramd.adT()) });
      hQK.put(Integer.valueOf(paramd.adT()), paramd);
      e.d.a(Integer.valueOf(paramd.adS()), paramd);
      AppMethodBeat.o(42998);
    }
    
    public static void b(d paramd)
    {
      AppMethodBeat.i(42999);
      ae.i("MicroMsg.IFunctionMessageExtension.Factory", "unregisterExtensionFor %s, %s", new Object[] { Integer.valueOf(paramd.adS()), Integer.valueOf(paramd.adT()) });
      hQK.remove(Integer.valueOf(paramd.adT()));
      e.d.b(Integer.valueOf(paramd.adS()), paramd);
      AppMethodBeat.o(42999);
    }
    
    public static d bZ(Object paramObject)
    {
      AppMethodBeat.i(43000);
      paramObject = (d)hQK.get(paramObject);
      AppMethodBeat.o(43000);
      return paramObject;
    }
  }
  
  public static final class b
  {
    public qw hQL;
    public String hQM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ak.d
 * JD-Core Version:    0.7.0.1
 */