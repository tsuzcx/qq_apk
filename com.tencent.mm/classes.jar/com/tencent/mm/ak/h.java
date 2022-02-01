package com.tencent.mm.ak;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import java.util.concurrent.ConcurrentHashMap;

public abstract interface h
{
  public abstract b b(a parama);
  
  public abstract void b(c paramc);
  
  public static final class a
  {
    public de heO;
    public boolean iLV = false;
    public boolean iLW = false;
    public boolean iLX = false;
    public long iLY = 0L;
    public boolean iLZ = false;
    public Object iMa;
    public int what;
    
    public a(de paramde, Object paramObject)
    {
      this.heO = paramde;
      this.iLZ = true;
      this.iMa = paramObject;
    }
    
    public a(de paramde, boolean paramBoolean, long paramLong)
    {
      this.heO = paramde;
      this.iLV = true;
      this.iLW = false;
      this.iLX = paramBoolean;
      this.iLY = paramLong;
    }
    
    public a(de paramde, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      this.heO = paramde;
      this.iLV = paramBoolean1;
      this.iLW = paramBoolean2;
      this.iLX = paramBoolean3;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(43002);
      String str = String.format("AddMsgInfo(%d), get[%b], fault[%b], up[%b] fixTime[%s]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.iLV), Boolean.valueOf(this.iLW), Boolean.valueOf(this.iLX), Long.valueOf(this.iLY) });
      AppMethodBeat.o(43002);
      return str;
    }
  }
  
  public static final class b
  {
    public ca dCM;
    public boolean iMb;
    
    public b(ca paramca, boolean paramBoolean)
    {
      this.dCM = paramca;
      this.iMb = paramBoolean;
    }
  }
  
  public static final class c
  {
    public ca dTX;
    public de heO;
    public Object iMc;
    public Object iMd;
    public String iMe;
    public String iMf;
    
    public c(de paramde, Object paramObject1, Object paramObject2)
    {
      this.heO = paramde;
      this.iMc = paramObject1;
      this.iMd = paramObject2;
    }
    
    public c(ca paramca)
    {
      this.dTX = paramca;
    }
  }
  
  public static final class d
  {
    private static ConcurrentHashMap<Object, h> iLS;
    
    static
    {
      AppMethodBeat.i(43006);
      iLS = new ConcurrentHashMap();
      AppMethodBeat.o(43006);
    }
    
    public static void a(Object paramObject, h paramh)
    {
      AppMethodBeat.i(43003);
      Log.i("MicroMsg.IMessageExtension.Factory", "registerExtensionFor %s, %s", new Object[] { paramObject, paramh });
      iLS.put(paramObject, paramh);
      AppMethodBeat.o(43003);
    }
    
    public static void b(Object paramObject, h paramh)
    {
      AppMethodBeat.i(43004);
      Log.i("MicroMsg.IMessageExtension.Factory", "unregisterExtensionFor %s, %s", new Object[] { paramObject, paramh });
      iLS.remove(paramObject);
      AppMethodBeat.o(43004);
    }
    
    public static h ck(Object paramObject)
    {
      AppMethodBeat.i(43005);
      paramObject = (h)iLS.get(paramObject);
      AppMethodBeat.o(43005);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ak.h
 * JD-Core Version:    0.7.0.1
 */