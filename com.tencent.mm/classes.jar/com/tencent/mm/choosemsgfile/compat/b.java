package com.tencent.mm.choosemsgfile.compat;

import com.tencent.mm.aw.e;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.storage.bl;

public abstract interface b
  extends com.tencent.mm.kernel.c.a
{
  public abstract com.tencent.mm.vending.e.a a(long paramLong, String paramString, a parama);
  
  public abstract String a(bl parambl, e parame);
  
  public abstract void a(c paramc);
  
  public abstract void a(bl parambl, a parama);
  
  public abstract boolean a(bl parambl, c paramc);
  
  public abstract boolean a(String paramString, bl parambl, b paramb);
  
  public abstract boolean j(bl parambl);
  
  public abstract e k(bl parambl);
  
  public abstract String l(bl parambl);
  
  public abstract boolean m(bl parambl);
  
  public abstract c q(String paramString, long paramLong);
  
  public static abstract interface a
  {
    public abstract void cq(int paramInt1, int paramInt2);
    
    public abstract void r(int paramInt, String paramString);
  }
  
  public static abstract interface b
  {
    public abstract void s(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.choosemsgfile.compat.b
 * JD-Core Version:    0.7.0.1
 */