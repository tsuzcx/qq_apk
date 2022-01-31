package com.tencent.mm.plugin.fav.b.e;

import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class d$3
  implements am.a
{
  d$3(d paramd) {}
  
  public final boolean tC()
  {
    try
    {
      d.d(this.kaP);
      return false;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.Fav.FavModService", localException, "", new Object[0]);
    }
    return false;
  }
  
  public final String toString()
  {
    return super.toString() + "|scenePusher";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.e.d.3
 * JD-Core Version:    0.7.0.1
 */