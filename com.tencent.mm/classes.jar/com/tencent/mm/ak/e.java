package com.tencent.mm.ak;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bv;
import java.util.concurrent.ConcurrentHashMap;

public abstract interface e
{
  public abstract b b(a parama);
  
  public abstract void b(c paramc);
  
  public static final class a
  {
    public cv gte;
    public boolean hQN = false;
    public boolean hQO = false;
    public boolean hQP = false;
    public long hQQ = 0L;
    public boolean hQR = false;
    public Object hQS;
    public int what;
    
    public a(cv paramcv, Object paramObject)
    {
      this.gte = paramcv;
      this.hQR = true;
      this.hQS = paramObject;
    }
    
    public a(cv paramcv, boolean paramBoolean, long paramLong)
    {
      this.gte = paramcv;
      this.hQN = true;
      this.hQO = false;
      this.hQP = paramBoolean;
      this.hQQ = paramLong;
    }
    
    public a(cv paramcv, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      this.gte = paramcv;
      this.hQN = paramBoolean1;
      this.hQO = paramBoolean2;
      this.hQP = paramBoolean3;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(43002);
      String str = String.format("AddMsgInfo(%d), get[%b], fault[%b], up[%b] fixTime[%s]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.hQN), Boolean.valueOf(this.hQO), Boolean.valueOf(this.hQP), Long.valueOf(this.hQQ) });
      AppMethodBeat.o(43002);
      return str;
    }
  }
  
  public static final class b
  {
    public bv dlw;
    public boolean hQT;
    
    public b(bv parambv, boolean paramBoolean)
    {
      this.dlw = parambv;
      this.hQT = paramBoolean;
    }
  }
  
  public static final class c
  {
    public bv dCi;
    public cv gte;
    public Object hQU;
    public Object hQV;
    public String hQW;
    public String hQX;
    
    public c(cv paramcv, Object paramObject1, Object paramObject2)
    {
      this.gte = paramcv;
      this.hQU = paramObject1;
      this.hQV = paramObject2;
    }
    
    public c(bv parambv)
    {
      this.dCi = parambv;
    }
  }
  
  public static final class d
  {
    private static ConcurrentHashMap<Object, e> hQK;
    
    static
    {
      AppMethodBeat.i(43006);
      hQK = new ConcurrentHashMap();
      AppMethodBeat.o(43006);
    }
    
    public static void a(Object paramObject, e parame)
    {
      AppMethodBeat.i(43003);
      ae.i("MicroMsg.IMessageExtension.Factory", "registerExtensionFor %s, %s", new Object[] { paramObject, parame });
      hQK.put(paramObject, parame);
      AppMethodBeat.o(43003);
    }
    
    public static void b(Object paramObject, e parame)
    {
      AppMethodBeat.i(43004);
      ae.i("MicroMsg.IMessageExtension.Factory", "unregisterExtensionFor %s, %s", new Object[] { paramObject, parame });
      hQK.remove(paramObject);
      AppMethodBeat.o(43004);
    }
    
    public static e ca(Object paramObject)
    {
      AppMethodBeat.i(43005);
      paramObject = (e)hQK.get(paramObject);
      AppMethodBeat.o(43005);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ak.e
 * JD-Core Version:    0.7.0.1
 */