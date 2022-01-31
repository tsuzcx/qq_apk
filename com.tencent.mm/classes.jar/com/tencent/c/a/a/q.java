package com.tencent.c.a.a;

import android.content.Context;

public abstract class q
{
  protected Context context = null;
  
  protected q(Context paramContext)
  {
    this.context = paramContext;
  }
  
  protected abstract void a(a parama);
  
  public final void b(a parama)
  {
    if (parama == null) {}
    while (!rv()) {
      return;
    }
    a(parama);
  }
  
  public final void b(g paramg)
  {
    if (paramg == null) {}
    do
    {
      return;
      paramg = paramg.toString();
    } while (!rv());
    write(s.encode(paramg));
  }
  
  public final g rD()
  {
    g localg = null;
    if (rv()) {}
    for (String str = s.decode(read());; str = null)
    {
      if (str != null) {
        localg = g.bE(str);
      }
      return localg;
    }
  }
  
  public final a rE()
  {
    if (rv()) {
      return rw();
    }
    return null;
  }
  
  protected abstract String read();
  
  protected abstract boolean rv();
  
  protected abstract a rw();
  
  protected abstract void write(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.c.a.a.q
 * JD-Core Version:    0.7.0.1
 */