package com.tencent.mm.ck;

import com.tencent.mm.vending.b.b;
import com.tencent.mm.vending.h.d;
import com.tencent.mm.vending.h.f;
import java.util.Iterator;
import java.util.LinkedList;

public class a<_Callback>
  extends com.tencent.mm.vending.b.a<_Callback>
{
  public a()
  {
    super(new e());
  }
  
  public a(d paramd)
  {
    super(paramd);
  }
  
  public final void a(final a<_Callback> parama)
  {
    Iterator localIterator = cKT().iterator();
    while (localIterator.hasNext())
    {
      final b localb = (b)localIterator.next();
      if (localb != null) {
        if (localb.wtp != null)
        {
          this.wtn.b(localb.wtp);
          this.wtn.a(new com.tencent.mm.vending.c.a() {}, com.tencent.mm.vending.c.a.wtt, true);
        }
        else
        {
          parama.ae(localb.d);
        }
      }
    }
  }
  
  public b<_Callback> aj(_Callback param_Callback)
  {
    return super.a(new b(param_Callback, this));
  }
  
  public final void remove(_Callback param_Callback)
  {
    super.b(new b(param_Callback, this));
  }
  
  public static abstract interface a<_Callback>
  {
    public abstract void ae(_Callback param_Callback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ck.a
 * JD-Core Version:    0.7.0.1
 */