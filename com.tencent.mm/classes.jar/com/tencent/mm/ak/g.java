package com.tencent.mm.ak;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.rx;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.ConcurrentHashMap;

public abstract interface g
  extends h
{
  public abstract int atA();
  
  public abstract int atz();
  
  public static final class a
  {
    private static ConcurrentHashMap<Object, g> iLS;
    
    static
    {
      AppMethodBeat.i(43001);
      iLS = new ConcurrentHashMap();
      AppMethodBeat.o(43001);
    }
    
    public static void a(g paramg)
    {
      AppMethodBeat.i(42998);
      Log.i("MicroMsg.IFunctionMessageExtension.Factory", "registerExtensionFor %s, %s", new Object[] { Integer.valueOf(paramg.atz()), Integer.valueOf(paramg.atA()) });
      iLS.put(Integer.valueOf(paramg.atA()), paramg);
      h.d.a(Integer.valueOf(paramg.atz()), paramg);
      AppMethodBeat.o(42998);
    }
    
    public static void b(g paramg)
    {
      AppMethodBeat.i(42999);
      Log.i("MicroMsg.IFunctionMessageExtension.Factory", "unregisterExtensionFor %s, %s", new Object[] { Integer.valueOf(paramg.atz()), Integer.valueOf(paramg.atA()) });
      iLS.remove(Integer.valueOf(paramg.atA()));
      h.d.b(Integer.valueOf(paramg.atz()), paramg);
      AppMethodBeat.o(42999);
    }
    
    public static g cj(Object paramObject)
    {
      AppMethodBeat.i(43000);
      paramObject = (g)iLS.get(paramObject);
      AppMethodBeat.o(43000);
      return paramObject;
    }
  }
  
  public static final class b
  {
    public rx iLT;
    public String iLU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ak.g
 * JD-Core Version:    0.7.0.1
 */