package com.tencent.mm.ak;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bo;
import java.util.concurrent.ConcurrentHashMap;

public abstract interface f
{
  public abstract b b(a parama);
  
  public abstract void b(c paramc);
  
  public static final class a
  {
    public cu fXi;
    public boolean hvF = false;
    public boolean hvG = false;
    public boolean hvH = false;
    public long hvI = 0L;
    public boolean hvJ = false;
    public Object hvK;
    
    public a(cu paramcu, Object paramObject)
    {
      this.fXi = paramcu;
      this.hvJ = true;
      this.hvK = paramObject;
    }
    
    public a(cu paramcu, boolean paramBoolean, long paramLong)
    {
      this.fXi = paramcu;
      this.hvF = true;
      this.hvG = false;
      this.hvH = paramBoolean;
      this.hvI = paramLong;
    }
    
    public a(cu paramcu, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      this.fXi = paramcu;
      this.hvF = paramBoolean1;
      this.hvG = paramBoolean2;
      this.hvH = paramBoolean3;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(43002);
      String str = String.format("AddMsgInfo(%d), get[%b], fault[%b], up[%b] fixTime[%s]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.hvF), Boolean.valueOf(this.hvG), Boolean.valueOf(this.hvH), Long.valueOf(this.hvI) });
      AppMethodBeat.o(43002);
      return str;
    }
  }
  
  public static final class b
  {
    public bo cZc;
    public boolean hvL;
    
    public b(bo parambo, boolean paramBoolean)
    {
      this.cZc = parambo;
      this.hvL = paramBoolean;
    }
  }
  
  public static final class c
  {
    public bo dpq;
    public cu fXi;
    public Object hvM;
    public Object hvN;
    public String hvO;
    public String hvP;
    
    public c(cu paramcu, Object paramObject1, Object paramObject2)
    {
      this.fXi = paramcu;
      this.hvM = paramObject1;
      this.hvN = paramObject2;
    }
    
    public c(bo parambo)
    {
      this.dpq = parambo;
    }
  }
  
  public static final class d
  {
    private static ConcurrentHashMap<Object, f> hvC;
    
    static
    {
      AppMethodBeat.i(43006);
      hvC = new ConcurrentHashMap();
      AppMethodBeat.o(43006);
    }
    
    public static void a(Object paramObject, f paramf)
    {
      AppMethodBeat.i(43003);
      ac.i("MicroMsg.IMessageExtension.Factory", "registerExtensionFor %s, %s", new Object[] { paramObject, paramf });
      hvC.put(paramObject, paramf);
      AppMethodBeat.o(43003);
    }
    
    public static void b(Object paramObject, f paramf)
    {
      AppMethodBeat.i(43004);
      ac.i("MicroMsg.IMessageExtension.Factory", "unregisterExtensionFor %s, %s", new Object[] { paramObject, paramf });
      hvC.remove(paramObject);
      AppMethodBeat.o(43004);
    }
    
    public static f bY(Object paramObject)
    {
      AppMethodBeat.i(43005);
      paramObject = (f)hvC.get(paramObject);
      AppMethodBeat.o(43005);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ak.f
 * JD-Core Version:    0.7.0.1
 */