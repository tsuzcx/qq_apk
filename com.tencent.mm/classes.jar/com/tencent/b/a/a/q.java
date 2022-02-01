package com.tencent.b.a.a;

import android.content.Context;

public abstract class q
{
  protected Context context = null;
  
  protected q(Context paramContext)
  {
    this.context = paramContext;
  }
  
  protected abstract boolean JJ();
  
  protected abstract a JK();
  
  public final g JQ()
  {
    g localg = null;
    if (JJ()) {}
    for (String str = s.decode(read());; str = null)
    {
      if (str != null) {
        localg = g.eo(str);
      }
      return localg;
    }
  }
  
  public final a JR()
  {
    if (JJ()) {
      return JK();
    }
    return null;
  }
  
  protected abstract void a(a parama);
  
  public final void b(a parama)
  {
    if (parama == null) {}
    while (!JJ()) {
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
    } while (!JJ());
    write(s.encode(paramg));
  }
  
  protected abstract String read();
  
  protected abstract void write(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.b.a.a.q
 * JD-Core Version:    0.7.0.1
 */