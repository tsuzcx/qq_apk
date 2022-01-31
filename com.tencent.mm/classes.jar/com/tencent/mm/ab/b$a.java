package com.tencent.mm.ab;

import a.f.a.a;
import a.f.b.k;
import a.f.b.u.c;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<no name provided>", "T", "invoke", "()Ljava/lang/Object;"})
public final class b$a
  extends k
  implements a<T>
{
  public b$a(u.c paramc, List paramList)
  {
    super(0);
  }
  
  public final T invoke()
  {
    AppMethodBeat.i(155610);
    if ((this.eMq.BNp < 0) || (this.eMq.BNp >= this.eMr.size()))
    {
      AppMethodBeat.o(155610);
      return null;
    }
    Object localObject = this.eMr;
    u.c localc = this.eMq;
    int i = localc.BNp;
    localc.BNp = (i + 1);
    localObject = ((List)localObject).get(i);
    AppMethodBeat.o(155610);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ab.b.a
 * JD-Core Version:    0.7.0.1
 */