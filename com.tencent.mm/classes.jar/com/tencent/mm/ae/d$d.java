package com.tencent.mm.ae;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.ah.d;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"<no name provided>", "T"}, k=3, mv={1, 5, 1}, xi=48)
public final class d$d
  extends u
  implements a<T>
{
  public d$d(ah.d paramd, List<? extends T> paramList)
  {
    super(0);
  }
  
  public final T invoke()
  {
    AppMethodBeat.i(153446);
    if ((this.mHD.aixb < 0) || (this.mHD.aixb >= this.mHE.size()))
    {
      AppMethodBeat.o(153446);
      return null;
    }
    Object localObject = this.mHE;
    int i = this.mHD.aixb;
    this.mHD.aixb = (i + 1);
    localObject = ((List)localObject).get(i);
    AppMethodBeat.o(153446);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ae.d.d
 * JD-Core Version:    0.7.0.1
 */