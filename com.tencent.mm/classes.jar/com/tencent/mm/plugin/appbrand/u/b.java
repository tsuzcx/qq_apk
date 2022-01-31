package com.tencent.mm.plugin.appbrand.u;

import com.tencent.mm.plugin.appbrand.u.d.d.a;
import com.tencent.mm.plugin.appbrand.u.e.i;

public abstract class b
  implements d
{
  protected boolean iYH;
  
  public final void a(a parama, com.tencent.mm.plugin.appbrand.u.d.d paramd)
  {
    paramd = new com.tencent.mm.plugin.appbrand.u.d.e(paramd);
    paramd.a(d.a.iZJ);
    parama.b(paramd);
  }
  
  public final i aOc()
  {
    return new com.tencent.mm.plugin.appbrand.u.e.e();
  }
  
  public void b(com.tencent.mm.plugin.appbrand.u.e.a parama) {}
  
  public void c(com.tencent.mm.plugin.appbrand.u.d.d paramd) {}
  
  public final void setTcpNoDelay(boolean paramBoolean)
  {
    this.iYH = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.b
 * JD-Core Version:    0.7.0.1
 */