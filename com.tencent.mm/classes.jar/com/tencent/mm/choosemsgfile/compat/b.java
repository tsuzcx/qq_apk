package com.tencent.mm.choosemsgfile.compat;

import com.tencent.mm.modelimage.h;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.storage.cc;

public abstract interface b
  extends com.tencent.mm.kernel.c.a
{
  public abstract com.tencent.mm.vending.e.a a(long paramLong, String paramString, a parama);
  
  public abstract String a(cc paramcc, h paramh);
  
  public abstract void a(c paramc);
  
  public abstract void a(cc paramcc, a parama);
  
  public abstract boolean a(cc paramcc, c paramc);
  
  public abstract boolean a(String paramString, cc paramcc, b paramb);
  
  public abstract boolean j(cc paramcc);
  
  public abstract h k(cc paramcc);
  
  public abstract String l(cc paramcc);
  
  public abstract boolean m(cc paramcc);
  
  public abstract c q(String paramString, long paramLong);
  
  public static abstract interface a
  {
    public abstract void dA(int paramInt1, int paramInt2);
    
    public abstract void u(int paramInt, String paramString);
  }
  
  public static abstract interface b
  {
    public abstract void v(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.choosemsgfile.compat.b
 * JD-Core Version:    0.7.0.1
 */