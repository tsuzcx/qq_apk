package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;
import java.util.concurrent.ConcurrentHashMap;

public abstract interface g
{
  public abstract b b(a parama);
  
  public abstract void b(c paramc);
  
  public static class a
  {
    public Object extra;
    public dl mpN;
    public boolean otM = false;
    public boolean otN = false;
    public boolean otO = false;
    public boolean otP = false;
    public long otQ = 0L;
    public boolean otR = false;
    public int what;
    
    public a(dl paramdl)
    {
      this.mpN = paramdl;
      this.extra = null;
    }
    
    public a(dl paramdl, long paramLong)
    {
      this.mpN = paramdl;
      this.otP = true;
      this.otQ = paramLong;
    }
    
    public a(dl paramdl, Object paramObject)
    {
      this.mpN = paramdl;
      this.otR = true;
      this.extra = paramObject;
    }
    
    public a(dl paramdl, boolean paramBoolean, long paramLong)
    {
      this.mpN = paramdl;
      this.otM = true;
      this.otN = false;
      this.otO = paramBoolean;
      this.otQ = paramLong;
    }
    
    public a(dl paramdl, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      this.mpN = paramdl;
      this.otM = paramBoolean1;
      this.otN = paramBoolean2;
      this.otO = paramBoolean3;
    }
    
    public String toString()
    {
      AppMethodBeat.i(43002);
      String str = String.format("AddMsgInfo(%d), get[%b], fault[%b], up[%b] fixTime[%s]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.otM), Boolean.valueOf(this.otN), Boolean.valueOf(this.otO), Long.valueOf(this.otQ) });
      AppMethodBeat.o(43002);
      return str;
    }
  }
  
  public static class b
  {
    public cc hzO;
    public boolean otS;
    
    public b(cc paramcc, boolean paramBoolean)
    {
      this.hzO = paramcc;
      this.otS = paramBoolean;
    }
  }
  
  public static final class c
  {
    public cc hTm;
    public dl mpN;
    public Object otT;
    public Object otU;
    public String otV;
    public String otW;
    
    public c(dl paramdl, Object paramObject1, Object paramObject2)
    {
      this.mpN = paramdl;
      this.otT = paramObject1;
      this.otU = paramObject2;
    }
    
    public c(cc paramcc)
    {
      this.hTm = paramcc;
    }
  }
  
  public static final class d
  {
    private static ConcurrentHashMap<Object, g> otJ;
    
    static
    {
      AppMethodBeat.i(43006);
      otJ = new ConcurrentHashMap();
      AppMethodBeat.o(43006);
    }
    
    public static void a(Object paramObject, g paramg)
    {
      AppMethodBeat.i(43003);
      Log.i("MicroMsg.IMessageExtension.Factory", "registerExtensionFor %s, %s", new Object[] { paramObject, paramg });
      otJ.put(paramObject, paramg);
      AppMethodBeat.o(43003);
    }
    
    public static void b(Object paramObject, g paramg)
    {
      AppMethodBeat.i(43004);
      Log.i("MicroMsg.IMessageExtension.Factory", "unregisterExtensionFor %s, %s", new Object[] { paramObject, paramg });
      otJ.remove(paramObject);
      AppMethodBeat.o(43004);
    }
    
    public static g dB(Object paramObject)
    {
      AppMethodBeat.i(43005);
      paramObject = (g)otJ.get(paramObject);
      AppMethodBeat.o(43005);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.am.g
 * JD-Core Version:    0.7.0.1
 */