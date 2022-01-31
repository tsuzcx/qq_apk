package com.tencent.mm.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import java.util.concurrent.ConcurrentHashMap;

public abstract interface e
{
  public abstract void a(c paramc);
  
  public abstract b b(a parama);
  
  public static final class a
  {
    public cm eyJ;
    public boolean fte = false;
    public boolean ftf = false;
    public boolean ftg = false;
    public long fth = 0L;
    public Object fti;
    
    public a(cm paramcm, Object paramObject)
    {
      this.eyJ = paramcm;
      this.fti = paramObject;
    }
    
    public a(cm paramcm, boolean paramBoolean, long paramLong)
    {
      this.eyJ = paramcm;
      this.fte = true;
      this.ftf = false;
      this.ftg = paramBoolean;
      this.fth = paramLong;
    }
    
    public a(cm paramcm, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      this.eyJ = paramcm;
      this.fte = paramBoolean1;
      this.ftf = paramBoolean2;
      this.ftg = paramBoolean3;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(59945);
      String str = String.format("AddMsgInfo(%d), get[%b], fault[%b], up[%b] fixTime[%s]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.fte), Boolean.valueOf(this.ftf), Boolean.valueOf(this.ftg), Long.valueOf(this.fth) });
      AppMethodBeat.o(59945);
      return str;
    }
  }
  
  public static final class b
  {
    public bi cmQ;
    public boolean ftj;
    
    public b(bi parambi, boolean paramBoolean)
    {
      this.cmQ = parambi;
      this.ftj = paramBoolean;
    }
  }
  
  public static final class c
  {
    public bi cEE;
    public cm eyJ;
    public Object fti;
    
    public c(cm paramcm, Object paramObject)
    {
      this.eyJ = paramcm;
      this.fti = paramObject;
    }
    
    public c(bi parambi)
    {
      this.cEE = parambi;
    }
  }
  
  public static final class d
  {
    private static ConcurrentHashMap<Object, e> ftb;
    
    static
    {
      AppMethodBeat.i(59949);
      ftb = new ConcurrentHashMap();
      AppMethodBeat.o(59949);
    }
    
    public static void a(Object paramObject, e parame)
    {
      AppMethodBeat.i(59946);
      ab.i("MicroMsg.IMessageExtension.Factory", "registerExtensionFor %s, %s", new Object[] { paramObject, parame });
      ftb.put(paramObject, parame);
      AppMethodBeat.o(59946);
    }
    
    public static e aV(Object paramObject)
    {
      AppMethodBeat.i(59948);
      paramObject = (e)ftb.get(paramObject);
      AppMethodBeat.o(59948);
      return paramObject;
    }
    
    public static void b(Object paramObject, e parame)
    {
      AppMethodBeat.i(59947);
      ab.i("MicroMsg.IMessageExtension.Factory", "unregisterExtensionFor %s, %s", new Object[] { paramObject, parame });
      ftb.remove(paramObject);
      AppMethodBeat.o(59947);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ai.e
 * JD-Core Version:    0.7.0.1
 */