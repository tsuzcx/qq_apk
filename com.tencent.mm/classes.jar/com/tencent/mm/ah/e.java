package com.tencent.mm.ah;

import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.util.concurrent.ConcurrentHashMap;

public abstract interface e
{
  public abstract void a(c paramc);
  
  public abstract b b(a parama);
  
  public static final class a
  {
    public cd dBs;
    public boolean ecS = false;
    public boolean ecT = false;
    public boolean ecU = false;
    public long ecV = 0L;
    public Object ecW;
    
    public a(cd paramcd, Object paramObject)
    {
      this.dBs = paramcd;
      this.ecW = paramObject;
    }
    
    public a(cd paramcd, boolean paramBoolean, long paramLong)
    {
      this.dBs = paramcd;
      this.ecS = true;
      this.ecT = false;
      this.ecU = paramBoolean;
      this.ecV = paramLong;
    }
    
    public a(cd paramcd, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      this.dBs = paramcd;
      this.ecS = paramBoolean1;
      this.ecT = paramBoolean2;
      this.ecU = paramBoolean3;
    }
    
    public final String toString()
    {
      return String.format("AddMsgInfo(%d), get[%b], fault[%b], up[%b] fixTime[%s]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.ecS), Boolean.valueOf(this.ecT), Boolean.valueOf(this.ecU), Long.valueOf(this.ecV) });
    }
  }
  
  public static final class b
  {
    public bi bFH;
    public boolean ecX;
    
    public b(bi parambi, boolean paramBoolean)
    {
      this.bFH = parambi;
      this.ecX = paramBoolean;
    }
  }
  
  public static final class c
  {
    public bi bWO;
    public cd dBs;
    public Object ecW;
    
    public c(cd paramcd, Object paramObject)
    {
      this.dBs = paramcd;
      this.ecW = paramObject;
    }
    
    public c(bi parambi)
    {
      this.bWO = parambi;
    }
  }
  
  public static final class d
  {
    private static ConcurrentHashMap<Object, e> ecP = new ConcurrentHashMap();
    
    public static void a(Object paramObject, e parame)
    {
      y.i("MicroMsg.IMessageExtension.Factory", "registerExtensionFor %s, %s", new Object[] { paramObject, parame });
      ecP.put(paramObject, parame);
    }
    
    public static e aB(Object paramObject)
    {
      return (e)ecP.get(paramObject);
    }
    
    public static void b(Object paramObject, e parame)
    {
      y.i("MicroMsg.IMessageExtension.Factory", "unregisterExtensionFor %s, %s", new Object[] { paramObject, parame });
      ecP.remove(paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ah.e
 * JD-Core Version:    0.7.0.1
 */