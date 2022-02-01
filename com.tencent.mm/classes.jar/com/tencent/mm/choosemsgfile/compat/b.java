package com.tencent.mm.choosemsgfile.compat;

import com.tencent.mm.av.g;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.storage.ca;

public abstract interface b
  extends com.tencent.mm.kernel.c.a
{
  public abstract com.tencent.mm.vending.e.a a(long paramLong, String paramString, a parama);
  
  public abstract String a(ca paramca, g paramg);
  
  public abstract void a(c paramc);
  
  public abstract void a(ca paramca, a parama);
  
  public abstract boolean a(ca paramca, c paramc);
  
  public abstract boolean a(String paramString, ca paramca, b paramb);
  
  public abstract boolean j(ca paramca);
  
  public abstract g k(ca paramca);
  
  public abstract String l(ca paramca);
  
  public abstract boolean m(ca paramca);
  
  public abstract c s(String paramString, long paramLong);
  
  public static abstract interface a
  {
    public abstract void cs(int paramInt1, int paramInt2);
    
    public abstract void t(int paramInt, String paramString);
  }
  
  public static abstract interface b
  {
    public abstract void u(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.choosemsgfile.compat.b
 * JD-Core Version:    0.7.0.1
 */