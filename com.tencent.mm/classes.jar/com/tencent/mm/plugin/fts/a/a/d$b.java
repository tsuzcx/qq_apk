package com.tencent.mm.plugin.fts.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

public final class d$b
  implements Comparable<b>
{
  public g.c mSl;
  public int mSm = -1;
  public int mSn = -1;
  
  public final String bBW()
  {
    AppMethodBeat.i(114241);
    if ((this.mSl != null) && (this.mSl.mSE.size() > 0))
    {
      Object localObject = this.mSl.mSE.iterator();
      while (((Iterator)localObject).hasNext())
      {
        g.b localb = (g.b)((Iterator)localObject).next();
        if (localb.mSC == g.d.mSH)
        {
          localObject = localb.content;
          AppMethodBeat.o(114241);
          return localObject;
        }
      }
    }
    AppMethodBeat.o(114241);
    return null;
  }
  
  public final boolean isAvailable()
  {
    return (this.mSm != -1) && (this.mSn != -1);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(114242);
    if (this.mSl == null) {}
    for (String str = "";; str = this.mSl.bBZ().replaceAll("​", ","))
    {
      str = String.format("FTSQueryHLRequest.Item %s %d %d", new Object[] { str, Integer.valueOf(this.mSm), Integer.valueOf(this.mSn) });
      AppMethodBeat.o(114242);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a.d.b
 * JD-Core Version:    0.7.0.1
 */