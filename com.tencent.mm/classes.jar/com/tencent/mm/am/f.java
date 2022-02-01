package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.tb;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.ConcurrentHashMap;

public abstract interface f
  extends g
{
  public abstract void a(b paramb);
  
  public abstract int aTl();
  
  public abstract long aTm();
  
  public abstract void aTn();
  
  public static final class a
  {
    private static ConcurrentHashMap<Long, f> otJ;
    
    static
    {
      AppMethodBeat.i(43001);
      otJ = new ConcurrentHashMap();
      AppMethodBeat.o(43001);
    }
    
    public static void a(f paramf)
    {
      AppMethodBeat.i(42998);
      Log.i("MicroMsg.IFunctionMessageExtension.Factory", "registerExtensionFor %s, %s", new Object[] { Integer.valueOf(paramf.aTl()), Long.valueOf(paramf.aTm()) });
      otJ.put(Long.valueOf(paramf.aTm()), paramf);
      g.d.a(Integer.valueOf(paramf.aTl()), paramf);
      AppMethodBeat.o(42998);
    }
    
    public static void b(f paramf)
    {
      AppMethodBeat.i(42999);
      Log.i("MicroMsg.IFunctionMessageExtension.Factory", "unregisterExtensionFor %s, %s", new Object[] { Integer.valueOf(paramf.aTl()), Long.valueOf(paramf.aTm()) });
      otJ.remove(Long.valueOf(paramf.aTm()));
      g.d.b(Integer.valueOf(paramf.aTl()), paramf);
      AppMethodBeat.o(42999);
    }
    
    public static f iz(long paramLong)
    {
      AppMethodBeat.i(236811);
      f localf = (f)otJ.get(Long.valueOf(paramLong));
      AppMethodBeat.o(236811);
      return localf;
    }
  }
  
  public static final class b
  {
    public tb otK;
    public String otL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.am.f
 * JD-Core Version:    0.7.0.1
 */