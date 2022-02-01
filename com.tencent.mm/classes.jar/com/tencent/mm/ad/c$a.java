package com.tencent.mm.ad;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.b.v.c;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<no name provided>", "T", "invoke", "()Ljava/lang/Object;"})
public final class c$a
  extends d.g.b.l
  implements a<T>
{
  public c$a(v.c paramc, List paramList)
  {
    super(0);
  }
  
  public final T invoke()
  {
    AppMethodBeat.i(153446);
    if ((this.ghw.Jhu < 0) || (this.ghw.Jhu >= this.$list.size()))
    {
      AppMethodBeat.o(153446);
      return null;
    }
    Object localObject = this.$list;
    v.c localc = this.ghw;
    int i = localc.Jhu;
    localc.Jhu = (i + 1);
    localObject = ((List)localObject).get(i);
    AppMethodBeat.o(153446);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ad.c.a
 * JD-Core Version:    0.7.0.1
 */