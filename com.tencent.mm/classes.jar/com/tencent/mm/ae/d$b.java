package com.tencent.mm.ae;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.g.a.a;
import kotlin.g.b.aa.d;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<no name provided>", "T", "invoke", "()Ljava/lang/Object;"})
public final class d$b
  extends q
  implements a<T>
{
  public d$b(aa.d paramd, List paramList)
  {
    super(0);
  }
  
  public final T invoke()
  {
    AppMethodBeat.i(153446);
    if ((this.khh.aaBA < 0) || (this.khh.aaBA >= this.khi.size()))
    {
      AppMethodBeat.o(153446);
      return null;
    }
    Object localObject = this.khi;
    aa.d locald = this.khh;
    int i = locald.aaBA;
    locald.aaBA = (i + 1);
    localObject = ((List)localObject).get(i);
    AppMethodBeat.o(153446);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ae.d.b
 * JD-Core Version:    0.7.0.1
 */