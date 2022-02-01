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
    AppMethodBeat.i(158413);
    AppMethodBeat.o(158413);
  }
  
  public a(d paramd)
  {
    super(paramd);
  }
  
  public final void a(final a<_Callback> parama)
  {
    AppMethodBeat.i(158414);
    Iterator localIterator = fSr().iterator();
    while (localIterator.hasNext())
    {
      final b localb = (b)localIterator.next();
      if (localb != null) {
        if (localb.cUP != null)
        {
          this.LEl.c(localb.cUP);
          this.LEl.a(new com.tencent.mm.vending.c.a() {}, com.tencent.mm.vending.c.a.LEs, true);
        }
        else
        {
          parama.bn(localb.LEn);
        }
      }
    }
    AppMethodBeat.o(158414);
  }
  
  public b<_Callback> bu(_Callback param_Callback)
  {
    AppMethodBeat.i(158415);
    param_Callback = super.a(new b(param_Callback, this));
    AppMethodBeat.o(158415);
    return param_Callback;
  }
  
  public final void remove(_Callback param_Callback)
  {
    AppMethodBeat.i(158416);
    super.b(new b(param_Callback, this));
    AppMethodBeat.o(158416);
  }
  
  public static abstract interface a<_Callback>
  {
    public abstract void bn(_Callback param_Callback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cm.a
 * JD-Core Version:    0.7.0.1
 */