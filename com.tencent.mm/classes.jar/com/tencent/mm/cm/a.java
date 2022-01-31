package com.tencent.mm.cm;

import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(123360);
    AppMethodBeat.o(123360);
  }
  
  public a(d paramd)
  {
    super(paramd);
  }
  
  public final void a(final a<_Callback> parama)
  {
    AppMethodBeat.i(123361);
    Iterator localIterator = dQj().iterator();
    while (localIterator.hasNext())
    {
      final b localb = (b)localIterator.next();
      if (localb != null) {
        if (localb.AOk != null)
        {
          this.AOi.c(localb.AOk);
          this.AOi.a(new com.tencent.mm.vending.c.a() {}, com.tencent.mm.vending.c.a.AOo, true);
        }
        else
        {
          parama.am(localb.d);
        }
      }
    }
    AppMethodBeat.o(123361);
  }
  
  public b<_Callback> at(_Callback param_Callback)
  {
    AppMethodBeat.i(123362);
    param_Callback = super.a(new b(param_Callback, this));
    AppMethodBeat.o(123362);
    return param_Callback;
  }
  
  public final void remove(_Callback param_Callback)
  {
    AppMethodBeat.i(123363);
    super.b(new b(param_Callback, this));
    AppMethodBeat.o(123363);
  }
  
  public static abstract interface a<_Callback>
  {
    public abstract void am(_Callback param_Callback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cm.a
 * JD-Core Version:    0.7.0.1
 */