package com.tencent.mm.an;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import java.util.concurrent.ConcurrentHashMap;

public abstract interface h
{
  public abstract h.b b(a parama);
  
  public abstract void b(c paramc);
  
  public static class a
  {
    public db jQG;
    public boolean lCc = false;
    public boolean lCd = false;
    public boolean lCe = false;
    public long lCf = 0L;
    public boolean lCg = false;
    public Object lCh;
    public int what;
    
    public a(db paramdb, Object paramObject)
    {
      this.jQG = paramdb;
      this.lCg = true;
      this.lCh = paramObject;
    }
    
    public a(db paramdb, boolean paramBoolean, long paramLong)
    {
      this.jQG = paramdb;
      this.lCc = true;
      this.lCd = false;
      this.lCe = paramBoolean;
      this.lCf = paramLong;
    }
    
    public a(db paramdb, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      this.jQG = paramdb;
      this.lCc = paramBoolean1;
      this.lCd = paramBoolean2;
      this.lCe = paramBoolean3;
    }
    
    public String toString()
    {
      AppMethodBeat.i(43002);
      String str = String.format("AddMsgInfo(%d), get[%b], fault[%b], up[%b] fixTime[%s]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.lCc), Boolean.valueOf(this.lCd), Boolean.valueOf(this.lCe), Long.valueOf(this.lCf) });
      AppMethodBeat.o(43002);
      return str;
    }
  }
  
  public static final class c
  {
    public ca fNz;
    public db jQG;
    public Object lCj;
    public Object lCk;
    public String lCl;
    public String lCm;
    
    public c(db paramdb, Object paramObject1, Object paramObject2)
    {
      this.jQG = paramdb;
      this.lCj = paramObject1;
      this.lCk = paramObject2;
    }
    
    public c(ca paramca)
    {
      this.fNz = paramca;
    }
  }
  
  public static final class d
  {
    private static ConcurrentHashMap<Object, h> lBZ;
    
    static
    {
      AppMethodBeat.i(43006);
      lBZ = new ConcurrentHashMap();
      AppMethodBeat.o(43006);
    }
    
    public static void a(Object paramObject, h paramh)
    {
      AppMethodBeat.i(43003);
      Log.i("MicroMsg.IMessageExtension.Factory", "registerExtensionFor %s, %s", new Object[] { paramObject, paramh });
      lBZ.put(paramObject, paramh);
      AppMethodBeat.o(43003);
    }
    
    public static void b(Object paramObject, h paramh)
    {
      AppMethodBeat.i(43004);
      Log.i("MicroMsg.IMessageExtension.Factory", "unregisterExtensionFor %s, %s", new Object[] { paramObject, paramh });
      lBZ.remove(paramObject);
      AppMethodBeat.o(43004);
    }
    
    public static h cj(Object paramObject)
    {
      AppMethodBeat.i(43005);
      paramObject = (h)lBZ.get(paramObject);
      AppMethodBeat.o(43005);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.an.h
 * JD-Core Version:    0.7.0.1
 */