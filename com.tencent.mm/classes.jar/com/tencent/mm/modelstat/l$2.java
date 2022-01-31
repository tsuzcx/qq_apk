package com.tencent.mm.modelstat;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.ad;

final class l$2
  implements Runnable
{
  l$2(l paraml, int paramInt, String paramString) {}
  
  public final void run()
  {
    switch (this.eEh)
    {
    default: 
      return;
    case 1: 
      ad.a(g.DP().dKt + this.eEi, q.Gj(), false, true);
      return;
    case 2: 
      ad.a(g.DP().cachePath + this.eEi, q.Gj(), false, true);
      return;
    }
    ad.a(this.eEi, q.Gj(), false, true);
  }
  
  public final String toString()
  {
    return super.toString() + "|onPreAddMessage";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelstat.l.2
 * JD-Core Version:    0.7.0.1
 */