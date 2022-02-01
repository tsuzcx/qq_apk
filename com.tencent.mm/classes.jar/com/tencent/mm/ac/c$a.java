package com.tencent.mm.ac;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.b.q;
import d.g.b.y.d;
import d.l;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<no name provided>", "T", "invoke", "()Ljava/lang/Object;"})
public final class c$a
  extends q
  implements a<T>
{
  public c$a(y.d paramd, List paramList)
  {
    super(0);
  }
  
  public final T invoke()
  {
    AppMethodBeat.i(153446);
    if ((this.gIs.NiW < 0) || (this.gIs.NiW >= this.gIt.size()))
    {
      AppMethodBeat.o(153446);
      return null;
    }
    Object localObject = this.gIt;
    y.d locald = this.gIs;
    int i = locald.NiW;
    locald.NiW = (i + 1);
    localObject = ((List)localObject).get(i);
    AppMethodBeat.o(153446);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ac.c.a
 * JD-Core Version:    0.7.0.1
 */