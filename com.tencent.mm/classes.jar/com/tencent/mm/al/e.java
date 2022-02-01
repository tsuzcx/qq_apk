package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.pi;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.concurrent.ConcurrentHashMap;

public abstract interface e
  extends f
{
  public abstract int aae();
  
  public static final class a
  {
    private static ConcurrentHashMap<Object, e> gVd;
    
    static
    {
      AppMethodBeat.i(43001);
      gVd = new ConcurrentHashMap();
      AppMethodBeat.o(43001);
    }
    
    public static void a(e parame)
    {
      AppMethodBeat.i(42998);
      ad.i("MicroMsg.IFunctionMessageExtension.Factory", "registerExtensionFor %s, %s", new Object[] { Integer.valueOf(parame.aae()), Integer.valueOf(0) });
      gVd.put(Integer.valueOf(0), parame);
      f.d.a(Integer.valueOf(parame.aae()), parame);
      AppMethodBeat.o(42998);
    }
    
    public static void b(e parame)
    {
      AppMethodBeat.i(42999);
      ad.i("MicroMsg.IFunctionMessageExtension.Factory", "unregisterExtensionFor %s, %s", new Object[] { Integer.valueOf(parame.aae()), Integer.valueOf(0) });
      gVd.remove(Integer.valueOf(0));
      f.d.b(Integer.valueOf(parame.aae()), parame);
      AppMethodBeat.o(42999);
    }
    
    public static e bZ(Object paramObject)
    {
      AppMethodBeat.i(43000);
      paramObject = (e)gVd.get(paramObject);
      AppMethodBeat.o(43000);
      return paramObject;
    }
  }
  
  public static final class b
  {
    public pi gVe;
    public String gVf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.al.e
 * JD-Core Version:    0.7.0.1
 */