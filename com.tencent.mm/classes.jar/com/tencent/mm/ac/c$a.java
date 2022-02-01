package com.tencent.mm.ac;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.b.v.d;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<no name provided>", "T", "invoke", "()Ljava/lang/Object;"})
public final class c$a
  extends d.g.b.l
  implements a<T>
{
  public c$a(v.d paramd, List paramList)
  {
    super(0);
  }
  
  public final T invoke()
  {
    AppMethodBeat.i(153446);
    if ((this.gmc.KUO < 0) || (this.gmc.KUO >= this.gmd.size()))
    {
      AppMethodBeat.o(153446);
      return null;
    }
    Object localObject = this.gmd;
    v.d locald = this.gmc;
    int i = locald.KUO;
    locald.KUO = (i + 1);
    localObject = ((List)localObject).get(i);
    AppMethodBeat.o(153446);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ac.c.a
 * JD-Core Version:    0.7.0.1
 */