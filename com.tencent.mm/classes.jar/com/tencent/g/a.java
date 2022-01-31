package com.tencent.g;

import java.util.HashMap;

public final class a
  implements com.tencent.g.b.a
{
  private boolean aeo = true;
  private g xbW;
  
  protected a(g paramg)
  {
    this.xbW = paramg;
  }
  
  public final void p(String paramString, Object paramObject)
  {
    if (!this.aeo) {
      return;
    }
    f localf = f.cRg();
    if (paramObject == null) {
      throw new h("TpfServiceCenter|registerService|name or service should not be null");
    }
    synchronized (localf.xcc)
    {
      localf.xca.put(paramString, paramObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.g.a
 * JD-Core Version:    0.7.0.1
 */