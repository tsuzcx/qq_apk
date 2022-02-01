package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bl;
import java.util.concurrent.ConcurrentHashMap;

public abstract interface f
{
  public abstract b b(a parama);
  
  public abstract void b(c paramc);
  
  public static final class a
  {
    public cs fTo;
    public boolean gVg = false;
    public boolean gVh = false;
    public boolean gVi = false;
    public long gVj = 0L;
    public boolean gVk = false;
    public Object gVl;
    
    public a(cs paramcs, Object paramObject)
    {
      this.fTo = paramcs;
      this.gVk = true;
      this.gVl = paramObject;
    }
    
    public a(cs paramcs, boolean paramBoolean, long paramLong)
    {
      this.fTo = paramcs;
      this.gVg = true;
      this.gVh = false;
      this.gVi = paramBoolean;
      this.gVj = paramLong;
    }
    
    public a(cs paramcs, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      this.fTo = paramcs;
      this.gVg = paramBoolean1;
      this.gVh = paramBoolean2;
      this.gVi = paramBoolean3;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(43002);
      String str = String.format("AddMsgInfo(%d), get[%b], fault[%b], up[%b] fixTime[%s]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.gVg), Boolean.valueOf(this.gVh), Boolean.valueOf(this.gVi), Long.valueOf(this.gVj) });
      AppMethodBeat.o(43002);
      return str;
    }
  }
  
  public static final class b
  {
    public bl dbD;
    public boolean gVm;
    
    public b(bl parambl, boolean paramBoolean)
    {
      this.dbD = parambl;
      this.gVm = paramBoolean;
    }
  }
  
  public static final class c
  {
    public bl drF;
    public cs fTo;
    public Object gVn;
    public Object gVo;
    public String gVp;
    public String gVq;
    
    public c(cs paramcs, Object paramObject1, Object paramObject2)
    {
      this.fTo = paramcs;
      this.gVn = paramObject1;
      this.gVo = paramObject2;
    }
    
    public c(bl parambl)
    {
      this.drF = parambl;
    }
  }
  
  public static final class d
  {
    private static ConcurrentHashMap<Object, f> gVd;
    
    static
    {
      AppMethodBeat.i(43006);
      gVd = new ConcurrentHashMap();
      AppMethodBeat.o(43006);
    }
    
    public static void a(Object paramObject, f paramf)
    {
      AppMethodBeat.i(43003);
      ad.i("MicroMsg.IMessageExtension.Factory", "registerExtensionFor %s, %s", new Object[] { paramObject, paramf });
      gVd.put(paramObject, paramf);
      AppMethodBeat.o(43003);
    }
    
    public static void b(Object paramObject, f paramf)
    {
      AppMethodBeat.i(43004);
      ad.i("MicroMsg.IMessageExtension.Factory", "unregisterExtensionFor %s, %s", new Object[] { paramObject, paramf });
      gVd.remove(paramObject);
      AppMethodBeat.o(43004);
    }
    
    public static f ca(Object paramObject)
    {
      AppMethodBeat.i(43005);
      paramObject = (f)gVd.get(paramObject);
      AppMethodBeat.o(43005);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.al.f
 * JD-Core Version:    0.7.0.1
 */