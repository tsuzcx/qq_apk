package com.tencent.mm.ak;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.pp;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.concurrent.ConcurrentHashMap;

public abstract interface e
  extends f
{
  public abstract int abd();
  
  public static final class a
  {
    private static ConcurrentHashMap<Object, e> hvC;
    
    static
    {
      AppMethodBeat.i(43001);
      hvC = new ConcurrentHashMap();
      AppMethodBeat.o(43001);
    }
    
    public static void a(e parame)
    {
      AppMethodBeat.i(42998);
      ac.i("MicroMsg.IFunctionMessageExtension.Factory", "registerExtensionFor %s, %s", new Object[] { Integer.valueOf(parame.abd()), Integer.valueOf(0) });
      hvC.put(Integer.valueOf(0), parame);
      f.d.a(Integer.valueOf(parame.abd()), parame);
      AppMethodBeat.o(42998);
    }
    
    public static void b(e parame)
    {
      AppMethodBeat.i(42999);
      ac.i("MicroMsg.IFunctionMessageExtension.Factory", "unregisterExtensionFor %s, %s", new Object[] { Integer.valueOf(parame.abd()), Integer.valueOf(0) });
      hvC.remove(Integer.valueOf(0));
      f.d.b(Integer.valueOf(parame.abd()), parame);
      AppMethodBeat.o(42999);
    }
    
    public static e bX(Object paramObject)
    {
      AppMethodBeat.i(43000);
      paramObject = (e)hvC.get(paramObject);
      AppMethodBeat.o(43000);
      return paramObject;
    }
  }
  
  public static final class b
  {
    public pp hvD;
    public String hvE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ak.e
 * JD-Core Version:    0.7.0.1
 */