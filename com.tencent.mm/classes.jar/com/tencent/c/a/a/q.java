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
    while (!zL()) {
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
    } while (!zL());
    write(s.encode(paramg));
  }
  
  protected abstract String read();
  
  protected abstract void write(String paramString);
  
  protected abstract boolean zL();
  
  protected abstract a zM();
  
  public final g zS()
  {
    g localg = null;
    if (zL()) {}
    for (String str = s.decode(read());; str = null)
    {
      if (str != null) {
        localg = g.cH(str);
      }
      return localg;
    }
  }
  
  public final a zT()
  {
    if (zL()) {
      return zM();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.c.a.a.q
 * JD-Core Version:    0.7.0.1
 */