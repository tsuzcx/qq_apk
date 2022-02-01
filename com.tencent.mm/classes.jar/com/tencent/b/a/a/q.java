package com.tencent.b.a.a;

import android.content.Context;

public abstract class q
{
  protected Context context = null;
  
  protected q(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final a IA()
  {
    if (Is()) {
      return It();
    }
    return null;
  }
  
  protected abstract boolean Is();
  
  protected abstract a It();
  
  public final g Iz()
  {
    g localg = null;
    if (Is()) {}
    for (String str = s.decode(read());; str = null)
    {
      if (str != null) {
        localg = g.dy(str);
      }
      return localg;
    }
  }
  
  protected abstract void a(a parama);
  
  public final void b(a parama)
  {
    if (parama == null) {}
    while (!Is()) {
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
    } while (!Is());
    write(s.encode(paramg));
  }
  
  protected abstract String read();
  
  protected abstract void write(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.b.a.a.q
 * JD-Core Version:    0.7.0.1
 */