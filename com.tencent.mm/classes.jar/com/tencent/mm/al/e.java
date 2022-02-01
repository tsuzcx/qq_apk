package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bu;
import java.util.concurrent.ConcurrentHashMap;

public abstract interface e
{
  public abstract b b(a parama);
  
  public abstract void b(c paramc);
  
  public static final class a
  {
    public cv gqE;
    public boolean hNU = false;
    public boolean hNV = false;
    public boolean hNW = false;
    public long hNX = 0L;
    public boolean hNY = false;
    public Object hNZ;
    public int what;
    
    public a(cv paramcv, Object paramObject)
    {
      this.gqE = paramcv;
      this.hNY = true;
      this.hNZ = paramObject;
    }
    
    public a(cv paramcv, boolean paramBoolean, long paramLong)
    {
      this.gqE = paramcv;
      this.hNU = true;
      this.hNV = false;
      this.hNW = paramBoolean;
      this.hNX = paramLong;
    }
    
    public a(cv paramcv, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      this.gqE = paramcv;
      this.hNU = paramBoolean1;
      this.hNV = paramBoolean2;
      this.hNW = paramBoolean3;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(43002);
      String str = String.format("AddMsgInfo(%d), get[%b], fault[%b], up[%b] fixTime[%s]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.hNU), Boolean.valueOf(this.hNV), Boolean.valueOf(this.hNW), Long.valueOf(this.hNX) });
      AppMethodBeat.o(43002);
      return str;
    }
  }
  
  public static final class b
  {
    public bu dku;
    public boolean hOa;
    
    public b(bu parambu, boolean paramBoolean)
    {
      this.dku = parambu;
      this.hOa = paramBoolean;
    }
  }
  
  public static final class c
  {
    public bu dBd;
    public cv gqE;
    public Object hOb;
    public Object hOc;
    public String hOd;
    public String hOe;
    
    public c(cv paramcv, Object paramObject1, Object paramObject2)
    {
      this.gqE = paramcv;
      this.hOb = paramObject1;
      this.hOc = paramObject2;
    }
    
    public c(bu parambu)
    {
      this.dBd = parambu;
    }
  }
  
  public static final class d
  {
    private static ConcurrentHashMap<Object, e> hNR;
    
    static
    {
      AppMethodBeat.i(43006);
      hNR = new ConcurrentHashMap();
      AppMethodBeat.o(43006);
    }
    
    public static void a(Object paramObject, e parame)
    {
      AppMethodBeat.i(43003);
      ad.i("MicroMsg.IMessageExtension.Factory", "registerExtensionFor %s, %s", new Object[] { paramObject, parame });
      hNR.put(paramObject, parame);
      AppMethodBeat.o(43003);
    }
    
    public static void b(Object paramObject, e parame)
    {
      AppMethodBeat.i(43004);
      ad.i("MicroMsg.IMessageExtension.Factory", "unregisterExtensionFor %s, %s", new Object[] { paramObject, parame });
      hNR.remove(paramObject);
      AppMethodBeat.o(43004);
    }
    
    public static e ca(Object paramObject)
    {
      AppMethodBeat.i(43005);
      paramObject = (e)hNR.get(paramObject);
      AppMethodBeat.o(43005);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.al.e
 * JD-Core Version:    0.7.0.1
 */