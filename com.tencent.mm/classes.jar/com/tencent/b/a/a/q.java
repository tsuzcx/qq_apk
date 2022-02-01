package com.tencent.b.a.a;

import android.content.Context;

public abstract class q
{
  protected Context context = null;
  
  protected q(Context paramContext)
  {
    this.context = paramContext;
  }
  
  protected abstract boolean JB();
  
  protected abstract a JC();
  
  public final g JI()
  {
    g localg = null;
    if (JB()) {}
    for (String str = s.decode(read());; str = null)
    {
      if (str != null) {
        localg = g.ej(str);
      }
      return localg;
    }
  }
  
  public final a JJ()
  {
    if (JB()) {
      return JC();
    }
    return null;
  }
  
  protected abstract void a(a parama);
  
  public final void b(a parama)
  {
    if (parama == null) {}
    while (!JB()) {
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
    } while (!JB());
    write(s.encode(paramg));
  }
  
  protected abstract String read();
  
  protected abstract void write(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.b.a.a.q
 * JD-Core Version:    0.7.0.1
 */