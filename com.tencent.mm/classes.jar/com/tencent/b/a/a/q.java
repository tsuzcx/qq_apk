package com.tencent.b.a.a;

import android.content.Context;

public abstract class q
{
  protected Context context = null;
  
  protected q(Context paramContext)
  {
    this.context = paramContext;
  }
  
  protected abstract boolean TW();
  
  protected abstract a TX();
  
  public final g Ud()
  {
    g localg = null;
    if (TW()) {}
    for (String str = s.decode(read());; str = null)
    {
      if (str != null) {
        localg = g.eX(str);
      }
      return localg;
    }
  }
  
  public final a Ue()
  {
    if (TW()) {
      return TX();
    }
    return null;
  }
  
  protected abstract void a(a parama);
  
  public final void b(a parama)
  {
    if (parama == null) {}
    while (!TW()) {
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
    } while (!TW());
    write(s.encode(paramg));
  }
  
  protected abstract String read();
  
  protected abstract void write(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.b.a.a.q
 * JD-Core Version:    0.7.0.1
 */